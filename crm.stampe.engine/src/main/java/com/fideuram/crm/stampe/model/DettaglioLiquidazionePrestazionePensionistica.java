package com.fideuram.crm.stampe.model;

import java.util.List;

import com.fideuram.stampe.modello.fpa.DettaglioComparto;



/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 12/05/15
 * Time: 12.25
 * To change this template use File | Settings | File Templates.       simulazioneFPA.odt
 */
public class DettaglioLiquidazionePrestazionePensionistica {

    public String aderente;
    public String ammontarePosizioneIndividualeMaturata;

    public String controvalore;
    public String controvaloreReale;	
    public String controvaloreGarantito;
    public String dataAdesioneFondo;
    public String dataPrimaIscrizioneFormePensionisticheComplementare;
    public String dataNascita100;
    public String dataNascita50;
    public String numeroPosizione;
    public String prospettoLiquidativo;
    public String fondoPensione;
    public String tipologiaAderente;
    public String totaleContributiVersatiNettiFondoGenerale;
    public String numeroQuote;
    public String valoreQuota;
    public Rateazione  renditaImmediata100;
    public Rateazione  renditaImmediata50;
    public Rateazione renditaImmediata85Anni;
    public Rateazione  renditaGarantita100;
    public Rateazione  renditaGarantita50;
    public String valoreLordoPrestazionePensionistica100;
    public String valoreLordoPrestazionePensionistica50;
    public Boolean valorizza85;
    public Boolean valorizzaRendita10;
    public Boolean valorizzaRenditaGarantita10Anni;
    public Boolean valorizzaRendita5;

    public String dataPreventivo;

    public String assegnoSociale;
    public Boolean valorizzaAssegnoSociale;
	private List<DettaglioComparto> listaComparti;
	private String tabellaDemografica;
	public Integer etaCalcolo;
	public Integer etaCalcoloEffettiva;

    //Parte relativa

    public List<DettaglioComparto> getListaComparti() {
		return listaComparti;
	}

	public void setListaComparti(List<DettaglioComparto> listaComparti) {
		this.listaComparti = listaComparti;
	}

	public String getTabellaDemografica() {
		return tabellaDemografica;
	}

	public void setTabellaDemografica(String tabellaDemografica) {
		this.tabellaDemografica = tabellaDemografica;
	}

	public String getAderente() {
        return aderente;
    }

    public void setAderente(String aderente) {
        this.aderente = aderente;
    }

    public String getAmmontarePosizioneIndividualeMaturata() {
        return ammontarePosizioneIndividualeMaturata;
    }

    public void setAmmontarePosizioneIndividualeMaturata(String ammontarePosizioneIndividualeMaturata) {
        this.ammontarePosizioneIndividualeMaturata = ammontarePosizioneIndividualeMaturata;
    }

    public String getControvalore() {
        return controvalore;
    }

    public void setControvalore(String controvalore) {
        this.controvalore = controvalore;
    }

    public String getControvaloreReale() {
		return controvaloreReale;
	}

	public void setControvaloreReale(String controvaloreReale) {
		this.controvaloreReale = controvaloreReale;
	}

	public String getControvaloreGarantito() {
		return controvaloreGarantito;
	}

	public void setControvaloreGarantito(String controvaloreGarantito) {
		this.controvaloreGarantito = controvaloreGarantito;
	}

	public String getDataAdesioneFondo() {
        return dataAdesioneFondo;
    }

    public void setDataAdesioneFondo(String dataAdesioneFondo) {
        this.dataAdesioneFondo = dataAdesioneFondo;
    }

    public String getDataNascita100() {
        return dataNascita100;
    }

    public void setDataNascita100(String dataNascita100) {
        this.dataNascita100 = dataNascita100;
    }

    public String getDataNascita50() {
        return dataNascita50;
    }

    public void setDataNascita50(String dataNascita50) {
        this.dataNascita50 = dataNascita50;
    }

    public String getNumeroPosizione() {
        return numeroPosizione;
    }

    public void setNumeroPosizione(String numeroPosizione) {
        this.numeroPosizione = numeroPosizione;
    }

    public String getProspettoLiquidativo() {
        return prospettoLiquidativo;
    }

    public void setProspettoLiquidativo(String prospettoLiquidativo) {
        this.prospettoLiquidativo = prospettoLiquidativo;
    }

    public String getFondoPensione() {
        return fondoPensione;
    }

    public void setFondoPensione(String fondoPensione) {
        this.fondoPensione = fondoPensione;
    }

    public String getTipologiaAderente() {
        return tipologiaAderente;
    }

    public void setTipologiaAderente(String tipologiaAderente) {
        this.tipologiaAderente = tipologiaAderente;
    }

    public String getDataPrimaIscrizioneFormePensionisticheComplementare() {
        return dataPrimaIscrizioneFormePensionisticheComplementare;
    }

