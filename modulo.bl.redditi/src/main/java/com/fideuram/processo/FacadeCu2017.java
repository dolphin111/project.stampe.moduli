package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.stampa2017.sintetico.PrinterCu2017Sintetico;
import com.fideuram.prova.Cud2017Mock;
import com.fideuram.stampe.modello.redditi.d2017.Cud2017;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

/**
 * User: V801068
 * Date: 07/01/16
 * Time: 18.18
 */
public class FacadeCu2017 {
    public void generaCu2017(String datiInXml) throws Cu2015Exception {

        try {
            Cud2017 c = parseXml2Bean(datiInXml);

            new PrinterCu2017Sintetico(c).generateCud2017();
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (DocumentException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        }
    }
    private Cud2017 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
    	Cud2017 cud = new Cud2017();
        cud= (Cud2017) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2017Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2017().generaCu2017(xml);
        }
        LoggingUtils.info("FINE");
    }
}
