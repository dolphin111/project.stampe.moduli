package com.fideuram.preventivo.processo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.file.manipolation.pdf.PdfMerge;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.preventivo.config.Templates;
import com.fideuram.preventivo.modello.Dichiarazione;
import com.fideuram.preventivo.modello.DichiarazioneDomandaRisposta;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.modello.PreventivoStampabile;
import com.fideuram.preventivo.modello.PreventivoStampabilePlus;
import com.fideuram.preventivo.modello.Questionario;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

/**
 * Created by
 * User: logan
 * Date: 19/03/13
 * Time: 14.45
 */
public class PreventivoTcmEvoluta {

    public Object getDocumento(Preventivo p, int richiesta)
            throws DocGeneratorException
    {
        LoggingUtils.debug("com.fideuram.crm.stampe.engine.processi.preventivi.LetteraPreventiviTCMevoluta.getDocumento");
        LoggingUtils.debug("*** GESTIONE CONSENSI: cmi="+p.getConsensoCMI()+", ccsg="+p.getConsensoCCSG()+", cdp="+p.getConsensoCDP()+", richiesta="+richiesta);
        HashMap map = new HashMap();
        try{
            PreventivoStampabilePlus preventivoStampabile = new PreventivoStampabilePlus();
            try {
                BeanUtils.copyProperties(preventivoStampabile, p);  //todo eliminare xkè inutile
            } catch (IllegalAccessException e) {
                LoggingUtils.error("LetteraPreventiviTCMevoluta.getDocumento "+e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                LoggingUtils.error("LetteraPreventiviTCMevoluta.getDocumento "+e.getMessage());
                e.printStackTrace();
            }
            Integer etaAssicurato = Integer.parseInt(preventivoStampabile.getAssicurato().getSegniParticolari().getEta());
            String durataContrattoSubstring = preventivoStampabile.getDurataContrattuale().replace(" anni", "");
            Integer durataContratto = Integer.parseInt(durataContrattoSubstring);
            
            
            	if(etaAssicurato+durataContratto>=65){
            		preventivoStampabile.setWarningComplementareInfortuni(true);
            	}
            	if(etaAssicurato+durataContratto>=70){
            		preventivoStampabile.setWarningComplementareMalattiaGrave(true);
            	}
            	preventivoStampabile.setWarning(preventivoStampabile.isWarningComplementareInfortuni()||preventivoStampabile.isWarningComplementareMalattiaGrave());
            
            preventivoStampabile = formatField(preventivoStampabile);
            if(preventivoStampabile.getNumeroPreventivo() == null){
                preventivoStampabile.setNumeroPreventivo("");
            }
          
            if(preventivoStampabile.getAssicurato().getCodiceFiscale().equalsIgnoreCase(preventivoStampabile.getContraente().getCodiceFiscale())){
            	preventivoStampabile.setContraAss(true);
            }
          
            
            String eta = preventivoStampabile.getAssicurato().getSegniParticolari().getEta();
            preventivoStampabile.getAssicurato().getSegniParticolari().setEta(eta+" anni");
            ArrayList<Questionario> listQuestionario = (ArrayList<Questionario>)preventivoStampabile.getQuestionario();
            /*if(listQuestionario != null && listQuestionario.size() > 0){
                Dichiarazione dichiarazione = new Dichiarazione();
                ArrayList<String> risposta = new ArrayList<String>();
                for(int i=0;i<listQuestionario.size();i++){
                    Questionario q = listQuestionario.get(i);
                    LoggingUtils.debug("LetteraPreventivi.getDocumento indice "+q.getIndice().intValue());
                    
                }
                dichiarazione.setRisposta(risposta);
                preventivoStampabile.setDichiarazione(dichiarazione);
            }*/
            
            if(listQuestionario != null && listQuestionario.size() > 0){
                DichiarazioneDomandaRisposta dichiarazione = new DichiarazioneDomandaRisposta();
                ArrayList<String> risposta = new ArrayList<String>();
                for(int i=0;i<listQuestionario.size();i++){
                    Questionario q = listQuestionario.get(i);
                    LoggingUtils.debug("LetteraPreventivi.getDocumento indice "+q.getIndice().intValue());
                    
                }
                dichiarazione.setDomanda(risposta);
                preventivoStampabile.setDichiarazione(dichiarazione);
            }
            
//            consensi privacy
            preventivoStampabile.setConsensoCCSG(p.getConsensoCCSG());
            preventivoStampabile.setConsensoCMI(p.getConsensoCMI());
            
            LoggingUtils.debug("*** GESTIONE CONSENSI: preventivo da stampare: cmi="+preventivoStampabile.getConsensoCMI()+", ccsg="+preventivoStampabile.getConsensoCCSG()+", cdp="+preventivoStampabile.getConsensoCDP()+", richiesta="+richiesta);
            if(preventivoStampabile.getBozza()){
            	if(richiesta==115){
            		map.put("preventivo", preventivoStampabile);
                    return generatoreOdt(map, Templates.TEMPLATE_BOZZE_TCMEV);
            	}
            	else if(richiesta==116){
            		map.put("preventivo", preventivoStampabile);
                    return generatoreOdt(map, Templates.TEMPLATE_BOZZE_TCMEV_QS);
            	}
            }else{
            	
            	String fraseFide = "COPIA PER FIDEURAM VITA S.p.A.";
                String fraseCli = "COPIA PER IL CLIENTE";
                preventivoStampabile.setCopiaPerFideuram(fraseFide);
                preventivoStampabile.setCopiaPerCliente(fraseCli);
                map.put("preventivo", preventivoStampabile);

                /*
                byte[] copiafid= generatoreOdt(map, Templates.TEMPLATE_TCM);
                byte[] copiacli= generatoreOdt(map, Templates.TEMPLATE_TCM);
                OdtMerge.mergeFileProdotti()
                */
            	
            	if(richiesta==114){
            		return generatoreOdt(map, Templates.TEMPLATE_TCMEV);
                }
            	else if(richiesta==117){
            		return generatoreOdt(map, Templates.TEMPLATE_TCMEV_QS);
            	}
                
            }
        }catch(DocGeneratorException e){
            throw new DocGeneratorException("Eccezione in stampa preventivi:--->"+e);
        }
		return map;
    }

    private PreventivoStampabilePlus formatField(PreventivoStampabilePlus preventivoStampabile) {
        preventivoStampabile.getCapitale().setCapitaleAssicurato(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicurato())));
        preventivoStampabile.getCapitale().setCapitaleAssicuratoMorteInfortunio(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicuratoMorteInfortunio())));
        preventivoStampabile.getCapitale().setCapitaleAssicuratoMorteInfortunioStradale(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicuratoMorteInfortunioStradale())));
        preventivoStampabile.getCapitale().setCapitaleAssicuratoMalattiaGrave(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicuratoMalattiaGrave())));
        
        preventivoStampabile.getPremi().setPremioAnnuoCostante(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioAnnuoCostante())));
        preventivoStampabile.getPremi().setPremioAnnuoCostanteGaranzieComplementari(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioAnnuoCostanteGaranzieComplementari())));
        preventivoStampabile.getPremi().setPremioAnnuoCostanteGaranzieComplementariMalattiaGrave(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioAnnuoCostanteGaranzieComplementariMalattiaGrave())));
        
        preventivoStampabile.getPremi().setSovrappremioSanitario(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getSovrappremioSanitario())));
        preventivoStampabile.getPremi().setSovrappremioSportivo(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getSovrappremioSportivo())));
        preventivoStampabile.getPremi().setPremioAnnuoCostanteComplessivo(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioAnnuoCostanteComplessivo())));
        preventivoStampabile.getPremi().setRataLorda(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getRataLorda())));
        return preventivoStampabile;
    }

    private double convertToDouble(String importo){
        double d = new BigDecimal(importo).doubleValue();
        return d;
    }

    private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
        byte templateData[] = new byte[0];
        try {
            templateData = TemplateFinder.getTemplate(template);
            LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
            byte doc[] =  new OdtWriter().mergeData(templateData, data);
            doc = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(doc);
            byte doc1[] = doc;
            //Una volta generato il doc, nel caso in cui il template è quello del questionario completo, allora chiamare classe
            if(template == Templates.TEMPLATE_BOZZE_TCMEV_QS||template == Templates.TEMPLATE_TCMEV_QS) {
            	 List<InputStream> list = new ArrayList<InputStream>();
                 try {
                 	// Documento generato
                 	InputStream input = new ByteArrayInputStream(doc1);
                     list.add(input);
                     
                     byte templateAllegatoData[] = TemplateFinder.getTemplate(Templates.TEMPLATE_TCMEV_QUESTIONARIOSANITARIO);
                     
                     // PDF Allegato statico
                     list.add(new ByteArrayInputStream(templateAllegatoData));
                     
                     // Resulting pdf
                     byte templateOutputData[] = new byte[0];
                     ByteArrayOutputStream out = new ByteArrayOutputStream();
                    		 //new FileOutputStream(new File("C:\\app\\CRMStampe\\temp\\preventivoQuestionario.pdf"));
                     PdfMerge.doMerge(list, out);
                    
                     out.close();
                    
                     return out.toByteArray();
                 } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 } catch (com.lowagie.text.DocumentException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
            } else {
            	return doc;
            }
            
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            templateLoaderExcepion.printStackTrace();
        } catch (ConverterException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (WebServiceClientException e) {
            throw new DocGeneratorException(e.getMessage());
        }
        return null;
    }

}
