package com.fideuram.crm.stampe.engine.modello.bean;

import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.PrivateBanker;

import java.io.Serializable;
import java.util.List;


//import com.fideuram.crm.stampe.engine.modello.bean.tcm.Tcm;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 22/06/11
 * Time: 12.18
 */
public class Polizza implements Serializable{
    //I valori con _ arrivano dall'xml in imput di Nanni

	private static final long    		serialVersionUID = -5664706646404253924L;
	private String          	 		id;
    private String         	 	 		stato;
    private String          	 		tipoFormaAssicurativa;
    private String          	 		codice_conferimento;
    private String          	 		valore_di_riscatto;
    private String          	 		prestazioni_caso_vita;
    private String          	 		prestazioni_caso_morte;
    private String          	 		prestazione_totale_di_rendita_lorda;
       
    private Contraente                  contraente;
    private Assicurato                  primoassicurato;
    private Assicurato      	 		secondoassicurato;
    private PrivateBanker               pb;

    private String          	 		dataRichiesta;
    private String          	 		dataScadenzaPolizza;
     
    private String          	 		dataEmissionePolizza;
    private String          	 		codiceTariffa;
    private String          	 		descrizioneTariffa;
    private String          	 		codiceProdotto;
    private String          	 		descrizioneProdottoCommerciale;
    
    private String 				 		renditaAnnuaVitMinimaGar;
    private String 				 		valoreRiscattoScadGarantito;
    private String 				 		ipotesiRenditaAnnuaPosticipataScadenzaCTV;
    private String 				 		ipotesiValoreRiscattoScadenzaCTV;
    private String 				 		totaleRenditaFrazionataAnnualePosticipata;
    private String 				 		totaleRenditaFrazionataSemestralePosticipata;
    private String 				 		totaleRenditaFrazionataTrimestralePosticipata;
    private String 				 		totaleRenditaFrazionataMensilePosticipata;
    private String 				 		totaleRenditaCerta1AnnualePosticipata;
	private String 				 		totaleRenditaCerta1SemestralePosticipata;
	private String 				 		totaleRenditaCerta1TrimestralePosticipata;
	private String 				 		totaleRenditaCerta1MensilePosticipata;	
	private String 				 		totaleRenditaCerta2AnnualePosticipata;
	private String 				 		totaleRenditaCerta2SemestralePosticipata;
	private String 				 		totaleRenditaCerta2TrimestralePosticipata;
	private String 				 		totaleRenditaCerta2MensilePosticipata;	
	private String 				 		totaleRenditaCerta3AnnualePosticipata;
	private String 				 		totaleRenditaCerta3SemestralePosticipata;
	private String 				 		totaleRenditaCerta3TrimestralePosticipata;
	private String 				 		totaleRenditaCerta3MensilePosticipata;	
	private String 				 		totaleRenditaCerta4AnnualePosticipata;
	private String 				 		totaleRenditaCerta4SemestralePosticipata;
	private String 				 		totaleRenditaCerta4TrimestralePosticipata;
	private String 				 		totaleRenditaCerta4MensilePosticipata;
	private String          	 		dataRiferimentoNav;
	private String          	 		numeroQuote;
	private String 				 		controvaloreQuote;
	private String          	 		tipoPrestazione;
	private String          	 		ramoMinisteriale;
	
	private boolean         	 		controlloCertezza;
	
	private String          			data_riferimento_nav;
	private String          	 		premi_incassati_pa;
	private String          	 		premi_incassati_pu;
	private String          	 		prestazione_minima_garantita;
	private String          	 		proiezione_al_nav_odierno;
	private String          	 		premi_incassati;
	//fuffa
	private String          	 		renditaAnnuaVitaliziaMinimaGarantita;
	private String          	 		valoreRiscattoScadenzaMinGarantito;
	private String          	 		quote;
	private String          	 		ipotesiControvaloreQuoteNav;
	private String          	 		ipotesiDiValoreRiscattoScadenza;
	private String          	 		ipotesiRenditaAnnuaPosticipataScadenza;
	private String          	 		valoreRiscattoScadenzaNav;
    private String          	 		premiVersatiNav;
    private String               		descPremiVersatiNav;
   
