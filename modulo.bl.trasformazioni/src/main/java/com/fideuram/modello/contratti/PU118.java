package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU118 extends PremioUnico{
    public PU118() {
        super();
        prodotto = "118";
        prodottoConTipoPremio = "118PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"118");
    }
}
