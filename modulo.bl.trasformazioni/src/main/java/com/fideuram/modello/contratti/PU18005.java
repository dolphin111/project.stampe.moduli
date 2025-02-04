package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.30
 */
public class PU18005 extends PremioUnico{
    public PU18005() {
        super();
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.1800XPU");
        cppH= getPostilla("cpph.prodotto.18005PU");
        setCVNG();
        prodotto = "18005";
        prodottoConTipoPremio = "18005PU";
    }
}
