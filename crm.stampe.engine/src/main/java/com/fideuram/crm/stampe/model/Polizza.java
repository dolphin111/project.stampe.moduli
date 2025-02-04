package com.fideuram.crm.stampe.model;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.SpiegazioneConteggiRamoI;
import com.fideuram.crm.stampe.model.vospolizza.prestazioni.PrestazioneBase;
import com.fideuram.crm.stampe.model.vospolizza.rendita.Certezza;
import com.fideuram.crm.stampe.model.vospolizza.rendita.IpotesiRendita;
import com.fideuram.crm.stampe.model.vospolizza.reversibilita.R3_ReversibilitaVo;
import com.fideuram.crm.stampe.model.vospolizza.reversibilita.Reversibilita;
import com.fideuram.puc.service.impl.BeneficiarioLiquidazioneVO;
import com.fideuram.puc.service.impl.CaricamentiCppVORamoIII;
import com.fideuram.puc.service.impl.DettaglioLiquidazionePrestazionePensionisticaVO;
import com.fideuram.puc.service.impl.EstrattoContoCollettiveVO;
import com.fideuram.stampe.bean.commissioni.CommissioniFondiEsterni;
import com.fideuram.stampe.bean.polizza.collettiva.EstrattoConto;
import com.fideuram.stampe.bean.pratiche.SospensioneScadenza;
import com.fideuram.stampe.bean.prestito.Prestito;
import com.fideuram.stampe.bean.riscatto.RiscattoParziale;
import com.fideuram.stampe.bean.riscatto.RiscattoTotale;
import com.fideuram.stampe.bean.riscatto.Scadenza;
import com.fideuram.stampe.bean.simulatori.Simulazione;
import com.fideuram.utils.LoggingUtils;

public class Polizza {
    private Simulazione simulazione;                              //Usato da <SIMULATORE VALORE ALLA DATA>
    private SospensioneScadenza sospensioneScadenza;
    private String dataScadenzaOriginaria;
    private long macroFamiglia; //1= FVI; 2=Garanzia e Valore
    private boolean voglioLePrestazioniAssicurate;
    private boolean collettiva;
    private EstrattoConto estrattoConto;

    private RiscattoParziale riscattoParziale;
    private RiscattoTotale riscattoTotale;
	private Scadenza scadenza;
    private Prestito valorePrestito;
    private CommissioniFondiEsterni commissioniFondiEsterni;

    //OPZIONI R3
    private R3_ReversibilitaVo reversibilitaTP;
    private R3_ReversibilitaVo reversibilitaTS;

    private PrestazioneBase prestazioni;
    private IpotesiRendita rendita;
    private Reversibilita reversibilita;
    private Long primoDifferimento;
    //--------------
    private String prodottoGarantito;
    private String situazionePremiQuote;
	private String numero;
	private String descrizioneCommerciale;
	private String codiceTariffa;
	private String descrizioneTariffa;
	private String tipoPrestazione;
	private String tipoFormaAssicurazione;
	private String descrizioneFondoSintetica;
	private String tipo;
	private String conferimento;  

	private String stato;
	private String sottostato;
	private String statoDT;
	private String codiceSottostato;
	private String dataDecorrenza;
	private String dataEmissione;
	private String dataFineDifferimento;
	private String dataLiquidazione;
	private Persona contraente;
	private Persona assicurato;
	private String dataScadenza;
	private String labelDataScadenza;
	private String ramoMinisteriale;
	private String eccedenza;
	private String riservaMatematica;
	private String dataRiferimentoQuote;
	private String controvaloreQuote;
	private PrivateBanker privateBanker;
	private List<Polizza> polizzeProvenienza;
	private boolean praticheAperte;
	private String codiceIngressoBase;
	private String codiceIngresso;

	private String reteVendita;
	private String classe;
	private String codiceFondo;
	private String codicePremio;
	private String codiceGruppo;
	private Persona beneficiario;
	private String beneficiarioVita;
	private String beneficiarioMorte;
	private boolean trasformata;
	private String premiUnici;
	private String premiAnnui;
	private String premiDaIncassare;
	private String dataPremiDaIncassare;
	private String dataUltimaRataPagata;
	private String dataErogazioneRendita;
	private String dataUltimaRivalutazioneFineDifferimento;
	private String dataUltimaRivalutazioneSistema;
	private String dataRicorrenza75;
	private String dataRicorrenza80;
	private String dataRicorrenza85;
	private boolean controassicurazione;
	private boolean vincoloPegno;
	private String tassoIsvap;
	
	private String decumuloAttivo;
	private String vincolo;
	private String detraibilitaFiscale;
	private String polizzaScudata;
	private String isVariazioneContrattuale;
	private String riallocazioneGuidata;
	private double imponibileCongelamento;
	private double importoPianoProgrammatoVersamenti;
	private double impostaBolloMaturata;
	private String tipoClasseBonus;
	
	private double massimoValoreUl;

	//importi
	private String importoCasoMorteRivalutato;
	private String importoPrestazioniVita;
	private String massimaleInfortunio;
	private String massimaleMalattia;
	private String capitaleMorteInfortunio;
	private String capitaleMorteInfortunioStradale;
	private String capitaleMalattiaGrave;
	private String capitaleSecondoDecesso;
	private String importoBonus; 
	private String renditaGarantita75;
	private String tipoLineaInvestimento;
	
	


    public String getTipoLineaInvestimento() {
		return tipoLineaInvestimento;
	}

	public void setTipoLineaInvestimento(String tipoLineaInvestimento) {
		this.tipoLineaInvestimento = tipoLineaInvestimento;
	}

    public Simulazione getSimulazione() {
        return simulazione!=null?simulazione:new Simulazione();
    }

    public void setSimulazione(Simulazione simulazione) {
        this.simulazione = simulazione;
    }

    public String getTotalePrestazioniCV() {
        return totalePrestazioniCV;
    }

    public void setTotalePrestazioniCV(String totalePrestazioniCV) {
        this.totalePrestazioniCV = totalePrestazioniCV;
    }

    private String renditaGarantita80;
	private String renditaGarantita85;
    private String totalePrestazioniCV;

	private List<Liquidazione> liquidazioni;
	private List<BeneficiarioLiquidazioneVO> beneficiari;
	private List<BeneficiariLiquidazione> listBeneficiari;
	private List<Titolo> listaTitoli;
	private List<CoefficienteCpp> listaCoefficientiCpp;
	private List<CaricamentiCppVORamoIII> listaCaricamentiCppVORamoIII;	
	private List<PraticaSpiegazioneConteggi> listaPraticheConteggi;
	
	private Map<String, String> attributi = new HashMap<String, String>();
	private Map<String, String> tronconi = new HashMap<String, String>();

	private String scenario;
	
