package com.fideuram.stampe.modello.rendiconti;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created
 * User: v801068
 * Date: 29/01/14
 * Time: 16.58
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Patrimonio {
    private Double patrimonioNetto;
    private Double valoreQuota;



    public String getPatrimonioNetto() {
        return FormattatoreCifre.formatImporto(patrimonioNetto, ".", ",");
    }
    public String getValoreQuota() {
        return FormattatoreCifre.formatQuota(valoreQuota, ".", ",");
    }



    public void setPatrimonioNetto(Double patrimonioNetto) {
        this.patrimonioNetto = patrimonioNetto;
    }
    public void setValoreQuota(Double valoreQuota) {
        this.valoreQuota = valoreQuota;
    }

}
