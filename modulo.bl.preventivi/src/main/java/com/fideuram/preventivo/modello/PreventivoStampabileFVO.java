package com.fideuram.preventivo.modello;


import java.util.List;

public class PreventivoStampabileFVO extends PreventivoFVO{


	private static final long serialVersionUID = 2705751783905327790L;
	
	private DichiarazioneDomandaRisposta dichiarazione;
	private Dichiarazione dichiarazioneSemplice;
	
	private String copiaPerFideuram;
	private String copiaPerCliente;
	private List<RigaTabellaA> listRigaTabellaA;
	private List<RigaTabellaB> listRigaTabellaB;

	//variabili come in preventivo ma formato string cosi sono formattabile come serve
	private String carTotStampabile;
	private String percentualeGSStampabile;
	private String quotaGestioneSeparataStampabile;

	private String rlaStampabile; // rendimento lordo ipotesi a
	private String rlbStampabile; // rendimento lordo ipotesi b
	private String rmgStampabile; // rendiento minimo garantito
	private String commStampabile; // commissione , trattenute della compagnia
	private String rnaStampabile;  // rendimento netto ipotsi a
	private String rnbStampabile; // rendimento netto ipotesi b

	private boolean isD;
	private boolean isWarning;
	private boolean isWarningComplementareInfortuni;
	private boolean isWarningComplementareMalattiaGrave;

	private boolean isContraAss;
	
	private List<PremiFVI> premiFV;
	private List<PremiFVIStr> premiFVStr;

	public String getCarTotStampabile() {
		return carTotStampabile;
	}

	public void setCarTotStampabile(String carTotStampabile) {
		this.carTotStampabile = carTotStampabile;
	}

	public String getPercentualeGSStampabile() {
		return percentualeGSStampabile;
	}

	public void setPercentualeGSStampabile(String percentualeGSStampabile) {
		this.percentualeGSStampabile = percentualeGSStampabile;
	}

	public String getQuotaGestioneSeparataStampabile() {
		return quotaGestioneSeparataStampabile;
	}

	public void setQuotaGestioneSeparataStampabile(String quotaGestioneSeparataStampabile) {
		this.quotaGestioneSeparataStampabile = quotaGestioneSeparataStampabile;
	}

	public String getRlaStampabile() {
		return rlaStampabile;
	}

	public void setRlaStampabile(String rlaStampabile) {
		this.rlaStampabile = rlaStampabile;
	}

	public String getRlbStampabile() {
		return rlbStampabile;
	}

	public void setRlbStampabile(String rlbStampabile) {
		this.rlbStampabile = rlbStampabile;
	}

	public String getRmgStampabile() {
		return rmgStampabile;
	}

	public void setRmgStampabile(String rmgStampabile) {
		this.rmgStampabile = rmgStampabile;
	}

	public String getCommStampabile() {
		return commStampabile;
	}

	public void setCommStampabile(String commStampabile) {
		this.commStampabile = commStampabile;
	}

	public String getRnaStampabile() {
		return rnaStampabile;
	}

	public void setRnaStampabile(String rnaStampabile) {
		this.rnaStampabile = rnaStampabile;
	}

	public String getRnbStampabile() {
		return rnbStampabile;
	}

	public void setRnbStampabile(String rnbStampabile) {
		this.rnbStampabile = rnbStampabile;
	}

	public List<RigaTabellaA> getListRigaTabellaA() {
		return listRigaTabellaA;
	}

	public void setListRigaTabellaA(List<RigaTabellaA> listRigaTabellaA) {
		this.listRigaTabellaA = listRigaTabellaA;
	}

	public List<RigaTabellaB> getListRigaTabellaB() {
		return listRigaTabellaB;
	}

	public void setListRigaTabellaB(List<RigaTabellaB> listRigaTabellaB) {
		this.listRigaTabellaB = listRigaTabellaB;
	}
	
	public String getCopiaPerFideuram() {
		return copiaPerFideuram;
	}

	public void setCopiaPerFideuram(String copiaPerFideuram) {
		this.copiaPerFideuram = copiaPerFideuram;
	}

	public String getCopiaPerCliente() {
		return copiaPerCliente;
	}

	public void setCopiaPerCliente(String copiaPerCliente) {
		this.copiaPerCliente = copiaPerCliente;
	}

	public DichiarazioneDomandaRisposta getDichiarazione() {
        return dichiarazione;
    }

    public void setDichiarazione(DichiarazioneDomandaRisposta dichiarazione) {
        this.dichiarazione = dichiarazione;
    }

	public Boolean getD() {
		return isD;
	}

	public void setD(boolean d) {
		isD = d;
	}

	public boolean isWarning() {
		return isWarning;
	}

	public void setWarning(boolean isWarning) {
		this.isWarning = isWarning;
	}

	public boolean isWarningComplementareInfortuni() {
		return isWarningComplementareInfortuni;
	}

	public void setWarningComplementareInfortuni(
			boolean isWarningComplementareInfortuni) {
		this.isWarningComplementareInfortuni = isWarningComplementareInfortuni;
	}

	public boolean isWarningComplementareMalattiaGrave() {
		return isWarningComplementareMalattiaGrave;
	}

	public void setWarningComplementareMalattiaGrave(
			boolean isWarningComplementareMalattiaGrave) {
		this.isWarningComplementareMalattiaGrave = isWarningComplementareMalattiaGrave;
	}

	public boolean isContraAss() {
		return isContraAss;
	}

	public void setContraAss(boolean isContraAss) {
		this.isContraAss = isContraAss;
	}

	public Dichiarazione getDichiarazioneSemplice() {
		return dichiarazioneSemplice;
	}

	public void setDichiarazioneSemplice(Dichiarazione dichiarazioneSemplice) {
		this.dichiarazioneSemplice = dichiarazioneSemplice;
	}

	public List<PremiFVI> getPremiFV() {
		return premiFV;
	}

	public void setPremiFV(List<PremiFVI> premiFV) {
		this.premiFV = premiFV;
	}

	public List<PremiFVIStr> getPremiFVStr() {
		return premiFVStr;
	}

	public void setPremiFVStr(List<PremiFVIStr> premiFVStr) {
		this.premiFVStr = premiFVStr;
	}
	
}