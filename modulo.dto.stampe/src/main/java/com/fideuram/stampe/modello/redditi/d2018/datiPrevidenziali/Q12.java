package com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801098
 * Date: 14/01/16
 * Time: 12.22
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q12 extends AbstractQBase {
    private Double  c411;
    private Double  c412;
    private Double  c413;
    private Double  c414;
    private Date    c415;
    private Double  c416;
    private Double  c417;
    private Double  c418;
    private Double  c419;
    private Integer c420;
    private Double  c421;
    private Double  c422;
    private Double  c423;
    private String  c424;
    private String  c425;
    private String  c426;
    private String  c427;

    public String getC411() {return  formattedDouble2String(c411);}
    public String getC412() {return  formattedDouble2String(c412);}
    public String getC413() {return  formattedDouble2String(c413);}
    public String getC414() {return  formattedDouble2String(c414);}
    public String getC415() {return  formattedData2String(c415);}
    public String getC416() {return  formattedDouble2String(c416);}
    public String getC417() {return  formattedDouble2String(c417);}
    public String getC418() {return  formattedDouble2String(c418);}
    public String getC419() {return  formattedDouble2String(c419);}
    public String getC420() {return  formattedInteger2String(c420);}
    public String getC421() {return  formattedDouble2String(c421);}
    public String getC422() {return  formattedDouble2String(c422);}
    public String getC423() {return  formattedDouble2String(c423);}
    public String getC424() {return  c424!=null?c424:"";}
    public String getC425() {return  c425!=null?c425:"";}
    public String getC426() {return  c426!=null?c426:"";}
    public String getC427() {return  c427!=null?c427:"";}

    public void setC411(Double c411) {
        this.c411 = c411;
    }

    public void setC412(Double c412) {
        this.c412 = c412;
    }

    public void setC413(Double c413) {
        this.c413 = c413;
    }

    public void setC414(Double c414) {
        this.c414 = c414;
    }

    public void setC415(Date c415) {
        this.c415 = c415;
    }

    public void setC416(Double c416) {
        this.c416 = c416;
    }

    public void setC417(Double c417) {
        this.c417 = c417;
    }

    public void setC418(Double c418) {
        this.c418 = c418;
    }

    public void setC419(Double c419) {
        this.c419 = c419;
    }

    public void setC420(Integer c420) {
        this.c420 = c420;
    }

    public void setC421(Double c421) {
        this.c421 = c421;
    }

    public void setC422(Double c422) {
        this.c422 = c422;
    }

    public void setC423(Double c423) {
        this.c423 = c423;
    }

    public void setC424(String c424) {
        this.c424 = c424;
    }

    public void setC425(String c425) {
        this.c425 = c425;
    }

    public void setC426(String c426) {
        this.c426 = c426;
    }

    public void setC427(String c427) {
        this.c427 = c427;
    }
}
