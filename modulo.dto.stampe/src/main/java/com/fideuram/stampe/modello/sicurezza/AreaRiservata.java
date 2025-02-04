package com.fideuram.stampe.modello.sicurezza;

import com.fideuram.stampe.modello.attori.Individuo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 11/09/14
 * Time: 11.30
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AreaRiservata {
    private Individuo individuo;
    private String userId;
    private String passwd;

    public String getUserId() {
        return userId!=null?userId:"";
    }

    public String getPasswd() {
        return passwd!=null?passwd:"";
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
}
