package com.fideuram.modello.polizza.altridati;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 16/04/13
 * Time: 16.12
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class DetraibilitaFiscale {
   private Boolean stato;
   private Date dataFineBeneficioFiscale;

    public Boolean getStato() {
        return stato;
    }

    public String getDataFineBeneficioFiscale() {
        return FormatterFactory.getStandardDate(dataFineBeneficioFiscale);
    }


    @Override
    public String toString() {
        if(stato)
            return "SI";
        else
            return "NO";
    }
}
