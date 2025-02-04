package com.fideuram.stampe.modello.redditi.d2016.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 15/01/16
 * Time: 18.09
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q16 extends AbstractQBase {
    private Double  c511;
    private Double  c512;
    private Double  c513;
    private Double  c514;
    private String  c515;
    private Double  c516;
    private Double  c517;
    private Double  c518;
    private Double  c519;
    private Double  c520;
    private String  c521;
    private String  c522;

    public String getC511() {return  formattedDouble2String(c511);}
    public String getC512() {return  formattedDouble2String(c512);}
    public String getC513() {return  formattedDouble2String(c513);}
    public String getC514() {return  formattedDouble2String(c514);}
    public String getC515() {return  c515!=null?c515:"";}
    public String getC516() {return  formattedDouble2String(c516);}
    public String getC517() {return  formattedDouble2String(c517);}
    public String getC518() {return  formattedDouble2String(c518);}
    public String getC519() {return  formattedDouble2String(c519);}
    public String getC520() {return  formattedDouble2String(c520);}
    public String getC521() {return  c521!=null?c521:"";}
    public String getC522() {return  c522!=null?c522:"";}

    public void setC511(Double c511) {
        this.c511 = c511;
    }

    public void setC512(Double c512) {
        this.c512 = c512;
    }

    public void setC513(Double c513) {
        this.c513 = c513;
    }

    public void setC514(Double c514) {
        this.c514 = c514;
    }

    public void setC515(String c515) {
        this.c515 = c515;
    }

    public void setC516(Double c516) {
        this.c516 = c516;
    }

    public void setC517(Double c517) {
        this.c517 = c517;
    }

    public void setC518(Double c518) {
        this.c518 = c518;
    }

    public void setC519(Double c519) {
        this.c519 = c519;
    }

    public void setC520(Double c520) {
        this.c520 = c520;
    }

    public void setC521(String c521) {
        this.c521 = c521;
    }

    public void setC522(String c522) {
        this.c522 = c522;
    }
}
