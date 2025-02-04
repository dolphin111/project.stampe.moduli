package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.24
 */
public class PR18003  extends PremioRicorrente{
    public PR18003() {
        super();
        cppH= getPostilla("cpph.prodotto.18003PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.18003PR");
        setCVNG();
        prodotto = "18003";
        prodottoConTipoPremio = "18003PR";
    }
}
