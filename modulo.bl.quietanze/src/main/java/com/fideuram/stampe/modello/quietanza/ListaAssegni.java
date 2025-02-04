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
@XmlType(name = "ListaBonifici", propOrder = {"assegno"})
public class ListaAssegni 
{
	@XmlElement(name = "QUIETANZA")
	private ArrayList<Assegno> assegno = new ArrayList<Assegno>();

	public ArrayList<Assegno> getAssegno() {
		return assegno;
	}

	public void setAssegno(ArrayList<Assegno> assegno) {
		this.assegno = assegno;
	}
	
	public int sizeLista(){
		if(assegno!= null && !assegno.isEmpty())
			return this.assegno.size();
		else 
			return 0;
	}

	
	
    
}
