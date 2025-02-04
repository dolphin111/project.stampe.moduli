package com.fideuram.modello.contratti;

public class PU126 extends PremioUnico {

	public PU126() {
        super();
        prodotto = "126";
        prodottoConTipoPremio = "126PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"126");
    }
}
