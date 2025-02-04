package com.fideuram.modello.polizza.prestazioni;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: logan
 * Date: 14/10/13
 * Time: 11.20
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Rendita {
    private Double   ipotesiValoreRiscattoScadenza                   ;
    private Double   stimaTotaleRenditaScadenza                      ;
    private boolean  isPianoCompletato                               ;
    private Double   stimaTotaleRenditaScadenzaPianoCompletatoSPI    ;
    private Double   renditaAnnuaVitaliziaMinimaGarantita            ;
    private Double   stimaTotaleRenditaScadenzaPianoNonCompletatoSPI ;
    private Double   renditaTotaleAnnuaLordaPosticipataScadenza      ;
    private Double   totalePrestazioniRendita;

    public String getIpotesiValoreRiscattoScadenza() {
        return FormatterFactory.getStandardImporto(ipotesiValoreRiscattoScadenza);
    }

    public String getStimaTotaleRenditaScadenza() {
        return FormatterFactory.getStandardImporto(stimaTotaleRenditaScadenza);
    }

    public boolean isPianoCompletato() {
        return isPianoCompletato;
    }

    public String getStimaTotaleRenditaScadenzaPianoCompletatoSPI() {
        return FormatterFactory.getStandardImporto(stimaTotaleRenditaScadenzaPianoCompletatoSPI);
    }

    public String getRenditaAnnuaVitaliziaMinimaGarantita() {
        return FormatterFactory.getStandardImporto(renditaAnnuaVitaliziaMinimaGarantita);
    }

    public String getStimaTotaleRenditaScadenzaPianoNonCompletatoSPI() {
        return FormatterFactory.getStandardImporto(stimaTotaleRenditaScadenzaPianoNonCompletatoSPI);
    }

    public String getRenditaTotaleAnnuaLordaPosticipataScadenza() {
        return FormatterFactory.getStandardImporto(renditaTotaleAnnuaLordaPosticipataScadenza);
    }

    public String getTotalePrestazioniRendita() {
        return FormatterFactory.getStandardImporto(totalePrestazioniRendita);
    }

    public Double getTotalePrestazioniRenditaDoubleFormat() {
        return totalePrestazioniRendita;
    }


}
