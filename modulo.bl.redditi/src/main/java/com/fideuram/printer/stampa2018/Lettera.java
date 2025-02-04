package com.fideuram.printer.stampa2018;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;


public class Lettera extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2018 cud, int pag) {
        PdfContentByte canvas = stamper.getOverContent(pag);
        int riga=640;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().toString(),10), 332, riga, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getVia().trim(),10), 332, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 332, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 99, riga=riga-30, 0);
        
        int anno = 2018;
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