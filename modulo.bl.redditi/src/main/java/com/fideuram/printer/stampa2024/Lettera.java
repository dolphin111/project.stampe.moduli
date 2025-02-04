package com.fideuram.printer.stampa2024;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2024.Cud2024;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;


public class Lettera extends PaginaBase {


	public void test () {
		System.out.println("test");
	}
	public void stampa(PdfStamper stamper, Cud2024 cud, int pag) {

		PdfContentByte canvas = stamper.getOverContent(pag);

		/* GIO::: 11/02/2023
		 * Dalla riga 656 comincia intestazione Lettera:
		 *  Gentile Signor
			NOME COGNOME
			VIA GLUGLIELMO PIZZIRANI 5
			40133 BOLOGNA BO
		 * */
        int riga=656;//643;//da 640 a 638

        //Gentile
        // 01/03/2023 (Engineering): aggiunta visualizzazione condizionale
		// Aprile 2023 (Engineering): modificata condizione in esclusione primo invio
         if (! cud.isPrimaDichiarazione()) {
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getPercettoreSomme().getTitolo(), 10), 322, riga, 0);
         }
        //Nome Cognome
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getPercettoreSomme().toString(),10), 					322, riga=riga-10, 0);

        //Indirizzo
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getVia().trim(),10), 			322, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 	322, riga=riga-10, 0);
        //Data
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getDataEleaborazione(),10), 							88, riga=riga-30, 0);//OK 102

        System.out.println(new Exception().getStackTrace()[0] + ": cud = " + cud);
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getPercettoreSomme() = " + cud.getPercettoreSomme());
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getIndirizzoLettera() = " + cud.getIndirizzoLettera());
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getIndirizzoLettera().getVia() = " + cud.getIndirizzoLettera().getVia());
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getIndirizzoLettera().getCapLocalProv() = " + cud.getIndirizzoLettera().getCapLocalProv());
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getIndirizzoLettera().getTel_fax() = " + cud.getIndirizzoLettera().getTel_fax());
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getIndirizzoLettera().geteMail() = " + cud.getIndirizzoLettera().geteMail());

        int anno = 2024;
        riga = riga-2;
        if(cud.isPrimaDichiarazione()) {

/*        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		462, riga=riga-95, 0);// (MODELLO CU 2020)
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+(anno-1),10), 	214, riga=riga-11, 0);// dell'anno 2019				//230

            riga= riga+1;
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		252, riga=riga-48, 0);//Modello 730/2020
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		442, riga, 0);		  //persone fisiche 2020

            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 75, riga=riga-213, 0);
*/
        } else {

        	//GIO::: rettifica : a parte la data e l'indirizzo, è inutile stampare l'anno fiscale, già presente nella lettera di rettifica
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("",10), 365, riga=riga-96, 0);
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("",10), 149, riga=riga-214, 0);
        }

    }
}