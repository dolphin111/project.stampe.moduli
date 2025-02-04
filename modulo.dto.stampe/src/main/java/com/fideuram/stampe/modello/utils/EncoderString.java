package com.fideuram.stampe.modello.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * User: v801068
 * Date: 16/10/14
 * Time: 7.56
 */
public class EncoderString {
    public static String encodUTF8(String frase){
        try {
            byte[] b= frase.getBytes(Charset.defaultCharset());
            String utf8encoded = new String(b, Configurazione.ENCODING);
            return utf8encoded;
        } catch (UnsupportedEncodingException e) {
            return frase;
        }
    }
}
