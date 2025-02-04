package com.fideuram.printer.stampa2019;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
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
	public void stampa(PdfStamper stamper, Cud2019 cud, int pag) {
    
		PdfContentByte canvas = stamper.getOverContent(pag);
		
        int riga=640;
        
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().toString(),10), 					332, riga, 0);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getVia().trim(),10), 			332, riga=riga-10, 0);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 	332, riga=riga-10, 0);
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 							99, riga=riga-30, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getPercettoreSomme().toString(),10), 					322, riga, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getVia().trim(),10), 			322, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 	322, riga=riga-10, 0);
        //Data
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(cud.getDataEleaborazione(),10), 							87, riga=riga-30, 0);//OK
        
        int anno = 2019;
        if(cud.isPrimaDichiarazione()) {
        	
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 		/*451*/452, riga=riga-96, 0);//Modello CU
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+(anno-1),11), 	/*225*/224, riga=riga-12, 0);
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 		/*263*/268, riga=riga-/*49*/51, 0);
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 		/*448*/453, riga, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		462, riga=riga-95, 0);//2019
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+(anno-1),10), 	213, riga=riga-11, 0);//2018
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		251, riga=riga-47, 0);//Modello 730/2019
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 		438, riga, 0);		  //fisiche 2019
            
//            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 150, riga=riga-201, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhraseL(""+anno,10), 75, riga=riga-213, 0);
        
        } else { 
        	
        	//GIO::: rettifica : a parte la data e l'indirizzo, è inutile stampare l'anno fiscale, già presente nella lettera di rettifica
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("",10), 365, riga=riga-96, 0);
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("",10), 149, riga=riga-214, 0);
        }
        
    }
}