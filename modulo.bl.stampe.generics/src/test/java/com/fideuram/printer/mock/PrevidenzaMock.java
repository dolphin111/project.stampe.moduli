package com.fideuram.printer.mock;

import com.fideuram.printer.previdenza.sharedMock.ConvenzioneMock;
import com.fideuram.printer.previdenza.sharedMock.LiquidazioneMock;
import com.fideuram.stampe.modello.previdenza.Previdenza;

import java.util.Date;

/**
 * Created by V801068 on 03/06/14.
 */
public class PrevidenzaMock {


    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPrimaIscrizione(new Date());
        o.setPrimaLiquidabilita(new Date());
     //   o.setConvenzione(ConvenzioneMock.getConvenzione());
      //  o.setLiquidazione(LiquidazioneMock.getLiquidazione());
        o.setPolizza(ContrattoMock.getContratto());
        return o;
    }


}
