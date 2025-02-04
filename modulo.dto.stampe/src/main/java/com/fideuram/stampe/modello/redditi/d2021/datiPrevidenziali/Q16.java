package com.fideuram.stampe.modello.redditi.d2021.datiPrevidenziali;

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
   

    public String getC511() {return  formattedDouble2String(c511);}
    public String getC512() {return  formattedDouble2String(c512);}
    public String getC513() {return  formattedDouble2String(c513);}
    public String getC514() {return  formattedDouble2String(c514);}
  
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
}

