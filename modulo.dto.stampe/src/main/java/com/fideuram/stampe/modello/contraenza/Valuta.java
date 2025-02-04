package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 01/07/15
 * Time: 15.14
 */
@XmlRootElement(name="Valuta", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Valuta {
    private Date dataValuta;
    private Double valore;
    private String valuta="€";

    public String getDataValuta() {
        return dataValuta!=null?FormattatoreDate.formatDate(dataValuta, FormattatoreDate.FORMATO_DATA_ITALIANA):"";
    }

    public String getValuta() {
        return valuta;
    }

    public String getValore() {
        return valore!=null?FormattatoreCifre.formatImporto(valore, ".", ","):"";
    }

    public void setDataValuta(Date dataValuta) {
        this.dataValuta = dataValuta;
    }

    public void setValore(Double valore) {
        this.valore = valore;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }
}
