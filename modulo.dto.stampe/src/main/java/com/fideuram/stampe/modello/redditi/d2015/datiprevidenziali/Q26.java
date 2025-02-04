package com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 16.19
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q26  extends AbstractQBase {
    private String c35;
    //private String c36="12345678901";    //todo eliminare
    private String c36;
    private Date   c37;
    private Date   c38;
    private String c39;
    private String c40;

    public String getC35 ()  {return c35!=null?c35:"";}
    public String getC36 ()  {return c36!=null?c36:"";}
    public String getC37 ()  {return splitGGMMFromDate(c37);}
    public String getC38 ()  {return splitGGMMFromDate(c38);}
    public String getC39 ()  {return c39!=null?c39:"";}
    public String getC40 ()  {return c40!=null?c40:"";}

    public void setC35(String c35) {
        this.c35 = c35;
    }

    public void setC36(String c36) {
        this.c36 = c36;
    }

    public void setC37(Date c37) {
        this.c37 = c37;
    }

    public void setC38(Date c38) {
        this.c38 = c38;
    }

    public void setC39(String c39) {
        this.c39 = c39;
    }

    public void setC40(String c40) {
        this.c40 = c40;
    }

    /*private String splitGGMMFromDate(Date c){
        String data=formattedData2String(c);
        return !data.equals("")?data.substring(0,8):"";
    }*/

}
