package com.fideuram.printer.stampa2025.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2025.Cud2025;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag2 extends PaginaBase
{
    public void stampa(PdfStamper stamper, Cud2025 cud, int pag) {

        canvas = stamper.getOverContent(pag);//pag.4

        int anno = 2025;

        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);

        if(cud.isSostituzione())
        {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }

        propagaCF(cud,pag);

        int y;

        // CERTIFICAZIONE LAVORO DIPENDENTE, ASSIMILATI ED ASSISTENZA FISCALE

        //DATI FISCALI

        // DATI PER LA EVENTUALE COMPILAZIONE DELLA DICHIARAZIONE DEI REDDITI
        y = 736;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC1()), 132, y, 0); // Redditi di lavoro dipendente e assimilati con contratto a tempo indeterminato
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC2()), 240, y, 0); // Redditi di lavoro dipendente e assimilati con contratto a tempo determinato
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC3()), 348, y, 0); // Redditi di pensione
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC4()), 460, y, 0); // Altri redditi assimilati
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC1"), 132, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC2"), 240, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC3"), 348, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC4"), 460, y, 0);//2025

        // REDDITI
        y = 690;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC5()), 132, y, 0); // Assegni periodici corrisposti dal coniuge
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC6()), 238, y, 0); // Numero di giorni per i quali spettano le detrazioni (Lavoro dipendente)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC7()), 282, y, 0); // Numero di giorni per i quali spettano le detrazioni (Pensione)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC8()), 344, y, 0); // Rapporto di lavoro (Data di inizio)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC9()), 430, y, 0); // Rapporto di lavoro (Data di cessazione)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC10()),506, y, 0); // Rapporto di lavoro (In forza al 31/12)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC11()),532, y, 0); // Rapporto di lavoro (Periodi particolari)
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC5"), 132, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC6"), 238, y, 0);//2025 N.GG LAVORO DIP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC7"), 282, y, 0);//2025 N.GG PENSIONE
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC8"), 344, y, 0);//2025 DATA INIZIO
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC9"), 430, y, 0);//2025 DATA CESSAZIONE
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC10"), 506, y, 0);//2025 IN FORZA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC11"), 532, y, 0);//2025 PERIODI PART.
        //GIO::: 2021 - 28/02/2021
        //GIO::: 2023 - NON PRESENTI
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC13()), 238, 655, 0);//2021 N.GG LAVORO DIP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ5().getC14()), 282, 655, 0);//2021 N.GG LAVORO DIP


        //RITENUTE - 1 RIGA
        y = 615;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC21()), 132, y, 0);//2025 RITENUTE IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC22()), 219, y, 0);//2025 ADD REG IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC26()), 307, y, 0);//2025 ACCONTO 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC27()), 392, y, 0);//2025 SALDO 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC29()), 481, y, 0);//2025 ACCONTO 2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC21"), 132, y, 0);//2025 RITENUTE IRPEF
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC22"), 219, y, 0);//2025 ADD REG IRPEF
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC26"), 307, y, 0);//2025 ACCONTO 2021
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC27"), 392, y, 0);//2025 SALDO 2021
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC29"), 481, y, 0);//2025 ACCONTO 2025

        //RITENUTE - 2 RIGA
        y = 580;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC30()), 132, y, 0);//2025 RIT IRPEF SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC31()), 219, y, 0);//2025 ADD IRPEF SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC33()), 394, y, 0);//2025 ADD COM ACC 2021
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ6().getC34()), 481, y, 0);//2025 ADD COM SALDO 2021
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC30"), 132, y, 0);//2025 RIT IRPEF SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC31"), 219, y, 0);//2025 ADD IRPEF SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC33"), 394, y, 0);//2025 ADD COM ACC 2021
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC34"), 481, y, 0);//2025 ADD COM SALDO 2021


        //ASS. FISC. DICH.
        y = 545;
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC53()), 124, y, 0);//2021 vedere istruzioni
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC54()), 143, y, 0);//2025 PRES 730 INTEGR
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC55()), 179, y, 0);//2025 PRE 730 RETT
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC63()), 255, y, 0);//2025 SALDO IRPEF     - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC73()), 333, y, 0);//2025 ADD REG 	     - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC83()), 410, y, 0);//2025 SALDO ADD 	 	 - Non tratt
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC93()), 490, y, 0);//2025 SALDO CED SECCA - Non tratt
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC54"), 143, y, 0);//2025 PRES 730 INTEGR
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC55"), 179, y, 0);//2025 PRE 730 RETT
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC63"), 255, y, 0);//2025 SALDO IRPEF     - Non tratt
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC73"), 333, y, 0);//2025 ADD REG 	     - Non tratt
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC83"), 410, y, 0);//2025 SALDO ADD 	 	 - Non tratt
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC93"), 490, y, 0);//2025 SALDO CED SECCA - Non tratt

        //CRED. NON RIMB.
        y = 508;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC64()), 132, y, 0);//2025 saldo irpef 	 	  - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC74()), 215, y, 0);//2025 addiz regionale 	  - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC84()), 290, y, 0);//2025 saldo addiz 		  - Non rimb
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC94()), 374, y, 0);//2025 saldo cedolare secca - Non rimb
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC64"), 132, y, 0);//2025 saldo irpef 	 	  - Non rimb
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC74"), 215, y, 0);//2025 addiz regionale 	  - Non rimb
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC84"), 290, y, 0);//2025 saldo addiz 		  - Non rimb
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC94"), 374, y, 0);//2025 saldo cedolare secca - Non rimb


        //ACC. DICH 2021
        y = 471;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC121()),132, y, 0);//2025 PRIMO ACCONTO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC122()),215, y, 0);//2025 SECONDO ACCONTO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC124()),290, y, 0);//2025 ACCONTO ADD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC126()),374, y, 0);//2025 PRIMA RATA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC127()),453, y, 0);//2025 SECONDA RATA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC121"),132, y, 0);//2025 PRIMO ACCONTO
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC122"),215, y, 0);//2025 SECONDO ACCONTO
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC124"),290, y, 0);//2025 ACCONTO ADD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC126"),374, y, 0);//2025 PRIMA RATA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC127"),453, y, 0);//2025 SECONDA RATA

        //ACC. IRPEF
        y = 448;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC131()),132, y, 0);//2025 ACC IRPEF SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC132()),215, y, 0);//2025 ACC ADD IRPEF COM
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ7().getC133()),290, y, 0);//2025 ACC CED SECCA SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC131"),132, y, 0);//2025 ACC IRPEF SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC132"),215, y, 0);//2025 ACC ADD IRPEF COM
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC133"),290, y, 0);//2025 ACC CED SECCA SOSP


        //ASS. FISC. CONIUGE - NON TRATT
        y = 412;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC263()),132, y, 0);//2025 SALDO IRPEF 2020
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC273()),219, y, 0);//2025 ADDIZ REG 2020
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC283()),304, y, 0);//2025 SALDO ADDIZ 2020
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC293()),392, y, 0);//2025 SALDO CED SECCA 2020
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC263"),132, y, 0);//2025 SALDO IRPEF 2020
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC273"),219, y, 0);//2025 ADDIZ REG 2020
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC283"),304, y, 0);//2025 SALDO ADDIZ 2020
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC293"),392, y, 0);//2025 SALDO CED SECCA 2020

        //ASS. FISC. CONIUGE - NON RIMB
        y = 376;
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC264()),132, y, 0);//2025 SALDO IRPEF 2020
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC274()),219, y, 0);//2025 ADDIZ REG 2020
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC284()),304, y, 0);//2025 SALDO ADDIZ 2020
		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC294()),392, y, 0);//2025 SALDO CED SECCA 2020
