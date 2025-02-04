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
 * Time: 18.58
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class BonusReale {
    @XmlElement(name = "Valore")
    private Double valore;
    private Date dataRiferimento;
    @XmlElement(name = "ListaDettaglioBonus")
    private ListaDettaglioBonus listaDettaglioBonus;


    public String getValore() {
        return FormatterFactory.getStandardImporto(valore);
    }

    public String getDataRiferimento() {
        return FormatterFactory.getStandardDate(dataRiferimento);
    }

    public ListaDettaglioBonus getListaDettaglioBonus() {
        return listaDettaglioBonus;
    }
}
