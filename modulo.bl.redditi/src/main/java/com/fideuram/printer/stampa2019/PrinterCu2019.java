package com.fideuram.printer.stampa2019;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PrinterCu2019  extends Cud 
{
    protected Cud2019 cud;
    protected PdfReader reader;
    protected PdfStamper stamper;

    public PrinterCu2019(Cud2019 cud) throws IOException, DocumentException {
        String fs= CrmProperties.getProperty("cud.output")+"2019" + File.separator;

        this.cud=cud;
        if(cud.isPrimaDichiarazione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120165"));
        else if(cud.isRettifica())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120166"));

        LoggingUtils.info("Mi preparo alla stampa di " + fs + cud.getPercettoreSomme().getCf() + ".pdf");

        stamper = new PdfStamper(reader, new FileOutputStream(fs+cud.getPercettoreSomme().getCf()+".pdf"));
    }
}