    public void setDataPrimaIscrizioneFormePensionisticheComplementare(String dataPrimaIscrizioneFormePensionisticheComplementare) {
        this.dataPrimaIscrizioneFormePensionisticheComplementare = dataPrimaIscrizioneFormePensionisticheComplementare;
    }

    public String getTotaleContributiVersatiNettiFondoGenerale() {
        return totaleContributiVersatiNettiFondoGenerale;
    }

    public void setTotaleContributiVersatiNettiFondoGenerale(String totaleContributiVersatiNettiFondoGenerale) {
        this.totaleContributiVersatiNettiFondoGenerale = totaleContributiVersatiNettiFondoGenerale;
    }

    public String getNumeroQuote() {
        return numeroQuote;
    }

    public void setNumeroQuote(String numeroQuote) {
        this.numeroQuote = numeroQuote;
    }

    public String getValoreQuota() {
        return valoreQuota;
    }

    public void setValoreQuota(String valoreQuota) {
        this.valoreQuota = valoreQuota;
    }

    public Rateazione getRenditaImmediata100() {
        return renditaImmediata100;
    }

    public void setRenditaImmediata100(Rateazione renditaImmediata100) {
        this.renditaImmediata100 = renditaImmediata100;
    }

    public Rateazione getRenditaImmediata50() {
        return renditaImmediata50;
    }

    public void setRenditaImmediata50(Rateazione renditaImmediata50) {
        this.renditaImmediata50 = renditaImmediata50;
    }

    public Rateazione getRenditaGarantita50() {
        return renditaGarantita50;
    }

    public void setRenditaGarantita50(Rateazione renditaGarantita50) {
        this.renditaGarantita50 = renditaGarantita50;
    }

    public Rateazione getRenditaGarantita100() {
        return renditaGarantita100;
    }

    public void setRenditaGarantita100(Rateazione renditaGarantita100) {
        this.renditaGarantita100 = renditaGarantita100;
    }

    public String getValoreLordoPrestazionePensionistica100() {
        return valoreLordoPrestazionePensionistica100;
    }

    public void setValoreLordoPrestazionePensionistica100(String valoreLordoPrestazionePensionistica100) {
        this.valoreLordoPrestazionePensionistica100 = valoreLordoPrestazionePensionistica100;
    }

    public String getValoreLordoPrestazionePensionistica50() {
        return valoreLordoPrestazionePensionistica50;
    }

    public void setValoreLordoPrestazionePensionistica50(String valoreLordoPrestazionePensionistica50) {
        this.valoreLordoPrestazionePensionistica50 = valoreLordoPrestazionePensionistica50;
    }

    public Rateazione getRenditaImmediata85Anni() {
        return renditaImmediata85Anni;
    }

    public void setRenditaImmediata85Anni(Rateazione renditaImmediata85Anni) {
        this.renditaImmediata85Anni = renditaImmediata85Anni;
    }

    public Boolean getValorizza85() {
        return valorizza85;
    }

    public void setValorizza85(Boolean valorizza85) {
        this.valorizza85 = valorizza85;
    }

    public Boolean getValorizzaRendita10() {
        return valorizzaRendita10;
    }

    public void setValorizzaRendita10(Boolean valorizzaRendita10) {
        this.valorizzaRendita10 = valorizzaRendita10;
    }

    public Boolean getValorizzaRendita5() {
        return valorizzaRendita5;
    }

    public void setValorizzaRendita5(Boolean valorizzaRendita5) {
        this.valorizzaRendita5 = valorizzaRendita5;
    }

    public Boolean getValorizzaRenditaGarantita10Anni() {
        return valorizzaRenditaGarantita10Anni;
    }

    public void setValorizzaRenditaGarantita10Anni(Boolean valorizzaRenditaGarantita10Anni) {
        this.valorizzaRenditaGarantita10Anni = valorizzaRenditaGarantita10Anni;
    }

    public String getAssegnoSociale() {
        return assegnoSociale;
    }

    public void setAssegnoSociale(String assegnoSociale) {
        this.assegnoSociale = assegnoSociale;
    }

    public Boolean getValorizzaAssegnoSociale() {
        return valorizzaAssegnoSociale;
    }

    public void setValorizzaAssegnoSociale(Boolean valorizzaAssegnoSociale) {
        this.valorizzaAssegnoSociale = valorizzaAssegnoSociale;
    }

    public String getDataPreventivo() {
        return dataPreventivo;
    }

    public void setDataPreventivo(String dataPreventivo) {

        this.dataPreventivo = dataPreventivo;
    }

	public Integer getEtaCalcolo() {
		return etaCalcolo;
	}

	public void setEtaCalcolo(Integer etaCalcolo) {
		this.etaCalcolo = etaCalcolo;
	}

	public Integer getEtaCalcoloEffettiva() {
		return etaCalcoloEffettiva;
	}

	public void setEtaCalcoloEffettiva(Integer etaCalcoloEffettiva) {
		this.etaCalcoloEffettiva = etaCalcoloEffettiva;
	}

}
