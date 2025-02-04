package com.fideuram.printer.stampa2018.sintetico;

import com.fideuram.printer.stampa2018.sintetico.Pag2;
import com.fideuram.printer.stampa2018.sintetico.Pag3;
import com.fideuram.printer.stampa2018.sintetico.Pag4;
import com.fideuram.printer.stampa2018.sintetico.Pag6;
import com.fideuram.printer.stampa2018.Lettera;
import com.fideuram.printer.stampa2018.Pag1;
import com.fideuram.printer.stampa2018.PrinterCu2018;
import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2018Sintetico extends PrinterCu2018{

    public PrinterCu2018Sintetico(Cud2018 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2018() throws IOException, DocumentException {
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