package com.fideuram.stampe.modello.redditi.d2016.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 15/01/16
 * Time: 17.10
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q18 extends AbstractQBase {
    private String  c571;
    private String  c572;

    public String getC571() {return  c571!=null?c571:"";}
    public String getC572() {return  c572!=null?c572:"";}

    public void setC571(String c571) {
        this.c571 = c571;
    }

    public void setC572(String c572) {
        this.c572 = c572;
    }
}
