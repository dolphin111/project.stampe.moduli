/**
 * 
 */
package com.fideuram.crm.stampe.model;

import java.util.List;

/**
 * @author Giorgio Desideri
 *
 */
public class PraticaSpiegazioneConteggi {
    private boolean haImpostaDiBollo;

	private String numeroPratica;
	
	private String fraseFinale;	
	private String prestazioneMinima;
	
	private String labelValoreRicattoLordo;
	private String labelValoreRicattoNetto;
	
	private String valoreRiscattoLordo;
	private String valoreRiscattoNetto;
	
	private String dataLiquidazione;
	private String dataValuta;
	
	private String totaleQuote;
	private String totaleControvalute;
	private String totaleValoreRiscatto;
	private String totaleImponibile;
	private String totaleImposta;
		
	private List<PraticaSpiegazioneConteggiRecordTipoLiquidazione2> tabella1;
	private List<PraticaSpiegazioneConteggiRecordTipoLiquidazione4> tabella2;
	private List<PraticaSpiegazioneConteggiRecordTipoLiquidazione1> tabella3;
	private List<PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale> tabella4;
	private List<PraticaSpiegazioneConteggiRecordTipoLiquidazioneOpzionale> tabella5;
    /*Parte relativa alla fiscalita   */
    private Imposta   tabellaRitenutaImposta;
    private Imposta   tabellaImpostaSostitutiva;
	private String   impostaBolloFiscalita;
    /*Fine*/

	private String interessiMoraPolizza;
	private String interessiRitardatoPagamentoPolizza;
	private String eccedenzaPolizza;
	
	private String descrizioneLiquidazione;
	
	/*                20110915              */
	private String totaleValoreRiscattoTermine;
	private String coefficenteRiscattoTermine;
	
	/*                20120217              */
	private String importoNettoTermine;
	private String totaleImportoNettoTermine;
	
	//  CIA 20120608
	private boolean testTotaleImportoNettoTermine;
	
	//valorizzazione data richiesta 20120920
	private String dataRichiesta;

	private double ctvAccantonateCG;
	private double ctvAccantonateCM;
    private double ctvDaInizioAnnoCG;
    private double ctvDaInizioAnnoCM;
	private String descrizioneProdotto;

	private boolean isRiscattoTotale;
	
    public double getCtvAccantonateCG() {
		return ctvAccantonateCG;
	}

    public void setCtvDaInizioAnnoCG(double ctvDaInizioAnnoCG) {
        this.ctvDaInizioAnnoCG = ctvDaInizioAnnoCG;
    }

    public void setCtvDaInizioAnnoCM(double ctvDaInizioAnnoCM) {
        this.ctvDaInizioAnnoCM = ctvDaInizioAnnoCM;
    }

    public double getCtvDaInizioAnnoCG() {
        return ctvDaInizioAnnoCG;
    }

    public double getCtvDaInizioAnnoCM() {
        return ctvDaInizioAnnoCM;
    }

    public void setCtvAccantonateCG(double ctvAccantonateCG) {
		this.ctvAccantonateCG = ctvAccantonateCG;
	}

	public double getCtvAccantonateCM() {
		return ctvAccantonateCM;
	}

