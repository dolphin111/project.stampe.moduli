package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.model.Polizza;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraPrestazioniAssicurate {

    /**
     * @param dest
     */
    public static void completaPolizza(Polizza dest) {

        //-----------  PRESTAZIONI ASSICURATE -------------------
        TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);

        //-----------  VINCOLO/PEGNO -------------------
        DescrizioniComuni.impostaVincoloPegno(dest);

    }
}
