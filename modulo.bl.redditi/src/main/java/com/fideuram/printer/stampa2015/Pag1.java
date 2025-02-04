package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.ResidenzaEstero;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 21/01/15
 * Time: 16.09
 */
public class Pag1 extends PaginaBase {
    public void stampa(PdfStamper stamper,Cud2015 cud,int pag){
            canvas = stamper.getOverContent(pag); //Pagina 1
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCf()), 122, 617, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCognome()),                                  268, 617, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getNome()),                                     442, 617, 0);

            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getSesso()),                                    122, 580, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDataNascita()),                              152, 580, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getComuneNascita()),                            230, 580, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getProvinciaNascita()),                         360, 580, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCategorieParticolari()),                     440, 580, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getEventiEccezionali()),                        483, 580, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCasiEsclusione()),                           526, 580, 0);

            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getComune()),             122, 545, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getProvincia()),          475, 545, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getCodiceComune()),       525, 545, 0);

            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getComune()),                    122, 510, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getProvincia()),                 475, 510, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getCodiceComune()),              525, 510, 0);

            if(null!=cud.getPercettoreSomme().getRappresentante())
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getRappresentante().getCf().toUpperCase()),     122, 475, 0);
            if(null!=cud.getPercettoreSomme().getResidenzaEstero())
                stampaRiferimentoEstro(canvas, cud.getPercettoreSomme().getResidenzaEstero());
    }

    private void stampaRiferimentoEstro(PdfContentByte canvas,ResidenzaEstero re){
        if(null!=re){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getCfEstero().toUpperCase()),           122, 438, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getLocalita().toUpperCase()),           259, 438, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getViaenumero().toUpperCase()),         122, 403, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getCodiceStatoEstero().toUpperCase()),  525, 403, 0);
        }
    }
}
