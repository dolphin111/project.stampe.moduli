package com.fideuram.modello.metodiPagamento;

import java.util.ArrayList;
import java.util.List;

public class ListMetodiPagamento {
	
	private List<MetodiPagamento> metodPag;
	
	public ListMetodiPagamento(){
		metodPag = new ArrayList<MetodiPagamento>();
	}
	public List<MetodiPagamento> getMetodPag() {
		return metodPag;
	}

	public void setMetodPag(List<MetodiPagamento> metodPag) {
		this.metodPag = metodPag;
	}
	
}
