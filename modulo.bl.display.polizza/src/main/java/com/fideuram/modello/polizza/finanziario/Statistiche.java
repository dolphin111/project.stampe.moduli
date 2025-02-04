package com.fideuram.modello.polizza.finanziario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: logan
 * Date: 05/07/13
 * Time: 17.46
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistiche {
    private Double totale        ;
    private Double valore        ;
    private String percentuale   ;
    private String descrizione   ;
    private String codiceColore  ;

    public Double getTotale() {
        return totale;
    }

    public Double getValore() {
        return valore;
    }

    public String getPercentuale() {
        return percentuale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCodiceColore() {
        return codiceColore;
    }
}
