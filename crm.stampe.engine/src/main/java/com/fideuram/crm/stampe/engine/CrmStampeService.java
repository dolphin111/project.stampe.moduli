package com.fideuram.crm.stampe.engine;

import com.fideuram.crm.stampe.exception.*;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.FileManagerFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.stampe.dao.CrmDao;
import com.fideuram.stampe.domande.ControllerDiStampa;
import com.fideuram.stampe.domande.DomandaException;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.ContextLocale;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.TemplateUtils;
import com.fideuram.config.CrmProperties;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Giorgio Desideri
 *
 */
public class CrmStampeService {
    CrmDao crmDao;


    /**
	 * @param idComunicazione
	 */
    public void elaboraMessaggio(Integer idComunicazione) {

        LoggingUtils.info("COMUNICAZIONE IN ELABORAZIONE: " + idComunicazione);
        ContextLocale.setDefaultLocale();

        ComunicazioneVO comunicazione;
        List<File> outputFileList = new ArrayList<File>();

        // Flag di _debug
        String _debug = CrmProperties.getProperty(Costanti.CRM_STAMPE_TEST);


        // Lista delle domande
        List<DomandaVO> listaDomande = new ArrayList<DomandaVO>();

        try {
          
        	/*G.C.-20161227 Rigenerato il client tramite nuovo progetto client a partire 
        	 * dal WSDL di produzione JBOSS (http://fvwvcrm.fidevita.bancafideuram.it:8080/crm.web/CrmServiceWS?WSDL)
        	 */
        	
            crmDao =new CrmDao(idComunicazione);
            comunicazione= crmDao.getComunicazioneById(idComunicazione);
            LoggingUtils.info("COMUNICAZIONE TROVATA: "+comunicazione.getTipo().getCodice());

            // Sorting delle domande
            sortDomande(comunicazione, listaDomande);


            int count = 0;
            LoggingUtils.info("DOMANDE TROVATE: "+listaDomande.size());
            for (DomandaVO domanda : listaDomande) {
                byte[] odt;
                if(ControllerDiStampa.hasDomanda(domanda)){
                    //odt = new Controller().sviluppaDomanda(domanda, comunicazione.getBpmProcess()!=null?comunicazione.getBpmProcess().getPraticaID():0);
                    odt = new ControllerDiStampa().sviluppaDomanda(domanda, comunicazione);
                }else{
                    // tripletta domanda
                    String tripletta =
                            domanda.getDescrizioneDomanda().getVecchioliv1()
                                    + domanda.getDescrizioneDomanda().getVecchioliv2()
                                    + domanda.getDescrizioneDomanda().getVecchioliv3();

                    // Preparazione Scenario
                    String scenario = TemplateUtils.getScenario(listaDomande.size());

                    // Prepare input
                    InputDataModel input = new InputDataModel(comunicazione, domanda, scenario, tripletta);

                    // Creo il Modello della lettera
                    ModelDataGenerator creator = new ModelDataGenerator(input);
                    Modello modello = null;

                    modello = creator.createModelloLettera();

                    //AGGIUNTO PER ALLINEARE LA GESTIONE DEL FLAG OPZIONE (PROPOSTA SU FASE 1
                    modello.getLettera().setFlagOpzione(tripletta);




                    String xml = modello.toXml();

                    if ((count == 0) && (domanda.getDescrizioneDomanda().getTemplate().isNeedsLetteraAccompagnamento())) {
                        byte[] coverTemplate = null;
                        coverTemplate = crmDao.getTemplateAccompagnamento();
                        //todo coverTemplate = templateFinder.getLettera("LetteraAccompagnamento");

                        byte[] letteraAccompagnamento = DocumentFileWriter.mergeData(coverTemplate, xml, tripletta);

                        //salvo il file temporaneo
                        File temp = StreamerFactory.saveFile(letteraAccompagnamento, CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH), "COM_"+idComunicazione+"_"+domanda.getID()+"_"+domanda.getDescrizioneDomanda().getDescrizione().replace('/','-')+"accompagnamento"+".odt");
                        outputFileList.add(temp);
                    }

                    byte[] template=null;
                    if("true".equals(_debug)) {
                        //LoggingUtils.info(xml);
                    }
                    if(CrmProperties.getProperty("dev_template")!=null)
                        template = TemplateFinder.getTemplate(CrmProperties.getProperty("dev_template"));
                    else
                        template = domanda.getDescrizioneDomanda().getTemplate().getTemplate();

                    LoggingUtils.debug("TRIPLETTA :                     "+tripletta);
                    LoggingUtils.debug("TIPO COMUNICAZIONE :           "+comunicazione.getTipo().getCodice());
                    LoggingUtils.debug("TEMPLATE INTERCETTATO :         "+domanda.getDescrizioneDomanda().getTemplate().getID());

                    
//                    LoggingUtils.debug("XML :         "+xml);
                    // Merge dei dati
                    odt = DocumentFileWriter.mergeData(template, xml, tripletta);


                }

                //salvo il file temporaneo
                File temp = StreamerFactory.saveFile(odt, CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH),"COM_"+idComunicazione+"_DOM_"+domanda.getID()+"_"+ domanda.getDescrizioneDomanda().getDescrizione().replace('/','-')+".odt");
                LoggingUtils.debug("E' STATO GENERATO IL SEGUENTE DOCUMEMNTO >>>>>>>>>>>>:         "+ temp.getName() );
                outputFileList.add(temp);


                //  Inizializzo la risposta.
                //  In data 21/05/2014
                //  Abbiamo verificato con Bolognesi che  setContenuto(xml) non viene usato
                //  Per questo ho commentato quanto segue:
                //  RispostaVO rispostaDomanda = new RispostaVO();
                //  rispostaDomanda.setContenuto(xml);
                //  domanda.setRisposta(rispostaDomanda);

                // Incremento il counter
                count++;
            }

