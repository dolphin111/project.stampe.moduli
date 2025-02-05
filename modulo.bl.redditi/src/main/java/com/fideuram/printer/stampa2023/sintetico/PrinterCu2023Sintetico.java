package com.fideuram.printer.stampa2023.sintetico;

import com.fideuram.printer.stampa2023.Lettera;
import com.fideuram.printer.stampa2023.Pag1;
import com.fideuram.printer.stampa2023.PrinterCu2023;
import com.fideuram.stampe.modello.redditi.d2023.Cud2023;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

import com.fideuram.stampe.modello.redditi.CudBase;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2023Sintetico extends PrinterCu2023 {

    public PrinterCu2023Sintetico(Cud2023 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2023() throws IOException, DocumentException {
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getTipoDichiarazione() = " + cud.getTipoDichiarazione());

    	LoggingUtils.info("chiamo generateCud2023 ::: ");

    	  new Lettera().stampa(stamper, cud,1);//LETTERA

        // Aprile 2023 (Engineering) (aggiunta istruzione IF come condizione per l'annullamento, per generare solo la prima pagina)
        if (CudBase.ANNULLAMENTO != cud.getTipoDichiarazione()) {
            //2-pagina bianca
            new Pag1().stampa(stamper, cud, 3);//DATI ANAGRAFICI
            new Pag2().stampa(stamper, cud, 4);//DATI FISCALI
            new Pag3().stampa(stamper, cud, 5);//PREVIDENZA COMPLEMENTARE
            new Pag4().stampa(stamper, cud, 6);//DATI RELATIVI CONIUGE E FAMILIARI A CARICO
            new Pag5().stampa(stamper, cud, 7);//TRATT. FINE RAPPORTO - NEW 2020
            new Pag6().stampa(stamper, cud, 8);//ANNOTAZIONI

            new Pag7().stampa(stamper, cud, 9);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
            new Pag8().stampa(stamper, cud, 10);//CERTIFICAZIONE REDDITI - LOCAZIONI BREVI

            new Pag1().stampa(stamper, cud, 13);//DATI ANAGRAFICI
            new Pag2().stampa(stamper, cud, 14);//DATI FISCALI
            new Pag3().stampa(stamper, cud, 15);//ALTRI DATI - COMPENSI ANNI PREC - FAM A CARICO
            new Pag4().stampa(stamper, cud, 16);//DATI PREVIDENZIALI
            new Pag5().stampa(stamper, cud, 17);//TRATT. FINE RAPPORTO - NEW 2020
            new Pag6().stampa(stamper, cud, 18);//ANNOTAZIONI

            new Pag7().stampa(stamper, cud, 19);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
            new Pag8().stampa(stamper, cud, 20);//CERTIFICAZIONE REDDITI - LOCAZIONI BREVI
        } // Aprile 2023 (Engineering)

          stamper.close();
          reader.close();


    }
}