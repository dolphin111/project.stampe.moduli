package com.fideuram.stampe.modello.comunicazionecrm;

import com.fideuram.stampe.modello.utils.EncoderString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 01/09/14
 * Time: 15.07
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class TronconeCrm {
    private int id;
    private String frase;

    public TronconeCrm() {
    }

    public TronconeCrm(int id, String frase) {
        this.id = id;
        this.frase = frase;
    }

    public int getId() {
        return id;
    }

    public String getFrase() {
        return EncoderString.encodUTF8(frase);
    }


}
