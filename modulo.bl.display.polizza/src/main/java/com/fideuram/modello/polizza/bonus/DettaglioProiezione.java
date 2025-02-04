package com.fideuram.modello.polizza.bonus;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 19.38
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class DettaglioProiezione {
    private Double valore;
    @XmlElement(name = "dataRiferimento")
    private Date annoRiferimento;

    private Double totale;
    private Double baseCalcolo;

    public String getValore() {
        return FormatterFactory.getStandardImporto(valore);
    }

    public String getAnnoRiferimento() {
        return FormatterFactory.getStandardDate(annoRiferimento);
    }

    public String getBaseCalcolo() {
        return FormatterFactory.getStandardImporto(baseCalcolo);
    }

    public String getTotale() {
        return FormatterFactory.getStandardImporto(totale);
    }
}
