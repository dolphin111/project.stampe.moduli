package com.fideuram.printer.stampa2022;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2022.Cud2022;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;


public class Lettera extends PaginaBase {
    
	
	public void test () {
		System.out.println("test");
	}
	public void stampa(PdfStamper stamper, Cud2022 cud, int pag) {
    
		PdfContentByte canvas = stamper.getOverContent(pag);
		
		/* GIO::: 11/02/2022
		 * Dalla riga 656 comincia intestazione Lettera:
		 *  Gentile Signor
			NOME COGNOME
			VIA GLUGLIELMO PIZZIRANI 5
			40133 BOLOGNA BO
		 * */
        int riga=656;//643;//da 640 a 638
        
        //Gentile 
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getPercettoreSomme().getTitolo(),10), 			322, riga, 0);
        //Nome Cognome
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getPercettoreSomme().toString(),10), 					322, riga=riga-10, 0);
        //Indirizzo
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getVia().trim(),10), 			322, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 	322, riga=riga-10, 0);
        //Data
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getDataEleaborazione(),10), 							88, riga=riga-30, 0);//OK 102
        
        int anno = 2022;
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