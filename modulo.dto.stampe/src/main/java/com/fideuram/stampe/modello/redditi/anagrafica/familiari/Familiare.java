package com.fideuram.stampe.modello.redditi.anagrafica.familiari;

import com.fideuram.stampe.modello.attori.Individuo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 20/11/14
 * Time: 10.19
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Familiare extends Individuo{
    public static Character CONIUGE='C';
    public static Character FIGLIO='F';
    public static Character ALTRO='A';

    private Character tipoFamiliare;                //C: congiuge: F:figlio  A:altro

    protected Boolean disabile=false;
    protected Boolean minoreAnni3=false;
    protected int     numeroMesiACarico;            //numero di mesi a carico
    protected int     detrazPercSpettante;          //detrazionePercentualeSpettante
    protected int     detrazTotaleAffidamento;      //detrazione 100% affidamento Figli

    public int getDetrazTotaleAffidamento() {
        return detrazTotaleAffidamento;
    }

    public int getDetrazPercSpettante() {
        return detrazPercSpettante;
    }

    public int getNumeroMesiACarico() {
        return numeroMesiACarico;
    }

    public String getMinoreAnni3() {
        return minoreAnni3?"X":"";
    }

    public String isFiglio() {
        return tipoFamiliare.equals('F')?"X":"";
    }

    public String isAltroFamiliare() {
        return tipoFamiliare.equals('A')?"X":"";
    }

    public String isConiuge() {
        return tipoFamiliare.equals('C')?"X":"";
    }

    public String isDisabile() {
        return disabile?"X":"";
    }


    public void setTipoFamiliare(Character tipoFamiliare) {
        this.tipoFamiliare = tipoFamiliare;
    }

    public void setDisabile(Boolean disabile) {
        this.disabile = disabile;
    }

    public void setMinoreAnni3(Boolean minoreAnni3) {
        this.minoreAnni3 = minoreAnni3;
    }

    public void setNumeroMesiACarico(int numeroMesiACarico) {
        this.numeroMesiACarico = numeroMesiACarico;
    }

    public void setDetrazPercSpettante(int detrazPercSpettante) {
        this.detrazPercSpettante = detrazPercSpettante;
    }

    public void setDetrazTotaleAffidamento(int detrazTotaleAffidamento) {
        this.detrazTotaleAffidamento = detrazTotaleAffidamento;
    }

}
