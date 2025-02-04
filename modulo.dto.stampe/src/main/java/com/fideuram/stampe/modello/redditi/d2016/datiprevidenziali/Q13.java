package com.fideuram.stampe.modello.redditi.d2016.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 14/01/16
 * Time: 18.32
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q13  extends AbstractQBase {
    private Double  c431;
    private String  c432;
    private Double  c433;
    private String  c434;
    private Double  c435;
    private String  c436;
    private Double  c437;
    private Double  c438;
    private Double  c439;
    private Double  c440;
    private Double  c441;
    private Double  c442;
    private String  c443;
    private String  c444;

    public String getC431() {return  formattedDouble2String(c431);}
    public String getC432() {return  c432!=null?c432:"";}
    public String getC433() {return  formattedDouble2String(c433);}
    public String getC434() {return  c434!=null?c434:"";}
    public String getC435() {return  formattedDouble2String(c435);}
    public String getC436() {return  c436!=null?c436:"";}
    public String getC437() {return  formattedDouble2String(c437);}
    public String getC438() {return  formattedDouble2String(c438);}
    public String getC439() {return  formattedDouble2String(c439);}
    public String getC440() {return  formattedDouble2String(c440);}
    public String getC441() {return  formattedDouble2String(c441);}
    public String getC442() {return  formattedDouble2String(c442);}
    public String getC443() {return  c443!=null?c443:"";}
    public String getC444() {return  c444!=null?c444:"";}

    public void setC431(Double c431) {
        this.c431 = c431;
    }

    public void setC432(String c432) {
        this.c432 = c432;
    }

    public void setC433(Double c433) {
        this.c433 = c433;
    }

    public void setC434(String c434) {
        this.c434 = c434;
    }

    public void setC435(Double c435) {
        this.c435 = c435;
    }

    public void setC436(String c436) {
        this.c436 = c436;
    }

    public void setC437(Double c437) {
        this.c437 = c437;
    }

    public void setC438(Double c438) {
        this.c438 = c438;
    }

    public void setC439(Double c439) {
        this.c439 = c439;
    }

    public void setC440(Double c440) {
        this.c440 = c440;
    }

    public void setC441(Double c441) {
        this.c441 = c441;
    }

    public void setC442(Double c442) {
        this.c442 = c442;
    }

    public void setC443(String c443) {
        this.c443 = c443;
    }

    public void setC444(String c444) {
        this.c444 = c444;
    }
}
