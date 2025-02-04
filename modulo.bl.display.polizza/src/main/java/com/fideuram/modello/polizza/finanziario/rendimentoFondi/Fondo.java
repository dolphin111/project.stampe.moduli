package com.fideuram.modello.polizza.finanziario.rendimentoFondi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 11.24
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Fondo {
    private Double  codice;
    private String  descrizione;
    private Double  valoreFront;
    private Date    dataRiferimento;
    private DatiRendimento dati;

    public Double getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Double getValoreFront() {
        return valoreFront;
    }

    public Date getDataRiferimento() {
        return dataRiferimento;
    }

    public DatiRendimento getDati() {
        return dati;
    }
}
