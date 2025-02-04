package com.fideuram.crm.stampe.lettere;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fideuram.crm.stampe.generatori.AbstractLettera;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.MassimoControvaloreVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.LoggingUtils;

public class LetteraMassimoValoreUL extends LetteraEngine{

	public LetteraMassimoValoreUL(int comID) throws WebServiceClientException {
		super(comID);
		// TODO Auto-generated constructor stub
	}
	
	public void completaPolizza(int comunicazione, Polizza dest, boolean root) throws PucException {

		StampeServiceImpl pucClient;
		try {
			pucClient = (StampeServiceImpl) new ClientWs().getPucClient(comunicazione);
			getMassimoValoreUl(pucClient, dest);
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PucException e) {
			LoggingUtils.error(e);
		}

	}
	
	private static void getMassimoValoreUl(StampeServiceImpl service,
			Polizza targetPolizza) throws PucException {

		Date data = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyy");
		String dataFine = df.format(data);

		int dataInizio = getAnnoPrecedente(dataFine);
		MassimoControvaloreVO massimoCVO; 
		try {
			massimoCVO = service.getMassimoControvalorePolizza(dataInizio, new Long(targetPolizza
					.getNumero()));
		} catch (ServiceException_Exception e) {
			throw new PucException(e);
		}
		if ((massimoCVO == null))
			return;

		targetPolizza.setMassimoValoreUl(massimoCVO.getControvalore());

	}

	private static int getAnnoPrecedente(String dataFine) {
		int annoPrecedente = Integer.parseInt(dataFine.substring(0, 4))-1;
		return annoPrecedente;
	}
	
	

}
