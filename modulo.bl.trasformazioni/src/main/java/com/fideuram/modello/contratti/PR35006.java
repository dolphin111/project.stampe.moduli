package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.26
 */
public class PR35006 extends PremioRicorrente{
    public PR35006() {
        super();
        cppH= getPostilla("cpph.prodotto.35006PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.35006PR");
        prodotto = "35006";
        prodottoConTipoPremio = "35006PR";
    }
}
