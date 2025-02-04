package com.fideuram.printer.stampa2017.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.fideuram.stampe.modello.redditi.d2017.Cud2017;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag3 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2017 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        
        if(cud.isRettifica())
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        
        propagaCF(cud,pag);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC451()), 130, 747, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC452()), 196, 747, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC453()), 288, 747, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC454()), 354, 747, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC455()), 448, 747, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC456()), 512, 747, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC457()), 130, 711, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC458()), 196, 711, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC459()), 262, 711, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC466()), 406, 711, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC467()), 438, 711, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC468()), 487, 711, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC469()), 520, 711, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC473()), 130, 664, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC475()), 232, 664, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC476()), 412, 664, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC477()), 458, 664, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC478()), 503, 664, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC481()), 130, 627, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC482()), 248, 627, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC483()), 368, 627, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC496()), 134, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC497()), 242, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC498()), 362, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC499()), 474, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC500()), 134, 569, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC501()), 242, 569, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC511()), 138, 520, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC512()), 250, 520, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC513()), 370, 520, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC514()), 486, 520, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC531()), 130, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC532()), 224, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC533()), 310, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC534()), 396, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC535()), 484, 471, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC536()), 130, 447, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC538()), 396, 447, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC539()), 484, 447, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC540()), 130, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC541()), 224, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC542()), 310, 423, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC543()), 396, 423, 0);
         
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC544()), 130, 399, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC545()), 224, 399, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC546()), 310, 399, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC561()), 130, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC562()), 242, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC563()), 358, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC564()), 470, 364, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC571()), 130, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC572()), 185, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC573()), 265, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC574()), 345, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC575()), 425, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC576()), 505, 327, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC577()), 130, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC578()), 185, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC579()), 265, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC580()), 345, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC581()), 425, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC582()), 505, 303, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC583()), 130, 268, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC584()), 235, 268, 0);

        if(cud.getPercettoreSomme().hasFamiliariACarico()){
            FamiliariACarico familiariACarico=cud.getPercettoreSomme().getFamiliariACarico();

            if(null!=familiariACarico.getConiuge()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("X"), 138, 233, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getCf().toUpperCase()),           255, 233, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getNumeroMesiACarico()),          435, 233, 0);
            } if (null!=familiariACarico.getPrimoFiglio()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().isFiglio()),                  138, 221, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getCf().toUpperCase()),       255, 221, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getNumeroMesiACarico()),      435, 221, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getMinoreAnni3()),            470, 221, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazPercSpettante()),    505, 221, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazTotaleAffidamento()),540, 221, 0);
            }

            int riga=209;
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
        }
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC701()), 131, 87, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC702()), 225, 87, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC703()), 297, 87, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC704()), 355, 87, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC705()), 132, 64, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC706()), 354, 64, 0);
        
    }

}