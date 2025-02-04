package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 17.34
 */
public class Pag5 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2015 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCf()),              114, 608, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCognome()),         114, 560, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getNome()),            322, 560, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getSesso()),           537, 560, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDataNascitaDilatatissimo()),     114, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getComuneNascita()),   230, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getProvinciaNascita()),537, 508, 0);
    }
}
