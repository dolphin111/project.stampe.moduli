package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;

import com.fideuram.prova.Cud2025Mock;
import com.fideuram.stampe.modello.redditi.d2025.Cud2025;
import com.fideuram.printer.stampa2025.sintetico.PrinterCu2025Sintetico;

import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;


public class FacadeCu2025 {
    /** Legge il file xml e stampa sul modello cud */
    public void generaCu2025(String datiInXml) throws Cu2015Exception {

        try {

//        	System.out.println("/********************* datiInXml *************************************/");
//        	System.out.println(datiInXml);
//        	System.out.println("/********************* datiInXml ***********************************/");

            Cud2025 c = parseXml2Bean(datiInXml);

            System.out.println(new Exception().getStackTrace()[0] + ": datiInXml = " + datiInXml);
            System.out.println(new Exception().getStackTrace()[0] + ": c.getPercettoreSomme().getResidenzaEstero().getCognome() = " + c.getPercettoreSomme().getCognome());
            System.out.println(new Exception().getStackTrace()[0] + ": c.getPercettoreSomme().getResidenzaEstero() = " + c.getPercettoreSomme().getResidenzaEstero());

            new PrinterCu2025Sintetico(c).generateCud2025();
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
    private Cud2025 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        Cud2025 cud = new Cud2025();
        cud= (Cud2025) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2025Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2025().generaCu2025(xml);
        }
        LoggingUtils.info("FINE");
    }
}
