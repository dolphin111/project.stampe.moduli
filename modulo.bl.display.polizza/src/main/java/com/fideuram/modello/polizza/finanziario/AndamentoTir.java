package com.fideuram.modello.polizza.finanziario;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 10.42
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AndamentoTir {
    private Double valore;
    private Date data;
    private String descrizione;

    public String getValore() {
        return FormatterFactory.getStandardImporto(valore);
    }
    public Double getValoreToDouble() {
        return valore;
    }

    public String getData() {
        return FormatterFactory.getStandardDate(data);
    }
    public Date getDataToDate() {
        return data;
    }

    public String getDescrizione(){
        return descrizione;
    }


}
