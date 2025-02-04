package com.fideuram.stampe.modello.rendita;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 01/12/15
 * Time: 17.39
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="prestazione", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prestazione {

    @XmlElement(name = "numeroPolizze",nillable = true)
    private String numeroPolizze;

    @XmlElement(name = "beneficiario",nillable = true)
    private String beneficiario;

    @XmlElement(name = "intestazione",nillable = true)
    private String intestazione;

    @XmlElement(name = "nominativo",nillable = true)
    private String nominativo;

    @XmlElement(name = "indirizzo",nillable = true)
    private String indirizzo;

    @XmlElement(name = "localita",nillable = true)
    private String localita;

    @XmlElement(name = "provincia",nillable = true)
    private String provincia;

    @XmlElement(name = "cap",nillable = true)
    private String cap;

    @XmlElement(name = "dataPagamento",nillable = true)
    private String dataPagamento;

    @XmlElement(name = "codiceIban",nillable = true)
    private String codiceIban;

    @XmlElement(name = "pagamentoIntestato",nillable = true)
    private String pagamentoIntestato;

    @XmlElement(name = "importoDiConguaglio",nillable = true)
    private String importoDiConguaglio;

    @XmlElement(name = "dataVersamento",nillable = true)
    private String dataVersamento;

    @XmlElement(name = "codiceFiscale",nillable = true)
    private String codiceFiscale;

    public String getNumeroPolizze() {
        return numeroPolizze;
    }

    public void setNumeroPolizze(String numeroPolizze) {
        this.numeroPolizze = numeroPolizze;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(String intestazione) {
        this.intestazione = intestazione;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getCodiceIban() {
        return codiceIban;
    }

    public void setCodiceIban(String codiceIban) {
        this.codiceIban = codiceIban;
    }

    public String getPagamentoIntestato() {
        return pagamentoIntestato;
    }

    public void setPagamentoIntestato(String pagamentoIntestato) {
        this.pagamentoIntestato = pagamentoIntestato;
    }

    public String getImportoDiConguaglio() {
        return importoDiConguaglio;
    }

    public void setImportoDiConguaglio(String importoDiConguaglio) {
        this.importoDiConguaglio = importoDiConguaglio;
    }

    public String getDataVersamento() {
        return dataVersamento;
    }

    public void setDataVersamento(String dataVersamento) {
        this.dataVersamento = dataVersamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
}
