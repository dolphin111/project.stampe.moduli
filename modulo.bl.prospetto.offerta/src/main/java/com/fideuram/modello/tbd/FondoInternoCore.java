package com.fideuram.modello.tbd;


import com.fideuram.modello.anagrafe.SoggettoDelegato;

import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 28/06/12
 * Time: 10.32
 */
public class FondoInternoCore extends LineaInvestimento {
    public FondoInternoCore(String sigla, String nome, Date inizioOperativita, Date terminePrevistoOperativita, Float volatilitaExAnte, SoggettoDelegato delegato) {
        super(sigla, nome, inizioOperativita, terminePrevistoOperativita, volatilitaExAnte, delegato);
    }
}
