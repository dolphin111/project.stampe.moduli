package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU114 extends PremioUnico{
    public PU114() {
        super();
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.114PU");
        prodotto = "114";
        prodottoConTipoPremio = "114PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"114");
    }
}
