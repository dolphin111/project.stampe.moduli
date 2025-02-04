package com.fideuram.modello.polizza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 15.01
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Tariffa {
    private String codice;
    private String descrizione;

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return codice +  " - "  + descrizione ;
    }
}
