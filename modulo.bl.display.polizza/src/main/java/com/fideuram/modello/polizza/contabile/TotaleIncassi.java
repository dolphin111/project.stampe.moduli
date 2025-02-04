package com.fideuram.modello.polizza.contabile;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 11/10/13
 * Time: 16.03
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class TotaleIncassi {
    private Double importoEuro    ;
    private Double importoValuta  ;
    private Date   dataCambio     ;
    private Double cambioInEuro   ;
    private String divisa         ;

    public String getImportoEuro() {
        return FormatterFactory.getStandardImporto(importoEuro);
    }

    public String getImportoValuta() {
        return FormatterFactory.getStandardImporto(importoValuta);
    }

    public String getDataCambio() {
        return FormatterFactory.getStandardDate(dataCambio);
    }

    public String getCambioInEuro() {
        return FormatterFactory.getStandardTasso(cambioInEuro);
    }

    public String getDivisa() {
        return divisa;
    }

    public Boolean hasTassoCambio(){
        if(divisa.trim().equalsIgnoreCase("EUR"))
            return false;
        return true;
    }
}
