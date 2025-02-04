package com.fideuram.crm.stampe.model.vospolizza.prestazioni;

import com.fideuram.costanti.Costanti;
import com.fideuram.puc.service.impl.OpzioneFrazionamentoVO;
import com.fideuram.puc.service.impl.OpzioneRiscattoAlTermineVO;
import com.fideuram.utils.NumberUtils;

/**
 * Created by
 * User: logan
 * Date: 23/12/11
 * Time: 10.50
 */
public class Rendita extends PrestazioneBase{
    private String tipoPrestazione                          ="R";
    private String descizionePrestazione                    ="PRODOTTO DI RENDITA";
    private String vitalizioAnnuoMinimoGarantito            ="";
    private String valoreRiscattoScadenzaGarantito          ="";
    private String ipotesiRenditaAnnuaPosticipataScadenza   ="";
    private String nota1="(*) il calcolo è stato eseguito senza tenere conto di eventuale preavviso previsto dalle Condizioni di polizza.";

    public Rendita() { }

    public Rendita(OpzioneRiscattoAlTermineVO opz, OpzioneFrazionamentoVO frz){
         setDataRiferimentoNav(opz.getDataRiferimentoNav());
         setVitalizioAnnuoMinimoGarantito(opz.getRenditaAnnuaVitaliziaMinimaGrarantita());
         setValoreRiscattoScadenzaGarantito(opz.getValoreRiscattoScadenzaGarantito());
         setNumeroQuote(opz.getNumeroQuote());
         setControvaloreQuote(opz.getControvaloreQuote());
         setIpotesiRenditaAnnuaPosticipataScadenza(frz.getAnnualePosticipata());
         setIpotesiValRiscattoScadenza(opz.getIpotesivaloreRiscattoScadenza());
         setCatenaccio("Prestazioni Calcolate sul minimo garantito ipotizzando il completamento del piano dei versamenti");
    }

    public void setVitalizioAnnuoMinimoGarantito(Double vitalizioAnnuoMinimoGarantito) {
        this.vitalizioAnnuoMinimoGarantito = ((vitalizioAnnuoMinimoGarantito!=null)? NumberUtils.formatCurrency(vitalizioAnnuoMinimoGarantito,Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI):"");
    }
    public void setValoreRiscattoScadenzaGarantito(Double valoreRiscattoScadenzaGarantito) {
        this.valoreRiscattoScadenzaGarantito = ((valoreRiscattoScadenzaGarantito!=null)? NumberUtils.formatCurrency(valoreRiscattoScadenzaGarantito, Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI):"");
    }
    public void setIpotesiRenditaAnnuaPosticipataScadenza(Double ipotesiRenditaAnnuaPosticipataScadenza) {
        this.ipotesiRenditaAnnuaPosticipataScadenza =((ipotesiRenditaAnnuaPosticipataScadenza!=null)? NumberUtils.formatCurrency(ipotesiRenditaAnnuaPosticipataScadenza,Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI):"-");
    }


    public String getVitalizioAnnuoMinimoGarantito() {
        return vitalizioAnnuoMinimoGarantito;
    }

    public String getValoreRiscattoScadenzaGarantito() {
        return valoreRiscattoScadenzaGarantito;
    }

    public String getIpotesiRenditaAnnuaPosticipataScadenza() {
        return ipotesiRenditaAnnuaPosticipataScadenza;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    @Override
    public String getTipoPrestazione() {
        return tipoPrestazione;
    }

    @Override
    public String getDescrizionePrestazione() {
        return descizionePrestazione;
    }

}
