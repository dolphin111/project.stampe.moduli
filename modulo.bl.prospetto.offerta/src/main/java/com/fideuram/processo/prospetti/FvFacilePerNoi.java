package com.fideuram.processo.prospetti;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.sintetico.ProspettoSintetico;
import com.fideuram.processo.prospetti.sintetico.SupplementoProspettoSintetico;

import java.io.File;

/**
 * User: v801068
 * Date: 05/11/14
 * Time: 12.34
 */
public class FvFacilePerNoi extends FvInsiemeFacile{
    public FvFacilePerNoi(String dir) {
        super(dir);
    }

    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new ProspettoSintetico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("La PARTE II dei FV PRIVATE non è prevista. I'm quite sorry");
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("La PARTE III dei FV PRIVATE non è prevista. I'm quite sorry");
    }

    @Override
    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        //doc.setNotaIvass();
        doc.setNomeProdotto("Fideuram Vita Insieme Facile Per Noi"); //TODO VERIFICARE SE GIà INSERITO
        doc.getSupplemento().setArt(Frasi.getFrase("fv.facile.x.noi.art"));
        //solo per i supplementi il puntatoe dei fondi interni deve valere ""

        for (int i=0; i<doc.getSelectionFunds().size(); i++){
            switch (i){
                case 0:
                    doc.getSelectionFunds().get(0).setPuntatore("A)");
                    break;
                case 1:
                    doc.getSelectionFunds().get(1).setPuntatore("B)");
                    break;
                case 2:
                    doc.getSelectionFunds().get(2).setPuntatore("C)");
                    break;
                case 3:
                    doc.getSelectionFunds().get(3).setPuntatore("D)");
                    break;
                case 4:
                    doc.getSelectionFunds().get(4).setPuntatore("E)");
                    break;
                case 5:
                    doc.getSelectionFunds().get(4).setPuntatore("F)");
                    break;
            }
        }
        return new SupplementoProspettoSintetico().generateDocument(doc,temporaryDirecotry);
    }
}
