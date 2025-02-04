package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.26
 */
public class PR111 extends PremioRicorrente{
    public PR111() {
        super();
        cppH= getPostilla("cpph.prodotto.111PR");
       // fondoInterno=getPostilla("fondo.interno.fap3");
        commissioneGest=getPostilla("commissione.gest.3");

        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.111PR");
        premi= getPostilla("premi.111PR");
        //setCVNG();
        prodotto = "111";
        prodottoConTipoPremio = "111PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"111");
    }
}
