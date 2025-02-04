package com.fideuram.processo.prospetti.fvpremium;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;
import com.fideuram.costanti.Frasi;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 12/11/13
 * Time: 10.06
 */
@Deprecated
public class FvPremiumSupplementoGenerator extends ProspettoBase {
    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
        doc.getSupplemento().setParte1(true);   //voglio stampare la parte I
        doc.getSupplemento().setParte2(true);    //voglio stampare la parte II
        doc.getSupplemento().setParte3(true);     //voglio stampare la parte III
        doc.getSupplemento().setPremessaParte1(Frasi.getFrase("fv.premium.parte.1"));
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.premium.parte.1.A"));
        doc.getSupplemento().setPremessaParte2(Frasi.getFrase("fv.premium.parte.2"));
        doc.getSupplemento().setPremessaParte3(Frasi.getFrase("fv.premium.parte.3"));
        doc.getSupplemento().setPremessaParte3b(Frasi.getFrase("fv.premium.parte.3b"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.premium.art"));
        pubblicazioneConsob=doc;
        pubblicazioneConsob.setNomeProdotto("Fideuram Vita Insieme Premium");
        percorso=dir;
        return start(FV_SUPPLEMENTO_GENERICO,true);
    }
}
