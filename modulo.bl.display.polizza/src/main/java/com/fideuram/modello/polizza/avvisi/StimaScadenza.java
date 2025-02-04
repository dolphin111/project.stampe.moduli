package com.fideuram.modello.polizza.avvisi;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 10/09/13
 * Time: 10.12
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class StimaScadenza {
    private Integer ramoMinisteriale;
    private Double  renditaAnnuavitaliziaMinimaGarantita;
    private Double  valoreRiscattoScadenzaGarantito;
    private Double  ipotesiRenditaAnnuaPosticipataScadenzaCVT;
    private Double  ipotesiValoreriScattoScadenzaCVT;
    private Double  totalerenditaFrazionataAnnualePosticipata;
    private Double  totalerenditaFrazionataSemestralePosticipata;
    private Double  totalerenditaFrazionataTrimestralePosticipata;
    private Double  totalerenditaFrazionataMensilePosticipata;
    private Double  totaleRenditaCerta1AnnualePosticipata;
    private Double  totaleRenditaCerta1SemestralePosticipata;
    private Double  totaleRenditaCerta1TrimestralePosticipata;
    private Double  totaleRenditaCerta1MensilePosticipata;
    private Double  totaleRenditaCerta2AnnualePosticipata;
    private Double  totaleRenditaCerta2Semestraleposticipata;
    private Double  totaleRenditaCerta2TrimestralePosticipata;
    private Double  totaleRenditaCerta2MensilePosticipata;
    private Double  totaleRenditaCerta3AnnualePosticipata;
    private Double  totaleRenditaCerta3SemestralePosticipata;
    private Double  totaleRenditaCerta3TrimestralePosticipata;
    private Double  totaleRenditaCerta3MensilePosticipata;
    private Double  totaleRenditaCerta4AnnualePosticipata;
    private Double  totaleRenditaCerta4SemestralePosticipata;
    private Double  totaleRenditaCerta4TrimestralePosticipata;
    private Double  totaleRenditaCerta4MensilePosticipata;
    private Double  totaleRenditaReversibile;
    private Double  percentualeReversibilita;
    private Double  nav;
    @XmlElement(name = "ControValoreQuote")
    private Double  controValoreQuote;
    private Double  numeroQuote;
    private Date    timestamp;
    private Date    dataScadenza;
    private Date    dataCalcolo;
    private Double  importoNettoRiscattoTermine=0.0;
    private Boolean isACLSLungaSopravvivenza;
    private Double  renditaVitaliziaAnnuaPosticipata;
    @XmlElement(name = "dataRiferimentoNav")
    private Date    dataRiferimentoNAV;

    private Integer anniCertezza1=0;
    private Integer anniCertezza2=0;


    public Integer getAnniCertezza2() {
        return anniCertezza2;
    }

    public String getDataRiferimentoNAV() {
        return FormatterFactory.getStandardDate(dataRiferimentoNAV);
    }

    public Integer getRamoMinisteriale() {
        return ramoMinisteriale;
    }

    public String getRenditaAnnuavitaliziaMinimaGarantita() {
        return FormatterFactory.getStandardImporto(renditaAnnuavitaliziaMinimaGarantita);
    }

    public String getValoreRiscattoScadenzaGarantito() {
        return FormatterFactory.getStandardImporto(valoreRiscattoScadenzaGarantito);
    }

    public String getIpotesiRenditaAnnuaPosticipataScadenzaCVT() {
        return FormatterFactory.getStandardImporto(ipotesiRenditaAnnuaPosticipataScadenzaCVT);
    }

    public String getIpotesiValoreriScattoScadenzaCVT() {
        return FormatterFactory.getStandardImporto(ipotesiValoreriScattoScadenzaCVT);
    }

    public String getTotalerenditaFrazionataAnnualePosticipata() {
        return FormatterFactory.getStandardImporto(totalerenditaFrazionataAnnualePosticipata);
    }

    public String getTotalerenditaFrazionataSemestralePosticipata() {
        return FormatterFactory.getStandardImporto(totalerenditaFrazionataSemestralePosticipata);
    }

    public String getTotalerenditaFrazionataTrimestralePosticipata() {
        return FormatterFactory.getStandardImporto(totalerenditaFrazionataTrimestralePosticipata);
    }

    public String getTotalerenditaFrazionataMensilePosticipata() {
        return FormatterFactory.getStandardImporto(totalerenditaFrazionataMensilePosticipata);
    }

    public String getTotaleRenditaCerta1AnnualePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta1AnnualePosticipata);
    }

    public String getTotaleRenditaCerta1SemestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta1SemestralePosticipata);
    }

    public String getTotaleRenditaCerta1TrimestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta1TrimestralePosticipata);
    }

    public String getTotaleRenditaCerta1MensilePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta1MensilePosticipata);
    }

    public String getTotaleRenditaCerta2AnnualePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta2AnnualePosticipata);
    }

    public String getTotaleRenditaCerta2Semestraleposticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta2Semestraleposticipata);
    }

    public String getTotaleRenditaCerta2TrimestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta2TrimestralePosticipata);
    }

    public String getTotaleRenditaCerta2MensilePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta2MensilePosticipata);
    }

    public String getTotaleRenditaCerta3AnnualePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta3AnnualePosticipata);
    }

    public String getTotaleRenditaCerta3SemestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta3SemestralePosticipata);
    }

    public String getTotaleRenditaCerta3TrimestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta3TrimestralePosticipata);
    }

    public String getTotaleRenditaCerta3MensilePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta3MensilePosticipata);
    }

    public String getTotaleRenditaCerta4AnnualePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta4AnnualePosticipata);
    }

    public String getTotaleRenditaCerta4SemestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta4SemestralePosticipata);
    }

    public String getTotaleRenditaCerta4TrimestralePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta4TrimestralePosticipata);
    }

    public String getTotaleRenditaCerta4MensilePosticipata() {
        return FormatterFactory.getStandardImporto(totaleRenditaCerta4MensilePosticipata);
    }

    public String getTotaleRenditaReversibile() {
        return FormatterFactory.getStandardImporto(totaleRenditaReversibile);
    }

    public Double getPercentualeReversibilita() {
        return percentualeReversibilita;
    }

    public String getNav() {
        return FormatterFactory.getStandardImporto(nav);
    }

    public String getControValoreQuote() {
        return FormatterFactory.getStandardImporto(controValoreQuote);
    }

    public String getNumeroQuote() {
        return FormatterFactory.getStandardQuote(numeroQuote);
    }

    public String getTimestamp() {
        return FormatterFactory.getStandardDate(timestamp);
    }

    public String getDataScadenza() {
        return FormatterFactory.getStandardDate(dataScadenza);
    }

    public String getDataCalcolo() {
        return FormatterFactory.getStandardDate(dataCalcolo);
    }

    public boolean hasImportoNettoRiscattoTermine(){
        if(importoNettoRiscattoTermine>0)
            return true;
        else
            return false;
    }
    public Double getImportoNettoRiscattoTermine() {
        return importoNettoRiscattoTermine;
    }

    public Boolean isACLSLungaSopravvivenza() {
        return isACLSLungaSopravvivenza;
    }

    public String getRenditaVitaliziaAnnuaPosticipata() {
        return FormatterFactory.getStandardImporto(renditaVitaliziaAnnuaPosticipata);
    }


    public boolean isCertezza1() {
        if(anniCertezza1>0)
            return true;
        else
            return false;
    }

    public Integer getAnniCertezza1() {
        return anniCertezza1;
    }
}
