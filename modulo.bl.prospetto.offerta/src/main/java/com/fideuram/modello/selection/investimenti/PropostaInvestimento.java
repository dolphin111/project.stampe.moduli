package com.fideuram.modello.selection.investimenti;

/**
 * User: V801068
 * Date: 26/01/16
 * Time: 17.29
 */
public class PropostaInvestimento extends SelezioneInvestimenti {
    @Override
    public String getProvenienza() {
        return "PROPOSTE DI INVESTIMENTO";
    }

    @Override
    public Boolean isPropostaInvestimento() {
        return true;
    }
}
