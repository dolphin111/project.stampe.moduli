package com.fideuram.printer.stampa2020;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2020.Cud2020;
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
	public void stampa(PdfStamper stamper, Cud2020 cud, int pag) {
    
		PdfContentByte canvas = stamper.getOverContent(pag);
		
        int riga=643;//da 640 a 638
        
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().toString(),10), 					332, riga, 0);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getVia().trim(),10), 			332, riga=riga-10, 0);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 	332, riga=riga-10, 0);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 							99, riga=riga-30, 0);
        //Indirizzo
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getPercettoreSomme().toString(),10), 					322, riga, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getVia().trim(),10), 			322, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 	322, riga=riga-10, 0);
        //Data
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getDataEleaborazione(),10), 							88, riga=riga-30, 0);//OK 102
        
        int anno = 2020;
        riga = riga-2;
        if(cud.isPrimaDichiarazione()) {
        	
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 		/*451*/452, riga=riga-96, 0);//Modello CU
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+(anno-1),11), 	/*225*/224, riga=riga-12, 0);
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 		/*263*/268, riga=riga-/*49*/51, 0);
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 		/*448*/453, riga, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		462, riga=riga-95, 0);// (MODELLO CU 2020)
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+(anno-1),10), 	214, riga=riga-11, 0);// dell'anno 2019				//230
            
            riga= riga+1;
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		252, riga=riga-48, 0);//Modello 730/2020
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		442, riga, 0);		  //persone fisiche 2020
            
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 150, riga=riga-201, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 75, riga=riga-213, 0);
        
        } else { 
        	
        	//GIO::: rettifica : a parte la data e l'indirizzo, è inutile stampare l'anno fiscale, già presente nella lettera di rettifica
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("",10), 365, riga=riga-96, 0);
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("",10), 149, riga=riga-214, 0);
        }
        
    }
}