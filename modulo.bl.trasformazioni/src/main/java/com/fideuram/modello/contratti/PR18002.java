package com.fideuram.modello.contratti;

/**
 * Created by
 *
 * User: logan
 * Date: 01/03/13
 * Time: 11.23
 */
public class PR18002  extends PremioRicorrente{
    public PR18002() {
        super();
        cppH= getPostilla("cpph.prodotto.18002PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.18002PR");
        prodotto = "18002";
        prodottoConTipoPremio = "18002PR";
    }
}
