package com.fideuram.modello.contratti;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.26
 */
public class PR113 extends PremioRicorrente{
    public PR113() {
        super();
        //cppH= getPostilla("cpph.prodotto.111PR");
       // fondoInterno=getPostilla("fondo.interno.fap3");
        //commissioneGest=getPostilla("commissione.gest.3");

        descrizioneProdottoOrigine= getPostilla("descrizione.prodotto.113PR");
        premi= getPostilla("premi.113PR");
        //setCVNG();
        prodotto = "113";
        prodottoConTipoPremio = "113PR";
    }

    @Override
    public int getCodiceDestinazionene() {
        return Integer.decode(codiceDestinazionene+"113");
    }
}
