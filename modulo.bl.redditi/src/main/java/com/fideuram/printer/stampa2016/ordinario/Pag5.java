package com.fideuram.printer.stampa2016.ordinario;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 15/01/16
 * Time: 14.48
 */
public class Pag5  extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2016 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC531()), 130, 748, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC532()), 220, 748, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC533()), 310, 748, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC534()), 396, 748, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC535()), 484, 748, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC536()), 130, 724, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC537()), 350, 724, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC538()), 396, 724, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC539()), 484, 724, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC540()), 130, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC541()), 220, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC542()), 310, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC543()), 396, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC544()), 484, 700, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC545()), 130, 676 , 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC546()), 220, 676 , 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC547()), 130, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC548()), 248, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC549()), 366, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC550()), 482, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC551()), 130, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC552()), 160, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC553()), 236, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC554()), 268 ,616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC561()), 132, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC562()), 242, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC563()), 354, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC564()), 462, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC565()), 132, 546, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC566()), 220, 546, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC571()), 132, 519, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ18().getC572()), 374, 519, 0);
        if(cud.getPercettoreSomme().hasFamiliariACarico()){
            FamiliariACarico familiariACarico=cud.getPercettoreSomme().getFamiliariACarico();

            if(null!=familiariACarico.getConiuge()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("X"), 138, 486, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getCf().toUpperCase()),           255, 486, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getNumeroMesiACarico()),          435, 486, 0);
            } if (null!=familiariACarico.getPrimoFiglio()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().isFiglio()),                  138, 473, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getCf().toUpperCase()),       255, 473, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getNumeroMesiACarico()),      435, 473, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getMinoreAnni3()),            470, 473, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazPercSpettante()),    505, 473, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazTotaleAffidamento()),540, 473, 0);
            }

            int riga=460;
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
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPercDetrazioneSpettante()),388, 376, 0);
            //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("100"),388,376, 0);
        }

    }
}
