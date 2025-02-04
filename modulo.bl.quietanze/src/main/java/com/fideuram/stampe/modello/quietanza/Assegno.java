package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 14.57
 */
@XmlRootElement(name="QUIETANZA")
@XmlAccessorType(XmlAccessType.FIELD)
public class Assegno extends Quietanza {
    @XmlElement(name = "NUMEROASSEGNO")
    private String numeroAssegno;
    @XmlElement(name = "DATAASSEGNO")
    private String dataAssegno;
    @XmlElement(name = "IMPORTOCIFRA")
    private String importoCifra;
    @XmlElement(name = "IMPORTOLETTERE")
    private String importoLettere;
    @XmlElement(name = "ASSEGNONOME")
    private String assegnoNome;

    public String getNumeroAssegno() {
       	if(numeroAssegno != null)
       		numeroAssegno = numeroAssegno.trim();	
        return numeroAssegno;
    }

    public void setNumeroAssegno(String numeroAssegno) {
        this.numeroAssegno = numeroAssegno;
    }

    public String getDataAssegno() {
       	if(dataAssegno != null)
       		dataAssegno = dataAssegno.trim();	
        return dataAssegno;
    }

    public void setDataAssegno(String dataAssegno) {
        this.dataAssegno = dataAssegno;
    }

    public String getImportoCifra() {
       	if(importoCifra != null)
       		importoCifra = importoCifra.trim();	
        return importoCifra;
    }

    public void setImportoCifra(String importoCifra) {
        this.importoCifra = importoCifra;
    }

    public String getImportoLettere() {
       	if(importoLettere != null)
       		importoLettere = importoLettere.trim();	
        return importoLettere;
    }

    public void setImportoLettere(String importoLettere) {
        this.importoLettere = importoLettere;
    }

    public String getAssegnoNome() {
       	if(assegnoNome != null)
       		assegnoNome = assegnoNome.trim();	
        return assegnoNome;
    }
    
    public void setAssegnoNome(String assegnoNome) {
        this.assegnoNome = assegnoNome;
    }
}
