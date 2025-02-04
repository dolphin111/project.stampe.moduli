package com.fideuram.printer.stampa2016.sintetico;

import com.fideuram.printer.stampa2016.Lettera;
import com.fideuram.printer.stampa2016.Pag1;
import com.fideuram.printer.stampa2016.PrinterCu2016;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2016Sintetico extends PrinterCu2016{

    public PrinterCu2016Sintetico(Cud2016 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2016() throws IOException, DocumentException {
        new Lettera().stampa(stamper, cud,1);
        new Pag1().stampa(stamper, cud,2);
        new Pag2().stampa(stamper, cud,3);
        new Pag3().stampa(stamper, cud,4);
        new Pag4().stampa(stamper, cud,5);
        new Pag6().stampa(stamper, cud,6);

        new Pag1().stampa(stamper, cud,9);
        new Pag2().stampa(stamper, cud,10);
        new Pag3().stampa(stamper, cud,11);
        new Pag4().stampa(stamper, cud,12);
        new Pag6().stampa(stamper, cud,13);
        stamper.close();
        reader.close();


    }
}
