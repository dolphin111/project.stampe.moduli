package com.fideuram.modello.contratti;

/**
 * User: V801068
 * Date: 06/08/15
 * Time: 10.02
 */
public class PR001 extends PremioRicorrente{
    public PR001() {
        super();
        cppH= getPostilla("cpph.prodotto.001PR");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.001PR");
        fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");
        setCVNG();
        prodotto = "001";
        prodottoConTipoPremio = "001PR";
        
    }
    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"001");
    }
}
