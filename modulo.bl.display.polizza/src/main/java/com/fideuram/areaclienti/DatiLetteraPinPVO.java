package com.fideuram.areaclienti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DatiLetteraPinPVO", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
@Deprecated
public class DatiLetteraPinPVO {

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
