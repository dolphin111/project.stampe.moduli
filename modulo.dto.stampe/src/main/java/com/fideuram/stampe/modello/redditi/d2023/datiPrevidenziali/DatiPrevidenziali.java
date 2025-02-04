package com.fideuram.stampe.modello.redditi.d2023.datiPrevidenziali;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 14/01/16
 * Time: 12.22
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiPrevidenziali {
	
    private List<String> annotazioni;
    
    private Q12 q12;
    private Q13 q13;
    private Q14 q14;
    private Q15 q15;
    private Q16 q16;
    private Q17 q17;
    private Q18 q18;
    private Q19 q19;
    private Q20 q20;
    private Q21 q21;
    private Q22 q22;
    private Q23 q23;

    public Q12 getQ12() {return q12!=null?q12:new Q12();}
    public Q13 getQ13() {return q13!=null?q13:new Q13();}
    public Q14 getQ14() {return q14!=null?q14:new Q14();}
    public Q15 getQ15() {return q15!=null?q15:new Q15();}
    public Q16 getQ16() {return q16!=null?q16:new Q16();}
    public Q17 getQ17() {return q17!=null?q17:new Q17();}
    public Q18 getQ18() {return q18!=null?q18:new Q18();}
    public Q19 getQ19() {return q19!=null?q19:new Q19();}
    public Q20 getQ20() {return q20!=null?q20:new Q20();}
    public Q21 getQ21() {return q21!=null?q21:new Q21();}
    public Q22 getQ22() {return q22!=null?q22:new Q22();}
    public Q23 getQ23() {return q23!=null?q23:new Q23();}
    
    public List<String>  getAnnotazioni() {
        return annotazioni!=null?annotazioni:new ArrayList<String>();
    }

    public void addAnnotazioni(String annotazioni) {
        if(null==this.annotazioni)
            this.annotazioni=new ArrayList<String>();
        this.annotazioni.add(annotazioni);
    }
    public void setQ12(Q12 q12) {
        this.q12 = q12;
    }


    public void setQ13(Q13 q13) {
        this.q13 = q13;
    }



    public void setQ14(Q14 q14) {
        this.q14 = q14;
    }


    public void setQ15(Q15 q15) {
        this.q15 = q15;
    }



    public void setQ16(Q16 q16) {
        this.q16 = q16;
    }



    public void setQ17(Q17 q17) {
        this.q17 = q17;
    }



    public void setQ18(Q18 q18) {
        this.q18 = q18;
    }



    public void setQ19(Q19 q19) {
        this.q19 = q19;
    }

    public void setQ20(Q20 q20) {
        this.q20 = q20;
    }


    public void setQ21(Q21 q21) {
        this.q21 = q21;
    }


    public void setQ22(Q22 q22) {
        this.q22 = q22;
    }



    public void setQ23(Q23 q23) {
        this.q23 = q23;
    }
}
