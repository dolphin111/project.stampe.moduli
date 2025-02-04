package com.fideuram.modello.attori;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: logan
 * Date: 17/09/13
 * Time: 8.47
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AreaCliente {
    private String userId;
    private String passwd;

    public String getUserId() {
        if(null ==userId)
            return "";
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        if(null==passwd)
           return "";
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
