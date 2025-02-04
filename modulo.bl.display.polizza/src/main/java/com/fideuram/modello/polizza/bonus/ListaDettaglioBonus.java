package com.fideuram.modello.polizza.bonus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 11/04/13
 * Time: 19.40
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaDettaglioBonus {

    private ArrayList<DettaglioBonus> dettaglioBonus = new ArrayList<DettaglioBonus>();

    public ArrayList<DettaglioBonus> getDettaglioBonus() {
        return dettaglioBonus;
    }
}
