package com.fideuram.processo;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;

import com.fideuram.prova.Cud2024Mock;
import com.fideuram.stampe.modello.redditi.d2024.Cud2024;
import com.fideuram.printer.stampa2024.sintetico.PrinterCu2024Sintetico;

import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;


public class FacadeCu2024 {
    /** Legge il file xml e stampa sul modello cud */
    public void generaCu2024(String datiInXml) throws Cu2015Exception {

        try {

//        	System.out.println("/********************* datiInXml *************************************/");
//        	System.out.println(datiInXml);
//        	System.out.println("/********************* datiInXml ***********************************/");

            Cud2024 c = parseXml2Bean(datiInXml);

            System.out.println(new Exception().getStackTrace()[0] + ": datiInXml = " + datiInXml);
            System.out.println(new Exception().getStackTrace()[0] + ": c.getPercettoreSomme().getResidenzaEstero().getCognome() = " + c.getPercettoreSomme().getCognome());
            System.out.println(new Exception().getStackTrace()[0] + ": c.getPercettoreSomme().getResidenzaEstero() = " + c.getPercettoreSomme().getResidenzaEstero());

            new PrinterCu2024Sintetico(c).generateCud2024();
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
    private Cud2024 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        Cud2024 cud = new Cud2024();
        cud= (Cud2024) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2024Mock.getXmlMock();
        System.out.println(xml);
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2024().generaCu2024(xml);
        }
        LoggingUtils.info("FINE");
    }
}
