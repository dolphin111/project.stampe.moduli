package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU120 extends PremioUnico{
    public PU120() {
        super();
        prodotto = "120";
        prodottoConTipoPremio = "120PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"120");
    }
}
