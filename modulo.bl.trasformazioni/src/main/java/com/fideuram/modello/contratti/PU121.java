package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU121 extends PremioUnico{
    public PU121() {
        super();
        prodotto = "121";
        prodottoConTipoPremio = "121PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"121");
    }
}
