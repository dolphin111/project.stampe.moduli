
package com.fideuram.stampe.modello.preventivi;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 17/07/14
 * Time: 15.55
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rateo {
    private Double  importoPremio;
    private int     durataMinima;
    private Date    decorrenza;
    private int     decumulo;       //si esprime in percentuale

    public String getImportoPremio() {
        return FormattatoreCifre.formatImporto(importoPremio, ".", ",");
    }

    public boolean hasPremio(){
        if (importoPremio!=null&&importoPremio>0)
            return true;
        return false;
    }

    public boolean hasDecumulo(){
        if(decumulo>0)
            return true;
        return false;
    }

    public int getDecumulo() {
        return decumulo;
    }

    public String getDecorrenza() {
        return FormattatoreDate.formatDate(decorrenza, FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);
    }

    public int getDurataMinima() {
        return durataMinima;
    }

    public void setImportoPremio(Double importoPremio) {
        this.importoPremio = importoPremio;
    }

    public void setImportoPremio(String importoPremio) {
        this.importoPremio = Double.valueOf(!importoPremio.equals("")?importoPremio:"0");
    }

    public void setDurataMinima(int durataMinima) {
        this.durataMinima = durataMinima;
    }

    public void setDecorrenza(Date decorrenza) {
        this.decorrenza = decorrenza;
    }

    public void setDecumulo(int decumulo) {
        this.decumulo = decumulo;
    }


}
