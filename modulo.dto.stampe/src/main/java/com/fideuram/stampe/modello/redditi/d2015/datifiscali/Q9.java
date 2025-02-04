package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 12.15
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q9 extends AbstractQBase{
    private Double c61;
    private Double c62;
    private Double c63;
    private Double c64;

    public String getC61 ()  {return formattedDouble2String(c61 );}
    public String getC62 ()  {return formattedDouble2String(c62 );}
    public String getC63 ()  {return formattedDouble2String(c63 );}
    public String getC64 ()  {return formattedDouble2String(c64 );}

    public void setC61(Double c61) {
        this.c61 = c61;
    }

    public void setC62(Double c62) {
        this.c62 = c62;
    }

    public void setC63(Double c63) {
        this.c63 = c63;
    }

    public void setC64(Double c64) {
        this.c64 = c64;
    }
}
