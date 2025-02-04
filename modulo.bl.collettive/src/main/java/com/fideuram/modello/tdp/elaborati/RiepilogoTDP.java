package com.fideuram.modello.tdp.elaborati;

import com.fideuram.modello.tdp.Tdp;

/**
 * Created by
 * User: logan
 * Date: 10/05/13
 * Time: 11.54
 */
public class RiepilogoTDP extends Tdp{
	
   	private String rataLorda;
    private String numeroGaranzie;

    public String getRataLorda() {
        return rataLorda;
    }

    public void setRataLorda(String rataLorda) {
        this.rataLorda = rataLorda;
    }

    public String getNumeroGaranzie() {
        return numeroGaranzie;
    }

    public void setNumeroGaranzie(String numeroGaranzie) {
        this.numeroGaranzie = numeroGaranzie;
    }
    
    @Override
   	public String toString() {
   		return "RiepilogoTDP [rataLorda=" + rataLorda + ", numeroGaranzie="
   				+ numeroGaranzie + "]";
   	}
}
