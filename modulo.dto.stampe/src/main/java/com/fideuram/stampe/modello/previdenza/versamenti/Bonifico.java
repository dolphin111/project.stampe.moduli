package com.fideuram.stampe.modello.previdenza.versamenti;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 14.40
 */
@XmlRootElement(name="Bonifico", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class    Bonifico {

    private String causale;
    private String importoDistinta;
    private String importoDaBonificare;
    private String iban;
    private String intestatoA;

    public String getIntestatoA() {
        return intestatoA;
    }

    public String getCausale() {
        return causale;
    }

    public String getImportoDistinta() {
        return FormattatoreCifre.formatImporto(Double.valueOf(importoDistinta), ".", ",");

    }

    public String getImportoDaBonificare() {
        return FormattatoreCifre.formatImporto(Double.valueOf(importoDaBonificare), ".", ",");
    }

    public String getIban() {
        return iban;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public void setImportoDistinta(String importoDistinta) {
        this.importoDistinta = importoDistinta;
    }

    public void setImportoDaBonificare(String importDaBonificare) {
        this.importoDaBonificare = importDaBonificare;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setIntestatoA(String intestatoA) {
        this.intestatoA = intestatoA;
    }
}
