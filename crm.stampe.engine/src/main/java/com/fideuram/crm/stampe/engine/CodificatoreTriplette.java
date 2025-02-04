package com.fideuram.crm.stampe.engine;

import com.fideuram.costanti.Costanti;

/**
 * Created with
 * User: v801068
 * Date: 03/12/13
 * Time: 9.41
 */
public class CodificatoreTriplette {
    public static int getCodiceTemplate(String tripletta){
        if(Costanti.COMMISSIONI_FONDI_ESTERNI.equalsIgnoreCase(tripletta))
           return 304;
        else if(Costanti.VALORE_PRESTITO.equalsIgnoreCase(tripletta))
           return 305;
        else
           return 0;
    }
}
