package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione;

import com.fideuram.stampe.modello.rendiconti.grafici.torta.Percentuali;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 31/10/14
 * Time: 9.29
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ComposizioneObbligazionaria extends Percentuali {
    public ComposizioneObbligazionaria() {
        super();
    }
}
