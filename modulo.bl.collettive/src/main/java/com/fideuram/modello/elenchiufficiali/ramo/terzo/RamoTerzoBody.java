package com.fideuram.modello.elenchiufficiali.ramo.terzo;

import java.util.Date;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.elenchiufficiali.ramo.Contribuente;
import com.fideuram.modello.elenchiufficiali.ramo.Ramo;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

public class RamoTerzoBody extends Ramo{

	private String numConvenzione;
	
	private Contribuente contr;
	//codice gestione (PPOS_CODGESSEP)
	private String codGest;
	//codice Fondo (TRF_CDFND)
	private String codFon;
	//valore NAV (PPOS_NAV)
	private String valNav;
	//NUMERO QUOTE (PPOS_QUOTE)
	private String numQuote;
	//Importo netto investito (PPOS_NETINV)
	private Double impNettInv;
	//codice emissione (PCOL_CODEMI)
	private String codEmis;
	//Indicatore tipo prestazione (PPOS_NETINV)
	private String indTipPrest;
	//Importo capitale (PPOS_CAPITALE)
	private Double impCapit;
	//Importo Rendita (PPOS_RENDITA)
	private Double impRend;
	//COEFFICIENTE DI CONVERSIONE IN RENDITA (PPOS_COEFREN)
	private String coefConvRen;
	//tipo rendita (PPOS_TIPREN)
	private String tipoRend;
	//iMPORTO RISERVA MATEMATICA (TDISP_RISERVA)
	private Double impRisMat;
	//durata residua minima (GEDI_DURRES_MIN)
	private String durResMin;
	//durata residua massima (GEDI_DURRES_MAX)
	private String durResMax;
	//codice classificazione tariffa (TRF_CLASSE)
	private String codClasTar;
	//anni di differimento (PPOS_DURDIF_AA)
	private String anniDif;
	//mesi di differimento (PPOS_DURDIF_MM)
	private String mesiDif;
	//durata differimento (PPOS_DURDEC)
	private String durataDif;
	//premio tariffa (TRF_CDPREMIO)
	private String premTar;
	//Codice Forma Assicurativa (TRF_CDFASS)
	private String codForAss;
	//Data Fine Differimento (PPOS_DTSCARI)
	private Date datFineDiff;
	//Premi Annui Previsti (PPOS_DURPRE)
	private String preAnnuiPre;
	//private String codTarCompl;
	//private Double impRataCompl;
	
	
	//------------------------------metodi get e set-----------------------------//
	public Contribuente getContr() {
		return contr;
	}
	public void setContr(Contribuente contr) {
		this.contr = contr;
	}
	public String getCodGest() {
		return codGest;
	}
	public void setCodGest(String codGest) {
		this.codGest = codGest;
	}
	public String getCodFon() {
		return codFon;
	}
	public void setCodFon(String codFon) {
		this.codFon = codFon;
	}
	public String getValNav() {
		return valNav;
	}
	public void setValNav(String valNav) {
		this.valNav = valNav;
	}
	public String getNumQuote() {
		return numQuote;
	}
	public void setNumQuote(String numQuote) {
		this.numQuote = numQuote;
	}
	public Double getImpNettInv() {
		return impNettInv;
	}
	public void setImpNettInv(Double impNettInv) {
		this.impNettInv = impNettInv;
	}
	public String getIndTipPrest() {
		return indTipPrest;
	}
	public void setIndTipPrest(String indTipPrest) {
		this.indTipPrest = indTipPrest;
	}
	public Double getImpCapit() {
		return impCapit;
	}
	public void setImpCapit(Double impCapit) {
		this.impCapit = impCapit;
	}
	public Double getImpRend() {
		return impRend;
	}
	public void setImpRend(Double impRend) {
		this.impRend = impRend;
	}
	public String getCoefConvRen() {
		return coefConvRen;
	}
	public void setCoefConvRen(String coefConvRen) {
		this.coefConvRen = coefConvRen;
	}
	public String getTipoRend() {
		return tipoRend;
	}
	public void setTipoRend(String tipoRend) {
		this.tipoRend = tipoRend;
	}
	public Double getImpRisMat() {
		return impRisMat;
	}
	public void setImpRisMat(Double impRisMat) {
		this.impRisMat = impRisMat;
	}
	public String getDurResMin() {
		return durResMin;
	}
	public void setDurResMin(String durResMin) {
		this.durResMin = durResMin;
	}
	public String getDurResMax() {
		return durResMax;
	}
	public void setDurResMax(String durResMax) {
		this.durResMax = durResMax;
	}
	public String getCodClasTar() {
		return codClasTar;
	}
	public void setCodClasTar(String codClasTar) {
		this.codClasTar = codClasTar;
	}
	public String getAnniDif() {
		return anniDif;
	}
	public void setAnniDif(String anniDif) {
		this.anniDif = anniDif;
	}
	public String getMesiDif() {
		return mesiDif;
	}
	public void setMesiDif(String mesiDif) {
		this.mesiDif = mesiDif;
	}
	public String getDurataDif() {
		return durataDif;
	}
	public void setDurataDif(String durataDif) {
		this.durataDif = durataDif;
	}
	public String getPremTar() {
		return premTar;
	}
	public void setPremTar(String premTar) {
		this.premTar = premTar;
	}
	public String getCodForAss() {
		return codForAss;
	}
	public void setCodForAss(String codForAss) {
		this.codForAss = codForAss;
	}
	public Date getDatFineDiff() {
		return datFineDiff;
	}
	public void setDatFineDiff(Date datFineDiff) {
		this.datFineDiff = datFineDiff;
	}
	//------------------------------fine metodi get e set-----------------------------//
	
