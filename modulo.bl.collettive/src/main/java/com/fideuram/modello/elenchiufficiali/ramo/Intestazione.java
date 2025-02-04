package com.fideuram.modello.elenchiufficiali.ramo;

import java.util.Date;
import java.util.List;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.utils.NumberUtils;

public class Intestazione {
	
	//numero convenzione (PCOL_NUMCOL)
	private String numConvenzione;
	//numero Elenco (PCOL_NUMEL)
	private String numElenco;
	//codice collettiva (PCOL_CDCOL)
	private String codCollettiva;
	
	//pcol_codage+pcol_codari
	private String numAgenzia;
	private String codiceAgenzia; //pcol_codage
	
	//contraente
	private String nome;//pcol_nome
	private String cognome;//pcol_cognome
	private String codFisc;//pcol_codfis
	
	//sede sociale
	private String citta;
	private String prov;
	private String cap;
	private String ind;
	
	//tariffa (pcol_codtrf_1)
	private String numTariffa;//pcol_codtrf_1
	private String descTariffa;//pcol_dectrf
	
	//ricavato da isPremioUnico (U o A)
	private String premioTariffa;

	private String codiceEmissione;
	//capitale o rendita (C o R)
	private String codicePrestazione; 

	
	//testo premio Unico (change codiceEmisione)
	private String textGaranzie;
	
	//testo premio Annuale (change frazionamentoPremio)
	private String textSfrazPre;
	private String frazionamentoPremio; //pcol_frazpre
	
	//I e III ramo
	private String textVersamentoPremio;
	
	//testo perfezionamento (change codiceAgenzia)
	private String textPerfezionamento;
	
	private Date dataEmissione; //pcol_datemi
	private Date dataDecorrenza; //pcol_datdec
	private Date dataInizioCopertura; //pcol_datdec
	
	//importi
	private Double importoValoreLordo; // svallordo

	//solo per ramo I
	private List<Importi> importiRI;
	
	//solo per ramo III
	private String textInvestimento;
	private Date dataRiferimentoNav; //ppos_datrifnav
	private String codiceFondo; //trf_cdfnd
		
	//premio unico, premio annuale
	private boolean isPremioUnico;
	//ramo primo, ramo terzo
	private boolean isRamoPrimo;
	
	public Intestazione(String numConvenzione, String numElenco, boolean isPremioUnico, boolean isRamoPrimo){
		this.numConvenzione = numConvenzione;
		this.numElenco = numElenco;
		this.isPremioUnico = isPremioUnico;
		this.isRamoPrimo = isRamoPrimo;
	}
	
	public Intestazione(boolean isPremioUnico, boolean isRamoPrimo){
		this.isPremioUnico = isPremioUnico;
		this.isRamoPrimo = isRamoPrimo;
	}

	public Intestazione(){
		
	}
	
	public String getNumConvenzione() {
		return numConvenzione;
	}

	public void setNumConvenzione(String numConvenzione) {
		this.numConvenzione = numConvenzione;
	}

	public String getNumElenco() {
		return numElenco;
	}

	public void setNumElenco(String numElenco) {
		this.numElenco = numElenco;
	}

	public String getNumAgenzia() {
		return numAgenzia;
	}

