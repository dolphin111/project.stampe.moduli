package com.fideuram.preventivo.modello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 04/12/12
 * Time: 11.43
 */
@XmlType(name="Capitale")
public class Capitale implements Serializable {
    private String capitaleAssicurato;
    private String capitaleAssicuratoMorteInfortunio;
    private String capitaleAssicuratoMorteInfortunioStradale;
    private String capitaleAssicuratoMalattiaGrave;

    private List<Double> capitaleAssicuratoPerAnno;
    private List<Double> capitaleAssicuratoCasoMortePerAnnoA; // ipotesi a
    private List<Double> capitaleAssicuratoCasoMortePerAnnoB; // ipotesi b
    private List<Double> valoriRiscattoFineAnnoA;
    private List<Double> valoriRiscattoFineAnnoB;


    public List<Double> getValoriRiscattoFineAnnoB() {
        return valoriRiscattoFineAnnoB;
    }

    public void setValoriRiscattoFineAnnoB(List<Double> valoriRiscattoFineAnnoB) {
        this.valoriRiscattoFineAnnoB = valoriRiscattoFineAnnoB;
    }

    public List<Double> getValoriRiscattoFineAnnoA() {
        return valoriRiscattoFineAnnoA;
    }

    public void setValoriRiscattoFineAnnoA(List<Double> valoriRiscattoFineAnnoA) {
        this.valoriRiscattoFineAnnoA = valoriRiscattoFineAnnoA;
    }

    public List<Double> getCapitaleAssicuratoPerAnno() {
        return capitaleAssicuratoPerAnno;
    }

    public void setCapitaleAssicuratoPerAnno(List<Double> capitaleAssicuratoPerAnno) {
        this.capitaleAssicuratoPerAnno = capitaleAssicuratoPerAnno;
    }

    public List<Double> getCapitaleAssicuratoCasoMortePerAnnoA() {
        return capitaleAssicuratoCasoMortePerAnnoA;
    }

    public void setCapitaleAssicuratoCasoMortePerAnnoA(List<Double> capitaleAssicuratoCasoMortePerAnnoA) {
        this.capitaleAssicuratoCasoMortePerAnnoA = capitaleAssicuratoCasoMortePerAnnoA;
    }

    public List<Double> getCapitaleAssicuratoCasoMortePerAnnoB() {
        return capitaleAssicuratoCasoMortePerAnnoB;
    }

    public void setCapitaleAssicuratoCasoMortePerAnnoB(List<Double> capitaleAssicuratoCasoMortePerAnnoB) {
        this.capitaleAssicuratoCasoMortePerAnnoB = capitaleAssicuratoCasoMortePerAnnoB;
    }

    public String getCapitaleAssicurato() {
        return capitaleAssicurato;
    }
    public void setCapitaleAssicurato(String capitaleAssicurato) {
        this.capitaleAssicurato = capitaleAssicurato;
    }
    public String getCapitaleAssicuratoMorteInfortunio() {
        return capitaleAssicuratoMorteInfortunio;
    }
    public void setCapitaleAssicuratoMorteInfortunio(
            String capitaleAssicuratoMorteInfortunio) {
        this.capitaleAssicuratoMorteInfortunio = capitaleAssicuratoMorteInfortunio;
    }
    public String getCapitaleAssicuratoMorteInfortunioStradale() {
        return capitaleAssicuratoMorteInfortunioStradale;
    }
    public void setCapitaleAssicuratoMorteInfortunioStradale(
            String capitaleAssicuratoMorteInfortunioStradale) {
        this.capitaleAssicuratoMorteInfortunioStradale = capitaleAssicuratoMorteInfortunioStradale;
    }
/*
    public void addCapitaleAssicuratoPerAnno(double impo){
        if(this.capitaleAssicuratoPerAnno == null)
            this.capitaleAssicuratoPerAnno = new ArrayList<Double>();

        this.capitaleAssicuratoPerAnno.add(impo);

    }

    public void addCapitaleAssicuratoCasoMortePerAnnoA(double impo){
        if(this.capitaleAssicuratoCasoMortePerAnnoA == null)
            this.capitaleAssicuratoCasoMortePerAnnoA = new ArrayList<Double>();

        this.capitaleAssicuratoCasoMortePerAnnoA.add(impo);
    }

    public void addCapitaleAssicuratoCasoMortePerAnnoB(double impo){
        if(this.capitaleAssicuratoCasoMortePerAnnoB == null)
            this.capitaleAssicuratoCasoMortePerAnnoB = new ArrayList<Double>();

        this.capitaleAssicuratoCasoMortePerAnnoB.add(impo);
    }

    public void addValoriRiscattoFineAnnoA(double impo){
        if(this.valoriRiscattoFineAnnoA == null)
            this.valoriRiscattoFineAnnoA = new ArrayList<Double>();

        this.valoriRiscattoFineAnnoA.add(impo);
    }

    public void addValoriRiscattoFineAnnoB(double impo){
        if(this.valoriRiscattoFineAnnoB == null)
            this.valoriRiscattoFineAnnoB = new ArrayList<Double>();

        this.valoriRiscattoFineAnnoB.add(impo);
    }*/

	public String getCapitaleAssicuratoMalattiaGrave() {
		return capitaleAssicuratoMalattiaGrave;
	}

	public void setCapitaleAssicuratoMalattiaGrave(
			String capitaleAssicuratoMalattiaGrave) {
		this.capitaleAssicuratoMalattiaGrave = capitaleAssicuratoMalattiaGrave;
	}
}
