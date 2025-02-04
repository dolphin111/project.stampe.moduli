package com.fideuram.stampe.modello.rendiconti.prodotto.consob;

import com.fideuram.stampe.modello.rendiconti.prodotto.Fap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: v801068
 * Date: 05/02/14
 * Time: 15.29
 */
@XmlRootElement(name="RtfConsob", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RtfConsob extends Fap {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORPRTF2_CONSOB";
    }
}
