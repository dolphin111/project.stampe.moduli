package com.fideuram.modello.anagrafe;

import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 15/06/12
 * Time: 9.48
 */
public class Gestore implements Serializable {
    protected boolean valido;
    private String denominazione="---";
    private String sedeLegale   ="---";
    private String nazionalita  ="---";
    private String gruppo       ="---";

    public boolean isValido() {
        return valido;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        if(null==denominazione||denominazione.trim().equals(""))
            return;
        valido=true;
        this.denominazione = denominazione;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public String getGruppo() {
        return gruppo;
    }

    public void setGruppo(String gruppo) {
        this.gruppo = gruppo;
    }
}
