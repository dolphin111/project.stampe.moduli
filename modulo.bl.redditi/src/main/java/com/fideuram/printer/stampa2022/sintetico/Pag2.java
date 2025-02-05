package com.fideuram.printer.stampa2022.sintetico;


import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2022.Cud2022;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag2 extends PaginaBase
{
    public void stampa(PdfStamper stamper, Cud2022 cud, int pag) {

        canvas = stamper.getOverContent(pag);//pag.4

        int anno = 2022;

        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);

        if(cud.isSostituzione())
        {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }

        propagaCF(cud,pag);
        //DATI FISCALI																						colonna	 riga
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC1()), 132, 736, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC2()), 240, 736, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC3()), 348, 736, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC4()), 460, 736, 0);//2022

        //GIO:::
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC5()), 132, 690, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC6()), 238, 690, 0);//2022 N.GG LAVORO DIP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC7()), 282, 690, 0);//2022 N.GG PENSIONE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC8()), 344, 690, 0);//2022 DATA INIZIO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC9()), 430, 690, 0);//2022 DATA CESSAZIONE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC10()),506, 690, 0);//2022 IN FORZA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC11()),532, 690, 0);//2022 PERIODI PART.
        //GIO::: 2021 - 28/02/2021
        //GIO::: 2022 - NON PRESENTI
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC13()), 238, 655, 0);//2021 N.GG LAVORO DIP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ5().getC14()), 282, 655, 0);//2021 N.GG LAVORO DIP

        //RITENUTE - 1 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC21()), 132, 615, 0);//2022 RITENUTE IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC22()), 219, 615, 0);//2022 ADD REG IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC26()), 307, 615, 0);//2022 ACCONTO 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC27()), 392, 615, 0);//2022 SALDO 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC29()), 481, 615, 0);//2022 ACCONTO 2022
        //RITENUTE - 2 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC30()), 132, 616, 0);//2022 RIT IRPEF SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC31()), 219, 616, 0);//2022 ADD IRPEF SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC33()), 394, 616, 0);//2022 ADD COM ACC 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ6().getC34()), 481, 616, 0);//2022 ADD COM SALDO 2021

        //ASS. FISC. DICH.
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC53()), 124, 580, 0);//2021 vedere istruzioni
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC54()), 165, 580, 0);//2022 PRES 730 INTEGR
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC55()), 165, 580, 0);//2022 PRE 730 RETT
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC63()), 255, 580, 0);//2022 SALDO IRPEF     - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC73()), 333, 580, 0);//2022 ADD REG 	     - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC83()), 410, 580, 0);//2022 SALDO ADD 	 	 - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC93()), 490, 580, 0);//2022 SALDO CED SECCA - Non tratt
        //CRED. NON RIMB.
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC64()), 132, 545, 0);//2022 saldo irpef 	 	  - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC74()), 215, 545, 0);//2022 addiz regionale 	  - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC84()), 290, 545, 0);//2022 saldo addiz 		  - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC94()), 374, 545, 0);//2022 saldo cedolare secca - Non rimb

        //ACC. DICH 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC121()),132, 508, 0);//2022 PRIMO ACCONTO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC122()),215, 508, 0);//2022 SECONDO ACCONTO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC124()),290, 508, 0);//2022 ACCONTO ADD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC126()),374, 508, 0);//2022 PRIMA RATA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC127()),453, 508, 0);//2022 SECONDA RATA
        //ACC. IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC131()),132, 485, 0);//2022 ACC IRPEF SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC132()),215, 485, 0);//2022 ACC ADD IRPEF COM
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ7().getC133()),290, 485, 0);//2022 ACC CED SECCA SOSP

        //ASS. FISC. CONIUGE - NON TRATT
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC263()),132, 447, 0);//2022 SALDO IRPEF 2020
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC273()),219, 447, 0);//2022 ADDIZ REG 2020
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC283()),304, 447, 0);//2022 SALDO ADDIZ 2020
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC293()),392, 447, 0);//2022 SALDO CED SECCA 2020
        //ASS. FISC. CONIUGE - NON RIMB
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC264()),132, 412, 0);//2022 SALDO IRPEF 2020
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC274()),219, 412, 0);//2022 ADDIZ REG 2020
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC284()),304, 412, 0);//2022 SALDO ADDIZ 2020
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC294()),392, 412, 0);//2022 SALDO CED SECCA 2020

		//CONIUGE ACC. IRPEF - 1 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC321()),132, 376, 0);//2022 1 ACC. CONIUGE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC322()),250, 376, 0);//2022 2 ACC CONIUGE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC324()),364, 376, 0);//2022 ACC ADDIZ IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC326()),480, 376, 0);//2022 1 RATA CED SECCA
        //CONIUGE ACC. IRPEF - 2 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC327()),132, 353, 0);//2022 2 CED SECCA 	SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC331()),250, 353, 0);//2022 ACC IRPEF 		SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC332()),364, 353, 0);//2022 ACC ADDIZ COM	SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ9().getC333()),480, 353, 0);//2022 ACC CED SECCA 	SOSP
        //ONERI DETRAIBILI - 1 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC341()),128, 327, 0);//2022 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC342()),162, 327, 0);//2022 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC343()),247, 327, 0);//2022 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC344()),278, 327, 0);//2022 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC345()),367, 327, 0);//2022 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC346()),400, 327, 0);//2022 IMP
        //ONERI DETRAIBILI - 2 RIGA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC347()),128, 304, 0);//2022 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC348()),162, 304, 0);//2022 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC349()),247, 304, 0);//2022 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC350()),279, 304, 0);//2022 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC351()),367, 304, 0);//2022 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ10().getC352()),400, 304, 0);//2022 IMP

        //DETRAZIONI E CREDITI
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC361()),131, 245, 0);//2022 IMPOSTA LORDA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC362()),246, 245, 0);//2022 DETRAZ CARICHI FAM
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC363()),356, 245, 0);//2022 DETRAZ FAM NUM
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC364()),472, 245, 0);//2022 CREDITO RIC FAM NUM

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC365()),131, 220, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC366()),244, 220, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC367()),356, 220, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC368()),472, 220, 0);//2022

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC369()),131, 232, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC370()),244, 232, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC371()),356, 232, 0);//2022
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC372()),472, 232, 0);//2022
        //
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC373()),131, 171, 0);//2022 CREDITO CANONI LOCAZ
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC374()),244, 171, 0);//2022 TOTALE DETRAZ
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC375()),356, 171, 0);//2022 IMPOSTA NETTA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC376()),472, 171, 0);//2022 CR. IMPOSTA

        //REDD ESTERO / IMPOSTA ESTERO - VERIFICARE
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC377()),131, 160, 0);//2022 COD. STATO EE
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC378()),244, 160, 0);//2022 ANNO REDDITO EE

        //GIO::: 2022 CODICE TRATTAMENTO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC390()),127, 75, 0);//2022 COD TRATT
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC391()),127, 75, 0);//2022 TRATT EROGATO - VERIFICARE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC392()),170, 221, 0);//2022 SOLO EXCEL
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC393()),260, 221, 0);//2022  SOLO EXCEL

        //GIO::: 2022 - TRATTAMENTO INTEGRATIVO (NON ESISTONO)
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC400()),356, 75, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC401()),400, 75, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiFiscali().getQ11().getC402()),472, 75, 0);

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