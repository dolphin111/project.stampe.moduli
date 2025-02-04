package com.fideuram.stampe.modello.attori;


import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlType;

/**
 * Date: 23/06/11
 * Time: 11.18
 */

@XmlType(name="Persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 2217680844686910338L;
	//identificativo della persona (Contraente, Assicurato o folletto)
	private String tipoPersona;
	/*   DATI PERSONA    */
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private String sesso;
    private Date   dataDiNascita;
    private String dataNascitaString;
    private String nominativo;
    /*   DESCRIZIONE PERSONA    */
    private String descCodiceFiscale;
    private String descNome;
    private String descCognome;
    private String descSesso;
    private Date   descDataDiNascita;
    private String descDataNascitaString;
    private String descNominativo;
    protected SegniParticolari segniParticolari;
    
    public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getDescNominativo() {
		return descNominativo;
	}

	public void setDescNominativo(String descNominativo) {
		this.descNominativo = descNominativo;
	}

	public String getDescCodiceFiscale() {
		return descCodiceFiscale;
	}

	public void setDescCodiceFiscale(String descCodiceFiscale) {
		this.descCodiceFiscale = descCodiceFiscale;
	}

	public String getDescNome() {
		return descNome;
	}

	public void setDescNome(String descNome) {
		this.descNome = descNome;
	}

	public String getDescCognome() {
		return descCognome;
	}

	public void setDescCognome(String descCognome) {
		this.descCognome = descCognome;
	}

	public String getDescSesso() {
		return descSesso;
	}

	public void setDescSesso(String descSesso) {
		this.descSesso = descSesso;
	}

	public Date getDescDataDiNascita() {
		return descDataDiNascita;
	}

	public void setDescDataDiNascita(Date descDataDiNascita) {
		this.descDataDiNascita = descDataDiNascita;
	}

	public String getDescDataNascitaString() {
		return descDataNascitaString;
	}

	public void setDescDataNascitaString(String descDataNascitaString) {
		this.descDataNascitaString = descDataNascitaString;
	}

    public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

	public String getDataNascitaString() {
		return dataNascitaString;
	}

	public void setDataNascitaString(String dataNascitaString) {
		this.dataNascitaString = dataNascitaString;
	}

    public SegniParticolari getSegniParticolari() {
        return segniParticolari;
    }

    public void setSegniParticolari(SegniParticolari segniParticolari) {
        this.segniParticolari = segniParticolari;
    }
}