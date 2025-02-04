package com.fideuram.stampe.modello.rendiconti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: v801068
 * Date: 31/01/14
 * Time: 12.29
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Rischio {
    private String profilo;

    public String getProfilo() {
        if(null==profilo)
            return "---";
        return profilo;
    }

    public void setProfilo(String profilo) {
        this.profilo = profilo;
    }
}
