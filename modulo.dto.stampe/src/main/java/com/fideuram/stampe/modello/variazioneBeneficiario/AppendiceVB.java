package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name="AppendiceVB", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppendiceVB extends VariazioneBeneficiario{
    private Date           		dataEmissioneAppendice;
    private BeneficiarioVB   	beneficiari;
    private Date         		dataEffettoVB;
    private String 				tipoOperazione;

    public String getDataEmissioneAppendice() {
        return FormattatoreDate.formatDate(dataEmissioneAppendice!=null?dataEmissioneAppendice:new Date(),FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public String getDataEffettoVB() {
        return FormattatoreDate.formatDate(dataEffettoVB,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setDataEmissioneAppendice(Date dataEmissioneAppendice) {
        this.dataEmissioneAppendice = dataEmissioneAppendice;
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public void setDataEffettoVB(Date dataEffettoVB) {
        this.dataEffettoVB = dataEffettoVB;
    }

    public BeneficiarioVB getBeneficiari() {
        return beneficiari;
    }

    public void setBeneficiari(BeneficiarioVB beneficiari) {
        this.beneficiari = beneficiari;
    }

	public String getTipoOperazione() {
		return tipoOperazione;
	}

	public void setTipoOperazione(String tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}
    
}
