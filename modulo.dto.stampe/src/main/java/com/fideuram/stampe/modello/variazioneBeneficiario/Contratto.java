package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.stampe.modello.attori.Compagnia;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.contocorrente.FondoPensione;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by V801068 on 14/05/14.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Contratto {

    private FondoPensione fondoPensione;      //Identifica il fondo pensione a si riferisce questo contratto
    private Compagnia     compagniaDiProvenienza;
    private Compagnia     compagniaDiDestinazione;


    private String        numeroID;
    private String        descrizioneProdotto;   //todo rifattorizzare con Prodotto
    private Date          adesione;
    private Date          decorrenza;
    private Individuo     contraente;
    private Individuo     assicurato;
    private Individuo     aderente;
    private Individuo     pb;
    private Date          emissione;
    


    public String getEmissione() {
    	  return FormattatoreDate.formatDate(emissione,FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setEmissione(Date emissione) {
		this.emissione = emissione;
	}

	public String getNumeroID() {
        return numeroID;
    }

    public String getSottoscrizione() {
        return FormattatoreDate.formatDate(adesione,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getDecorrenza() {
        return FormattatoreDate.formatDate(decorrenza,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public Individuo getContraente() {
        return contraente!=null?contraente:new Individuo();
    }

    public Individuo getAssicurato() {
        return assicurato;
    }

    public Individuo getAderente() {
        return aderente!=null?aderente:new Individuo();
    }

    public Individuo getPb() {
        return pb;
    }

    public boolean hasPb(){
        if(null==pb)
          return false;
        else if(null==pb.getCognome()||pb.getCognome().trim().equals(""))
          return false;
        else
          return true;
    }

    public String getDescrizioneProdotto() {
        return descrizioneProdotto!=null?descrizioneProdotto:"";
    }

    public Compagnia getCompagniaDiProvenienza() {
        return compagniaDiProvenienza;
    }

    public Compagnia getCompagniaDiDestinazione() {
        return compagniaDiDestinazione;
    }

    public FondoPensione getFondoPensione() {
        return fondoPensione;
    }

    public String getAdesione() {
        return FormattatoreDate.formatDate(adesione,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setNumeroID(String numeroID) {
        this.numeroID = numeroID;
    }

    public void setSottoscrizione(Date sottoscrizione) { this.adesione = sottoscrizione;}

    public void setDecorrenza(Date decorrenza) {
        this.decorrenza = decorrenza;
    }

    public void setContraente(Individuo contraente) {
        this.contraente = contraente;
    }

    public void setAssicurato(Individuo assicurato) {
        this.assicurato = assicurato;
    }

    public void setAderente(Individuo aderente) {
        this.aderente = aderente;
    }

    public void setPb(Individuo pb) {
        this.pb = pb;
    }

    public void setDescrizioneProdotto(String descrizioneProdotto) {
        this.descrizioneProdotto = descrizioneProdotto;
    }

    public void setCompagniaDiProvenienza(Compagnia compagniaDiProvenienza) {
        this.compagniaDiProvenienza = compagniaDiProvenienza;
    }

    public void setCompagniaDiDestinazione(Compagnia compagniaDiDestinazione) {
        this.compagniaDiDestinazione = compagniaDiDestinazione;
    }

    public void setFondoPensione(FondoPensione fondoPensione) {
        this.fondoPensione = fondoPensione;
    }
}
