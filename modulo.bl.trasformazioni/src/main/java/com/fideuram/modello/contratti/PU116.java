package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU116 extends PremioUnico{
    public PU116() {
        super();
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.115PU");
        prodotto = "116";
        prodottoConTipoPremio = "116PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"116");
    }
}