	//DATI PER LE POLIZZE SPI
    //private Long numeroPolizza;
	private String divisa;
	private String prodotto;
	private String tariffa;

	private String dataNascitaAssicurato;
	private String sesso;
	private String dataRivalutazione;
	private String renditaDaPiano;
	private String renditaDaEstemporanei;
	private String tassoLordoRivalutazione;
	private String tassoNettoRivalutazione;
	private String bonusFedelta;
	private String bonusExtra;
	private String totaleRendita;
	private String coefficienteCapitale;
	private String capitaleLordoInValuta;
	private String cambioInEuro;
	private String capitaleLordoInEuro;
	private String premiVersatiInEuro;
	private String renditaTrimestrale;
	private String renditaSemestrale;
    private String renditaCerta5Anni;
    private String renditaCerta10Anni;
	private String guadagno;

    //SIMULAZIONI SPI
    private String prestazioneGarantitaAllUltimaRivalutazione;
    private String premiVersatiAdOggiInEuro;
    private String rivalutazioneMinimaGarantita;
    private String stimaTotaleRenditaAScadenza;
    private String stimaRenditaDaPianoAScadenza;
    private String capitaleLordo;
    private String sommaPremiResiduiDaVersare;
    private String stimaRenditaDaEstemporaneiAScadenza;
    private String stimaRenditaDaEstemporaneiAScadenza2;
   	private String renditaTrimestrale2;
    private String renditaSemestrale2;
    private String renditaCerta5Anni2;
    private String renditaCerta10Anni2;
    private String capitaleLordo2;
    private boolean isCompletato;
	
	private String premiAggiuntiviVersatiAdOggi;
	
	//AVVISI SCADENZA SPI
	private String dataCambio;
	private String renditaAnnuaLordaScadenza;
	private String dataElaborazione;	
	//OPZIONI RAMO III PIATTO
	//prestazioni
	private String renditaAnnuaVitMinimaGar;
	private String valoreRiscattoScadGarantito;
	private String renditaVitaliziaAnnuaPosticipata;
	private String ipotesiRenditaAnnuaPosticipataScadenzaCTV;
	private String ipotesiValoreRiscattoScadenzaCTV;
	private String dataRiferimentoNav;
	private String numeroQuote;	
	//frazionamento
    /*
	private String totaleRenditaFrazionataAnnualePosticipata;
	private String totaleRenditaFrazionataSemestralePosticipata;
	private String totaleRenditaFrazionataTrimestralePosticipata;
	private String totaleRenditaFrazionataMensilePosticipata;
	*/
	//certezza
    //private Certezza opzioniCertezza;

    /*
    private String OpzioneAnni1="";
	private String OpzioneAnni2="";
	private String OpzioneAnni3="";
	private String OpzioneAnni4="";
	private String totaleRenditaCerta1AnnualePosticipata;
	private String totaleRenditaCerta1SemestralePosticipata;
	private String totaleRenditaCerta1TrimestralePosticipata;
	private String totaleRenditaCerta1MensilePosticipata;	
	private String totaleRenditaCerta2AnnualePosticipata;
	private String totaleRenditaCerta2SemestralePosticipata;
	private String totaleRenditaCerta2TrimestralePosticipata;
	private String totaleRenditaCerta2MensilePosticipata;	
	private String totaleRenditaCerta3AnnualePosticipata;
	private String totaleRenditaCerta3SemestralePosticipata;
	private String totaleRenditaCerta3TrimestralePosticipata;
	private String totaleRenditaCerta3MensilePosticipata;	
	private String totaleRenditaCerta4AnnualePosticipata;
	private String totaleRenditaCerta4SemestralePosticipata;
	private String totaleRenditaCerta4TrimestralePosticipata;
	private String totaleRenditaCerta4MensilePosticipata;
	*/
    private boolean prestazioniAssicurate = false;
    private String valoreRiscattoNetto;
    private String anniCertezza;
    private String anniCertezza2;
    private Differimento differimento;
    
    // Parametri aggiuntivi Conversione Rendita
    private String durataMinima;
    private String premioAggiuntivo;


    //Simulazione FPA
    private DettaglioLiquidazionePrestazionePensionistica  dettaglioLiquidazionePrestazionePensionistica;
    
    private PraticheLegali praticheLegali;

    private PraticheLegaliAccertamento praticheLegaliAccertamento;

    private PraticheLegaliAccessi praticheLegaliAccessi;
    
    private PraticheLegaliDissequestro praticheLegaliDissequestro;
    
    private PraticheLegaliPignoramentoAE praticheLegaliPignoramentoAE;
    
    private PraticheLegaliPignoramentoPrivato praticheLegaliPignoramentoPrivato;

    public SospensioneScadenza getSospensioneScadenza() {
        if(sospensioneScadenza==null)                               //todo capire o scoprire a cosa serve questo controllo e perchè è stato introdotto
            return new SospensioneScadenza(new Long(numero));
        return sospensioneScadenza;
    }

    public void setSospensioneScadenza(SospensioneScadenza sospensioneScadenza) {
        this.sospensioneScadenza = sospensioneScadenza;
    }

    public long getMacroFamiglia() {
        return macroFamiglia;
    }

    public void setMacroFamiglia(long macroFamiglia) {
        this.macroFamiglia = macroFamiglia;
    }

    public boolean isVoglioLePrestazioniAssicurate() {
        return voglioLePrestazioniAssicurate;
    }

    public void setVoglioLePrestazioniAssicurate(boolean voglioLePrestazioniAssicurate) {
        this.voglioLePrestazioniAssicurate = voglioLePrestazioniAssicurate;
    }

    public boolean isCollettiva() {
        return collettiva;
    }

    public void setCollettiva(boolean collettiva) {
        this.collettiva = collettiva;
    }

    public EstrattoConto getEstrattoConto() {
        return estrattoConto;
    }

    public void setEstrattoConto(EstrattoConto estrattoConto) {
        this.estrattoConto = estrattoConto;
    }

    public RiscattoParziale getRiscattoParziale() {return riscattoParziale; }

    public void setRiscattoParziale(RiscattoParziale riscattoParziale) {this.riscattoParziale = riscattoParziale;}

    public RiscattoTotale getRiscattoTotale() {return riscattoTotale; }

    public void setRiscattoTotale(RiscattoTotale riscattoTotale) {this.riscattoTotale = riscattoTotale;}

    public Prestito getValorePrestito() {
        return valorePrestito;
    }

    public void setValorePrestito(Prestito valorePrestito) {
        this.valorePrestito = valorePrestito;
    }

    public CommissioniFondiEsterni getCommissioniFondiEsterni() {
        return commissioniFondiEsterni;
    }

