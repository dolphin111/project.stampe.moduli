package com.fideuram.stampe.modello.redditi.d2022.datiFiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 12/01/16
 * Time: 9.36
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q8 extends AbstractQBase {
    private Double c161;
    private Double c162;
    private Double c163;
    private Double c164;
    private Double c165;
    private Double c166;
    private Double c167;

    public String getC161() {return  formattedDouble2String(c161);}
    public String getC162() {return  formattedDouble2String(c162);}
    public String getC163() {return  formattedDouble2String(c163);}
    public String getC164() {return  formattedDouble2String(c164);}
    public String getC165() {return  formattedDouble2String(c165);}
    public String getC166() {return  formattedDouble2String(c166);}
    public String getC167() {return  formattedDouble2String(c167);}

    public void setC161(Double c161) {
        this.c161 = c161;
    }

    public void setC162(Double c162) {
        this.c162 = c162;
    }

    public void setC163(Double c163) {
        this.c163 = c163;
    }

    public void setC164(Double c164) {
        this.c164 = c164;
    }

    public void setC165(Double c165) {
        this.c165 = c165;
    }

    public void setC166(Double c166) {
        this.c166 = c166;
    }

    public void setC167(Double c167) {
        this.c167 = c167;
    }
}
