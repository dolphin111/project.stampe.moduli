package com.fideuram.stampe.modello.comunicazionecrm;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 22/07/14
 * Time: 12.07
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comunicazione {
    private String cittaEmissione;
    private String protocollo;
    private Date data;

    public String getCittaEmissione() {
        return cittaEmissione;
    }

    public void setCittaEmissione(String cittaEmissione) {
        this.cittaEmissione = cittaEmissione;
    }

    public String getProtocollo() {
        return protocollo;
    }

    public void setProtocollo(String protocollo) {
        this.protocollo = protocollo;
    }

    public String getData() {
        return FormattatoreDate.formatDate(data,FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);
    }

    public void setData(Date dataRichiesta) {
        this.data = dataRichiesta;
    }
}
