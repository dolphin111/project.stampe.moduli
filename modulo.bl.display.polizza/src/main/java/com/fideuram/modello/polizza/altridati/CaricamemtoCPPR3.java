package com.fideuram.modello.polizza.altridati;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 16.22
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class CaricamemtoCPPR3 {
   private String descrizione           ;
   private String tipoTitolo;
   private Double percentualeCaricamento;

    public String getDescrizione() {
        return descrizione;
    }

    public String getTipoTitolo() {
        return tipoTitolo;
    }

    public String getPercentualeCaricamento() {
        return FormatterFactory.getStandardImporto(percentualeCaricamento);
    }
}
