package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
/**
 * User: V801068
 * Date: 26/01/15
 * Time: 17.12
 */
public class Pag2 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2015 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC1()), 132, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC2()), 262, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC3()), 298, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC4()), 435, 736, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC5()), 132, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC6()), 248, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC7()), 304, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC8()), 372, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC9()), 457, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC10()),537, 700, 0);


        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC11()), 132, 662, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC12()), 219, 662, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC16()), 304, 662, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC17()), 392, 662, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC19()), 481, 662, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC20()), 132, 628, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC21()), 219, 628, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC23()), 392, 628, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC24()), 481, 628, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC31()), 132, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC32()), 219, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC33()), 304, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC34()), 392, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC35()), 481, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC36()), 132, 568, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC37()), 219, 568, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC38()), 304, 568, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC51()), 132, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC52()), 219, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC53()), 304, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC54()), 392, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC55()), 481, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC56()), 132, 519, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC57()), 219, 519, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ8().getC58()), 304, 519, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC61()), 132, 495, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC62()), 219, 495, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC63()), 304, 495, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC64()), 392, 495, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC65()), 132, 472, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC66()), 219, 472, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC67()), 304, 472, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC68()), 392, 472, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC71()), 132, 446, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC72()), 164, 446, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC73()), 247, 446, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC74()), 280, 446, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC75()), 366, 446, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC76()), 399, 446, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC77()), 132, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC78()), 164, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC79()), 247, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC80()), 280, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC81()), 366, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC82()), 399, 423, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC101()), 132, 398, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC102()), 240, 398, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC103()), 347, 398, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC104()), 132, 374, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC105()), 240, 374, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC106()), 347, 374, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC107()), 453, 374, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC108()), 132, 350, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC109()), 240, 350, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC110()), 347, 350, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC111()), 132, 326, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC112()), 240, 326, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC113()), 347, 326, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC114()), 453, 326, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC115()), 132, 302, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC116()), 240, 302, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC117()), 347, 302, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC118()), 453, 302, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC119()), 137, 266, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC120()), 202, 266, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ12().getC121()), 347, 266, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC141()), 137, 230, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC142()), 175, 230, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC143()), 276, 230, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC144()), 376, 230, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC145()), 478, 230, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC146()), 132, 183, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC147()), 231, 183, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC148()), 332, 183, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC149()), 432, 183, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC150()), 533, 183, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC151()), 132, 146, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC152()), 231, 146, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ13().getC153()), 332, 146, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ14().getC161()), 132, 111, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ14().getC162()), 218, 111, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ14().getC163()), 303, 111, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ14().getC164()), 391, 111, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ14().getC166()), 491, 111, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC171()), 132, 75, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC172()), 202, 75, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC173()), 273, 75, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC174()), 346, 75, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC175()), 418, 75, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC184()), 132, 27, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC186()), 240, 27, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC191()), 375, 27, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ15().getC192()), 421, 27, 0);
    }
}
