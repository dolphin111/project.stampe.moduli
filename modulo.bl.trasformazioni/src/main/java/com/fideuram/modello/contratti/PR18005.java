package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.25
 */
public class PR18005 extends PremioRicorrente{
    public PR18005() {
        super();
        cppH= getPostilla("cpph.prodotto.18005PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.18005PR");
        setCVNG();
        prodotto = "18005";
        prodottoConTipoPremio = "18005PR";
    }
}
