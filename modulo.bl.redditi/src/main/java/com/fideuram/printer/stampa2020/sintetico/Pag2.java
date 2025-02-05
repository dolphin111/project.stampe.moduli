package com.fideuram.printer.stampa2020.sintetico;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2020.Cud2020;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag2 extends PaginaBase
{
    public void stampa(PdfStamper stamper, Cud2020 cud, int pag) {

        canvas = stamper.getOverContent(pag);//pag.4

        int anno = 2020;

        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);

        if(cud.isSostituzione())
        {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }

        propagaCF(cud,pag);
        //DATI FISCALI
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC1()), 132, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC2()), 240, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC3()), 348, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC4()), 460, 736, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC5()), 132, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC6()), 238, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC7()), 282, 690, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC8()), 344, 690, 0);//DATA INIZIO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC9()), 430, 690, 0);//DATA CESSAZIONE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC10()),506, 690, 0);//IN FORZA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC11()),532, 690, 0);//PERIODI PART.
        //RITENUTE - 1 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC21()), 132, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC22()), 219, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC26()), 307, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC27()), 392, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC29()), 481, 652, 0);
        //RITENUTE - 2 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC30()), 132, 616, 0);//132: COLONNA	616: RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC31()), 219, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC33()), 394, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC34()), 481, 616, 0);
        //ASS. FISC. DICH.
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC53()), 124, 580, 0);//vedere istruzioni
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC54()), 165, 580, 0);//presenza 730
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC55()), 165, 580, 0);//C55
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC63()), 255, 580, 0);//saldo irpef - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC73()), 333, 580, 0);//addiz regionale - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC83()), 410, 580, 0);//saldo addiz - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC93()), 490, 580, 0);//saldo cedolare secca - Non tratt
        //CRED. NON RIMB.
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC64()), 132, 545, 0);//saldo irpef - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC74()), 215, 545, 0);//addiz regionale - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC84()), 290, 545, 0);//saldo addiz - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC94()), 374, 545, 0);//saldo cedolare secca - Non rimb
        //ACC. DICH 2019
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC121()),132, 508, 0);//riga da 545 a 519
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC122()),215, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC124()),290, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC126()),374, 508, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC127()),453, 508, 0);
        //ACC. IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC131()),132, 485, 0);//OK!
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC132()),215, 485, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC133()),290, 485, 0);
        //ASS. FISC. CONIUGE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC264()),132, 447, 0);//SALDO IRPEF 	NN TR. OK!!
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC273()),219, 447, 0);//ADDIZ REG 		NN TR.
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC283()),304, 447, 0);//SALDO ADDIZ 	NN TR.
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC293()),392, 447, 0);//SALDO CED SECCA NN TR.

		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC263()),132, 412, 0);//SALDO IRPEF 	NN RIMB. OK!!
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC274()),219, 412, 0);//ADDIZ REG 		NN RIMB.
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC284()),304, 412, 0);//SALDO ADDIZ 	NN RIMB.
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC294()),392, 412, 0);//SALDO CED SECCA NN RIMB.
        //CONIUGE ACC. IRPEF - 1 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC321()),132, 376, 0);//1 ACC. CONIUGE			OK!!
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC322()),250, 376, 0);//2 ACC CONIUGE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC324()),364, 376, 0);//ACC ADDIZ IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC326()),480, 376, 0);//1 RATA CED SECCA
        //CONIUGE ACC. IRPEF - 2 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC327()),132, 353, 0);//2 CED SECCA 	SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC331()),250, 353, 0);//ACC IRPEF 		SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC332()),364, 353, 0);//ACC ADDIZ COM	SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC333()),480, 353, 0);//ACC CED SECCA 	SOSP
        //ONERI DETRAIBILI - 1 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC341()),128, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC342()),162, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC343()),247, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC344()),278, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC345()),367, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC346()),400, 327, 0);
        //ONERI DETRAIBILI - 2 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC347()),128, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC348()),162, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC349()),247, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC350()),279, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC351()),367, 304, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC352()),400, 304, 0);
        //DETRAZIONI E CREDITI
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC361()),131, 280, 0);		//OK!!
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC362()),244, 280, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC363()),356, 280, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC364()),472, 280, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC365()),131, 256, 0);		//OK!!
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC366()),244, 256, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC367()),356, 256, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC368()),472, 256, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC369()),131, 232, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC370()),244, 232, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC371()),356, 232, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC372()),472, 232, 0);
        //TOT DETRAZIONI
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC373()),131, 208, 0);//TOT DETRAZ
        //ESTERO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC374()),244, 208, 0);//CR. IMP. ESTERO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC375()),356, 208, 0);//COD. EE ESTERO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC376()),472, 208, 0);//ANNO ESTERO
        //REDD ESTERO / IMPOSTA ESTERO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC377()),131, 184, 0);//REDD. ESTERO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC378()),244, 184, 0);//IMPOSTA ESTERO
        //CODICE BONUS
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC391()),127, 112, 0);//	OK!!
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC392()),170, 221, 0);//ASSENTE EXCEL
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC393()),260, 221, 0);//ASSENTE EXCEL

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC431()),130, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC432()),225, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC433()),264, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC434()),343, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC435()),380, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC436()),455, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC437()),497, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC440()),130, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC441()),231, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC442()),332, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ13().getC444()),436, 28, 0);
    }
}