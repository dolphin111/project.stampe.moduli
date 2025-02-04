package com.fideuram.stampe.modello.quietanza;

import java.util.ArrayList;

public class EsitoStampaQuietanze 
{
    private ArrayList<String> listaBonifici = new ArrayList<String>();
    private ArrayList<String> listaAssegni = new ArrayList<String>();
    private ArrayList<String> listaErrori = new ArrayList<String>();
    
    private ArrayList<String> listaAssegniGeneratiArchiviazione = new ArrayList<String>();
    private ArrayList<String> listaAssegniGeneratiStorico = new ArrayList<String>();
    private ArrayList<String> listaBonificiGenerati = new ArrayList<String>();
    

	public ArrayList<String> getListaBonifici() {
		return listaBonifici;
	}
	public void setListaBonifici(ArrayList<String> listaBonifici) {
		this.listaBonifici = listaBonifici;
	}
	public ArrayList<String> getListaAssegni() {
		return listaAssegni;
	}
	public void setListaAssegni(ArrayList<String> listaAssegni) {
		this.listaAssegni = listaAssegni;
	}
	public int getNumeroBonificiStampati() {
		return listaBonifici.size();
	}
	public int getNumeroAssegniStampati() {
		return listaAssegni.size();
	}
	public ArrayList<String> getListaErrori() {
		return listaErrori;
	}
	public int getNumeroErroriStampaQuietanze() {
		return listaErrori.size();
	}
	public ArrayList<String> getListaBonificiGenerati() {
		return listaBonificiGenerati;
	}
	public void setListaBonificiGenerati(ArrayList<String> listaBonificiGenerati) {
		this.listaBonificiGenerati = listaBonificiGenerati;
	}
	public ArrayList<String> getListaAssegniGeneratiArchiviazione() {
		return listaAssegniGeneratiArchiviazione;
	}
	public void setListaAssegniGeneratiArchiviazione(
			ArrayList<String> listaAssegniGeneratiArchiviazione) {
		this.listaAssegniGeneratiArchiviazione = listaAssegniGeneratiArchiviazione;
	}
	public ArrayList<String> getListaAssegniGeneratiStorico() {
		return listaAssegniGeneratiStorico;
	}
	public void setListaAssegniGeneratiStorico(
			ArrayList<String> listaAssegniGeneratiStorico) {
		this.listaAssegniGeneratiStorico = listaAssegniGeneratiStorico;
	}
	
}
