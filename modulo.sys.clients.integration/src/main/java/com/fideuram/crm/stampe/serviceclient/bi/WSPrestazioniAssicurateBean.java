package com.fideuram.crm.stampe.serviceclient.bi;


public class WSPrestazioniAssicurateBean {

	private String TotalePrestazioniCM;
	private String TotalePrestazioniCV;
	private String BonusCM;
	private String BonusCV;
	private String Rendita75Anno;
	private String Rendita80Anno;
	private String Rendita85Anno;
	private String CapitaleMalattiaGrave;
	private String CapitaleMorteInfortunio;
	private String CapitaleMorteInfortunioStradale;
	private String CapitaleSecondoDecesso;
	private String MassimaleInfortunio;
	private String MassimaleMalattia;
   
	public String getTotalePrestazioniCM() {
		return TotalePrestazioniCM;
	}
	public void setTotalePrestazioniCM(String totalePrestazioniCM) {
		TotalePrestazioniCM = totalePrestazioniCM;
	}
	public String getTotalePrestazioniCV() {
		return TotalePrestazioniCV;
	}
	public void setTotalePrestazioniCV(String totalePrestazioniCV) {
		TotalePrestazioniCV = totalePrestazioniCV;
	}
	public String getBonusCM() {
        if(BonusCM.equals(""))
            return "0";
		return BonusCM;
	}
	public void setBonusCM(String bonusCM) {
		BonusCM = bonusCM;
	}
	public String getBonusCV() {
        if(BonusCV.equals(""))
            return "0";
		return BonusCV;
	}
	public void setBonusCV(String bonusCV) {
		BonusCV = bonusCV;
	}
	public String getRendita75Anno() {
		return Rendita75Anno;
	}
	public void setRendita75Anno(String rendita75Anno) {
		Rendita75Anno = rendita75Anno;
	}
	public String getRendita80Anno() {
		return Rendita80Anno;
	}
	public void setRendita80Anno(String rendita80Anno) {
		Rendita80Anno = rendita80Anno;
	}
	public String getRendita85Anno() {
		return Rendita85Anno;
	}
	public void setRendita85Anno(String rendita85Anno) {
		Rendita85Anno = rendita85Anno;
	}
	public void setCapitaleMalattiaGrave(String capitaleMalattiaGrave) {
		CapitaleMalattiaGrave = capitaleMalattiaGrave;
	}
	public String getCapitaleMalattiaGrave() {
		return CapitaleMalattiaGrave;
	}
	public String getCapitaleMorteInfortunio() {
		return CapitaleMorteInfortunio;
	}
	public void setCapitaleMorteInfortunio(String capitaleMorteInfortunio) {
		CapitaleMorteInfortunio = capitaleMorteInfortunio;
	}
	public String getCapitaleMorteInfortunioStradale() {
		return CapitaleMorteInfortunioStradale;
	}
	public void setCapitaleMorteInfortunioStradale(
			String capitaleMorteInfortunioStradale) {
		CapitaleMorteInfortunioStradale = capitaleMorteInfortunioStradale;
	}
	public String getCapitaleSecondoDecesso() {
		return CapitaleSecondoDecesso;
	}
	public void setCapitaleSecondoDecesso(String capitaleSecondoDecesso) {
		CapitaleSecondoDecesso = capitaleSecondoDecesso;
	}
	public String getMassimaleInfortunio() {
		return MassimaleInfortunio;
	}
	public void setMassimaleInfortunio(String massimaleInfortunio) {
		MassimaleInfortunio = massimaleInfortunio;
	}
	public String getMassimaleMalattia() {
		return MassimaleMalattia;
	}
	public void setMassimaleMalattia(String massimaleMalattia) {
		MassimaleMalattia = massimaleMalattia;
	}
	
}
