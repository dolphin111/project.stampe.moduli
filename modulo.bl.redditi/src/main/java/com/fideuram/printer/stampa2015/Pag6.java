package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 17.54
 */
public class Pag6 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2015 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        char[] c= cud.getPercettoreSomme().getCf().toCharArray();
        int colonna=76;
        for(int i=0;i<c.length;i++){
            if(i<=6)
                colonna=colonna+14;
            else if(i>6&&i<12)
                colonna=colonna+15;
            else if(i>=12)
                colonna=colonna+14;
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(c[i]+""), colonna, 804, 0);
        }
    }


}
