package com.fideuram.stampe.modello.previdenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Created by V801068 on 03/06/14.
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
@Deprecated
public class Convenzione {
    private String titolo;

    public String getTitolo() {
        return titolo!=null?titolo:"Fondo Pensione Fideuram";
    }

    public String getTitoloUpper() {
        return titolo!=null?titolo.toUpperCase():"---";
    }


    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
