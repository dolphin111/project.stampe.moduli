package com.fideuram.crm.stampe.model;

import com.fideuram.attori.bo.IPersona;
import com.thoughtworks.xstream.XStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Giuseppe 
 * @author Giorgio Desideri
 * 
 */
public class Modello {
	private Lettera lettera;
    //private Persona contraente;
	private IPersona proponente;
	private IPersona richiedente;
	private IPersona altro;
	
	private List<Polizza> polizze;
	private LiquidazionePratica liqPratica;
	private List<Contraente> contraenti;

	/**
	 * @return
	 */
	public String toXml() {
		XStream xstream = new XStreamUtils().readXStream();

        xstream.alias("model", Modello.class);
        xstream.alias("polizza", com.fideuram.crm.stampe.model.Polizza.class);
        
        xstream.alias("liquidazione", com.fideuram.crm.stampe.model.Liquidazione.class);
        xstream.alias("titolo", com.fideuram.crm.stampe.model.Titolo.class);
        xstream.alias("coefficienteCpp", com.fideuram.crm.stampe.model.CoefficienteCpp.class);
        xstream.alias("praticaSpiegazioneConteggi", com.fideuram.crm.stampe.model.PraticaSpiegazioneConteggi.class);

        xstream.alias("liqPratica", com.fideuram.crm.stampe.model.LiquidazionePratica.class);
        String xml = xstream.toXML(this);
        
        return xml;
	}

	/**
	 * @param xml
	 * @return
	 */
	public static Map<String, Object> fromXml(String xml) {
		XStream xstream = new XStreamUtils().readXStream();
        xstream.alias("model", Modello.class);
        xstream.alias("polizza", com.fideuram.crm.stampe.model.Polizza.class);
        xstream.alias("liquidazione", com.fideuram.crm.stampe.model.Liquidazione.class);
        xstream.alias("titolo", com.fideuram.crm.stampe.model.Titolo.class);
        xstream.alias("coefficienteCpp", com.fideuram.crm.stampe.model.CoefficienteCpp.class);
        xstream.alias("praticaSpiegazioneConteggi", com.fideuram.crm.stampe.model.PraticaSpiegazioneConteggi.class);
        xstream.alias("liqPratica", com.fideuram.crm.stampe.model.LiquidazionePratica.class);
        
        Modello modello = (Modello) xstream.fromXML(xml);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("intestazione", modello.getLettera());
        map.put("proponente", modello.getProponente());
        map.put("richiedente", modello.getRichiedente());
        map.put("altro", modello.getAltro());
        map.put("polizze", modello.getPolizze());
        map.put("liqPratica", modello.getLiquidazionePratica());
        map.put("contraenti", modello.getContraenti());
        return map;
	}

	/**
	 * @return the liquidazionePratica
	 */
	public LiquidazionePratica getLiquidazionePratica() {
		return liqPratica;
	}

	/**
	 * @param liquidazionePratica the liquidazionePratica to set
	 */
	public void setLiquidazionePratica(LiquidazionePratica liquidazionePratica) {
		this.liqPratica = liquidazionePratica;
	}
	
	/**
	 * @return the lettera
	 */
	public Lettera getLettera() {
		return lettera;
	}

	/**
	 * @param lettera the lettera to set
	 */
	public void setLettera(Lettera lettera) {
		this.lettera = lettera;
	}



    /**
	 * @return the proponente
	 */
	public IPersona getProponente() {
		return proponente;
	}

	/**
	 * @param proponente the proponente to set
	 */
	public void setProponente(IPersona proponente) {
		this.proponente = proponente;
	}

	/**
	 * @return the richiedente
	 */
	public IPersona getRichiedente() {
		return richiedente;
	}

	/**
	 * @param richiedente the richiedente to set
	 */
	public void setRichiedente(IPersona richiedente) {
		this.richiedente = richiedente;
	}

	/**
	 * @return the altro
	 */
	public IPersona getAltro() {
		return altro;
	}

	/**
	 * @param altro the altro to set
	 */
	public void setAltro(IPersona altro) {
		this.altro = altro;
	}

	/**
	 * @return the polizze
	 */
	public List<Polizza> getPolizze() {
		return polizze;
	}

	/**
	 * @param polizze the polizze to set
	 */
	public void setPolizze(List<Polizza> polizze) {
		this.polizze = polizze;
	}

	public List<Contraente> getContraenti() {
		return contraenti;
	}

	public void setContraenti(List<Contraente> contraenti) {
		this.contraenti = contraenti;
	}
}