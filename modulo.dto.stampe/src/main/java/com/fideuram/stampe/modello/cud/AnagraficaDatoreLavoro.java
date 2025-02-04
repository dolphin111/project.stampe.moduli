package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AnagraficaDatoreLavoro")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnagraficaDatoreLavoro extends Anagrafica {
 
	private String codFis;
	private String cognome_denominazione;
	private String nome;
	private String comune;
	private String provincia;
	private String CAP;
	private String indirizzo;
	private String tel_fax;
	private String email;
	private String codAttivita;
	private String codSede;
	
	
	public String getCodFis() {
		return codFis;
	}
	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}
	public String getCognome_denominazione() {
		return cognome_denominazione;
	}
	public void setCognome_denominazione(String cognome_denominazione) {
		this.cognome_denominazione = cognome_denominazione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getCAP() {
		return CAP;
	}
	public void setCAP(String CAP) {
		this.CAP = CAP;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTel_fax() {
		return tel_fax;
	}
	public void setTel_fax(String tel_fax) {
		this.tel_fax = tel_fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodAttivita() {
		return codAttivita;
	}
	public void setCodAttivita(String codAttivita) {
		this.codAttivita = codAttivita;
	}
	public String getCodSede() {
		return codSede;
	}
	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}
		
}
