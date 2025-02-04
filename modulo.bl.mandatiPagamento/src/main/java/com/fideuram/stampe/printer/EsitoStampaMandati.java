package com.fideuram.stampe.printer;

import java.util.ArrayList;

public class EsitoStampaMandati
{
    private ArrayList<String> listaMandatiPagamento = new ArrayList<String>();
    private ArrayList<String> listaErrori = new ArrayList<String>();
    private ArrayList<String> listaMandatiPagamentoGenerati = new ArrayList<String>();


    public ArrayList<String> getListaMandatiPagamento() {
        return listaMandatiPagamento;
    }

    public void setListaMandatiPagamento(ArrayList<String> listaMandatiPagamento) {
        this.listaMandatiPagamento = listaMandatiPagamento;
    }

    public ArrayList<String> getListaErrori() {
        return listaErrori;
    }

    public void setListaErrori(ArrayList<String> listaErrori) {
        this.listaErrori = listaErrori;
    }

    public ArrayList<String> getListaMandatiPagamentoGenerati() {
        return listaMandatiPagamentoGenerati;
    }

    public void setListaMandatiPagamentoGenerati(ArrayList<String> listaMandatiPagamentoGenerati) {
        this.listaMandatiPagamentoGenerati = listaMandatiPagamentoGenerati;
    }
}
