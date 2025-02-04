package com.fideuram.stampe.modello.contocorrente;

import com.fideuram.stampe.modello.utils.EncoderString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 15.08
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Divisa {
    private String nome;
    private String simbolo;

    public Divisa() {}

    public Divisa(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return EncoderString.encodUTF8(simbolo);
    }
}
