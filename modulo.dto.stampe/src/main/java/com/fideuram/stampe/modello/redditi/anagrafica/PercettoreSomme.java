package com.fideuram.stampe.modello.redditi.anagrafica;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 19/11/14
 * Time: 15.58
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class PercettoreSomme extends Individuo {
    private String              categorieParticolari;
    private String              eventiEccezionali;
    private String              casiEsclusione;
    private DomicilioFiscale    dfAttuale;
    private DomicilioFiscale    dfAnnoPrecedente;
    private Individuo           rappresentante;
    private FamiliariACarico    familiariACarico;
    private ResidenzaEstero     residenzaEstero;


    public String getDataNascita() {
        return FormattatoreDate.formatDate(dataNascita, FormattatoreDate.FORMATO_DATA_dd___MM___YYYY);
    }

    public String getDataNascitaDilatatissimo() {
        return FormattatoreDate.formatDate(dataNascita, "dd           MM           yyyy");
    }
    public String getCategorieParticolari() {
        return categorieParticolari;
    }
    public String getEventiEccezionali() {
        return eventiEccezionali;
    }

    public String getCasiEsclusione() {
        return casiEsclusione;
    }

    public DomicilioFiscale getDfAttuale() {
        return dfAttuale;
    }

    public DomicilioFiscale getDfAnnoPrecedente() {
        return dfAnnoPrecedente!=null?dfAnnoPrecedente:new DomicilioFiscale();
    }

    public Individuo getRappresentante() {
        return rappresentante;
    }

    public FamiliariACarico getFamiliariACarico() {
        return familiariACarico;
    }

    public boolean hasFamiliariACarico(){return familiariACarico!=null?true:false;}

    public ResidenzaEstero getResidenzaEstero() {
        return residenzaEstero;
    }

    public void setResidenzaEstero(ResidenzaEstero residenzaEstero) {
        this.residenzaEstero = residenzaEstero;
    }

    public void setFamiliariACarico(FamiliariACarico familiariACarico) {
        this.familiariACarico = familiariACarico;
    }

    public void setRappresentante(Individuo rappresentante) {
        this.rappresentante = rappresentante;
    }

    public void setDfAnnoPrecedente(DomicilioFiscale dfAnnoPrecedente) {
        this.dfAnnoPrecedente = dfAnnoPrecedente;
    }

    public void setDfAttuale(DomicilioFiscale dfAttuale) {
        this.dfAttuale = dfAttuale;
    }

    public void setEventiEccezionali(String eventiEccezionali) {
        this.eventiEccezionali = eventiEccezionali;
    }
    public void setCategorieParticolari(String categorieParticolari) {
        this.categorieParticolari = categorieParticolari;
    }

    public void setCasiEsclusione(String casiEsclusione) {
        this.casiEsclusione = casiEsclusione;
    }


}
