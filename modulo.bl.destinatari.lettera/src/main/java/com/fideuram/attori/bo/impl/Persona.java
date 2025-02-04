package com.fideuram.attori.bo.impl;

import com.fideuram.attori.bo.IPersona;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 10.42
 */
public class Persona implements IPersona {
    protected String titolo="Spett.le";
    protected String denominazione;
    protected Indirizzo indirizzo;
    protected String dataNascita;
    protected String sesso;

    public void setTitolo() {
		if ("M".equalsIgnoreCase(getSesso())) {
			titolo="Gentile Signor";

		} else if ("F".equalsIgnoreCase(getSesso())) {
			titolo="Gentile Signora";

        } else if ("G".equalsIgnoreCase(getSesso())) {
            titolo="Spett.le";

		} else {
			titolo="Spett.le";
		}
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public String getDenominazione() {
        return denominazione;
    }

    @Override
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    @Override
    public String getDataNascita() {
        return dataNascita;
    }

    @Override
    public String getSesso() {
        return sesso;
    }

    @Override
    public void setDenominazione(String cognome, String nome) {
        this.denominazione= cognome + " "+nome;
    }

    @Override
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo=indirizzo;
    }

    @Override
    public void setIndirizzo(String via, String citta, String cap, String provincia) {
       indirizzo= new Indirizzo();
       indirizzo.setVia(via);
       indirizzo.setCap(cap);
       indirizzo.setCitta(citta);
       indirizzo.setProvincia(provincia);
    }

    @Override
    public void setDataNascita(String dataNascita) {
        this.dataNascita=dataNascita;
    }

    @Override
    public void setSesso(String sesso) {
        this.sesso=sesso;
        setTitolo();   //ogni volta che imposto il sesso sono in grado (e devo!!) rideterminare il titolo
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result
				+ ((denominazione == null) ? 0 : denominazione.hashCode());
		result = prime * result
				+ ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (denominazione == null) {
			if (other.denominazione != null)
				return false;
		} else if (!denominazione.equals(other.denominazione))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
}
