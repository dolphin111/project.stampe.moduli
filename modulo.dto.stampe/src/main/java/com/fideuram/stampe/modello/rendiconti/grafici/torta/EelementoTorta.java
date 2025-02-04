package com.fideuram.stampe.modello.rendiconti.grafici.torta;

import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 18.03
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class EelementoTorta {
    private String key;
    private Double value;
    private String codiceColore;

    public EelementoTorta() {}

    public EelementoTorta(String key, Double value) {
        this.key = key;
        this.value = value;
    }

    public EelementoTorta(String key, Double value, String codiceColore) {
        this.key = key;
        this.value = value;
        this.codiceColore = codiceColore;
    }

    public String getKey() {
        return key;
    }

    public Double getValue() {
        return value;
    }

    public String valStr() {
        return FormattatorePerc.percentualeStandard(value,true);
    }

    public String getCodiceColore() {
        return codiceColore;
    }

    public void setCodiceColore(String codiceColore) {
        this.codiceColore = codiceColore;
    }
}
