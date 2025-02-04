package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;
//import com.fideuram.prova.Cud2018Mock;
//import com.fideuram.prova.Cud2019Mock;
//import com.fideuram.prova.Cud2021Mock;

//import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
//import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
//import com.fideuram.stampe.modello.redditi.d2020.Cud2020;
//import com.fideuram.stampe.modello.redditi.d2021.Cud2021;

//import com.fideuram.printer.stampa2018.*;
//import com.fideuram.printer.stampa2018.sintetico.PrinterCu2018Sintetico;
//import com.fideuram.printer.stampa2019.sintetico.PrinterCu2019Sintetico;
//import com.fideuram.printer.stampa2020.sintetico.PrinterCu2020Sintetico;
//import com.fideuram.printer.stampa2021.sintetico.PrinterCu2021Sintetico;


import com.fideuram.prova.Cud2022Mock;
import com.fideuram.stampe.modello.redditi.d2022.Cud2022;
import com.fideuram.printer.stampa2022.sintetico.PrinterCu2022Sintetico;

import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;


public class FacadeCu2022 {
	
    public void generaCu2022(String datiInXml) throws Cu2015Exception {

        try {
        	
//        	System.out.println("/********************* datiInXml *************************************/");
//        	System.out.println(datiInXml);
//        	System.out.println("/********************* datiInXml ***********************************/");
        	
            Cud2022 c = parseXml2Bean(datiInXml);

            new PrinterCu2022Sintetico(c).generateCud2022();
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
    private Cud2022 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
    	Cud2022 cud = new Cud2022();
        cud= (Cud2022) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2022Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2022().generaCu2022(xml);
        }
        LoggingUtils.info("FINE");
    }
}
