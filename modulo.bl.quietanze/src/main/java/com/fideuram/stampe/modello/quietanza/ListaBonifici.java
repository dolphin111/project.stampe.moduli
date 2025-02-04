package com.fideuram.stampe.modello.quietanza;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 14.55
 */
@XmlRootElement(name = "QUIETANZE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaBonifici", propOrder = {"bonifico"})

public class ListaBonifici 
{
	@XmlElement(name = "QUIETANZA")
	private ArrayList<Bonifico> bonifico = new ArrayList<Bonifico>();

	public ArrayList<Bonifico> getBonifico() {
		return bonifico;
	}

	public void setBonifico(ArrayList<Bonifico> bonifico) {
		this.bonifico = bonifico;
	}    
	
	public int sizeLista(){
		if(bonifico!= null && !bonifico.isEmpty())
			return this.bonifico.size();
		else 
			return 0;
	}
}
