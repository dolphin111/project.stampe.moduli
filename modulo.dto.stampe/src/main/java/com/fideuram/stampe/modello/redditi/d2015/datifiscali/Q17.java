package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 14.27
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q17 extends AbstractQBase {
    private Double c221;
    private Double c222;
    private Double c223;
    private Double c241;
    private Double c242;
    private Double c243;
    private Double c244;
    private Double c245;
    private Double c246;

    public String getC221()  {return formattedDouble2String(c221);}
    public String getC222()  {return formattedDouble2String(c222);}
    public String getC223()  {return formattedDouble2String(c223);}
    public String getC241()  {return formattedDouble2String(c241);}
    public String getC242()  {return formattedDouble2String(c242);}
    public String getC243()  {return formattedDouble2String(c243);}
    public String getC244()  {return formattedDouble2String(c244);}
    public String getC245()  {return formattedDouble2String(c245);}
    public String getC246()  {return formattedDouble2String(c246);}

    public void setC221(Double c221) {
        this.c221 = c221;
    }

    public void setC222(Double c222) {
        this.c222 = c222;
    }

    public void setC223(Double c223) {
        this.c223 = c223;
    }

    public void setC241(Double c241) {
        this.c241 = c241;
    }

    public void setC242(Double c242) {
        this.c242 = c242;
    }

    public void setC243(Double c243) {
        this.c243 = c243;
    }

    public void setC244(Double c244) {
        this.c244 = c244;
    }

    public void setC245(Double c245) {
        this.c245 = c245;
    }

    public void setC246(Double c246) {
        this.c246 = c246;
    }
}
