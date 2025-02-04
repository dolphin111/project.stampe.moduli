package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU115 extends PremioUnico{
    public PU115() {
        super();
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.115PU");
        prodotto = "115";
        prodottoConTipoPremio = "115PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"115");
    }
}
