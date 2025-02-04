package com.fideuram.stampe.modello.rendiconti.grafici.linea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: v801068
 * Date: 03/11/14
 * Time: 10.25
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementoLinea {
    private String linea;  // indica la linea sui cui disegnare questo elemento
    private Date   data;
    private Double value;

    public ElementoLinea() {}

    public ElementoLinea(String linea, Date data, Double value) {
        this.linea = linea;
        this.data = data;
        this.value = value;
    }

    public String getLinea() {
        return linea;
    }

    public Date getData() {
        return data;
    }


    public Double getValue() {
        return value;
    }


}
