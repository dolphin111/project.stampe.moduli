package com.fideuram.modello.polizza.finanziario.rendimentoFondi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 17.03
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DettaglioComposizioneRendimentoFondo")
public class DettaglioComposizioneRendimentoFondo {
    List<DettaglioRendimentoFondoRamo3> dettaglioRendimentoFondoRamo3=new ArrayList<DettaglioRendimentoFondoRamo3>();

    public List<DettaglioRendimentoFondoRamo3> getDettaglioComposizioneInvestimentoRamo3() {
        return dettaglioRendimentoFondoRamo3;
    }
}
