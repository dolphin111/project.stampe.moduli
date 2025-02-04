package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 14.55
 */
@XmlTransient
@XmlRootElement(name="QUIETANZA")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quietanza{
    @XmlElement(name = "INTESTAZIONE")
    private Intestazione intestazione;
    @XmlElement(name = "PROTOCOLLO")
    private String protocollo;
    @XmlElement(name = "DATAPROTOCOLLO")
    private String dataProtocollo;
	@XmlElement(name = "OGGETTO")
    private Oggetto oggetto;
    @XmlElement(name = "BENEFICIARIO")
    private Beneficiario beneficiario;
    @XmlElement(name = "IMPORTI")
    private Importi importi;

    public String getDataProtocollo() {
		return dataProtocollo;
	}

	public void setDataProtocollo(String dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}

    public Intestazione getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(Intestazione intestazione) {
        this.intestazione = intestazione;
    }

    public String getProtocollo() {
        return protocollo.trim();
    }

    public void setProtocollo(String protocollo) {
        this.protocollo = protocollo;
    }

    public Oggetto getOggetto() {
        return oggetto;
    }

    public void setOggetto(Oggetto oggetto) {
        this.oggetto = oggetto;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Importi getImporti() {
        return importi;
    }

    public void setImporti(Importi importi) {
        this.importi = importi;
    }
}
