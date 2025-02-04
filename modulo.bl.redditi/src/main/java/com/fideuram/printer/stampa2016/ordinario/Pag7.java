package com.fideuram.printer.stampa2016.ordinario;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.stampe.modello.redditi.d2016.redditidiversi.GestioneSeparata;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 18/01/16
 * Time: 19.38
 */
public class Pag7  extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2016 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        GestioneSeparata g=cud.getGestioneSeparata();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC801()), 132, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC802()), 218, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC803()), 304, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC804()), 390, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC805()), 478, 748, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC806()), 132, 724, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC807()), 218, 724, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC808()), 304, 724, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC809()), 390, 724, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC810()), 478, 724, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC811()), 132, 700, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC812()), 218, 700, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC813()), 304, 700, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC814()), 134, 654, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC815()), 220, 654, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC816()), 306, 654, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC817()), 390, 654, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC818()), 434, 654, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC819()), 464, 654, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC820()), 128, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC821()), 178, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC822()), 228, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC823()), 278, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC824()), 324, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC825()), 408, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC826()), 434, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC827()), 454, 604, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC828()), 480, 604, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC829()), 128, 552, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC830()), 174, 552, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC831()), 252, 552, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC832()), 294, 552, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC833()), 378, 552, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC834()), 434, 552, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC835()), 128, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC836()), 184, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC837()), 232, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC838()), 280, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC839()), 324, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC840()), 410, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC841()), 494, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC842()), 518, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC843()), 536, 495, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC844()), 128, 458, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC845()), 232, 458, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC846()), 280, 458, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC847()), 380, 458, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC848()), 428, 458, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC849()), 128, 410, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC850()), 208, 410, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC851()), 240, 410, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC852()), 336, 410, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC853()), 380, 410, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC854()), 122, 362, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC855()), 172, 362, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC856()), 232, 362, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC857()), 128, 328, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC858()), 208, 328, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC859()), 284, 328, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC860()), 330, 328, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC861()), 402, 328, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC862()), 482, 328, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC863()), 122, 292, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC864()), 144, 292, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC865()), 164, 292, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC866()), 208, 292, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC867()), 402, 292, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC868()), 462, 292, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC869()), 128, 243, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC870()), 212, 243, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC871()), 250, 243, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC872()), 338, 243, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC873()), 416, 243, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC874()), 124, 186, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC875()), 190, 186, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC876()), 288, 186, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC877()), 412, 186, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC878()), 474, 186, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC879()), 124, 158, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC880()), 190, 158, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC881()), 412, 158, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC882()), 474, 158, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC883()), 126, 100, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC884()), 180, 100, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC885()), 272, 100, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC886()), 304, 100, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC887()), 398, 100, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC888()), 442, 100, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC889()), 532, 100, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC890()), 128, 52, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC891()), 222, 52, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC892()), 392, 52, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC893()), 474, 52, 0);



    }
}




