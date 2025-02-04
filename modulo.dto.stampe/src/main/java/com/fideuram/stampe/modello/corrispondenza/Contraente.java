package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="CONTRAENTE", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contraente {

	 @XmlElement(name = "COGNOME")
		private String cognome;
		 @XmlElement(name = "NOME")
		private String nome;
		
		
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

    @Override
    public String toString() {
        return  cognome.trim() + " " +nome.trim() ;
    }
}
