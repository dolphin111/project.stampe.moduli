package com.fideuram.stampe.modello.previdenza.versamenti;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 14.40
 */
@XmlRootElement(name="Distinta", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Distinta {
      private Boolean      inLavorazione;   //definisce se la stampa è in "Bozza" oppure "Definitiva"
      private Date         dataCreazione;   //indica la data di prima registrazione di questa distinta sul DB
      private String       progressivo;
      private String       competenza;
      private String       descrizione;
      private DatoreLavoro datoreLavoro;


    public Boolean getInLavorazione() {
        return inLavorazione!=null?inLavorazione:false;
    }

    public String getDataCreazione() {
        return FormattatoreDate.formatDate(dataCreazione,FormattatoreDate.FORMATO_DATA_ITALIANA_CON_ORA);
    }

    public String getProgressivo() { return progressivo;}
    public String getCompetenza() { return competenza!=null?competenza:""; }
    public String getDescrizione() {return descrizione!=null?descrizione:"";}
    public DatoreLavoro getDatoreLavoro() { return datoreLavoro!=null?datoreLavoro:new DatoreLavoro();}


    /**
     * <br>Questo settaggio definisce se la stampa è in "Bozza" oppure "Definitiva".
     * <br>Quindi se si passa "true" , l'eventuale stampa sarà una Bozza
     * <br>Quindi se si passa "false", l'eventuale stampa sarà in formato definitivo
     * @param inLavorazione
     */
    public void setInLavorazione(Boolean inLavorazione) {
        this.inLavorazione = inLavorazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public void setProgressivo(String progressivo) {
        this.progressivo = progressivo;
    }

    public void setCompetenza(String competenza) {
        this.competenza = competenza;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setDatoreLavoro(DatoreLavoro datoreLavoro) {
        this.datoreLavoro = datoreLavoro;
    }
}
