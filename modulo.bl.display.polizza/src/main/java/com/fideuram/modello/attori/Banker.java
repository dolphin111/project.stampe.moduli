package com.fideuram.modello.attori;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 09/04/13
 * Time: 18.45
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Banker {
    private String dataInizio;
    private String stato;
    private String livello;
    private Persona privateBanker;

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) {
        this.livello = livello;
    }

    public Persona getPrivateBanker() {
        return privateBanker;
    }

    public void setPrivateBanker(Persona privateBanker) {
        this.privateBanker = privateBanker;
    }
}
