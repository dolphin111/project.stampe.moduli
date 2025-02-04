package com.fideuram.stampe.modello.redditi.anagrafica;

import com.fideuram.stampe.modello.attori.Recapito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 19/11/14
 * Time: 17.46
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DomicilioFiscale extends Recapito{
    private String codiceComune;
    private String fusioneComuni;

    public String getCodiceComune() {
        return codiceComune!=null?codiceComune:"";
    }

    public void setCodiceComune(String codiceComune) {
        this.codiceComune = codiceComune;
    }

	public String getFusioneComuni() {
		 return fusioneComuni!=null?fusioneComuni:"";
	}

	public void setFusioneComuni(String fusioneComuni) {
		this.fusioneComuni = fusioneComuni;
	}


    
}
