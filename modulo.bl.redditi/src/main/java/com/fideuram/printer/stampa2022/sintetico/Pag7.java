package com.fideuram.printer.stampa2022.sintetico;

import java.util.List;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2022.Cud2022;
import com.fideuram.stampe.modello.redditi.d2022.annotazioni.Annotazioni;
import com.fideuram.stampe.modello.redditi.d2022.datiPrevidenziali.DatiPrevidenziali;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;


/**
 * User: V801068
 * Date: 18/01/16
 * Time: 12.12
 */
public class Pag7 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2022 cud, int pag) throws DocumentException {
    	
        canvas = stamper.getOverContent(pag);
        
        int anno = 2022;
        
        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);
        
        if(cud.isRettifica())
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        
        propagaCF(cud,pag);
        
    }
    
}