package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.printer.mock.ContraenteMock;
import com.fideuram.stampe.modello.contraenza.Contratto;

/**
 * User: V801068
 * Date: 19/08/14
 * Time: 17.49
 */
public class ContrattoPrevidenzaMock {
    public static Contratto getContratto(){
        Contratto contratto = new Contratto();
        contratto.setNumeroID("4327");
        contratto.setAderente(ContraenteMock.getAderente());
        contratto.setPb(ContraenteMock.getPb());
        return contratto;
    }
}
