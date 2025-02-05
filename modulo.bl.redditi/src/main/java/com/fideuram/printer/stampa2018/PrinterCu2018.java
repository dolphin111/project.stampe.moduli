package com.fideuram.printer.stampa2018;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PrinterCu2018  extends Cud
{
    protected Cud2018 cud;
    protected PdfReader reader;
    protected PdfStamper stamper;

    public PrinterCu2018(Cud2018 cud) throws IOException, DocumentException {
        String fs= CrmProperties.getProperty("cud.output")+"2018"+File.separator;

        this.cud=cud;
        if(cud.isPrimaDichiarazione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120165"));
        else if(cud.isSostituzione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120166"));

        LoggingUtils.info("Mi preparto alla stampa di " + fs + cud.getPercettoreSomme().getCf() + ".pdf");

        stamper = new PdfStamper(reader, new FileOutputStream(fs+cud.getPercettoreSomme().getCf()+".pdf"));
    }
}