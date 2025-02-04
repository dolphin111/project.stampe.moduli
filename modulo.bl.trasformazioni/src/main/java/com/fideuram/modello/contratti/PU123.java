package com.fideuram.modello.contratti;

public class PU123 extends PremioUnico {

	public PU123() {
        super();
        prodotto = "123";
        prodottoConTipoPremio = "123PU";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"123");
    }
}
