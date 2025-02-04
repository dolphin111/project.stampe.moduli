package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AltriDatiFiscali")
@XmlAccessorType(XmlAccessType.FIELD)
public class AltriDatiFiscali {
	 
	private double impostaLorda;
	private double detrazFamiglia; // Detrazioni per carichi di famiglia
	private double detrazFamNum; // Detrazioni per famiglie numerose
	private double credRiconFamNum; // Credito riconosciuto per famiglie numerose
	private double credNoRicFamNum; // Credito non riconosciuto per famiglie numerose
	private double  credFamNumRec; // Credito per famiglie numerose recuperato
	private double  detrLavDip_Pens_Redditi; // Detrazioni per lavoro dipendente, pensioni e redditi assimilati
	private double  detrOneri; // Detrazioni per oneri
	private double  detrCanLoc; // Detrazioni per canoni di locazione
	private double  credRicCanLoc; // Credito riconosciuto per canoni di locazione
	private double  credNoRicCanLoc; // Credito non riconosciuto per canoni di locazione
	private double  credCanLocRec; // Credito per canoni di locazione recuperato
	private double  totDetrazioni; // Totale detrazioni
	private double  credImpPagEstero; // Credito d'imposta per le imposte pagate all'estero
	private double  contrPrevComplEsclRedditi; // Contributi previdenza complementare esclusi dai redditi di cui ai punti 1 e 2
	private double  contrPrevComplNoEsclRedditi; // Contributi previdenza complementare non esclusi dai redditi di cui ai punti 1 e 2
	
	// Contributi previdenza complementare lavoratori di prima occupazione CPCLPO
	private double  CPCLPOVersati; // Versati nell'anno
	private double  CPCLPOEcced; // Importi eccedenti esclusi dai redditi di cui ai punti 1 e 2
	private double  CPCLPOTot; // Importo totale
	private double  CPCLPODiffer; // Differenziale
	private double  CPCLPOAnniRes; // Anni residui
	private double  CPCLPOPrevCompFam; // Previdenza complementare per familiari a carico
	private double  CPCLPOTotOneriNORedditi; // Totale oneri sostenuti esclusi dai redditi indicati nei punti 1 e 2
	private double  CPCLPOTotOneriNOEsclRedditi; // Totale oneri sostenuti non esclusi dai redditi indicati nei punti 1 e 2
	private double  CPCLPOTotOneriDetraz; // Totale oneri per i quali ' prevista la detrazione d'imposta
	private double  CPCLPOContrAssist; // Contributi versati a enti e casse aventi esclusivamente fini assistenziali
	private double  CPCLPOAssicSanit; // Assicurazioni sanitarie
	private double  CPCLPOApplMagRit; // Applicazione maggiore ritenuta
	private double  CPCLPOCasiPart; // Casi particolari
	private double  CPCLPOContrSolid; // Contributo di solidarieta'
	private double  CPCLPOContrSolidSosp; // Contributo di solidarieta' sospeso
	
	
	
