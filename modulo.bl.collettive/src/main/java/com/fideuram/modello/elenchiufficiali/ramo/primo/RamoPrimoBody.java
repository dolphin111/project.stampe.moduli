package com.fideuram.modello.elenchiufficiali.ramo.primo;

import java.util.Date;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.elenchiufficiali.ramo.Contribuente;
import com.fideuram.modello.elenchiufficiali.ramo.Ramo;
import com.fideuram.utils.NumberUtils;



public class RamoPrimoBody extends Ramo {

	private String numConvenzione;
	
	private Contribuente contr;
	
	//anni eta assicurato (PPOS_ETAASS_AA)
	private String anniAss;
	//mesi eta assicurato (PPOS_ETAASS_MM)
	private String mesiAss;
	//codice classificazione tariffa (TRF_CLASSE)
	private String codClasTar;
	//differimento anni mesi (PPOS_DURDIF_AA/_MM)
	private String anniDif;
	private String mesiDif;
	//durata decorrenza (PPOS_DURDEC)
	private String durDec;
	//premio tariffa (TRF_CDPREMIO)
	private String premTar;
	//codice forma assicurativa (TRF_CDFASS)
	private String codForAss;
	//frazionamento (PCOL_FRAZPRE)
	private String fraz;
	//importo Premio Contro assicurazione (PPOS_PRECAS)
	private Double impPremio;
	//importo rata netta (PPOS_RATANET)
	private Double impRataNetta;
	//importo reintegro di riserva matematica (PPOS_INTRETRO)
	private Double impReiRis;
	//IMPORTO ABBUONO (PPOS_ABBUONO)
	private Double impAbbuono;
	//imPORTO CAPITALE (PPOS_CAPITALE)
	private Double impCapitale;
	//IMPORTO RENDITA (PPOS_RENDITA)
	private Double impRendita;
	//importo contributo dipendente (PPOS_PREMIODIP)
	private Double impDip;
	//importo contributo Azienda (PPOS_PREMIODAT)
	private Double impAzi;
	//importo contributo Volontario (PPOS_PREMIOVOL)
	private Double impVol;
	//importo contributo TFR (PPOS_PREMIOREI)
	private Double impTfr;
	//percentuale soprapremio sanitario (PPOS_PERSSA)
	private Double percSan;
	//percentuale soprapremio sportivo (PPOS_PERSSP)
	private Double percSpo;
	//percentuale soprapremio professionale (PPOS_PERSPR)
	private Double percProf;
	//percentuale soprapremio rischio volo (PPOS_PERSVO)
	private Double percRis;
	//percentuale soprapremio invalidita' (PPOS_PERSIN)
	private Double percInval;
	//codice emissione (PCOL_CODEMI)
	private String codEmi;
	//data fine differimento (PPOS_DTSCARI) 
	private Date dataDiff;
	//codice tariffa complementare (PCOL_CODTRC_1)
	private String codTarCompl;
	//importo rata netta complementare (PPOS_PANTRC)
	private Double impRaComp;
	//Tipo Prestazione (C o R)  (TRF_CDPREST)
	private String tipoPrestaz;
	//Codice Fondo (TRF_CDFND)
	private String codFondo;
	//Premi annui previsti (PPOS_DURPRE)
	private String durPre;
	
	
	//------------------------------metodi get e set-----------------------------//
	public Contribuente getContr() {
		return contr;
	}
	public void setContr(Contribuente contr) {
		this.contr = contr;
	}
	public String getAnniAss() {
		return anniAss;
	}
	public void setAnniAss(String anniAss) {
		this.anniAss = anniAss;
	}
	public String getMesiAss() {
		return mesiAss;
	}
	public void setMesiAss(String mesiAss) {
		this.mesiAss = mesiAss;
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
	public String getDurDec() {
		return durDec;
	}
	public void setDurDec(String durDec) {
		this.durDec = durDec;
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
	public String getFraz() {
		return fraz;
	}
	public void setFraz(String fraz) {
		this.fraz = fraz;
	}
	public Double getImpPremio() {
		return impPremio;
	}
	public void setImpPremio(Double impPremio) {
		this.impPremio = impPremio;
	}
	public Double getImpRataNetta() {
		return impRataNetta;
	}
	public void setImpRataNetta(Double impRataNetta) {
		this.impRataNetta = impRataNetta;
	}
	public Double getImpReiRis() {
		return impReiRis;
	}
	public void setImpReiRis(Double impReiRis) {
		this.impReiRis = impReiRis;
	}
	public Double getImpAbbuono() {
		return impAbbuono;
	}
	public void setImpAbbuono(Double impAbbuono) {
		this.impAbbuono = impAbbuono;
	}
	public Double getImpCapitale() {
		return impCapitale;
	}
	public void setImpCapitale(Double impCapitale) {
		this.impCapitale = impCapitale;
	}
	public Double getImpRendita() {
		return impRendita;
	}
	public void setImpRendita(Double impRendita) {
		this.impRendita = impRendita;
	}
	public Double getImpDip() {
		return impDip;
	}
	public void setImpDip(Double impDip) {
		this.impDip = impDip;
	}
	public Double getImpAzi() {
		return impAzi;
	}
	public void setImpAzi(Double impAzi) {
		this.impAzi = impAzi;
	}
	public Double getImpVol() {
		return impVol;
	}
	public void setImpVol(Double impVol) {
		this.impVol = impVol;
	}
	public Double getImpTfr() {
		return impTfr;
	}
	public void setImpTfr(Double impTfr) {
		this.impTfr = impTfr;
	}
	public Double getPercSan() {
		return percSan;
	}
	public void setPercSan(Double percSan) {
		this.percSan = percSan;
	}
	public Double getPercSpo() {
		return percSpo;
	}
	public void setPercSpo(Double percSpo) {
		this.percSpo = percSpo;
	}
	public Double getPercProf() {
		return percProf;
	}
	public void setPercProf(Double percProf) {
		this.percProf = percProf;
	}
	public Double getPercRis() {
		return percRis;
	}
	public void setPercRis(Double percRis) {
		this.percRis = percRis;
	}
	public Double getPercInval() {
		return percInval;
	}
	public void setPercInval(Double percInval) {
		this.percInval = percInval;
	}
	public Date getDataDiff() {
		return dataDiff;
	}
	public void setDataDiff(Date dataDiff) {
		this.dataDiff = dataDiff;
	}
	//------------------------------fine metodi get e set-----------------------------//
	
	
	
	//------------------------------dati contribuente---------------------------------//

	public String getNumConvenzione() {
		return numConvenzione;
	}
	public void setNumConvenzione(String numConvenzione) {
		this.numConvenzione = numConvenzione;
	}
	public String getCodTarCompl() {
		return codTarCompl;
	}
	public void setCodTarCompl(String codTarCompl) {
		this.codTarCompl = codTarCompl;
	}
	public Double getImpRaComp() {
		return impRaComp;
	}
	public void setImpRaComp(Double impRaComp) {
		this.impRaComp = impRaComp;
	}
	public String getTipoPrestaz() {
		return tipoPrestaz;
	}
	public void setTipoPrestaz(String tipoPrestaz) {
		this.tipoPrestaz = tipoPrestaz;
	}
	public String getCodEmi() {
		return codEmi;
	}
	public void setCodEmi(String codEmi) {
		this.codEmi = codEmi;
	}
	public String getCodFondo() {
		return codFondo;
	}
	public void setCodFondo(String codFondo) {
		this.codFondo = codFondo;
	}
	public String getDurPre() {
		return durPre;
	}
	public void setDurPre(String durPre) {
		this.durPre = durPre;
	}
	@Override
	public String toString() {
		return "RamoPrimoBody [contr=" + contr + ", anniAss=" + anniAss
				+ ", mesiAss=" + mesiAss + ", codClasTar=" + codClasTar
				+ ", anniDif=" + anniDif + ", mesiDif=" + mesiDif + ", durDec="
				+ durDec + ", premTar=" + premTar + ", codForAss=" + codForAss
				+ ", fraz=" + fraz + ", impPremio=" + impPremio
				+ ", impRataNetta=" + impRataNetta + ", impReiRis=" + impReiRis
				+ ", impAbbuono=" + impAbbuono + ", impCapitale=" + impCapitale
				+ ", impRendita=" + impRendita + ", impDip=" + impDip
				+ ", impAzi=" + impAzi + ", impVol=" + impVol + ", impTfr="
				+ impTfr + ", percSan=" + percSan + ", percSpo=" + percSpo
				+ ", impProf=" + percProf + ", impRis=" + percRis + ", impInval="
				+ percInval + ", dataDiff=" + dataDiff + "]";
	}
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
		if(getCodForAss().equalsIgnoreCase("V") && getCodFondo()!= null && !getCodFondo().equalsIgnoreCase(""))
			result = FormatterFactory.getStandardDate(getDataDiff());
		else if(getCodForAss().equalsIgnoreCase("TE") || getCodForAss().equalsIgnoreCase("GR"))
			result = FormatterFactory.getStandardDate(getDataDiff());
		return result;
	}
	
	public String getF1(){
		return getAnniAss()+"/"+getMesiAss();
	}
	
	public String getF2(){
		String result = "";
		if(getCodForAss().equalsIgnoreCase("M") 
				&& getCodFondo()!=null 
				&& !getCodFondo().equals("")
				&& getPremTar().equalsIgnoreCase("A"))
			result = getDurPre();
		else if(getCodForAss().equalsIgnoreCase("V") 
				&& getCodFondo()!=null 
				&& !getCodFondo().equals(""))
			result = getAnniDif()+"/"+getMesiDif();
		else if(getCodForAss().equalsIgnoreCase("TE")
				&& getCodForAss().equalsIgnoreCase("GR")){
			if(Integer.getInteger(getDurDec()).intValue()>=1)
				result = getAnniDif()+"/"+getMesiDif();
			else{
				int value=Integer.getInteger(getDurDec()).intValue()*365;
				result = value+"";
			}
		}
		return result ;
	}
	
	//campo non valorizzato nella colonna G
	public String getG1(){
		double result= getImpCapitale().doubleValue()+getImpRendita().doubleValue();
		return NumberUtils.formatImporto(result, ".", ",");
	}
	public String getG2(){
		return "";
	}
	
	public String getH1(){
		if((getCodEmi().equalsIgnoreCase("82") || 
			getCodEmi().equalsIgnoreCase("89") ||
			getCodEmi().equalsIgnoreCase("84")) && getPremTar().equalsIgnoreCase("U"))
			return NumberUtils.formatImporto(getImpPremio(), ".", ",");
		else
			return NumberUtils.formatImporto(calcoloImportoGaranziaBase(), ".", ",");
	}
	
	public String getH2(){
		String result = "";
		if(getCodTarCompl()!=null && !getCodTarCompl().equals(""))
			result= NumberUtils.formatImporto(getImpRaComp(), ".", ",");
		return result;
	}
	
	public String getJ1(){
		if(!getCodEmi().equalsIgnoreCase("82") || 
		!getCodEmi().equalsIgnoreCase("89"))
			return NumberUtils.formatImporto(calcoloImportoGaranziaBase(), ".", ",");
		else if((getCodEmi().equalsIgnoreCase("82") || 
				getCodEmi().equalsIgnoreCase("89") ||
				getCodEmi().equalsIgnoreCase("84")) && getPremTar().equalsIgnoreCase("U") )
			
			return NumberUtils.formatImporto(calcoloImportoGaranziaBase(), ".", ",");
		else
			return "";
	}
	
	public String getJ2(){
		return "";
	}
	
	public String getL1(){
		String result = "";
		if(getImpReiRis()!=null && getImpReiRis().doubleValue()>0)
			result = NumberUtils.formatImporto(getImpReiRis(), ".", ",");
		else if(getImpAbbuono()!=null && getImpAbbuono().doubleValue()>0)
			result = NumberUtils.formatImporto(getImpAbbuono(), ".", ",");
		else
			result = "";
		return result;
	}
	//la colonna L valorizza solo una riga (L1)
	public String getL2(){
		return "";
	}
	
	//la colonna M compare solo 
	//nel caso di tariffa caso vita (TRF_CDFASS = V)
	public String getM1(){
		if(getCodForAss().equalsIgnoreCase("V"))
			return NumberUtils.formatImporto(calcoloSommaPercentuali(), ".", ",");
					
		else 
			return "";
	}
	//mai valorizzato
	public String getM2(){
		return "";
	}
	
	private Double calcoloImportoGaranziaBase() {
		double resultImporto = new Double(getImpRataNetta()).doubleValue()*new Double(getFraz());
		
		return resultImporto-getImpReiRis().doubleValue()+getImpAbbuono().doubleValue();
	}
	
	private Double calcoloSommaPercentuali(){
		double percentuale= getPercSan().doubleValue()+getPercSpo().doubleValue()+
				getPercProf().doubleValue()+getImpVol().doubleValue()+
				getPercInval().doubleValue();
		return percentuale;
	}
}
