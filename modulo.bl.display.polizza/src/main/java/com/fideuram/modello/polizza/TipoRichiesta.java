package com.fideuram.modello.polizza;

import javax.xml.bind.annotation.XmlType;

/**

 */
@XmlType(name="TipoRichiesta")
public class TipoRichiesta {
    private boolean mail;


    public boolean isMail() {
        return mail;
    }

    public boolean isNotMail() {
        if (!mail)
           return true;
        else
           return false;
    }

    public void setMail(boolean mail) {
        this.mail = mail;
    }

}
