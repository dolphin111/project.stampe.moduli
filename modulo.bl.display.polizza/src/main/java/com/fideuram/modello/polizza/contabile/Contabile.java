package com.fideuram.modello.polizza.contabile;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 10.34
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Contabile {
    private Double totalePremiAnnuiIncassati ;
    private Double totalePremiAggiuntiviOggi ;
    private Double sommaPremiResiduiDaVersare;
    @XmlElement(name = "PremiIncassati")
    private PremiIncassati premiIncassati;
    private Date   dataFinePagamentoPremi;
    private TotaleIncassi totaleIncassi;
    private Double totalePremiDaTrasformazioni;
    private Double totalePremiAnnuiIncassatiConTrasformate;

    public Boolean hasPremiDaTrasformazione(){
        if(totalePremiAnnuiIncassatiConTrasformate==null||totalePremiAnnuiIncassatiConTrasformate==0)
            return false;
        return true;
    }

    public String getSommaPremiConTrasformazione(){
            double p= totalePremiAnnuiIncassatiConTrasformate!=null?totalePremiAnnuiIncassatiConTrasformate:0+totalePremiAnnuiIncassati;
            return FormatterFactory.getStandardImporto(p);
    }

    public String getTotalePremiAnnuiIncassati() {
        return FormatterFactory.getStandardImporto(totalePremiAnnuiIncassati);
    }

    public String getTotalePremiAggiuntiviOggi() {
        return FormatterFactory.getStandardImporto(totalePremiAggiuntiviOggi);
    }

    public String getSommaPremiResiduiDaVersare() {
        return FormatterFactory.getStandardImporto(sommaPremiResiduiDaVersare);
    }

    public PremiIncassati getPremiIncassati() {
        return premiIncassati;
    }

    public Date getDataFinePagamentoPremi() {
        return dataFinePagamentoPremi;
    }

    public TotaleIncassi getTotaleIncassi() {
        return totaleIncassi;
    }

    public String getTotalePremiDaTrasformazioni() {
        return FormatterFactory.getStandardImporto(totalePremiDaTrasformazioni);
    }

    public String getTotalePremiAnnuiIncassatiConTrasformate() {
        return FormatterFactory.getStandardImporto(totalePremiAnnuiIncassatiConTrasformate);
    }

}
