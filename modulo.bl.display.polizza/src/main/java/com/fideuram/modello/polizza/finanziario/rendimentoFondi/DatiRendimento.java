package com.fideuram.modello.polizza.finanziario.rendimentoFondi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with q
 * User: logan
 * Date: 10/07/13
 * Time: 11.33
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DatiRendimento")
public class DatiRendimento {
    List<Statistica> statistiche = new ArrayList<Statistica>();

    public List<Statistica> getStatistiche() {
        return statistiche;
    }
}
