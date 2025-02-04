package com.fideuram.modello.polizza.protetta;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 02/07/15
 * Time: 7.30
 */
@XmlRootElement(name="dettaglioLinea", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineaInvestimento {
    private Double controvaloreInProtezione;
    private Double controvaloreProtetto;

    private Double controValoreNav;
    @XmlElement(name = "descrizioneLinea")
    private String descrizione;
    @XmlElement(name = "isProtetta")
    private String percorso;

    public String getControvaloreInProtezione() {
        return controvaloreInProtezione!=null?FormatterFactory.getStandardImporto(controvaloreInProtezione):"";
    }

    public String getControvaloreProtetto() {
        return controvaloreProtetto!=null?FormatterFactory.getStandardImporto(controvaloreProtetto):"";
    }

    public String getControValoreNav() {
        return controValoreNav!=null?FormatterFactory.getStandardImporto(controValoreNav):"";
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getPercorso() {
        return percorso.trim().toUpperCase().equals("NO")?"NON Protetta":"Protetta";
    }
}
