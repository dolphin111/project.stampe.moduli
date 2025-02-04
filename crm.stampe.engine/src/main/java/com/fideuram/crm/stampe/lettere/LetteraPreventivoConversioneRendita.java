package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Decumulo;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.puc.service.impl.DecumuloVO;
import com.fideuram.puc.service.impl.DettaglioCoefficienteRenditaFrazionataVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author v801112

 *
 * IMPORTANTE QUESTA LETTERA VIENE UTILIZZATA SOLO POLIZZE DI CAPITALE RAMO I
 * @deprecated
 */
public class LetteraPreventivoConversioneRendita extends LetteraEngine{

    public LetteraPreventivoConversioneRendita(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom) throws StampeInfoException, WebServiceClientException, PucException, DaoException {

		//------------ CASO VITA per diverso da vita Intera------------
		new TabellaValoreRiscattoTermine(comID).impostaTabellaValoreRiscatto(dest);


     		//-----------  CHIAMATA MOTORE UNIVERSO-------------------
		String polizza = dest.getNumero();
        String durataMinima = "";
		String premio = "";
        String sesso = "";
        String decumulo = "";
        String prodotto = "";
        String dataDecorrenza = "";
        String renditaAnnua = "";
        String dataNascita = "";
        List<ValoreInputVO> vi= dom.getValoriInput();
        
		for(int i=0; i<vi.size();i++){
			if(vi.get(i).getDatoInput().getId()==64){
				durataMinima=vi.get(i).getValore();
			}
			if(vi.get(i).getDatoInput().getId()==65){
				premio=vi.get(i).getValore();
			}
			if(vi.get(i).getDatoInput().getId()==62){
				sesso=vi.get(i).getValore();
			}
			if(vi.get(i).getDatoInput().getId()==67){
				decumulo=vi.get(i).getValore();
			}
			if(vi.get(i).getDatoInput().getId()==61){
				dataNascita=vi.get(i).getValore();
			}
			if(vi.get(i).getDatoInput().getId()==63){
				dataDecorrenza=vi.get(i).getValore();
			}
			if(vi.get(i).getDatoInput().getId()==66){
				renditaAnnua=vi.get(i).getValore();
			}
			
		}

		StampeServiceImpl pucws = ClientWsFactory.getInstance().getPucClient();
        try {

            DettaglioCoefficienteRenditaFrazionataVO d = pucws.getSimulatorePreventivoConversioneRendita(polizza, 
            		durataMinima, premio, sesso, decumulo, prodotto, dataDecorrenza, renditaAnnua);
            
            dest.setDataNascitaAssicurato(FormatterFactory.getStandardDate(DateUtils.getCrmDate(dataNascita)));
            dest.setDataDecorrenza(FormatterFactory.getStandardDate(DateUtils.getCrmDate(dataDecorrenza)));
            dest.setSesso(sesso);
            dest.setDurataMinima(durataMinima);
            Decumulo dec= dest.getDecumulo();
            if (dec==null){
            	dec= new Decumulo();
                dec.setControvaloreQuote(null);     //dec.setControvaloreQuote("");
                dec.setDataNav(null);               //dec.setDataNav("");
	            dec.setDescControvaloreQuote("");
	            dec.setDescImportoCedola("");
	            dec.setDescPercentuale("");
	            dec.setFrazionamento("");
                dec.setImportoCedola(null);          //dec.setImportoCedola("");
	            
            }
            dec.setPercentuale(Double.parseDouble(decumulo));   //dec.setPercentuale(decumulo);
            dest.setDecumulo(dec);
            
            if(Double.valueOf(renditaAnnua)>0)
            	dest.addAttributo("renditaAnnuale", FormatterFactory.getStandardImporto(Double.valueOf(renditaAnnua)));
            else
            	dest.addAttributo("renditaAnnuale","");
            
            if(Double.valueOf(premio)>0)
            	dest.setPremioAggiuntivo(FormatterFactory.getStandardImporto(Double.valueOf(premio)));
            else
            	dest.setPremioAggiuntivo("");
            
            dest.addAttributo("dataRiferimentoRiscatto", dest.getDataErogazioneRendita());
            dest.setDifferimento();
            setDescrizioneRiscatto(dest);                                                                                   //CARICO I TRONCONI

        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        } catch (ParseException e) {
            throw new StampeInfoException(e);
        }

    }


