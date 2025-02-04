package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.attori.Individuo;

import java.io.Serializable;

/**
 * User: V801068
 * Date: 04/02/16
 * Time: 11.13
 */
public class DestinatarioComunicazioneCC implements Serializable{
    private Individuo destinatario;
    private String    appellativo;

    public DestinatarioComunicazioneCC(CausaleCC causaleCC, Contratto contratto) {
        if(causaleCC.isDecesso()&&existAssicurato(contratto)){
            this.destinatario= contratto.getAssicurato();
            this.appellativo=contratto.getAssicurato().getTitolo();
        }else{
            this.destinatario= contratto.getContraente();
            this.appellativo= causaleCC.getAppellattivoCausale();
        }
    }

    public Individuo getDestinatario(){
        return destinatario;
    }

    public String getAppellativo(){
        return appellativo;
    }


    private boolean existAssicurato(Contratto contratto){
        if(null==contratto.getAssicurato())
            return false;
        if(contratto.getContraente().getCf().equals(contratto.getAssicurato().getCf()))
            return false;
        if(contratto.getAssicurato().hasIndirizzo()&&!contratto.getAssicurato().getIndirizzo().getVia().trim().equals(""))
            return true;
        return false;


    }
}
