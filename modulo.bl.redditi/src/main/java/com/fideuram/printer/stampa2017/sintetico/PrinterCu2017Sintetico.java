package com.fideuram.printer.stampa2017.sintetico;

import com.fideuram.printer.stampa2017.Lettera;
import com.fideuram.printer.stampa2017.Pag1;
import com.fideuram.printer.stampa2017.PrinterCu2017;
import com.fideuram.stampe.modello.redditi.d2017.Cud2017;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2017Sintetico extends PrinterCu2017{

    public PrinterCu2017Sintetico(Cud2017 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2017() throws IOException, DocumentException {
        new Lettera().stampa(stamper, cud,1);
        new Pag1().stampa(stamper, cud,3);
        new Pag2().stampa(stamper, cud,4);
        new Pag3().stampa(stamper, cud,5);
        new Pag4().stampa(stamper, cud,6);
        new Pag6().stampa(stamper, cud,7);

        new Pag1().stampa(stamper, cud,11);
        new Pag2().stampa(stamper, cud,12);
        new Pag3().stampa(stamper, cud,13);
        new Pag4().stampa(stamper, cud,14);
        new Pag6().stampa(stamper, cud,15);
        stamper.close();
        reader.close();


    }
}