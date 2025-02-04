package com.fideuram.modello.polizza.altridati;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 16/04/13
 * Time: 16.12
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class CaricamentiCPP {

    private ArrayList<CaricamemtoCPPR3> caricamentoCPPR3  = new ArrayList<CaricamemtoCPPR3>();

    public ArrayList<CaricamemtoCPPR3> getCaricamentoCPPR3() {
        return caricamentoCPPR3;
    }
}
