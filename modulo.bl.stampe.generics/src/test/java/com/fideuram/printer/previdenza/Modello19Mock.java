package com.fideuram.printer.previdenza;

import com.fideuram.printer.previdenza.sharedMock.*;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * User: V801068
 * Date: 08/09/14
 * Time: 10.47
 */
public class Modello19Mock {
    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPolizza(ContrattoPrevidenzaMock.getContratto());
        o.setDocumentazione(DocumentazioneMock.getDocIntegrativa());
        return o;
    }
}
