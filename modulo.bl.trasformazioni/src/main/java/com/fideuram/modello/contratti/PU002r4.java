package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 07/09/15
 * Time: 10.31
 */
public class PU002r4 extends PremioUnico{
    public PU002r4() {
        super();
        cppH= getPostilla("cpph.prodotto.002");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.002PR");
        fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");
        setCVNG();
        prodotto = "002";
        prodottoConTipoPremio = "002PU";
    }
    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"00204");
    }
}