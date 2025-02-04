package com.fideuram.crm.stampe.model;

import com.fideuram.costanti.Costanti;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.utils.NumberUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Decumulo {

    private Double importoCVN;
    private String dataCVN;


	private Double controvaloreQuote;
    private Date dataNav;

	private Double percentuale;
	private Double importoCedola;

	private String descControvaloreQuote;
	private String descPercentuale;
	private String descImportoCedola;
	
	private String frazionamento;

    public String getImportoCVN() {
        return importoCVN!=null?FormatterFactory.getStandardImporto(importoCVN):"";             //verificare 2 decimali in fondo;
    }

    public String getDataCVN() {
        return dataCVN;
    }

    public String getControvaloreQuote() {
        return controvaloreQuote!=null?FormatterFactory.getStandardQuote(controvaloreQuote):""; //verificare 2 decimali in fondo
	}

	public String getPercentuale() {
        return percentuale!=null?FormatterFactory.getStandardPercentuale(percentuale):"";       //verificare 2 decimali in fondo
	}

	public String getImportoCedola() {
        return importoCedola!=null?FormatterFactory.getStandardImporto(importoCedola):"";       //verificare 2 decimali in fondo
	}

	public String getDataNav() {
        return dataNav!=null?FormatterFactory.getStandardDate(dataNav):"";
	}

    public String getFrazionamento() {
        if(frazionamento.equalsIgnoreCase("S"))
            return  "Semestrale";
        else if (frazionamento.equalsIgnoreCase("Q"))
            return  "Quadrimestrale";
        else if (frazionamento.equalsIgnoreCase("T"))
            return  "Trimestrale";
        else if (frazionamento.equalsIgnoreCase("B"))
            return "Bimestrale";
        else if(frazionamento.equalsIgnoreCase("M"))
            return  "Mensile";
        else return frazionamento;   //Se la sigla non è riconducibile a nessun formato la restituisco così com'è
    }

    public void setImportoCVN(Double importoCVN) {
        this.importoCVN = importoCVN;
    }

    public void setDataCVN(String dataCVN) {
        this.dataCVN = dataCVN;
    }

    public void setFrazionamento(String frazionamento) {
        this.frazionamento = frazionamento;
    }

    public void setControvaloreQuote(Double controvaloreQuote) {
        this.controvaloreQuote = controvaloreQuote;
    }

    public void setPercentuale(Double percentuale) {
        this.percentuale = percentuale;
    }

    public void setPercentuale(String percentuale)  {
        this.setPercentuale( Double.parseDouble(percentuale.replaceAll(",",".")));
    }

    public void setImportoCedola(Double importoCedola) {
        this.importoCedola = importoCedola;
    }

    public void setDataNav(Date dataNav) {
        this.dataNav = dataNav;
    }


    //todo rivedere bene cosa è sta roba quì sotto  chi la usa e per fare cosa

	public String getDescControvaloreQuote() {
		return descControvaloreQuote;
	}
	public void setDescControvaloreQuote(String descControvaloreQuote) {
		this.descControvaloreQuote = descControvaloreQuote;
	}
	public String getDescPercentuale() {
		return descPercentuale;
	}
	public void setDescPercentuale(String descPercentuale) {
		this.descPercentuale = descPercentuale;
	}
	public String getDescImportoCedola() {
		return descImportoCedola;
	}
	public void setDescImportoCedola(String descImportoCedola) {
		this.descImportoCedola = descImportoCedola;
	}


}