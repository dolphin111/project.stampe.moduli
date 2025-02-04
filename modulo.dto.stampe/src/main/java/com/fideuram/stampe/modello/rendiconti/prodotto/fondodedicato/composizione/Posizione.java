package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.Performance;
import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 07/11/14
 * Time: 10.30
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Posizione {
    private String      isin;
    private String      descrizioneTitolo;
    private Double      peso;
    private Double      prezzoStorico;
    private Double      cambioStorico;
    private Double      prezzoMercato;
    private Double      cambioMercato;
    private Performance performance;
    private Divisa      div;

    public String getDescrizioneTitolo() {
        return descrizioneTitolo.toUpperCase();
    }

    public String getPeso() {
        return FormattatorePerc.percentualeStandard(peso,true);
    }

    public String getPrezzoStorico() {
        return FormattatoreCifre.formatImporto(prezzoStorico, ".", ",");
    }

    public String getCambioStorico() {
        return FormattatoreCifre.formatImporto(cambioStorico, ".", ",");
    }

    public String getPrezzoMercato() {
        return FormattatoreCifre.formatImporto(prezzoMercato, ".", ",");
    }

    public String getCambioMercato() {
        return FormattatoreCifre.formatImporto(cambioMercato, ".", ",");
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setDescrizioneTitolo(String descrizioneTitolo) {
        this.descrizioneTitolo = descrizioneTitolo;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setPrezzoStorico(Double prezzoStorico) {
        this.prezzoStorico = prezzoStorico;
    }

    public void setCambioStorico(Double cambioStorico) {
        this.cambioStorico = cambioStorico;
    }

    public void setPrezzoMercato(Double prezzoMercato) {
        this.prezzoMercato = prezzoMercato;
    }

    public void setCambioMercato(Double cambioMercato) {
        this.cambioMercato = cambioMercato;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Divisa getDiv() {
        return div;
    }

    public void setDiv(Divisa div) {
        this.div = div;
    }
}
