package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 19/06/15
 * Time: 9.55
 */
public class PR19002 extends PremioRicorrente{
    public PR19002() {
        super();
        prodotto = "19002";
        prodottoConTipoPremio = "19002PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"19002");
    }
}
