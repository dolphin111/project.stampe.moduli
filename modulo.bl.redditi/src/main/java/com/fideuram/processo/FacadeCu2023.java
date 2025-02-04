package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;

import com.fideuram.prova.Cud2023Mock;
import com.fideuram.stampe.modello.redditi.d2023.Cud2023;
import com.fideuram.printer.stampa2023.sintetico.PrinterCu2023Sintetico;

import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;


public class FacadeCu2023 {
    /** Legge il file xml e stampa sul modello cud */
    public void generaCu2023(String datiInXml) throws Cu2015Exception {

        try {

//        	System.out.println("/********************* datiInXml *************************************/");
//        	System.out.println(datiInXml);
//        	System.out.println("/********************* datiInXml ***********************************/");

            Cud2023 c = parseXml2Bean(datiInXml);

            System.out.println(new Exception().getStackTrace()[0] + ": datiInXml = " + datiInXml);
            System.out.println(new Exception().getStackTrace()[0] + ": c.getPercettoreSomme().getResidenzaEstero().getCognome() = " + c.getPercettoreSomme().getCognome());
            System.out.println(new Exception().getStackTrace()[0] + ": c.getPercettoreSomme().getResidenzaEstero() = " + c.getPercettoreSomme().getResidenzaEstero());

            new PrinterCu2023Sintetico(c).generateCud2023();
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
    private Cud2023 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        Cud2023 cud = new Cud2023();
        cud= (Cud2023) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2023Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2023().generaCu2023(xml);
        }
        LoggingUtils.info("FINE");
    }
}
