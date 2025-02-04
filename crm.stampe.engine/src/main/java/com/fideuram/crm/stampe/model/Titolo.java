package com.fideuram.crm.stampe.model;

public class Titolo {

	private String numero;
	private String dataEffetto;
	private String dataPagamento;
	private String descrizione;
	private String divisa;
	private String premioPagato;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDataEffetto() {
		return dataEffetto;
	}

	public void setDataEffetto(String dataEffetto) {
		this.dataEffetto = dataEffetto;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	public String getPremioPagato() {
		return premioPagato;
	}

	public void setPremioPagato(String premioPagato) {
		this.premioPagato = premioPagato;
	}
}