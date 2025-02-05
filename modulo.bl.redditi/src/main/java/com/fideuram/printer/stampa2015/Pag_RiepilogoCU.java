package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 27/01/15
 * Time: 19.15
 */
public class Pag_RiepilogoCU extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2015 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        if(cud.isSostituzione())
           ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 358, 692, 0);
        if(cud.isAnnullamento())
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 178, 692, 0);
        char[] c= cud.getPercettoreSomme().getCf().toCharArray();
        int colonna=320;
        for(int i=0;i<c.length;i++){
            if(i<=6)
                colonna=colonna+14;
            else if(i>6&&i<12)
                colonna=colonna+15;
            else if(i>=12)
                colonna=colonna+14;
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(c[i] + ""), colonna, 729, 0);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getNumCertDip()), 158, 476, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getNumCertPro()), 242, 476, 0);
    }
}
