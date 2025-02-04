package com.fideuram.stampe.modello.cud;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AnagraficaDipendente")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnagraficaDipendente extends Anagrafica {
	 
	private String codFis;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String sesso;
	private String comuneNascita;
	private String provinciaNascita;
	private String previdComplem; // Previdenza complementare
	private String dataIscrFondo; // Data iscrizione al fondo
	private String eventiEcc; // Eventi eccezionali
	private String domicilioAnnoPrec; // DOMICILIO FISCALE ALL' 1/1/2013
	private String domicilioFineRappLav; // DOMICILIO FISCALE AL 31/12/2013 O ALLA DATA DI CESSAZIONE DEL RAPPORTO DI LAVORO SE PRECEDENTE
	private String domicilioCorrente; // DOMICILIO FISCALE ALL' 1/1/2014
	private String provDomAnnoPrec; // Provincia ALL' 1/1/2013
	private String provDomFineRappLav; // Provincia AL 31/12/2013 O ALLA DATA DI CESSAZIONE DEL RAPPORTO DI LAVORO SE PRECEDENTE
	private String provDomCorrente;  // Provincia ALL' 1/1/2014
	private String codComuneDomAnnoPrec; // Codice comune ALL' 1/1/2013
	private String codComuneDomCorrente; // Codice comune ALL' 1/1/2014
	private String cap;
	private String indirizzoDip;
	
	
	
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getIndirizzoDip() {
		return indirizzoDip;
	}
	public void setIndirizzoDip(String indirizzoDip) {
		this.indirizzoDip = indirizzoDip;
	}
	public String getCodFis() {
		return codFis;
	}
	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public String getProvinciaNascita() {
		return provinciaNascita;
	}
	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}
	public String getPrevidComplem() {
		return previdComplem;
	}
	public void setPrevidComplem(String previdComplem) {
		this.previdComplem = previdComplem;
	}
	public String getDataIscrFondo() {
		return dataIscrFondo;
	}
	public void setDataIscrFondo(String dataIscrFondo) {
		this.dataIscrFondo = dataIscrFondo;
	}
	public String getEventiEcc() {
		return eventiEcc;
	}
	public void setEventiEcc(String eventiEcc) {
		this.eventiEcc = eventiEcc;
	}
	public String getDomicilioAnnoPrec() {
		return domicilioAnnoPrec;
	}
	public void setDomicilioAnnoPrec(String domicilioAnnoPrec) {
		this.domicilioAnnoPrec = domicilioAnnoPrec;
	}
	public String getDomicilioFineRappLav() {
		return domicilioFineRappLav;
	}
	public void setDomicilioFineRappLav(String domicilioFineRappLav) {
		this.domicilioFineRappLav = domicilioFineRappLav;
	}
	public String getDomicilioCorrente() {
		return domicilioCorrente;
	}
	public void setDomicilioCorrente(String domicilioCorrente) {
		this.domicilioCorrente = domicilioCorrente;
	}
	public String getProvDomAnnoPrec() {
		return provDomAnnoPrec;
	}
	public void setProvDomAnnoPrec(String provDomAnnoPrec) {
		this.provDomAnnoPrec = provDomAnnoPrec;
	}
	public String getProvDomFineRappLav() {
		return provDomFineRappLav;
	}
	public void setProvDomFineRappLav(String provDomFineRappLav) {
		this.provDomFineRappLav = provDomFineRappLav;
	}
	public String getProvDomCorrente() {
		return provDomCorrente;
	}
	public void setProvDomCorrente(String provDomCorrente) {
		this.provDomCorrente = provDomCorrente;
	}
	public String getCodComuneDomAnnoPrec() {
		return codComuneDomAnnoPrec;
	}
	public void setCodComuneDomAnnoPrec(String codComuneDomAnnoPrec) {
		this.codComuneDomAnnoPrec = codComuneDomAnnoPrec;
	}
	public String getCodComuneDomCorrente() {
		return codComuneDomCorrente;
	}
	public void setCodComuneDomCorrente(String codComuneDomCorrente) {
		this.codComuneDomCorrente = codComuneDomCorrente;
	}
	
	

}