	public String getNumConvenzione() {
		return numConvenzione;
	}
	public void setNumConvenzione(String numConvenzione) {
		this.numConvenzione = numConvenzione;
	}
	public String getCodEmis() {
		return codEmis;
	}
	public void setCodEmis(String codEmis) {
		this.codEmis = codEmis;
	}
	
	public String getPreAnnuiPre() {
		return preAnnuiPre;
	}
	public void setPreAnnuiPre(String preAnnuiPre) {
		this.preAnnuiPre = preAnnuiPre;
	}
	@Override
	public String toString() {
		return "RamoTerzoBody [contr=" + contr + ", codGest=" + codGest
				+ ", codFon=" + codFon + ", valNav=" + valNav
				+ ", numQuote=" + numQuote + ", impNettInv=" + impNettInv
				+ ", codEmis=" + codEmis + ", indTipPrest=" + indTipPrest
				+ ", impCapit=" + impCapit + ", impRend=" + impRend
				+ ", coefConvRen=" + coefConvRen + ", tipoRend=" + tipoRend
				+ ", impRisMat=" + impRisMat + ", durResMin=" + durResMin
				+ ", durResMax=" + durResMax + ", codClasTar=" + codClasTar
				+ ", anniDif=" + anniDif + ", mesiDif=" + mesiDif
				+ ", durataDif=" + durataDif + ", premTar=" + premTar
				+ ", codForAss=" + codForAss + ", datFineDiff="
				+ datFineDiff + "]";
	}
	
