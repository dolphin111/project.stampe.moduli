package com.fideuram.stampe.modello.richiestaDocumentiMancantiSinistro;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by V801098 on 23/02/17.
 */
@XmlRootElement(name="RichiestaDocumentiMancantiSinistro", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RichiestaDocumentiMancantiSinistro {

    private Date           dataRichiesta;
    protected Contratto    polizza;
    protected List<DettaglioDocumentoIntegrativo> docIntgrativa;
    private boolean isDSN; //dichiarazione sostitutiva notorieta'
    private boolean isMAV; //modulo adeguata verifica
    private boolean isMAF; //modulo adeguata FACTA
    private boolean isMCT; //modulo consenso trattamento dei dati

    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }


    public Contratto getPolizza() {
        return polizza;
    }

    public List<String> getDocIntgrativa() {
    	
    	List<String> l = new ArrayList<String>();
    	for (DettaglioDocumentoIntegrativo d : docIntgrativa) 
    	{
			l.add(d.getDescrizione()!=null?d.getDescrizione():"");
			
			if(d.getID() != null && d.getID().equalsIgnoreCase("L3"))
			{
				isDSN = true;
			}
			//modifica per generazione lettera sinistro 04-02-2020
			if(d.getID() != null && d.getID().equalsIgnoreCase("AV"))
			{
				isMAV = true;
			}
			
			if(d.getID() != null && d.getID().equalsIgnoreCase("19"))
			{
				isMAF = true;
			}
			if(d.getID() != null && d.getID().equalsIgnoreCase("60"))
			{
				isMCT = true;
			}
		}
    	
        return l;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public void setDocIntgrativa(List<DettaglioDocumentoIntegrativo> docIntgrativa) {
        this.docIntgrativa = docIntgrativa;
    }

    public void addDocIntegrativa(DettaglioDocumentoIntegrativo doc){
        if(null==docIntgrativa)
            docIntgrativa=new ArrayList<DettaglioDocumentoIntegrativo>();
        docIntgrativa.add(doc);
    }


	public boolean isDSN() {
		
		return isDSN;
	}
	public boolean isMAV() {
			
			return isMAV;
		}
	public boolean isMAF() {
		
		return isMAF;
	}
	public boolean isMCT() {
		
		return isMCT;
	}

}
