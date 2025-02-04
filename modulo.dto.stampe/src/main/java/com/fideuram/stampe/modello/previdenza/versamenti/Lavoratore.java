package com.fideuram.stampe.modello.previdenza.versamenti;

import com.fideuram.stampe.modello.attori.Individuo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 16.08
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lavoratore extends Individuo{
    private String codice;
    private Contributi contributi;

    public String getCodice() {
        return codice;
    }

    public Contributi getContributi() {
        return contributi;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setContributi(Contributi contributi) {
        this.contributi = contributi;
    }
}
