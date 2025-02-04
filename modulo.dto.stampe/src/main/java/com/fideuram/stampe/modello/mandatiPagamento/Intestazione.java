package com.fideuram.stampe.modello.mandatiPagamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="INTESTAZIONE", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Intestazione {

    @XmlElement(name = "EGREGIO")
    private String egregio;
    @XmlElement(name = "GENERALITA")
    private String generalita;
    @XmlElement(name = "VIA")
    private String via;
    @XmlElement(name = "CITTA")
    private String citta;


    public String getEgregio() {
        return egregio;
    }
    public void setEgregio(String egregio) {
        this.egregio = egregio;
    }
    public String getGeneralita() {
        return generalita;
    }
    public void setGeneralita(String generalita) {
        this.generalita = generalita;
    }
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }

}
