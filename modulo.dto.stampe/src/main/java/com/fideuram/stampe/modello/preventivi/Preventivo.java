package com.fideuram.stampe.modello.preventivi;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created
 * User: V801068
 * Date: 17/07/14
 * Time: 14.53
 */
@XmlRootElement(name="Preventivo", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Preventivo {
    private Comunicazione    comunicazione;
    private Date             dataPreventivo;
    private Prodotto         prodotto;
    private Individuo        assicurato;
    private Rateo            rateo;
    private RenditaVitalizia vitalizio;

    public Comunicazione getComunicazione() {
        return comunicazione;
    }

    public String getDataPreventivo() {
        return FormattatoreDate.formatDate(new Date(),FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);
    }

    public Prodotto getProdotto() {
        return prodotto!=null?prodotto:new Prodotto();
    }

    public Individuo getAssicurato() {
        return assicurato;
    }

    public Rateo getRateo() {
        return rateo;
    }

    public RenditaVitalizia getVitalizio() {
        return vitalizio;
    }

    /**
     * <br><Questo metodo indica la natura del preventivo
     * <br>Se restituisce true:
     * <br>Il preventivo consiste nel calcolo del rateo da versare per ottenere il Vitalizio voluto
     * <br>
     * <br>Se restituisce false:
     * <br>Il preventivo consiste nel calcolo del Vitalizio ottenuto a fronte del rateo che si sta pagando
     * @return  boolean
     */
    public boolean isPreventivoDiCalcoloRateo(){
        return rateo.hasPremio();
    }

    public void setComunicazione(Comunicazione comunicazione) {
        this.comunicazione = comunicazione;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public void setAssicurato(Individuo assicurato) {
        this.assicurato = assicurato;
    }

    public void setVitalizio(RenditaVitalizia vitalizio) {
        this.vitalizio = vitalizio;
    }

    public void setRateo(Rateo rateo) {
        this.rateo = rateo;
    }



    /**
     * tck 853
     *
     * @return String:<br> "(IN QUESTO CASO NON CONCEDIBILE)"
     *                <br> solo nel caso di preventivo di calcolo rateo
     */
    public String isConcedibile(){
        if(isPreventivoDiCalcoloRateo())
           return vitalizio.isConcedibile();
        return "";
    }

}
