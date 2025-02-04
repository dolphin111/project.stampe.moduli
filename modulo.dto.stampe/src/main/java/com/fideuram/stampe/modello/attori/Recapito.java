package com.fideuram.stampe.modello.attori;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by.
 * User: logan
 * Date: 30/09/11
 * Time: 10.25
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Recapito {
    private String via="";
    private String cap="";
    private String comune="";
    private String provincia="";
    private String tel_fax="";
    private String eMail="";

    public Recapito() { }

    public Recapito(String via, String cap, String comune, String provincia) {
        this.via = via;
        this.cap = cap;
        this.comune = comune;
        this.provincia = provincia;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        if(null==comune)
            return;
        this.comune = comune;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        if(null==cap)
            return;
        this.cap = cap;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        if(null==via)
            return;
        this.via = via;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        if(null==provincia)
            return;
        this.provincia = provincia;
    }

    public String getTel_fax() {
        return tel_fax;
    }

    public void setTel_fax(String tel_fax) {
        this.tel_fax = tel_fax;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCapLocalProv(){
        return cap+" "+comune+" "+provincia;
    }
}
