package com.fideuram.stampe.modello.rendiconti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 16.21
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Gestione {
    private String stile;
    private String obiettivo;

    public Gestione() {}

    public Gestione(String stile, String obiettivo) {
        this.stile = stile;
        this.obiettivo=obiettivo;
    }


    public String getStile() {
        return stile;
    }

    public String getObiettivo() {
        return obiettivo;
    }
}
