package com.fideuram.crm.stampe.engine;

import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;

/**
 * @author Giorgio Desideri
 *
 */
public class InputDataModel {

	private ComunicazioneVO comunicazione;
	
	private DomandaVO domanda;
	
	private String scenario;
	
	private String triplettaDomanda;
	
	
	/**
	 * @param comunicazione
	 * @param domanda
	 */
	public InputDataModel(ComunicazioneVO comunicazione, DomandaVO domanda) {
		super();
		
		this.comunicazione = comunicazione;
		this.domanda = domanda;
	}

	/**
	 * @param comunicazione
	 * @param domanda
	 * @param scenario
	 * @param triplettaDomanda
	 */
	public InputDataModel(ComunicazioneVO comunicazione, DomandaVO domanda, String scenario, String triplettaDomanda) {
		super();
		
		this.comunicazione = comunicazione;
		this.domanda = domanda;
		this.scenario = scenario;
		this.triplettaDomanda = triplettaDomanda;
	}

	/**
	 * @return the comunicazione
	 */
	public ComunicazioneVO getComunicazione() {
		return comunicazione;
	}

	/**
	 * @param comunicazione the comunicazione to set
	 */
	public void setComunicazione(ComunicazioneVO comunicazione) {
		this.comunicazione = comunicazione;
	}

	/**
	 * @return the domanda
	 */
	public DomandaVO getDomanda() {
		return domanda;
	}

	/**
	 * @param domanda the domanda to set
	 */
	public void setDomanda(DomandaVO domanda) {
		this.domanda = domanda;
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

	/**
	 * @return the triplettaDomanda
	 */
	public String getTriplettaDomanda() {
		return triplettaDomanda;
	}

	/**
	 * @param triplettaDomanda the triplettaDomanda to set
	 */
	public void setTriplettaDomanda(String triplettaDomanda) {
		this.triplettaDomanda = triplettaDomanda;
	}
	
}