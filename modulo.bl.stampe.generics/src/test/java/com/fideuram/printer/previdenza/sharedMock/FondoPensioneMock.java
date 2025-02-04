package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.stampe.modello.contocorrente.FondoPensione;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 23/07/14
 * Time: 9.53
 * To change this template use File | Settings | File Templates.
 */
public class FondoPensioneMock {
    public static FondoPensione getFondo(){
        FondoPensione fondo = new FondoPensione();
        fondo.setDataCostituzione(new Date());
        fondo.setDenominazione("Fondo Pensione Fideuram");
        fondo.setTipologia("fondo di tipo finanziario");
        fondo.setIscrizioneAlbo("7");
        fondo.setGestioneAmmVa("");
        fondo.setCfPiva("");
        fondo.setIBAN("");
        return fondo;
    }

    public static FondoPensione getFondoBreve(){
        FondoPensione fondo = new FondoPensione();
        fondo.setDenominazione("Fondo Pensione Fideuram");
        return fondo;
    }
}
