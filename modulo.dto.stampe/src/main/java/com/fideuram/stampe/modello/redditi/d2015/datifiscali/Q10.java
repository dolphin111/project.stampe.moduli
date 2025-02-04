package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 12.17
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q10 extends AbstractQBase {
    private Double c65;
    private Double c66;
    private Double c67;
    private Double c68;

    public String getC65 ()  {return formattedDouble2String(c65 );}
    public String getC66 ()  {return formattedDouble2String(c66 );}
    public String getC67 ()  {return formattedDouble2String(c67 );}
    public String getC68 ()  {return formattedDouble2String(c68 );}

    public void setC65(Double c65) {
        this.c65 = c65;
    }

    public void setC66(Double c66) {
        this.c66 = c66;
    }

    public void setC67(Double c67) {
        this.c67 = c67;
    }

    public void setC68(Double c68) {
        this.c68 = c68;
    }
}
