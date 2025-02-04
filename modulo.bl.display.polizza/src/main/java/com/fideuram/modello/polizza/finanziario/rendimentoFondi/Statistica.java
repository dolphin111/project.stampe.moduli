package com.fideuram.modello.polizza.finanziario.rendimentoFondi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 11.47
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistica {
    private Double  valore                 ;
    private Double  valoreDaInizioAnno     ;
    private Double  valoreDaInizioGestione ;
    private Double  valoreDelTrimestre     ;
    private Date    data                   ;
    private Date    dataDaInizioAnno       ;
    private Date    dataDaInizioGestione   ;
    private Date    dataDelTrimestre       ;
    private String  descrizione            ;
    private Boolean isTirAnomalo           ;

    public Double getValore() {
        return valore;
    }

    public Double getValoreDaInizioAnno() {
        return valoreDaInizioAnno;
    }

    public Double getValoreDaInizioGestione() {
        return valoreDaInizioGestione;
    }

    public Double getValoreDelTrimestre() {
        return valoreDelTrimestre;
    }

    public Date getData() {
        return data;
    }

    public Date getDataDaInizioAnno() {
        return dataDaInizioAnno;
    }

    public Date getDataDaInizioGestione() {
        return dataDaInizioGestione;
    }

    public Date getDataDelTrimestre() {
        return dataDelTrimestre;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Boolean getTirAnomalo() {
        return isTirAnomalo;
    }
}
