package com.fideuram.stampe.modello.attori;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 23/06/11
 * Time: 11.20
 */
@XmlType(name="Contraente")
public class Contraente  extends Persona implements Serializable {
	private static final long serialVersionUID = -5715324508193216727L;

	private String classePatrimonioPotenziale;

	public String getClassePatrimonioPotenziale() {
		return classePatrimonioPotenziale;
	}

	public void setClassePatrimonioPotenziale(String classePatrimonioPotenziale) {
		this.classePatrimonioPotenziale = classePatrimonioPotenziale;
	}
}
