package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 17/06/15
 * Time: 8.25
 */
@XmlRootElement(name="RichiestaVariazione", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RichiestaVariazione {
    protected   Date        dataRichiesta;
    protected   boolean     sollecito=false;
    protected   Contratto   polizza;

    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public boolean isSollecito() {
        return sollecito;
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public void setSollecito(boolean sollecito) {
        this.sollecito = sollecito;
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }
}
