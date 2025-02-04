package com.fideuram.stampe.modello.attori;


import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 10.42
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Individuo {
    protected String   titolo="Spett.le";
    protected String   ragioneSociale;
    protected String   cognome;
    protected String   nome;
    protected String   cf;
    protected Recapito indirizzo;
    protected Date     dataNascita;
    protected String   comuneNascita;
    protected String   provinciaNascita;
    protected String   sesso;
    protected String   percentualeBeneficiario;  //Redmine:  feature 150



    public boolean isPersonaFisica() {
        if(null==ragioneSociale||"".equals(ragioneSociale.trim()))
            return true;
        return false;
    }


    public String getTitolo() {
        return titolo;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }


    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCf() {return cf!=null?cf:"";}

    public Recapito getIndirizzo() {
        return indirizzo!=null?indirizzo:new Recapito();
    }

    public Boolean hasIndirizzo(){
        return indirizzo!=null?true:false;
    }

    public String getDataNascita() {
        return FormattatoreDate.formatDate(dataNascita, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getDataNascitaStandardInfo() {
        return FormattatoreDate.formatDate(dataNascita, FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);
    }

    public Date getDataNascitaUnformatted() {
        return dataNascita;
    }

    public String getComuneNascita() {
        return comuneNascita;
    }

    public String getProvinciaNascita() {
        return provinciaNascita;
    }

    public String getSesso() {
        return sesso.toUpperCase();
    }

    public String getPercentualeBeneficiario() {
        return percentualeBeneficiario!=null?percentualeBeneficiario:"";
    }

    public void setPercentualeBeneficiario(String percentualeBeneficiario) {
        this.percentualeBeneficiario = percentualeBeneficiario;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
        setSesso("G");
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCf(String cf) {this.cf = cf;}

    public void setIndirizzo(Recapito indirizzo) {
        this.indirizzo=indirizzo;
    }

    public void setIndirizzo(String via, String comune, String cap, String provincia) {
       indirizzo= new Recapito();
       indirizzo.setVia(via);
       indirizzo.setCap(cap);
       indirizzo.setComune(comune);
       indirizzo.setProvincia(provincia);
    }


    public void setDataNascita(Date dataNascita) {
        this.dataNascita=dataNascita;
    }

    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public void setProvinciaNascita(String provinciaNascita) {
        this.provinciaNascita = provinciaNascita;
    }

    public void setSesso(String sesso) {
        this.sesso=sesso!=null?sesso:"G";

        if ("M".equalsIgnoreCase(getSesso())) {
            titolo="Gentile Signor";

        } else if ("F".equalsIgnoreCase(getSesso())) {
            titolo="Gentile Signora";

        } else if ("G".equalsIgnoreCase(getSesso())) {
            titolo="Spett.le";

        } else {
            titolo="Spett.le";
        }
    }


    @Override
    public String toString() {
        if(isPersonaFisica())
           return (cognome!=null?cognome:"")+(nome!=null?" "+nome:"");
        else
           return ragioneSociale!=null?ragioneSociale:"";
    }

    public Individuo(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }

    public Individuo(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public Individuo() {
    }

    public boolean isUomo(){
         return "M".equalsIgnoreCase(getSesso())?true:false;
    }
}
