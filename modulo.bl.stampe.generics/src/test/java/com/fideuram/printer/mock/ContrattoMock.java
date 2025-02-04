package com.fideuram.printer.mock;

import com.fideuram.stampe.modello.attori.Compagnia;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.contocorrente.FondoPensione;
import com.fideuram.stampe.modello.contraenza.Contratto;

import java.util.Date;

/**
 * Created by V801068 on 03/06/14.
 */
public class ContrattoMock {
    public static Contratto getContratto(){
        Contratto contratto = new Contratto();
        contratto.setNumeroID("12434534");
        contratto.setContraente(ContraenteMock.getContraente());
        contratto.setAssicurato(ContraenteMock.getAssicurato());
        contratto.setAderente(ContraenteMock.getAderente());
        //contratto.setPb(ContraenteMock.getPb());
        contratto.setCompagniaDiProvenienza(ContraenteMock.getCompagniaProvenienza());
        contratto.setFondoPensione(getFondo());
        return contratto;
    }



    private static FondoPensione getFondo(){
        FondoPensione fondo = new FondoPensione();
        fondo.setDataCostituzione(new Date());
        fondo.setDenominazione("RamnLah");
        fondo.setIscrizioneAlbo("7");
        fondo.setGestioneAmmVa("");
        fondo.setCfPiva("");
        fondo.setIBAN("");
        return fondo;
    }

}
