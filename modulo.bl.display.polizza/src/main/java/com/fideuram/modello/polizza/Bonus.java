package com.fideuram.modello.polizza;

import com.fideuram.modello.polizza.bonus.BonusPremium4X4;
import com.fideuram.modello.polizza.bonus.ProiezioneQuinquenni;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 09/04/13
 * Time: 18.46
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Bonus {
    @XmlElement(name = "BonusPremium4X4")
    private BonusPremium4X4 bonusPremium4X4;


    public BonusPremium4X4 getBonusPremium4X4() {
        return bonusPremium4X4;
    }


}
