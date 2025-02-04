package com.fideuram.stampe.modello.mandatiPagamento;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BENEFICIARIO", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Beneficiario {

    @XmlElement(name = "NOMINATIVO")
    private String nominativo;

    @XmlElement(name = "IMPORTO")
    public String  importo;

    @XmlElement(name = "IBAN",nillable = true)
    public String  iban;

    @XmlElement(name = "DATASCADENZA")
    public String  scadenza;

    @XmlElement(name = "DATAVALUTA")
    public String  valuta;

    @XmlElement(name = "NUMEROPROTOCOLLO",nillable = true)
    public String  numProt;

    @XmlElement(name = "NUMEROASSEGNO",nillable = true)
    public String  numAss;

    @XmlElement(name = "LOCALITA",nillable = true)
    public String  localita;

    @XmlElement(name = "INDIRIZZO",nillable = true)
    public String  indirizzo;

    @XmlElement(name = "PROVINCIA",nillable = true)
    public String  provincia;

    @XmlElement(name = "CAP",nillable = true)
    public String  cap;

    @XmlElement(name = "PROGRESSIVO",nillable = true)
    private int progressivo;

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getImporto() {
        return importo;
    }

    public void setImporto(String importo) {
        this.importo = importo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }



    public String getLocalita() {
        return localita;
    }

    public String getNumProt() {
        return numProt;
    }

    public void setNumProt(String numProt) {
        this.numProt = numProt;
    }

    public String getNumAss() {
        return numAss;
    }

    public void setNumAss(String numAss) {
        this.numAss = numAss;
    }

    public void setLocalita(String localita) {
        this.localita = localita;

    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public int getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(int progressivo) {
        this.progressivo = progressivo;
    }
}
