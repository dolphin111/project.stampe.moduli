package com.fideuram.crm.stampe.engine.modello.bean;

import java.util.List;

public class SollecitoRipensamentoRendita {

	String numeroPolizza;
	String dataLettera;
	String dataRichiesta;
	String intestazione;
	String cognome;
	String nome;
	String via;
	String cap;
	String comune;
	String provincia;
	List<String> docSollecitato;
	String nota;
	
	public String getNumeroPolizza() {
		return numeroPolizza;
	}
	public void setNumeroPolizza(String numeroPolizza) {
		this.numeroPolizza = numeroPolizza;
	}
	public String getDataLettera() {
		return dataLettera;
	}
	public void setDataLettera(String dataLettera) {
		this.dataLettera = dataLettera;
	}
	public String getDataRichiesta() {
		return dataRichiesta;
	}
	public void setDataRichiesta(String dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public String getIntestazione() {
		return intestazione;
	}
	public void setIntestazione(String intestazione) {
		this.intestazione = intestazione;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public List<String> getDocSollecitato() {
		return docSollecitato;
	}
	public void setDocSollecitato(List<String> docSollecitato) {
		this.docSollecitato = docSollecitato;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	
}