    /**
     * Logiche secondo Feature#64 di Redmine
     * compone il testo da stampare nel documento come spiegazione  dell'importo oggetto del ricatto
     * @param dest        la Polizza di destinazione dei dati
     */
    private static void setDescrizioneRiscatto(Polizza dest) throws ParseException {
        if(dest.getRamoMinisteriale().equalsIgnoreCase("3")){
            if((dest.getProdotto().trim().equalsIgnoreCase("PR001")||(dest.getProdotto().trim().equalsIgnoreCase("PR002")))){
                String descrizione=dest.getTroncone("ConversioneRenditaPR");
                if(dest.getProdotto().trim().equalsIgnoreCase("PR002"))
                      descrizione= descrizione+ dest.getTroncone("ConversioneRenditaPR002");
                dest.addAttributo("descrizioneRendita",descrizione);
            }else{
                if((dest.getProdotto().trim().equalsIgnoreCase("80"))){
                    dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaFIP80"));
                }else{
                	if(dest.getDifferimento().getDataFine().equals("")){
                		dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMaggiore20"));
                	}
                	else{
	                    if(dest.getDifferimento().isMaggioreAnni(10) && dest.getDifferimento().isMinoreAnni(20)){
	                        dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMaggiore10"));
	                    }
	                    if(dest.getDifferimento().isMaggioreAnni(20)){
	                        dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMaggiore20"));
	                    }
	                    if(dest.getDifferimento().isMinoreAnni(10)){
	                        dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMinore10"));
	                    }
                	}
                }
            }
           
           if(dest.getProdotto().trim().equalsIgnoreCase("RS0U1") || dest.getProdotto().trim().equalsIgnoreCase("RS0U2")
        		   || dest.getProdotto().trim().equalsIgnoreCase("RM0U1") || dest.getProdotto().trim().equalsIgnoreCase("RB0U1")
        		   || dest.getProdotto().trim().equalsIgnoreCase("RB0U2") || dest.getProdotto().trim().equalsIgnoreCase("RV0U1"))
           {
        	   dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaFVI"));
           }
           
        }else if(dest.getRamoMinisteriale().equalsIgnoreCase("1")){
            if((dest.getProdotto().trim().equalsIgnoreCase("53"))||(dest.getProdotto().trim().equalsIgnoreCase("54"))){
                dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaCerta"));
            }
            if(dest.getProdotto().trim().equalsIgnoreCase("RP") || dest.getProdotto().trim().equalsIgnoreCase("RG0T2")
            		|| dest.getProdotto().trim().equalsIgnoreCase("RG0T1")){
                dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaGV"));
            }
        }

    }



            /*

            ClientUniverso universoWs = ClientWsFactory.getInstance().getUniversoClient();
            WSConversioneinRenditaBean bean = universoWs.getConversioneInRendita(polizza, dataValutazione);

            if (bean != null) {
                dest.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());
            }



            if (bean != null) {
            // verificare se l'importo delle PrestazioniVita sono uguali a renditaIniziale restituito dal motore.
            dest.addAttributo("importoPrestazioniVita", bean.getRenditaIniziale());
            dest.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());
        }*/
    // Se VITA INTERA
		/*if ("VI".equals(dest.getCodiceGruppo())) {
		    dest.addAttributo("importoPrestazioniMorte", "");
	    	dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getDataFineDifferimento());
		    dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteCapitaleMaturato"));


			dest.addAttributo("dataRiferimentoRiscatto", dest.getDataErogazioneRendita());
			dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrConversionerenditaVitalizia"));

			if ("VIVA".equalsIgnoreCase(dest.getCodiceFondo().trim())) {
				dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
						+ dest.getTroncone("DescrConversione"));
			} else {
				dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
						+ dest.getTroncone("DescrConversione1999"));
			}
		} else {	//  Se Globale Vita
			dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataErogazioneRendita());
	        dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaLordaVitalizia"));


			dest.addAttributo("dataRiferimentoRiscatto", dest.getDataFineDifferimento());
			dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrValoreRiscattoLordoFD"));

			// DescrRichiesta 1mese o 3mesi o Tempestiva
			DescrizioniComuni.impostaDescrizioneRichiesta(dest);
		}*/


}
