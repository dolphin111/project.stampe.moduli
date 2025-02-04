package com.fideuram.stampe.modello.contocorrente;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 23/06/14
 * Time: 10.45
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContoCorrente {
    private Date   dataCostituzione;
    private String IBAN;
    private String cfPiva;

    public String getDataCostituzione() {
        return FormattatoreDate.formatDate(dataCostituzione,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getCfPiva() {
        return cfPiva;
    }


    public void setDataCostituzione(Date dataCostituzione) {
        this.dataCostituzione = dataCostituzione;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setCfPiva(String cfPiva) {
        this.cfPiva = cfPiva;
    }
}
