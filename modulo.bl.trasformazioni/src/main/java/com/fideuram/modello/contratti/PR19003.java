package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 19/06/15
 * Time: 9.57
 */
public class PR19003 extends  PremioRicorrente{
    public PR19003() {
        super();
        prodotto = "19003";
        prodottoConTipoPremio = "19003PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"19003");
    }
}
