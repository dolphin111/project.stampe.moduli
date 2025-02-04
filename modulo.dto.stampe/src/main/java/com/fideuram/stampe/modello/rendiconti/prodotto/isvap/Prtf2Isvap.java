package com.fideuram.stampe.modello.rendiconti.prodotto.isvap;

import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 16.09
 */
@XmlRootElement(name="Prtf2Isvap", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prtf2Isvap extends NormativaProdottoAllegato {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORPRTF2";
    }
}
