package com.fideuram.stampe.modello.rendiconti.prodotto.isvap;

import com.fideuram.stampe.modello.rendiconti.prodotto.Fap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: v801068
 * Date: 11/02/14
 * Time: 11.11
 */
@XmlRootElement(name="FapIsvap", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class FapIsvap extends Fap {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORFAP";
    }
}
