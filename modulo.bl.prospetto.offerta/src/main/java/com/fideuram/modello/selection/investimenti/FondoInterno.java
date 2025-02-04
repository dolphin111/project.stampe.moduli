package com.fideuram.modello.selection.investimenti;

/**
 * User: V801068
 * Date: 26/01/16
 * Time: 17.29
 */
public class FondoInterno extends SelezioneInvestimenti {

    @Override
    public String getProvenienza() {
        return "FONDI INTERNI";
    }

    @Override
    public Boolean isFondoInterno() {
        return true;
    }
}