    private String               		note;
    
    private String               		prestazioneTotaleDiRenditaLorda;
    private String               		valoreRiscattoLordo;
    
    private String               		eccedenza;
    
    private PrestazioniScadenza  		prestazioniScadenza;
    
    private DatiPolizza          		datiPolizza;
    
    private Pratica              		pratica;
    
    private boolean              		controlloDisinvestimento;
    
    private Disinvestimento      		disinvestimento;
    
    private List<Pagamento>      		listPagamento; 
    
    private OpzioneFrazionamento 		opzioneFrazionamento;
    
    private List<Certezza>       		listCertezza;
    
    private AvvisiScadenzaSPI    		avvisiScadenzaSPI;
    
    private SimulazioniSPI       		simulazioniSPI;
    
    private SpiegazioneConteggiLiqSPI 	spiegazioneConteggiLiqSPI;
    
    private String 						valoreRiscattoNetto;
    
    private String                     	anniCertezza;
    
    private String                      dataRichiestaStampa;
    
    private String                      reteVendita;
    
    private RiscattoParzialeTendenza    riscattoParzialeTendenza;
    
    private Decumulo                    decumulo;
    
    private Boolean                     isPrevidenza;//switch per il tipo di template
    

    
	public Boolean getIsPrevidenza() {
		return isPrevidenza;
	}

	public void setIsPrevidenza(Boolean isPrevidenza) {
		this.isPrevidenza = isPrevidenza;
	}

	public Decumulo getDecumulo() {
		return decumulo;
	}

	public void setDecumulo(Decumulo decumulo) {
		this.decumulo = decumulo;
	}

	public RiscattoParzialeTendenza getRiscattoParzialeTendenza() {
		return riscattoParzialeTendenza;
	}

	public void setRiscattoParzialeTendenza(
			RiscattoParzialeTendenza riscattoParzialeTendenza) {
		this.riscattoParzialeTendenza = riscattoParzialeTendenza;
	}

	public String getReteVendita() {
		return reteVendita;
	}

	public void setReteVendita(String reteVendita) {
		this.reteVendita = reteVendita;
	}

	public String getDataRichiestaStampa() {
		return dataRichiestaStampa;
	}

	public void setDataRichiestaStampa(String dataRichiestaStampa) {
		this.dataRichiestaStampa = dataRichiestaStampa;
	}

	public String getAnniCertezza() {
		return anniCertezza;
	}

	public void setAnniCertezza(String anniCertezza) {
		this.anniCertezza = anniCertezza;
	}

	public String getValoreRiscattoNetto() {
		return valoreRiscattoNetto;
	}

	public void setValoreRiscattoNetto(String valoreRiscattoNetto) {
		this.valoreRiscattoNetto = valoreRiscattoNetto;
	}

	public SpiegazioneConteggiLiqSPI getSpiegazioneConteggiLiqSPI() {
		return spiegazioneConteggiLiqSPI;
	}

	public void setSpiegazioneConteggiLiqSPI(
			SpiegazioneConteggiLiqSPI spiegazioneConteggiLiqSPI) {
		this.spiegazioneConteggiLiqSPI = spiegazioneConteggiLiqSPI;
	}

	public SimulazioniSPI getSimulazioniSPI() {
		return simulazioniSPI;
	}

	public void setSimulazioniSPI(SimulazioniSPI simulazioniSPI) {
		this.simulazioniSPI = simulazioniSPI;
	}

	public AvvisiScadenzaSPI getAvvisiScadenzaSPI() {
		return avvisiScadenzaSPI;
	}

	public void setAvvisiScadenzaSPI(AvvisiScadenzaSPI avvisiScadenzaSPI) {
		this.avvisiScadenzaSPI = avvisiScadenzaSPI;
	}


	public String getEccedenza() {
		return eccedenza;
	}

	public void setEccedenza(String eccedenza) {
		this.eccedenza = eccedenza;
	}


	public List<Certezza> getListCertezza() {
		return listCertezza;
	}

	public void setListCertezza(List<Certezza> listCertezza) {
		this.listCertezza = listCertezza;
	}

