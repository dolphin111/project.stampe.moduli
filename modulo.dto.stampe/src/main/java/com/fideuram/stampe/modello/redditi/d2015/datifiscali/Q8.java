package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 12.13
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q8 extends AbstractQBase {
    private Double c51;
    private Double c52;
    private Double c53;
    private Double c54;
    private Double c55;
    private Double c56;
    private Double c57;
    private Double c58;

    public String getC51 ()  {return formattedDouble2String(c51 );}
    public String getC52 ()  {return formattedDouble2String(c52 );}
    public String getC53 ()  {return formattedDouble2String(c53 );}
    public String getC54 ()  {return formattedDouble2String(c54 );}
    public String getC55 ()  {return formattedDouble2String(c55 );}
    public String getC56 ()  {return formattedDouble2String(c56 );}
    public String getC57 ()  {return formattedDouble2String(c57 );}
    public String getC58 ()  {return formattedDouble2String(c58 );}

    public void setC51(Double c51) {
        this.c51 = c51;
    }

    public void setC52(Double c52) {
        this.c52 = c52;
    }

    public void setC53(Double c53) {
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
}
