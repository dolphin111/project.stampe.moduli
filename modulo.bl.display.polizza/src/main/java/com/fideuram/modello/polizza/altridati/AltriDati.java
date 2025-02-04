package com.fideuram.modello.polizza.altridati;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 16/04/13
 * Time: 16.10
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AltriDati {
    private String              tipoClasseBonus;
    private boolean             isRiallocazioneGuidata;
    private Vincolo             vincolo;
    private CaricamentiCPP      caricamentiCPP;
    private DecumuloCedola      decumuloCedola;
    private DetraibilitaFiscale detraibilitaFiscale;

    private Double              imponibileCongelamento;
    private String              classeCPP;
    private Double              percentualeCaricamentoCPP;
    private Double              importoPianoProgrammatoVersamenti;
    private String              polizzaDerivanteDaTrasformazione;
    private Boolean             polizzaScudata;
    private Double              impostaBolloMaturata;

    public String getTipoClasseBonus() {
        return tipoClasseBonus;
    }

    public String getRiallocazioneGuidata() {
        return isRiallocazioneGuidata?"SI":"NO";
    }

    public boolean isRiallocazioneGuidata() {
        return isRiallocazioneGuidata;
    }

    public Vincolo getVincolo() {
        return vincolo;
    }

    public CaricamentiCPP getCaricamentiCPP() {
        return caricamentiCPP;
    }

    public DecumuloCedola getDecumuloCedola() {
        return decumuloCedola;
    }

    public DetraibilitaFiscale getDetraibilitaFiscale() {
        return detraibilitaFiscale;
    }

    public String getImponibileCongelamento() {
        return FormatterFactory.getStandardImporto(imponibileCongelamento);
    }

    public String getClasseCPP() {
        return classeCPP;
    }

    public String getPercentualeCaricamentoCPP() {
        return FormatterFactory.getStandardImporto(percentualeCaricamentoCPP);
    }

    public String getImportoPianoProgrammatoVersamenti() {
        return FormatterFactory.getStandardImporto(importoPianoProgrammatoVersamenti);
    }

    public String getPolizzaDerivanteDaTrasformazione() {
        return polizzaDerivanteDaTrasformazione;
    }

    public String getPolizzaScudata() {
        if(polizzaScudata)
            return "SI";
        else
            return "NO";
    }

    public String getImpostaBolloMaturata() {
        return FormatterFactory.getStandardImporto(impostaBolloMaturata);
    }
}
