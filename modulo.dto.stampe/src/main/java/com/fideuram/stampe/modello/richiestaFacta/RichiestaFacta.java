package com.fideuram.stampe.modello.richiestaFacta;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FrancescoD. on 16/10/18.
 */
@XmlRootElement(name="RichiestaFacta", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RichiestaFacta {

    private Date           dataRichiesta;
    protected Documento    polizza;
    protected List<DettaglioDocumentoIntegrativo> docIntgrativa;
    private boolean isDSN; //dichiarazione sostitutiva notorieta'

    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }


    public Documento getPolizza() {
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
		}
    	
        return l;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public void setPolizza(Documento polizza) {
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

}
