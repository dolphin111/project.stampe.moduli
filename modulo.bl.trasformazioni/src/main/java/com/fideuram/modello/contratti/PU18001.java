package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.30
 */
public class PU18001 extends PremioUnico{
    public PU18001() {
        super();
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.1800XPU");
        cppH= getPostilla("cpph.prodotto.18001PU");
        prodotto = "18001";
        prodottoConTipoPremio = "18001PU";
    }
}
