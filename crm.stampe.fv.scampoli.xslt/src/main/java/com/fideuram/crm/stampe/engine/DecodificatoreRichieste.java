package com.fideuram.crm.stampe.engine;

/**
 * Created by
 * User: logan
 * Date: 27/07/11
 * Time: 15.28
 */
@Deprecated
public  class DecodificatoreRichieste {

    /**
     * Questo metodo serve a decodifcare la richiesta in entrata. Attualmente (27Agosto2011) <br>
     * esistono più codici (alias tripletta) per identificare la stessa richiesta. Es:       <br>
     * 4604 e 7138 attivano la rischiesta  RIDUZIONE_4604_E21.                               <br>
     *
     * @param richiesta
     * @return int
     */
     public static  int decodificaRichiesta(int richiesta) {
        if((richiesta==4604) || (richiesta==7138))
             return   4604;
        if((richiesta==4538) || (richiesta==7072))
             return   4538;
        if((richiesta==4555) || (richiesta==7093))
             return   4555;
        return richiesta;
     }
}
