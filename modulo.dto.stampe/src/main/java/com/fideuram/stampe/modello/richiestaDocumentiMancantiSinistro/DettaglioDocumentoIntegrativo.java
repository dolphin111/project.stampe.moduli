package com.fideuram.stampe.modello.richiestaDocumentiMancantiSinistro;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by V801068 on 14/05/14.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class DettaglioDocumentoIntegrativo {

	
    private String        ID;
    private String     descrizione;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
    
}
