package com.fideuram.crm.stampe.model.vospolizza.prestazioni;

import com.fideuram.puc.service.impl.OpzioneRiscattoAlTermineVO;

/**
 * Created by
 * User: logan
 * Date: 23/12/11
 * Time: 10.50
 */
public class CapNnGarantito extends PrestazioneBase {
    private String tipoPrestazione = "CNG";
    private String descizionePrestazione = "PRODOTTO DI CAPITALE PRODOTTO NON GARANTITO";

    public CapNnGarantito() {
    }

    public CapNnGarantito(OpzioneRiscattoAlTermineVO opz) {
        setDataRiferimentoNav(opz.getDataRiferimentoNav());
        setNumeroQuote(opz.getNumeroQuote());
        setControvaloreQuote(opz.getControvaloreQuote());
        setIpotesiValRiscattoScadenza(opz.getIpotesivaloreRiscattoScadenza());
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
