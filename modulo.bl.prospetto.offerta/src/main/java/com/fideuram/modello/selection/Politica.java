package com.fideuram.modello.selection;

import com.fideuram.costanti.Frasi;
import com.fideuram.utils.LoggingUtils;

import java.io.Serializable;

/**
 * Created by 
 * User: logan
 * Date: 15/06/12
 * Time: 11.51
 */
public class Politica implements Serializable {
    private String categoria;
    private String categoriaAnia;
    private String orizzonteTemporale;
    private String gradoRischio;
    private String gradoScostamentoBenchmark                        ="---";
    private String strumentiFinanziari                       		="n.a.";
    private String valutaStrumentiFinanziari                        ="n.a.";
    private String arreeGeografiche;
    private String categoriEmittenti                                ="n.a.";
    private String settoriIndustrialiRilevanti						="n.a.";
    private String investimentoQuoteAzioniFondiInterniOicr          ="n.a.";// modifica del 12/06/2018 ETF
    private String fattoriDiRischio                                 ="n.a.";// modifica del 12/06/2018 ETF
    private String strumentiDerivati								="n.a.";// modifica del 12/06/2018 ETF
    private String indicizzazione;
    private String garanzia;
    private String immunizzazione;
    private String gestioneObiettivoRendimentoProtetta;
    private String tecninaDiGestione;
    private String tecninaDiGestioneRischio                         ;
    private String tecninaDiGestioneRischioDettagli                 ="n.a.";
    private String destinazioneProventi;
    private String precisazioniGestioneBenchmarkPassivoImmunizzato  =" ";
    private String precisazioneGestioneBenchmarkPassivo             =" ";
    private String variazioniPoliticaInvestimento;
    private String dvpi=""; //descrizione della variazione
    private String variazioniSoggettiIncaricati;
    private String dvsi=""; //descrizione della variazione
    private String rimando1="";
    private String              testoGaranzia;
    private String ulterioriInformazioniInvestFondi;
    private boolean isBasso = false;
    private boolean isMedioBasso = false;
    private boolean isMedio = false;
    private boolean isMedioAlto = false;
    private boolean isAlto = false;
    private boolean isMoltoAlto = false;
    private boolean isStrumentiBold = false;
    private String altriStrumenti;
    
    
    public String getAltriStrumenti() {
		return altriStrumenti;
	}

	public void setAltriStrumenti(String altriStrumenti) {
		this.altriStrumenti = altriStrumenti;
	}

	public boolean isStrumentiBold() {
		return isStrumentiBold;
	}

	public void setStrumentiBold(boolean isStrumentiBold) {
		this.isStrumentiBold = isStrumentiBold;
	}

	public boolean isBasso() {
		return isBasso;
	}

	public void setBasso(boolean isBasso) {
		this.isBasso = isBasso;
	}

	public boolean isMedioBasso() {
		return isMedioBasso;
	}

	public void setMedioBasso(boolean isMedioBasso) {
		this.isMedioBasso = isMedioBasso;
	}

	public boolean isMedio() {
		return isMedio;
	}

	public void setMedio(boolean isMedio) {
		this.isMedio = isMedio;
	}

	public boolean isMedioAlto() {
		return isMedioAlto;
	}

	public void setMedioAlto(boolean isMedioAlto) {
		this.isMedioAlto = isMedioAlto;
	}

	public boolean isAlto() {
		return isAlto;
	}

	public void setAlto(boolean isAlto) {
		this.isAlto = isAlto;
	}

	public boolean isMoltoAlto() {
		return isMoltoAlto;
	}

	public void setMoltoAlto(boolean isMoltoAlto) {
		this.isMoltoAlto = isMoltoAlto;
	}

	public String getUlterioriInformazioniInvestFondi() {
		return ulterioriInformazioniInvestFondi;
	}

	public void setUlterioriInformazioniInvestFondi(
			String ulterioriInformazioniInvestFondi) {
		this.ulterioriInformazioniInvestFondi = ulterioriInformazioniInvestFondi;
	}

	public String getCategoriaAnia() {
    	if(categoriaAnia==null||categoriaAnia.equals(""))
            return "---";
		return categoriaAnia;
	}

	public void setCategoriaAnia(String categoriaAnia) {
		this.categoriaAnia = categoriaAnia;
	}

