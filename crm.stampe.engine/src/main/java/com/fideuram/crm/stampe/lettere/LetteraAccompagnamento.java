package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.utils.LoggingUtils;

public abstract class LetteraAccompagnamento extends LetteraEngine{

    public LetteraAccompagnamento(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void completaPolizza(Polizza dest, boolean root) {

        // leggere descrizioni riduzione per polizze UL anche se non utilizzate

        //-----------  SITUAZIONE PREMI/QUOTE -------------------
        try {
			new TabellaSituazionePremi(comID).impostaTabellaSituazionePremi(dest, root);

		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
            LoggingUtils.error(e);
		} catch (PucException e) {
            LoggingUtils.error(e);
        }

    }

}
