package com.fideuram.modello.polizza.contabile;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 23/04/13
 * Time: 17.55
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class PremiIncassati {

    private Date dataRiferimento;
    private Double totaleImporti;
    @XmlElement(name = "listaPremiIncassati")
    private List<PremioIncassato> premioIncassatos=new ArrayList<PremioIncassato>();

    public String getDataRiferimento() {
        return FormatterFactory.getStandardDate(dataRiferimento);
    }

    public String getTotaleImporti() {
        return FormatterFactory.getStandardImporto(totaleImporti);
    }

    public List<PremioIncassato> getPremioIncassatos() {
        return premioIncassatos;
    }
}
