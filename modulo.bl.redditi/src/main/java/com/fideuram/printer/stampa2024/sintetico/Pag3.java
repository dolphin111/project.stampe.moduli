package com.fideuram.printer.stampa2024.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2024.Cud2024;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag3 extends PaginaBase {

    public void stampa(PdfStamper stamper, Cud2024 cud, int pag) {

        canvas = stamper.getOverContent(pag);//PAG.5

        int anno = 2024;

        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);

        if(cud.isSostituzione())
        {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }

        propagaCF(cud,pag);
        //PREVIDENZA COMPLEMENTARE - NON PRESENTE NEL FILE EXCEL
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC411()),120, 700, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC412()),172, 700, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC413()),276, 700, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC414()),382, 700, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC415()),492, 700, 0);

//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC416()),130, 630, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC417()),232, 630, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC418()),336, 630, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC419()),438, 630, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC420()),540, 630, 0);

//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC421()),130, 580, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC422()),230, 580, 0);
//      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ12().getC423()),332, 580, 0);

      //INCAPIENZA IN SEDE DI CONGUAGLIO

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC455()), 131, 747, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC456()), 196, 747, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC457()), 262, 747, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC458()), 340, 747, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC459()), 420, 747, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC460()), 500, 747, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC461()), 131, 711, 0);

        //ALTRI DATI
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC464()), 420, 555, 0);//2024 REDD. ESENTI COD.
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC465()), 448, 555, 0);//2024 REDD. ESENTI AMMONTARE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC469()), 307, 600, 0);//2024 IRPEF DA TRATTENERE

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC471()), 307, 600, 0);//2024 IRPEF DA VERSARE

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC472()), 192, 711, 0);//APPL. MAGG. RITENUTA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC473()), 380, 711, 0);//CASI PART.
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC474()), 192, 711, 0);//EROGAZ. IN NATURA
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC475()), 480,711, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC476()), 138, 688, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC477()), 176, 688, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC478()), 232, 688, 0);

      	//REDDITI ASSOG. RITENUTA IMPOSTA
        // Aprile 2023 (Engineering): allineata ordinata dei campi con le caselle di testo prestampate (valore aumentato per spostare il testo in alto)
        // ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC481()), 130, 483, 0);//2024 TOT. REDDITI
        // ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC482()), 248, 483, 0);//2024 TOT.RITENUTE IRPEF
        // ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC483()), 368, 483, 0);//2024 TOT. RITENUTE IRPEF SOS.
        int y = 495;
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC481()), 130, y, 0);//2024 TOT. REDDITI
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC482()), 248, y, 0);//2024 TOT.RITENUTE IRPEF
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC483()), 368, y, 0);//2024 TOT. RITENUTE IRPEF SOS.

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC496()), 134, 618, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC497()), 242, 618, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC498()), 364, 618, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC499()), 474, 618, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC500()), 134, 592, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC501()), 242, 592, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC511()), 134, 557, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC512()), 250, 557, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC513()), 365, 557, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC514()), 481, 557, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC531()), 134, 507, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC532()), 226, 507, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC533()), 312, 507, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC534()), 398, 507, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC535()), 486, 507, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC536()), 134, 483, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC538()), 397, 483, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC539()), 485, 483, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC540()), 131, 459, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC541()), 225, 459, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC542()), 311, 459, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC543()), 397, 459, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC544()), 131, 436, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC545()), 225, 436, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC546()), 311, 436, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC561()), 131, 400, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC562()), 243, 400, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC563()), 358, 400, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC564()), 470, 400, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC571()), 131, 364, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC572()), 185, 364, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC573()), 265, 364, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC574()), 345, 364, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC575()), 425, 364, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC576()), 505, 364, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC577()), 131, 339, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC578()), 215, 339, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC579()), 290, 339, 0);
//     //   ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC580()), 345, 347, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC581()), 131, 304, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC582()), 185, 304, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC583()), 265, 304, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC584()), 340, 304, 0);
//        //Parte nuova
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC585()), 424, 304, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC586()), 498, 304, 0);
//
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC587()), 131, 280, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC588()), 214, 280, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC589()), 290, 280, 0);

        //FAMILIARI A CARICO
/*        if(cud.getPercettoreSomme().hasFamiliariACarico()){
            FamiliariACarico familiariACarico=cud.getPercettoreSomme().getFamiliariACarico();

            if(null!=familiariACarico.getConiuge()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("X"), 138, 198, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getCf().toUpperCase()),           255, 198, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getNumeroMesiACarico()),          435, 198, 0);
            } if (null!=familiariACarico.getPrimoFiglio()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().isFiglio()),                  138, 185, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getCf().toUpperCase()),       255, 185, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getNumeroMesiACarico()),      435, 185, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getMinoreAnni3()),            470, 185, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazPercSpettante()),    505, 185, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazTotaleAffidamento()),540, 185, 0);
            }

            int riga=173;
            for(int i=0;i<familiariACarico.getAltri().size();i++){
                Familiare f= familiariACarico.getAltri().get(i);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.isFiglio()),                  138, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.isAltroFamiliare()),          173, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.isDisabile()),                212, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getCf().toUpperCase()),       255, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getNumeroMesiACarico()),      435, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getMinoreAnni3()),            470, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getDetrazPercSpettante()),    505, riga, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getDetrazTotaleAffidamento()),540, riga, 0);
                riga=riga-12;
            }
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPercDetrazioneSpettante()),384, 124, 0);
        }*/

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC701()), 131, 51, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC702()), 225, 51, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC703()), 297, 51, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC704()), 355, 51, 0);

//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC705()), 132, 28, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC706()), 354, 28, 0);

    }

}