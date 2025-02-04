package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.30
 */
public class PU35005 extends PremioUnico{
    public PU35005() {
        super();
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.3500XPU");
        cppH= getPostilla("cpph.prodotto.35005PU");
        prestazioneDecesso=getPostilla("prestazione.decesso");
        commissioneGest=getPostilla("commissione.gest.2");
        fondoInterno=getPostilla("fondo.interno.ful2");
        prodotto = "35005";
        prodottoConTipoPremio = "35005PU";
    }
}
