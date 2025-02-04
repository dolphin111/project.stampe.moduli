package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.AbstractLettera;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.utils.LoggingUtils;


public class LetteraCreditLine extends LetteraEngine{

	public LetteraCreditLine(int comID) throws WebServiceClientException {
		super(comID);
		// TODO Auto-generated constructor stub
	}
	
	public void completaPolizza(int comunicazione, Polizza dest, boolean root) {

		//-----------  SITUAZIONE PREMI/QUOTE -------------------
		try {
			new DatiSintetici(comunicazione).impostaDatiSintetici(dest, root);
		} catch (WebServiceClientException e) {
			LoggingUtils.error(e);
		} catch (PucException e) {
			LoggingUtils.error(e);
		}

	}

}
