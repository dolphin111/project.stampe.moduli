package com.fideuram.modello.polizza.bonus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 19.38
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ProiezioneQuinquenni {
    private List<DettaglioProiezione> dettaglioProiezione=new ArrayList<DettaglioProiezione>();

    public List<DettaglioProiezione> getDettaglioProiezione() {
        return dettaglioProiezione;
    }
}
