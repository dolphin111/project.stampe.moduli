package com.fideuram.modello.polizza.altridati;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 18.17
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class DettagliDecumolo {
    private Double imponibile;
    private Double importoPagato;
    private Double cvn;
    private String frazionamento;
    private Double percentuale;
    private Double importoRata;
    private String durata;

    public String getImponibile() {
        return imponibile!=null?FormatterFactory.getStandardImporto(imponibile):"";
    }

    public String getImportoPagato() {
        return importoPagato!=null?FormatterFactory.getStandardImporto(importoPagato):"";
    }

    public String getCvn() {
        return cvn!=null?FormatterFactory.getStandardImporto(cvn):"";
    }

    public String getFrazionamento() {
        return frazionamento!=null?frazionamento:"";
    }

    public String getPercentuale() {
        return percentuale!=null?FormatterFactory.getStandardPercentuale(percentuale):"";
    }

    public String getImportoRata() {
        return importoRata!=null?FormatterFactory.getStandardImporto(importoRata):"";
    }

    public String getDurata() {
        return durata!=null?durata:"";
    }
}