	public OpzioneFrazionamento getOpzioneFrazionamento() {
		return opzioneFrazionamento;
	}

	public void setOpzioneFrazionamento(OpzioneFrazionamento opzioneFrazionamento) {
		this.opzioneFrazionamento = opzioneFrazionamento;
	}
	
	public String getDescPremiVersatiNav() {
		return descPremiVersatiNav;
	}

	public void setDescPremiVersatiNav(String descPremiVersatiNav) {
		this.descPremiVersatiNav = descPremiVersatiNav;
	}

	public boolean isControlloDisinvestimento() {
		return controlloDisinvestimento;
	}

	public void setControlloDisinvestimento(boolean controlloDisinvestimento) {
		this.controlloDisinvestimento = controlloDisinvestimento;
	}

	public List<Pagamento> getListPagamento() {
		return listPagamento;
	}

	public void setListPagamento(List<Pagamento> listPagamento) {
		this.listPagamento = listPagamento;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public Disinvestimento getDisinvestimento() {
		return disinvestimento;
	}

	public void setDisinvestimento(Disinvestimento disinvestimento) {
		this.disinvestimento = disinvestimento;
	}

	public DatiPolizza getDatiPolizza() {
		return datiPolizza;
	}

	public void setDatiPolizza(DatiPolizza datiPolizza) {
		this.datiPolizza = datiPolizza;
	}

	public PrestazioniScadenza getPrestazioniScadenza() {
		return prestazioniScadenza;
	}

	public void setPrestazioniScadenza(PrestazioniScadenza prestazioniScadenza) {
		this.prestazioniScadenza = prestazioniScadenza;
	}

	/*
    private Node            valoreRiscattoScadenzaMinGarantito;
    
   
	public Node getValoreRiscattoScadenzaMinGarantito() {
		return valoreRiscattoScadenzaMinGarantito;
	}

	public void setValoreRiscattoScadenzaMinGarantito(
			Node valoreRiscattoScadenzaMinGarantito) {
		this.valoreRiscattoScadenzaMinGarantito = valoreRiscattoScadenzaMinGarantito;
	}
	*/
	public String getPrestazioneTotaleDiRenditaLorda() {
		return prestazioneTotaleDiRenditaLorda;
	}

	public void setPrestazioneTotaleDiRenditaLorda(
			String prestazioneTotaleDiRenditaLorda) {
		this.prestazioneTotaleDiRenditaLorda = prestazioneTotaleDiRenditaLorda;
	}

	public String getValoreRiscattoLordo() {
		return valoreRiscattoLordo;
	}

	public void setValoreRiscattoLordo(String valoreRiscattoLordo) {
		this.valoreRiscattoLordo = valoreRiscattoLordo;
	}

	public String getRamoMinisteriale() {
		return ramoMinisteriale;
	}

	public void setRamoMinisteriale(String ramoMinisteriale) {
		this.ramoMinisteriale = ramoMinisteriale;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getValoreRiscattoScadenzaNav() {
		return valoreRiscattoScadenzaNav;
	}

	public void setValoreRiscattoScadenzaNav(String valoreRiscattoScadenzaNav) {
		this.valoreRiscattoScadenzaNav = valoreRiscattoScadenzaNav;
	}

	public String getRenditaAnnuaVitaliziaMinimaGarantita() {
		return renditaAnnuaVitaliziaMinimaGarantita;
	}

	public void setRenditaAnnuaVitaliziaMinimaGarantita(
			String renditaAnnuaVitaliziaMinimaGarantita) {
		this.renditaAnnuaVitaliziaMinimaGarantita = renditaAnnuaVitaliziaMinimaGarantita;
	}
	
	public String getValoreRiscattoScadenzaMinGarantito() {
		return valoreRiscattoScadenzaMinGarantito;
	}

	public void setValoreRiscattoScadenzaMinGarantito(
			String valoreRiscattoScadenzaMinGarantito) {
		this.valoreRiscattoScadenzaMinGarantito = valoreRiscattoScadenzaMinGarantito;
	}
	
	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getIpotesiControvaloreQuoteNav() {
		return ipotesiControvaloreQuoteNav;
	}

	public void setIpotesiControvaloreQuoteNav(String ipotesiControvaloreQuoteNav) {
		this.ipotesiControvaloreQuoteNav = ipotesiControvaloreQuoteNav;
	}

	public String getIpotesiDiValoreRiscattoScadenza() {
		return ipotesiDiValoreRiscattoScadenza;
	}

	public void setIpotesiDiValoreRiscattoScadenza(
			String ipotesiDiValoreRiscattoScadenza) {
		this.ipotesiDiValoreRiscattoScadenza = ipotesiDiValoreRiscattoScadenza;
	}

	public String getIpotesiRenditaAnnuaPosticipataScadenza() {
		return ipotesiRenditaAnnuaPosticipataScadenza;
	}

	public void setIpotesiRenditaAnnuaPosticipataScadenza(
			String ipotesiRenditaAnnuaPosticipataScadenza) {
		this.ipotesiRenditaAnnuaPosticipataScadenza = ipotesiRenditaAnnuaPosticipataScadenza;
	}

	public String getPremiVersatiNav() {
		return premiVersatiNav;
	}

	public void setPremiVersatiNav(String premiVersatiNav) {
		this.premiVersatiNav = premiVersatiNav;
	}

	public String getData_riferimento_nav() {
		return data_riferimento_nav;
	}

	public void setData_riferimento_nav(String data_riferimento_nav) {
		this.data_riferimento_nav = data_riferimento_nav;
	}

	public String getPremi_incassati_pa() {
		return premi_incassati_pa;
	}

	public void setPremi_incassati_pa(String premi_incassati_pa) {
		this.premi_incassati_pa = premi_incassati_pa;
	}

	public String getPremi_incassati_pu() {
		return premi_incassati_pu;
	}

	public void setPremi_incassati_pu(String premi_incassati_pu) {
		this.premi_incassati_pu = premi_incassati_pu;
	}

	public String getPrestazione_minima_garantita() {
		return prestazione_minima_garantita;
	}

	public void setPrestazione_minima_garantita(String prestazione_minima_garantita) {
		this.prestazione_minima_garantita = prestazione_minima_garantita;
	}

	public String getProiezione_al_nav_odierno() {
		return proiezione_al_nav_odierno;
	}

	public void setProiezione_al_nav_odierno(String proiezione_al_nav_odierno) {
		this.proiezione_al_nav_odierno = proiezione_al_nav_odierno;
	}

	public String getPremi_incassati() {
		return premi_incassati;
	}

	public void setPremi_incassati(String premi_incassati) {
		this.premi_incassati = premi_incassati;
	}

	public boolean isControlloCertezza() {
		return controlloCertezza;
	}

	public void setControlloCertezza(boolean controlloCertezza) {
		this.controlloCertezza = controlloCertezza;
	}

	public String getTipoPrestazione() {
		return tipoPrestazione;
	}

	public void setTipoPrestazione(String tipoPrestazione) {
		this.tipoPrestazione = tipoPrestazione;
	}

	public String getDataRiferimentoNav() {
		return dataRiferimentoNav;
	}

	public void setDataRiferimentoNav(String dataRiferimentoNav) {
		this.dataRiferimentoNav = dataRiferimentoNav;
	}

	public String getNumeroQuote() {
		return numeroQuote;
	}

	public void setNumeroQuote(String numeroQuote) {
		this.numeroQuote = numeroQuote;
	}

	public String getControvaloreQuote() {
		return controvaloreQuote;
	}

	public void setControvaloreQuote(String controvaloreQuote) {
		this.controvaloreQuote = controvaloreQuote;
	}

	public String getRenditaAnnuaVitMinimaGar() {
		return renditaAnnuaVitMinimaGar;
	}

	public void setRenditaAnnuaVitMinimaGar(String renditaAnnuaVitMinimaGar) {
		this.renditaAnnuaVitMinimaGar = renditaAnnuaVitMinimaGar;
	}

	public String getValoreRiscattoScadGarantito() {
		return valoreRiscattoScadGarantito;
	}

	public void setValoreRiscattoScadGarantito(String valoreRiscattoScadGarantito) {
		this.valoreRiscattoScadGarantito = valoreRiscattoScadGarantito;
	}

	public String getIpotesiRenditaAnnuaPosticipataScadenzaCTV() {
		return ipotesiRenditaAnnuaPosticipataScadenzaCTV;
	}

	public void setIpotesiRenditaAnnuaPosticipataScadenzaCTV(
			String ipotesiRenditaAnnuaPosticipataScadenzaCTV) {
		this.ipotesiRenditaAnnuaPosticipataScadenzaCTV = ipotesiRenditaAnnuaPosticipataScadenzaCTV;
	}

	public String getIpotesiValoreRiscattoScadenzaCTV() {
		return ipotesiValoreRiscattoScadenzaCTV;
	}

	public void setIpotesiValoreRiscattoScadenzaCTV(
			String ipotesiValoreRiscattoScadenzaCTV) {
		this.ipotesiValoreRiscattoScadenzaCTV = ipotesiValoreRiscattoScadenzaCTV;
	}

	public String getTotaleRenditaFrazionataAnnualePosticipata() {
		return totaleRenditaFrazionataAnnualePosticipata;
	}

	public void setTotaleRenditaFrazionataAnnualePosticipata(
			String totaleRenditaFrazionataAnnualePosticipata) {
		this.totaleRenditaFrazionataAnnualePosticipata = totaleRenditaFrazionataAnnualePosticipata;
	}

	public String getTotaleRenditaFrazionataSemestralePosticipata() {
		return totaleRenditaFrazionataSemestralePosticipata;
	}

	public void setTotaleRenditaFrazionataSemestralePosticipata(
			String totaleRenditaFrazionataSemestralePosticipata) {
		this.totaleRenditaFrazionataSemestralePosticipata = totaleRenditaFrazionataSemestralePosticipata;
	}

	public String getTotaleRenditaFrazionataTrimestralePosticipata() {
		return totaleRenditaFrazionataTrimestralePosticipata;
	}

	public void setTotaleRenditaFrazionataTrimestralePosticipata(
			String totaleRenditaFrazionataTrimestralePosticipata) {
		this.totaleRenditaFrazionataTrimestralePosticipata = totaleRenditaFrazionataTrimestralePosticipata;
	}

	public String getTotaleRenditaFrazionataMensilePosticipata() {
		return totaleRenditaFrazionataMensilePosticipata;
	}

	public void setTotaleRenditaFrazionataMensilePosticipata(
			String totaleRenditaFrazionataMensilePosticipata) {
		this.totaleRenditaFrazionataMensilePosticipata = totaleRenditaFrazionataMensilePosticipata;
	}

	public String getTotaleRenditaCerta1AnnualePosticipata() {
		return totaleRenditaCerta1AnnualePosticipata;
	}

	public void setTotaleRenditaCerta1AnnualePosticipata(
			String totaleRenditaCerta1AnnualePosticipata) {
		this.totaleRenditaCerta1AnnualePosticipata = totaleRenditaCerta1AnnualePosticipata;
	}

	public String getTotaleRenditaCerta1SemestralePosticipata() {
		return totaleRenditaCerta1SemestralePosticipata;
	}

	public void setTotaleRenditaCerta1SemestralePosticipata(
			String totaleRenditaCerta1SemestralePosticipata) {
		this.totaleRenditaCerta1SemestralePosticipata = totaleRenditaCerta1SemestralePosticipata;
	}

	public String getTotaleRenditaCerta1TrimestralePosticipata() {
		return totaleRenditaCerta1TrimestralePosticipata;
	}

	public void setTotaleRenditaCerta1TrimestralePosticipata(
			String totaleRenditaCerta1TrimestralePosticipata) {
		this.totaleRenditaCerta1TrimestralePosticipata = totaleRenditaCerta1TrimestralePosticipata;
	}

	public String getTotaleRenditaCerta1MensilePosticipata() {
		return totaleRenditaCerta1MensilePosticipata;
	}

	public void setTotaleRenditaCerta1MensilePosticipata(
			String totaleRenditaCerta1MensilePosticipata) {
		this.totaleRenditaCerta1MensilePosticipata = totaleRenditaCerta1MensilePosticipata;
	}

	public String getTotaleRenditaCerta2AnnualePosticipata() {
		return totaleRenditaCerta2AnnualePosticipata;
	}

	public void setTotaleRenditaCerta2AnnualePosticipata(
			String totaleRenditaCerta2AnnualePosticipata) {
		this.totaleRenditaCerta2AnnualePosticipata = totaleRenditaCerta2AnnualePosticipata;
	}

	public String getTotaleRenditaCerta2SemestralePosticipata() {
		return totaleRenditaCerta2SemestralePosticipata;
	}

	public void setTotaleRenditaCerta2SemestralePosticipata(
			String totaleRenditaCerta2SemestralePosticipata) {
		this.totaleRenditaCerta2SemestralePosticipata = totaleRenditaCerta2SemestralePosticipata;
	}

	public String getTotaleRenditaCerta2TrimestralePosticipata() {
		return totaleRenditaCerta2TrimestralePosticipata;
	}

	public void setTotaleRenditaCerta2TrimestralePosticipata(
			String totaleRenditaCerta2TrimestralePosticipata) {
		this.totaleRenditaCerta2TrimestralePosticipata = totaleRenditaCerta2TrimestralePosticipata;
	}

	public String getTotaleRenditaCerta2MensilePosticipata() {
		return totaleRenditaCerta2MensilePosticipata;
	}

	public void setTotaleRenditaCerta2MensilePosticipata(
			String totaleRenditaCerta2MensilePosticipata) {
		this.totaleRenditaCerta2MensilePosticipata = totaleRenditaCerta2MensilePosticipata;
	}

	public String getTotaleRenditaCerta3AnnualePosticipata() {
		return totaleRenditaCerta3AnnualePosticipata;
	}

	public void setTotaleRenditaCerta3AnnualePosticipata(
			String totaleRenditaCerta3AnnualePosticipata) {
		this.totaleRenditaCerta3AnnualePosticipata = totaleRenditaCerta3AnnualePosticipata;
	}

	public String getTotaleRenditaCerta3SemestralePosticipata() {
		return totaleRenditaCerta3SemestralePosticipata;
	}

	public void setTotaleRenditaCerta3SemestralePosticipata(
			String totaleRenditaCerta3SemestralePosticipata) {
		this.totaleRenditaCerta3SemestralePosticipata = totaleRenditaCerta3SemestralePosticipata;
	}

	public String getTotaleRenditaCerta3TrimestralePosticipata() {
		return totaleRenditaCerta3TrimestralePosticipata;
	}

	public void setTotaleRenditaCerta3TrimestralePosticipata(
			String totaleRenditaCerta3TrimestralePosticipata) {
		this.totaleRenditaCerta3TrimestralePosticipata = totaleRenditaCerta3TrimestralePosticipata;
	}

	public String getTotaleRenditaCerta3MensilePosticipata() {
		return totaleRenditaCerta3MensilePosticipata;
	}

	public void setTotaleRenditaCerta3MensilePosticipata(
			String totaleRenditaCerta3MensilePosticipata) {
		this.totaleRenditaCerta3MensilePosticipata = totaleRenditaCerta3MensilePosticipata;
	}

	public String getTotaleRenditaCerta4AnnualePosticipata() {
		return totaleRenditaCerta4AnnualePosticipata;
	}

	public void setTotaleRenditaCerta4AnnualePosticipata(
			String totaleRenditaCerta4AnnualePosticipata) {
		this.totaleRenditaCerta4AnnualePosticipata = totaleRenditaCerta4AnnualePosticipata;
	}

	public String getTotaleRenditaCerta4SemestralePosticipata() {
		return totaleRenditaCerta4SemestralePosticipata;
	}

	public void setTotaleRenditaCerta4SemestralePosticipata(
			String totaleRenditaCerta4SemestralePosticipata) {
		this.totaleRenditaCerta4SemestralePosticipata = totaleRenditaCerta4SemestralePosticipata;
	}

	public String getTotaleRenditaCerta4TrimestralePosticipata() {
		return totaleRenditaCerta4TrimestralePosticipata;
	}

	public void setTotaleRenditaCerta4TrimestralePosticipata(
			String totaleRenditaCerta4TrimestralePosticipata) {
		this.totaleRenditaCerta4TrimestralePosticipata = totaleRenditaCerta4TrimestralePosticipata;
	}

	public String getTotaleRenditaCerta4MensilePosticipata() {
		return totaleRenditaCerta4MensilePosticipata;
	}

	public void setTotaleRenditaCerta4MensilePosticipata(
			String totaleRenditaCerta4MensilePosticipata) {
		this.totaleRenditaCerta4MensilePosticipata = totaleRenditaCerta4MensilePosticipata;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getTipoFormaAssicurativa() {
        return tipoFormaAssicurativa;
    }

    public void setTipoFormaAssicurativa(String tipoFormaAssicurativa) {
        this.tipoFormaAssicurativa = tipoFormaAssicurativa;
    }

    public String getCodice_conferimento() {
        return codice_conferimento;
    }

    public void setCodice_conferimento(String codice_conferimento) {
        this.codice_conferimento = codice_conferimento;
    }

    public String getValore_di_riscatto() {
        return valore_di_riscatto;
    }

    public void setValore_di_riscatto(String valore_di_riscatto) {
        this.valore_di_riscatto = valore_di_riscatto;
    }

    public String getPrestazioni_caso_vita() {
        return prestazioni_caso_vita;
    }

    public void setPrestazioni_caso_vita(String prestazioni_caso_vita) {
        this.prestazioni_caso_vita = prestazioni_caso_vita;
    }

    public String getPrestazioni_caso_morte() {
        return prestazioni_caso_morte;
    }

    public void setPrestazioni_caso_morte(String prestazioni_caso_morte) {
        this.prestazioni_caso_morte = prestazioni_caso_morte;
    }

    public Contraente getContraente() {
        return contraente;
    }

    public void setContraente(Contraente contraente) {
        this.contraente = contraente;
    }

    public Assicurato getPrimoassicurato() {
        return primoassicurato;
    }

    public void setPrimoassicurato(Assicurato primoassicurato) {
        this.primoassicurato = primoassicurato;
    }

    public Assicurato getSecondoassicurato() {
        return secondoassicurato;
    }

    public void setSecondoassicurato(Assicurato secondoassicurato) {
        this.secondoassicurato = secondoassicurato;
    }

    public PrivateBanker getPb() {
        return pb;
    }

    public void setPb(PrivateBanker pb) {
        this.pb = pb;
    }

    public String getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(String dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getDataScadenzaPolizza() {
        return dataScadenzaPolizza;
    }

    public void setDataScadenzaPolizza(String dataScadenzaPolizza) {
        this.dataScadenzaPolizza = dataScadenzaPolizza;
    }

    public String getPrestazione_totale_di_rendita_lorda() {
        return prestazione_totale_di_rendita_lorda;
    }

    public void setPrestazione_totale_di_rendita_lorda(String prestazione_totale_di_rendita_lorda) {
        this.prestazione_totale_di_rendita_lorda = prestazione_totale_di_rendita_lorda;
    }

	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getCodiceTariffa() {
		return codiceTariffa;
	}

	public void setCodiceTariffa(String codiceTariffa) {
		this.codiceTariffa = codiceTariffa;
	}

	public String getDescrizioneTariffa() {
		return descrizioneTariffa;
	}

	public void setDescrizioneTariffa(String descrizioneTariffa) {
		this.descrizioneTariffa = descrizioneTariffa;
	}

	public String getDataEmissionePolizza() {
		return dataEmissionePolizza;
	}

	public void setDataEmissionePolizza(String dataEmissionePolizza) {
		this.dataEmissionePolizza = dataEmissionePolizza;
	}

	public String getDescrizioneProdottoCommerciale() {
		return descrizioneProdottoCommerciale;
	}

	public void setDescrizioneProdottoCommerciale(
			String descrizioneProdottoCommerciale) {
		this.descrizioneProdottoCommerciale = descrizioneProdottoCommerciale;
	}
	
	
}