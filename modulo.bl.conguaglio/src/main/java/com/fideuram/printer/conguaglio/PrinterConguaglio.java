package com.fideuram.printer.conguaglio;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.conguaglio.*;
import com.fideuram.stampe.modello.corrispondenza.CorrispondenzaRendite;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.stampe.modello.rendita.Prestazione;
import com.fideuram.stampe.modello.rendita.Prestazioni;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 02/12/15
 * Time: 17.50
 * To change this template use File | Settings | File Templates.
 */
public class PrinterConguaglio {

    Prestazione prestazione;
    PdfReader reader;
    PdfStamper stamper;

    public PrinterConguaglio(Prestazione prest,String tipo) throws IOException, DocumentException {
        String fs= CrmProperties.getProperty("prestazione.output");
        String percorsoFinale=fs;
        this.prestazione=prest;
        //Credito
        if(tipo.equalsIgnoreCase("credito"))        {
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("1300"));

        }
        else
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("1301"));           //Debito


        stamper = new PdfStamper(reader, new FileOutputStream(fs + tipo + File.separator + prestazione.getCodiceFiscale().trim()+".pdf"));
        //PdfReader.unethicalreading = true;

    }



    public void generateConguaglio(String tipo) throws IOException, DocumentException {

        if(tipo.equalsIgnoreCase("credito"))
            new LetteraCredito().stampa(stamper,prestazione,1);
        else
            new LettereDebito().stampa(stamper,prestazione,1);

        stamper.close();
        reader.close();


    }



}

