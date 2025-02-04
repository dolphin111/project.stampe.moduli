package com.fideuram.stampe.modello.previdenza;

import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;
import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.utils.FormattatoreDate;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by V801068 on 03/06/14.
 */
@XmlRootElement(name="Previdenza", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Previdenza {
    private   Date            primaIscrizione;    //riferito alla data di prima iscrizione ad un qualsiasi fondo pensionistico
    private   Date            primaLiquidabilita; //riferito alla data di prima liquidabilità calcolata sulla data di prima iscrizione
    protected Contratto       polizza;
    private   Convenzione     convenzione;
    private   Liquidazione    liquidazione;
    protected Documentazione  documentazione;
    private   Rigetto         rigetto;
    private   Comunicazione   richiesta;

    public void setPrimaIscrizione(Date primaIscrizione) {this.primaIscrizione = primaIscrizione;}

    public void setPrimaLiquidabilita(Date primaLiquidabilita) {this.primaLiquidabilita = primaLiquidabilita;}

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public void setConvenzione(Convenzione convenzione) {
        this.convenzione = convenzione;
    }

    public void setLiquidazione(Liquidazione liquidazione) {
        this.liquidazione = liquidazione;
    }

    public void setRigetto(Rigetto rigetto) {
        this.rigetto = rigetto;
    }

    public void setDocumentazione(Documentazione documentazione) {this.documentazione = documentazione;}

    public void setRichiesta(Comunicazione richiesta) {this.richiesta = richiesta;}

    public String getPrimaIscrizione() {
        return FormattatoreDate.formatDate(primaIscrizione, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }


    public String getPrimaLiquidabilita() {
        return FormattatoreDate.formatDate(primaLiquidabilita, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public Convenzione getConvenzione() {
        return convenzione!=null?convenzione:new Convenzione();
    }

    public Liquidazione getLiquidazione() {
        return liquidazione!=null?liquidazione:new Liquidazione();
    }

    public Documentazione getDocumentazione(){
        return documentazione!=null?documentazione:new Documentazione();
    }

    public Rigetto getRigetto() {
        return rigetto!=null?rigetto:new Rigetto();
    }


    public String getDataStampa(){
        return FormattatoreDate.formatDate(new Date(), FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public Comunicazione getRichiesta() { return richiesta; }
}
