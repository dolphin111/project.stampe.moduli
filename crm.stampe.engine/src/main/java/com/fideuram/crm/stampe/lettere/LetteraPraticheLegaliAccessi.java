package com.fideuram.crm.stampe.lettere;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.PraticheLegaliAccessi;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.log.Log4j1Utils;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return;

import org.apache.commons.lang.StringUtils;

public class LetteraPraticheLegaliAccessi extends LetteraEngine {

	private String formatoData = "dd/MM/yyyy";

	public LetteraPraticheLegaliAccessi(int comID) throws WebServiceClientException {
		super(comID);
	}

	/**
	 * @param dest
	 * @param dom
	 *
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom) {

		PraticheLegaliAccessi pratica = new PraticheLegaliAccessi();

		try {
			NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
			nf.setMinimumFractionDigits(2);
			nf.setMaximumFractionDigits(2);
			nf.setRoundingMode(RoundingMode.HALF_UP);

			Return datiSintetici = pucS.getDatiSinteticiPolizza(Long.parseLong(dest.getNumero()));
			pratica.setContraente(datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getCognome()
					.trim() + " "
					+ datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getNome().trim());
			pratica.setCodiceFiscaleContraente(
					datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getCodicefiscale());
			pratica.setDataNascitaContraente(
					new SimpleDateFormat(formatoData).format(java.sql.Date.valueOf(datiSintetici.getFigureContrattuali()
							.getContraente().getPersonaFisica().getDatanascita().toString()).getTime()));
			pratica.setLocalitaNascitaContraente(
					datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getLocalitaNascita());
			pratica.setAssicurato(datiSintetici.getFigureContrattuali().getPrimoAssicurato().getPersonaFisica()
					.getCognome().trim() + " "
					+ datiSintetici.getFigureContrattuali().getPrimoAssicurato().getPersonaFisica().getNome().trim());
			pratica.setDataEmissione(new SimpleDateFormat(formatoData).format(
					java.sql.Date.valueOf(datiSintetici.getDatiTecnici().getDataEmissione().toString()).getTime()));
			pratica.setDataScadenza(new SimpleDateFormat(formatoData).format(
					java.sql.Date.valueOf(datiSintetici.getDatiTecnici().getDataScadenza().toString()).getTime()));
			pratica.setTipologiaPolizza(pucS.getTipologiaPolizza(dest.getNumero()));
			pratica.setPolizzaAScadenza(pratica.getTipologiaPolizza().contains("scad"));

			pratica.setTotPremiVersati(
					nf.format(datiSintetici.getContabile().getTotalePremiAnnuiIncassatiConTrasformate()));

			String beneficiariMorte = "";
			if (datiSintetici.getDatiTecnici().getProdotto().getCodice().trim().equalsIgnoreCase("90")) {
				List<String> listaBenef = datiSintetici.getPrevidenza().getBeneficiariMorte().getBeneficiarioMorte();
				int cont = 1;
				for (String benef : listaBenef) {
					if (cont == 1) {
						beneficiariMorte = benef;
					} else {
						beneficiariMorte = ", " + benef;
					}
					cont++;
				}
			} else {
				beneficiariMorte = datiSintetici.getFigureContrattuali().getBeneficiarioMorte();
			}

			pratica.setBeneficiariMorte(StringUtils.isNotBlank(beneficiariMorte) ? beneficiariMorte : "n.d.");
			pratica.setStato(datiSintetici.getDatiTecnici().getStato().trim());
			pratica.setProdotto(datiSintetici.getDatiTecnici().getProdotto().getDescrizione().trim());
			pratica.setNumeroPolizza(dest.getNumero());
			pratica.setLiquidazioni(pucS.getLiquidazioniPraticaLegaleByPolizza(dest.getNumero()));
			pratica.setRamoI(false); // false default value
			pratica.setDataProposta(new SimpleDateFormat(formatoData).format(
					java.sql.Date.valueOf(datiSintetici.getDatiTecnici().getDataProposta().toString()).getTime()));
			pratica.setNumeroProposta(datiSintetici.getDatiTecnici().getNumeroProposta() != null
					? datiSintetici.getDatiTecnici().getNumeroProposta()
					: "n.d.");

			if (datiSintetici.getDatiTecnici().getProdotto().getCodice().trim().toUpperCase().startsWith("II")
					|| datiSintetici.getDatiTecnici().getProdotto().getCodice().trim().toUpperCase().startsWith("IJ")) {
				pratica.setControvalore("n.d.");
				pratica.setUltimoNav("n.d.");
			} else if (datiSintetici.getDatiTecnici().getRamoMinisteriale().trim().equalsIgnoreCase("1")
					|| datiSintetici.getDatiTecnici().getProdotto().getCodice().trim().equalsIgnoreCase("80")) {
				pratica.setRamoI(true);
				pratica.setRivalutazioneAnnua(datiSintetici.getPrestazioni().getDataUltimaRivalutazione() != null
						? new SimpleDateFormat(formatoData).format(java.sql.Date
								.valueOf(datiSintetici.getPrestazioni().getDataUltimaRivalutazione().toString()))
						: "n.d.");
				Double capitaleAssicuratoRivalutato = datiSintetici.getPrestazioni()
						.getPrestazioneGarantitaUltimaRivalutazione();
				pratica.setCapitaleAssicuratoRivalutato(
						capitaleAssicuratoRivalutato != null ? nf.format(capitaleAssicuratoRivalutato) : "n.d.");
			} else {
				pratica.setControvalore(nf.format(datiSintetici.getFinanziario().getControvaloreTotale()));
				pratica.setUltimoNav(datiSintetici.getFinanziario().getDataRiferimentoNAV() != null
						? new SimpleDateFormat(formatoData).format(java.sql.Date
								.valueOf(datiSintetici.getFinanziario().getDataRiferimentoNAV().toString()))
						: "n.d.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			Log4j1Utils.error(ex);
		}

		Log4j1Utils.info(pratica);

		dest.setPraticheLegaliAccessi(pratica);

	}
}
