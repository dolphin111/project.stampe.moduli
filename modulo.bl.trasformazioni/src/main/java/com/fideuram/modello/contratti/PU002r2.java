package com.fideuram.modello.contratti;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 04/09/15
 * Time: 16.55
 * To change this template use File | Settings | File Templates.
 */
public class PU002r2  extends PremioUnico{
    public PU002r2() {
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
        return Integer.decode(codiceDestinazionene+"00202");
    }
}