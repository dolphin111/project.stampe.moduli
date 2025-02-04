package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 07/09/15
 * Time: 9.15
 */
public class PU002r3 extends PremioUnico{
    public PU002r3() {
        super();
        cppH= getPostilla("cpph.prodotto.002");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.002PR");
        fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");
        premi= getPostilla("premi.002.r3.PU");
        setCVNG();
        prodotto = "002";
        prodottoConTipoPremio = "002PU";
    }
    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"00203");
    }
}