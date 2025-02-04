package com.fideuram.stampe.modello.redditi.d2017.datifiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801098
 * Date: 07/01/16
 * Time: 11.52
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q5 extends AbstractQBase {
    private Double  c1;
    private Integer c2;
    private Double  c3;
    private Double  c4;
    private Double  c5;
    private Integer c6;
    private Double  c7;
    private Date    c8;
    private Date    c9;
    private Double  c10;
    private Double  c11;

    public String getC1 ()  {return formattedDouble2String(c1 );}
    public String getC2 ()  {return c2!=null?c2+"":"";}
    public String getC3 ()  {return formattedDouble2String(c3 );}
    public String getC4 ()  {return formattedDouble2String(c4 );}
    public String getC5 ()  {return formattedDouble2String(c5 );}
    public String getC6 ()  {return c6!=null?c6+"":"";}
    public String getC7 ()  {return formattedDouble2String(c7 );}
    public String getC8 ()  {return formattedData2String(c8);}
    public String getC9 ()  {return formattedData2String(c9);}
    
    public String getC10()  
    {
    	String sc10="";
    	if(c10 != null && c10 == 1)
    		sc10="X";
    	
    	return sc10 ;
    }
    
    public String getC11()  {return formattedDouble2String(c11);}

    public void setC1(Double c1) {
        this.c1 = c1;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public void setC3(Double c3) {
        this.c3 = c3;
    }

    public void setC4(Double c4) {
        this.c4 = c4;
    }

    public void setC5(Double c5) {
        this.c5 = c5;
    }

    public void setC6(Integer c6) {
        this.c6 = c6;
    }

    public void setC7(Double c7) {
        this.c7 = c7;
    }

    public void setC8(Date c8) {
        this.c8 = c8;
    }

    public void setC9(Date c9) {
        this.c9 = c9;
    }

    public void setC10(Double c10) {
        this.c10 = c10;
    }

    public void setC11(Double c11) {
        this.c11 = c11;
    }
}
