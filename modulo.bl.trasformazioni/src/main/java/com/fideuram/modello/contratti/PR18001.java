package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.18
 */
public class PR18001 extends PremioRicorrente{
    public PR18001() {
        super();
        cppH= getPostilla("cpph.prodotto.18001PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.18001PR");
        prodotto = "18001";
        prodottoConTipoPremio = "18001PR";
    }


}
