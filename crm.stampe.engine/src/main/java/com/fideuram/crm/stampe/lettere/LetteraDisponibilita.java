package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.CrmStampeException;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraDisponibilita {

    /**
     * @param dest
     * 
     * @throws CrmStampeException
     */
    public static void completaPolizza(Polizza dest) throws StampeInfoException {

        //------------ CASO VITA --------
        TabellaValoreRiscattoAnticipato.impostaRigaPrestazioniVita(dest);

        if (("FAP".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())) &&
                ("R".equalsIgnoreCase(dest.getTipoPrestazione()))) {
            dest.addAttributo(
            		"descrizionePrestazioniVita", 
            		dest.getTroncone("PrestVitaRenditaRivalutabile"));
        }

        //------------ CASO MORTE --------
        TabellaValoreRiscattoAnticipato.impostaRigaPrestazioniMorte(dest);

        //------------ VALORE CONVERSIONE IN RENDITA ----------------
        impostaRigaValoreDisponibilita(dest);

   }


    /**
     * @param dest
     */
    private static void impostaRigaValoreDisponibilita(Polizza dest) {

        dest.addAttributo("descrizioneDisponibilita", "");

        dest.addAttributo("dataRiferimentoDisponibilita", dest.getAttributo("dataValutazione"));
        dest.addAttributo("importoDisponibilita", dest.getRiservaMatematica());

        // Importo BONUS
        if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
            dest.addAttributo("descrizioneDisponibilita", dest.getTroncone("DescrDisponibilitaBonus"));
            
        } else {
            dest.addAttributo("descrizioneDisponibilita", dest.getTroncone("DescrDisponibilita"));
        }

        
        // Liquidazioni
        if (dest.getLiquidazioni() != null 
        		&& !dest.getLiquidazioni().isEmpty() 
        		&& dest.getLiquidazioni().get(0).getImportoPrestito() != null) {
            dest.addAttributo(
            		"descrizioneDisponibilita", 
            		dest.getAttributo("descrizioneDisponibilita")
                    + dest.getTroncone("DescrRestituzionePrestito"));
        }

        DescrizioniComuni.impostaDescrizioneInteressiRitardatoPagamento(dest);
       
        TabellaValoreRiscattoAnticipato.impostaDescrizioneQualora(dest);
    }

}

