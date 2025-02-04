package com.fideuram.stampe.modello.rendiconti.composizione;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: v801068
 * Date: 24/02/14
 * Time: 11.10
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class FondoAnnidato {
    private String    nomeFondo="---";
    private Double    pesoPercentuale;

    public String getNomeFondo() {
        return nomeFondo;
    }

    public String getPesoPercentuale() {
        return FormattatorePerc.percentualeStandard(pesoPercentuale, true);
    }

    public void setNomeFondo(String nomeFondo) {
        this.nomeFondo = nomeFondo;
    }

    public void setPesoPercentuale(Double pesoPercentuale) {
        this.pesoPercentuale = pesoPercentuale;
    }


}
