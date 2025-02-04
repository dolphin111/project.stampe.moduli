package com.fideuram.modello.polizza.finanziario;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.polizza.finanziario.rendimentoFondi.DettaglioComposizioneRendimentoFondo;
import com.fideuram.modello.polizza.finanziario.rendimentoFondi.DettaglioRendimentoFondoRamo3;
import com.fideuram.modello.polizza.finanziario.rendimentoFondi.StatisticheRendimentoFondi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 10.26
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AndamentoRisultati {
   private Double   percentualeRendimentoDaInizioGestione ;
   private Double   percentualeRendimentoDaInizioAnno     ;
   private Double   percentualeRendimentoDaInizioTrimestre;
   private Double   percentualeRendimentoDaInizioMese     ;
   private Double   percentualeRendimentoDaSemestre       ;
   private Date     dataCalcoloBF                         ;
   private String   annoRiferimento                       ;
   private Double   premioInizialeVersato                 ;
   private Double   premiVersatiInAnnoRiferimento         ;
   private Double   premioInizialeVersatoDaInizioGestione ;
   private Double   premiVersatiDaInizioGestione          ;
   private Double   importiRiscattatiInAnnoRiferimento    ;
   private Double   importiRiscattatiDaInizioGestione     ;
   private Double   cedoleErogateInAnnoRiferimento        ;
   private Double   cedoleErogateDaInizioGestione         ;
   private Double   controvaloreTotale                    ;
   private Date     dataRiferimentoNav                    ;
   private Double   risultatoAnnuoInAnnoRiferimento       ;
   private Double   risultatoAnnuoDaInizioGestione        ;
   private Double   capitaleCasoMorte                     ;
   private Double   quoteTotale                           ;
   private List<AndamentoTir> andamentoTir                ;
   private Double   controvaloreTotaleAnnoPrecedente      ;
   private Date     dataControvaloreTotaleAnnoPrecedente  ;
   private Boolean  isTirAnomalo                          ;
   private Date     dataRiferimentoConsolidato            ;
   private StatisticheRendimentoFondi statisticheRendimentoAndamentoFondi;
   private DettaglioComposizioneRendimentoFondo dettaglioComposizioneRendimentoFondo;

    public String getPercentualeRendimentoDaInizioGestione() {
        return FormatterFactory.getStandardImporto(percentualeRendimentoDaInizioGestione);
    }

    public String getPercentualeRendimentoDaInizioAnno() {
        return FormatterFactory.getStandardImporto(percentualeRendimentoDaInizioAnno);
    }

    public String getPercentualeRendimentoDaInizioTrimestre() {
        return FormatterFactory.getStandardImporto(percentualeRendimentoDaInizioTrimestre);
    }

    public Double getPercentualeRendimentoDaInizioMese() {
        return percentualeRendimentoDaInizioMese;
    }

    public Double getPercentualeRendimentoDaSemestre() {
        return percentualeRendimentoDaSemestre;
    }

    public String  getDataCalcoloBF() {
        return FormatterFactory.getStandardDate(dataCalcoloBF);
    }

    public String getAnnoRiferimento() {
        return annoRiferimento;
    }

    public String getPremioInizialeVersato() {
        return FormatterFactory.getStandardImporto(premioInizialeVersato);
    }

    public String getPremiVersatiInAnnoRiferimento() {
        return FormatterFactory.getStandardImporto(premiVersatiInAnnoRiferimento);
    }

    public String getPremioInizialeVersatoDaInizioGestione() {
        return FormatterFactory.getStandardImporto(premioInizialeVersatoDaInizioGestione);
    }

    public String getPremiVersatiDaInizioGestione() {
        return FormatterFactory.getStandardImporto(premiVersatiDaInizioGestione);
    }

    public String getImportiRiscattatiInAnnoRiferimento() {
        return FormatterFactory.getStandardImporto(importiRiscattatiInAnnoRiferimento);
    }

    public String getImportiRiscattatiDaInizioGestione() {
        return FormatterFactory.getStandardImporto(importiRiscattatiDaInizioGestione);
    }

    public String getCedoleErogateInAnnoRiferimento() {
        return FormatterFactory.getStandardImporto(cedoleErogateInAnnoRiferimento);
    }

    public String getCedoleErogateDaInizioGestione() {
        return FormatterFactory.getStandardImporto(cedoleErogateDaInizioGestione);
    }

    public Double getControvaloreTotale() {
        return controvaloreTotale;
    }

    public Date getDataRiferimentoNav() {
        return dataRiferimentoNav;
    }

    public String getRisultatoAnnuoInAnnoRiferimento() {
        return FormatterFactory.getStandardImporto(risultatoAnnuoInAnnoRiferimento);
    }

    public String getRisultatoAnnuoDaInizioGestione() {
        return FormatterFactory.getStandardImporto(risultatoAnnuoDaInizioGestione);
    }

    public Double getCapitaleCasoMorte() {
        return capitaleCasoMorte;
    }

    public Double getQuoteTotale() {
        return quoteTotale;
    }

    public List<AndamentoTir> getAndamentoTir() {
        return andamentoTir;
    }

    public Double getControvaloreTotaleAnnoPrecedente() {
        return controvaloreTotaleAnnoPrecedente;
    }

    public Date getDataControvaloreTotaleAnnoPrecedente() {
        return dataControvaloreTotaleAnnoPrecedente;
    }

    public Boolean getTirAnomalo() {
        return isTirAnomalo;
    }

    public Date getDataRiferimentoConsolidato() {
        return dataRiferimentoConsolidato;
    }

    public StatisticheRendimentoFondi getStatisticheRendimentoAndamentoFondi() {
        return statisticheRendimentoAndamentoFondi;
    }

    public DettaglioComposizioneRendimentoFondo getDettaglioComposizioneRendimentoFondo() {
        return dettaglioComposizioneRendimentoFondo;
    }

    @Deprecated
    public boolean isAndamentoPrevidenza() {
        if(premioInizialeVersato==0)
            return false;
        else
            return true;
    }

    public boolean hasStatistiche(){
        if(statisticheRendimentoAndamentoFondi!=null&&statisticheRendimentoAndamentoFondi.getStatistiche().size()>0)
            return true;
        return false;
    }

    public boolean hasComposizioneRendimentoFondo(){
       if(dettaglioComposizioneRendimentoFondo!=null&&dettaglioComposizioneRendimentoFondo.getDettaglioComposizioneInvestimentoRamo3().size()>0)
           return true;
        return false;
    }

    public List<DettaglioRendimentoFondoRamo3>  getComposizioneRendimentoFondo(){
        return dettaglioComposizioneRendimentoFondo.getDettaglioComposizioneInvestimentoRamo3();
    }
}
