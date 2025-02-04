package com.fideuram.modello.selection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import com.fideuram.utils.SerigrafiaStringhe;

/**
 * Created by
 * User: logan
 * Date: 06/06/12
 * Time: 15.11
 * <br> TER: RAPPORTO ONERI PATRIMONIO</br>
 * <br>Di seguito è riportato il rapporto percentuale, riferito a ciascun anno solare dell'ultimo triennio, </br>
 * <br>fra il totale degli oneri posti a carico dell’OICR ed il patrimonio medio su base giornaliera dello stesso </br>
 * <br>(c.d. TER).</br>
 */
public class Ter implements Serializable {
    private String anno;                                             //2009...
    private String commissioniGestione                      ="---";
    private String commissioniIncentivo                     ="---";
    //sulle due commissioni di cui sopra dare il totale
    private String ter                                      ="---";
    private String speseAmministrazioneCustodia             ="---";
    private String speseRevisioneCertificazionePatrimonio   ="---";
    private String speseGiudiziarie                         ="---";
    private String spesePubblicazione                       ="---";
    private String altriOneri                               ="---";
    private String totSpese                                 ="---";
    private String totCommissioni                           ="---";
    private String pesoCompravenditeStrumentiFinanziari     ="---"; //pesoPercCompravenditeStrumentiFinanziari
    private String oneriDismissioneAttivita					="---";
    private String turnoverPortafoglio 					    ="---";
    private String totSpeseArrotondate                      ="---";
    private String pesoCompFin                              ="--"; 
    private List<String> matchND = Arrays.asList( "n.d.","nd","n.d","nd.");
    private List<String> matchNA = Arrays.asList( "n.a.","na","n.a","na.");
    
    public String getPesoCompFin() {
		return pesoCompFin;
	}
    
	public void setPesoCompFin(String pesoCompFin) {
		if (matchND.contains(pesoCompFin)){
	      	  this.pesoCompFin=pesoCompFin;
	      }else  if(isValid(pesoCompFin)){
	    	  String tot = pesoCompFin.trim().replace(",", ".");
	    	  BigDecimal value = new BigDecimal(tot);
	    	  value = value.setScale(2, RoundingMode.HALF_UP);
	          this.pesoCompFin=SerigrafiaStringhe.getNdOrAppendPercentuale(value.toString().replace(".", ","),"%");
	      }
	}
    public String getTotSpeseArrotondate() {
        return totSpeseArrotondate;
    }
    public void setTotSpeseArrotondate(String totSpeseArrotondate) {
    	if (matchND.contains(totSpeseArrotondate)){
      	  this.totSpeseArrotondate=totSpeseArrotondate;
      }else if(isValid(totSpeseArrotondate)){
        	String tot = totSpeseArrotondate.trim().replace(",", ".");
        	BigDecimal value = new BigDecimal(tot);
        	value = value.setScale(2, RoundingMode.HALF_UP);
            this.totSpeseArrotondate=SerigrafiaStringhe.getNdOrAppendPercentuale(value.toString().replace(".", ","),"%");
        }
    }
    

	public String getTurnoverPortafoglio() {
		return turnoverPortafoglio;
	}

	public void setTurnoverPortafoglio(String turnoverPortafoglio) {
		if(turnoverPortafoglio != null && matchND.contains(turnoverPortafoglio)){
			this.turnoverPortafoglio = turnoverPortafoglio;
		}else if(isValid(turnoverPortafoglio))
	        this.turnoverPortafoglio= SerigrafiaStringhe.getNdOrAppendPercentuale(turnoverPortafoglio,"%");
	}

	public String getOneriDismissioneAttivita() {
		return oneriDismissioneAttivita;
	}

	public void setOneriDismissioneAttivita(String oneriDismissioneAttivita) {
		if (oneriDismissioneAttivita != null && matchND.contains(oneriDismissioneAttivita.toLowerCase())){
			this.oneriDismissioneAttivita = oneriDismissioneAttivita;
		}else if(isValid(oneriDismissioneAttivita))
	            this.oneriDismissioneAttivita= SerigrafiaStringhe.getNdOrAppendPercentuale(oneriDismissioneAttivita,"%");
	}

	public String getAnno() {
        return anno;
    }

    public String getCommissioniGestione() {
        return commissioniGestione;
    }

    public String getCommissioniIncentivo() {
        return commissioniIncentivo;
    }

    public String getTer() {
        return ter;
    }

    public String getSpeseAmministrazioneCustodia() {
        return speseAmministrazioneCustodia;
    }

    public String getSpeseRevisioneCertificazionePatrimonio() {
        return speseRevisioneCertificazionePatrimonio;
    }

    public String getSpeseGiudiziarie() {
        return speseGiudiziarie.trim();
    }

    public String getSpesePubblicazione() {
        return spesePubblicazione.trim();
    }

    public String getAltriOneri() {
        return altriOneri.trim();
    }

    public Double getAltriOneriCleaned() {
        String numeretto = altriOneri.contains("%")? altriOneri.substring(0,altriOneri.length()-1):"0.00";
        numeretto=numeretto.replace(',','.');
        return Double.valueOf(numeretto);
    }

    public String getTotSpese() {
        return totSpese;
    }

    public String getTotCommissioni() {
        return totCommissioni;
    }

