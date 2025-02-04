package com.fideuram.modello.metodiPagamento;

import java.util.Date;
import java.util.List;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.utils.LoggingUtils;

public class MetodiPagamento {

	private String tipoPagamento;
	private String numeroMandato;
	private Date dataMandato;
	private String numeroCollettiva;
	private String contraente;
	//indirizzo contraente
	private String indirizzo;
	private String cap;
	private String citta;
	private String prov;
	
	private List<Mandato> mandati;
	private Double totaleMandati;
	

	public String getTipoPagamento() {
		return tipoPagamento;
	}
	//può essere valorizzato A/B/GA/GF 
	//A=assegno/B=bonifico/GA=girofondo assicurativo/GF=girofondo finanziario
	public void setTipoPagamento(String tipoPagamento) {
		if(tipoPagamento.equalsIgnoreCase("a"))
			this.tipoPagamento = "ASSEGNO";
		else if(tipoPagamento.equalsIgnoreCase("b"))
			this.tipoPagamento = "BONIFICO BANCARIO";
		else if(tipoPagamento.equalsIgnoreCase("ga"))
			this.tipoPagamento = "GIROFONDO ASSICURATIVO";
		else if(tipoPagamento.equalsIgnoreCase("gf"))
			this.tipoPagamento = "GIROFONDO FINANZIARIO";
		else {
			LoggingUtils.warn("tipo pagamento non contemplato");
			this.tipoPagamento = "";
		}
	}

	public String getNumeroMandato() {
		return numeroMandato;
	}

	public void setNumeroMandato(String numeroMandato) {
		this.numeroMandato = numeroMandato;
	}

	public String getDataMandato() {
		return FormatterFactory.getStandardDate(dataMandato);
	}

	public void setDataMandato(Date dataMandato) {
		this.dataMandato = dataMandato;
	}

	public String getNumeroCollettiva() {
		return numeroCollettiva+"";
	}

	public void setNumeroCollettiva(String numeroCollettiva) {
		this.numeroCollettiva = numeroCollettiva;
	}

	public String getContraente() {
		return contraente;
	}

	public void setContraente(String contraente) {
		this.contraente = contraente;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Mandato> getMandati() {
		return mandati;
	}

	public void setMandati(List<Mandato> mandati) {
		this.mandati = mandati;
	}

	public String getTotaleMandati() {
		return FormatterFactory.getStandardImporto(totaleMandati);
	}

	public void setTotaleMandati(Double totaleMandati) {
		this.totaleMandati = totaleMandati;
	}
	
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}

	@Override
	public String toString() {
		return "MetodiPagamento [tipoPagamento=" + tipoPagamento
				+ ", numeroMandato=" + numeroMandato + ", dataMandato="
				+ dataMandato + ", numeroCollettiva=" + numeroCollettiva
				+ ", contraente=" + contraente + ", indirizzo=" + indirizzo
				+ ", --->mandati=" + mandati.size() + ", totaleMandati=" + totaleMandati
				+ "]";
	}
}
