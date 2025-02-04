package com.fideuram.printer.previdenza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.previdenza.Previdenza;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by V801068 on 04/06/14.
 */
public class ModelloTest {
    public void test(int richiesta,String p){
        LoggingUtils.info(p);
        try {
            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(p, richiesta);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "mod_"+richiesta+"_previdenza.odt");

        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (Exception e) {
            LoggingUtils.error(e);
        }
    }


    public void test(int richiesta,Previdenza p){
        try {
            test(richiesta,getXmlPrevidenzaMock(p));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String getXmlPrevidenzaMock(Previdenza p) throws JAXBException, IOException {
        return Converter.objectToXml(p);
    }
}
