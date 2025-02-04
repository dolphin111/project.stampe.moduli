package com.fideuram.modello.polizza.finanziario;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 05/07/13
 * Time: 17.24
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DettaglioComposizioneInvestimentoRamo3")
public class DettaglioComposizioneInvestimentoRamo3 {
    private String polizzaRiferimento ;
    private String codiceFondo        ;
    private String denominazioneFondoInvestimento;
    private Double valoreNAV          ;
    private Date   dataNav            ;
    private Double numeroQuote        ;
    private Double controvaloreQuote  ;
    private String isin               ;
    private String idRepository       ;
    private Double pesoFondo          ;
    private Boolean isETF             ;
    private String tipoFondo=""       ;
    private String codiceLineaBF=""   ;

    public String getCodiceLineaBF() {
        return codiceLineaBF!=null?codiceLineaBF:"";
    }

    public String getPolizzaRiferimento() {
        return polizzaRiferimento;
    }

    public String getCodiceFondo() {
        return codiceFondo;
    }

    public String getDenominazioneFondoInvestimento() {
        return denominazioneFondoInvestimento;
    }

    public String getValoreNAV() {
        return FormatterFactory.getStandardQuote(valoreNAV);
    }

    public String getDataNav() {
        return FormatterFactory.getStandardDate(dataNav);
    }

    public Double getNumeroQuote() {
        return numeroQuote;
    }

    public String getControvaloreQuote() {
        return FormatterFactory.getStandardImporto(controvaloreQuote);
    }

    public String getIsin() {
        if(null==isin)
            return "";
        return isin;
    }

    public String getIdRepository() {
        return idRepository;
    }

    public String getPesoFondo() {
        return FormatterFactory.getStandardPercentuale(pesoFondo);
    }

    public String getTipoFondo() {
        if(isETF)
            tipoFondo="(ETF)";
        return tipoFondo;
    }
}
