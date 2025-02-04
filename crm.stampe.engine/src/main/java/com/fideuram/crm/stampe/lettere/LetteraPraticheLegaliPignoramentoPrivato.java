package com.fideuram.crm.stampe.lettere;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.PraticheLegaliPignoramentoPrivato;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.log.Log4j1Utils;
import com.fideuram.puc.service.impl.RivalutazioneVO;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return;

public class LetteraPraticheLegaliPignoramentoPrivato extends LetteraEngine {

	private PraticheLegaliPignoramentoPrivato pratica;
	private String formatoData = "dd/MM/yyyy";
	private Return datiSintetici;
	private NumberFormat nf;

	public LetteraPraticheLegaliPignoramentoPrivato(int comID) throws WebServiceClientException {
		super(comID);
	}

	/**
	 * @param dest
	 * @param dom
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom, ComunicazioneVO com) {

		pratica = new PraticheLegaliPignoramentoPrivato();

		try {

			nf = NumberFormat.getInstance(Locale.ITALIAN);
			nf.setMinimumFractionDigits(2);
			nf.setMaximumFractionDigits(2);
			nf.setRoundingMode(RoundingMode.HALF_UP);

			datiSintetici = pucS.getDatiSinteticiPolizza(Long.parseLong(dest.getNumero()));
			pratica.setDataEmissione(new SimpleDateFormat(formatoData).format(
					java.sql.Date.valueOf(datiSintetici.getDatiTecnici().getDataEmissione().toString()).getTime()));
			pratica.setCodiceProdotto(datiSintetici.getDatiTecnici().getProdotto().getCodice().trim().toUpperCase());
			pratica.setNumeroPolizza(dest.getNumero());
			pratica.setContraente(datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getCognome()
					.trim() + " "
					+ datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getNome().trim());
			pratica.setCodiceFiscaleContraente(
					datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica().getCodicefiscale());

			boolean checkProdotto = settaDatiProdotto90();

			if (!checkProdotto) {
				checkProdotto = settaDatiProdottoIIOrIJ();
			}
			if (!checkProdotto) {
				checkProdotto = settaDatiRamoIOrProdotto80();
			}
			if (!checkProdotto) {
				settaDatiAltriProdotti();
			}
			
			pratica.setEmailProponente(
					com.getProponente().getEmail() != null ? com.getProponente().getEmail() : "n.d.");
			
			Log4j1Utils.info(pratica);

		} catch (Exception ex) {
			ex.printStackTrace();
			Log4j1Utils.error(ex);
		}

		dest.setPraticheLegaliPignoramentoPrivato(pratica);

	}

	private boolean settaDatiProdotto90() {

		boolean ret = false;

		if (StringUtils.equalsIgnoreCase(pratica.getCodiceProdotto(), "90")) {

			pratica.setNumeroContratto(datiSintetici.getDatiTecnici().getCodiceConferimento());

			BigInteger codiceIscritto = datiSintetici.getFigureContrattuali().getContraente().getPersonaFisica()
					.getDatiSupplementariAnagraficiPrevidenza().getCodiceIscritto();
			pratica.setCodiceIscritto(codiceIscritto != null ? codiceIscritto.toString() : "n.d.");

			Double contributiLordi = datiSintetici.getPrevidenza().getImportoContributiLordi();
			pratica.setContributiLordi(contributiLordi != null ? nf.format(contributiLordi) : "n.d.");

			Double posizioneIndividuale = datiSintetici.getPrevidenza().getValorePosizioneIndividuale();
			pratica.setPosizioneIndividuale(posizioneIndividuale != null ? nf.format(posizioneIndividuale) : "n.d.");

			pratica.setDataAdesione(new SimpleDateFormat(formatoData).format(
					java.sql.Date.valueOf(datiSintetici.getPrevidenza().getDataAdesioneFondo().toString()).getTime()));

			pratica.setDataRiferimentoNav(new SimpleDateFormat(formatoData).format(java.sql.Date
					.valueOf(datiSintetici.getFinanziario().getDataRiferimentoNAV().toString()).getTime()));

			ret = true;

		}

		return ret;
	}

	private boolean settaDatiProdottoIIOrIJ() {

		boolean ret = false;

		if (StringUtils.startsWith(pratica.getCodiceProdotto().trim().toUpperCase(), "II")
				|| StringUtils.startsWith(pratica.getCodiceProdotto().trim().toUpperCase(), "IJ")) {

			pratica.setControvalore("n.d.");
			pratica.setUltimoNav("n.d.");

			ret = true;

		}

		return ret;
	}

	private boolean settaDatiRamoIOrProdotto80() throws Exception {

		boolean ret = false;

		if (StringUtils.equalsIgnoreCase(datiSintetici.getDatiTecnici().getRamoMinisteriale(), "1")
				|| StringUtils.equalsIgnoreCase(pratica.getCodiceProdotto(), "80")) {

			pratica.setRamoI(true);
			List<RivalutazioneVO> rivalutazioni = pucS.getListaRivalutazioniByPolizza(pratica.getNumeroPolizza());

			XMLGregorianCalendar dataUltimaRivalutazione = null;

			for (RivalutazioneVO vo : rivalutazioni) {
				XMLGregorianCalendar tmp = vo.getDataDecorrenza();
				if (dataUltimaRivalutazione == null
						|| tmp.compare(dataUltimaRivalutazione) == DatatypeConstants.GREATER) {
					dataUltimaRivalutazione = tmp;
				}
			}

			pratica.setRivalutazioneAnnua(dataUltimaRivalutazione != null
					? new SimpleDateFormat(formatoData).format(dataUltimaRivalutazione.toGregorianCalendar().getTime())
					: "n.d.");
			
			Double capitaleAssicuratoRivalutato = datiSintetici.getPrestazioni().getTotalePrestazioniCV();
			pratica.setCapitaleAssicuratoRivalutato(
					capitaleAssicuratoRivalutato != null ? nf.format(capitaleAssicuratoRivalutato) : "n.d.");

			ret = true;

		}

		return ret;
	}

	private void settaDatiAltriProdotti() {

		Double controvalore = datiSintetici.getFinanziario().getControvaloreTotale();
		pratica.setControvalore(controvalore != null ? nf.format(controvalore) : "n.d.");

		XMLGregorianCalendar dataRiferimentoNav = datiSintetici.getFinanziario().getDataRiferimentoNAV();
		pratica.setUltimoNav(dataRiferimentoNav != null
				? new SimpleDateFormat(formatoData).format(java.sql.Date.valueOf(dataRiferimentoNav.toString()))
				: "n.d.");
	}
}
