package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU122 extends PremioUnico{
    public PU122() {
        super();
        prodotto = "122";
        prodottoConTipoPremio = "122PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"122");
    }
}
