package com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 15.08
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiPrevidenziali {
    private Q22 q22;
    private Q23 q23;
    private Q24 q24;
    private Q25 q25;
    private Q26 q26;
    private List<String> annotazioni;

    public Q22 getQ22() {
        return q22!=null?q22:new Q22();
    }

    public Q23 getQ23() {
        return q23!=null?q23:new Q23();
    }

    public Q24 getQ24() {
        return q24!=null?q24:new Q24();
    }

    public Q25 getQ25() {
        return q25!=null?q25:new Q25();
    }

    public Q26 getQ26() {
        return q26!=null?q26:new Q26();
    }

    public List<String> getAnnotazioni() {
        return annotazioni!=null?annotazioni:new ArrayList<String>();
    }

    public void setQ22(Q22 q22) {
        this.q22 = q22;
    }

    public void setQ23(Q23 q23) {
        this.q23 = q23;
    }

    public void setQ24(Q24 q24) {
        this.q24 = q24;
    }

    public void setQ25(Q25 q25) {
        this.q25 = q25;
    }

    public void setQ26(Q26 q26) {
        this.q26 = q26;
    }

    public void addAnnotazioni(String annotazioni) {
        if(null==this.annotazioni)
            this.annotazioni=new ArrayList<String>();
        this.annotazioni.add(annotazioni);
    }
}