            byte[] documentoFinale = getDocumentoFinale(outputFileList);

            // Invio risposta definitiva
            if ("true".equals(_debug)) {
                LoggingUtils.debug("Documento prodotto " + documentoFinale.length + " bytes");
                StreamerFactory.saveFile(documentoFinale,CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH),"COMID_"+idComunicazione+".odt");
            } else{
                LoggingUtils.debug("CALLING SALVA RISPOSTA DEL CRM " + documentoFinale.length + " bytes");
                crmDao.salvaRisposta(idComunicazione, listaDomande, documentoFinale);
            }
        } catch (StampeInfoException e) {
            crmDao.salvaErrore(idComunicazione, e, "StampeInfoException\n ");
        } catch (WebServiceClientException e){
            crmDao.salvaErrore(idComunicazione, e, "WebServiceClientException\n ");
        } catch (CrmException e) {
            crmDao.salvaErrore(idComunicazione, e, "CrmException\n ");
        } catch (DomandaException e) {
            crmDao.salvaErrore(idComunicazione, e, "DomandaException\n ");
        } catch (DestinatariException e) {
            crmDao.salvaErrore(idComunicazione, e, "DestinatariException\n ");
        } catch (DocGeneratorException e) {
            crmDao.salvaErrore(idComunicazione, e, "DocGeneratorException\n ");
        } catch (Exception e) {
        	e.printStackTrace();
            crmDao.salvaErrore(idComunicazione, e, "");
        } catch (Throwable e) {
        	e.printStackTrace();
        	crmDao.salvaErrore(idComunicazione, e, "");
        } finally {
            if ((outputFileList!=null)&&(!("true".equals(_debug)))) {
                for (File f : outputFileList) {
                    f.delete();
                }
            }
            ClientWs.unloadClients(idComunicazione);
        }
        LoggingUtils.info("COMUNICAZIONE ELABORATA: " + idComunicazione);
    }



    private  byte[] getDocumentoFinale(List<File> outputFileList) throws DocGeneratorException {
         return FileManagerFactory.mergeOdtFiles(outputFileList);
    }

	/**
	 * @param comunicazione
	 * @param domande
	 */
	private void sortDomande(ComunicazioneVO comunicazione, List<DomandaVO> domande) throws StampeInfoException, CrmException {
		List<DomandaVO> domandeOrig = comunicazione.getDomande();
		if ((domandeOrig != null)&&(domandeOrig.size()>0)){
          	// Ordinamento secondo lettera accompagnamento
			for (DomandaVO d : domandeOrig) {
                //verifico se questa domanda è stata formalizzata tramite il nuovo BPM process "Bonita"
                if(ControllerDiStampa.hasDomanda(d)){
                    domande.add(d);
                    continue;
                } else {
                    // Salto quella con la lettera generica
                    if(d.getDescrizioneDomanda().getTemplate()==null){
                        throw new  StampeInfoException("Template non associato per la Domanda: " + d.getDescrizioneDomanda());
                    }
                	if(d.getDescrizioneDomanda().getTemplate().getID() == Costanti.ID_LETTERA_GENERICA){
                        continue;
                    }


                    if (!d.getDescrizioneDomanda().getTemplate().isNeedsLetteraAccompagnamento()) {
                        domande.add(0, d);
                    } else {
                        domande.add(d);
                    }
                }
			}
			// Non ho caricato nessuna domanda poiche' tutte generiche, ne aggiungo una sola.
			if(domande.isEmpty()) {
				domande.add(domandeOrig.get(0));
			}
		}else{
         String tipocomunicazione=   comunicazione.getTipo().getCodice();
        if (!(tipocomunicazione.equals("1")) &&
            !(tipocomunicazione.equals("2")) &&
            !(tipocomunicazione.equals("8")) &&
            !(tipocomunicazione.equals("9")) &&
            !(tipocomunicazione.equals("A"))) {
                //1 LETTERA GENERICA SENZA POLIZZA
                //2
                throw new  CrmException("Non ci sono domande per la comunicazione: " + comunicazione.getID());
            }
        }
	}

    public static void main(String args0[]){
  
    	new CrmStampeService().elaboraMessaggio(13476233);
    	

    }
}
