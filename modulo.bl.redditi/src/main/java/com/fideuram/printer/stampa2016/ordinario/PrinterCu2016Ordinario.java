package com.fideuram.printer.stampa2016.ordinario;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.printer.stampa2016.Lettera;
import com.fideuram.printer.stampa2016.Pag1;
import com.fideuram.printer.stampa2016.PrinterCu2016;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: V801068
 * Date: 07/01/16
 * Time: 18.10
 */
public class PrinterCu2016Ordinario extends PrinterCu2016 {


    public PrinterCu2016Ordinario(Cud2016 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2016() throws IOException, DocumentException {
        new Lettera().stampa(stamper, cud,1);
        new Pag1().stampa(stamper, cud,2);
        new Pag2().stampa(stamper, cud,3);
        new Pag3().stampa(stamper, cud,4);
        new Pag4().stampa(stamper, cud,5);
        new Pag5().stampa(stamper, cud,6);
        new Pag6().stampa(stamper, cud,7);
        new Pag7().stampa(stamper, cud,8);
        new Pag8().stampa(stamper, cud,9);
        new Pag9().stampa(stamper, cud,10);
        new Pag1().stampa(stamper, cud,11);
        new Pag2().stampa(stamper, cud,12);
        new Pag3().stampa(stamper, cud,13);
        new Pag4().stampa(stamper, cud,14);
        new Pag5().stampa(stamper, cud,15);
        new Pag6().stampa(stamper, cud,16);
        new Pag7().stampa(stamper, cud,17);
        new Pag8().stampa(stamper, cud,18);
        new Pag9().stampa(stamper, cud,19);
        stamper.close();
        reader.close();


    }
}
