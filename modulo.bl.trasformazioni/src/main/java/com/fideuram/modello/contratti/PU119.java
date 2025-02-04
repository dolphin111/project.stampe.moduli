package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU119 extends PremioUnico{
    public PU119() {
        super();
        prodotto = "119";
        prodottoConTipoPremio = "119PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"119");
    }
}
