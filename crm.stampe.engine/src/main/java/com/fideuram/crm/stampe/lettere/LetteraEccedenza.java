package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.model.Polizza;
/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraEccedenza {

    /**
     * @param target
     */
    public static void completaPolizza(Polizza target) {
        //------------ VALORE ECCEDENZA ----------------
        impostaRigaEccedenza(target);
    }

    /**
     * @param target
     */
    public static void impostaRigaEccedenza(Polizza target) {
        target.addAttributo("dataRiferimentoPrestazioniVita", target.getDataScadenza());
        target.addAttributo("importoPrestazioniVita", target.getEccedenza());
        target.addAttributo("descrizionePrestazioniVita", target.getTroncone("EccedenzaCapitaleDifferitosenzaContrass"));
        
        if (target.getLiquidazioni() != null 
        		&& !target.getLiquidazioni().isEmpty() 
        		&& target.getLiquidazioni().get(0).getData() != null) 
        {
            target.addAttributo("descrizionePrestazioniVita", 
            		target.getAttributo("descrizionePrestazioniVita")
                    + " " + target.getLiquidazioni().get(0).getData());
        }

    }

}
