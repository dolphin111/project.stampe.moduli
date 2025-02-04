package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.WSOpzioniBean;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraOpzioneAnticipata extends LetteraEngine{

    public LetteraOpzioneAnticipata(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @param dom
	 * 
	 * @throws CrmStampeException
	 */
	public  void completaPolizza(Polizza dest, DomandaVO dom) throws WebServiceClientException {

		// ----------- PRESTAZIONI ASSICURATE -------------------
		TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);

		// ----------- CHIAMATA MOTORE OPZIONI -------------------
		WSOpzioniBean input = impostaWSinput(dom);

		String polizza = dest.getNumero();

		String frazionamento = input.getFrazionamento();

        WSOpzioniBean output = null;
        try {
            output = uniS.getOpzCambioFraz(polizza, frazionamento, "S");
        } catch (UniversoException e) {
           throw new WebServiceClientException(e);
        }

        if (output != null) {
			dest.addAttributo("dataScadenzaPrimaRataRendita",
					output.getDataScadenzaPrimaRataRendita());
			
			dest.addAttributo("importoOpzionePrestazioniVita",
					output.getTotaleRenditaDiOpzioneComplessiva());

			if (dest.getRenditaGarantita75() != null
					&& !"".equals(dest.getRenditaGarantita75())) {
				
				dest.addAttributo("dataOpzioneRicorrenza75",
						output.getRicorrenzaRenditaAl75Anno());
				
				dest.addAttributo("dataOpzioneRicorrenza80",
						output.getRicorrenzaRenditaAl80Anno());
				
				dest.addAttributo("dataOpzioneRicorrenza85",
						output.getRicorrenzaRenditaAl85Anno());
				
				dest.addAttributo("renditaOpzioneGarantita75",
						output.getRenditaAnnuaVitaliziaAl75Anno());
				
				dest.addAttributo("renditaOpzioneGarantita80",
						output.getRenditaAnnuaVitaliziaAl80Anno());
				
				dest.addAttributo("renditaOpzioneGarantita85",
						output.getRenditaAnnuaVitaliziaAl85Anno());
			}
			
			// nella colonna descrizioni
			dest.addAttributo("importoRataRenditaFrazionata",
					output.getImportoRataRenditaFrazionata());
			
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl75Anno",
					output.getRataRenditaAnnuaVitaliziaAl75Anno());
			
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl80Anno",
					output.getRataRenditaAnnuaVitaliziaAl80Anno());
			
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl85Anno",
					output.getRataRenditaAnnuaVitaliziaAl85Anno());
			
			dest.addAttributo("rataRenditaReversibilitaMorteAssic",
					output.getRataRenditaReversibilitaMorteAssic());
			
			dest.addAttributo("dataFineDiffReversibilitaMorteAssic",
					output.getDataFineDiffReversibilitaMorteAssic());
			
			dest.addAttributo("durataCerta", output.getDurataCerta());

			// TABELLA OPZIONI
			impostaIpotesiOpzioneAnticipata(dest, output);

			// ------------ CASO VITA ------------
			impostaRigaPrestazioniVita(dest, output);

			// ------------ ACLS (75, 80, 85) ----------------
			impostaRigaPrestazioniACLS(dest, output);
		}
		
		dest.addAttributo("anticipata", "si");

		// ------------ DESCRIZIONE IPOTESI ------------
		LetteraOpzioneReversibilita.impostaIpotesiOpzioneGenerica(dest);

		// ------------ RICHIESTA OPZIONE ------------
		DescrizioniComuni.impostaDescrizioneRichiestaOpzione(dest);
	}

	/**
	 * @param dom
	 * @return
	 */
	private static WSOpzioniBean impostaWSinput(DomandaVO dom) {
		WSOpzioniBean bean = new WSOpzioniBean();
		
		bean.setFrazionamento(Inputs.getFrazionamento(dom));
		bean.setAnticipata(Inputs.getAnticipata(dom));
		
		return bean;
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaIpotesiOpzioneAnticipata(Polizza dest, WSOpzioniBean output) {

		dest.addAttributo("ipotesiOpzione", dest.getTroncone("DescrIpotAnticipata")
						+ " " + output.getFrazionamentoPlurale());
	
		// Rinuncia Riscatto
		LetteraOpzioneReversibilita.impostaIpotesiOpzioneRinunciaRiscatto(dest,output);

		if ((dest.getAttributo("durataCerta") != null) && !dest.getAttributo("durataCerta").isEmpty()) {
			dest.addAttributo("ipotesiOpzione",	dest.getAttributo("ipotesiOpzione")
							+ " " + dest.getTroncone("DescrIpotCoefficienti"));
		}

	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniVita(Polizza dest, WSOpzioniBean output) {

		if ("3".equals(dest.getRamoMinisteriale())
				&& ("R".equals(dest.getTipoPrestazione()))) {
			dest.addAttributo("descrizioneOpzionePrestazioniVita",
					dest.getTroncone("PrestVitaRenditaAnnuaVitaliziaMinima"));
		} else {
			dest.addAttributo(
					"descrizioneOpzionePrestazioniVita",
					dest.getTroncone("PrestVitaRenditaAnnuaVitaliziaRivalutata"));
		}
		
		dest.addAttributo("descrizioneOpzionePrestazioniVita",
				dest.getAttributo("descrizioneOpzionePrestazioniVita")
						+ " anticipate, ciascuna di € "
						+ output.getImportoRataRenditaFrazionata()
						+ ".");
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniACLS(Polizza dest,WSOpzioniBean output) {

		dest.addAttributo("descrizioneOpzioneACLS", "");
		
		if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
			dest.addAttributo("descrizioneOpzioneACLS",
					dest.getTroncone("PrestVitaRenditaAnnuaVitaliziaACLS")
					+ " " + output.getFrazionamentoPlurale()
			        + " anticipate, ciascuna rispettivamente di € ");		

			dest.addAttributo(
					"descrizioneOpzioneACLS",
					dest.getAttributo("descrizioneOpzioneACLS") + " "
							+ output.getRataRenditaAnnuaVitaliziaAl75Anno()
							+ ", € "
							+ output.getRataRenditaAnnuaVitaliziaAl80Anno()
							+ " ed € "
							+ output.getRataRenditaAnnuaVitaliziaAl85Anno()
							+ ".");
		}
	}

}
