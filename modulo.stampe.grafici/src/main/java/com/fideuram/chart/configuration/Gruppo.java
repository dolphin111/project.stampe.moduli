package com.fideuram.chart.configuration;

import com.fideuram.chart.configuration.Colore;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 12.28
 */
public class Gruppo {
    private String nome="";
    private Colore colore;

    public Gruppo(String nome) {
        this.nome = nome;
    }

    public Gruppo(String nome, Colore colore) {
        this.nome = nome;
        this.colore = colore;
    }

    public String getNome() {
        return nome;
    }

    public Colore getColore() {
        return colore;
    }

}
