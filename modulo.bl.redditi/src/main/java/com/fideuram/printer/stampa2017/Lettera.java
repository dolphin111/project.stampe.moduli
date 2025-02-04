package com.fideuram.printer.stampa2017;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2017.Cud2017;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 23/01/15
 * Time: 15.05
 */
public class Lettera extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2017 cud, int pag) {
        PdfContentByte canvas = stamper.getOverContent(pag);
        int riga=630;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().toString(),10), 332, riga, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getVia().trim(),10), 332, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 332, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 97, riga=riga-20, 0);
        
        int anno = 2017;
        if(cud.isPrimaDichiarazione())
        { 
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 451, riga=riga-96, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+(anno-1),11), 225, riga=riga-12, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 263, riga=riga-49, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 448, riga, 0);
            
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 150, riga=riga-201, 0);
        }
        else
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 365, riga=riga-96, 0);
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(""+anno,11), 149, riga=riga-214, 0);
        }
        
    }
}
