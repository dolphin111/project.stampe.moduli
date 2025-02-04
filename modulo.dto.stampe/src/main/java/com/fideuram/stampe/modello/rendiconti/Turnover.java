package com.fideuram.stampe.modello.rendiconti;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: V801068
 * Date: 08/01/14
 * Time: 14.29
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Turnover {
    private Integer anno;
    private Double  turnover;

    public String getAnno() {
        if(null==anno)
            return "---";
        return anno.toString();
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getTurnover(){
        if(null==turnover)
            return "---";
        return FormattatorePerc.percentualeNonStandard(turnover, ".", ",", 3, true);
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }
}
