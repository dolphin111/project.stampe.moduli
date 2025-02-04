package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 12.39
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q15 extends AbstractQBase {
    private Double c171;
    private Double c172;
    private Double c173;
    private Double c174;
    private Double c175;
    private Double c184;
    private Double c186;
    private Double c191;
    private Double c192;

    public String getC171 ()  {return formattedDouble2String(c171);}
    public String getC172 ()  {return formattedDouble2String(c172);}
    public String getC173 ()  {return formattedDouble2String(c173);}
    public String getC174 ()  {return formattedDouble2String(c174);}
    public String getC175 ()  {return formattedDouble2String(c175);}
    public String getC184 ()  {return formattedDouble2String(c184);}
    public String getC186 ()  {return formattedDouble2String(c186);}
    public String getC191 ()  {return formattedDouble2String(c191);}
    public String getC192 ()  {return formattedDouble2String(c192);}

    public void setC171(Double c171) {
        this.c171 = c171;
    }

    public void setC172(Double c172) {
        this.c172 = c172;
    }

    public void setC173(Double c173) {
        this.c173 = c173;
    }

    public void setC174(Double c174) {
        this.c174 = c174;
    }

    public void setC175(Double c175) {
        this.c175 = c175;
    }

    public void setC184(Double c184) {
        this.c184 = c184;
    }

    public void setC186(Double c186) {
        this.c186 = c186;
    }

    public void setC191(Double c191) {
        this.c191 = c191;
    }

    public void setC192(Double c192) {
        this.c192 = c192;
    }
}
