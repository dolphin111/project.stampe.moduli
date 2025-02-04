package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 23/01/15
 * Time: 15.05
 */
public class Lettera extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2015 cud, int pag) {
        PdfContentByte canvas = stamper.getOverContent(pag);
        int riga=630;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().toString(),10), 332, riga, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getVia().trim(),10), 332, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getIndirizzoLettera().getCapLocalProv().trim(),10), 332, riga=riga-10, 0);
        //ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAttuale().getVia().trim(),10), 332, riga=riga-10, 0);
        //ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAttuale().getCapLocalProv().trim(),10), 332, riga=riga-10, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 97, riga=riga-30, 0);
    }
}
