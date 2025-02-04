package com.fideuram.printer.previdenza;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 16.22
 */
public class DistintaTest {

    public static void main(String args[]){
        new DistintaTest().test(1101);
    }


    public void test(int richiesta){
        try {
            String xml_buono= getXml(DistintaMock.getMock());
            String xml=DistintaMock.getXml();
            LoggingUtils.info(xml_buono);
            LoggingUtils.info(xml);
            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml, richiesta);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "Distinta.odt");
        } catch (Exception e) {
            LoggingUtils.error(e);
        }
    }

    public static String getXml(VersamentiPrevidenza b) throws JAXBException, IOException {
        return Converter.objectToXml(b);
    }

}
