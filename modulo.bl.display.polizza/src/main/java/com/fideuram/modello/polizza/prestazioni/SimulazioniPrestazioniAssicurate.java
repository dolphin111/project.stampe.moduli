package com.fideuram.modello.polizza.prestazioni;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 02/05/13
 * Time: 10.47
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class SimulazioniPrestazioniAssicurate {
    private Double eccedenza;
    private Double riscattoLordo;
    private Date dataRiferimento;

    public String getEccedenza() {
        return FormatterFactory.getStandardImporto(eccedenza);
    }

    public String  getRiscattoLordo() {
        return FormatterFactory.getStandardImporto(riscattoLordo);
    }

    public String getDataRiferimento() {
        return FormatterFactory.getStandardDate(dataRiferimento);
    }
}
