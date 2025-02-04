package com.fideuram.modello.contratti;

public class PR125 extends PremioRicorrente {

	public PR125() {
        super();
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.125PR");
        premi= getPostilla("premi.125PR");
        prodotto = "125";
        prodottoConTipoPremio = "125PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"125");
    }
}
