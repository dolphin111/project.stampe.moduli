package com.fideuram.printer.previdenza;

import com.fideuram.exception.GenericsException;
import com.fideuram.jaxb.Converter;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.previdenza.Previdenza;
import com.fideuram.stampe.modello.previdenza.versamenti.Bonifico;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 15.10
 */
public class BonificoTest {
    public static void main(String args[]){
        new BonificoTest().test(1100);
    }


    public void test(int richiesta){
        try {
            String xml= getXml(BonificoMock.getMock());
            LoggingUtils.info(xml);
            new ControllerActionsGenerics().elaboraProcesso(xml, richiesta);
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String getXml(VersamentiPrevidenza b) throws JAXBException, IOException {
        return Converter.objectToXml(b);
    }

}
