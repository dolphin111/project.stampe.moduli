package com.fideuram.iText;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;

/**
 * User: V801068
 * Date: 18/05/15
 * Time: 16.13
 */
public class Frase {
    public Phrase getPhrase(Integer i){
        return this.getPhrase(i+"");
    }

    public Phrase getPhrase(String s){
        return getPhrase(s,9);
    }

    public Phrase getPhrase(String s, int fontSize){
        Font f1= FontFactory.getFont(FontFactory.TIMES_ROMAN, fontSize);
        return new Phrase(s,f1);
    }

    public Phrase getPhrase(String s, String font ,int fontSize){
        Font f1= FontFactory.getFont(font, fontSize);
        return new Phrase(s,f1);
    }

    public Phrase getPhrase(String s, String font ,int fontSize,boolean bold){
        Font f1= FontFactory.getFont(font, fontSize,bold?Font.BOLD:Font.NORMAL);
        return new Phrase(s,f1);
    }
}
