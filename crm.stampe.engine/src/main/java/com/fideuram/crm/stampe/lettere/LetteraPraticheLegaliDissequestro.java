package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.PraticheLegaliDissequestro;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.log.Log4j1Utils;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return;

public class LetteraPraticheLegaliDissequestro extends LetteraEngine {

	public LetteraPraticheLegaliDissequestro(int comID) throws WebServiceClientException {
		super(comID);
	}

	/**
	 * @param dest
	 * @param dom
	 *
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom) {

		PraticheLegaliDissequestro pratica = new PraticheLegaliDissequestro();

		try {

			Return datiSintetici = pucS
					.getDatiSinteticiPolizza(Long.parseLong(dest.getNumero()));

			pratica.setNumeroPolizza(dest.getNumero());
			pratica.setContraente(datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getCognome()
					.trim() + " "
					+ datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getNome().trim());

		} catch (Exception ex) {
			ex.printStackTrace();
			Log4j1Utils.error(ex);
		}

		dest.setPraticheLegaliDissequestro(pratica);

	}

}
