package com.fideuram.crm.stampe.model;

import java.util.List;

import com.fideuram.puc.service.impl.LiquidazionePraticaLegaleVO;
import com.fideuram.puc.service.impl.VersamentoPraticaLegaleVO;

public class PraticheLegaliAccertamento {

	private String istanteDenominazione;
	private String istanteCodiceFiscale;
	private String istanteDataNascita;
	private String istanteLocalitaNascita;
	private String totPremiVersati;
	private Boolean vincoloFUG;
	private String numeroProposta;
	private String dataProposta;
	private String contraente;
	private String localitaNascitaContraente;
	private String dataNascitaContraente;
	private String codiceFiscaleContraente;
	private String assicurato;
	private String dataEmissione;
	private String dataScadenza;
	private String stato;
	private String prodotto;
	private String numeroPolizza;
	private String beneficiariMorte;
	private String tipologiaPolizza;
	private String controvalore;
	private String ultimoNav;
	private Boolean polizzaAScadenza;
	private Boolean ramoI;
	private Boolean hasProposta;
	private List<VersamentoPraticaLegaleVO> versamenti;
	private List<LiquidazionePraticaLegaleVO> liquidazioni;
	private String rivalutazioneAnnua;
	private String capitaleAssicuratoRivalutato;
	private String emailProponente;

	public String getIstanteDenominazione() {
		return istanteDenominazione;
	}

	public void setIstanteDenominazione(String istanteDenominazione) {
		this.istanteDenominazione = istanteDenominazione;
	}

	public String getIstanteCodiceFiscale() {
		return istanteCodiceFiscale;
	}

	public void setIstanteCodiceFiscale(String istanteCodiceFiscale) {
		this.istanteCodiceFiscale = istanteCodiceFiscale;
	}

	public String getIstanteDataNascita() {
		return istanteDataNascita;
	}

	public void setIstanteDataNascita(String istanteDataNascita) {
		this.istanteDataNascita = istanteDataNascita;
	}

	public String getIstanteLocalitaNascita() {
		return istanteLocalitaNascita;
	}

	public void setIstanteLocalitaNascita(String istanteLocalitaNascita) {
		this.istanteLocalitaNascita = istanteLocalitaNascita;
	}

	public String getTotPremiVersati() {
		return totPremiVersati;
	}

	public void setTotPremiVersati(String totPremiVersati) {
		this.totPremiVersati = totPremiVersati;
	}

	public Boolean getVincoloFUG() {
		return vincoloFUG;
	}

	public void setVincoloFUG(Boolean vincoloFUG) {
		this.vincoloFUG = vincoloFUG;
	}

	public String getNumeroProposta() {
		return numeroProposta;
	}

	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	public String getDataProposta() {
		return dataProposta;
	}

	public void setDataProposta(String dataProposta) {
		this.dataProposta = dataProposta;
	}

	public String getContraente() {
		return contraente;
	}

	public void setContraente(String contraente) {
		this.contraente = contraente;
	}

	public String getAssicurato() {
		return assicurato;
	}

	public void setAssicurato(String assicurato) {
		this.assicurato = assicurato;
	}

	public String getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public String getNumeroPolizza() {
		return numeroPolizza;
	}

	public void setNumeroPolizza(String numeroPolizza) {
		this.numeroPolizza = numeroPolizza;
	}

	public String getBeneficiariMorte() {
		return beneficiariMorte;
	}

	public void setBeneficiariMorte(String beneficiariMorte) {
		this.beneficiariMorte = beneficiariMorte;
	}

	public String getTipologiaPolizza() {
		return tipologiaPolizza;
	}

	public void setTipologiaPolizza(String tipologiaPolizza) {
		this.tipologiaPolizza = tipologiaPolizza;
	}

	public String getControvalore() {
		return controvalore;
	}

	public void setControvalore(String controvalore) {
		this.controvalore = controvalore;
	}

	public String getUltimoNav() {
		return ultimoNav;
	}

	public void setUltimoNav(String ultimoNav) {
		this.ultimoNav = ultimoNav;
	}

