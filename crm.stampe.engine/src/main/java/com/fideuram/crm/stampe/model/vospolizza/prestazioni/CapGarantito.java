package com.fideuram.crm.stampe.model.vospolizza.prestazioni;

import com.fideuram.costanti.Costanti;
import com.fideuram.puc.service.impl.OpzioneRiscattoAlTermineVO;
import com.fideuram.utils.NumberUtils;

/**
 * Created by
 * User: logan
 * Date: 23/12/11
 * Time: 10.49
 */
public class CapGarantito extends PrestazioneBase{
    private String tipoPrestazione                  ="CG";
    private String descizionePrestazione            ="PRODOTTO DI CAPITALE PRODOTTO GARANTITO";
    private String valoreRiscattoScadenzaGarantito  ="";

    public CapGarantito() { }

    public CapGarantito(OpzioneRiscattoAlTermineVO opz){
         setDataRiferimentoNav(opz.getDataRiferimentoNav());
         setValoreRiscattoScadenzaGarantito(opz.getValoreRiscattoScadenzaGarantito());
         setNumeroQuote(opz.getNumeroQuote());
         setControvaloreQuote(opz.getControvaloreQuote());
         setIpotesiValRiscattoScadenza(opz.getIpotesivaloreRiscattoScadenza());
         setCatenaccio("Prestazioni Calcolate sul minimo garantito ipotizzando il completamento del piano dei versamenti");
    }

    public String getValoreRiscattoScadenzaGarantito() {
        return valoreRiscattoScadenzaGarantito;
    }

     public void setValoreRiscattoScadenzaGarantito(Double valoreRiscattoScadenzaGarantito) {
        this.valoreRiscattoScadenzaGarantito = ((valoreRiscattoScadenzaGarantito!=null)? NumberUtils.formatCurrency(valoreRiscattoScadenzaGarantito, Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI):"");
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
