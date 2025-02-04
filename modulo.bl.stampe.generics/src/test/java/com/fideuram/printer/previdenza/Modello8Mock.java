package com.fideuram.printer.previdenza;

import com.fideuram.printer.previdenza.sharedMock.*;
import com.fideuram.stampe.modello.previdenza.Previdenza;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 21/08/14
 * Time: 16.36
 * To change this template use File | Settings | File Templates.
 */
public class Modello8Mock {
    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPrimaIscrizione(new Date());
        o.setPrimaLiquidabilita(new Date());
        o.setPolizza(ContrattoPrevidenzaMock.getContratto());
        o.setRichiesta(ComunicazioneMock.getRichiesta());
        o.setLiquidazione(LiquidazioneMock.getLiquidazione());
        o.setConvenzione(ConvenzioneMock.getConvenzione());
        o.setRigetto(RigettoMock.getRigetto());
        return o;
    }
}
