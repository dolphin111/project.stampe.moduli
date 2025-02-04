package com.fideuram.request.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.TempDir;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.FVInsieme;
import com.fideuram.processo.prospetti.GeneratoreBase;
import com.fideuram.puc.service.impl.ByteArray;
import com.fideuram.puc.service.impl.FvInsieme;
import com.fideuram.puc.service.impl.ProspettoServiceImpl;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.request.FacadeProspetti;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.Streamer;
import com.fideuram.utils.pdf.ImageAppender;
import com.fideuram.utils.pdf.ToPdf;
import com.itextpdf.text.DocumentException;

/**
 * Created by
 * User: logan
 * Date: 13/02/13
 * Time: 18.11
 */
public class ControllerOffertaBase {

    protected ProspettoServiceImpl pucProspettiManagerPortWS;
    protected String dir;


    /**
     * <br>Questo metodo svolge tutto il lavoro di generazione dei documenti pdf
     * <br>sulla base dei parametri forniti
     *
     * @param prospetto
     */
     protected PubblicazioneConsob loadDati(int prospetto) throws ProspettoDiOffertaException {
        try{
            LoggingUtils.debug("richiesto avvia processo "+prospetto);
            Object o                   = getValueFromPuc(makePucKey(prospetto),prospetto);              //chiedo i dati al puc
            LoggingUtils.debug("chiesto i dati al puc per il prospetto: "+prospetto );
            PubblicazioneConsob p      = getPCfromPuc(o,prospetto);                                      //travaso il tutto nei bean PubblicazioneConsob
            LoggingUtils.debug("travasato i bean PUC nella damigiana delle stampe");
            dir = TempDir.getTmpDir();
            return p;
        }catch (WebServiceClientException e){
            LoggingUtils.error("ProspettoDiOffertaException: " + e.getMessage());
            throw new ProspettoDiOffertaException(e.getMessage(),e);
        }catch (Exception e){
            LoggingUtils.error("ProspettoDiOffertaException: " , e);
            throw new ProspettoDiOffertaException(e.getMessage(),e);
        }finally {

        }

    }


    /**
     * todo deprecare
     * @param processo
     * @return
     */
    private String makePucKey(int processo){
        switch (processo){
            case 19:
            case 190:
                return "18PN";
            case 54:
            case 540:
                return "53PN";
            case 57:
            case 570:
                return "55PN";
            default:
                return processo+"";
        }
    }

