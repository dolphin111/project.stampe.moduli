package com.fideuram.modello.polizza.bonus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 15.26
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class BonusPremium4X4 {
    @XmlElement(name = "BonusMaturatoGiornaliero")
    private BonusReale bonusMaturatoGiornaliero;
    @XmlElement(name = "BonusIQuinquennio")
    private BonusReale bonusIQuinquennio;
    @XmlElement(name = "BonusIIQuinquennio")
    private BonusReale bonusIIQuinquennio;
    @XmlElement(name = "ProiezioneQuinquenni")
    private ProiezioneQuinquenni proiezioneQuinquenni;
    public BonusReale getBonusMaturatoGiornaliero() {
        return bonusMaturatoGiornaliero;
    }

    public BonusReale getBonusIQuinquennio() {
        return bonusIQuinquennio;
    }

    public BonusReale getBonusIIQuinquennio() {
        return bonusIIQuinquennio;
    }

    public ProiezioneQuinquenni getProiezioneQuinquenni() {
        return proiezioneQuinquenni;
    }
}
