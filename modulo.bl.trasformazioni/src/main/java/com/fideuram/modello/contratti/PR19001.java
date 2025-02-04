package com.fideuram.modello.contratti;


/**
 * User: V801068
 * Date: 19/06/15
 * Time: 9.54
 */
public class PR19001 extends PremioRicorrente{
    public PR19001() {
        super();
        //cppH= getPostilla("cpph.prodotto.18001PR");
        //coefficienteRiscatto=getPostilla("coefficiente.riscatto.18001PR");
        coefficienteRiscatto="";
        prodotto = "19001";
        prodottoConTipoPremio = "19001PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"19001");
    }
}
