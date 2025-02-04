package com.fideuram.printer.stampa2019.sintetico;

import com.fideuram.printer.stampa2019.sintetico.Pag2;
import com.fideuram.printer.stampa2019.sintetico.Pag3;
import com.fideuram.printer.stampa2019.sintetico.Pag4;
import com.fideuram.printer.stampa2019.sintetico.Pag6;
import com.fideuram.printer.stampa2019.Lettera;
import com.fideuram.printer.stampa2019.Pag1;
import com.fideuram.printer.stampa2019.PrinterCu2019;
import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2019Sintetico extends PrinterCu2019{

    public PrinterCu2019Sintetico(Cud2019 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2019() throws IOException, DocumentException {
    	  
    	  new Lettera().stampa(stamper, cud,1);//LETTERA
    	  									   //2-pagina bianca
          new Pag1().stampa(stamper, cud,3);//DATI ANAGRAFICI
          new Pag2().stampa(stamper, cud,4);//DATI FISCALI
          new Pag3().stampa(stamper, cud,5);//ALTRI DATI - COMPENSI ANNI PREC - FAM A CARICO
          new Pag4().stampa(stamper, cud,6);//DATI PREVIDENZIALI
          new Pag6().stampa(stamper, cud,7);//ANNOTAZIONI
          									//8-pagina bianca
          //new Pag7().stampa(stamper, cud,8);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
          //new Pag8().stampa(stamper, cud,9);CERTIFICAZIONE REDDITI - LOCAZIONI BREVI
          //PAGINA 10 Scheda 8 per mille
          //PAGINA 11 Scheda 5 per mille / Scheda 2 per mille dell'IRPEF
          //PAGINA 12 - pagina bianca
          
          									//pagina bianca
          new Pag1().stampa(stamper, cud,13);//DATI ANAGRAFICI
          new Pag2().stampa(stamper, cud,14);//DATI FISCALI
          new Pag3().stampa(stamper, cud,15);//ALTRI DATI - COMPENSI ANNI PREC - FAM A CARICO
          new Pag4().stampa(stamper, cud,16);//DATI PREVIDENZIALI
          new Pag6().stampa(stamper, cud,17);//ANNOTAZIONI
          //new Pag7().stampa(stamper, cud,18);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
          //new Pag8().stampa(stamper, cud,19);CERTIFICAZIONE REDDITI - LOCAZIONI BREVI          
          
          stamper.close();
          reader.close();


    }
}