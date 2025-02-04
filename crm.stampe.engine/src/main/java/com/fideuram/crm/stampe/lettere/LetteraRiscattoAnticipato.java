package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.utils.LoggingUtils;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraRiscattoAnticipato extends LetteraEngine {

    public LetteraRiscattoAnticipato(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza dest) throws WebServiceClientException, StampeInfoException, PucException, DaoException {

		Integer indicatoreTipoRisc = new Integer(2);
		String dataValutazione = dest.getAttributo("dataValutazione");
		dest.addAttributo("dataValutazione", dataValutazione);

		//-----------  CHIAMATA MOTORE UNIVERSO-------------------

        new DescrizioniComuni(comID).impostaDatiRiscatto(dest,dataValutazione,indicatoreTipoRisc);


        //-----------  DICITURA ANTICIPATO SU COLONNA TABELLA ------
		impostaLabelRiscattoAnticipato(dest);

		//-----------  PRESTAZIONI ASSICURATE -------------------
//		TabellaValoreRiscattoAnticipato.impostaTabellaValoreRiscatto(dest);
		try {
			new TabellaValoreRiscattoAnticipato(comID).impostaTabellaValoreRiscatto(dest);
		} catch (WebServiceClientException e) {
            LoggingUtils.error(e);
		} catch (PucException e) {
            LoggingUtils.error(e);
        }

		//-----------  VINCOLO/PEGNO -------------------
		DescrizioniComuni.impostaVincoloPegno(dest);

		//-----------  CATEGORIA MINISTERIALE per Documentazione Riscatto-------------------
		getCategoriaMinisteriale(dest);

		//-----------  RETE VENDITA per Documentazione Riscatto-------------------
		dest.addAttributo("ReteVendita", dest.getReteVendita());     

	}


	/**
	 * @param dest
	 */
	public static void impostaLabelRiscattoAnticipato(Polizza dest) {

		// LABEL DESCRIZIONE COLONNA TABELLA PER COMPLEMENTARI
		dest.addAttributo("labelRiscattoAnticipato", "");

		if (!"AF".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.addAttributo("labelRiscattoAnticipato", "ANTICIPATO");
		}

	}

	/**
	 * @param dest
	 */
	private static void getCategoriaMinisteriale(Polizza dest) {

		dest.addAttributo("categoriaMinisteriale", "");
		
		if ("F40A".equalsIgnoreCase(dest.getCodiceTariffa().trim())) {
			dest.addAttributo("categoriaMinisteriale", "prod.80");
		}

		// oppure fondo = FAP and Rendita
		if ("R".equalsIgnoreCase(dest.getTipoPrestazione()) 
				&& "FAP".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())) {
			
			dest.addAttributo("categoriaMinisteriale", "prod.38");
			
			if (dest.getConferimento() != null 
					&& dest.getConferimento().length() > 8) 
			{            
				String codconfstr = 
					dest.getConferimento().substring(6,9) 
					+ dest.getConferimento().substring(0,6);
				
				long codconf = (new Long(codconfstr)).longValue();

				if (codconf <= 380170000) {
					dest.addAttributo("categoriaMinisteriale", "4-2001");
					
				} else {
					dest.addAttributo("categoriaMinisteriale", "9-2002");
				}
			}
		}

	}

}