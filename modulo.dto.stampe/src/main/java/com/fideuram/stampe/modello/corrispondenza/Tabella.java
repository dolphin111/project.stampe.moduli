package com.fideuram.stampe.modello.corrispondenza;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="TABELLA", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tabella {
	
	 @XmlElement(name = "RECORD")
		private List<Record> record;
	 

	public List<Record> getRecord() {
		return record;
	}

	public void setRecord(List<Record> record) {
		this.record = record;
	}

}