	public void setCtvAccantonateCM(double ctvAccantonateCM) {
		this.ctvAccantonateCM = ctvAccantonateCM;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public boolean hasImpostaDiBollo() {
        return haImpostaDiBollo;
    }

    public void setHasImpostaDiBollo(boolean hasImpostaDiBollo) {
        this.haImpostaDiBollo = hasImpostaDiBollo;
    }

    public String getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(String dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public boolean isTestTotaleImportoNettoTermine() {
		return testTotaleImportoNettoTermine;
	}

	public void setTestTotaleImportoNettoTermine(
			boolean testTotaleImportoNettoTermine) {
		this.testTotaleImportoNettoTermine = testTotaleImportoNettoTermine;
	}

	public String getImportoNettoTermine() {
		return importoNettoTermine;
	}

	public void setImportoNettoTermine(String importoNettoTermine) {
		this.importoNettoTermine = importoNettoTermine;
	}

	public String getTotaleImportoNettoTermine() {
		return totaleImportoNettoTermine;
	}

	public void setTotaleImportoNettoTermine(String totaleImportoNettoTermine) {
		this.totaleImportoNettoTermine = totaleImportoNettoTermine;
	}

	/**
	 * Costruttore
	 */
	public PraticaSpiegazioneConteggi() {
	}

	/**
	 * @return the fraseFinale
	 */
	public String getFraseFinale() {
		return fraseFinale;
	}

	/**
	 * @param fraseFinale the fraseFinale to set
	 */
	public void setFraseFinale(String fraseFinale) {
		this.fraseFinale = fraseFinale;
	}

	/**
	 * @return the prestazioneMinima
	 */
	public String getPrestazioneMinima() {
		return prestazioneMinima;
	}

	/**
	 * @param prestazioneMinima the prestazioneMinima to set
	 */
	public void setPrestazioneMinima(String prestazioneMinima) {
		this.prestazioneMinima = prestazioneMinima;
	}

	/**
	 * @return the labelValoreRicattoLordo
	 */
	public String getLabelValoreRicattoLordo() {
		return labelValoreRicattoLordo;
	}

	/**
	 * @param labelValoreRicattoLordo the labelValoreRicattoLordo to set
	 */
	public void setLabelValoreRicattoLordo(String labelValoreRicattoLordo) {
		this.labelValoreRicattoLordo = labelValoreRicattoLordo;
	}

	/**
	 * @return the labelValoreRicattoNetto
	 */
	public String getLabelValoreRicattoNetto() {
		return labelValoreRicattoNetto;
	}

	/**
	 * @param labelValoreRicattoNetto the labelValoreRicattoNetto to set
	 */
	public void setLabelValoreRicattoNetto(String labelValoreRicattoNetto) {
		this.labelValoreRicattoNetto = labelValoreRicattoNetto;
	}

	/**
	 * @return the valoreRiscattoLordo
	 */
	public String getValoreRiscattoLordo() {
		return valoreRiscattoLordo;
	}

	/**
	 * @param valoreRiscattoLordo the valoreRiscattoLordo to set
	 */
	public void setValoreRiscattoLordo(String valoreRiscattoLordo) {
		this.valoreRiscattoLordo = valoreRiscattoLordo;
	}

	/**
	 * @return the valoreRiscattoNetto
	 */
	public String getValoreRiscattoNetto() {
		return valoreRiscattoNetto;
	}

	/**
	 * @param valoreRiscattoNetto the valoreRiscattoNetto to set
	 */
	public void setValoreRiscattoNetto(String valoreRiscattoNetto) {
		this.valoreRiscattoNetto = valoreRiscattoNetto;
	}

	/**
	 * @return the dataLiquidazione
	 */
	public String getDataLiquidazione() {
		return dataLiquidazione;
	}

	/**
	 * @param dataLiquidazione the dataLiquidazione to set
	 */
	public void setDataLiquidazione(String dataLiquidazione) {
		this.dataLiquidazione = dataLiquidazione;
	}

	/**
	 * @return the dataValuta
	 */
	public String getDataValuta() {
		return dataValuta;
	}

	/**
	 * @param dataValuta the dataValuta to set
	 */
	public void setDataValuta(String dataValuta) {
		this.dataValuta = dataValuta;
	}

	/**
	 * @return the tabella1
	 */
	public List<PraticaSpiegazioneConteggiRecordTipoLiquidazione2> getTabella1() {
		return tabella1;
	}

	/**
	 * @param tabella1 the tabella1 to set
	 */
	public void setTabella1(
			List<PraticaSpiegazioneConteggiRecordTipoLiquidazione2> tabella1) {
		this.tabella1 = tabella1;
	}

	/**
	 * @return the tabella2
	 */
	public List<PraticaSpiegazioneConteggiRecordTipoLiquidazione4> getTabella2() {
		return tabella2;
	}

	/**
	 * @param tabella2 the tabella2 to set
	 */
	public void setTabella2(
			List<PraticaSpiegazioneConteggiRecordTipoLiquidazione4> tabella2) {
		this.tabella2 = tabella2;
	}

	/**
	 * @return the tabella3
	 */
	public List<PraticaSpiegazioneConteggiRecordTipoLiquidazione1> getTabella3() {
		return tabella3;
	}

	/**
	 * @param tabella3 the tabella3 to set
	 */
	public void setTabella3(
			List<PraticaSpiegazioneConteggiRecordTipoLiquidazione1> tabella3) {
		this.tabella3 = tabella3;
	}

	/**
	 * @return the tabella4
	 */
	public List<PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale> getTabella4() {
		return tabella4;
	}

	/**
	 * @param tabella4 the tabella4 to set
	 */
	public void setTabella4(
			List<PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale> tabella4) {
		this.tabella4 = tabella4;
	}

	/**
	 * @return the tabella5
	 */
	public List<PraticaSpiegazioneConteggiRecordTipoLiquidazioneOpzionale> getTabella5() {
		return tabella5;
	}

	/**
	 * @param tabella5 the tabella5 to set
	 */
	public void setTabella5(
			List<PraticaSpiegazioneConteggiRecordTipoLiquidazioneOpzionale> tabella5) {
		this.tabella5 = tabella5;
	}

	/**
	 * @param numeroPratica the numeroPratica to set
	 */
	public void setNumeroPratica(String numeroPratica) {
		this.numeroPratica = numeroPratica;
	}

	/**
	 * @return the numeroPratica
	 */
	public String getNumeroPratica() {
		return numeroPratica;
	}

	/**
	 * @return the totaleQuote
	 */
	public String getTotaleQuote() {
		return totaleQuote;
	}

	/**
	 * @param totaleQuote the totaleQuote to set
	 */
	public void setTotaleQuote(String totaleQuote) {
		this.totaleQuote = totaleQuote;
	}

	/**
	 * @return the totaleControvalute
	 */
	public String getTotaleControvalute() {
		return totaleControvalute;
	}

	/**
	 * @param totaleControvalute the totaleControvalute to set
	 */
	public void setTotaleControvalute(String totaleControvalute) {
		this.totaleControvalute = totaleControvalute;
	}

	/**
	 * @return the totaleValoreRiscatto
	 */
	public String getTotaleValoreRiscatto() {
		return totaleValoreRiscatto;
	}

	/**
	 * @param totaleValoreRiscatto the totaleValoreRiscatto to set
	 */
	public void setTotaleValoreRiscatto(String totaleValoreRiscatto) {
		this.totaleValoreRiscatto = totaleValoreRiscatto;
	}

	/**
	 * @return the totaleImponibile
	 */
	public String getTotaleImponibile() {
		return totaleImponibile;
	}

	/**
	 * @param totaleImponibile the totaleImponibile to set
	 */
	public void setTotaleImponibile(String totaleImponibile) {
		this.totaleImponibile = totaleImponibile;
	}

	/**
	 * @return the totaleImposta
	 */
	public String getTotaleImposta() {
		return totaleImposta;
	}

	/**
	 * @param totaleImposta the totaleImposta to set
	 */
	public void setTotaleImposta(String totaleImposta) {
		this.totaleImposta = totaleImposta;
	}

	/**
	 * @return the interessiMoraPolizza
	 */
	public String getInteressiMoraPolizza() {
		return interessiMoraPolizza;
	}

	/**
	 * @param interessiMoraPolizza the interessiMoraPolizza to set
	 */
	public void setInteressiMoraPolizza(String interessiMoraPolizza) {
		this.interessiMoraPolizza = interessiMoraPolizza;
	}

	/**
	 * @return the interessiRitardatoPagamentoPolizza
	 */
	public String getInteressiRitardatoPagamentoPolizza() {
		return interessiRitardatoPagamentoPolizza;
	}

	/**
	 * @param interessiRitardatoPagamentoPolizza the interessiRitardatoPagamentoPolizza to set
	 */
	public void setInteressiRitardatoPagamentoPolizza(
			String interessiRitardatoPagamentoPolizza) {
		this.interessiRitardatoPagamentoPolizza = interessiRitardatoPagamentoPolizza;
	}

	/**
	 * @return the eccedenzaPolizza
	 */
	public String getEccedenzaPolizza() {
		return eccedenzaPolizza;
	}

	/**
	 * @param eccedenzaPolizza the eccedenzaPolizza to set
	 */
	public void setEccedenzaPolizza(String eccedenzaPolizza) {
		this.eccedenzaPolizza = eccedenzaPolizza;
	}
	
	public String getTotaleValoreRiscattoTermine() {
		return totaleValoreRiscattoTermine;
	}
	
	public String getDescrizioneLiquidazione() {
		return descrizioneLiquidazione;
	}

	public void setDescrizioneLiquidazione(String descrizioneLiquidazione) {
		this.descrizioneLiquidazione = descrizioneLiquidazione;
	}

	public void setTotaleValoreRiscattoTermine(String totaleValoreRiscattoTermine) {
		this.totaleValoreRiscattoTermine = totaleValoreRiscattoTermine;
	}
	
	public String getCoefficenteRiscattoTermine() {
		return coefficenteRiscattoTermine;
	}

	public void setCoefficenteRiscattoTermine(String coefficenteRiscattoTermine) {
		this.coefficenteRiscattoTermine = coefficenteRiscattoTermine;
	}

    public String getImpostaBolloFiscalita() {
        return impostaBolloFiscalita;
    }

    public void setImpostaBolloFiscalita(String impostaBolloFiscalita) {
        this.impostaBolloFiscalita = impostaBolloFiscalita;
    }

    public Imposta getTabellaRitenutaImposta() {
        return tabellaRitenutaImposta;
    }

    public void setTabellaRitenutaImposta(Imposta tabellaRitenutaImposta) {
        this.tabellaRitenutaImposta = tabellaRitenutaImposta;
    }

    public Imposta getTabellaImpostaSostitutiva() {
        return tabellaImpostaSostitutiva;
    }

    public void setTabellaImpostaSostitutiva(Imposta tabellaImpostaSostitutiva) {
        this.tabellaImpostaSostitutiva = tabellaImpostaSostitutiva;
    }

	public boolean isRiscattoTotale() {
		return isRiscattoTotale;
	}

	public void setRiscattoTotale(boolean riscattoTotale) {
		isRiscattoTotale = riscattoTotale;
	}
}