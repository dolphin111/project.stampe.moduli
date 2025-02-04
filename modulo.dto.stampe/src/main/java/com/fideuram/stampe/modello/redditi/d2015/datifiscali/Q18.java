package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 14.45
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q18  extends AbstractQBase {
    private Double c261;
    private Double c262;
    private Double c263;
    private Double c264;

    public String getC261()  {return formattedDouble2String(c261);}
    public String getC262()  {return formattedDouble2String(c262);}
    public String getC263()  {return formattedDouble2String(c263);}
    public String getC264()  {return formattedDouble2String(c264);}

    public void setC261(Double c261) {
        this.c261 = c261;
    }

    public void setC262(Double c262) {
        this.c262 = c262;
    }

    public void setC263(Double c263) {
        this.c263 = c263;
    }

    public void setC264(Double c264) {
        this.c264 = c264;
    }
}
