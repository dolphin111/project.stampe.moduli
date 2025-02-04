package com.fideuram.modello.tbd;

import com.fideuram.costanti.Costanti;
import com.fideuram.modello.anagrafe.SoggettoDelegato;
import com.fideuram.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 28/06/12
 * Time: 9.27
 */
public class LineaInvestimento implements Serializable {
    private String              sigla;                       //LG01C
    private String              nome;                        //Linea Totale Core "Classe Bonus C"
    private Date                inizioOperativita;           //31/03/2012
    private Date                terminePrevistoOperativita;  //31/03/2050      Termine Previsto Operatività
    private Float               volatilitaExAnte;            //7%
    private SoggettoDelegato delegato;                    // Soggetto a cui è delegata la gestione


    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getInizioOperativita() {
        return inizioOperativita;
    }

    public void setInizioOperativita(Date inizioOperativita) {
        this.inizioOperativita = inizioOperativita;
    }

    public Date getTerminePrevistoOperativita() {
        return terminePrevistoOperativita;
    }

    public void setTerminePrevistoOperativita(Date terminePrevistoOperativita) {
        this.terminePrevistoOperativita = terminePrevistoOperativita;
    }

    public float getVolatilitaExAnte() {
        return volatilitaExAnte;
    }

    public void setVolatilitaExAnte(float volatilitaExAnte) {
        this.volatilitaExAnte = volatilitaExAnte;
    }

    public SoggettoDelegato getDelegato() {
        return delegato;
    }

    public void setDelegato(SoggettoDelegato delegato) {
        this.delegato = delegato;
    }

    public LineaInvestimento(String sigla, String nome, Date inizioOperativita, Date terminePrevistoOperativita, Float volatilitaExAnte, SoggettoDelegato delegato) {
        this.sigla = sigla;
        this.nome = nome;
        this.inizioOperativita = inizioOperativita;
        this.terminePrevistoOperativita = terminePrevistoOperativita;
        this.volatilitaExAnte = volatilitaExAnte;
        this.delegato = delegato;
    }

    public String getTerminePrevistoOperativitaString() {
        return DateUtils.formatDate(terminePrevistoOperativita, Costanti.FORMATO_DATA);
    }
    public String getInizioOperativitaString() {
        return DateUtils.formatDate(inizioOperativita, Costanti.FORMATO_DATA);
    }
}
