package com.fideuram.modello.polizza.finanziario.rendimentoFondi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 11.07
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="StatisticheRendimentoFondi")
public class StatisticheRendimentoFondi {
    List<Fondo> statistiche;

    public List<Fondo> getStatistiche() {
        return statistiche;
    }


}
