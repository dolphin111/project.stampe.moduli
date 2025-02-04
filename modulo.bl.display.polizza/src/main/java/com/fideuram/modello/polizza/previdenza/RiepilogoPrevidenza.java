package com.fideuram.modello.polizza.previdenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 12/04/13
 * Time: 15.24
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class RiepilogoPrevidenza {
    private ArrayList<Riepilogo> riepilogo = new ArrayList<Riepilogo>();

    public ArrayList<Riepilogo> getRiepilogo() {
        return riepilogo;
    }
}
