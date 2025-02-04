package com.fideuram.printer.previdenza;

import com.fideuram.printer.previdenza.sharedMock.*;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 20/08/14
 * Time: 18.07
 */
public class Modello4_5_6_7Mock {
    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPolizza(ContrattoPrevidenzaMock.getContratto());
        o.setRichiesta(ComunicazioneMock.getRichiesta());
        o.setLiquidazione(LiquidazioneMock.getLiquidazione());
        o.setConvenzione(ConvenzioneMock.getConvenzione());
        o.setDocumentazione(DocumentazioneMock.getDocIntegrativaAderente());
        return o;
    }
}
