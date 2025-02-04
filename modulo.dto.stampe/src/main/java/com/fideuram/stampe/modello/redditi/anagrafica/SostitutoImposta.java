package com.fideuram.stampe.modello.redditi.anagrafica;

import com.fideuram.stampe.modello.attori.Compagnia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 18/11/14
 * Time: 17.02
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class SostitutoImposta extends Compagnia{
    private String codAttivita;
    private String codSede;

    public String getCodAttivita() {
        return codAttivita;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodAttivita(String codAttivita) {
        this.codAttivita = codAttivita;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

}
