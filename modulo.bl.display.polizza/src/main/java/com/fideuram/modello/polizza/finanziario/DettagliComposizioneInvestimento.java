package com.fideuram.modello.polizza.finanziario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 05/07/13
 * Time: 17.21
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DettagliComposizioneInvestimento")
public class DettagliComposizioneInvestimento {
    List<DettaglioComposizioneInvestimentoRamo3> dettaglioComposizioneInvestimentoRamo3=new ArrayList<DettaglioComposizioneInvestimentoRamo3>();

    public List<DettaglioComposizioneInvestimentoRamo3> getDettaglioComposizioneInvestimentoRamo3() {
        return dettaglioComposizioneInvestimentoRamo3;
    }

    public boolean isOverPage(){
        if (null!=dettaglioComposizioneInvestimentoRamo3&&dettaglioComposizioneInvestimentoRamo3.size()>15)
            return true;
        return false;
    }
}
