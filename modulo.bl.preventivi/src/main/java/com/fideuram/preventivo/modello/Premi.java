package com.fideuram.preventivo.modello;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 04/12/12
 * Time: 11.43
 */
@XmlType(name="Premi")
public class Premi implements Serializable {
    private String premioAnnuoCostante;
    private String premioAnnuoCostanteGaranzieComplementari;
    private String premioAnnuoCostanteGaranzieComplementariMalattiaGrave;
    private String frazionamento;
    private String sovrappremioSanitario;
    private String sovrappremioSportivo;
    private String premioAnnuoCostanteComplessivo;
    private String rataLorda;
    private String premioUnico;
    private Double percentualePremioGS;
    private Integer sviluppoPerAnni;
    private Double quotaGestioneSeparata; // quota parte versata alla gestione separata

    private Double carTot; // percentuale di caricamente per acquisizione e amministrazione

    public Double getCarTot() {
        return carTot;
    }

    public void setCarTot(Double carTot) {
        this.carTot = carTot;
    }

    public Double getQuotaGestioneSeparata() {
        return quotaGestioneSeparata;
    }

    public void setQuotaGestioneSeparata(Double quotaGestioneSeparata) {
        this.quotaGestioneSeparata = quotaGestioneSeparata;
    }


    public String getPremioAnnuoCostante() {
        return premioAnnuoCostante;
    }
    public void setPremioAnnuoCostante(String premioAnnuoCostante) {
        this.premioAnnuoCostante = premioAnnuoCostante;
    }
    public String getPremioAnnuoCostanteGaranzieComplementari() {
        return premioAnnuoCostanteGaranzieComplementari;
    }
    public void setPremioAnnuoCostanteGaranzieComplementari(
            String premioAnnuoCostanteGaranzieComplementari) {
        this.premioAnnuoCostanteGaranzieComplementari = premioAnnuoCostanteGaranzieComplementari;
    }
    public String getSovrappremioSanitario() {
        return sovrappremioSanitario;
    }
    public void setSovrappremioSanitario(String sovrappremioSanitario) {
        this.sovrappremioSanitario = sovrappremioSanitario;
    }
    public String getSovrappremioSportivo() {
        return sovrappremioSportivo;
    }
    public void setSovrappremioSportivo(String sovrappremioSportivo) {
        this.sovrappremioSportivo = sovrappremioSportivo;
    }
    public String getPremioAnnuoCostanteComplessivo() {
        return premioAnnuoCostanteComplessivo;
    }
    public void setPremioAnnuoCostanteComplessivo(
            String premioAnnuoCostanteComplessivo) {
        this.premioAnnuoCostanteComplessivo = premioAnnuoCostanteComplessivo;
    }
    public String getRataLorda() {
        return rataLorda;
    }
    public void setRataLorda(String rataLorda) {
        this.rataLorda = rataLorda;
    }

    public String getPremioUnico() {
        return premioUnico;
    }

    public void setPremioUnico(String premioUnico) {
        this.premioUnico = premioUnico;
    }

    public Double getPercentualePremioGS() {
        return percentualePremioGS;
    }

    public void setPercentualePremioGS(Double percentualePremioGS) {
        this.percentualePremioGS = percentualePremioGS;
    }

    public Integer getSviluppoPerAnni() {
        return sviluppoPerAnni;
    }

    public void setSviluppoPerAnni(Integer sviluppoPerAnni) {
        this.sviluppoPerAnni = sviluppoPerAnni;
    }

	public String getPremioAnnuoCostanteGaranzieComplementariMalattiaGrave() {
		return premioAnnuoCostanteGaranzieComplementariMalattiaGrave;
	}

	public void setPremioAnnuoCostanteGaranzieComplementariMalattiaGrave(
			String premioAnnuoCostanteGaranzieComplementariMalattiaGrave) {
		this.premioAnnuoCostanteGaranzieComplementariMalattiaGrave = premioAnnuoCostanteGaranzieComplementariMalattiaGrave;
	}

	public String getFrazionamento() {
		return frazionamento;
	}

	public void setFrazionamento(String frazionamento) {
		this.frazionamento = frazionamento;
	}
}
