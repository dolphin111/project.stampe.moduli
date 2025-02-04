package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.30
 */
public class PU18002 extends PremioUnico{
    public PU18002() {
        super();
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.1800XPU");
        cppH= getPostilla("cpph.prodotto.18002PU");
        prodotto = "18002";
        prodottoConTipoPremio = "18002PU";
    }
}
