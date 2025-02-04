package com.fideuram.stampe.modello.rendiconti.prodotto.ante551;

import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: V801068
 * Date: 08/01/14
 * Time: 14.53
 */
@XmlRootElement(name="Fulaa", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fulaa  extends NormativaProdottoAllegato {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORFULAA";
    }
}