    public String getPesoCompravenditeStrumentiFinanziari() {
        return pesoCompravenditeStrumentiFinanziari;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public void setCommissioniGestione(String commissioniGestione) {
    	if (matchND.contains(commissioniGestione)){
        	  this.commissioniGestione=commissioniGestione;
        }else  if(isValid(commissioniGestione))
            this.commissioniGestione= SerigrafiaStringhe.getNdOrAppendPercentuale(commissioniGestione,"%");
    }

    public void setCommissioniIncentivo(String commissioniIncentivo) {
    	if (matchND.contains(commissioniIncentivo)){
        	  this.commissioniIncentivo=commissioniIncentivo;
        }else if(isValid(commissioniIncentivo))
            this.commissioniIncentivo= SerigrafiaStringhe.getNdOrAppendPercentuale(commissioniIncentivo,"%");
    }

    public void setTer(String ter) {
    	if (ter != null && matchND.contains(ter)){
        	  this.ter=ter;
        }else if(isValid(ter))
            this.ter= SerigrafiaStringhe.getNdOrAppendPercentuale(ter,"%");
    }

    public void setSpeseAmministrazioneCustodia(String speseAmministrazioneCustodia) {
    	if (matchND.contains(speseAmministrazioneCustodia)){
        	  this.speseAmministrazioneCustodia=speseAmministrazioneCustodia;
        }else if(isValid(speseAmministrazioneCustodia))
            this.speseAmministrazioneCustodia= SerigrafiaStringhe.getNdOrAppendPercentuale(speseAmministrazioneCustodia,"%");
    }

    public void setSpeseRevisioneCertificazionePatrimonio(String speseRevisioneCertificazionePatrimonio) {
    	if (matchND.contains(speseRevisioneCertificazionePatrimonio)){
        	  this.speseRevisioneCertificazionePatrimonio=speseRevisioneCertificazionePatrimonio;
        }else if(isValid(speseRevisioneCertificazionePatrimonio))
            this.speseRevisioneCertificazionePatrimonio= SerigrafiaStringhe.getNdOrAppendPercentuale(speseRevisioneCertificazionePatrimonio,"%");
    }

    public void setSpeseGiudiziarie(String speseGiudiziarie) {
    	if (matchND.contains(speseGiudiziarie)|| 
    			(speseGiudiziarie != null && matchNA.contains(speseGiudiziarie.toLowerCase()))){
        	  this.speseGiudiziarie=speseGiudiziarie;
        }else if(isValid(speseGiudiziarie)){
            this.speseGiudiziarie= SerigrafiaStringhe.getNdOrAppendPercentuale(speseGiudiziarie,"%");
        }
    }

    public void setSpesePubblicazione(String spesePubblicazione) {
    	if (matchND.contains(spesePubblicazione)){
        	  this.spesePubblicazione=spesePubblicazione;
        }else if(isValid(spesePubblicazione))
            this.spesePubblicazione= SerigrafiaStringhe.getNdOrAppendPercentuale(spesePubblicazione,"%");
    }

    public void setAltriOneri(String altriOneri) {
    	if (matchND.contains(altriOneri)){
        	  this.altriOneri=altriOneri;
        }else if(isValid(altriOneri))
            this.altriOneri=SerigrafiaStringhe.getNdOrAppendPercentuale(altriOneri,"%");
    }

    public void setTotSpese(String totSpese) {
    	if (matchND.contains(totSpese)){
        	  this.totSpese=totSpese;
        }else if(isValid(totSpese))
            this.totSpese=SerigrafiaStringhe.getNdOrAppendPercentuale(totSpese,"%");
    }

    public void setTotCommissioni(String totCommissioni) {
    	if (matchND.contains(totCommissioni)){
        	  this.totCommissioni=totCommissioni;
        }else if(isValid(totCommissioni))
            this.totCommissioni=SerigrafiaStringhe.getNdOrAppendPercentuale(totCommissioni,"%");
    }

    public void setPesoCompravenditeStrumentiFinanziari(String pesoCompravenditeStrumentiFinanziari) {
    	if (matchND.contains(pesoCompravenditeStrumentiFinanziari)){
        	  this.pesoCompravenditeStrumentiFinanziari=pesoCompravenditeStrumentiFinanziari;
        }else if(isValid(pesoCompravenditeStrumentiFinanziari)){
	    	  String tot = pesoCompravenditeStrumentiFinanziari.trim().replace(",", ".");
	    	  BigDecimal value = new BigDecimal(tot);
	    	  value = value.setScale(2, RoundingMode.HALF_UP);
	          this.pesoCompravenditeStrumentiFinanziari=SerigrafiaStringhe.getNdOrAppendPercentuale(value.toString().replace(".", ","),"%");
        }
    }
    
    private String getTotate(String totale){
        totale = totale.replace(',','.');
        Double x = Double.parseDouble(totale);
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        totale=twoDForm.format(x);
        if(totale.contains(",")&&totale.substring(totale.indexOf(',')+1).length()==1)
            totale=totale+"0";
        if(!totale.contains(","))
            totale=totale+",00";
        return totale;
    }

    private boolean isValid(String dato){
        if(dato==null ||
        		 dato.trim().contains("--") ||
                 dato.trim().toUpperCase().contains("N.A") ||
                 dato.trim().toUpperCase().contains("N,A") ||
                 dato.trim().toUpperCase().contains("N.D") ||
                 dato.trim().toUpperCase().contains("N,D") ||
                 dato.trim().equals("%") ||
                 dato.trim().equals(""))
            return false;
        else
            return true;
    }
}
