package com.fideuram.stampe.modello.previdenza.versamenti;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 16.10
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contributi {
    private String tfr;
    private String datore;
    private String iscritto;
    private String premioProduttivita;
    private String totale;

    
    public String getPremioProduttivita() {
        return FormattatoreCifre.formatImporto(Double.valueOf(premioProduttivita), ".", ",");
    }

    public void setPremioProduttivita(String premioProduttivita) {
        this.premioProduttivita = premioProduttivita;
    }
    
    public String getTfr() {
        return FormattatoreCifre.formatImporto(Double.valueOf(tfr), ".", ",");

    }

    public void setTfr(String tfr) {
        this.tfr = tfr;
    }

    public String  getDatore() {
        return FormattatoreCifre.formatImporto(Double.valueOf(datore), ".", ",");

    }

    public void setDatore(String datore) {
        this.datore = datore;
    }

    public String getIscritto() {
        return FormattatoreCifre.formatImporto(Double.valueOf(iscritto), ".", ",");

    }

    public void setIscritto(String iscritto) {
        this.iscritto = iscritto;
    }

    public String  getTotale() {
        return FormattatoreCifre.formatImporto(Double.valueOf(totale), ".", ",");

    }

    public void setTotale(String totale) {
        this.totale = totale;
    }
}
