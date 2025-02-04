package com.fideuram.modello.contratti;

/**
 * ED-01-2012
 * User: V801068
 * Date: 25/08/15
 * Time: 15.46
 */
public class PR002r3 extends PremioRicorrente{

    public PR002r3() {
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
        return Integer.decode(codiceDestinazionene+"00203");
    }
}