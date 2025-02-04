package com.fideuram.preventivo.processo;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.preventivo.config.Templates;
import com.fideuram.preventivo.modello.Dichiarazione;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.modello.PreventivoStampabile;
import com.fideuram.preventivo.modello.Questionario;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by
 * User: logan
 * Date: 19/03/13
 * Time: 14.45
 */
public class PreventivoTcm {

    public Object getDocumento(Preventivo p, int richiesta)
            throws DocGeneratorException
    {
        LoggingUtils.debug("com.fideuram.crm.stampe.engine.processi.preventivi.LetteraPreventivi.getDocumento");
        HashMap map = new HashMap();
        try{
            PreventivoStampabile preventivoStampabile = new PreventivoStampabile();
            try {
                BeanUtils.copyProperties(preventivoStampabile, p);  //todo eliminare xkè inutile
            } catch (IllegalAccessException e) {
                LoggingUtils.error("LetteraPreventivi.getDocumento "+e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                LoggingUtils.error("LetteraPreventivi.getDocumento "+e.getMessage());
                e.printStackTrace();
            }

            preventivoStampabile = formatField(preventivoStampabile);
            if(preventivoStampabile.getNumeroPreventivo() == null){
                preventivoStampabile.setNumeroPreventivo("");
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
                    if(q.getIndice().intValue() == 14){
                        int caso = Integer.valueOf(q.getRisposta());
                        LoggingUtils.debug("LetteraPreventivi.getDocumento 13° indice caso: "+caso);
                        switch (caso){
                            case 0:
                                risposta.add("");
                                risposta.add("");
                                risposta.add("");
                                break;
                            case 1:
                                risposta.add("X");
                                risposta.add("");
                                risposta.add("");
                                break;
                            case 2:
                                risposta.add("");
                                risposta.add("X");
                                risposta.add("");
                                break;
                            case 3:
                                risposta.add("");
                                risposta.add("");
                                risposta.add("X");
                                break;
                        }
                    }else{
                        if(q.getRisposta().equals("S")){
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
                preventivoStampabile.setDichiarazione(dichiarazione);
            }
            if(preventivoStampabile.getBozza()){
                map.put("preventivo", preventivoStampabile);
                return generatoreOdt(map, Templates.TEMPLATE_BOZZE_TCM);
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

                return generatoreOdt(map, Templates.TEMPLATE_TCM);
            }
        }catch(DocGeneratorException e){
            throw new DocGeneratorException("Eccezione in stampa preventivi:--->"+e);
        }
    }

    private PreventivoStampabile formatField(PreventivoStampabile preventivoStampabile) {
        preventivoStampabile.getCapitale().setCapitaleAssicurato(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicurato())));
        preventivoStampabile.getCapitale().setCapitaleAssicuratoMorteInfortunio(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicuratoMorteInfortunio())));
        preventivoStampabile.getCapitale().setCapitaleAssicuratoMorteInfortunioStradale(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicuratoMorteInfortunioStradale())));
        preventivoStampabile.getPremi().setPremioAnnuoCostante(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioAnnuoCostante())));
        preventivoStampabile.getPremi().setPremioAnnuoCostanteGaranzieComplementari(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioAnnuoCostanteGaranzieComplementari())));
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
            return doc;
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
