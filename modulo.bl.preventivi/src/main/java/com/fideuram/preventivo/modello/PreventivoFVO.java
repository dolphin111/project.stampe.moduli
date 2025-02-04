package com.fideuram.preventivo.modello;


import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;


@XmlType(name="PreventivoFVO")
public class PreventivoFVO implements Serializable {
 
	private static final long serialVersionUID = -8009744509556717738L;
	
	private Contraente contraente;
    private Assicurato assicurato;

    private Boolean isBozza;
    private String numeroPreventivo;             //viene rilasciato solo se isBozza==false

    private String dataElaborazionePreventivo;
    private String dataValiditaPreventivo;       //significa entro quando il preventivo dovrà essere sottoscritto
    private String durataContrattuale;
    private String dataDecorrenza;
    private String dataScadenza;
    private String tipoPackDocumenti;
    
    private Capitale capitale;
    private Premi premi;
    private List<PremiFVI> premiFV;
    private List<Questionario> questionario;

    private String numeroProposta;

    private Double rla; // rendimento lordo ipotesi a
    private Double rlb; // rendimento lordo ipotesi b
    private Double rmg; // rendiento minimo garantito
    private Double comm; // commissione , trattenute della compagnia
    private Double rna;  // rendimento netto ipotsi a
    private Double rnb; // rendimento netto ipotesi b

    private String descrizioneProdotto;
    private Boolean isTcmPrivacy;
    private String testoFirmaOtp;  
    
    private Boolean consensoCCSG;
    private Boolean consensoCMI;
    private Boolean consensoCDP;

    public Double getRla() {
        return rla;
    }

    public void setRla(Double rla) {
        this.rla = rla;
    }

    public Double getRlb() {
        return rlb;
    }

    public void setRlb(Double rlb) {
        this.rlb = rlb;
    }

    public Double getRmg() {
        return rmg;
    }

    public void setRmg(Double rmg) {
        this.rmg = rmg;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Double getRna() {
        return rna;
    }

    public void setRna(Double rna) {
        this.rna = rna;
    }

    public Double getRnb() {
        return rnb;
    }

    public void setRnb(Double rnb) {
        this.rnb = rnb;
    }

    public String getNumeroProposta() {
        return numeroProposta;
    }

    public void setNumeroProposta(String numeroProposta) {
        this.numeroProposta = numeroProposta;
    }

    public Contraente getContraente() {
        return contraente;
    }

    public void setContraente(Contraente contraente) {
        this.contraente = contraente;
    }

    public Assicurato getAssicurato() {
        return assicurato;
    }

    public void setAssicurato(Assicurato assicurato) {
        this.assicurato = assicurato;
    }

    public Boolean getBozza() {
        return isBozza;
    }

    public void setBozza(Boolean bozza) {
        isBozza = bozza;
    }

    public Boolean getIsBozza() {
        return isBozza;
    }

    public void setIsBozza(Boolean bozza) {
        isBozza = bozza;
    }
    
    public String getNumeroPreventivo() {
        return numeroPreventivo;
    }

    public void setNumeroPreventivo(String numeroPreventivo) {
        this.numeroPreventivo = numeroPreventivo;
    }

    public String getDataElaborazionePreventivo() {
        return dataElaborazionePreventivo;
    }

    public void setDataElaborazionePreventivo(String dataElaborazionePreventivo) {
        this.dataElaborazionePreventivo = dataElaborazionePreventivo;
    }

    public String getDataValiditaPreventivo() {
        return dataValiditaPreventivo;
    }

    public void setDataValiditaPreventivo(String dataValiditaPreventivo) {
        this.dataValiditaPreventivo = dataValiditaPreventivo;
    }

    public String getDurataContrattuale() {
        return durataContrattuale;
    }

    public void setDurataContrattuale(String durataContrattuale) {
        this.durataContrattuale = durataContrattuale;
    }

    public String getDataDecorrenza() {
        return dataDecorrenza;
    }

    public void setDataDecorrenza(String dataDecorrenza) {
        this.dataDecorrenza = dataDecorrenza;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Capitale getCapitale() {
        return capitale;
    }

    public void setCapitale(Capitale capitale) {
        this.capitale = capitale;
    }

    public Premi getPremi() {
        return premi;
    }

    public void setPremi(Premi premi) {
        this.premi = premi;
    }

    public List<Questionario> getQuestionario() {
        return questionario;
    }

    public void setQuestionario(List<Questionario> questionario) {
        this.questionario = questionario;
    }

	public String getTipoPackDocumenti() {
		return tipoPackDocumenti;
	}

	public void setTipoPackDocumenti(String tipoPackDocumenti) {
		this.tipoPackDocumenti = tipoPackDocumenti;
	}

	public List<PremiFVI> getPremiFV() {
		return premiFV;
	}

	public void setPremiFV(List<PremiFVI> premiFV) {
		this.premiFV = premiFV;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public Boolean getIsTcmPrivacy() {
		return isTcmPrivacy;
	}

	public void setIsTcmPrivacy(Boolean isTcmPrivacy) {
		this.isTcmPrivacy = isTcmPrivacy;
	}

	public String getTestoFirmaOtp() {
		return testoFirmaOtp;
	}

	public void setTestoFirmaOtp(String testoFirmaOtp) {
		this.testoFirmaOtp = testoFirmaOtp;
	}

	public Boolean getConsensoCCSG() {
		return consensoCCSG;
	}

	public void setConsensoCCSG(Boolean consensoCCSG) {
		this.consensoCCSG = consensoCCSG;
	}

	public Boolean getConsensoCMI() {
		return consensoCMI;
	}

	public void setConsensoCMI(Boolean consensoCMI) {
		this.consensoCMI = consensoCMI;
	}

	public Boolean getConsensoCDP() {
		return consensoCDP;
	}

	public void setConsensoCDP(Boolean consensoCDP) {
		this.consensoCDP = consensoCDP;
	}
	
}
