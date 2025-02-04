package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 17.29
 */
public class Beneficiario {
    private String cognome          ;
    private String nome             ;
    private String codiceFiscale    ;
    private String dataNascita      ;
    private String comuneNascita    ;
    private String provNascita      ;
    private String comuneResidenza  ;
    private String provResidenza    ;
    private String egregio          ;

    public String getCognome() {
        return cognome.trim();
    }

    @XmlElement(name = "COGNOME")
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome.trim();
    }

    @XmlElement(name = "NOME")
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale.trim();
    }

    @XmlElement(name = "CODICEFISCALE")
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDataNascita() {
        return dataNascita.trim();
    }

    @XmlElement(name = "DATANASCITA")
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getComuneNascita() {
        return comuneNascita.trim();
    }

    @XmlElement(name = "COMUNENASCITA")
    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public String getProvNascita() {
        return provNascita.trim();
    }

    @XmlElement(name = "PROVNASCITA")
    public void setProvNascita(String provNascita) {
        this.provNascita = provNascita;
    }

    public String getComuneResidenza() {
        return comuneResidenza.trim();
    }

    @XmlElement(name = "COMUNERESIDENZA")
    public void setComuneResidenza(String comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }

    public String getProvResidenza() {
        return provResidenza.trim();
    }

    @XmlElement(name = "PROVRESIDENZA")
    public void setProvResidenza(String provResidenza) {
        this.provResidenza = provResidenza;
    }

    public String getEgregio() {
        return egregio.trim();
    }

    @XmlElement(name = "EGREGIO")
    public void setEgregio(String egregio) {
        this.egregio = egregio;
    }
}
