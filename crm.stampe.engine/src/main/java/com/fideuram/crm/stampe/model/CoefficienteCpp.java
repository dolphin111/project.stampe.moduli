/**
 * 
 */
package com.fideuram.crm.stampe.model;

/**
 * @author Giorgio Desideri
 *
 */
public class CoefficienteCpp {

	private String tariffa;
	
	private Long appendice;
	
	private Double coefficiente;

	/**
	 * Costruttore vuoto
	 */
	public CoefficienteCpp() {
	}

	/**
	 * Costruttore
	 * 
	 * @param tariffa
	 * @param appendice
	 * @param coefficiente
	 */
	public CoefficienteCpp(String tariffa, Long appendice, Double coefficiente) {
		this.tariffa = tariffa;
		this.appendice = appendice;
		this.coefficiente = coefficiente;
	}

	/**
	 * @return the tariffa
	 */
	public String getTariffa() {
		return tariffa;
	}

	/**
	 * @param tariffa the tariffa to set
	 */
	public void setTariffa(String tariffa) {
		this.tariffa = tariffa;
	}

	/**
	 * @return the appendice
	 */
	public Long getAppendice() {
		return appendice;
	}

	/**
	 * @param appendice the appendice to set
	 */
	public void setAppendice(Long appendice) {
		this.appendice = appendice;
	}

	/**
	 * @return the coefficiente
	 */
	public Double getCoefficiente() {
		return coefficiente;
	}

	/**
	 * @param coefficiente the coefficiente to set
	 */
	public void setCoefficiente(Double coefficiente) {
		this.coefficiente = coefficiente;
	}
	
	
}