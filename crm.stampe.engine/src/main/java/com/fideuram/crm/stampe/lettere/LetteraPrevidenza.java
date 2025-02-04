package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Polizza;

public class LetteraPrevidenza {

	/**
	 * @param polizza
	 * @param modello
	 * @param comunicazione
	 * @param domanda
	 * @param root
	 */
	public static void completaPolizza(Polizza polizza, Modello modello,ComunicazioneVO comunicazione,DomandaVO domanda,boolean root){
		StringBuffer rv = new StringBuffer();

		rv.append("Posizione ").append(modello.getPolizze().get(0)!=null ? modello.getPolizze().get(0).getDescrizioneCommerciale().trim() :"").
		append(" n. :").append(modello.getPolizze().get(0).getNumero());
		if (modello.getPolizze().get(0).getPolizzeProvenienza() != null) {
			if (modello.getPolizze().get(0).getPolizzeProvenienza().size() > 1) {
				rv.append(" - derivante da sostituzione pol. ");
				boolean primo = true;

				for (Polizza p : modello.getPolizze().get(0).getPolizzeProvenienza()) {
					rv.append((primo ? "" : ", ")).append(p.getNumero());
					primo = false;
				}
			} else {
				rv.append(" - derivante da sostituzione di polizza ");
			}
		}
		modello.getLettera().setOggetto(rv.toString());
	}
}