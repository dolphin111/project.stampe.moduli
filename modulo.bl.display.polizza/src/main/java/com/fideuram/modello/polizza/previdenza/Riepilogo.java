package com.fideuram.modello.polizza.previdenza;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 12/04/13
 * Time: 15.22
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Riepilogo {
    private String descrizioneComparto;
    private Double importoContributi;
    private Double importoAnticipazione;
    private Double importoSwitch;
    private Double numeroQuote;
    private Double valoreQuota;
    private Double valorePosizioneIndividuale;

    public String getDescrizioneComparto() {
        return descrizioneComparto;
    }

    public String getImportoContributi() {
        return FormatterFactory.getStandardImporto(importoContributi);
    }

    public String getImportoAnticipazione() {
        return FormatterFactory.getStandardImporto(importoAnticipazione);
    }

    public String getImportoSwitch() {
        return FormatterFactory.getStandardImporto(importoSwitch);
    }

    public String getNumeroQuote() {
        return FormatterFactory.getStandardQuote(numeroQuote);
    }

    public String getValoreQuota() {
        return FormatterFactory.getStandardQuote(valoreQuota);
    }

    public String getValorePosizioneIndividuale() {
        return FormatterFactory.getStandardImporto(valorePosizioneIndividuale);
    }
}
