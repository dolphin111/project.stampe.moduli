package com.fideuram.stampe.modello.polizza;

import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.PrivateBanker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 06/09/12
 * Time: 9.35
 */
@XmlRootElement(name="Polizza")
@XmlAccessorType(XmlAccessType.FIELD)
public class Polizza {
    private String        numero;
    private String        nomeCommercialeProdotto;
    private String        tipoPremio;  //U=unico; A||R=ricorrente
    private PrivateBanker privateBanker;
    private Contraente    contraente;
    private Assicurato    assicurato;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeCommercialeProdotto() {
        return nomeCommercialeProdotto;
    }

    public void setNomeCommercialeProdotto(String nomeCommercialeProdotto) {
        this.nomeCommercialeProdotto = nomeCommercialeProdotto;
    }

    public String getTipoPremio() {
        return tipoPremio;
    }

    public void setTipoPremio(String tipoPremio) {
        this.tipoPremio = tipoPremio;
    }

    public PrivateBanker getPrivateBanker() {
        return privateBanker;
    }

    public void setPrivateBanker(PrivateBanker privateBanker) {
        this.privateBanker = privateBanker;
    }

    public Contraente getContraente() {
        return contraente;
    }

    public void setContraente(Contraente contraente) {
        this.contraente = contraente;
    }

    public Assicurato getAssicurato() {
        return assicurato;
    }

    public void setAssicurato(Assicurato assicurato) {
        this.assicurato = assicurato;
    }

}