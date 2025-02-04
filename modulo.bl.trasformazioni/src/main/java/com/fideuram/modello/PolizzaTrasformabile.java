package com.fideuram.modello;

import com.fideuram.modello.contratti.Contratto;
import com.fideuram.stampe.modello.polizza.Polizza;
import com.fideuram.utils.FormattatoreCifre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 25/02/13
 * Time: 16.54
 */
@XmlRootElement(name="polizzaTrasformabile", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class PolizzaTrasformabile {
    //public static final String CANALE_PO="PO";
    private String  canale="0";      //canale di vendita    0=fv 1=po

    private Polizza polizza;
    private String  nomeCommercialeProdottoDestinazione;
    private String  decorrenza;
    private String  scadenza;
    private String  durata;
    private String  dataProposta; //equivalente a data sistema
    private String  numeroSchedaTrasformazione="";
    private String  dataNav="";
    private String  controvalorePolizza="";

    private Contratto origine;

    public Polizza getPolizza() {
        return polizza;
    }

    public void setPolizza(Polizza polizza) {
        this.polizza = polizza;
    }

    public String getNomeCommercialeProdottoDestinazione() {
        return nomeCommercialeProdottoDestinazione;
    }

    public void setNomeCommercialeProdottoDestinazione(String nomeCommercialeProdottoDestinazione) {
        this.nomeCommercialeProdottoDestinazione = nomeCommercialeProdottoDestinazione;
    }

    public String getDecorrenza() {
        return decorrenza;
    }

    public void setDecorrenza(String decorrenza) {
        this.decorrenza = decorrenza;
    }

    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(String dataProposta) {
        this.dataProposta = dataProposta;
    }

    public String getCanale() {
        return canale;
    }

    public void setCanale(String canale) {
        this.canale = canale;
    }

    public Contratto getOrigine() {
        return origine;
    }

    public void setOrigine(Contratto origine) {
        this.origine = origine;
    }

    public String getNumeroSchedaTrasformazione() {
        return numeroSchedaTrasformazione;
    }

    public void setNumeroSchedaTrasformazione(String numeroSchedaTrasformazione) {
        this.numeroSchedaTrasformazione = numeroSchedaTrasformazione;
    }

    public String getDataNav() {
        return dataNav;
    }

    public void setDataNav(String dataNav) {
        this.dataNav = dataNav;
    }

    public String getControvalorePolizza() {

        return FormattatoreCifre.formatImporto(new Double(controvalorePolizza), ".", ",");
    }

    public void setControvalorePolizza(String controvalorePolizza) {
        this.controvalorePolizza = controvalorePolizza;
    }

    @Override
    public String toString() {
        return "PolizzaTrasformabile{" +
                "canale='" + canale + '\'' +
                ", polizza=" + polizza +
                ", nomeCommercialeProdottoDestinazione='" + nomeCommercialeProdottoDestinazione + '\'' +
                ", decorrenza='" + decorrenza + '\'' +
                ", scadenza='" + scadenza + '\'' +
                ", durata='" + durata + '\'' +
                ", dataProposta='" + dataProposta + '\'' +
                ", dataNav='" + dataNav + '\'' +
                ", controvalorePolizza='" + controvalorePolizza + '\'' +
                ", numeroSchedaTrasformazione='" + numeroSchedaTrasformazione + '\'' +
                ", origine=" + origine +
                '}';
    }
}
