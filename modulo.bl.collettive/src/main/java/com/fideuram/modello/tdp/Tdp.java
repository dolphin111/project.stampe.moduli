package com.fideuram.modello.tdp;

import java.util.Date;

import com.fideuram.factory.FormatterFactory;

/**
 * TitoloDiPerfezionamento
 * Created by
 * User: logan
 * Date: 10/05/13
 * Time: 11.57
 */
public class Tdp {
    private String collettiva;
    private String elenco;
    private Date dataDecorrenza;


    public String getCollettiva() {
        return collettiva;
    }

    public void setCollettiva(String collettiva) {
        this.collettiva = collettiva;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDataDecorrenza() {
        return FormatterFactory.getStandardDate(dataDecorrenza);
    }

    public void setDataDecorrenza(Date dataDecorrenza) {
        this.dataDecorrenza = dataDecorrenza;
    }
}
