package com.fideuram.modello.polizza.finanziario;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 18/04/13
 * Time: 17.02
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoRiallocazioneGuidata {

    private String  codice;
    private String  descrizione="";
    private String  tipoRiallocazione;
    private String  descrizioneTipoRiallocazione="";
    private Date    dataInizioValiditaFV;


    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getTipoRiallocazione() {
        return tipoRiallocazione;
    }

    public String getDataInizioValiditaFV() {
        //if(codice.equalsIgnoreCase("RM0U1")&&(null!=dataInizioValiditaFV)){  commentato il 01-09-2015 - abbiamo convenuto ciò con CRI
        if((null!=dataInizioValiditaFV)){
                return FormatterFactory.getStandardDate(dataInizioValiditaFV);
        }else {
            //return null;
            return "";
        }
    }

    public String getDescrizioneTipoRiallocazione() {
        return descrizioneTipoRiallocazione;
    }

    @Override
    public String toString() {
        return   descrizione +" ("+descrizioneTipoRiallocazione+")";
    }
}
