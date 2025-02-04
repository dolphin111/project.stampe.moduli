package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 04/09/15
 * Time: 16.54
 */
public class PR002r2 extends PremioRicorrente{
    public PR002r2() {
        super();
        cppH= getPostilla("cpph.prodotto.002");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.002PR");
        fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");
        setCVNG();
        prodotto = "002";
        prodottoConTipoPremio = "002PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"00202");
    }
}