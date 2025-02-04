package com.fideuram.stampe.modello.preventivi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with
 * User: V801068
 * Date: 21/07/14
 * Time: 10.25
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prodotto {
    private String codice;
    private String descrizione;
    private FamigliaProdotto famigliaProdotto;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public FamigliaProdotto getFamigliaProdotto() {
        return famigliaProdotto!=null?famigliaProdotto:new FamigliaProdotto();
    }

    public void setFamigliaProdotto(FamigliaProdotto famigliaProdotto) {
        this.famigliaProdotto = famigliaProdotto;
    }

    @Override
    public String toString() {
        return descrizione;
    }
}
