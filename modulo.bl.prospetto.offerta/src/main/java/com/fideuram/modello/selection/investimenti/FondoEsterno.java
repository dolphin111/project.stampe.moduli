package com.fideuram.modello.selection.investimenti;

/**
 * User: V801068
 * Date: 26/01/16
 * Time: 17.30
 */
public class FondoEsterno extends SelezioneInvestimenti {

    @Override
    public String getProvenienza() {
        return "FONDI ESTERNI";
    }

    @Override
    public Boolean isFondoEsterno() {
        return true;
    }
}
