package com.fideuram.modello.polizza.altridati;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 16.11
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Vincolo {
    private Boolean attivo;

    public Boolean getAttivo() {
        return attivo;
    }

    @Override
    public String toString() {
        if(attivo)
            return "SI";
        else
            return "NO";
    }
}
