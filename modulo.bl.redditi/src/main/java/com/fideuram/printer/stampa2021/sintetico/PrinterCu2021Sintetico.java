package com.fideuram.printer.stampa2021.sintetico;

import com.fideuram.printer.stampa2021.sintetico.Pag2;
import com.fideuram.printer.stampa2021.sintetico.Pag3;
import com.fideuram.printer.stampa2021.sintetico.Pag4;
import com.fideuram.printer.stampa2021.sintetico.Pag6;
import com.fideuram.printer.stampa2021.Lettera;
import com.fideuram.printer.stampa2021.Pag1;
import com.fideuram.printer.stampa2021.PrinterCu2021;
import com.fideuram.stampe.modello.redditi.d2021.Cud2021;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2021Sintetico extends PrinterCu2021{

    public PrinterCu2021Sintetico(Cud2021 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2021() throws IOException, DocumentException {
    	  
    	  new Lettera().stampa(stamper, cud,1);//LETTERA
    	  									   //2-pagina bianca
          new Pag1().stampa(stamper, cud,3);//DATI ANAGRAFICI
          new Pag2().stampa(stamper, cud,4);//DATI FISCALI
          new Pag3().stampa(stamper, cud,5);//PREVIDENZA COMPLEMENTARE
          new Pag4().stampa(stamper, cud,6);//DATI RELATIVI CONIUGE E FAMILIARI A CARICO
          new Pag5().stampa(stamper, cud,7);//TRATT. FINE RAPPORTO - NEW 2020
          new Pag6().stampa(stamper, cud,8);//ANNOTAZIONI

          new Pag7().stampa(stamper, cud,9);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
          new Pag8().stampa(stamper, cud,10);//CERTIFICAZIONE REDDITI - LOCAZIONI BREVI
          									
          new Pag1().stampa(stamper, cud,13);//DATI ANAGRAFICI
          new Pag2().stampa(stamper, cud,14);//DATI FISCALI
          new Pag3().stampa(stamper, cud,15);//ALTRI DATI - COMPENSI ANNI PREC - FAM A CARICO
          new Pag4().stampa(stamper, cud,16);//DATI PREVIDENZIALI
          new Pag5().stampa(stamper, cud,17);//TRATT. FINE RAPPORTO - NEW 2020
          new Pag6().stampa(stamper, cud,18);//ANNOTAZIONI
          
          new Pag7().stampa(stamper, cud,19);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
          new Pag8().stampa(stamper, cud,20);//CERTIFICAZIONE REDDITI - LOCAZIONI BREVI          
          
          stamper.close();
          reader.close();


    }
}