package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.30
 */
public class PU35007 extends PremioUnico{
    public PU35007() {
        super();
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.3500XPU");
        cppH= getPostilla("cpph.prodotto.35007PU");
        prodotto = "35007";
        prodottoConTipoPremio = "35007PU";
    }
}
