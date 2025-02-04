package com.fideuram.stampe.modello.rendiconti.prodotto.fgp;

import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: v801068
 * Date: 31/01/14
 * Time: 12.44
 */
@XmlRootElement(name="Fgp", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fgp extends NormativaProdottoAllegato{
    @Override
    public String toString() {
        return getDataRiferimento().substring(6)+"_DTSTORFGP";
    }
}
