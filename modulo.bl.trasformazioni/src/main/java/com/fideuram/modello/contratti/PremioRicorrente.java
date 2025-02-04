package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.04
 */
public class PremioRicorrente extends Contratto{

    public PremioRicorrente() {
        super();
        tipo="PR";
        descrizioneTipo="premio unico ricorrente";
        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.PR");
        premi= getPostilla("premi.PR");
        prestazioniSopravvivenza= getPostilla("prestazioni.sopravvissuto");
        minimoGarantito0 =getPostilla("capitale.garantito.0");
        minimoGarantito =getPostilla("capitale.garantito.PR");
        opzioneTroncone=getPostilla("opzioni.a1.a2.b1.xxxxxPR");
        opzioneTroncone3=getPostilla("opzioni.troncone.PR");
    }
}
