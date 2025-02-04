package com.fideuram.crm.stampe.model;

import com.fideuram.costanti.Costanti;

public class Lettera {
    private String reteVendita;
	private String citta;
    private String data;
    private String labelProtocollo;
    private String protocollo;
    private String codiceIside;
    private String utente;
    private String oggetto                      ="";
    private String testoLettera;
    private String testoIndirizzoLettera        ="";
    private String tipoComunicazione;
    private boolean indirizzoModificato;
    private String denominazioneContraente      ="";
    private String etichettaDenominazione       ="";
    private String flagOpzioni= "si";
    private String descrizioneDomanda;
    private String dataCreazione;                   //si riferisce alla data di creazione della comunicazione o di ricezione del reclamo
    private String tipoProponente;
    private String codaOggetto                  ="";
    private String comunicazioneId;
    private boolean letteraPrevidenza;
    private String titoloReclamante;

    public boolean isLetteraPrevidenza() {
        return letteraPrevidenza;
    }

    public void setLetteraPrevidenza(boolean letteraPrevidenza) {
        this.letteraPrevidenza = letteraPrevidenza;
    }

    public String getTestoIndirizzoLettera() {
        return testoIndirizzoLettera;
    }

    public void setTestoIndirizzoLettera(String testoIndirizzoLettera) {
        this.testoIndirizzoLettera = testoIndirizzoLettera;
    }

    public String getComunicazioneId() {
		return comunicazioneId;
	}

	public void setComunicazioneId(String comunicazioneId) {
		this.comunicazioneId = comunicazioneId;
	}

	public String getEtichettaDenominazione() {
        return etichettaDenominazione;
    }

    public void setEtichettaDenominazione(String etichettaDenominazione) {
        this.etichettaDenominazione = etichettaDenominazione;
    }

    public String getCodaOggetto() {
		return codaOggetto;
	}

	public void setCodaOggetto(String codaOggetto) {
		this.codaOggetto = codaOggetto;
	}

	public String getTipoProponente() {
		return tipoProponente!=null?tipoProponente:"";
	}

	public void setTipoProponente(String tipoProponente) {
		this.tipoProponente = tipoProponente;
	}

	public String getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getDescrizioneDomanda() {
        return descrizioneDomanda;
    }

    public void setDescrizioneDomanda(String descrizioneDomanda) {
        this.descrizioneDomanda = descrizioneDomanda;
    }

    /*

	*/

    public String getReteVendita() {
        return reteVendita;
    }

    public void setReteVendita(String reteVendita) {
        this.reteVendita = reteVendita;
    }

    public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

	public String getProtocollo() {
		return protocollo;
	}

	public String getLabelProtocollo() {
		return labelProtocollo;
	}

	public void setLabelProtocollo(String labelProtocollo) {
		this.labelProtocollo = labelProtocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getCodiceIside() {
		return codiceIside;
	}

	public void setCodiceIside(String codiceIside) {
		this.codiceIside = codiceIside;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getTestoLettera() {
        return testoLettera!=null?testoLettera:"";
    }

    public void setTestoLettera(String testoLettera) {
        this.testoLettera = testoLettera;
    }

    public String getTipoComunicazione() {
        return tipoComunicazione;
    }

    public void setTipoComunicazione(String tipoComunicazione) {
        this.tipoComunicazione = tipoComunicazione;
    }

    public boolean isIndirizzoModificato() {
        return indirizzoModificato;
    }

    public void setIndirizzoModificato(boolean indirizzoModificato) {
        this.indirizzoModificato = indirizzoModificato;
    }

	/**
	 * @return the denominazioneContraente
	 */
	public String getDenominazioneContraente() {
		return denominazioneContraente;
	}

	/**
	 * @param denominazioneContraente the denominazioneContraente to set
	 */
	public void setDenominazioneContraente(String denominazioneContraente) {
		this.denominazioneContraente = denominazioneContraente;
	}


    public String getFlagOpzioni() {
        return flagOpzioni;
    }

    public void setFlagOpzioni(String flagOpzioni) {
        this.flagOpzioni = flagOpzioni;
    }

    public void setFlagOpzione(String tripletta) {
        if (    Costanti.CODICE_OPZIONE_ANTICIPATA.equalsIgnoreCase(tripletta) ||
                Costanti.CODICE_OPZIONE_CAMBIOFRAZ.equalsIgnoreCase(tripletta) ||
                Costanti.CODICE_OPZIONE_CERTEZZA.equalsIgnoreCase(tripletta)   ||
                Costanti.CODICE_OPZIONE_PROROGA.equalsIgnoreCase(tripletta)    ||
                Costanti.CODICE_OPZIONE_REVERSIBILITA.equalsIgnoreCase(tripletta))
            flagOpzioni = "no";
    }

	public String getTitoloReclamante() {
		return titoloReclamante;
	}

	public void setTitoloReclamante(String titoloReclamante) {
		this.titoloReclamante = titoloReclamante;
	}
}