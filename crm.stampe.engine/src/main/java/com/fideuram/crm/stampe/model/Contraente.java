package com.fideuram.crm.stampe.model;

import java.util.List;

public class Contraente extends Persona {
	
	public Contraente(Persona persona) {
		
		this.dataNascita = persona.dataNascita;
		this.denominazione = persona.denominazione;
		this.indirizzo = persona.indirizzo;
		this.reteVendita = persona.reteVendita;
		this.sesso = persona.sesso;
		this.titolo = persona.titolo;
	}

	private String codiceFiscale;
	private List<Polizza> polizze;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public List<Polizza> getPolizze() {
		return polizze;
	}

	public void setPolizze(List<Polizza> polizze) {
		this.polizze = polizze;
	}
}
