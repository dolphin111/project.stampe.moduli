package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.26
 */
public class PR35005 extends PremioRicorrente{
    public PR35005() {
        super();
        cppH= getPostilla("cpph.prodotto.35005PR");
        prestazioneDecesso=getPostilla("prestazione.decesso");
        commissioneGest=getPostilla("commissione.gest.2");
        coefficienteRiscatto=getPostilla("coefficiente.riscatto.35005PR");
        fondoInterno=getPostilla("fondo.interno.ful2");
        prodotto = "35005";
        prodottoConTipoPremio = "35005PR";
    }
}
