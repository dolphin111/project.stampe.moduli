package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.26
 */
public class PR35007 extends PremioRicorrente{
    public PR35007() {
        super();
        cppH= getPostilla("cpph.prodotto.35007PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.35007PR");
        prodotto = "35007";
        prodottoConTipoPremio = "35007PR";
    }
}
