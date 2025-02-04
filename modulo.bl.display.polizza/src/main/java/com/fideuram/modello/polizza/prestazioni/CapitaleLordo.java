package com.fideuram.modello.polizza.prestazioni;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: logan
 * Date: 14/10/13
 * Time: 11.34
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class CapitaleLordo {

    private Double coefficienteCapitale;
    private Double importoEuro         ;
    private Double importoValuta       ;
    private Double cambioInEuro        ;

    public Double getCambioInEuro() {
        return cambioInEuro;
    }

    public Double getCoefficienteCapitale() {
        return coefficienteCapitale;
    }

    public String getImportoEuro() {
        return FormatterFactory.getStandardImporto(importoEuro);
    }

    public String getImportoValuta() {
        return FormatterFactory.getStandardImporto(importoValuta);
    }


}
