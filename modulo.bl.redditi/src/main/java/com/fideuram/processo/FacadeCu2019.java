package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;
//import com.fideuram.prova.Cud2018Mock;
import com.fideuram.prova.Cud2019Mock;
//import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
//import com.fideuram.printer.stampa2018.*;
//import com.fideuram.printer.stampa2018.sintetico.PrinterCu2018Sintetico;
import com.fideuram.printer.stampa2019.sintetico.PrinterCu2019Sintetico;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;


public class FacadeCu2019 {
    public void generaCu2019(String datiInXml) throws Cu2015Exception {

        try {
            Cud2019 c = parseXml2Bean(datiInXml);

            new PrinterCu2019Sintetico(c).generateCud2019();
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
    private Cud2019 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
    	Cud2019 cud = new Cud2019();
        cud= (Cud2019) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2019Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2019().generaCu2019(xml);
        }
        LoggingUtils.info("FINE");
    }
}
