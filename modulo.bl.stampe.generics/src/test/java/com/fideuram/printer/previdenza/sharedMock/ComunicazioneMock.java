package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;

import java.util.Date;

/**
 * User: V801068
 * Date: 23/07/14
 * Time: 11.24
 */
public class ComunicazioneMock {
    public static Comunicazione getRichiesta(){
        Comunicazione c= new Comunicazione();
        c.setData(new Date());
        return c;
    }
}
