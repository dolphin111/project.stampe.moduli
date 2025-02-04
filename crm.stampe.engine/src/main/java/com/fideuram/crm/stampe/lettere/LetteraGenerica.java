package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.AbstractLettera;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.utils.LoggingUtils;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraGenerica extends LetteraEngine{

    public LetteraGenerica(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
     * @param dest
     * @param root
     */
    public void completaPolizza(int comunicazione, Polizza dest, boolean root) {

        //-----------  SITUAZIONE PREMI/QUOTE -------------------
        try {
			new TabellaSituazionePremi(comunicazione).impostaTabellaSituazionePremi(dest, root);

		} catch (WebServiceClientException e) {
            LoggingUtils.error(e);
		} catch (PucException e) {
            LoggingUtils.error(e);
        }

        //-----------  PRESTAZIONI ASSICURATE -------------------
        if (dest.getEccedenza() != null && !dest.getEccedenza().isEmpty()) {
            impostaRigaCapitaleDifferito(dest);
        } else {
            TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);
        }
        
        //-----------  VINCOLO/PEGNO -------------------
        DescrizioniComuni.impostaVincoloPegno(dest);
    }


    /**
     * @param dest
     */
    private static void impostaRigaCapitaleDifferito(Polizza dest) {

        dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataScadenza());
        dest.addAttributo("importoPrestazioniVita", dest.getEccedenza());
        
        String descrizionePrestazioniVita = dest.getTroncone("EccedenzaCapitaleDifferitosenzaContrass") + " ";
        
        if (dest.getLiquidazioni() != null && !dest.getLiquidazioni().isEmpty()) {
            descrizionePrestazioniVita += 
            	dest.getLiquidazioni().get(0).getData() + ".";
        }
        
        dest.addAttributo("descrizionePrestazioniVita", descrizionePrestazioniVita);
    }
}