package com.fideuram.printer;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;

/**
 * User: V801068
 * Date: 21/11/14
 * Time: 15.18
 */
public abstract class Cud {

    protected Phrase getPhrase(Integer i){
        return this.getPhrase(i+"");
    }

    protected Phrase getPhrase(String s){
        return getPhrase(s,9);
    }

    protected Phrase getPhrase(String s, int fontSize){
        Font f1= FontFactory.getFont(FontFactory.TIMES_ROMAN, fontSize);
        return new Phrase(s,f1);
    }


}
