package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.ContraenteMock;
import com.fideuram.printer.previdenza.sharedMock.FondoPensioneMock;
import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.previdenza.Documentazione;
import com.fideuram.stampe.modello.previdenza.Previdenza;


/**
 * User: V801068
 * Date: 23/07/14
 * Time: 9.48
 */
public class Modello16Mock {

    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPolizza(getContratto());
        Documentazione d = new Documentazione();
        d.setSollecito(false);
        o.setDocumentazione(d);
        return o;
    }

    private static Contratto getContratto(){
        Contratto contratto = new Contratto();
        contratto.setAderente(ContraenteMock.getAderente());
        contratto.setCompagniaDiProvenienza(ContraenteMock.getCompagniaProvenienza());
        contratto.setFondoPensione(FondoPensioneMock.getFondo());
        return contratto;
    }


}
