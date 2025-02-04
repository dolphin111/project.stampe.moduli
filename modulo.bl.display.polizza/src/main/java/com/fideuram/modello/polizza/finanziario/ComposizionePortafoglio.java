package com.fideuram.modello.polizza.finanziario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 05/07/13
 * Time: 17.42
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ComposizionePortafoglio {
    private List<Statistiche> statistiche=new ArrayList<Statistiche>();

    public List<Statistiche> getStatistiche() {
        return statistiche;
    }
}
