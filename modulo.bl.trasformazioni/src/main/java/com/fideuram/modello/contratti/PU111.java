package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PU111 extends PremioUnico{
    public PU111() {
        super();
        cppH= getPostilla("cpph.prodotto.111PU");
        //fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");

        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.111PU");
        premi= getPostilla("premi.111PU");
        //setCVNG();
        prodotto = "111";
        prodottoConTipoPremio = "111PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"112");
    }
}
