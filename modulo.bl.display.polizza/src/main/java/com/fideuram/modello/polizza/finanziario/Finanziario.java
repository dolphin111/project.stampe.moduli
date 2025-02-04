package com.fideuram.modello.polizza.finanziario;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 17.43
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Finanziario {
    private Double quoteTotali;
    private Double controvaloreTotale;
    private List<TipoRiallocazioneGuidata> tipoRiallocazioneGuidata;
    private String hasTipoRiallocazioneGuidata;
    private Date   dataRiferimentoNAV;
    @XmlElement(name = "listaAndamentoControvalori")
    private AndamentoControvalori andamentoControvalori;
    private DettagliComposizioneInvestimento dettagliComposizioneInvestimento;
    private ComposizionePortafoglio composizionePortafoglioPerAssetClass;
    private ComposizionePortafoglio composizionePortafoglioPerFondoOICR;
    private AndamentoRisultati andamentiRisultati;
    private String lineaInvestimento;
    private Boolean isETF;
    private Double ctvCommissioniNegoziazioni;



    public boolean isControvaloreUp0(){
         if(controvaloreTotale!=null && controvaloreTotale>0)
             return true;
         return false;
    }

    public Boolean isETF() {
        return isETF;
    }

    public String getCtvCommissioniNegoziazioni() {
        return FormatterFactory.getStandardImporto(ctvCommissioniNegoziazioni);
    }

    public String getQuoteTotali() {
        return FormatterFactory.getStandardImporto(quoteTotali);
    }

    public String getControvaloreTotale() {
        return FormatterFactory.getStandardImporto(controvaloreTotale);
    }

    public List<TipoRiallocazioneGuidata> getTipoRiallocazioneGuidata() {
        return tipoRiallocazioneGuidata!=null?tipoRiallocazioneGuidata:new ArrayList<TipoRiallocazioneGuidata>();
    }

    public String getHasTipoRiallocazioneGuidata() {
        if(tipoRiallocazioneGuidata!=null)
            return "SI";
        else
            return "NO";
    }

    public String getDataRiferimentoNAV() {
        if(dataRiferimentoNAV==null)
            return "";
        return FormatterFactory.getStandardDate(dataRiferimentoNAV);
    }

    public AndamentoControvalori getAndamentoControvalori() {
        return andamentoControvalori;
    }

    public DettagliComposizioneInvestimento getDettagliComposizioneInvestimento() {
        return dettagliComposizioneInvestimento;
    }

    public ComposizionePortafoglio getComposizionePortafoglioPerAssetClass() {
        return composizionePortafoglioPerAssetClass;
    }

    public ComposizionePortafoglio getComposizionePortafoglioPerFondoOICR() {
        return composizionePortafoglioPerFondoOICR;
    }

    public AndamentoRisultati getAndamentiRisultati() {
        return andamentiRisultati;
    }

    public String getLineaInvestimento() {
        return lineaInvestimento;
    }

    public boolean isLineaInvestimento(){
        if(null==lineaInvestimento)
            return false;
        return true;
    }

    //BOOLEAN   INTERROGATIONS
    public boolean isInvestimentoDettagliato(){
        if(null!=dettagliComposizioneInvestimento&&dettagliComposizioneInvestimento.getDettaglioComposizioneInvestimentoRamo3().size()>0){
            return true;
        }else
            return false;
    }
}
