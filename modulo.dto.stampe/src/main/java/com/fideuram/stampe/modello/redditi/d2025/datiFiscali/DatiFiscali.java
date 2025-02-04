package com.fideuram.stampe.modello.redditi.d2025.datiFiscali;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801098
 * Date: 07/01/16
 * Time: 11.51
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiFiscali {
    private Q5 q5;
    private Q6 q6;
    private Q7 q7;
    private Q8 q8;
    private Q9 q9;
    private Q10 q10;
    private Q11 q11;

    public Q5 getQ5() {return q5!=null?q5:new Q5();}
    public Q6 getQ6() {return q6!=null?q6:new Q6();}
    public Q7 getQ7() {return q7!=null?q7:new Q7();}
    public Q8 getQ8() {return q8!=null?q8:new Q8();}
    public Q9 getQ9() {return q9!=null?q9:new Q9();}
    public Q10 getQ10() {return q10!=null?q10:new Q10();}
    public Q11 getQ11() {return q11!=null?q11:new Q11();}

    public void setQ5(Q5 q5) {
        this.q5 = q5;
    }
    public void setQ6(Q6 q6) {
        this.q6 = q6;
    }
    public void setQ7(Q7 q7) {
        this.q7 = q7;
    }

    public void setQ8(Q8 q8) {
        this.q8 = q8;
    }

    public void setQ9(Q9 q9) {
        this.q9 = q9;
    }

    public void setQ10(Q10 q10) {
        this.q10 = q10;
    }

    public void setQ11(Q11 q11) {
        this.q11 = q11;
    }
}
