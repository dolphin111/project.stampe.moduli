package com.fideuram.stampe.modello.previdenza.versamenti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 15.29
 */
@XmlRootElement(name="VersamentiPrevidenza", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class VersamentiPrevidenza {
    private Bonifico bonifico;
    private Distinta distinta;
    private boolean sollecito=false;

    public Bonifico getBonifico() {
        return bonifico;
    }

    public Distinta getDistinta() {
        return distinta;
    }

    public void setBonifico(Bonifico bonifico) {
        this.bonifico = bonifico;
    }

    public void setDistinta(Distinta distinta) {
        this.distinta = distinta;
    }

    public boolean isSollecito() {
        return sollecito;
    }

    public void setSollecito(boolean sollecito) {
        this.sollecito = sollecito;
    }
}
