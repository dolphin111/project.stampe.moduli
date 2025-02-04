package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;
import com.fideuram.prova.Cud2018Mock;
import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
import com.fideuram.printer.stampa2018.*;
import com.fideuram.printer.stampa2018.sintetico.PrinterCu2018Sintetico;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;


public class FacadeCu2018 {
    public void generaCu2018(String datiInXml) throws Cu2015Exception {

        try {
            Cud2018 c = parseXml2Bean(datiInXml);

            new PrinterCu2018Sintetico(c).generateCud2018();
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
    private Cud2018 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
    	Cud2018 cud = new Cud2018();
        cud= (Cud2018) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2018Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2018().generaCu2018(xml);
        }
        LoggingUtils.info("FINE");
    }
}
