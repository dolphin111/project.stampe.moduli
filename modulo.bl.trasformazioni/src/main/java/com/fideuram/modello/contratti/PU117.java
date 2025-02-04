package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU117 extends PremioUnico{
    public PU117() {
        super();
       // descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.115PU");
        prodotto = "117";
        prodottoConTipoPremio = "117PU"; 
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"117");
    }
}
