package com.fideuram.chart.lab;

/**
 * Created by
 * User: logan
 * Date: 06/02/13
 * Time: 11.38
 */
public class Categoria {
    private String categoria;

    public Categoria() {
    }

    /**
     * Costruttore specializzato
     * @param categoria
     */
    public Categoria(String categoria) {
        this.categoria = categoria;
    }



    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return  categoria ;
    }
}
