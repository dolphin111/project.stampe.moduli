package com.fideuram.costanti;

/**
 * User: V801068
 * Date: 01/02/16
 * Time: 14.29
 */
public class Errori {
    public static final String  ERROR_XML       ="Errore durante la fase di conversione xml ";
    public static final String  ERROR_NOTFOUND  ="Errore di ClassNotFoundException durante la fase di conversione xml ";
    public static final String  ERROR_INSTANCE  ="Errore di InstantiationException durante la fase di conversione xml ";
    public static final String  ERROR_ILLEGAL   ="Errore di IllegalAccessException durante la fase di conversione xml ";
    public static final String  ERROR_TYPE      ="Richiesta una Stampa , ma non è stato specificato il Tipo.  OPPURE NON è UN TIPO CORRETTO.";
    public static final String  ERROR_FREEMARKER="Errore  FREEMARKER durante il merge del template con i dati";
    public static final String  ERROR_TEMPLATE  ="Errore  di caricamento del template";
    public static final String  ERROR_IO        ="Errore  di lettura o scrittura dal File System";
    public static final String  ERROR_DOCUMENT  ="Errore  di lettura o lettura di un PDF .... ITEXT";
}
