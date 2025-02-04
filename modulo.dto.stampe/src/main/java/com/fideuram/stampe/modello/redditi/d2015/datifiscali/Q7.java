package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 12.06
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q7 extends AbstractQBase {
    private Double c31;
    private Double c32;
    private Double c33;
    private Double c34;
    private Double c35;
    private Double c36;
    private Double c37;
    private Double c38;

    public String getC31 ()  {return formattedDouble2String(c31 );}
    public String getC32 ()  {return formattedDouble2String(c32 );}
    public String getC33 ()  {return formattedDouble2String(c33 );}
    public String getC34 ()  {return formattedDouble2String(c34 );}
    public String getC35 ()  {return formattedDouble2String(c35 );}
    public String getC36 ()  {return formattedDouble2String(c36 );}
    public String getC37 ()  {return formattedDouble2String(c37 );}
    public String getC38 ()  {return formattedDouble2String(c38 );}

    public void setC31(Double c31) {
        this.c31 = c31;
    }

    public void setC32(Double c32) {
        this.c32 = c32;
    }

    public void setC33(Double c33) {
        this.c33 = c33;
    }

    public void setC34(Double c34) {
        this.c34 = c34;
    }

    public void setC35(Double c35) {
        this.c35 = c35;
    }

    public void setC36(Double c36) {
        this.c36 = c36;
    }

    public void setC37(Double c37) {
        this.c37 = c37;
    }

    public void setC38(Double c38) {
        this.c38 = c38;
    }
}
