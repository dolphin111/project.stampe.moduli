package com.fideuram.modello.polizza;

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
public class Rol {
    private String codiceStato;

    public String getCodiceStato() {
        return codiceStato;
    }

    @Override
    public String toString() {
       if(codiceStato.equalsIgnoreCase("0"))
           return "NO";
       else
           return "SI";

    }
}
