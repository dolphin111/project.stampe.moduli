package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.03
 */
public class PremioUnico extends Contratto{
    public PremioUnico() {
        super();
        tipo="PU";
        descrizioneTipo="premio unico";
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.PU");
        premi= getPostilla("premi.PU");
        minimoGarantito =getPostilla("capitale.garantito.PU");
    }
}
