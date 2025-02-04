package com.fideuram.printer.stampa2016.ordinario;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 12/01/16
 * Time: 11.56
 */
public class Pag3 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2016 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC261()), 132, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC262()), 220, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC263()), 308, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC264()), 414, 760, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC271()), 132, 725, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC272()), 220, 725, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC273()), 308, 725, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC274()), 414, 725, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC275()), 514, 725, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC281()), 132, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC282()), 220, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC283()), 308, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC284()), 414, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC285()), 514, 688, 0);


        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC291()), 132, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC292()), 220, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC293()), 308, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC294()), 414, 652, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC301()), 132, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC302()), 235, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC306()), 364, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC307()), 468, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC311()), 132, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC312()), 235, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC321()), 132, 542, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC322()), 210, 542, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC323()), 288, 542, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC324()), 332, 542, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC325()), 415, 542, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC326()), 490, 542, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC327()), 132, 507, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC328()), 226, 507, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC331()), 283, 507, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC332()), 386, 507, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC333()), 492, 507, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC341()), 128, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC342()), 162, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC343()), 247, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC344()), 278, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC345()), 367, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC346()), 400, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC347()), 128, 460, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC348()), 162, 460, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC349()), 247, 460, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC350()), 278, 460, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC351()), 367, 460, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC352()), 400, 460, 0);


        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC361()), 130, 436, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC362()), 244, 436, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC363()), 356, 436, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC364()), 470, 436, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC365()), 130, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC366()), 244, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC367()), 356, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC368()), 470, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC369()), 130, 388, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC370()), 244, 388, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC371()), 356, 388, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC372()), 470, 388, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC373()), 130, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC374()), 244, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC375()), 356, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC376()), 470, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC377()), 130, 340, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC378()), 244, 340, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC391()), 124, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC392()), 168, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC393()), 258, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC394()), 348, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC395()), 430, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC396()), 476, 304, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC397()), 130, 280, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC399()), 348, 280, 0);
    }
}
