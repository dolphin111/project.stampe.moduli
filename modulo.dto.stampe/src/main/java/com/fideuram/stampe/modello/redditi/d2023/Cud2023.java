package com.fideuram.stampe.modello.redditi.d2023;

import com.fideuram.stampe.modello.redditi.CudBase;
import com.fideuram.stampe.modello.redditi.d2023.annotazioni.Annotazioni;
import com.fideuram.stampe.modello.redditi.d2023.datiFiscali.DatiFiscali;
import com.fideuram.stampe.modello.redditi.d2023.datiPrevidenziali.DatiPrevidenziali;
import com.fideuram.stampe.modello.redditi.d2023.redditidiversi.GestioneSeparata;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801092
 */
@XmlRootElement(name="CUD2023")
@XmlAccessorType(XmlAccessType.FIELD)

public class Cud2023 extends CudBase {
	    
	private String progressivoCertificazione;


	private DatiFiscali datiFiscali;
	private DatiPrevidenziali datiPrevidenziali;
	private GestioneSeparata gestioneSeparata;
	private Annotazioni annotazioni;
	protected Date     			dataInvio;
	    
	    public String getDataDataInvio() {
	        return FormattatoreDate.formatDate(dataInvio, FormattatoreDate.FORMATO_DATA_dd___MM___YYYY);
	    }

	    public Cud2023() {
	        this.annoFiscale="2023";
	    }

	    public String getProgressivoCertificazione() {
	        return progressivoCertificazione;
	    }

	    public void setProgressivoCertificazione(String progressivoCertificazione) {
	        this.progressivoCertificazione = progressivoCertificazione;
	    }

	    public DatiFiscali getDatiFiscali() {
	        return datiFiscali;
	    }

	    public void setDatiFiscali(DatiFiscali datiFiscali) {
	        this.datiFiscali = datiFiscali;
	    }

	    public DatiPrevidenziali getDatiPrevidenziali() {
	        return datiPrevidenziali;
	    }

	    public void setDatiPrevidenziali(DatiPrevidenziali datiPrevidenziali) {
	        this.datiPrevidenziali = datiPrevidenziali;
	    }

	    public GestioneSeparata getGestioneSeparata() {
	        return gestioneSeparata;
	    }

	    public void setGestioneSeparata(GestioneSeparata gestioneSeparata) {
	        this.gestioneSeparata = gestioneSeparata;
	    }

		
	    public Annotazioni getAnnotazioni() {
	        return annotazioni!=null?annotazioni:new Annotazioni();
	    }

	    public void setAnnotazioni(Annotazioni annotazioni) {
	        this.annotazioni = annotazioni;
	    }

		public Date getDataInvio() {
			return dataInvio;
		}

		public void setDataInvio(Date dataInvio) {
			this.dataInvio = dataInvio;
		}
	    
	}
