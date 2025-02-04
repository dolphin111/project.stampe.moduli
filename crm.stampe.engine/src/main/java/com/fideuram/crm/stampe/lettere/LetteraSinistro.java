package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.model.Polizza;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraSinistro {

	/**
	 * @param target
	 */
	public static void completaPolizza(Polizza target) {

		TabellaPrestazioniAssicurate.impostaLabelgaranziecomplementari(target);

		//------------ VALORE ECCEDENZA ----------------
		impostaRigaPrestazioniMorte(target);

	}


	/**
	 * @param dest
	 */
	private static void impostaRigaPrestazioniMorte(Polizza dest) {

		dest.addAttributo("descrizionePrestazioniMorte", "");
		dest.addAttributo("importoPrestazioniMorte", dest.getImportoCasoMorteRivalutato());

		if ("3".equals(dest.getRamoMinisteriale())) {
			dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getAttributo("dataValutazione"));     	         
			dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteDecessoLimitazioniRiscParziali"));
			
		} else {
			dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getDataUltimaRivalutazioneFineDifferimento());     	         

			if ("C".equalsIgnoreCase(dest.getTipoPrestazione()) ||
					dest.isControassicurazione() ||
					!"GD".equalsIgnoreCase(dest.getCodiceSottostato())) {

				if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
					dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteGarantitoBonus"));
					
				} else {
					dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteGarantito"));
				}
			}
		}
	}

}
