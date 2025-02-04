package com.fideuram.crm.stampe.serviceclient.bi;

public class WSRiscattoParzialeTendenzaBean {
	/*
	<ImportoRichiesto>1000</ImportoRichiesto>
	<ValoreRiscattoLordo>0</ValoreRiscattoLordo>
	<ImposteRiscatto>0</ImposteRiscatto>
	<CommissioniRiscatto>0</CommissioniRiscatto>
	<CapitaleRiscatto>0</CapitaleRiscatto>
	<ValoreRiscattoNetto>0</ValoreRiscattoNetto>
	*/
	
	private String importoRichiesto;
	private String valoreRiscattoLordo;
	private String imposteRiscatto;
	private String commissioniRiscatto;
	private String capitaleRiscatto;
	private String valoreRiscattoNetto;	
	
	public String getCapitaleRiscatto() {
		return capitaleRiscatto;
	}
	public void setCapitaleRiscatto(String capitaleRiscatto) {
		this.capitaleRiscatto = capitaleRiscatto;
	}
	public String getImportoRichiesto() {
		return importoRichiesto;
	}
	public void setImportoRichiesto(String importoRichiesto) {
		this.importoRichiesto = importoRichiesto;
	}
	public String getValoreRiscattoLordo() {
		return valoreRiscattoLordo;
	}
	public void setValoreRiscattoLordo(String valoreRiscattoLordo) {
		this.valoreRiscattoLordo = valoreRiscattoLordo;
	}
	public String getImposteRiscatto() {
		return imposteRiscatto;
	}
	public void setImposteRiscatto(String imposteRiscatto) {
		this.imposteRiscatto = imposteRiscatto;
	}
	public String getCommissioniRiscatto() {
		return commissioniRiscatto;
	}
	public void setCommissioniRiscatto(String commissioniRiscatto) {
		this.commissioniRiscatto = commissioniRiscatto;
	}
	public String getValoreRiscattoNetto() {
		return valoreRiscattoNetto;
	}
	public void setValoreRiscattoNetto(String valoreRiscattoNetto) {
		this.valoreRiscattoNetto = valoreRiscattoNetto;
	}
}