    protected void sendPDFListToPuc(List<byte[]> pdfs, int prodotto) throws ProspettoDiOffertaException {
        String _debug = CrmProperties.getProperty(Costanti.CRM_STAMPE_TEST);
        if(!"true".equals(_debug)){
            pucProspettiManagerPortWS=null;
            try {
                pucProspettiManagerPortWS = ClientWsFactory.getInstance().getPucProspettoClient();
            } catch (WebServiceClientException e) {
                LoggingUtils.error("ProspettoDiOffertaException: " + e.getMessage());
                throw new ProspettoDiOffertaException(e.getMessage(),e);
            }
            List<ByteArray> byteArrays=new ArrayList<ByteArray>();

            for (int i=0; i<pdfs.size();i++){
                ByteArray byteArray = new ByteArray();
                byte[] bytes = pdfs.get(i);
                for(int y=0; y<bytes.length;y++){
                    byteArray.getItem().add(bytes[y]);
                }
                byteArrays.add(byteArray);
            }

            try {
                LoggingUtils.debug("PREPARO CHIAMATA A setFileByteArrayFromStampe");
                LoggingUtils.debug("PUC--" + pucProspettiManagerPortWS.toString());
                switch (prodotto){
                    /*case 18:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "18", "", "pdf");
                        break;*/
                    case 180:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "SUPPLEMENTO: 18", "", "pdf");
                        break;
                   /* case 51:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "51", "", "pdf");
                        break;*/
                    case 510:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "SUPPLEMENTO: 51", "", "pdf");
                        break;
                   /* case 53:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "53", "", "pdf");
                        break;*/
                    case 530:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "SUPPLEMENTO: 53", "", "pdf");
                        break;
                   /* case 55:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "55", "", "pdf");
                        break;*/
                    case 550:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "SUPPLEMENTO: 55", "", "pdf");
                        break;
                    /*case 56:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "56", "", "pdf");
                        break;*/
                    case 560:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, "SUPPLEMENTO: 56", "", "pdf");
                        break;
                    default:
                        pucProspettiManagerPortWS.setFileByteArrayFromStampe(byteArrays, makePucKey(prodotto), "", "pdf");
                        break;

                }
                LoggingUtils.debug("CHIAMATA A setFileByteArrayFromStampe ESEGUITA ");

            } catch (ServiceException_Exception e) {
                throw new  ProspettoDiOffertaException("Errore tentando di invocare:psetFileByteArrayFromStampe(...) ", e);
            }
        }else {
            LoggingUtils.debug("MODALITà DEBUG E QUINDI LA CHIAMATA A setFileByteArrayFromStampe NON VERRà ESEGUITA ESEGUITA ");
        }
    }


    protected PubblicazioneConsob getPCfromPuc(Object obj,int prospetto) throws ProspettoDiOffertaException {
        PubblicazioneConsob pc = new Puc2StampeBeanConverter().convert((FvInsieme)obj,prospetto);
        return pc;
    }

    protected byte[] stampaParteX(PubblicazioneConsob p, int partRichiesta, GeneratoreBase generatoreBase) throws ProspettoDiOffertaException {
        File odt = null;
        String filename = null;
        FVInsieme generatoreFVInsieme= new FVInsieme(dir);
        try{
            switch (partRichiesta){
                case 1:
                    odt = generatoreBase.generatePartI(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-PARTE-I.pdf";
                    break;
                case 2:
                    odt = generatoreBase.generatePartII(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-PARTE-II.pdf";
                    break;
                case 3:
                    odt = generatoreBase.generatePartIII(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-PARTE-III.pdf";
                    break;
                case 4:
                    odt = generatoreBase.generateSupplemento(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-SUPPLEMENTO.pdf";
                    break;
                case 5:
                    odt = generatoreBase.generateRendiconto(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-RENDICONTO.pdf";
                    break;
                case 6:
                    odt = generatoreBase.generateSchedaSintesi(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-SCHEDASINTETICA.pdf";
                    break;
                case 7:
                    odt = generatoreBase.generateNotaInformativa(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-NOTAINFORMATIVA.pdf";
                    break;
                case 8:
                    odt = generatoreBase.generateAddendum(p);
                    filename=generatoreBase.getClass().getSimpleName()+"-ADDENDUM.pdf";
                    break;
//                case 9:
//                    odt = generatoreBase.generateRendiconto(p);
//                    filename=generatoreBase.getClass().getSimpleName()+"-RENDICONTO.pdf";
//                    break;
            }
            byte[]   pdf     = ToPdf.getPdf(Streamer.getFile(odt.getAbsolutePath()));
            return   pdf;
        } catch (WebServiceClientException e) {
            throw new ProspettoDiOffertaException(generatoreBase.getClass().getSimpleName()+".parte"+ partRichiesta +": WebServiceClientException",e);
        } catch (IOException e) {
            throw new ProspettoDiOffertaException(generatoreBase.getClass().getSimpleName()+".parte"+ partRichiesta +": IOException",e);
        } catch (Exception e) {
            throw new ProspettoDiOffertaException(generatoreBase.getClass().getSimpleName()+".parte"+ partRichiesta +": Exception",e);
        }
    }



    protected Object getValueFromPuc(String key, int processo) throws WebServiceClientException {
        LoggingUtils.info("MI PREPARO A CREARE IL PROXY PUC PROSPETTO CLIENT");
        pucProspettiManagerPortWS = ClientWsFactory.getInstance().getPucProspettoClient();
        LoggingUtils.info("PROXY CREATO BBE.. MO CHIAMO LU PUC (KOKKITTU) ");
        try {
            switch (processo){
                /*case 18:        //Fv Insieme
                case 19:        //Fv Insieme Per Noi
                case 51:        //Fv Insieme Premium
                case 53:        //FVI private: codice RV0U1
                case 54:        //FVI private: PER NOI
                case 55:        //FVI Facile: (codice prodotto è RM)
                case 56:        //FVI Premium 4+4: (codice prodotto è RB)
                case 57:        //FVI Facile PER NOI
                    return pucProspettiManagerPortWS.getProspettoOfferta(key); */
                case 180:       //SUPPLEMENTO Fv Insieme
                case 510:       //SUPPLEMENTO Fv Insieme Premium
                case 530:       //SUPPLEMENTO FVI private: codice RV0U1
                case 550:       //SUPPLEMENTO FVI Facile: (codice prodotto è RM)
                case 560:       //SUPPLEMENTO FVI Premium 4+4: (codice prodotto è RB)
                case 590:		//Supplemento FVI PRIVATE MIX
                    return pucProspettiManagerPortWS.getSupplementoProspetto(key.substring(0,2));
                case 190:       //SUPPLEMENTO FvInsieme x Noi
                case 570:       //SUPPLEMENTO FvFacile  x noi	
                case 540: //SUPPLEMENTO FVPrivate  x noi
                    return pucProspettiManagerPortWS.getSupplementoProspetto(key.substring(0,2)+"PN");
                
                case 511:       //RENDICONTO Fv Insieme Premium
                case 531:       //RENDICONTO FVI private: codice RV0U1
                case 551:       //RENDICONTO FVI Facile: (codice prodotto è RM)
                case 561:       //RENDICONTO FVI Premium 4+4: (codice prodotto è RB)
//                    return pucProspettiManagerPortWS.getRendicontiFVCore(key.substring(0,2));
                	  return pucProspettiManagerPortWS.getRendicontiMultiRamo(key.substring(0,2));
                case 64:
                case 640:
                case 66:
                case 660:
                	return pucProspettiManagerPortWS.getNotaInformativa(key.substring(0, 2));
                case 641:
                case 661:
                case 181:       //RENDICONTO Fv Insieme
                	return pucProspettiManagerPortWS.getRendicontiMultiRamo(key.substring(0, 2));
                case 662:       //Addendum Sintonia
                case 642:       //Addendum Gemini
                	return pucProspettiManagerPortWS.getAddendumSintonia(key.substring(0, 2));
                		
                default:
                    return pucProspettiManagerPortWS.getProspettoOfferta(key);
            }

        } catch (Exception e){
            LoggingUtils.error("Errore invocando il puc-prospetti  ", e);
            throw new  WebServiceClientException("Errore invocando il puc-prospetti ", e);
        }

    }


    /**
     * Questo metodo aggiunge il piedino al pdf passato
     * Il metodo in questione utilizza Itext
     * @return
     */
    protected byte[] addPiedino(byte[] pdf, String destName, boolean isColor) throws ProspettoDiOffertaException {
        try {
            return ImageAppender.apppendPiedinoToLastPage(pdf, dir, destName, isColor);
        } catch (IOException e) {
            LoggingUtils.error(e.getMessage());
            throw new ProspettoDiOffertaException(e.getMessage(), e);
        } catch (DocumentException e) {
            LoggingUtils.error(e.getMessage());
            throw new ProspettoDiOffertaException(e.getMessage(),e);
        }
    }

    protected void clearTempDirectory(String dir){
        if(CrmProperties.getProperty("stampe.prospetti.clean.job").equalsIgnoreCase("true")){
            TempDir.clean(dir);
        }
    }

    public static void main(String args[]){
        try {
            new ControllerOffertaFviFacile().avviaProcessoSupplemento();
            new ControllerOffertaFVInsieme().avviaProcessoSupplemento();
            new ControllerOffertaFviPremium44().avviaProcessoSupplemento();
            new ControllerOffertaFviPrivate().avviaProcessoSupplemento();
        } catch (ProspettoDiOffertaException e) {
            e.printStackTrace();
        }
    }

}
