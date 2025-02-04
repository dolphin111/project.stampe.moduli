package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.contraenza.CausaleCC;
import com.fideuram.stampe.modello.contraenza.Contratto;

import java.io.Serializable;

/**
 * User: V801068
 * Date: 04/02/16
 * Time: 11.13
 */
public class DestinatarioComunicazioneVB implements Serializable{
    private Individuo destinatario;
    private String    appellativo;

    public DestinatarioComunicazioneVB(CausaleVB causaleVB, Contratto contratto) {
        //if(causaleVB.isDecesso()&&existAssicurato(contratto)){
            //this.destinatario= contratto.getAssicurato();
            //this.appellativo=contratto.getAssicurato().getTitolo();
        //}else{
            this.destinatario= contratto.getContraente();
            this.appellativo= causaleVB.getAppellattivoCausale();
       // }
    }

    public Individuo getDestinatario(){
        return destinatario;
    }

    public String getAppellativo(){
        return appellativo;
    }

/*
    private boolean existAssicurato(Contratto contratto){
        if(null==contratto.getAssicurato())
            return false;
        if(contratto.getContraente().getCf().equals(contratto.getAssicurato().getCf()))
            return false;
        if(contratto.getAssicurato().hasIndirizzo()&&!contratto.getAssicurato().getIndirizzo().getVia().trim().equals(""))
            return true;
        return false;


    }*/
}
