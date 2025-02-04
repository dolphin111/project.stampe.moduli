package com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 15.49
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q23 extends AbstractQBase {
    private char   c7;
    private char[] c8;  // 12 posizioni

    public Q23() {}   //IL COSTRUTTORE VUOTO SERVE A JAXB SENNò SI INCAZZAA

    public Q23(char c7){
        this.c7 = c7;
    }

    public Q23(char[] c8)  throws ValidationException {
        if (c8.length<12)
            throw new ValidationException("Q23 - Character[] c8 --- deve essere di docici elementi non uno di più non uno di meno");
        this.c8 = c8;
    }

    public char getC7() {
        return c7;
    }

    public char[] getC8() {
        return c8;
    }

    /**
     * restuisce tutto l'anno = true
     * @return
     */
    public boolean isT(){
        return c8!=null?false:true;
    }

}
