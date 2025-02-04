package com.fideuram.modello.contratti;

public class PU112 extends PremioUnico {

	public PU112() {
        super();
        cppH= getPostilla("cpph.prodotto.112PU");
        //fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");

        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.112PU");
        premi= getPostilla("premi.112PU");
        //setCVNG();
        prodotto = "112";
        prodottoConTipoPremio = "112PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"112");
    }
}
