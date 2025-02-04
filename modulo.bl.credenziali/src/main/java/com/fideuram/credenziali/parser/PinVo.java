package com.fideuram.credenziali.parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 11/09/14
 * Time: 12.31
 */
@XmlRootElement(name="DatiLetteraPinPVO", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class PinVo {
    private String polizza        ="";
    private String user           ="";
    private String password       ="";
    private String daInviare      ="";
    private String nome           ="";
    private String cognome        ="";
    private String sesso          ="";
    private String provincia      ="";
    private String regione        ="";
    private String cap            ="";
    private String nazione        ="";
    private String indirizzo      ="";
    private String discriminator  ="";
    private String citta          ="";
    private String ragioneSociale ="";
    private boolean isMail;

    public String getPolizza() {
        return polizza;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDaInviare() {
        return daInviare;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getRegione() {
        return regione;
    }

    public String getCap() {
        return cap;
    }

    public String getNazione() {
        return nazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public String getCitta() {
        return citta;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public boolean isMail() {
        return isMail;
    }
}
