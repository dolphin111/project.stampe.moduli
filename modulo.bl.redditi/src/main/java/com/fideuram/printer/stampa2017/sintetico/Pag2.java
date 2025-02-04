package com.fideuram.printer.stampa2017.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2017.Cud2017;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag2 extends PaginaBase 
{
    public void stampa(PdfStamper stamper, Cud2017 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        
        if(cud.isRettifica())
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        
        propagaCF(cud,pag);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC1()), 132, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC2()), 240, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC3()), 348, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC4()), 460, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC5()), 132, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC6()), 238, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC7()), 282, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC8()), 344, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC9()), 430, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC10()),506, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC11()),532, 690, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC21()), 132, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC22()), 219, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC26()), 304, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC27()), 392, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC29()), 481, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC30()), 132, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC31()), 219, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC33()), 392, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC34()), 481, 616, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC53()), 124, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC54()), 160, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC64()), 219, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC74()), 304, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC84()), 392, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC94()), 470, 580, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC121()),132, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC122()),219, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC124()),302, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC126()),380, 543, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC127()),460, 543, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC131()),132, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC132()),255, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC133()),375, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC264()),132, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC274()),219, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC284()),304, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC294()),392, 471, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC321()),132, 435, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC322()),250, 435, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC324()),364, 435, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC326()),480, 435, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC327()),132, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC331()),250, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC332()),364, 412, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC333()),480, 412, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC341()),128, 387, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC342()),162, 387, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC343()),247, 387, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC344()),278, 387, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC345()),367, 387, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC346()),400, 387, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC347()),128, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC348()),162, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC349()),247, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC350()),278, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC351()),367, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC352()),400, 364, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC361()),130, 340, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC362()),244, 340, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC363()),356, 340, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC364()),480, 340, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC365()),130, 316, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC366()),244, 316, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC367()),356, 316, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC368()),480, 316, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC369()),130, 292, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC370()),244, 292, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC371()),356, 292, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC372()),480, 292, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC373()),130, 268, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC374()),244, 268, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC375()),356, 268, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC376()),480, 268, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC377()),130, 244, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC378()),244, 244, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC391()),129, 209, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC392()),170, 209, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC393()),260, 209, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC411()),120, 172, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC412()),172, 172, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC413()),276, 172, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC414()),382, 172, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC415()),492, 172, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC416()),130, 123, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC417()),232, 123, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC418()),336, 123, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC419()),438, 123, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC420()),540, 123, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC421()),130, 88, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC422()),230, 88, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC423()),332, 88, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC431()),130, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC432()),225, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC433()),264, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC434()),343, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC435()),380, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC436()),455, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC437()),497, 51, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC440()),130, 28, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC441()),230, 28, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC442()),331, 28, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC444()),436, 28, 0);
    }
}

