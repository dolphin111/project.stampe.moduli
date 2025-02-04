package com.fideuram.processo.prospetti.generico;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 14/03/14
 * Time: 9.37
 */
public class SupplementoProspetti extends ProspettoBase {
    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
        doc.getSupplemento().setParte1(true);   //voglio stampare la parte I
        doc.getSupplemento().setParte2(true);   //voglio stampare la parte II
        doc.getSupplemento().setParte3(true);   //voglio stampare la parte III
        pubblicazioneConsob=doc;
        percorso=dir;
        return start(FV_SUPPLEMENTO_GENERICO,true);
    }
}
