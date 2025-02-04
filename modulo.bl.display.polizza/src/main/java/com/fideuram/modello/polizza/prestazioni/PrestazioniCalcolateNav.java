package com.fideuram.modello.polizza.prestazioni;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 12/04/13
 * Time: 16.22
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestazioniCalcolateNav {
    private Double quote;
    private Double ipotesiControvaloreQuoteNav;
    private Double premiVersatiNav;
    private Double valoreRiscattoScadenza;
    private Date dataRiferimentoNav;

    public String getDataRiferimentoNav() {
        return FormatterFactory.getStandardDate(dataRiferimentoNav);
    }

    public String getQuote() {
        return FormatterFactory.getStandardImporto(quote);
    }

    public String getIpotesiControvaloreQuoteNav() {
        return FormatterFactory.getStandardImporto(ipotesiControvaloreQuoteNav);
    }

    public String getPremiVersatiNav() {
        return FormatterFactory.getStandardImporto(premiVersatiNav);
    }

    public String getValoreRiscattoScadenza() {
        return FormatterFactory.getStandardImporto(valoreRiscattoScadenza);
    }
}
