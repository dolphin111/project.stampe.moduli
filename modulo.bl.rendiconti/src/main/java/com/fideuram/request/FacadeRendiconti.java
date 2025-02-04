package com.fideuram.request;


import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.ante.ProcessoAnte551Fao;
import com.fideuram.processo.rendiconti.ante.ProcessoAnte551Fulaa;
import com.fideuram.processo.rendiconti.ante.ProcessoAnte551Prtf;
import com.fideuram.processo.rendiconti.consob.ProcessoFap3Consob;
import com.fideuram.processo.rendiconti.custom.ProcessoFondoCustom;
import com.fideuram.processo.rendiconti.isvap.ProcessoFap3Isvap;
import com.fideuram.processo.rendiconti.isvap.ProcessoFaoIsvap;
import com.fideuram.processo.rendiconti.isvap.ProcessoFapIsvap;
import com.fideuram.processo.rendiconti.isvap.ProcessoPrtf2Isvap;
import com.fideuram.processo.rendiconti.isvap.ProcessoPrtfIsvap;
import com.fideuram.processo.rendiconti.fgp.ProcessoFgp;
import com.fideuram.stampe.modello.rendiconti.mock.personalizzato.BrasilMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fao;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.FondoInternoPersonalizzato;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Fap3Isvap;
import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.exception.RendicontiException;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fulaa;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Prtf;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.Fap3Consob;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.RtfConsob;
import com.fideuram.processo.rendiconti.consob.ProcessoPRTFConsob;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FaoIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Prtf2Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.PrtfIsvap;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created
 * User:v80102
 * Date: 10/01/14
 * Time: 15.13
 */
public class FacadeRendiconti {

    public static final String  ERROR_XML="Errore durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_NOTFOUND="Errore di ClassNotFoundException durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_INSTANCE="Errore di InstantiationException durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_ILLEGAL= "Errore di IllegalAccessException durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_TYPE="Richiesto un Rendiconto , ma non è stato specificato il Tipo.  OPPURE NON è UN TIPO CORRETTO.";

    public Object elaboraProcesso(int azione,String xml) throws RendicontiException{
        LoggingUtils.debug("FacadeRendiconti 1.0.0");
        LoggingUtils.debug("Azione richiesta: "+azione);
        Object obj=null;
        try{
            switch (azione){
                case 6001:      //ANTE - FAO
                    Fao rendicontoBean= (Fao) Converter.xml2Object(new Fao(), xml);
                    return new ProcessoAnte551Fao().stampa(rendicontoBean);
                case 6002:      //ANTE - FULAA
                    Fulaa rendicontoFulaa= (Fulaa) Converter.xml2Object(new Fulaa(), xml);
                    return new ProcessoAnte551Fulaa().stampa(rendicontoFulaa);
                case 6003:      //ANTE -PRTF
                    Prtf prtf= (Prtf) Converter.xml2Object(new Prtf(), xml);
                    return new ProcessoAnte551Prtf().stampa(prtf);
                case 6004:      //ISVAP - FAO
                    FaoIsvap faoIsvap= (FaoIsvap) Converter.xml2Object(new FaoIsvap(), xml);
                    return new ProcessoFaoIsvap().stampa(faoIsvap);
                case 6005:      //ISVAP - FAP
                    FapIsvap fapIsvap= (FapIsvap) Converter.xml2Object(new FapIsvap(), xml);
                    return new ProcessoFapIsvap().stampa(fapIsvap);
                case 6006:      //ISVAP - FAP3
                    Fap3Isvap fap3Isvap= (Fap3Isvap) Converter.xml2Object(new Fap3Isvap(), xml);
                    return new ProcessoFap3Isvap().stampa(fap3Isvap);
                case 6007:      //ISVAP - PRTF2
                    Prtf2Isvap prtf2Isvap= (Prtf2Isvap) Converter.xml2Object(new Prtf2Isvap(), xml);
                    return new ProcessoPrtf2Isvap().stampa(prtf2Isvap);
                    //  return new ProcessoPrtfIsvap();
                case 6008:      //ISVAP - PRTF
                    PrtfIsvap prtfIsvap= (PrtfIsvap) Converter.xml2Object(new PrtfIsvap(), xml);
                    return new ProcessoPrtfIsvap().stampa(prtfIsvap);
                    //  return new ProcessoPrtf2Isvap();
                case 6009:      //CONSOB- FAP3
                    Fap3Consob fap3Consob= (Fap3Consob) Converter.xml2Object(new Fap3Consob(), xml);
                    return new ProcessoFap3Consob().stampa(fap3Consob);
                case 6010:     //CONSOB -PRTF2
                    RtfConsob prtfConsob= (RtfConsob) Converter.xml2Object(new RtfConsob(), xml);
                    return new ProcessoPRTFConsob().stampa(prtfConsob);
                case 6011:     //FGP
                case 6012:     //FGP -Linepreo
                case 6013:     //FGP2-Plus
                case 6014:     //FGP2
                case 6015:     //FGP2-Equilibrio
                case 6017:     //FGP2-Lux
                case 6018:     //FGP2-Lux
                    Fgp fgp= (Fgp) Converter.xml2Object(new Fgp(), xml);
                    return new ProcessoFgp().stampa(fgp,azione);
                case 6016:     //RENDICONTO AI FONDI INTERNI (snav e grandi investimenti privati)
                    FondoInternoPersonalizzato fi= (FondoInternoPersonalizzato) Converter.xml2Object(new FondoInternoPersonalizzato(), xml);
                    LoggingUtils.info(fi.getNomeProdotto());
                    LoggingUtils.info(fi.getDivisa().getNome());
                    return new ProcessoFondoCustom().stampa(fi);
                default:
                    LoggingUtils.debug("ERRORE - Richiesto un Rendiconto, ma non è stato specificato il Tipo. Es: FAO, PRTF2=  "+azione);
                    throw new RendicontiException(ERROR_TYPE);
            }
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new RendicontiException(ERROR_XML +e.getMessage(),e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new RendicontiException(ERROR_NOTFOUND +e.getMessage(),e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new RendicontiException(ERROR_INSTANCE +e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new RendicontiException(ERROR_ILLEGAL + e.getMessage(),e);
        }
    }





    public static void main(String args[]) throws Exception {
        String cudInput= "C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Anomalie\\rendiconti\\input";
        ArrayList<String> result = new ArrayList<String>();
        File f = new File(cudInput);
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                result.add(files[i]);
            }
        }


        for (int i=0;i<result.size();i++){
            LoggingUtils.info(Charset.defaultCharset());

            String nomefile=result.get(i);
            String xml =FileUtils.readFileToString(new File("C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Anomalie\\rendiconti\\input\\"+nomefile));

            byte[] b= (byte[]) new FacadeRendiconti().elaboraProcesso(6016,xml);

            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "BO.odt");

        }
    }





}