    public void setCommissioniFondiEsterni(CommissioniFondiEsterni commissioniFondiEsterni) {
        this.commissioniFondiEsterni = commissioniFondiEsterni;
    }


    
    private String comunicazioneId;
    
    private boolean isACLSLungaSopravvivenza;

	//reversibilità
	private String totaleRenditaReversibile;
    private String reversibile;
    
    //variabile di controllo per aggiungere l frase aggiuntiva sui layout
    //della lettera opzione ramo 3 e riscatto al termine (con e senza HP)
    private boolean isFAP_R = false;
    //SPIEGAZIONE CONTEGGI RAMO I
    private List<SpiegazioneConteggiRamoI> listaSpiegazioneConteggiRamoI;
    //lettera riscatto parziale tendenza
    private RiscattoParzialeTendenzaBean riscattoParzialeTendenza;
    
    //lettera riscatto parziale puntuale
    private RiscattoParzialePuntualeBean riscattoParzialePuntuale;
    
    //lettera DECUMULO
    private Decumulo decumulo;

    public String getDataScadenzaOriginaria() {
        return dataScadenzaOriginaria;
    }

    public void setDataScadenzaOriginaria(String dataScadenzaOriginaria) {
        this.dataScadenzaOriginaria = dataScadenzaOriginaria;
    }

    public void setDifferimento(){
        differimento = new Differimento();
        differimento.setDataInizio(dataEmissione);
        differimento.setDataFine(dataScadenzaOriginaria!=null?dataScadenzaOriginaria:dataScadenza);
    }

    public Differimento getDifferimento() {
        return differimento;
    }

    public Boolean getIsACLSLungaSopravvivenza() {
		return isACLSLungaSopravvivenza;
	}
	public void setIsACLSLungaSopravvivenza(Boolean isACLSLungaSopravvivenza) {
		this.isACLSLungaSopravvivenza = isACLSLungaSopravvivenza;
	}
    
    public Decumulo getDecumulo() {
		return decumulo;
	}

	public void setDecumulo(Decumulo decumulo) {
		this.decumulo = decumulo;
	}

	public Map<String, String> getAttributi() {
		return attributi;
	}

	public void setAttributi(Map<String, String> attributi) {
		this.attributi = attributi;
	}

	public Map<String, String> getTronconi() {
		return tronconi;
	}

	public void setTronconi(Map<String, String> tronconi) {
		this.tronconi = tronconi;
	}

	public boolean isFAP_R() {
		return isFAP_R;
	}

	public void setFAP_R(boolean isFAP_R) {
		this.isFAP_R = isFAP_R;
	}
	
    public List<SpiegazioneConteggiRamoI> getListaSpiegazioneConteggiRamoI() {
		return listaSpiegazioneConteggiRamoI;
	}

	public void setListaSpiegazioneConteggiRamoI(
			List<SpiegazioneConteggiRamoI> listaSpiegazioneConteggiRamoI) {
		this.listaSpiegazioneConteggiRamoI = listaSpiegazioneConteggiRamoI;
	}

	public Long getPrimoDifferimento() {
        return primoDifferimento;
    }
	
	public void setPrimoDifferimento(Long primoDifferimento) {
        this.primoDifferimento = primoDifferimento;
    }
	
	public Double getImportoPianoProgrammatoVersamenti() {
        return importoPianoProgrammatoVersamenti;
    }

    public void setImportoPianoProgrammatoVersamenti(Double ipv) {
        this.importoPianoProgrammatoVersamenti = ipv;
    }
    
    public Double getImponibileCongelamento() {
        return imponibileCongelamento;
    }

    public void setImponibileCongelamento(Double ic) {
        this.imponibileCongelamento = ic;
    }
    
    public Double getMassimoValoreUl() {
        return massimoValoreUl;
    }

    public void setMassimoValoreUl(Double mv) {
        this.massimoValoreUl = mv;
    }

    public Double getImpostaBolloMaturata() {
        return impostaBolloMaturata;
    }

    public void setImpostaBolloMaturata(Double ibm) {
        this.impostaBolloMaturata = ibm;
    }

    public Reversibilita getReversibilita() {
        return reversibilita;
    }

    public void setReversibilita(Reversibilita reversibilita) {
        this.reversibilita = reversibilita;
    }

    public IpotesiRendita getRendita() {
        return rendita;
    }

    public void setRendita(IpotesiRendita rendita) {
        this.rendita = rendita;
    }

    public PrestazioneBase getPrestazioni() {
        return prestazioni;
    }

    public void setPrestazioni(PrestazioneBase prestazioni) {
        this.prestazioni = prestazioni;
    }

	public String getRenditaVitaliziaAnnuaPosticipata() {
		return renditaVitaliziaAnnuaPosticipata;
	}
	public void setRenditaVitaliziaAnnuaPosticipata(
			String renditaVitaliziaAnnuaPosticipata) {
		this.renditaVitaliziaAnnuaPosticipata = renditaVitaliziaAnnuaPosticipata;
	}

    public String getReversibile() {
        return reversibile;
    }
    public void setReversibile(String reversibile) {
        this.reversibile = reversibile;
    }

    public R3_ReversibilitaVo getReversibilitaTS() {
        return reversibilitaTS;
    }

    public void setReversibilitaTS(R3_ReversibilitaVo reversibilitaTS) {
        this.reversibilitaTS = reversibilitaTS;
    }

    public R3_ReversibilitaVo getReversibilitaTP() {
        return reversibilitaTP;
    }

    public void setReversibilitaTP(R3_ReversibilitaVo reversibilitaTP) {
        this.reversibilitaTP = reversibilitaTP;
    }

    public String getProdottoGarantito() {
        return prodottoGarantito;
    }

    public void setProdottoGarantito(String prodottoGarantito) {
        this.prodottoGarantito = prodottoGarantito;
    }

    public boolean isPrestazioniAssicurate() {
		return prestazioniAssicurate;
	}

	public void setPrestazioniAssicurate(boolean prestazioniAssicurate) {
		this.prestazioniAssicurate = prestazioniAssicurate;
	}

	public String getRenditaAnnuaVitMinimaGar() {
		return renditaAnnuaVitMinimaGar;
	}

	public void setRenditaAnnuaVitMinimaGar(String renditaAnnuaVitMinimaGar) {
		this.renditaAnnuaVitMinimaGar = renditaAnnuaVitMinimaGar;
	}

