package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 17.43
 */
public class Intestazione {

    private String egregio;
    private String generalita;
    private String via;
    private String citta;

    public String getEgregio() {
        return egregio.trim();
    }

    @XmlElement(name = "EGREGIO")
    public void setEgregio(String egregio) {
        this.egregio = egregio;
    }


    public String getCitta() {
        return citta.trim();
    }

    @XmlElement(name = "CITTA")
    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via.trim();
    }

    @XmlElement(name = "VIA")
    public void setVia(String via) {
        this.via = via;
    }

    public String getGeneralita() {
        return generalita.trim();
    }

    @XmlElement(name = "GENERALITA")
    public void setGeneralita(String generalita) {
        this.generalita = generalita;
    }
}