	public void setNumAgenzia(String numAgenzia) {
		this.numAgenzia = numAgenzia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getInd() {
		return ind;
	}

	public void setInd(String ind) {
		this.ind = ind;
	}

	public String getNumTariffa() {
		return numTariffa;
	}

	public void setNumTariffa(String numTariffa) {
		this.numTariffa = numTariffa;
	}

	public String getDescTariffa() {
		return descTariffa;
	}

	public void setDescTariffa(String descTariffa) {
		this.descTariffa = descTariffa;
	}

	public String getCodCollettiva() {
		return codCollettiva;
	}

	public void setCodCollettiva(String codCollettiva) {
		this.codCollettiva = codCollettiva;
	}

	public boolean isPremioUnico() {
		return isPremioUnico;
	}

	public void setPremioUnico(boolean isPremioUnico) {
		this.isPremioUnico = isPremioUnico;
	}

	public boolean isRamoPrimo() {
		return isRamoPrimo;
	}
	
	public void setRamoPrimo(boolean isRamoPrimo) {
		this.isRamoPrimo = isRamoPrimo;
	}

	public String getTextGaranzie() {
	
		if(getCodiceEmissione().equalsIgnoreCase("80") || getCodiceEmissione().equalsIgnoreCase("89"))
			textGaranzie = "Le garanzie emesse nell'ambito del presente elenco sostituiscono quelle riportate nell'allegato N°1, "+
					 "con trasferimento delle disponibilità maturate. A seguito della suddetta operazione di sostituzione la Contraente, "+
					 "al perfezionamento del presente elenco, non versa alcun premio.";
		else if(getCodiceEmissione().equalsIgnoreCase("82"))
			textGaranzie = "Le garanzie emesse nell'ambito del presente elenco derivano dal reimpiego della Riserva Matematica maturata dagli Assicurati "+
					 "presso gli enti riportati nell'allegato N° 1. A seguito della suddetta operazione di reimpiego di Riserve Matematiche la Contraente, "+
					 "al perfezionamento del presente elenco, non versa alcun premio.";
		else
			textGaranzie = "";
		return textGaranzie;
	}

	public String getTextSfrazPre() {
		if(!isPremioUnico){
			if(getFrazionamentoPremio().equalsIgnoreCase("1"))
				textSfrazPre = "pagabile in rate annuali anticipate";
			else if(getFrazionamentoPremio().equalsIgnoreCase("2"))
				textSfrazPre = "pagabile in rate semestrali anticipate";
			else if(getFrazionamentoPremio().equalsIgnoreCase("3"))
				textSfrazPre = "pagabile in rate quadrimestrali anticipate";
			else if(getFrazionamentoPremio().equalsIgnoreCase("4"))
				textSfrazPre = "pagabile in rate trimestrali anticipate";
			else if(getFrazionamentoPremio().equalsIgnoreCase("6"))
				textSfrazPre = "pagabile in rate bimestrali anticipate";
			else if(getFrazionamentoPremio().equalsIgnoreCase("12"))
				textSfrazPre = "pagabile in rate mensili anticipate";
		}
		else if(isPremioUnico && codicePrestazione!=null && this.codicePrestazione.equalsIgnoreCase("R")){
			if(getFrazionamentoPremio().equalsIgnoreCase("1"))
				textSfrazPre = "Rendita pagabile in rate annuali";
			else if(getFrazionamentoPremio().equalsIgnoreCase("2"))
				textSfrazPre = "Rendita pagabile in rate semestrali";
			else if(getFrazionamentoPremio().equalsIgnoreCase("3"))
				textSfrazPre = "Rendita pagabile in rate quadrimestrali";
			else if(getFrazionamentoPremio().equalsIgnoreCase("4"))
				textSfrazPre = "Rendita pagabile in rate trimestrali";
			else if(getFrazionamentoPremio().equalsIgnoreCase("6"))
				textSfrazPre = "Rendita pagabile in rate bimestrali";
			else if(getFrazionamentoPremio().equalsIgnoreCase("12"))
				textSfrazPre = "Rendita pagabile in rate mensili";
		
		}
		else
			textSfrazPre = "";
		return textSfrazPre;
	}
	
	public String getTextPerfezionamento(){
		if(getCodiceAgenzia().equalsIgnoreCase("820") || getCodiceAgenzia().equalsIgnoreCase("900"))
			textPerfezionamento = "Il perfezionamento del presente elenco N° "+getNumElenco()+ 
								  " della Convenzione N° "+getNumConvenzione()+" e' avvenuto oggi "+
								  "__/__/____ in ____________________ con la firma della Contraente.";
		else
			textPerfezionamento = "";
		
		return textPerfezionamento;
	}
	
	public String getTextVersamentoPremio() {
		if(!isRamoPrimo && isPremioUnico()){ //premio unico ramo terzo
			if(getCodiceEmissione().equalsIgnoreCase("10"))
				textVersamentoPremio = "A seguito dell'emissione del presente elenco la Contraente versa un premio unico d'importo " +
									   "pari a lordi Euro "+NumberUtils.formatImporto(getImportoValoreLordo(), ".", ",") +" con valuta posta al "+getDataDecorrenza()+".";
				
			else if(getCodiceEmissione().equalsIgnoreCase("80") || getCodiceEmissione().equalsIgnoreCase("89"))
				textVersamentoPremio = "Le garanzie emesse nell'ambito del presente elenco sostituiscono quelle riportate nell'allegato "+
									   " N° 1, con trasferimento delle disponibilita' maturate. \n A seguito della suddetta operazione di sostituzione la Contraente, "+
									   "al perfezionamento del presente elenco, non versa alcun premio.";
			
			else if(getCodiceEmissione().equalsIgnoreCase("82"))
				textVersamentoPremio = "Le garanzie emesse nell'ambito del presente elenco derivano dal reimpiego della Riserva Matematica maturata "+
									   "dagli Assicurati presso gli enti riportati nell'allegato N° 1. \n A seguito della suddetta operazione di reimpiego di Riserve Matematiche "+
						               "la Contraente, al perfezionamento del presente elenco, non versa alcun premio.";
		}
		else if(!isRamoPrimo){ //premio Annuale ramo terzo
			if(getCodiceEmissione().equalsIgnoreCase("10") || getCodiceEmissione().equalsIgnoreCase("89"))
				textVersamentoPremio = "A seguito dell'emissione del presente elenco la Contraente versa un premio annuo "+
										getTextSfrazPre()+" di importo pari a lordi Euro "+NumberUtils.formatImporto(getImportoValoreLordo(), ".", ",") +" con valuta"+
										" posta al "+getDataDecorrenza()+".";
			else
				textVersamentoPremio = "Le garanzie emesse nell'ambito del presente elenco sostituiscono quelle riportate nell'allegato "+
									   " N° 1, con trasferimento delle disponibilita' maturate. A partire dal "+getDataInizioCopertura() +
									   " la Contraente versa un premio annuo "+getTextSfrazPre()+" ciascuna di importo pari a lordi Euro "+
									   NumberUtils.formatImporto(getImportoValoreLordo(), ".", ",") + " con valuta posta al "+ getDataDecorrenza();
			
		}
		else if(isRamoPrimo && isPremioUnico){
			if(this.codiceEmissione.equalsIgnoreCase("10"))
				textVersamentoPremio = "A seguito dell'emissione del presente elenco la Contraente versa un premio unico d'importo "+
									   " pari a lordi Euro "+NumberUtils.formatImporto(getImportoValoreLordo(), ".", ",");
			else if(this.codiceEmissione.equalsIgnoreCase("80") || this.codiceEmissione.equalsIgnoreCase("89"))
				textVersamentoPremio = "Le garanzie emesse nell'ambito del presente elenco sostituiscono quelle riportate nell'Allegato N° 1, "+
									   "con trasferimento delle disponibilita' maturate. \n A seguito della suddetta operazione di sostituzione la Contraente, " +
									   "al perfezionamento del presente elenco, non versa alcun premio.";
			
			else if(this.codiceEmissione.equalsIgnoreCase("82"))
				textVersamentoPremio = "Le garanzie emesse nell'ambito del presente elenco derivano dal reimpiego della Riserva Matematica maturata " +
										"dagli Assicurati presso gli enti riportati nell'allegato N°1. \n A seguito della suddetta operazione di reimpiego di Riserve "+
										"Matematiche la Contraente, al perfezionamento del presente elenco, non versa alcun premio.";
			else
				textVersamentoPremio = "";
		}
		else if(isRamoPrimo){ //premio Annuale ramo primo
			if(this.codiceEmissione.equalsIgnoreCase("10") || this.codiceEmissione.equalsIgnoreCase("89"))
				textVersamentoPremio = "A seguito dell'emissione del presente elenco la Contraente versa un premio annuo "+
										getTextSfrazPre() + " d'importo pari a lordi Euro "+NumberUtils.formatImporto(getImportoValoreLordo(), ".", ",") +" così costituite: ";
			else
				textVersamentoPremio = "Le garanzie emesse nell'ambito del presente elenco sostituiscono quelle riportate nell'Allegato N° 1, "+
									   "con trasferimento delle disponibilita' maturate. A partire dal "+getDataInizioCopertura()+
									   " la Contraente versa un premio annuo "+getTextSfrazPre()+" anticipate ciascuna di importo pari "+
									   "a lordi Euro "+NumberUtils.formatImporto(getImportoValoreLordo(), ".", ",") +" così costituite: ";
		}
		else
			textVersamentoPremio = "";
		return textVersamentoPremio;
	}

	public String getTextInvestimento() {
		if(getCodiceEmissione().equalsIgnoreCase("10"))
			textInvestimento= "Il suddetto premio unico è stato investito nei fondi della Societa'," +
					"contraddistinti dalla sigla "+getCodiceFondo()+", in data "+getDataRiferimentoNav()+
					", in conformita' a quanto previsto dalla Convenzione.";
		else if(getCodiceEmissione().equalsIgnoreCase("82"))
			textInvestimento = "Le disponibilita' trasferite sono state investite nei fondi interni della Societa',"+
					"contraddistinti dalla sigla F.U.L. 2, in data "+getDataRiferimentoNav()+
					", in conformita' a quanto previsto dalla Convenzione";
		else
			textInvestimento = "";
		return textInvestimento;
	}
	
	public String getCodiceFondo() {
		return codiceFondo;
	}

	public void setCodiceFondo(String codiceFondo) {
		this.codiceFondo = codiceFondo;
	}
	
	public String getDataRiferimentoNav() {
		return FormatterFactory.getStandardDate(dataRiferimentoNav);
	}
	
	public void setDataRiferimentoNav(Date dataRiferimentoNav) {
		this.dataRiferimentoNav = dataRiferimentoNav;
	}
	
	public String getCodiceEmissione() {
		return codiceEmissione;
	}

	public void setCodiceEmissione(String codiceEmissione) {
		this.codiceEmissione = codiceEmissione;
	}

	public String getFrazionamentoPremio() {
		return frazionamentoPremio;
	}

	public void setFrazionamentoPremio(String frazionamentoPremio) {
		this.frazionamentoPremio = frazionamentoPremio;
	}

	public String getCodiceAgenzia() {
		return codiceAgenzia;
	}

	public void setCodiceAgenzia(String codiceAgenzia) {
		this.codiceAgenzia = codiceAgenzia;
	}
	
	public String getDataEmissione() {
		return FormatterFactory.getStandardDate(dataEmissione);
	}

	public String getDataDecorrenza() {
		return FormatterFactory.getStandardDate(dataDecorrenza);
	}

	public String getDataInizioCopertura() {
		return FormatterFactory.getStandardDate(dataInizioCopertura);
	}

	public void setDataInizioCopertura(Date dataInizioCopertura) {
		this.dataInizioCopertura = dataInizioCopertura;
	}

	public void setDataDecorrenza(Date dataDecorrenza) {
		this.dataDecorrenza = dataDecorrenza;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Double getImportoValoreLordo() {
		return importoValoreLordo;
	}

	public void setImportoValoreLordo(Double importoValoreLordo) {
		this.importoValoreLordo = importoValoreLordo;
	}
	
	public List<Importi> getImportiRI() {
		return importiRI;
	}

	public void setImportiRI(List<Importi> importiRI) {
		this.importiRI = importiRI;
	}

	public String getCodicePrestazione() {
		return codicePrestazione;
	}

	public void setCodicePrestazione(String codicePrestazione) {
		this.codicePrestazione = codicePrestazione;
	}

	public String getPremioTariffa() {
		return premioTariffa;
	}

	public void setPremioTariffa(String premioTariffa) {
		this.premioTariffa = premioTariffa;
	}

	@Override
	public String toString() {
		return "Intestazione [numConvenzione=" + numConvenzione
				+ ", numElenco=" + numElenco + ", numAgenzia=" + numAgenzia
				+ ", codiceAgenzia=" + codiceAgenzia + ", nome=" + nome
				+ ", cognome=" + cognome + ", codFisc=" + codFisc + ", citta="
				+ citta + ", prov=" + prov + ", cap=" + cap + ", ind=" + ind
				+ ", numTariffa=" + numTariffa + ", descTariffa=" + descTariffa
				+ ", premioTariffa=" + premioTariffa + ", codiceEmissione="
				+ codiceEmissione + ", codicePrestazione=" + codicePrestazione
				+ ", textGaranzie=" + textGaranzie + ", textSfrazPre="
				+ textSfrazPre + ", frazionamentoPremio=" + frazionamentoPremio
				+ ", textVersamentoPremio=" + textVersamentoPremio
				+ ", textPerfezionamento=" + textPerfezionamento
				+ ", dataEmissione=" + dataEmissione + ", dataDecorrenza="
				+ dataDecorrenza + ", dataInizioCopertura="
				+ dataInizioCopertura + ", importoValoreLordo="
				+ importoValoreLordo + ", importiRI=" + importiRI
				+ ", textInvestimento=" + textInvestimento
				+ ", dataRiferimentoNav=" + dataRiferimentoNav
				+ ", codiceFondo=" + codiceFondo + ", isPremioUnico="
				+ isPremioUnico + ", isRamoPrimo=" + isRamoPrimo + "]";
	}
	
	
	

}
