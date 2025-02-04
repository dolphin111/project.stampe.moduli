// Nuova classe Engineering Aprile 2024
package com.fideuram.printer.stampa2025.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2025.Cud2025;
import com.fideuram.stampe.modello.redditi.d2025.redditidiversi.GestioneSeparata;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

public class Pag6 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2025 cud, int pag) {
        canvas = stamper.getOverContent(pag);

        int anno = 2025;

        System.out.println("***************pagina modello cud (anno " + anno + "): " + pag);

        if(cud.isRettifica())         {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }

        propagaCF(cud,pag);

        GestioneSeparata g =cud.getGestioneSeparata();
        int y;

        // prima riga
        y = 569;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC801()), 136, y, 0);	//2021	-	Indennita', acconti, anticipazioni e somme erogate nell'anno
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC802()), 222, y, 0);	//2021	-	Acconti ed anticipazioni erogate anni prec.
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC803()), 308, y, 0);	//2021	-	Detrazione
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC804()), 394, y, 0);	//2021	-	Ritenuta netta operata nell'anno
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC805()), 480, y, 0);	//2021	-	Ritenute sspese

        // seconda riga
        y = 545;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC806()), 136, y, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC807()), 222, y, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC808()), 308, y, 0);	//2021	-	Quota spettante per le indennita' erogate ai sensi dell'art.2122 c.c.
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC809()), 394, y, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC810()), 480, y, 0);

        // terza riga
        y = 522;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC811()), 136, y, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC812()), 222, y, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC813()), 308, y, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC920()), 394, y, 0);
    }
}
