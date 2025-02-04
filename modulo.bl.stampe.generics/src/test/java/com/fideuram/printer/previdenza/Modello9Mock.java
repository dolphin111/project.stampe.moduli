package com.fideuram.printer.previdenza;

import com.fideuram.printer.previdenza.sharedMock.*;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 21/08/14
 * Time: 16.23
 */
public class Modello9Mock {
    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPolizza(ContrattoPrevidenzaMock.getContratto());
        o.setRichiesta(ComunicazioneMock.getRichiesta());
        o.setLiquidazione(LiquidazioneMock.getLiquidazione());
        o.setConvenzione(ConvenzioneMock.getConvenzione());
        o.setRigetto(RigettoMock.getRigetto());
        return o;
    }
}
