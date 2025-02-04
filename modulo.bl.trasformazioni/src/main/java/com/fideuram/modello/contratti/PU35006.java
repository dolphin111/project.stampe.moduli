package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.30
 */
public class PU35006 extends PremioUnico{
    public PU35006() {
        super();
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.3500XPU");
        cppH= getPostilla("cpph.prodotto.35006PU");
        prodotto = "35006";
        prodottoConTipoPremio = "35006PU";
    }
}
