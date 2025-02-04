package com.fideuram.modello.polizza.prestazioni;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: logan
 * Date: 14/10/13
 * Time: 11.33
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Capitale {
    private CapitaleLordo capitaleLordo;

    public CapitaleLordo getCapitaleLordo() {
        return capitaleLordo;
    }
}
