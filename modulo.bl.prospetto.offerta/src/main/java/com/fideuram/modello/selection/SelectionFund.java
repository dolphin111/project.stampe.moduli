package com.fideuram.modello.selection;

import com.fideuram.utils.LoggingUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La Fundohouse è la casa che rilascia gli OICR
 * Created by
 * User: logan
 * Date: 06/06/12
 * Time: 14.18
 * Rendimento medio composto su base annua
 */
@Deprecated
public class SelectionFund implements Serializable {

    protected String nome;          //OICR APPARTENENTI ALLA SELECTION FIDEURAM
    protected String puntatore;
    protected List<Fundhouse> fundhouses;

    private boolean propostaInvestimento;
    private boolean primoFondoEsterno; //mi serve nel template per inserire il testo e le note una volta sola a cappello dei fondi esterni
    private boolean fondoInterno;
    private List<Isin> isinsInterni;
    private List<Isin> isinsEsterni;
    private boolean isNotEsisteFideuram = true;
    private boolean isNotEsistePartners = true;
    private boolean isEtfFvInsieme = false;
    

	/**
	 * @return the isEtfFvInsieme
	 */
	public boolean isEtfFvInsieme() {
		return isEtfFvInsieme;
	}

	/**
	 * @param isEtfFvInsieme the isEtfFvInsieme to set
	 */
	public void setEtfFvInsieme(boolean isEtfFvInsieme) {
		this.isEtfFvInsieme = isEtfFvInsieme;
	}

	/**
	 * @return the isNotEsisteFideuram
	 */
	public boolean isNotEsisteFideuram() {
		return isNotEsisteFideuram;
	}

	/**
	 * @param isNotEsisteFideuram the isNotEsisteFideuram to set
	 */
	public void setNotEsisteFideuram(boolean isNotEsisteFideuram) {
		this.isNotEsisteFideuram = isNotEsisteFideuram;
	}

	/**
	 * @return the isNotEsistePartners
	 */
	public boolean isNotEsistePartners() {
		return isNotEsistePartners;
	}

	/**
	 * @param isNotEsistePartners the isNotEsistePartners to set
	 */
	public void setNotEsistePartners(boolean isNotEsistePartners) {
		this.isNotEsistePartners = isNotEsistePartners;
	}

	public List<Isin> getIsinsInterni() {
    	if(isinsInterni == null){
    		isinsInterni = new ArrayList<Isin>();
    	}
		return isinsInterni;
	}

	public void setIsinsInterni(List<Isin> isinsInterni) {
		this.isinsInterni = isinsInterni;
	}

	public List<Isin> getIsinsEsterni() {
		if(isinsEsterni == null){
			isinsEsterni = new ArrayList<Isin>();
		}
		return isinsEsterni;
	}

	public void setIsinsEsterni(List<Isin> isinsEsterni) {
		this.isinsEsterni = isinsEsterni;
	}

    public boolean isPropostaInvestimento() {
        return propostaInvestimento;
    }

    public void setPropostaInvestimento(boolean propostaInvestimento) {
        this.propostaInvestimento = propostaInvestimento;
    }

    public Boolean getFondoInterno() {
        return fondoInterno;
    }

    public Boolean isFondoEsterno() {
        if(fondoInterno||propostaInvestimento)
            return false;
        return true;
    }


    public String getProvenienzaSelezione(){
        if(fondoInterno)
            return "FONDI INTERNI";
        return "FONDI ESTERNI - ";
    }

    public Boolean getPrimoFondoEsterno() {
        return primoFondoEsterno;
    }

    public boolean hasNotFundhouses(){
        if(null==fundhouses || (null!=fundhouses && fundhouses.size()==0))
            return true;
        return false;
    }

    public String getPuntatore() {
        return puntatore;
    }

    public void setFondoInterno(Boolean fondoInterno) {
        this.fondoInterno = fondoInterno;
    }

    public void setPrimoFondoEsterno(Boolean primoFondoEsterno) {
        this.primoFondoEsterno = primoFondoEsterno;
    }

    public void setPuntatore(String puntatore) {
        this.puntatore = puntatore;
    }

    public String getNome() {
        LoggingUtils.info("SELECION :"+nome);
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public List<Fundhouse> getFundhouses() {
        if(null==fundhouses)
            fundhouses=new ArrayList<Fundhouse>();
        return fundhouses;
    }

    public void setFundhouses(List<Fundhouse> fundhouses) {
        this.fundhouses = fundhouses;
    }

    public String getTipo() {
        return  nome.startsWith("ETF")?"ETF":"OICR";
    }

    public void addFundhouses( Fundhouse  fundhouse) {
        if(null==fundhouses)
            fundhouses=new ArrayList<Fundhouse>();
        this.fundhouses.add(fundhouse);
    }

    /**
     * Restituisce true se contiene almento un elemento Fundhouse
     * @return
     */
    public boolean hasFundhouse(){
        if(null!=fundhouses&&fundhouses.size()>0)
            return true;
        return false;
    }
}
