package com.fideuram.preventivo.processo;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.preventivo.config.Templates;
import com.fideuram.preventivo.modello.Dichiarazione;
import com.fideuram.preventivo.modello.PremiFVI;
import com.fideuram.preventivo.modello.PremiFVIStr;
import com.fideuram.preventivo.modello.PreventivoFVO;
import com.fideuram.preventivo.modello.PreventivoStampabileFVO;
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
public class PreventivoTcmFVO {

    public Object getDocumento(PreventivoFVO p, int richiesta)
            throws DocGeneratorException
    {
        LoggingUtils.debug("com.fideuram.crm.stampe.engine.processi.preventivi.LetteraPreventiviTCMFVO.getDocumento");
        HashMap map = new HashMap();
        try{
            PreventivoStampabileFVO preventivoStampabile = new PreventivoStampabileFVO();
            try {
                BeanUtils.copyProperties(preventivoStampabile, p);  //todo eliminare xkè inutile
            } catch (IllegalAccessException e) {
                LoggingUtils.error("LetteraPreventiviTCMFVO.getDocumento "+e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                LoggingUtils.error("LetteraPreventiviTCMFVO.getDocumento "+e.getMessage());
                e.printStackTrace();
            }
            /*
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
            */
          
            if(preventivoStampabile.getAssicurato().getCodiceFiscale().equalsIgnoreCase(preventivoStampabile.getContraente().getCodiceFiscale())){
            	preventivoStampabile.setContraAss(true);
            }
          
            String eta = preventivoStampabile.getAssicurato().getSegniParticolari().getEta();
            preventivoStampabile.getAssicurato().getSegniParticolari().setEta(eta+" anni");
            ArrayList<Questionario> listQuestionario = (ArrayList<Questionario>)preventivoStampabile.getQuestionario();
            if(listQuestionario != null && listQuestionario.size() > 0){
                Dichiarazione dichiarazione = new Dichiarazione();
                ArrayList<String> risposta = new ArrayList<String>();
                for(int i=0;i<listQuestionario.size();i++){
                    Questionario q = listQuestionario.get(i);
                    LoggingUtils.debug("LetteraPreventivi.getDocumento indice "+q.getIndice().intValue());
                    if(q.getIndice().intValue() == 3011){
                    	if(q.getRisposta().equalsIgnoreCase("No")){
                    		risposta.add("");
                            risposta.add("X");
                            //3012
                            risposta.add("");
                            risposta.add("");
                            //3013
                            risposta.add("");
                            risposta.add("");
                    	}else{
                    		risposta.add("X");
                            risposta.add("");
                    	}
                    }else if(q.getIndice().intValue() == 3012){
                		if(q.getRisposta().equalsIgnoreCase("No")){
                			risposta.add("");
                            risposta.add("X");
                		}else{
                			risposta.add("X");
                            risposta.add("");
                            
                            risposta.add("");
                            risposta.add("");
                		}
                	}else if(q.getIndice().intValue() == 3013){
            			if(q.getRisposta().equalsIgnoreCase("No")){
            				risposta.add("");
                            risposta.add("X");
            			}else{
            				risposta.add("X");
                            risposta.add("");
            			}
            		}else if(q.getIndice().intValue() == 3014){
        				if(q.getRisposta().equalsIgnoreCase("No")){
            				risposta.add("");
                            risposta.add("X");
                            
                            risposta.add("");
                            risposta.add("");
                            
                            risposta.add("");
                            risposta.add("");
            			}else{
            				risposta.add("X");
                            risposta.add("");
            			}
        			}else if(q.getIndice().intValue() == 3017){
    					if(q.getRisposta().equalsIgnoreCase("No")){
    						risposta.add("");
                        	risposta.add("X");
                        	
                            risposta.add("");
                            risposta.add("");
                            risposta.add("");
                        }else{
                        	risposta.add("X");
                        	risposta.add("");
                        }
    				}else if(q.getIndice().intValue() == 3018){
                        LoggingUtils.debug("LetteraPreventivi.getDocumento 13° indice caso: "+q.getRisposta());
                        if(q.getRisposta().equalsIgnoreCase("No")){
                        	risposta.add("");
                            risposta.add("");
                            risposta.add("");
                        }else if(q.getRisposta().equalsIgnoreCase("uno")){
                        	risposta.add("X");
                            risposta.add("");
                            risposta.add("");
                        }else if(q.getRisposta().equalsIgnoreCase("due")){
                        	risposta.add("");
                            risposta.add("X");
                            risposta.add("");
                        }else if(q.getRisposta().equalsIgnoreCase("tre o più di tre")){
                        	risposta.add("");
                            risposta.add("");
                            risposta.add("X");
                        }
                       
                    }else{
                        if(q.getRisposta().equals("Si")){
                            risposta.add("X");
                            risposta.add("");
                        }else if(q.getRisposta().equals("0")){
                            risposta.add(" ");
                            risposta.add(" ");
                        }else{
                            risposta.add("");
                            risposta.add("X");
                        }
                    }
                }
                dichiarazione.setRisposta(risposta);
                
                //Conversione dei premi in stringa
                List<PremiFVI> listPremiFV =  preventivoStampabile.getPremiFV();
                List<PremiFVIStr> listPremiStr = new ArrayList<PremiFVIStr>();
                
                DecimalFormat df = new DecimalFormat("#.00");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                
                if(listPremiFV != null && listPremiFV.size() > 0){
                	PremiFVIStr premioStr = null;
                	for(int i = 0; i < listPremiFV.size(); i++){
                		premioStr = new PremiFVIStr();
                		premioStr.setPremioAnnuoCostanteComplessivo(df.format(listPremiFV.get(i).getPremioAnnuoCostanteComplessivo()));
                		premioStr.setEta(""+listPremiFV.get(i).getEta());
                		premioStr.setDataDiDecorrenza(formatter.format(listPremiFV.get(i).getDataDiDecorrenza()));
                		listPremiStr.add(premioStr);
                	}
                	preventivoStampabile.setPremiFVStr(listPremiStr);
                }
                
                preventivoStampabile.setDichiarazioneSemplice(dichiarazione);
            }
            
            if(preventivoStampabile.getBozza()){
            	map.put("preventivo", preventivoStampabile);
            	return generatoreOdt(map, Templates.TEMPLATE_BOZZE_TCM_FVO);
            }else{
            	
            	String fraseFide = "COPIA PER FIDEURAM VITA S.p.A.";
                String fraseCli = "COPIA PER IL CLIENTE";
                preventivoStampabile.setCopiaPerFideuram(fraseFide);
                preventivoStampabile.setCopiaPerCliente(fraseCli);
                map.put("preventivo", preventivoStampabile);

            	if(preventivoStampabile.getBozza()){
            		return generatoreOdt(map, Templates.TEMPLATE_BOZZE_TCM_FVO);
                }
            	else{
            		return generatoreOdt(map, Templates.TEMPLATE_TCM_FVO);
            	}
                
            }
        }catch(DocGeneratorException e){
            throw new DocGeneratorException("Eccezione in stampa preventivi:--->"+e);
        }
    }

    private PreventivoStampabilePlus formatField(PreventivoStampabilePlus preventivoStampabile) {
        preventivoStampabile.getCapitale().setCapitaleAssicurato(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicurato())));
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
            
//            try {
//				FileUtils.writeByteArrayToFile(new File("C:\\app\\preventiviFvInsiemeODT\\FVI\\temp\\"+template), doc);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
            
            doc = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(doc);
            return doc;
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            templateLoaderExcepion.printStackTrace();
        }
        catch (ConverterException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (WebServiceClientException e) {
            throw new DocGeneratorException(e.getMessage());
        }
        return null;
    }

}
