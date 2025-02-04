package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.ContraenteMock;
import com.fideuram.printer.previdenza.sharedMock.*;
import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 19/08/14
 * Time: 15.50
 */
public class Modello10Mock {

    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPolizza(ContrattoPrevidenzaMock.getContratto());
        o.setRichiesta(ComunicazioneMock.getRichiesta());
        o.setLiquidazione(LiquidazioneMock.getLiquidazione());
        o.setConvenzione(ConvenzioneMock.getConvenzione());
        o.setDocumentazione(DocumentazioneMock.getDocIntegrativa());
        return o;
    }

}
