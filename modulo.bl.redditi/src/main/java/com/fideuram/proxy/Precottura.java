package com.fideuram.proxy;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.redditi.anagrafica.SostitutoImposta;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 04/01/16
 * Time: 12.36
 */
public class Precottura extends Cud{
    String outputfile;
    PdfReader reader;
    PdfStamper stamper;
    boolean rettificacud;


}
