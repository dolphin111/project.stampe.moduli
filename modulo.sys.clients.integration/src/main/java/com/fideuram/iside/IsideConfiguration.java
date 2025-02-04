package com.fideuram.iside;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by
 * User: logan
 * Date: 11/12/12
 * Time: 12.05
 */
public abstract class IsideConfiguration {
    protected String codiceMimeType;
    protected String codiceTipologia;
    protected String label;
    protected int    dimensione=000000;
    protected byte file[];
    protected String nomeFile;
    protected String utente;
    protected String numPolizza;
    protected XMLGregorianCalendar dataCreazione, dataScanner;

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }
    public void setUtente(String utente) {
        this.utente = utente;
    }

    public void setNumPolizza(String numPolizza) {
        this.numPolizza = numPolizza;
    }

    public void setDataCreazione(XMLGregorianCalendar dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public void setDataScanner(XMLGregorianCalendar dataScanner) {
        this.dataScanner = dataScanner;
    }

    public String getCodiceMimeType() {
        return codiceMimeType;
    }

    public String getCodiceTipologia() {
        return codiceTipologia;
    }

    public String getLabel() {
        return label;
    }

    public int getDimensione() {
        return dimensione;
    }

    public byte[] getFile() {
        return file;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public String getUtente() {
        return utente;
    }

    public String getNumPolizza() {
        return numPolizza;
    }

    public XMLGregorianCalendar getDataCreazione() {
        return dataCreazione;
    }



    public XMLGregorianCalendar getDataScanner() {
        return dataScanner;
    }


}
