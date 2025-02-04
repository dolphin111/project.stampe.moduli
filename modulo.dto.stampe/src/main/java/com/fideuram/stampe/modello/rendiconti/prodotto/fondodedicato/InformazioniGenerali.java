package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato;

import com.fideuram.stampe.modello.utils.EncoderString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 07/11/14
 * Time: 15.28
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class InformazioniGenerali {
    private String commentoaimercati;
    private String assetallocartion;
    private String operazionidelmese;

    public String getCommentoaimercati() {
        return commentoaimercati;
    }

    public String getAssetallocartion() {
        return assetallocartion;
    }

    public String getOperazionidelmese() {
        return operazionidelmese;
    }

    public void setCommentoaimercati(String commentoaimercati) {
        this.commentoaimercati = commentoaimercati;
    }

    public void setAssetallocartion(String assetallocartion) {
        this.assetallocartion = assetallocartion;
    }

    public void setOperazionidelmese(String operazionidelmese) {
        this.operazionidelmese = operazionidelmese;
    }
}
