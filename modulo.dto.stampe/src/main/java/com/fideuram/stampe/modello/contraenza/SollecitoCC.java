package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by V801068 on 14/05/14.
 */
@XmlRootElement(name="SollecitoCC", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class SollecitoCC extends CambioContraenza{
    public SollecitoCC() {
        sollecito=true;
    }

    private Date dataSollecito;

    public String getDataSollecito() {
        if(null==dataSollecito)
            dataSollecito=new Date();
        return FormattatoreDate.formatDate(dataSollecito, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setDataSollecito(Date dataSollecito) {
        this.dataSollecito = dataSollecito;
    }
}