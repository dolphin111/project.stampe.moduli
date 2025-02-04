package com.fideuram.stampe.modello.rendiconti.prodotto.isvap;

import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 18.53
 */
@XmlRootElement(name="FaoIsvap", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class FaoIsvap extends NormativaProdottoAllegato {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORFAO";
    }
}
