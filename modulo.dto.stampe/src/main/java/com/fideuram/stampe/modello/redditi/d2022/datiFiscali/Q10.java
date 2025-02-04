package com.fideuram.stampe.modello.redditi.d2022.datiFiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 12/01/16
 * Time: 11.43
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q10 extends AbstractQBase {
    private String  c341;
    private Double  c342;
    private String  c343;
    private Double  c344;
    private String  c345;
    private Double  c346;
    private String  c347;
    private Double  c348;
    private String  c349;
    private Double  c350;
    private String  c351;
    private Double  c352;

    public String getC341()  {return c341!=null?c341+"":"";}
    public String getC342()  {return formattedDouble2String(c342);}
    public String getC343()  {return c343!=null?c343+"":"";}
    public String getC344()  {return formattedDouble2String(c344);}
    public String getC345()  {return c345!=null?c345+"":"";}
    public String getC346()  {return formattedDouble2String(c346);}
    public String getC347()  {return c347!=null?c347+"":"";}
    public String getC348()  {return formattedDouble2String(c348);}
    public String getC349()  {return c349!=null?c349+"":"";}
    public String getC350()  {return formattedDouble2String(c350);}
    public String getC351()  {return c351!=null?c351+"":"";}
    public String getC352()  {return formattedDouble2String(c352);}

    public void setC341(String c341) {
        this.c341 = c341;
    }

    public void setC342(Double c342) {
        this.c342 = c342;
    }

    public void setC343(String c343) {
        this.c343 = c343;
    }

    public void setC344(Double c344) {
        this.c344 = c344;
    }

    public void setC345(String c345) {
        this.c345 = c345;
    }

    public void setC346(Double c346) {
        this.c346 = c346;
    }

    public void setC347(String c347) {
        this.c347 = c347;
    }

    public void setC348(Double c348) {
        this.c348 = c348;
    }

    public void setC349(String c349) {
        this.c349 = c349;
    }

    public void setC350(Double c350) {
        this.c350 = c350;
    }

    public void setC351(String c351) {
        this.c351 = c351;
    }

    public void setC352(Double c352) {
        this.c352 = c352;
    }
}
