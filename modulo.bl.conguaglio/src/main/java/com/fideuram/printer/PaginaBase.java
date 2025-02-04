package com.fideuram.printer;


import com.fideuram.stampe.modello.rendita.Prestazione;
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
        return getPhrase(s, 11);
    }

    protected Phrase getPhrase(String s, int fontSize){
        Font f1= FontFactory.getFont(FontFactory.TIMES_ROMAN, fontSize);
        return new Phrase(s,f1);
    }


    protected Phrase getPhraseBold(String s, int fontSize){
        Font f1=  FontFactory.getFont(FontFactory.TIMES_ROMAN, fontSize, Font.BOLD);
        return new Phrase(s,f1);
    }


    public abstract void stampa(PdfStamper stamper,Prestazione prestazione,int pag) throws DocumentException;

    public static String UppercaseFirstLetters(String str)
    {
        boolean prevWasWhiteSp = true;
        if (str != null){
            char[] chars = str.toLowerCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    if (prevWasWhiteSp) {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    prevWasWhiteSp = false;
                } else {
                    prevWasWhiteSp = Character.isWhitespace(chars[i]);
                }
            }
            return new String(chars);
        }
        return null;
    }
}
