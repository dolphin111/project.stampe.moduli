package com.fideuram.modello.attori;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 16.31
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Indirizzo {
    private String tipoIndirizzo;
    private String indirizzo;
    private String cap;
    private String comune;
    private String provincia;
    private String regione;
    private String nazione;
    private String dataAggiornamento;

    public String getTipoIndirizzo() {
        return tipoIndirizzo;
    }

    public void setTipoIndirizzo(String tipoIndirizzo) {
        this.tipoIndirizzo = tipoIndirizzo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
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

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    public void setDataAggiornamento(String dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }
}
