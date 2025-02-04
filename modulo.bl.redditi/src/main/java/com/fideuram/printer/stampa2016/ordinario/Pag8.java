package com.fideuram.printer.stampa2016.ordinario;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.stampe.modello.redditi.d2016.redditidiversi.GestioneSeparata;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 20/01/16
 * Time: 16.19
 */
public class Pag8 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2016 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        GestioneSeparata g=cud.getGestioneSeparata();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC894()), 132, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC895()), 264, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC896()), 304, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC897()), 372, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC898()), 448, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC899()), 132, 712, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC900()), 214, 712, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC901()), 304, 712, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC902()), 390, 712, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC903()), 478, 712, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC904()), 132, 674, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC905()), 214, 674, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC906()), 304, 674, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC907()), 390, 674, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC908()), 478, 674, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC909()), 132, 640, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC910()), 228, 640, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC911()), 334, 640, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC914()), 138, 594, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC915()), 328, 594, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC916()), 484, 594, 0);

    }
}