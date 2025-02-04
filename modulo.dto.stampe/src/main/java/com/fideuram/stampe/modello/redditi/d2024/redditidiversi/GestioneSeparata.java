package com.fideuram.stampe.modello.redditi.d2024.redditidiversi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 18/01/16
 * Time: 19.27
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class GestioneSeparata {
    private Q24 q24;

    public Q24 getQ24() {
        return q24;
    }

    public void setQ24(Q24 q24) {
        this.q24 = q24;
    }
}