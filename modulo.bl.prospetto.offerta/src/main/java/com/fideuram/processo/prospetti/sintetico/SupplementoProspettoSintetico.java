package com.fideuram.processo.prospetti.sintetico;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;

import java.io.File;

/**
 * Created by V801068 on 06/06/14.
 */
public class SupplementoProspettoSintetico  extends ProspettoBase {
    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
        pubblicazioneConsob=doc;
        percorso=dir;
        return start(FV_SUPPLEMENTO_SINTETICO_GENERICO,false);
    }
}
