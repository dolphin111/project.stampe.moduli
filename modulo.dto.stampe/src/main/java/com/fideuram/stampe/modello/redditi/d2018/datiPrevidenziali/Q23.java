package com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 18/01/16
 * Time: 18.38
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q23  extends AbstractQBase {
    private String c71;
    private String c72;
    private Date   c73;
    private Date   c74;
    private String c75;
    private String c76;

    public String getC71 ()  {return c71!=null?c71:"";}
    public String getC72 ()  {return c72!=null?c72:"";}
    public String getC73 ()  {return splitGGMMFromDate(c73);}
    public String getC74 ()  {return splitGGMMFromDate(c74);}
    public String getC75 ()  {return c75!=null?c75:"";}
    public String getC76 ()  {return c76!=null?c76:"";}

    public void setC71(String c71) {
        this.c71 = c71;
    }

    public void setC72(String c72) {
        this.c72 = c72;
    }

    public void setC73(Date c73) {
        this.c73 = c73;
    }

    public void setC74(Date c74) {
        this.c74 = c74;
    }

    public void setC75(String c75) {
        this.c75 = c75;
    }

    public void setC76(String c76) {
        this.c76 = c76;
    }
}
