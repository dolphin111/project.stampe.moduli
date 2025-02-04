package com.fideuram.processo.prospetti.generico;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;


import java.io.File;


/**
 * Created with
 * User: v801068
 * Date: 13/03/14
 * Time: 18.07
 */
public class RendicontoGenerico extends ProspettoBase {

    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
        pubblicazioneConsob=doc;
        percorso=dir;
        return start(RENDICONTO_PROSPETTO,true);
    }


}
