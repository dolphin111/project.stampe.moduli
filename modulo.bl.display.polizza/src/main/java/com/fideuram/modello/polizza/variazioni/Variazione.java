package com.fideuram.modello.polizza.variazioni;

import com.fideuram.factory.FormatterFactory;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

/**
 * User: V801068
 * Date: 23/02/15
 * Time: 10.18
 */
@XmlType(name="Variazione")
public class Variazione {

    private Date    dataScadenzaInVigore;
    private Date    dataNuovaScadenza;
    private Date    dataEffetto;
    private String  tipoAttivita;
    private String  tipoDifferimento;
    private String  tipoFrazionamentoPremio;

    public String getDataEffetto() {
        return dataEffetto!=null?FormatterFactory.getStandardDate(dataEffetto):"";
    }

    public String getDataScadenzaInVigore() {
        return dataScadenzaInVigore!=null?FormatterFactory.getStandardDate(dataScadenzaInVigore):"";
    }

    public String getDataNuovaScadenza() {
        return dataNuovaScadenza!=null?FormatterFactory.getStandardDate(dataNuovaScadenza):"";
    }


    public String getTipoAttivita() {
        return tipoAttivita;
    }

    public String getTipoDifferimento() {
        return tipoDifferimento;
    }

    public String getTipoFrazionamentoPremio() {
        return tipoFrazionamentoPremio;
    }

    public void setTipoFrazionamentoPremio(String tipoFrazionamentoPremio) {
        this.tipoFrazionamentoPremio = tipoFrazionamentoPremio;
    }

    public void setTipoDifferimento(String tipoDifferimento) {
        this.tipoDifferimento = tipoDifferimento;
    }

    public void setTipoAttivita(String tipoAttivita) {
        this.tipoAttivita = tipoAttivita;
    }

    public void setDataNuovaScadenza(Date dataNuovaScadenza) {
        this.dataNuovaScadenza = dataNuovaScadenza;
    }

    public void setDataScadenzaInVigore(Date dataScadenzaInVigore) {
        this.dataScadenzaInVigore = dataScadenzaInVigore;
    }

    public void setDataEffetto(Date dataEffetto) {
        this.dataEffetto = dataEffetto;
    }
}
