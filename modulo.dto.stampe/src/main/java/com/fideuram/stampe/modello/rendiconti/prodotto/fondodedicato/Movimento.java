package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: v801068
 * Date: 07/11/14
 * Time: 16.52
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Movimento {
    private String isin;
    private String descrizioneTitolo;
    private Divisa divisa;
    private String operazione       ;
    private Date   dataOperazione   ;
    private Date   dataValuta       ;
    private Date   dataBanca        ;
    private Double valoreNominale   ;
    private Double prezzoOperazione ;
    private Double valoreOperazione ;
    private Double pmRealizzo       ;
    private Double cambio           ;
    private Double pmCambio         ;
    private Double scartoEmissioni  ;

    public String getDescrizioneTitolo() {
        return descrizioneTitolo.toUpperCase();
    }

    public Divisa getDivisa() {
        return divisa;
    }

    public String getOperazione() {
        return operazione;
    }

    public String getDataOperazione() {
        return FormattatoreDate.formatDate(dataOperazione,FormattatoreDate.FORMATO_DATA_ITALIANA_SLASH);
    }

    public String getDataValuta() {
        return FormattatoreDate.formatDate(dataValuta,FormattatoreDate.FORMATO_DATA_ITALIANA_SLASH);
    }

    public String getDataBanca() {
        return FormattatoreDate.formatDate(dataBanca,FormattatoreDate.FORMATO_DATA_ITALIANA_SLASH);
    }

    public String getValoreNominale() {
        return FormattatoreCifre.formatImporto(valoreNominale, ".", ",");
        //return valoreNominale;
    }

    public String getPrezzoOperazione() {
        return FormattatoreCifre.formatImporto(prezzoOperazione, ".", ",");
        //return prezzoOperazione;
    }

    public String getValoreOperazione() {
        return FormattatoreCifre.formatImporto(valoreOperazione, ".", ",");
        //return valoreOperazione;
    }

    public String getPmRealizzo() {
        return   FormattatoreCifre.formatImporto(pmRealizzo, ".", ",");
        //return pmRealizzo;
    }

    public String getCambio() {
        return   FormattatoreCifre.formatImporto(cambio, ".", ",");
        //return cambio;
    }

    public String getPmCambio() {
        return   FormattatoreCifre.formatImporto(pmCambio, ".", ",");
        //return pmCambio ;
    }

    public String getScartoEmissioni() {
        return   FormattatoreCifre.formatImporto(scartoEmissioni, ".", ",");
        //return scartoEmissioni;
    }

    public void setDescrizioneTitolo(String descrizioneTitolo) {
        this.descrizioneTitolo = descrizioneTitolo;
    }

    public void setDivisa(Divisa divisa) {
        this.divisa = divisa;
    }

    public void setOperazione(String operazione) {
        this.operazione = operazione;
    }

    public void setDataOperazione(Date dataOperazione) {
        this.dataOperazione = dataOperazione;
    }

    public void setDataValuta(Date dataValuta) {
        this.dataValuta = dataValuta;
    }

    public void setDataBanca(Date dataBanca) {
        this.dataBanca = dataBanca;
    }

    public void setValoreNominale(Double valoreNominale) {
        this.valoreNominale = valoreNominale;
    }

    public void setPrezzoOperazione(Double prezzoOperazione) {
        this.prezzoOperazione = prezzoOperazione;
    }

    public void setValoreOperazione(Double valoreOperazione) {
        this.valoreOperazione = valoreOperazione;
    }

    public void setPmRealizzo(Double pmRealizzo) {
        this.pmRealizzo = pmRealizzo;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }

    public void setPmCambio(Double pmCambio) {
        this.pmCambio = pmCambio;
    }

    public void setScartoEmissioni(Double scartoEmissioni) {
        this.scartoEmissioni = scartoEmissioni;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
}
