package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 17.30
 */
public class Oggetto {
    private String polizza; 
    private String frazionamento;
    private String scadenza;

    public String getPolizza() {
        return polizza.trim();
    }

    @XmlElement(name = "POLIZZA")
    public void setPolizza(String polizza) {
        this.polizza = polizza;
    }

    public String getFrazionamento() {
        return frazionamento.trim();
    }

    @XmlElement(name = "FRAZIONAMENTO")
    public void setFrazionamento(String frazionamento) {
        this.frazionamento = frazionamento;
    }

    public String getScadenza() {
        return scadenza.trim();
    }

    @XmlElement(name = "SCADENZA")
    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }
}
