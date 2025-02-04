package com.fideuram.modello.contratti;

public class PR124 extends PremioRicorrente {

	public PR124() {
        super();
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.124PR");
        premi= getPostilla("premi.124PR");
        prodotto = "124";
        prodottoConTipoPremio = "124PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"124");
    }
}
