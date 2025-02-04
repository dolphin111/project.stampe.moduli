package com.fideuram.processo.prospetti.generico;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 13/03/14
 * Time: 18.17
 */
public class AllegatoParteIGenerico extends ProspettoBase {
    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
        pubblicazioneConsob=doc;
        percorso=dir;
        return start(FV_GENERICO_PART_I,false);
    }
}
