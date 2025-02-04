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
 * Date: 11/04/13
 * Time: 18.49
 */
@XmlRootElement(name="dettaglioBonus")
@XmlAccessorType(XmlAccessType.FIELD)
public class DettaglioBonus {
   private Double valore;
   private Date dataCalcolo;
   @XmlElement(name = "Tipo")
   private String tipo;

    public String getValore() {
        return FormatterFactory.getStandardImporto(valore);
    }

    public String getDataCalcolo() {
        return FormatterFactory.getStandardDate(dataCalcolo);
    }


    public String getTipo() {
        return tipo;
    }

}
