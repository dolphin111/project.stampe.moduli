package com.fideuram.printer.stampa2016.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.stampe.modello.redditi.d2016.redditidiversi.GestioneSeparata;
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
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC451()), 130, 758, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC452()), 196, 758, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC453()), 288, 758, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC454()), 354, 758, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC455()), 448, 758, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC456()), 512, 758, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC457()), 130, 722, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC458()), 196, 722, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC459()), 278, 722, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC466()), 358, 722, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC467()), 388, 722, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC468()), 448, 722, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC469()), 480, 722, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC472()), 130, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC474()), 232, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC475()), 366, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC476()), 422, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ14().getC477()), 482, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC481()), 130, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC482()), 248, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC483()), 368, 652, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC496()), 134, 614, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC497()), 242, 614, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC498()), 362, 614, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC499()), 474, 614, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC500()), 134, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ15().getC501()), 242, 592, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC511()), 138, 532, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC512()), 250, 532, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC513()), 370, 532, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ16().getC514()), 486, 532, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC531()), 130, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC532()), 220, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC533()), 310, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC534()), 396, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC535()), 484, 484, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC536()), 130, 460, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC538()), 130, 422, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC539()), 220, 422, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC540()), 310, 422, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC541()), 396, 422, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC542()), 484, 422, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC543()), 130, 398, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC544()), 242, 398, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC545()), 358, 398, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC546()), 470, 398, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC561()), 130, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC562()), 242, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC563()), 358, 364, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getDatiPrevidenziali().getQ17().getC564()), 470, 364, 0);

        if(cud.getPercettoreSomme().hasFamiliariACarico()){
            FamiliariACarico familiariACarico=cud.getPercettoreSomme().getFamiliariACarico();

            if(null!=familiariACarico.getConiuge()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("X"), 138, 328, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getCf().toUpperCase()),           255, 328, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getNumeroMesiACarico()),          435, 328, 0);
            } if (null!=familiariACarico.getPrimoFiglio()){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().isFiglio()),                  138, 316, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getCf().toUpperCase()),       255, 316, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getNumeroMesiACarico()),      435, 316, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getMinoreAnni3()),            470, 316, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazPercSpettante()),    505, 316, 0);
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazTotaleAffidamento()),540, 316, 0);
            }

            int riga=304;
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
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPercDetrazioneSpettante()),388, 220, 0);
        }
        GestioneSeparata g=cud.getGestioneSeparata();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC801()), 136, 170, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC802()), 222, 170, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC803()), 308, 170, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC804()), 394, 170, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC805()), 480, 170, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC806()), 136, 146, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC807()), 222, 146, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC808()), 308, 146, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC809()), 394, 146, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC810()), 480, 146, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC811()), 136, 122, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC812()), 222, 122, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC813()), 308, 122, 0);
    }

}
