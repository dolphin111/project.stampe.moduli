package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 11.49
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q6 extends AbstractQBase {
    private Double c11;
    private Double c12;
    private Double c16;
    private Double c17;
    private Double c19;
    private Double c20;
    private Double c21;
    private Double c23;
    private Double c24;

    public String getC11()  {return formattedDouble2String(c11);}
    public String getC12()  {return formattedDouble2String(c12);}
    public String getC16()  {return formattedDouble2String(c16);}
    public String getC17()  {return formattedDouble2String(c17);}
    public String getC19()  {return formattedDouble2String(c19);}
    public String getC20()  {return formattedDouble2String(c20);}
    public String getC21()  {return formattedDouble2String(c21);}
    public String getC23()  {return formattedDouble2String(c23);}
    public String getC24()  {return formattedDouble2String(c24);}

    public void setC11(Double c11) {
        this.c11 = c11;
    }

    public void setC12(Double c12) {
        this.c12 = c12;
    }

    public void setC16(Double c16) {
        this.c16 = c16;
    }

    public void setC17(Double c17) {
        this.c17 = c17;
    }

    public void setC19(Double c19) {
        this.c19 = c19;
    }

    public void setC20(Double c20) {
        this.c20 = c20;
    }

    public void setC21(Double c21) {
        this.c21 = c21;
    }

    public void setC23(Double c23) {
        this.c23 = c23;
    }

    public void setC24(Double c24) {
        this.c24 = c24;
    }
}
