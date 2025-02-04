package com.fideuram.processo.prospetti.fvprivate;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;
import com.fideuram.costanti.Frasi;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 13/11/13
 * Time: 13.57
 */
@Deprecated
public class FvPrivateSupplementoGenerator extends ProspettoBase {
    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
        doc.getSupplemento().setPremessaParte1("");
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.private.parte.1.A"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.private.art"));
        pubblicazioneConsob=doc;
        pubblicazioneConsob.setNomeProdotto("Fideuram Vita Insieme Private");
        percorso=dir;
        return start(FV_SUPPLEMENTO_SINTETICO_GENERICO,false);
        //return start(FV_SUPPLEMENTO_PRIVATE,false);
    }
}
