package com.fideuram.test;

import com.fideuram.file.io.writer.XmlWriter;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.rendita.Prestazione;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public class PrestazioneDebitoMock {


    public static String getXmlMock(Prestazione c) throws JAXBException, IOException {
        String xml=  Converter.objectToXml(c);
        return xml;
    }

    public static String getXmlMock() throws JAXBException, IOException {
        return getXmlMock(getMock());
    }

    public static Prestazione getMock(){
        Prestazione c=new Prestazione();
        c.setBeneficiario("Fierli Fausto");
        c.setIntestazione("Eg. Sig.re ");
        c.setNumeroPolizze("7332113");
        c.setNominativo("Fierli Fausto");
        c.setIndirizzo("Localita' vallont 19/E ");
        c.setCap("52044");
        c.setLocalita("Camucia Di Cortone");
        c.setProvincia(("AR"));
        c.setDataVersamento("");
        c.setCodiceIban("");
        c.setPagamentoIntestato("");
        c.setCodiceFiscale("PGHFHFJJFJFJFJJF");
        c.setImportoDiConguaglio("552,79");
        return c;
    }

       public static void main(String args[]) throws JAXBException, IOException {
        LoggingUtils.info(getXmlMock());
        Prestazione c=getMock();

        for(int i=0;i<1;i++){
            String _tmpcf=i+"";
            String xml=getXmlMock(c);
            XmlWriter.scriviStoXml(xml,c.getNumeroPolizze().trim()+ ".xml", "C:\\progetti\\stampe\\config\\prestazioni\\debito");


        }
    }
}
