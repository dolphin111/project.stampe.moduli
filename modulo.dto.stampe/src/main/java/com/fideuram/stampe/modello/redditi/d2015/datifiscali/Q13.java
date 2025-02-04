package com.fideuram.stampe.modello.redditi.d2015.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 12.34
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q13 extends AbstractQBase {
    private Double c141;
    private Double c142;
    private Double c143;
    private Double c144;
    private Date c145;
    private Double c146;
    private Double c147;
    private Double c148;
    private Double c149;
    private Double c150;
    private Double c151;
    private Double c152;
    private Double c153;

    public String getC141 ()  {return formattedDouble2String(c141);}
    public String getC142 ()  {return formattedDouble2String(c142);}
    public String getC143 ()  {return formattedDouble2String(c143);}
    public String getC144 ()  {return formattedDouble2String(c144);}
    public String getC145 ()  {return formattedData2String(c145);}
    public String getC146 ()  {return formattedDouble2String(c146);}
    public String getC147 ()  {return formattedDouble2String(c147);}
    public String getC148 ()  {return formattedDouble2String(c148);}
    public String getC149 ()  {return formattedDouble2String(c149);}
    public String getC150 ()  {return formattedDouble2String(c150);}
    public String getC151 ()  {return formattedDouble2String(c151);}
    public String getC152 ()  {return formattedDouble2String(c152);}
    public String getC153 ()  {return formattedDouble2String(c153);}

    public void setC141(Double c141) {
        this.c141 = c141;
    }

    public void setC142(Double c142) {
        this.c142 = c142;
    }

    public void setC143(Double c143) {
        this.c143 = c143;
    }

    public void setC144(Double c144) {
        this.c144 = c144;
    }

    public void setC145(Date c145) {
        this.c145 = c145;
    }

    public void setC146(Double c146) {
        this.c146 = c146;
    }

    public void setC147(Double c147) {
        this.c147 = c147;
    }

    public void setC148(Double c148) {
        this.c148 = c148;
    }

    public void setC149(Double c149) {
        this.c149 = c149;
    }

    public void setC150(Double c150) {
        this.c150 = c150;
    }

    public void setC151(Double c151) {
        this.c151 = c151;
    }

    public void setC152(Double c152) {
        this.c152 = c152;
    }

    public void setC153(Double c153) {
        this.c153 = c153;
    }
}
