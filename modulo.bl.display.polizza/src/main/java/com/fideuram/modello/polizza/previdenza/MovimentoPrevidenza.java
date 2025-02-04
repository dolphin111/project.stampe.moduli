package com.fideuram.modello.polizza.previdenza;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 15.30
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class MovimentoPrevidenza {
    private Date   dataOperazione;
    private Date   dataQuota;
    private String causale;
    private Double costi;
    private Double iscritto;
    private Double datore;
    private Double tfr;
    private Double totale;

    public String getDataOperazione() {
        return FormatterFactory.getStandardDate(dataOperazione);
    }

    public String getDataQuota() {
        return FormatterFactory.getStandardDate(dataQuota);
    }

    public String getCausale() {
        return causale;
    }

    public String getCosti() {
        return FormatterFactory.getStandardImporto(costi);
    }

    public String getIscritto() {
        return FormatterFactory.getStandardImporto(iscritto);
    }

    public String getDatore() {
        return FormatterFactory.getStandardImporto(datore);
    }

    public String getTfr() {
        return FormatterFactory.getStandardImporto(tfr);
    }

    public String getTotale() {
        return FormatterFactory.getStandardImporto(totale);
    }

}
