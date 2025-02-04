package com.fideuram.stampe.modello.rendiconti.prodotto.consob;

import com.fideuram.stampe.modello.rendiconti.prodotto.Fap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: v801068
 * Date: 29/01/14
 * Time: 17.21
 */
@XmlRootElement(name="Fap3Consob", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fap3Consob extends Fap {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORFAP3_CONSOB";
    }
}
