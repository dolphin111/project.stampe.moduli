package com.fideuram.printer.itext;


import com.fideuram.factory.ImageLoader;
import com.fideuram.iText.PiedinoColore;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.awt.*;
import java.io.IOException;

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

    protected Phrase getPhrase(){
        Phrase phrase = new Phrase(50);
        return phrase;
    }
    protected Chunk getChunk(String s, int fontSize,boolean bold){
        Font f1= FontFactory.getFont(FontFactory.TIMES_ROMAN, fontSize,bold?Font.BOLD:Font.NORMAL);
        return new Chunk(s,f1);
    }

    public abstract void stampa(PdfStamper stamper, AreaRiservata credenziali) throws DocumentException ;




}
