package com.fideuram.printer.stampa2015;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: V801068
 * Date: 21/11/14
 * Time: 12.06
 */
public class PrinterCu2015 extends Cud {
    Cud2015 cud;
    PdfReader reader;
    PdfStamper stamper;

    public PrinterCu2015(Cud2015 cud) throws IOException, DocumentException {
        String fs=CrmProperties.getProperty("cud.output")+"2015"+File.separator;

        this.cud=cud;
        if(cud.isPrimaDichiarazione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("12021"));
        else if(cud.isRettifica())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("12022"));
        //else if(cud.isAnnulla())
            //reader = new PdfReader(TemplateFactory.getPathNomeTemplate("12023"));
        LoggingUtils.info("Mi preparto alla stampa di "+fs+cud.getPercettoreSomme().getCf()+".pdf");

        //PdfReader.unethicalreading = true;
        stamper = new PdfStamper(reader, new FileOutputStream(fs+cud.getPercettoreSomme().getCf()+".pdf"));
    }

/*    public void annullaCud2015() throws IOException, DocumentException {
        new Lettera().stampa(stamper, cud,1);
        new Pag_RiepilogoCU().stampa(stamper, cud,2);
        new Pag_RiepilogoCU().stampa(stamper, cud,11);
        new Pag1().stampa(stamper, cud,4);
        new Pag1().stampa(stamper, cud,13);
        stamper.close();
        reader.close();
    }*/

    public void generateCud2015() throws IOException, DocumentException {
        //Font f1= FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

        new Lettera().stampa(stamper, cud,1);
        new Pag1().stampa(stamper, cud,2);
        new Pag2().stampa(stamper, cud,3);
        new Pag3().stampa(stamper, cud,4);
        new Pag4().stampa(stamper, cud,5);
        new Pag5().stampa(stamper, cud,6);
        new Pag6().stampa(stamper, cud,7);
        new Pag1().stampa(stamper, cud,8);
        new Pag2().stampa(stamper, cud,9);
        new Pag3().stampa(stamper, cud,10);
        new Pag4().stampa(stamper, cud,11);
        new Pag5().stampa(stamper, cud,12);
       // new Pag5().stampa(stamper, cud,13);
        new Pag6().stampa(stamper, cud,13);

        stamper.close();
        reader.close();


    }



}