	public Boolean getPolizzaAScadenza() {
		return polizzaAScadenza;
	}

	public void setPolizzaAScadenza(Boolean polizzaAScadenza) {
		this.polizzaAScadenza = polizzaAScadenza;
	}

	public Boolean getRamoI() {
		return ramoI;
	}

	public void setRamoI(Boolean ramoI) {
		this.ramoI = ramoI;
	}

	public Boolean getHasProposta() {
		return hasProposta;
	}

	public void setHasProposta(Boolean hasProposta) {
		this.hasProposta = hasProposta;
	}

	public String getLocalitaNascitaContraente() {
		return localitaNascitaContraente;
	}

	public void setLocalitaNascitaContraente(String localitaNascitaContraente) {
		this.localitaNascitaContraente = localitaNascitaContraente;
	}

	public String getDataNascitaContraente() {
		return dataNascitaContraente;
	}

	public void setDataNascitaContraente(String dataNascitaContraente) {
		this.dataNascitaContraente = dataNascitaContraente;
	}

	public String getCodiceFiscaleContraente() {
		return codiceFiscaleContraente;
	}

	public void setCodiceFiscaleContraente(String codiceFiscaleContraente) {
		this.codiceFiscaleContraente = codiceFiscaleContraente;
	}

	public List<VersamentoPraticaLegaleVO> getVersamenti() {
		return versamenti;
	}

	public void setVersamenti(List<VersamentoPraticaLegaleVO> versamenti) {
		this.versamenti = versamenti;
	}

	public List<LiquidazionePraticaLegaleVO> getLiquidazioni() {
		return liquidazioni;
	}

	public void setLiquidazioni(List<LiquidazionePraticaLegaleVO> liquidazioni) {
		this.liquidazioni = liquidazioni;
	}

	public String getRivalutazioneAnnua() {
		return rivalutazioneAnnua;
	}

	public void setRivalutazioneAnnua(String rivalutazioneAnnua) {
		this.rivalutazioneAnnua = rivalutazioneAnnua;
	}

	public String getCapitaleAssicuratoRivalutato() {
		return capitaleAssicuratoRivalutato;
	}

	public void setCapitaleAssicuratoRivalutato(String capitaleAssicuratoRivalutato) {
		this.capitaleAssicuratoRivalutato = capitaleAssicuratoRivalutato;
	}

	public String getEmailProponente() {
		return emailProponente;
	}

	public void setEmailProponente(String emailProponente) {
		this.emailProponente = emailProponente;
	}

	@Override
	public String toString() {
		return "PraticheLegaliAccertamento [istanteDenominazione=" + istanteDenominazione + ", istanteCodiceFiscale="
				+ istanteCodiceFiscale + ", istanteDataNascita=" + istanteDataNascita + ", istanteLocalitaNascita="
				+ istanteLocalitaNascita + ", totPremiVersati=" + totPremiVersati + ", vincoloFUG=" + vincoloFUG
				+ ", numeroProposta=" + numeroProposta + ", dataProposta=" + dataProposta + ", contraente=" + contraente
				+ ", localitaNascitaContraente=" + localitaNascitaContraente + ", dataNascitaContraente="
				+ dataNascitaContraente + ", codiceFiscaleContraente=" + codiceFiscaleContraente + ", assicurato="
				+ assicurato + ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza + ", stato="
				+ stato + ", prodotto=" + prodotto + ", numeroPolizza=" + numeroPolizza + ", beneficiariMorte="
				+ beneficiariMorte + ", tipologiaPolizza=" + tipologiaPolizza + ", controvalore=" + controvalore
				+ ", ultimoNav=" + ultimoNav + ", polizzaAScadenza=" + polizzaAScadenza + ", ramoI=" + ramoI
				+ ", hasProposta=" + hasProposta + ", versamenti=" + versamenti + ", liquidazioni=" + liquidazioni
				+ ", rivalutazioneAnnua=" + rivalutazioneAnnua + ", capitaleAssicuratoRivalutato="
				+ capitaleAssicuratoRivalutato + ", emailProponente=" + emailProponente + "]";
	}
}
