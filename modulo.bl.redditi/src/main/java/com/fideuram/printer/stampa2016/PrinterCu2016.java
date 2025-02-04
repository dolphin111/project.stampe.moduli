package com.fideuram.printer.stampa2016;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 02/03/16
 * Time: 19.15
 * To change this template use File | Settings | File Templates.
 */
public class PrinterCu2016  extends Cud {
    protected Cud2016 cud;
    protected PdfReader reader;
    protected PdfStamper stamper;

    public PrinterCu2016(Cud2016 cud) throws IOException, DocumentException {
        String fs= CrmProperties.getProperty("cud.output")+"2016"+File.separator;

        this.cud=cud;
        if(cud.isPrimaDichiarazione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120161"));
        else if(cud.isRettifica())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120162"));
        //else if(cud.isAnnulla())
        //reader = new PdfReader(TemplateFactory.getPathNomeTemplate("12023"));
        LoggingUtils.info("Mi preparto alla stampa di " + fs + cud.getPercettoreSomme().getCf() + ".pdf");

        //PdfReader.unethicalreading = true;
        stamper = new PdfStamper(reader, new FileOutputStream(fs+cud.getPercettoreSomme().getCf()+".pdf"));
    }
}