	public String getValoreRiscattoScadGarantito() {
		return valoreRiscattoScadGarantito!=null?valoreRiscattoScadGarantito:"";
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

	/*public String getTotaleRenditaFrazionataAnnualePosticipata() {
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
*/
   /* public String getOpzioneAnni1() {
        return OpzioneAnni1;
    }

    public void setOpzioneAnni1(String opzioneAnni1) {
        OpzioneAnni1 = opzioneAnni1;
    }

    public String getOpzioneAnni4() {
        return OpzioneAnni4;
    }

    public void setOpzioneAnni4(String opzioneAnni4) {
        OpzioneAnni4 = opzioneAnni4;
    }

    public String getOpzioneAnni3() {
        return OpzioneAnni3;
    }

    public void setOpzioneAnni3(String opzioneAnni3) {
        OpzioneAnni3 = opzioneAnni3;
    }

    public String getOpzioneAnni2() {
        return OpzioneAnni2;
    }

    public void setOpzioneAnni2(String opzioneAnni2) {
        OpzioneAnni2 = opzioneAnni2;
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
*/
	public String getTotaleRenditaReversibile() {
		return totaleRenditaReversibile;
	}

	public void setTotaleRenditaReversibile(String totaleRenditaReversibile) {
		this.totaleRenditaReversibile = totaleRenditaReversibile;
	}

	//OPZIONI RAMO III
	private OpzioniRamoIII opzioniRamoIII;

	public String getAttributo(String k) {
		System.out.println(k);
		String a = attributi.get(k);
		return (a == null) ? "" : a;
	}
	
	public void addAttributo(String k, String v) {
		if (k != null && v != null) {
			attributi.put(k, v);
		}
	}


	public String getTroncone(String k) {
		String a = tronconi.get(k);
		return (a == null) ? "" : a;
	}
	public void addTroncone(String k, String v) {
		if (k != null && v != null) {
			tronconi.put(k, v);
		}
	}

	public boolean isAttiva() {
		return !("ST".equalsIgnoreCase(stato) || "SC".equalsIgnoreCase(stato));
	}
	public void setAttiva(boolean v) {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoPrestazione() {
		return tipoPrestazione;
	}

	public void setTipoPrestazione(String tipoPrestazione) {
		this.tipoPrestazione = tipoPrestazione;
	}

	public String getTipoFormaAssicurazione() {
		return tipoFormaAssicurazione;
	}

	public void setTipoFormaAssicurazione(String tipoFormaAssicurazione) {
		this.tipoFormaAssicurazione = tipoFormaAssicurazione;
	}

	public String getDescrizioneFondoSintetica() {
		return descrizioneFondoSintetica;
	}

	public void setDescrizioneFondoSintetica(String descrizioneFondoSintetica) {
		this.descrizioneFondoSintetica = descrizioneFondoSintetica;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescrizioneCommerciale() {
		return descrizioneCommerciale;
	}

	public void setDescrizioneCommerciale(String descrizioneCommerciale) {
		this.descrizioneCommerciale = descrizioneCommerciale;
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

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	

	public String getDataFineDifferimento() {
		return dataFineDifferimento;
	}

	public void setDataFineDifferimento(String dataFineDifferimento) {
		this.dataFineDifferimento = dataFineDifferimento;
	}

	public String getDataLiquidazione() {
		return dataLiquidazione;
	}

	public void setDataLiquidazione(String dataLiquidazione) {
		this.dataLiquidazione = dataLiquidazione;
	}

	public Persona getContraente() {
		return contraente;
	}

	public void setContraente(Persona contraente) {
		this.contraente = contraente;
	}

	public Persona getAssicurato() {
		return assicurato;
	}

	public void setAssicurato(Persona assicurato) {
		this.assicurato = assicurato;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getLabelDataScadenza() {
		return labelDataScadenza;
	}

	public void setLabelDataScadenza(String labelDataScadenza) {
		this.labelDataScadenza = labelDataScadenza;
	}
	
	public String getDataRiferimentoQuote() {
		return dataRiferimentoQuote;
	}

	public void setDataRiferimentoQuote(String dataRiferimentoQuote) {
		this.dataRiferimentoQuote = dataRiferimentoQuote;
	}

	public String getControvaloreQuote() {
		return controvaloreQuote;
	}

	public void setControvaloreQuote(String controvaloreQuote) {
		this.controvaloreQuote = controvaloreQuote;
	}

	public PrivateBanker getPrivateBanker() {
		return privateBanker;
	}

	public void setPrivateBanker(PrivateBanker privateBanker) {
		this.privateBanker = privateBanker;
	}

	public List<Polizza> getPolizzeProvenienza() {
		return polizzeProvenienza;
	}

	public void setPolizzeProvenienza(List<Polizza> polizzeProvenienza) {
		this.polizzeProvenienza = polizzeProvenienza;
	}

	public boolean isPraticheAperte() {
		return praticheAperte;
	}

	public void setPraticheAperte(boolean praticheAperte) {
		this.praticheAperte = praticheAperte;
	}

	public String getCodiceIngressoBase() {
		return codiceIngressoBase;
	}

	public void setCodiceIngressoBase(String codiceIngressoBase) {
		this.codiceIngressoBase = codiceIngressoBase;
	}

	public String getCodiceIngresso() {
		return codiceIngresso;
	}

	public void setCodiceIngresso(String codiceIngresso) {
		this.codiceIngresso = codiceIngresso;
	}

	public String getReteVendita() {
		return reteVendita;
	}

	public void setReteVendita(String reteVendita) {
		this.reteVendita = reteVendita;
	}

	public String getDataDecorrenza() {
		return dataDecorrenza;
	}

	public void setDataDecorrenza(String dataDecorrenza) {
		this.dataDecorrenza = dataDecorrenza;
	}

	public String getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getCodiceFondo() {
		return codiceFondo;
	}

	public void setCodiceFondo(String codiceFondo) {
		this.codiceFondo = codiceFondo;
	}

	public String getCodicePremio() {
		return codicePremio;
	}

	public void setCodicePremio(String codicePremio) {
		this.codicePremio = codicePremio;
	}

	public String getCodiceGruppo() {
		return codiceGruppo;
	}

	public void setCodiceGruppo(String codiceGruppo) {
		this.codiceGruppo = codiceGruppo;
	}

	public Persona getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Persona beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	public String getBeneficiarioVita() {
		return beneficiarioVita;
	}
	
	public void setBeneficiarioVita(String beneficiarioVita) {
		this.beneficiarioVita = beneficiarioVita;
	}
	
	public String getBeneficiarioMorte() {
		return beneficiarioMorte;
	}
	
	public void setBeneficiarioMorte(String beneficiarioMorte) {
		this.beneficiarioMorte = beneficiarioMorte;
	}

	

	public boolean isTrasformata() {
		return trasformata;
	}

	public void setTrasformata(boolean trasformata) {
		this.trasformata = trasformata;
	}

	public String getPremiUnici() {
		return premiUnici;
	}

	public void setPremiUnici(String premiUnici) {
		this.premiUnici = premiUnici;
	}

	public String getPremiAnnui() {
		return premiAnnui;
	}

	public void setPremiAnnui(String premiAnnui) {
		this.premiAnnui = premiAnnui;
	}

	public String getPremiDaIncassare() {
		return premiDaIncassare;
	}

	public void setPremiDaIncassare(String premiDaIncassare) {
		this.premiDaIncassare = premiDaIncassare;
	}

	public String getDataPremiDaIncassare() {
		return dataPremiDaIncassare;
	}

	public void setDataPremiDaIncassare(String dataPremiDaIncassare) {
		this.dataPremiDaIncassare = dataPremiDaIncassare;
	}

	public String getDataErogazioneRendita() {
		return dataErogazioneRendita;
	}

	public void setDataErogazioneRendita(String dataErogazioneRendita) {
		this.dataErogazioneRendita = dataErogazioneRendita;
	}

	public String getDataUltimaRivalutazioneFineDifferimento() {
		return dataUltimaRivalutazioneFineDifferimento;
	}

	public void setDataUltimaRivalutazioneFineDifferimento(
			String dataUltimaRivalutazioneFineDifferimento) {
		this.dataUltimaRivalutazioneFineDifferimento = dataUltimaRivalutazioneFineDifferimento;
	}

	public String getDataUltimaRivalutazioneSistema() {
		return dataUltimaRivalutazioneSistema;
	}

	public void setDataUltimaRivalutazioneSistema(
			String dataUltimaRivalutazioneSistema) {
		this.dataUltimaRivalutazioneSistema = dataUltimaRivalutazioneSistema;
	}

	public String getDataRicorrenza75() {
		return dataRicorrenza75;
	}

	public void setDataRicorrenza75(String dataRicorrenza75) {
		this.dataRicorrenza75 = dataRicorrenza75;
	}

	public String getDataRicorrenza80() {
		return dataRicorrenza80;
	}

	public void setDataRicorrenza80(String dataRicorrenza80) {
		this.dataRicorrenza80 = dataRicorrenza80;
	}

	public String getDataRicorrenza85() {
		return dataRicorrenza85;
	}

	public void setDataRicorrenza85(String dataRicorrenza85) {
		this.dataRicorrenza85 = dataRicorrenza85;
	}

	public boolean isControassicurazione() {
		return controassicurazione;
	}

	public void setControassicurazione(boolean controassicurazione) {
		this.controassicurazione = controassicurazione;
	}

	public boolean isVincoloPegno() {
		return vincoloPegno;
	}

	public void setVincoloPegno(boolean vincoloPegno) {
		this.vincoloPegno = vincoloPegno;
	}
	
	public String getVincolo() {
		return vincolo;
	}

	public void setVincolo(boolean vincolo) {
		if(vincolo)
			this.vincolo = "Si";
		else
			this.vincolo = "No";
	}
	
	public String getDecumuloAttivo() {
		return decumuloAttivo;
	}

	public void setDecumuloAttivo(boolean decumuloAttivo) {
		if(decumuloAttivo)
			this.decumuloAttivo = "Si";
		else
			this.decumuloAttivo = "No";
	}
	
	public String getDetraibilitaFiscale() {
		return detraibilitaFiscale;
	}

	public void setDetraibiltaFiscale(boolean df) {
		if(df)
			this.detraibilitaFiscale = "Si";
		else
			this.detraibilitaFiscale = "No";
	}
	
	public String getPolizzaScudata() {
		return polizzaScudata;
	}

	public void setPolizzaScudata(boolean ps) {
		if(ps)
			this.polizzaScudata = "Si";
		else
			this.polizzaScudata = "No";
	}
	
	
	public void setRiallocazioneGuidata(boolean rg) {
		if(rg)
			this.riallocazioneGuidata = "Si";
		else
			this.riallocazioneGuidata = "No";
	}
	
	public String getRiallocazioneGuidata() {
		return riallocazioneGuidata;
	}

	public String getIsVariazioneContrattuale() {
		return isVariazioneContrattuale;
	}

	public void setIsVariazioneContrattuale(boolean isVC) {
		if(isVC)
			this.isVariazioneContrattuale = "Si";
		else
			this.isVariazioneContrattuale = "No";
	}
	
	public String getTipoClasseBonus() {
		return tipoClasseBonus;
	}

	public void setTipoClasseBonus(String tcb) {
		if(tcb.equalsIgnoreCase(""))
			this.tipoClasseBonus = "N/D";
		else
			this.tipoClasseBonus = tcb;
	}

	public String getImportoCasoMorteRivalutato() {
		return importoCasoMorteRivalutato;
	}

	public void setImportoCasoMorteRivalutato(String importoCasoMorteRivalutato) {
		this.importoCasoMorteRivalutato = importoCasoMorteRivalutato;
	}

	public String getImportoPrestazioniVita() {
		return importoPrestazioniVita;
	}

	public void setImportoPrestazioniVita(String importoPrestazioniVita) {
		this.importoPrestazioniVita = importoPrestazioniVita;
	}

	public String getMassimaleInfortunio() {
		return massimaleInfortunio;
	}

	public void setMassimaleInfortunio(String massimaleInfortunio) {
		this.massimaleInfortunio = massimaleInfortunio;
	}

	public String getMassimaleMalattia() {
		return massimaleMalattia;
	}

	public void setMassimaleMalattia(String massimaleMalattia) {
		this.massimaleMalattia = massimaleMalattia;
	}

	public String getCapitaleMorteInfortunio() {
		return capitaleMorteInfortunio;
	}

	public void setCapitaleMorteInfortunio(String capitaleMorteInfortunio) {
		this.capitaleMorteInfortunio = capitaleMorteInfortunio;
	}

	public String getCapitaleMorteInfortunioStradale() {
		return capitaleMorteInfortunioStradale;
	}

	public void setCapitaleMorteInfortunioStradale(
			String capitaleMorteInfortunioStradale) {
		this.capitaleMorteInfortunioStradale = capitaleMorteInfortunioStradale;
	}

	public String getCapitaleMalattiaGrave() {
		return capitaleMalattiaGrave;
	}

	public void setCapitaleMalattiaGrave(String capitaleMalattiaGrave) {
		this.capitaleMalattiaGrave = capitaleMalattiaGrave;
	}

	public String getCapitaleSecondoDecesso() {
		return capitaleSecondoDecesso;
	}

	public void setCapitaleSecondoDecesso(String capitaleSecondoDecesso) {
		this.capitaleSecondoDecesso = capitaleSecondoDecesso;
	}

	public String getImportoBonus() {
		return importoBonus;
	}

	public void setImportoBonus(String importoBonus) {
		this.importoBonus = importoBonus;
	}

	public String getRenditaGarantita75() {
		return renditaGarantita75;
	}

	public void setRenditaGarantita75(String renditaGarantita75) {
		this.renditaGarantita75 = renditaGarantita75;
	}

	public String getRenditaGarantita80() {
		return renditaGarantita80;
	}

	public void setRenditaGarantita80(String renditaGarantita80) {
		this.renditaGarantita80 = renditaGarantita80;
	}

	public String getRenditaGarantita85() {
		return renditaGarantita85;
	}

	public void setRenditaGarantita85(String renditaGarantita85) {
		this.renditaGarantita85 = renditaGarantita85;
	}

	public String getRamoMinisteriale() {
		return ramoMinisteriale;
	}

	public void setRamoMinisteriale(String ramoMinisteriale) {
		this.ramoMinisteriale = ramoMinisteriale;
	}

	public String getEccedenza() {
		return eccedenza;
	}

	public void setEccedenza(String eccedenza) {
		this.eccedenza = eccedenza;
	}

	public List<Liquidazione> getLiquidazioni() {
		return liquidazioni;
	}

	public void setLiquidazioni(List<Liquidazione> liquidazioni) {
		this.liquidazioni = liquidazioni;
	}
	public String getConferimento() {
		return conferimento;
	}
	public void setConferimento(String conferimento) {
		this.conferimento = conferimento;
	}
	public String getDataUltimaRataPagata() {
		return dataUltimaRataPagata;
	}
	public void setDataUltimaRataPagata(String dataUltimaRataPagata) {
		this.dataUltimaRataPagata = dataUltimaRataPagata;
	}
	public String getRiservaMatematica() {
		return riservaMatematica;
	}
	public void setRiservaMatematica(String riservaMatematica) {
		this.riservaMatematica = riservaMatematica;
	}

	public String getTassoIsvap() {
		return tassoIsvap;
	}

	public void setTassoIsvap(String tassoIsvap) {
		this.tassoIsvap = tassoIsvap;
	}
	public void setSottostato(String sottostato) {
		this.sottostato = sottostato;
	}
	public String getSottostato() {
		return sottostato;
	}
	
	public void setStatoDT(String statoDT) {
		this.statoDT = statoDT;
	}
	public String getStatoDT() {
		return statoDT;
	}
	
	public void setCodiceSottostato(String codiceSottostato) {
		this.codiceSottostato = codiceSottostato;
	}
	public String getCodiceSottostato() {
		return codiceSottostato;
	}

	public String toString(){
		StringBuffer tostring = new StringBuffer("");
		Method[] metodi = this.getClass().getMethods();
		for (Method method : metodi) {
			if(method.getName().startsWith("get")){
				tostring.append(method.getName()).append(":");
				try {
					tostring.append(method.invoke(this, new Object[0])).append("-");
				} catch (Exception e) {
					LoggingUtils.error(e);
				}
			}
		}		
		return tostring.toString();
	}
	
	/**
	 * @return the listaTitoli
	 */
	public List<Titolo> getListaTitoli() {
		return listaTitoli;
	}
	
	/**
	 * @param listaTitoli the listaTitoli to set
	 */
	public void setListaTitoli(List<Titolo> listaTitoli) {
		this.listaTitoli = listaTitoli;
	}
	
	/**
	 * @return the listaCoefficientiCpp
	 */
	public List<CoefficienteCpp> getListaCoefficientiCpp() {
		return listaCoefficientiCpp;
	}
	
	/**
	 * @param listaCoefficientiCpp the listaCoefficientiCpp to set
	 */
	public void setListaCoefficientiCpp(List<CoefficienteCpp> listaCoefficientiCpp) {
		this.listaCoefficientiCpp = listaCoefficientiCpp;
	}
	/**
	 * @return the listaPraticheConteggi
	 */
	public List<PraticaSpiegazioneConteggi> getListaPraticheConteggi() {
		return listaPraticheConteggi;
	}
	/**
	 * @param listaPraticheConteggi the listaPraticheConteggi to set
	 */
	public void setListaPraticheConteggi(
			List<PraticaSpiegazioneConteggi> listaPraticheConteggi) {
		this.listaPraticheConteggi = listaPraticheConteggi;
	}
	/**
	 * @return the scenario
	 */
	public String getScenario() {
		return scenario;
	}
	/**
	 * @param scenario the scenario to set
	 */
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}


    //POLIZZE SPI


    public String getDivisa() {
        return divisa!=null?divisa:"";
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getDataNascitaAssicurato() {
        return dataNascitaAssicurato;
    }

    public void setDataNascitaAssicurato(String dataNascitaAssicurato) {
        this.dataNascitaAssicurato = dataNascitaAssicurato;
    }

    public String getRenditaDaPiano() {
        return renditaDaPiano;
    }

    public void setRenditaDaPiano(String renditaDaPiano) {
        this.renditaDaPiano = renditaDaPiano;
    }

    public String getDataRivalutazione() {
        return dataRivalutazione;
    }

    public void setDataRivalutazione(String dataRivalutazione) {
        this.dataRivalutazione = dataRivalutazione;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getRenditaDaEstemporanei() {
        return renditaDaEstemporanei;
    }

    public void setRenditaDaEstemporanei(String renditaDaEstemporanei) {
        this.renditaDaEstemporanei = renditaDaEstemporanei;
    }

    public String getTassoLordoRivalutazione() {
        return tassoLordoRivalutazione;
    }

    public void setTassoLordoRivalutazione(String tassoLordoRivalutazione) {
        this.tassoLordoRivalutazione = tassoLordoRivalutazione;
    }

    public String getTassoNettoRivalutazione() {
        return tassoNettoRivalutazione;
    }

    public void setTassoNettoRivalutazione(String tassoNettoRivalutazione) {
        this.tassoNettoRivalutazione = tassoNettoRivalutazione;
    }

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public String getTariffa() {
        return tariffa;
    }

    public void setTariffa(String tariffa) {
        this.tariffa = tariffa;
    }

    public String getBonusFedelta() {
        return bonusFedelta;
    }

    public void setBonusFedelta(String bonusFedelta) {
        this.bonusFedelta = bonusFedelta;
    }

    public String getBonusExtra() {
        return bonusExtra;
    }

    public void setBonusExtra(String bonusExtra) {
        this.bonusExtra = bonusExtra;
    }

    public String getTotaleRendita() {
        return totaleRendita;
    }

    public void setTotaleRendita(String totaleRendita) {
        this.totaleRendita = totaleRendita;
    }

    public String getCoefficienteCapitale() {
        return coefficienteCapitale;
    }

    public void setCoefficienteCapitale(String coefficienteCapitale) {
        this.coefficienteCapitale = coefficienteCapitale;
    }

    public String getCapitaleLordoInValuta() {
        return capitaleLordoInValuta;
    }

    public void setCapitaleLordoInValuta(String capitaleLordoInValuta) {
        this.capitaleLordoInValuta = capitaleLordoInValuta;
    }

    public String getCambioInEuro() {
        return cambioInEuro;
    }

    public void setCambioInEuro(String cambioInEuro) {
        this.cambioInEuro = cambioInEuro;
    }

    public String getCapitaleLordoInEuro() {
        return capitaleLordoInEuro;
    }

    public void setCapitaleLordoInEuro(String capitaleLordoInEuro) {
        this.capitaleLordoInEuro = capitaleLordoInEuro;
    }

    public String getRenditaTrimestrale() {
        return renditaTrimestrale;
    }

    public void setRenditaTrimestrale(String renditaTrimestrale) {
        this.renditaTrimestrale = renditaTrimestrale;
    }

    public String getRenditaSemestrale() {
        return renditaSemestrale;
    }

    public void setRenditaSemestrale(String renditaSemestrale) {
        this.renditaSemestrale = renditaSemestrale;
    }
    public String getPremiVersatiInEuro() {
        return premiVersatiInEuro;
    }

    public void setPremiVersatiInEuro(String premiVersatiInEuro) {
        this.premiVersatiInEuro = premiVersatiInEuro;
    }

    public String getRenditaCerta5Anni() {
        return renditaCerta5Anni;
    }

    public void setRenditaCerta5Anni(String renditaCerta5Anni) {
        this.renditaCerta5Anni = renditaCerta5Anni;
    }

    public String getRenditaCerta10Anni() {
        return renditaCerta10Anni;
    }

    public void setRenditaCerta10Anni(String renditaCerta10Anni) {
        this.renditaCerta10Anni = renditaCerta10Anni;
    }

    public String getGuadagno() {
          return guadagno;
    }

    public void setGuadagno(String guadagno) {
          this.guadagno = guadagno;
    }

    //METODI ACCESSER AGGIUNTI PER LE SIMULAZIONI SPI

    public String getPrestazioneGarantitaAllUltimaRivalutazione() {
        return prestazioneGarantitaAllUltimaRivalutazione;
    }

    public void setPrestazioneGarantitaAllUltimaRivalutazione(String prestazioneGarantitaAllUltimaRivalutazione) {
        this.prestazioneGarantitaAllUltimaRivalutazione = prestazioneGarantitaAllUltimaRivalutazione;
    }

    public String getPremiVersatiAdOggiInEuro() {
        return premiVersatiAdOggiInEuro;
    }

    public void setPremiVersatiAdOggiInEuro(String premiVersatiAdOggiInEuro) {
        this.premiVersatiAdOggiInEuro = premiVersatiAdOggiInEuro;
    }

    public String getRivalutazioneMinimaGarantita() {
        return rivalutazioneMinimaGarantita;
    }

    public void setRivalutazioneMinimaGarantita(String rivalutazioneMinimaGarantita) {
        this.rivalutazioneMinimaGarantita = rivalutazioneMinimaGarantita;
    }

    public String getStimaTotaleRenditaAScadenza() {
        return stimaTotaleRenditaAScadenza;
    }

    public void setStimaTotaleRenditaAScadenza(String stimaTotaleRenditaAScadenza) {
        this.stimaTotaleRenditaAScadenza = stimaTotaleRenditaAScadenza;
    }

    public String getStimaRenditaDaPianoAScadenza() {
        return stimaRenditaDaPianoAScadenza;
    }

    public void setStimaRenditaDaPianoAScadenza(String stimaRenditaDaPianoAScadenza) {
        this.stimaRenditaDaPianoAScadenza = stimaRenditaDaPianoAScadenza;
    }

    public String getCapitaleLordo() {
        return capitaleLordo;
    }

    public void setCapitaleLordo(String capitaleLordo) {
        this.capitaleLordo = capitaleLordo;
    }
    public String getSommaPremiResiduiDaVersare() {
        return sommaPremiResiduiDaVersare;
    }

    public void setSommaPremiResiduiDaVersare(String sommaPremiResiduiDaVersare) {
        this.sommaPremiResiduiDaVersare = sommaPremiResiduiDaVersare;
    }

    public String getStimaRenditaDaEstemporaneiAScadenza() {
        return stimaRenditaDaEstemporaneiAScadenza;
    }

    public void setStimaRenditaDaEstemporaneiAScadenza(String stimaRenditaDaEstemporaneiAScadenza) {
        this.stimaRenditaDaEstemporaneiAScadenza = stimaRenditaDaEstemporaneiAScadenza;
    }

    public String getRenditaTrimestrale2() {
        return renditaTrimestrale2;
    }

    public void setRenditaTrimestrale2(String renditaTrimestrale2) {
        this.renditaTrimestrale2 = renditaTrimestrale2;
    }

    public String getRenditaSemestrale2() {
        return renditaSemestrale2;
    }

    public void setRenditaSemestrale2(String renditaSemestrale2) {
        this.renditaSemestrale2 = renditaSemestrale2;
    }

    public String getRenditaCerta5Anni2() {
        return renditaCerta5Anni2;
    }

    public void setRenditaCerta5Anni2(String renditaCerta5Anni2) {
        this.renditaCerta5Anni2 = renditaCerta5Anni2;
    }

    public String getRenditaCerta10Anni2() {
        return renditaCerta10Anni2;
    }

    public void setRenditaCerta10Anni2(String renditaCerta10Anni2) {
        this.renditaCerta10Anni2 = renditaCerta10Anni2;
    }

    public String getCapitaleLordo2() {
        return capitaleLordo2;
    }

    public void setCapitaleLordo2(String capitaleLordo2) {
        this.capitaleLordo2 = capitaleLordo2;
    }
    
    public String getSituazionePremiQuote() {
        return situazionePremiQuote;
    }

    public void setSituazionePremiQuote(String situazionePremiQuote) {
        this.situazionePremiQuote = situazionePremiQuote;
    }
    
    public List<CaricamentiCppVORamoIII> getListaCaricamentiCppVORamoIII() {
		return listaCaricamentiCppVORamoIII;
	}

	public void setListaCaricamentiCppVORamoIII(
			List<CaricamentiCppVORamoIII> listaCaricamentiCppVORamoIII) {
		this.listaCaricamentiCppVORamoIII = listaCaricamentiCppVORamoIII;
	}

	public void setBeneficiari(List<BeneficiarioLiquidazioneVO> beneficiari) {
		this.beneficiari = beneficiari;
	}

	public List<BeneficiarioLiquidazioneVO> getBeneficiari() {
		return beneficiari;
	}
	
	public List<BeneficiariLiquidazione> getListBeneficiari() {
		return listBeneficiari;
	}

	public void setListBeneficiari(List<BeneficiariLiquidazione> listBeneficiari) {
		this.listBeneficiari = listBeneficiari;
	}
	
	 public String getPremiAggiuntiviVersatiAdOggi() {
			return premiAggiuntiviVersatiAdOggi;
	}

	public void setPremiAggiuntiviVersatiAdOggi(String premiAggiuntiviVersatiAdOggi) {
		this.premiAggiuntiviVersatiAdOggi = premiAggiuntiviVersatiAdOggi;
	}
	
	public String getDataCambio() {
		return dataCambio;
	}

	public void setDataCambio(String dataCambio) {
		this.dataCambio = dataCambio;
	}
	
	public String getDataElaborazione() {
		return dataElaborazione;
	}

	public void setDataElaborazione(String dataElaborazione) {
		this.dataElaborazione = dataElaborazione;
	}
	
	public String getRenditaAnnuaLordaScadenza() {
		return renditaAnnuaLordaScadenza;
	}

	public void setRenditaAnnuaLordaScadenza(String renditaAnnuaLordaScadenza) {
		this.renditaAnnuaLordaScadenza = renditaAnnuaLordaScadenza;
	}
	
	public OpzioniRamoIII getOpzioniRamoIII() {
		return opzioniRamoIII;
	}


	public void setOpzioniRamoIII(OpzioniRamoIII opzioniRamoIII) {
		this.opzioniRamoIII = opzioniRamoIII;
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
	
	public String getStimaRenditaDaEstemporaneiAScadenza2() {
		return stimaRenditaDaEstemporaneiAScadenza2;
	}

	public void setStimaRenditaDaEstemporaneiAScadenza2(
			String stimaRenditaDaEstemporaneiAScadenza2) {
		this.stimaRenditaDaEstemporaneiAScadenza2 = stimaRenditaDaEstemporaneiAScadenza2;
	}
	
	public RiscattoParzialeTendenzaBean getRiscattoParzialeTendenza() {
		return riscattoParzialeTendenza;
	}

	public void setRiscattoParzialeTendenza(
			RiscattoParzialeTendenzaBean riscattoParzialeTendenza) {
		this.riscattoParzialeTendenza = riscattoParzialeTendenza;
	}

	public RiscattoParzialePuntualeBean getRiscattoParzialePuntuale() {
		return riscattoParzialePuntuale;
	}

	public void setRiscattoParzialePuntuale(
			RiscattoParzialePuntualeBean riscattoParzialePuntuale) {
		this.riscattoParzialePuntuale = riscattoParzialePuntuale;
	}
	public String getValoreRiscattoNetto() {
		return valoreRiscattoNetto;
	}

	public void setValoreRiscattoNetto(String valoreRiscattoNetto) {
		this.valoreRiscattoNetto = valoreRiscattoNetto;
	}
	public boolean isCompletato() {
		return isCompletato;
	}

	public void setCompletato(boolean isCompletato) {
		this.isCompletato = isCompletato;
	}
	
	public String getAnniCertezza() {
		return anniCertezza;
	}

	public void setAnniCertezza(String anniCertezza) {
		this.anniCertezza = anniCertezza;
	}
	
	/*
	private boolean controlloCertezza;

	eliminare dopo verifica tck 820 : FUFFA
	public boolean isControlloCertezza() {
		return controlloCertezza;
	}

	public void setControlloCertezza(boolean controlloCertezza) {
		this.controlloCertezza = controlloCertezza;
	}
	public String getComunicazioneId() {
		return comunicazioneId;
	}
	*/

	public void setComunicazioneId(String comunicazioneId) {
		this.comunicazioneId = comunicazioneId;
	}

    public  boolean isDivisaNotEur(){
		return !divisa.equalsIgnoreCase("EUR");
    }

    public String getAnniCertezza2() {
        return anniCertezza2;
    }

    public void setAnniCertezza2(String anniCertezza2) {
        this.anniCertezza2 = anniCertezza2;
    }

	public String getDurataMinima() {
		return durataMinima;
	}

	public void setDurataMinima(String durataMinima) {
		this.durataMinima = durataMinima;
	}

	public String getPremioAggiuntivo() {
		return premioAggiuntivo;
	}

	public void setPremioAggiuntivo(String premioAggiuntivo) {
		this.premioAggiuntivo = premioAggiuntivo;
	}

    public DettaglioLiquidazionePrestazionePensionistica getDettaglioLiquidazionePrestazionePensionistica() {
        return dettaglioLiquidazionePrestazionePensionistica;
    }

    public void setDettaglioLiquidazionePrestazionePensionistica(DettaglioLiquidazionePrestazionePensionistica dettaglioLiquidazionePrestazionePensionistica) {
        this.dettaglioLiquidazionePrestazionePensionistica = dettaglioLiquidazionePrestazionePensionistica;
    }

	public Scadenza getScadenza() {
		return scadenza;
	}

	public void setScadenza(Scadenza scadenza) {
		this.scadenza = scadenza;
	}

	public PraticheLegali getPraticheLegali() {
		return praticheLegali;
	}

	public void setPraticheLegali(PraticheLegali praticheLegali) {
		this.praticheLegali = praticheLegali;
	}
	
	public PraticheLegaliAccertamento getPraticheLegaliAccertamento() {
		return praticheLegaliAccertamento;
	}

	public void setPraticheLegaliAccertamento(PraticheLegaliAccertamento praticheLegaliAccertamento) {
		this.praticheLegaliAccertamento = praticheLegaliAccertamento;
	}

	public PraticheLegaliAccessi getPraticheLegaliAccessi() {
		return praticheLegaliAccessi;
	}

	public void setPraticheLegaliAccessi(PraticheLegaliAccessi praticheLegaliAccessi) {
		this.praticheLegaliAccessi = praticheLegaliAccessi;
	}

	public PraticheLegaliDissequestro getPraticheLegaliDissequestro() {
		return praticheLegaliDissequestro;
	}

	public void setPraticheLegaliDissequestro(PraticheLegaliDissequestro praticheLegaliDissequestro) {
		this.praticheLegaliDissequestro = praticheLegaliDissequestro;
	}

	public PraticheLegaliPignoramentoAE getPraticheLegaliPignoramentoAE() {
		return praticheLegaliPignoramentoAE;
	}

	public void setPraticheLegaliPignoramentoAE(PraticheLegaliPignoramentoAE praticheLegaliPignoramentoAE) {
		this.praticheLegaliPignoramentoAE = praticheLegaliPignoramentoAE;
	}

	public PraticheLegaliPignoramentoPrivato getPraticheLegaliPignoramentoPrivato() {
		return praticheLegaliPignoramentoPrivato;
	}

	public void setPraticheLegaliPignoramentoPrivato(PraticheLegaliPignoramentoPrivato praticheLegaliPignoramentoPrivato) {
		this.praticheLegaliPignoramentoPrivato = praticheLegaliPignoramentoPrivato;
	}
}