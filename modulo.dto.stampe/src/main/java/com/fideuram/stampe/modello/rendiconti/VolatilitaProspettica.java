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
 * Time: 14.19
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class VolatilitaProspettica {

    private String  percVolatilitaMaxAttesa="";
    private String  percVolatilitaProspettica="---";
    private Double  percVolatilitaEffettiva;
    private String  volExAnte;
    private Rischio rischio;


    public String getPercVolatilitaMaxAttesa() {
        return percVolatilitaMaxAttesa!=null?percVolatilitaMaxAttesa:"";
    }

    public String getPercVolatilitaProspettica() {
        if(null==percVolatilitaProspettica)
            return "---";
        return percVolatilitaProspettica+" %";
    }

    public void setPercVolatilitaMaxAttesa(String percVolatilitaMaxAttesa) {
        this.percVolatilitaMaxAttesa = percVolatilitaMaxAttesa;
    }

    public void setPercVolatilitaProspettica(String percVolatilitaProspettica) {
        this.percVolatilitaProspettica = percVolatilitaProspettica;
    }

    public String getPercVolatilitaEffettiva() {
        if(null==percVolatilitaEffettiva)
            return "---";
        return percVolatilitaEffettiva!=null?FormattatorePerc.percentualeNonStandard(percVolatilitaEffettiva, ".", ",", 3, true):"";
    }

    public void setPercVolatilitaEffettiva(Double percVolatilitaEffettiva) {
        this.percVolatilitaEffettiva = percVolatilitaEffettiva;
    }

    public String getVolExAnte() {
        if(null==volExAnte)
            return "---";
        return volExAnte;
    }

    public void setVolExAnte(String volExAnte) {
        this.volExAnte = volExAnte;
    }


    public Rischio getRischio() {
        return rischio!=null?rischio:new Rischio();
    }

    public void setRischio(Rischio rischio) {
        this.rischio = rischio;
    }
}
