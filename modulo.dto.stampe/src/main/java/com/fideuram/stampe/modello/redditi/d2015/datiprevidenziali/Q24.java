package com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 15.57
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q24 extends AbstractQBase {
    private Double c9;
    private Double c10;
    private Double c11;
    private Double c12;

    private char   c13;
    private char[] c14;  // 12 posizioni

    public Q24() { }

    /**
     * Costruttore da usare nel caso la denuncia riguardi tutti i mesi dell'anno
     * @param c13
     */
    public Q24(char c13) {
        this.c13 = c13;
    }

    /**
     * Costruttore da usare nel caso si debbano specificare i mesi dell'anno escludi daslla denuncia
     * @param c14
     */
    public Q24(char[] c14) throws ValidationException {
        if (c14.length<12)
            throw new ValidationException("Q24 - Character[] c14 --- deve essere di docici elementi non uno di più non uno di meno");
        this.c14 = c14;
    }


    public String getC9 ()   {return formattedDouble2String(c9 );}
    public String getC10 ()  {return formattedDouble2String(c10 );}
    public String getC11 ()  {return formattedDouble2String(c11 );}
    public String getC12 ()  {return formattedDouble2String(c12 );}

    public char getC13() {return c13;}
    public char[] getC14() {return c14;}

    /**
     * restuisce tutto l'anno = true
     * @return
     */
    public boolean isT(){
        return c14!=null?false:true;
    }

    public void setC9(Double c9) {
        this.c9 = c9;
    }

    public void setC10(Double c10) {
        this.c10 = c10;
    }

    public void setC11(Double c11) {
        this.c11 = c11;
    }

    public void setC12(Double c12) {
        this.c12 = c12;
    }
}