	public String getCategoria() {
         if(categoria==null||categoria.equals(""))
            return "---";
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOrizzonteTemporale() {
        if(orizzonteTemporale.trim().startsWith("1"))
            return "1 anno";
        return orizzonteTemporale;
    }

    public void setOrizzonteTemporale(String orizzonteTemporale) {
        this.orizzonteTemporale = orizzonteTemporale;
    }

    public String getGradoRischio() {
        return gradoRischio;
    }

    public void setGradoRischio(String gradoRischio) {
        if(gradoRischio==null){
            LoggingUtils.debug("gradoRischio null");
        }
        this.gradoRischio = gradoRischio;
    }

    public String getGradoScostamentoBenchmark() {
        return gradoScostamentoBenchmark;
    }

    public void setGradoScostamentoBenchmark(String gradoScostamentoBenchmark) {
        if(null==gradoScostamentoBenchmark||gradoScostamentoBenchmark.trim().equals(""))
            return;
        this.gradoScostamentoBenchmark = gradoScostamentoBenchmark;
    }

    public String getStrumentiFinanziari() {
        return strumentiFinanziari;
    }

    public void setStrumentiFinanziari(String strumentiFinanziari) {
    	if(strumentiFinanziari != null && !"".equals(strumentiFinanziari)){
    		this.strumentiFinanziari = strumentiFinanziari;
    	}
    }

    public String getValutaStrumentiFinanziari() {
        return valutaStrumentiFinanziari;
    }

    public void setValutaStrumentiFinanziari(String valutaStrumentiFinanziari) {
    	if(valutaStrumentiFinanziari != null && !"".equals(valutaStrumentiFinanziari)){
    		this.valutaStrumentiFinanziari = valutaStrumentiFinanziari;
    	}
    }

    public String getArreeGeografiche() {
    	if("".equals(arreeGeografiche) || arreeGeografiche == null)
    		return "n.a.";
        return arreeGeografiche;
    }

    public void setArreeGeografiche(String arreeGeografiche) {
        this.arreeGeografiche = arreeGeografiche;
    }

    public String getCategoriEmittenti() {
        return categoriEmittenti;
    }

    public void setCategoriEmittenti(String categoriEmittenti) {
        if(categoriEmittenti.trim().equals("")||null==categoriEmittenti)
            return;
        this.categoriEmittenti = categoriEmittenti;
    }

    public String getSettoriIndustrialiRilevanti() {
        return settoriIndustrialiRilevanti;
    }

    public void setSettoriIndustrialiRilevanti(String settoriIndustrialiRilevanti) {
        if(null==settoriIndustrialiRilevanti||settoriIndustrialiRilevanti.trim().equals("")){
            //this.settoriIndustrialiRilevanti = "nessun settore industriale rilevante";modifica del 12/0672018 con l'introduzione degli ETF
        	return;
        }else{
            this.settoriIndustrialiRilevanti = settoriIndustrialiRilevanti;
        }
    }

    public String getInvestimentoQuoteAzioniFondiInterniOicr() {
        return investimentoQuoteAzioniFondiInterniOicr;
    }

    public void setInvestimentoQuoteAzioniFondiInterniOicr(String investimento) {
        if(null==investimento||investimento.trim().equals(""))
            return;
        this.investimentoQuoteAzioniFondiInterniOicr = investimento;
    }

    public String getFattoriDiRischio() {
        return fattoriDiRischio;
    }

    public void setFattoriDiRischio(String fattoriDiRischio) {
    	if(fattoriDiRischio != null && !"".equals(fattoriDiRischio)){
    		this.fattoriDiRischio = fattoriDiRischio;
    	}
    }

    public String getStrumentiDerivati() {
        return strumentiDerivati;
    }

    public void setStrumentiDerivati(String strumentiDerivati) {
    	if(strumentiDerivati == null || "".equals(strumentiDerivati))
    		return;
        this.strumentiDerivati = strumentiDerivati;
    }

    public String getIndicizzazione() {
        return indicizzazione;
    }

    public void setIndicizzazione(String indicizzazione) {
        if(null==indicizzazione||indicizzazione.trim().equals(""))
            return;
        this.indicizzazione = indicizzazione;
    }

    public String getGaranzia() {
        return garanzia;
    }

    public void setGaranzia(String garanzia) {
        if(null==garanzia||garanzia.trim().equals(""))
            return;
        this.garanzia = garanzia;
    }

    public String getImmunizzazione() {
        return immunizzazione;
    }

    public void setImmunizzazione(String immunizzazione) {
        if(null==immunizzazione||immunizzazione.trim().equals(""))
            return;
        this.immunizzazione = immunizzazione;
    }

    public String getGestioneObiettivoRendimentoProtetta() {
        return gestioneObiettivoRendimentoProtetta;
    }

    public void setGestioneObiettivoRendimentoProtetta(String gestioneObiettivoRendimentoProtetta) {
        if(null==gestioneObiettivoRendimentoProtetta||gestioneObiettivoRendimentoProtetta.trim().equals(""))
            return;
        this.gestioneObiettivoRendimentoProtetta = gestioneObiettivoRendimentoProtetta;
    }

    public String getTecninaDiGestione() {
        if(tecninaDiGestione.endsWith("."))
            return tecninaDiGestione.substring(0,tecninaDiGestione.length()-1);
        if("".equals(tecninaDiGestione) || tecninaDiGestione == null)
    		return "n.a.";
        return tecninaDiGestione;
    }

    public void setTecninaDiGestione(String tecninaDiGestione) {
        this.tecninaDiGestione = tecninaDiGestione;
        if(tecninaDiGestione.equalsIgnoreCase("a obiettivo di rendimento protetta")){
            rimando1=Frasi.getFrase("rimando.1");
        }
    }

    public String getTecninaDiGestioneRischio() {
//    	if("NO".equals(tecninaDiGestioneRischio)){//12/06/2018 ETF
//    		return "Non sono attuate tecniche di gestione dei rischi.";
//    	}else
        return tecninaDiGestioneRischio;
    }

    public void setTecninaDiGestioneRischio(String tecninaDiGestioneRischio) {
    	if(tecninaDiGestioneRischio != null){
    		this.tecninaDiGestioneRischio = tecninaDiGestioneRischio;
    	}
    }

    public String getTecninaDiGestioneRischioDettagli() {
        return tecninaDiGestioneRischioDettagli;
    }

    public void setTecninaDiGestioneRischioDettagli(String tecninaDiGestioneRischioDettagli) {
        if(null==tecninaDiGestioneRischioDettagli||tecninaDiGestioneRischioDettagli.trim().equals(""))
            return;
        this.tecninaDiGestioneRischioDettagli = tecninaDiGestioneRischioDettagli;
    }

    public String getDestinazioneProventi() {
        return destinazioneProventi;
    }

    public void setDestinazioneProventi(String destinazioneProventi) {
        if(null==destinazioneProventi){
            LoggingUtils.fatal("Politica.destinazioneProventi==null");
            return;
        }
        this.destinazioneProventi = destinazioneProventi;
    }

    public String getPrecisazioniGestioneBenchmarkPassivoImmunizzato() {
        return precisazioniGestioneBenchmarkPassivoImmunizzato;
    }

    public void setPrecisazioniGestioneBenchmarkPassivoImmunizzato(String precisazioniGestioneBenchmarkPassivoImmunizzato) {
        this.precisazioniGestioneBenchmarkPassivoImmunizzato = precisazioniGestioneBenchmarkPassivoImmunizzato;
    }

    public String getPrecisazioneGestioneBenchmarkPassivo() {
        return precisazioneGestioneBenchmarkPassivo;
    }

    public void setPrecisazioneGestioneBenchmarkPassivo(String precisazioneGestioneBenchmarkPassivo) {
        this.precisazioneGestioneBenchmarkPassivo = precisazioneGestioneBenchmarkPassivo;
    }

    public String getVariazioniPoliticaInvestimento() {
        return variazioniPoliticaInvestimento;
    }

    public void setVariazioniPoliticaInvestimento(String variazioniPoliticaInvestimento) {
        this.variazioniPoliticaInvestimento = variazioniPoliticaInvestimento;
    }

    public String getVariazioniSoggettiIncaricati() {
        return variazioniSoggettiIncaricati;
    }

    public void setVariazioniSoggettiIncaricati(String variazioniSoggettiIncaricati) {
        this.variazioniSoggettiIncaricati = variazioniSoggettiIncaricati;
    }

    public String getRimando1() {
        return rimando1;
    }

    public String getTestoGaranzia() {
        if(null==testoGaranzia)
            return "";
        return testoGaranzia;
    }

    public void setTestoGaranzia(String testoGaranzia) {
        this.testoGaranzia = testoGaranzia;
    }

    public String getDvpi() {
        return dvpi;
    }

    public void setDvpi(String dvpi) {
        if(null==dvpi||"".equals(dvpi)){
            this.dvpi= Frasi.getFrase("variazione.politica.ult.2.anni")+" ";
        }else {
            this.dvpi = dvpi;
        }
    }

    public String getDvsi() {
        return dvsi;
    }

    public void setDvsi(String dvsi) {
        if(null==dvsi||"".equals(dvsi)){
            this.dvsi=Frasi.getFrase("variazione.soggetti.ult.2.anni");
            return;
        } else {
            this.dvsi = dvsi;
        }
        /*if(     dvsi.trim().equalsIgnoreCase("N.A.")||
                dvsi.trim().equalsIgnoreCase("NA.")||
                dvsi.trim().equalsIgnoreCase("N.A")){
            return;
        }else {
            this.dvsi = dvsi;
        }*/
    }
}
