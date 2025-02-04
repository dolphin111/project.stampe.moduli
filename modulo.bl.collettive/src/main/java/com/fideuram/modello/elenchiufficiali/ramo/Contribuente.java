package com.fideuram.modello.elenchiufficiali.ramo;

import java.util.Date;

public class Contribuente {

	//A1
	private String posizione;
	//Assicurato B1
	private String nome;
	private String cogn;
	//B2
	private String datNas;
	//C2
	private String codFis;
	//D2
	private String sesso;
	//E1
	private Date datDecor;
	
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCogn() {
		return cogn;
	}
	public void setCogn(String cogn) {
		this.cogn = cogn;
	}
	public String getDatNas() {
		return datNas;
	}
	public void setDatNas(String datNas) {
		this.datNas = datNas;
	}
	public String getCodFis() {
		return codFis;
	}
	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public Date getDatDecor() {
		return datDecor;
	}
	public void setDatDecor(Date datDecor) {
		this.datDecor = datDecor;
	}
	@Override
	public String toString() {
		return "Contribuente [posizione=" + posizione + ", nome=" + nome
				+ ", cogn=" + cogn + ", datNas=" + datNas + ", codFis="
				+ codFis + ", sesso=" + sesso + ", datDecor=" + datDecor + "]";
	}
	
	
}
