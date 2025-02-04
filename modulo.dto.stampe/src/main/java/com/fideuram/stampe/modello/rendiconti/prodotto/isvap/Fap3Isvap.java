package com.fideuram.stampe.modello.rendiconti.prodotto.isvap;

import com.fideuram.stampe.modello.rendiconti.prodotto.Fap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created
 * User: v801068
 * Date: 28/01/14
 * Time: 11.20
 */
@XmlRootElement(name="Fap3Isvap", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fap3Isvap extends Fap {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6)+"_DTSTORFAP3_551"+periodo;
    }
}
