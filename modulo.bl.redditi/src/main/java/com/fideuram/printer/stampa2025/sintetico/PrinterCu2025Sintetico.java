package com.fideuram.printer.stampa2025.sintetico;

import com.fideuram.printer.stampa2025.Lettera;
import com.fideuram.printer.stampa2025.Pag1;
import com.fideuram.printer.stampa2025.PrinterCu2025;
import com.fideuram.stampe.modello.redditi.d2025.Cud2025;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

import com.fideuram.stampe.modello.redditi.CudBase;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/16
 * Time: 19.13
 */
public class PrinterCu2025Sintetico extends PrinterCu2025 {

    public PrinterCu2025Sintetico(Cud2025 cud) throws IOException, DocumentException {
        super(cud);
    }

    public void generateCud2025() throws IOException, DocumentException {
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getTipoDichiarazione() = " + cud.getTipoDichiarazione());

    	LoggingUtils.info("chiamo generateCud2025 ::: ");

    	  new Lettera().stampa(stamper, cud,1); // Lettera di accompagnamento (primo invio), sostituzione o annullamento

        // Aprile 2023 (Engineering) (aggiunta istruzione IF come condizione per l'annullamento, per generare solo la prima pagina)
        if (CudBase.ANNULLAMENTO != cud.getTipoDichiarazione()) {
            // Pagina 2: vuota

            // Febbraio 2024 (Engineering) (adeguata impaginazione al 2024) (INIZIO)
            // Prima copia
            new Pag1().stampa(stamper, cud, 3);//DATI ANAGRAFICI
            new Pag2().stampa(stamper, cud, 4);//DATI FISCALI
            new Pag3().stampa(stamper, cud, 5);//PREVIDENZA COMPLEMENTARE
            new Pag4().stampa(stamper, cud, 6); // SOMME EROGATE PER PREMI DI RISULTATO IN FORZA DI CONTRATTI COLLETTIVI AZIENDALI O TERRITORIALI (ex DATI RELATIVI CONIUGE E FAMILIARI A CARICO)
            new Pag5().stampa(stamper, cud, 7); // DATI PREVIDENZIALI ED ASSISTENZIALI (ex TRATT. FINE RAPPORTO - NEW 2020)
            new Pag6().stampa(stamper, cud, 8); // Pagina 8 (SEZIONE 4  INPS SOCI COOPERATIVE ARTIGIANE)
            new Pag7().stampa(stamper, cud, 9);//ANNOTAZIONI
            new Pag8().stampa(stamper, cud, 10);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
            new Pag9().stampa(stamper, cud, 11);//CERTIFICAZIONE REDDITI - LOCAZIONI BREVI

            // Seconda copia
            new Pag1().stampa(stamper, cud, 14);//DATI ANAGRAFICI
            new Pag2().stampa(stamper, cud, 15);//DATI FISCALI
            new Pag3().stampa(stamper, cud, 16);//PREVIDENZA COMPLEMENTARE
            new Pag4().stampa(stamper, cud, 17); // SOMME EROGATE PER PREMI DI RISULTATO IN FORZA DI CONTRATTI COLLETTIVI AZIENDALI O TERRITORIALI (ex DATI RELATIVI CONIUGE E FAMILIARI A CARICO)
            new Pag5().stampa(stamper, cud, 18); // DATI PREVIDENZIALI ED ASSISTENZIALI (ex TRATT. FINE RAPPORTO - NEW 2020)
            new Pag6().stampa(stamper, cud, 19); // Pagina 8 (SEZIONE 4  INPS SOCI COOPERATIVE ARTIGIANE)
            new Pag7().stampa(stamper, cud, 20);//ANNOTAZIONI
            new Pag8().stampa(stamper, cud, 21);//CERTIFICAZIONE LAVORO AUTONOMO, PROVVIGIONI E REDDITI DIVERSI
            new Pag9().stampa(stamper, cud, 22);//CERTIFICAZIONE REDDITI - LOCAZIONI BREVI
            // Febbraio 2024 (Engineering) (adeguata impaginazione al 2024) (FINE)
        } // Aprile 2023 (Engineering)

          stamper.close();
          reader.close();


    }
}