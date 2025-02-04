package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiduzioneBean;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraRiduzione extends LetteraEngine{


    public LetteraRiduzione(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
     * @param dest
     * @throws CrmStampeException
     */
    public void completaPolizza(Polizza dest) throws  WebServiceClientException {

        //-----------  PRESTAZIONI ASSICURATE -------------------
        TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);

        dest.addAttributo("ipotesiConsiderate", dest.getTroncone("DescrIpotRiduzione")
        					+ " " + dest.getDataUltimaRataPagata());
        dest.addAttributo("descrizioneRiduzione",dest.getTroncone("Riduzione"));
        
        dest.addAttributo("descrizioneACLS", dest.getTroncone("ACLSRiduzione"));

        //-----------  CHIAMATA MOTORE UNIVERSO-------------------
        String polizza = dest.getNumero();
        String dataValutazione = dest.getAttributo("dataValutazione");
        
        WSRiduzioneBean bean = null;
        try {
            bean = uniS.getRiduzione(polizza, dataValutazione);
        } catch (UniversoException e) {
           throw new WebServiceClientException(e);
        }

        if (bean != null) {
            // verificare se l'importo delle PrestazioniVita sono uguali a renditaIniziale restituito dal motore.
        	dest.addAttributo("dataRiferimentoPrestazioniVitaRiduzione", dest.getDataErogazioneRendita());
        	dest.addAttributo("importoPrestazioniVita", bean.getPrestazioneVita());
            dest.addAttributo("importoPrestazioneMorte", bean.getCasoMorteRivalutato());
        }

    }
}
