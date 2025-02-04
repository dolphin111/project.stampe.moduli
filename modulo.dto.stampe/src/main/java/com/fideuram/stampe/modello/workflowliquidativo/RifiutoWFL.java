package com.fideuram.stampe.modello.workflowliquidativo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

@XmlRootElement(name="RifiutoWFL", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RifiutoWFL {
	
	
	private Date           dataRichiesta;
    protected Contratto    polizza;
    
    //a
    private Date           iscrizioneFPA;
    private Date           dataTrasferimento;
    private String         descrizioneFondo;
    private String         codiceCOVIP;
    
    //b
    private Date           dataIscrizioneFormaPensionisticaComplementare;
    private Date           dataAnticipazioneFondoPensioneFideuram;
    
    //c
    private Double         importoAccantonato;
    private Date           dataNav;
    
    //d
   // private Date           dataIscrizioneFormaPensionisticaComplementare;
    private Date           dataRichiestaErogazionePrestazionePensionistica;
    
  
    
    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }
    


	public String getDataRichiestaErogazionePrestazionePensionistica() {
		return FormattatoreDate.formatDate(dataRichiestaErogazionePrestazionePensionistica , FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setDataRichiestaErogazionePrestazionePensionistica(
			Date dataRichiestaErogazionePrestazionePensionistica) {
		this.dataRichiestaErogazionePrestazionePensionistica = dataRichiestaErogazionePrestazionePensionistica;
	}

	public String getDataStampa(){
        return FormattatoreDate.formatDate(new Date(), FormattatoreDate.FORMATO_DATA_ITALIANA);
    }
    
	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public Contratto getPolizza() {
		return polizza;
	}
	public void setPolizza(Contratto polizza) {
		this.polizza = polizza;
	}

	public String getIscrizioneFPA() {
		 return FormattatoreDate.formatDate(iscrizioneFPA, FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setIscrizioneFPA(Date iscrizioneFPA) {
		this.iscrizioneFPA = iscrizioneFPA;
	}

	public String getDataTrasferimento() {
		 return FormattatoreDate.formatDate(dataTrasferimento, FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setDataTrasferimento(Date dataTrasferimento) {
		this.dataTrasferimento = dataTrasferimento;
	}

	public String getDescrizioneFondo() {
		return descrizioneFondo;
	}

	public void setDescrizioneFondo(String descrizioneFondo) {
		this.descrizioneFondo = descrizioneFondo;
	}

	public String getCodiceCOVIP() {
		return codiceCOVIP;
	}

	public void setCodiceCOVIP(String codiceCOVIP) {
		this.codiceCOVIP = codiceCOVIP;
	}

	public String getDataIscrizioneFormaPensionisticaComplementare() {
		return FormattatoreDate.formatDate(dataIscrizioneFormaPensionisticaComplementare, FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public String getImportoAccantonato() {
		return importoAccantonato!=null?FormattatoreCifre.formatImporto(importoAccantonato, ".", ","):"";
	}

	public void setImportoAccantonato(Double importoAccantonato) {
		this.importoAccantonato = importoAccantonato;
	}

	public String getDataNav() {
		return FormattatoreDate.formatDate(dataNav, FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setDataNav(Date dataNav) {
		this.dataNav = dataNav;
	}

	public void setDataIscrizioneFormaPensionisticaComplementare(
			Date dataIscrizioneFormaPensionisticaComplementare) {
		this.dataIscrizioneFormaPensionisticaComplementare = dataIscrizioneFormaPensionisticaComplementare;
	}

	public String getDataAnticipazioneFondoPensioneFideuram() {
		return FormattatoreDate.formatDate(dataAnticipazioneFondoPensioneFideuram, FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setDataAnticipazioneFondoPensioneFideuram(
			Date dataAnticipazioneFondoPensioneFideuram) {
		this.dataAnticipazioneFondoPensioneFideuram = dataAnticipazioneFondoPensioneFideuram;
	}


}
