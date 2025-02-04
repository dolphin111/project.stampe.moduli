package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.stampe.modello.contocorrente.FondoPensione;
import com.fideuram.stampe.modello.previdenza.Liquidazione;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 19/08/14
 * Time: 16.24
 * To change this template use File | Settings | File Templates.
 */
public class LiquidazioneMock {

    public static Liquidazione getLiquidazione(){
        Liquidazione liquidazione = new Liquidazione();
        liquidazione.setDataRichiesta(new Date());
        liquidazione.setTipoLiquidazione(Liquidazione.LIQUIDAZIONE_PARZIALE);
        return liquidazione;
    }
}
