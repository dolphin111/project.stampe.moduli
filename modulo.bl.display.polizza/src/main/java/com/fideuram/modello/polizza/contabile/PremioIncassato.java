package com.fideuram.modello.polizza.contabile;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 10.34
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class PremioIncassato {
    private String progressivoTitolo;
    private Date dataEffetto;
    private Date dataValuta ;
    private String divisa;
    private Double importoLordo;
    private String descrizioneTipoTitolo;

    public String getDataEffetto() {
        return FormatterFactory.getStandardDate(dataEffetto);
    }

    public String getDataValuta() {
        return FormatterFactory.getStandardDate(dataValuta);
    }

    public String getDivisa() {
        return divisa;
    }

    public String getImportoLordo() {
        return FormatterFactory.getStandardImporto(importoLordo);
    }

    public String getDescrizioneTipoTitolo() {
        return descrizioneTipoTitolo;
    }

    public String getProgressivoTitolo() {
        return progressivoTitolo;
    }
}
