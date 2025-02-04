package com.fideuram.stampe.modello.redditi.d2020.datiPrevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 18/01/16
 * Time: 18.38
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q22  extends AbstractQBase {
    private String c49;
    private String c50;
    private String c52;
    private String c53;
    private Double c54;
    private Double c55;
    private Double c56;
    private Double c57;
    private Double c58;
    private Double c59;

    public String getC49 ()  {return c49!=null?c49:"" ;}
    public String getC50 ()  {return c50!=null?c50:"" ;}
    public String getC52 ()  {return c52!=null?c52:"" ;}
    public String getC53 ()  {return c53!=null?c53:"" ;}
    public String getC54 ()  {return formattedDouble2String(c54);}
    public String getC55 ()  {return formattedDouble2String(c55);}
    public String getC56 ()  {return formattedDouble2String(c56);}
    public String getC57 ()  {return formattedDouble2String(c57);}
    public String getC58 ()  {return formattedDouble2String(c58);}
    public String getC59 ()  {return formattedDouble2String(c59);}

    public void setC49(String c49) {
        this.c49 = c49;
    }

    public void setC50(String c50) {
        this.c50 = c50;
    }

    public void setC52(String c52) {
        this.c52 = c52;
    }

    public void setC53(String c53) {
        this.c53 = c53;
    }

    public void setC54(Double c54) {
        this.c54 = c54;
    }

    public void setC55(Double c55) {
        this.c55 = c55;
    }

    public void setC56(Double c56) {
        this.c56 = c56;
    }

    public void setC57(Double c57) {
        this.c57 = c57;
    }

    public void setC58(Double c58) {
        this.c58 = c58;
    }

    public void setC59(Double c59) {
        this.c59 = c59;
    }
}
