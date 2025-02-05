package com.fideuram.printer.stampa2021.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2021.Cud2021;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;


/**
 * User: V801068
 * Date: 18/01/16
 * Time: 12.12
 */
public class Pag7 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2021 cud, int pag) throws DocumentException {

        canvas = stamper.getOverContent(pag);

        int anno = 2021;

        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);

        if(cud.isSostituzione())
        {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }

        propagaCF(cud,pag);

    }

}