		//------------------------------dati contribuente---------------------------------//
		//posizione
		public String getA1(){
			return contr.getPosizione();
		}
		//Assicurato
		public String getB1(){
			return contr.getNome()+" "+contr.getCogn();
		}
		//dataNascita
		public String getB2(){
			return contr.getDatNas();
		}
		//codiceFiscale
		public String getC1(){
			return contr.getCodFis();
		}
		//sesso
		public String getD1(){
			return contr.getSesso();
		}
		//decorrenza
		public String getE1(){
			return FormatterFactory.getStandardDate(contr.getDatDecor());
		}
		//---------------------------------dati dinamici----------------------------------//
		public String getE2(){
			String result = "";
			if(getCodForAss().equalsIgnoreCase("V") && getCodFon()!=null)
				result = FormatterFactory.getStandardDate(getDatFineDiff());
			else if(getCodForAss().equalsIgnoreCase("TE") ||getCodForAss().equalsIgnoreCase("GR"))
				result = FormatterFactory.getStandardDate(getDatFineDiff());
			return result;
		}
		//
		public String getF1(){
			String result = "";
			if(getCodForAss().equalsIgnoreCase("M") && getCodFon()!=null && !getCodFon().equals(""))
				result = ""; //da valorizzare
			else if(getCodForAss().equalsIgnoreCase("V") && getCodFon()!=null && !getCodFon().equals(""))
				result = ""; //c'è F2 valorizzato
			else if(getCodForAss().equalsIgnoreCase("TE") || getCodForAss().equalsIgnoreCase("GR"))
				result = ""; //c'è F2 valorizzato
			else if(getCodEmis().equalsIgnoreCase("10") && getIndTipPrest().equalsIgnoreCase("C"))
				result = NumberUtils.formatImporto(getImpCapit(),".", ",");
			else if(getCodEmis().equalsIgnoreCase("10") && getIndTipPrest().equalsIgnoreCase("R"))
				result = NumberUtils.formatImporto(getImpRend(),".", ",");
			else if(getCodEmis().equalsIgnoreCase("82"))
				result = NumberUtils.formatImporto(getImpRend(),".", ",");
			return result;
			
		}
		
		public String getF2(){
			String result = "";
			if(getCodForAss().equalsIgnoreCase("V") && getCodFon()!=null && !getCodFon().equals(""))
				result = getAnniDif()+"/"+getMesiDif();
			else if(getCodForAss().equalsIgnoreCase("TE") || getCodForAss().equalsIgnoreCase("GR")){
				if(new Double(getDurataDif()).doubleValue() >= 1)
					result = getAnniDif()+"/"+getMesiDif();
				else {
					double resultDurata = new Double(getDurataDif()).doubleValue()*365; 
					result = resultDurata+"";
				}
			}
			else if(getCodEmis().equalsIgnoreCase("10") && getIndTipPrest().equalsIgnoreCase("C"))
					result = "";
			else if(getCodEmis().equalsIgnoreCase("10") && getIndTipPrest().equalsIgnoreCase("R")){
				if(getTipoRend().equalsIgnoreCase("CE"))
					result = "C/"+getCoefConvRen();
				else 
					result = "V/"+getCoefConvRen();	
			}
			else if(getCodEmis().equalsIgnoreCase("82")){
				if(getTipoRend().equalsIgnoreCase("CE"))
					result = "C/"+getCoefConvRen();
				else 
					result = "V/"+getCoefConvRen();	

			}
			return result;
		}
		
		public String getG1(){
			String result = "";
			if(getCodEmis().equalsIgnoreCase("10"))
				result = NumberUtils.formatImporto(getImpNettInv(), ".", ",");
			else if(getCodEmis().equalsIgnoreCase("82"))
				result = NumberUtils.formatImporto(getImpRisMat(), ".", ",");
			return result;
		}
		
		public String getG2(){
			return ""; 	
		}
		
		public String getH1(){
			String result = "";
			if(getNumConvenzione().equalsIgnoreCase("5541") || getNumConvenzione().equalsIgnoreCase("5542"))
				result = "FUL2 "+getCodGest().substring(0, 1)+"-20"+getCodGest().substring(getCodGest().length()-2, getCodGest().length()-1);
			else if(getNumConvenzione().equalsIgnoreCase("5879"))
				result = "PORTFOLIO 2";
			else if(getCodFon().equalsIgnoreCase("FAP"))
				result = "FAP"+getCodGest().substring(0, 1)+"-20"+getCodGest().substring(getCodGest().length()-2, getCodGest().length()-1);
			else {
				if(getDurResMin().equalsIgnoreCase(getDurResMax()))
					result = getCodFon()+" "+getDurResMax();
				else
					result = getCodFon()+" "+getDurResMin()+"-"+getDurResMax();
			}
			
			return result;
		}
		
		public String getH2(){
			return getValNav();
		}
		//la colonna J valorizza solo la prima riga del dettaglio
		public String getJ1(){
			return NumberUtils.formatImporto(getImpNettInv(), ".", ",");
		}
		
		public String getJ2(){
			return "";
		}
		
}
