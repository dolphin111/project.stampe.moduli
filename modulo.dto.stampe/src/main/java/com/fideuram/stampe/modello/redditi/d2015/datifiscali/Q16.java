package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 14.11
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q16 extends AbstractQBase {
    private Double c201;
    private Double c202;
    private Double c203;
    private Double c204;
    private Double c205;

    public String getC201 ()  {return formattedDouble2String(c201);}
    public String getC202 ()  {return formattedDouble2String(c202);}
    public String getC203 ()  {return formattedDouble2String(c203);}
    public String getC204 ()  {return formattedDouble2String(c204);}
    public String getC205 ()  {return formattedDouble2String(c205);}

    public void setC201(Double c201) {
        this.c201 = c201;
    }

    public void setC202(Double c202) {
        this.c202 = c202;
    }

    public void setC203(Double c203) {
        this.c203 = c203;
    }

    public void setC204(Double c204) {
        this.c204 = c204;
    }

    public void setC205(Double c205) {
        this.c205 = c205;
    }
}
