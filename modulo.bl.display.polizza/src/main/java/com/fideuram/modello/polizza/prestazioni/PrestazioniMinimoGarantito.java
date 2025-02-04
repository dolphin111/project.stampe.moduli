package com.fideuram.modello.polizza.prestazioni;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 12/04/13
 * Time: 16.50
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestazioniMinimoGarantito {
    private Double renditaAnnuaVitaliziaMinimaGarantita;
    private Double valoreRiscattoLordoScadenza;

    public String getRenditaAnnuaVitaliziaMinimaGarantita() {
        return FormatterFactory.getStandardImporto(renditaAnnuaVitaliziaMinimaGarantita);
    }

    public String getValoreRiscattoLordoScadenza() {
        return FormatterFactory.getStandardImporto(valoreRiscattoLordoScadenza);
    }

}
