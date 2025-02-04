package com.fideuram.stampe.printer;

import java.util.ArrayList;

public class EsitoStampaCorrispondenze 
{
    private ArrayList<String> listaCorrispondenzaRendite = new ArrayList<String>();
    private ArrayList<String> listaErrori = new ArrayList<String>();
    
    private ArrayList<String> listaCorrispondenzaRenditeGenerati = new ArrayList<String>();
    


	public ArrayList<String> getListaCorrispondenzaRendite() {
		return listaCorrispondenzaRendite;
	}
	public void setListaCorrispondenzaRendite(
			ArrayList<String> listaCorrispondenzaRendite) {
		this.listaCorrispondenzaRendite = listaCorrispondenzaRendite;
	}
	public ArrayList<String> getListaCorrispondenzaRenditeGenerati() {
		return listaCorrispondenzaRenditeGenerati;
	}
	public void setListaCorrispondenzaRenditeGenerati(
			ArrayList<String> listaCorrispondenzaRenditeGenerati) {
		this.listaCorrispondenzaRenditeGenerati = listaCorrispondenzaRenditeGenerati;
	}
	public ArrayList<String> getListaErrori() {
		return listaErrori;
	}
	public int getNumeroErroriStampaCorrispondenze() {
		return listaErrori.size();
	}
	
}
