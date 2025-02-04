package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI;

import com.fideuram.crm.stampe.model.Imposta;

public class SpiegazioneConteggiRamoI {
	private String numeroPolizza;
	private String numeroPratica;
	private String descrizioneLiquidazione;
	private String contraente;
	private String assicurato;
	private String codicePratica;	
	private String dataRichiesta;
	
	private TipoPraticaRiscatto tipoPraticaRiscatto;
	private TipoPraticaScadenza tipoPraticaScadenza;
	private TipoPraticaSinistro tipoPraticaSinistro;

    /*Parte relativa alla fiscalita   */
    private Imposta tabellaRitenutaImposta;
    private Imposta   tabellaImpostaSostitutiva;
    private String   impostaBolloFiscalita;
    /*Fine*/
	
	public String getNumeroPolizza() {
		return numeroPolizza;
	}
	public void setNumeroPolizza(String numeroPolizza) {
		this.numeroPolizza = numeroPolizza;
	}
	public String getNumeroPratica() {
		return numeroPratica;
	}
	public void setNumeroPratica(String numeroPratica) {
		this.numeroPratica = numeroPratica;
	}
	public String getDescrizioneLiquidazione() {
		return descrizioneLiquidazione;
	}
	public void setDescrizioneLiquidazione(String descrizioneLiquidazione) {
		this.descrizioneLiquidazione = descrizioneLiquidazione;
	}
	public String getContraente() {
		return contraente;
	}
	public void setContraente(String contraente) {
		this.contraente = contraente;
	}
	public String getAssicurato() {
		return assicurato;
	}
	public void setAssicurato(String assicurato) {
		this.assicurato = assicurato;
	}
	public String getCodicePratica() {
		return codicePratica;
	}
	public void setCodicePratica(String codicePratica) {
		this.codicePratica = codicePratica;
	}
	
	public String getDataRichiesta() {
		return dataRichiesta;
	}
	public void setDataRichiesta(String dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public TipoPraticaRiscatto getTipoPraticaRiscatto() {
		return tipoPraticaRiscatto;
	}
	public void setTipoPraticaRiscatto(TipoPraticaRiscatto tipoPraticaRiscatto) {
		this.tipoPraticaRiscatto = tipoPraticaRiscatto;
	}
	public TipoPraticaScadenza getTipoPraticaScadenza() {
		return tipoPraticaScadenza;
	}
	public void setTipoPraticaScadenza(TipoPraticaScadenza tipoPraticaScadenza) {
		this.tipoPraticaScadenza = tipoPraticaScadenza;
	}
	public TipoPraticaSinistro getTipoPraticaSinistro() {
		return tipoPraticaSinistro;
	}
	public void setTipoPraticaSinistro(TipoPraticaSinistro tipoPraticaSinistro) {
		this.tipoPraticaSinistro = tipoPraticaSinistro;
	}

    public Imposta getTabellaRitenutaImposta() {
        return tabellaRitenutaImposta;
    }

    public void setTabellaRitenutaImposta(Imposta tabellaRitenutaImposta) {
        this.tabellaRitenutaImposta = tabellaRitenutaImposta;
    }

    public String getImpostaBolloFiscalita() {
        return impostaBolloFiscalita;
    }

    public void setImpostaBolloFiscalita(String impostaBolloFiscalita) {
        this.impostaBolloFiscalita = impostaBolloFiscalita;
    }

    public Imposta getTabellaImpostaSostitutiva() {
        return tabellaImpostaSostitutiva;
    }

    public void setTabellaImpostaSostitutiva(Imposta tabellaImpostaSostitutiva) {
        this.tabellaImpostaSostitutiva = tabellaImpostaSostitutiva;
    }
}