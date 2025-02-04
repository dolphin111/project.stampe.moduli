package com.fideuram.stampe.modello.rendiconti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: V801068
 * Date: 08/01/14
 * Time: 14.18
 *
 * nb
 * NEI DOCUMENTI DI RENDIMENTO VIENE RAPPRESENTATO COME VALORE UNITARIO DELLA QUOTA
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class RendimentoMensile extends Rendimento{

    private Integer  mese;

    public Integer getMese() {
        return mese;
    }

    public void setMese(Integer mese) {
        this.mese = mese;
    }

}