	public double getImpostaLorda() {
		return impostaLorda;
	}
	public void setImpostaLorda(double impostaLorda) {
		this.impostaLorda = impostaLorda;
	}
	public double getDetrazFamiglia() {
		return detrazFamiglia;
	}
	public void setDetrazFamiglia(double detrazFamiglia) {
		this.detrazFamiglia = detrazFamiglia;
	}
	public double getDetrazFamNum() {
		return detrazFamNum;
	}
	public void setDetrazFamNum(double detrazFamNum) {
		this.detrazFamNum = detrazFamNum;
	}
	public double getCredRiconFamNum() {
		return credRiconFamNum;
	}
	public void setCredRiconFamNum(double credRiconFamNum) {
		this.credRiconFamNum = credRiconFamNum;
	}
	public double getCredNoRicFamNum() {
		return credNoRicFamNum;
	}
	public void setCredNoRicFamNum(double credNoRicFamNum) {
		this.credNoRicFamNum = credNoRicFamNum;
	}
	public double getCredFamNumRec() {
		return credFamNumRec;
	}
	public void setCredFamNumRec(double credFamNumRec) {
		this.credFamNumRec = credFamNumRec;
	}
	public double getDetrLavDip_Pens_Redditi() {
		return detrLavDip_Pens_Redditi;
	}
	public void setDetrLavDip_Pens_Redditi(double detrLavDip_Pens_Redditi) {
		this.detrLavDip_Pens_Redditi = detrLavDip_Pens_Redditi;
	}
	public double getDetrOneri() {
		return detrOneri;
	}
	public void setDetrOneri(double detrOneri) {
		this.detrOneri = detrOneri;
	}
	public double getDetrCanLoc() {
		return detrCanLoc;
	}
	public void setDetrCanLoc(double detrCanLoc) {
		this.detrCanLoc = detrCanLoc;
	}
	public double getCredRicCanLoc() {
		return credRicCanLoc;
	}
	public void setCredRicCanLoc(double credRicCanLoc) {
		this.credRicCanLoc = credRicCanLoc;
	}
	public double getCredNoRicCanLoc() {
		return credNoRicCanLoc;
	}
	public void setCredNoRicCanLoc(double credNoRicCanLoc) {
		this.credNoRicCanLoc = credNoRicCanLoc;
	}
	public double getCredCanLocRec() {
		return credCanLocRec;
	}
	public void setCredCanLocRec(double credCanLocRec) {
		this.credCanLocRec = credCanLocRec;
	}
	public double getTotDetrazioni() {
		return totDetrazioni;
	}
	public void setTotDetrazioni(double totDetrazioni) {
		this.totDetrazioni = totDetrazioni;
	}
	public double getCredImpPagEstero() {
		return credImpPagEstero;
	}
	public void setCredImpPagEstero(double credImpPagEstero) {
		this.credImpPagEstero = credImpPagEstero;
	}
	public double getContrPrevComplEsclRedditi() {
		return contrPrevComplEsclRedditi;
	}
	public void setContrPrevComplEsclRedditi(double contrPrevComplEsclRedditi) {
		this.contrPrevComplEsclRedditi = contrPrevComplEsclRedditi;
	}
	public double getContrPrevComplNoEsclRedditi() {
		return contrPrevComplNoEsclRedditi;
	}
	public void setContrPrevComplNoEsclRedditi(double contrPrevComplNoEsclRedditi) {
		this.contrPrevComplNoEsclRedditi = contrPrevComplNoEsclRedditi;
	}
	public double getCPCLPOVersati() {
		return CPCLPOVersati;
	}
	public void setCPCLPOVersati(double cPCLPOVersati) {
		CPCLPOVersati = cPCLPOVersati;
	}
	public double getCPCLPOEcced() {
		return CPCLPOEcced;
	}
	public void setCPCLPOEcced(double cPCLPOEcced) {
		CPCLPOEcced = cPCLPOEcced;
	}
	public double getCPCLPOTot() {
		return CPCLPOTot;
	}
	public void setCPCLPOTot(double cPCLPOTot) {
		CPCLPOTot = cPCLPOTot;
	}
	public double getCPCLPODiffer() {
		return CPCLPODiffer;
	}
	public void setCPCLPODiffer(double cPCLPODiffer) {
		CPCLPODiffer = cPCLPODiffer;
	}
	public double getCPCLPOAnniRes() {
		return CPCLPOAnniRes;
	}
	public void setCPCLPOAnniRes(double cPCLPOAnniRes) {
		CPCLPOAnniRes = cPCLPOAnniRes;
	}
	public double getCPCLPOPrevCompFam() {
		return CPCLPOPrevCompFam;
	}
	public void setCPCLPOPrevCompFam(double cPCLPOPrevCompFam) {
		CPCLPOPrevCompFam = cPCLPOPrevCompFam;
	}
	public double getCPCLPOTotOneriNORedditi() {
		return CPCLPOTotOneriNORedditi;
	}
	public void setCPCLPOTotOneriNORedditi(double cPCLPOTotOneriNORedditi) {
		CPCLPOTotOneriNORedditi = cPCLPOTotOneriNORedditi;
	}
	public double getCPCLPOTotOneriNOEsclRedditi() {
		return CPCLPOTotOneriNOEsclRedditi;
	}
	public void setCPCLPOTotOneriNOEsclRedditi(double cPCLPOTotOneriNOEsclRedditi) {
		CPCLPOTotOneriNOEsclRedditi = cPCLPOTotOneriNOEsclRedditi;
	}
	public double getCPCLPOTotOneriDetraz() {
		return CPCLPOTotOneriDetraz;
	}
	public void setCPCLPOTotOneriDetraz(double cPCLPOTotOneriDetraz) {
		CPCLPOTotOneriDetraz = cPCLPOTotOneriDetraz;
	}
	public double getCPCLPOContrAssist() {
		return CPCLPOContrAssist;
	}
	public void setCPCLPOContrAssist(double cPCLPOContrAssist) {
		CPCLPOContrAssist = cPCLPOContrAssist;
	}
	public double getCPCLPOAssicSanit() {
		return CPCLPOAssicSanit;
	}
	public void setCPCLPOAssicSanit(double cPCLPOAssicSanit) {
		CPCLPOAssicSanit = cPCLPOAssicSanit;
	}
	public double getCPCLPOApplMagRit() {
		return CPCLPOApplMagRit;
	}
	public void setCPCLPOApplMagRit(double cPCLPOApplMagRit) {
		CPCLPOApplMagRit = cPCLPOApplMagRit;
	}
	public double getCPCLPOCasiPart() {
		return CPCLPOCasiPart;
	}
	public void setCPCLPOCasiPart(double cPCLPOCasiPart) {
		CPCLPOCasiPart = cPCLPOCasiPart;
	}
	public double getCPCLPOContrSolid() {
		return CPCLPOContrSolid;
	}
	public void setCPCLPOContrSolid(double cPCLPOContrSolid) {
		CPCLPOContrSolid = cPCLPOContrSolid;
	}
	public double getCPCLPOContrSolidSosp() {
		return CPCLPOContrSolidSosp;
	}
	public void setCPCLPOContrSolidSosp(double cPCLPOContrSolidSosp) {
		CPCLPOContrSolidSosp = cPCLPOContrSolidSosp;
	}
	
	
	
	
}
