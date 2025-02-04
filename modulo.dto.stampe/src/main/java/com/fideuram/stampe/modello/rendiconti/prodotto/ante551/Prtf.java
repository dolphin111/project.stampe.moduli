package com.fideuram.stampe.modello.rendiconti.prodotto.ante551;

import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: V801068
 * Date: 08/01/14
 * Time: 14.54
 */
@XmlRootElement(name="Prtf", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prtf  extends NormativaProdottoAllegato {
    @Override
    public String toString() {
        return getDataRiferimento().substring(6) +"_DTSTORPRTF";
    }
}
