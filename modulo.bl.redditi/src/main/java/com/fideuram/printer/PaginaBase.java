package com.fideuram.printer;

import com.fideuram.stampe.modello.redditi.CudBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;

import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 21/01/15
 * Time: 16.16
 */
public abstract class PaginaBase {
    protected PdfContentByte canvas;

    protected Phrase getPhrase(Integer i){
        return this.getPhrase(i+"");
    }

    protected Phrase getPhrase(String s){
        return getPhrase(s, 9);
    }

    protected Phrase getPhrase(String s, int fontSize){
        Font f1= FontFactory.getFont(FontFactory.TIMES_ROMAN, fontSize);
        return new Phrase(s,f1);
    }
    
    //Font usato nella Lettera di accompagno
    protected Phrase getPhraseL(Integer i){
        return this.getPhrase(i+"");
    }

    protected Phrase getPhraseL(String s){
        return getPhrase(s, 9);
    }

    protected Phrase getPhraseL(String s, int fontSize){
        Font f1= FontFactory.getFont(FontFactory.HELVETICA, fontSize);
        return new Phrase(s,f1);
    }    
    
    //fine Font usato nella Lettera di accompagno

    //public abstract void stampa(PdfStamper stamper,Cud2015 cud,int pag) throws DocumentException;

    public void propagaCF(Cud2015 cud, int pag){
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCf()), 124, 809, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("0    1"), 543, 809, 0);
    }

    //public void propagaCF(Cud2016 cud, int pag){
    public void propagaCF(CudBase cud, int pag){
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCf()), 124, 809, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("0    1"), 543, 809, 0);
    }
}