//		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC264"),132, y, 0);//2025 SALDO IRPEF 2020
//		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC274"),219, y, 0);//2025 ADDIZ REG 2020
//		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC284"),304, y, 0);//2025 SALDO ADDIZ 2020
//		ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC294"),392, y, 0);//2025 SALDO CED SECCA 2020


		//CONIUGE ACC. IRPEF - 1 RIGA
        y = 340;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC321()),132, y, 0);//2025 1 ACC. CONIUGE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC322()),250, y, 0);//2025 2 ACC CONIUGE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC324()),364, y, 0);//2025 ACC ADDIZ IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC326()),480, y, 0);//2025 1 RATA CED SECCA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC321"),132, y, 0);//2025 1 ACC. CONIUGE
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC322"),250, y, 0);//2025 2 ACC CONIUGE
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC324"),364, y, 0);//2025 ACC ADDIZ IRPEF
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC326"),480, y, 0);//2025 1 RATA CED SECCA

        //CONIUGE ACC. IRPEF - 2 RIGA
        y = 316;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC327()),132, y, 0);//2025 2 CED SECCA 	SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC331()),250, y, 0);//2025 ACC IRPEF 		SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC332()),364, y, 0);//2025 ACC ADDIZ COM	SOSP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ9().getC333()),480, y, 0);//2025 ACC CED SECCA 	SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC327"),132, y, 0);//2025 2 CED SECCA 	SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC331"),250, y, 0);//2025 ACC IRPEF 		SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC332"),364, y, 0);//2025 ACC ADDIZ COM	SOSP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC333"),480, y, 0);//2025 ACC CED SECCA 	SOSP


        //ONERI DETRAIBILI - 1 RIGA
        // Aprile 2023 (Engineering): allineata ordinata dei campi con le caselle di testo prestampate
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC341()),128, 327, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC342()),162, 327, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC343()),247, 327, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC344()),278, 327, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC345()),367, 327, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC346()),400, 327, 0);//2025 IMP
        y = 294;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC341()),131, y, 0);//2025 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC342()),163, y, 0);//2025 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC343()),250, y, 0);//2025 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC344()),281, y, 0);//2025 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC345()),368, y, 0);//2025 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC346()),400, y, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC341"),131, y, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC342"),163, y, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC343"),250, y, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC344"),281, y, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC345"),368, y, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC346"),400, y, 0);//2025 IMP

        //ONERI DETRAIBILI - 2 RIGA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC347()),128, 304, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC348()),162, 304, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC349()),247, 304, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC350()),279, 304, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC351()),367, 304, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC352()),400, 304, 0);//2025 IMP
        y = 270;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC347()),131, y, 0);//2025 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC348()),163, y, 0);//2025 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC349()),250, y, 0);//2025 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC350()),281, y, 0);//2025 IMP
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC351()),368, y, 0);//2025 COD
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ10().getC352()),400, y, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC347"),131, y, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC348"),163, y, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC349"),250, y, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC350"),281, y, 0);//2025 IMP
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC351"),368, y, 0);//2025 COD
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC352"),400, y, 0);//2025 IMP
        System.out.println(new Exception().getStackTrace()[0] + ": cud.getDatiFiscali().getQ10().getC351() = " + cud.getDatiFiscali().getQ10().getC351());


        // DETRAZIONI E CREDITI
        // Febbraio 2024 (Engineering): allineate coordinate dei campi con le caselle di testo prestampate
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC361()),131, 245, 0);//2025 IMPOSTA LORDA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC362()),246, 245, 0);//2025 DETRAZ CARICHI FAM
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC363()),356, 245, 0);//2025 DETRAZ FAM NUM
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC364()),472, 245, 0);//2025 CREDITO RIC FAM NUM
        y = 234;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC361()), 132, y, 0); // Imposta lorda
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC362()), 247, y, 0); // Detrazioni per carichi di famiglia
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC367()), 362, y, 0); // Detrazioni per lavoro dipendente, pensioni e redditi assimilati
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC361"), 132, y, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC362"), 247, y, 0);//2025 DETRAZ CARICHI FAM
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC367"), 362, y, 0);//2025 DETRAZ FAM NUM

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC365()),131, 220, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC366()),244, 220, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC367()),356, 220, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC368()),472, 220, 0);//2025

        y = 210;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC369()),132, y, 0);//2025
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC370()),248, y, 0);//2025
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC371()),362, y, 0);//2025
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC372()),472, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC369"),132, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC370"),248, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC371"),362, y, 0);//2025
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC372"),472, y, 0);//2025

        // Febbraio 2024 (Engineering): allineate coordinate dei campi con le caselle di testo prestampate
        y = 183;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC373()),132, y, 0);//2025 CREDITO CANONI LOCAZ
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC374()),249, y, 0);//2025 TOTALE DETRAZ
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC375()),362, y, 0);//2025 IMPOSTA NETTA
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC376()),472, y, 0);//2025 CR. IMPOSTA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC373"),132, y, 0);//2025 CREDITO CANONI LOCAZ
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC374"),249, y, 0);//2025 TOTALE DETRAZ
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC375"),362, y, 0);//2025 IMPOSTA NETTA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC376"),472, y, 0);//2025 CR. IMPOSTA

        //REDD ESTERO / IMPOSTA ESTERO - VERIFICARE
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC377()),131, 160, 0);//2025 COD. STATO EE
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC378()),244, 160, 0);//2025 ANNO REDDITO EE

        // TRATTAMENTO INTEGRATIVO
        y = 89;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC390()),131, y, 0); // Codice trattamento
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC391()),167, y, 0); // Trattamento erogato
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC392()),268, y, 0); // Trattamento non erogato
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC393()),260, 221, 0); // Trattamento recuperato entro le operazioni di conguaglio
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC390"),131, y, 0); // Codice trattamento
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC391"),167, y, 0); // Trattamento erogato
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TESTC392"),268, y, 0); // Trattamento non erogato

        //GIO::: 2023 - TRATTAMENTO INTEGRATIVO (NON ESISTONO)
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC400()),356, 75, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC401()),400, 75, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiFiscali().getQ11().getC402()),472, 75, 0);

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC431()),130, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC432()),225, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC433()),264, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC434()),343, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC435()),380, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC436()),455, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC437()),497, 62, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC440()),130, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC441()),231, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC442()),332, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatiPrevidenziali().getQ13().getC444()),436, 28, 0);
    }
}
