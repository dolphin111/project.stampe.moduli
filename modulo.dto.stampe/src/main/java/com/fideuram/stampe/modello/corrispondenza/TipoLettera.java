package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="TIPOLETTERA", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoLettera {
	
	 @XmlElement(name = "LETTERA")
	 private String lettera;
	 @XmlElement(name = "DATA")
	 private String data;
	 @XmlElement(name = "POLIZZA")
	 private String polizza;
	 @XmlElement(name = "CERTIFICATOVITA")
	 private String certificatovita;
	 @XmlElement(name = "INTESTAZIONE")
	 private Intestazione intestazione;
	 @XmlElement(name = "BENEFICIARIO")
	 private Beneficiario beneficiario;
	 @XmlElement(name = "ASSICURATO")
	 private Assicurato assicurato;
	 @XmlElement(name = "CONTRAENTE")
	 private Contraente contraente;
	 @XmlElement(name = "SCADENZA")
	 private String scadenza;
	 @XmlElement(name = "FACTA")
	 private String facta;
	 @XmlElement(name = "TABELLA")
	 private Tabella tabella;
	 @XmlElement(name = "ALLEGATO1")
	 private String allegato1;
	 @XmlElement(name = "ALLEGATO2")
	 private Allegato2 allegato2;
	 @XmlElement(name = "ALLEGATO3")
	 private Allegato3 allegato3;
	 @XmlElement(name = "ALLEGATO4")
	 private Allegato4 allegato4;
	 @XmlElement(name = "ALL2")
	 private String all2;
	 @XmlElement(name = "ALL3")
	 private String all3;
	 @XmlElement(name = "ALL4")
	 private String all4;
	 @XmlElement(name = "ALLEGATI")
	 private String allegati;
	 @XmlElement(name = "SOLLECITOPENSIONISTICO")
	 private String sollecitoPensionistico;
     @XmlElement(name = "BENEFICIARIOTERZO",nillable = true)
     private String beneficiarioTerzo;
     @XmlElement(name = "DATAMORTE",nillable = true)
     private String dataMorte;
 	 @XmlElement(name = "DATIPRIVATEBANKER",nillable = true)
 	 private DatiPrivateBanker datiPrivateBanker;
 	 @XmlElement(name = "TABELLAPRESTAZIONI",nillable = true)
 	 private TabellaPrestazioni tabellaPrestazioni;
	 @XmlElement(name = "REVERSIBILITA",nillable = true)
	 private String reversibilita;
	 @XmlElement(name = "REVERSIONARIO",nillable = true)
	 private Reversionario reversionario;
	 @XmlElement(name = "CERTEZZA",nillable = true)
	 private String certezza;
	 @XmlElement(name = "FRAZIONAMENTO",nillable = true)
	 private String frazionamento;
	 @XmlElement(name = "ULTIMARATA",nillable = true)
	 private String ultimaRata;
	 @XmlElement(name = "DATACHIUSURA",nillable = true)
	 private String dataChiusura;
	 @XmlElement(name = "ADDREGTOTALE",nillable = true)
	 private String addRegTotale;
	 @XmlElement(name = "ADDCOMTOTALE",nillable = true)
	 private String addComTotale;
	 @XmlElement(name = "IMPORTOTOTALE",nillable = true)
	 private String importoTotale;
	 @XmlElement(name = "DATAPROSSIMA",nillable = true)
	 private String dataProssima;
	 @XmlElement(name = "IMPORTOCOMPLESSIVO",nillable = true)
	 private String importoComplessivo;

    public boolean needDocumenti(){
        Character b=allegati.toCharArray()[4];

        if(b.equals('S')&&allegato1.equals("NO"))
            return true;
        return false;
    }
    public String getDocumentoCI(){
        //String testo="Fotocopia di entrambi i lati di un documento di identità, valido, e del codice fiscale del beneficiario";
        String testo="Fotocopia di entrambi i lati di un documento di identità in corso di validità";
        return needDocumenti()?testo:"";
    }
    public boolean needDocumenti(Integer campo){
       
    	Character b=allegati.toCharArray()[campo-1];

        if (b.equals('S'))
            return true;
        else
        	return false;
    }

	
	public String getLettera() {
		return lettera;
	}
	public void setLettera(String lettera) {
		this.lettera = lettera;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Intestazione getIntestazione() {
		return intestazione;
	}
	public void setIntestazione(Intestazione intestazione) {
		this.intestazione = intestazione;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Assicurato getAssicurato() {
		return assicurato;
	}
	public void setAssicurato(Assicurato assicurato) {
		this.assicurato = assicurato;
	}
	public Contraente getContraente() {
		return contraente;
	}
	public void setContraente(Contraente contraente) {
		this.contraente = contraente;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	public String getFacta() {
		return facta;
	}
	public void setFacta(String facta) {
		this.facta = facta;
	}
	public Tabella getTabella() {
		return tabella;
	}
	public void setTabella(Tabella tabella) {
		this.tabella = tabella;
	}
	public String getPolizza() {
		return polizza;
	}
	public void setPolizza(String polizza) {
		this.polizza = polizza;
	}
	public String getCertificatovita() {
		return certificatovita;
	}
	public void setCertificatovita(String certificatovita) {
		this.certificatovita = certificatovita;
	}
	public String getAllegato1() {
		return allegato1;
	}
	public void setAllegato1(String allegato1) {
		this.allegato1 = allegato1;
	}
	public Allegato2 getAllegato2() {
		return allegato2;
	}
	public void setAllegato2(Allegato2 allegato2) {
		this.allegato2 = allegato2;
	}
	public Allegato3 getAllegato3() {
		return allegato3;
	}
	public void setAllegato3(Allegato3 allegato3) {
		this.allegato3 = allegato3;
	}
	public Allegato4 getAllegato4() {
		return allegato4;
	}
	public void setAllegato4(Allegato4 allegato4) {
		this.allegato4 = allegato4;
	}
	public String getAll2() {
		return all2;
	}
	public void setAll2(String all2) {
		this.all2 = all2;
	}
	public String getAll3() {
		return all3;
	}
	public void setAll3(String all3) {
		this.all3 = all3;
	}
	public String getAll4() {
		return all4;
	}
	public void setAll4(String all4) {
		this.all4 = all4;
	}
	public String getAllegati() {
		return allegati;
	}
	public void setAllegati(String allegati) {
		this.allegati = allegati;
	}
	public String getSollecitoPensionistico() {
		return sollecitoPensionistico;
	}
	public void setSollecitoPensionistico(String sollecitoPensionistico) {
		this.sollecitoPensionistico = sollecitoPensionistico;
	}


    public String getBeneficiarioTerzo() {
        return beneficiarioTerzo;
    }

    public void setBeneficiarioTerzo(String beneficiarioTerzo) {
        this.beneficiarioTerzo = beneficiarioTerzo;
    }


    public boolean hasSameContranteBeneficiario(){
        return beneficiario.toString().equalsIgnoreCase(contraente.toString())?true:false;
    }


    public String getImportoComplessivo() {
		return importoComplessivo;
	}
	public void setImportoComplessivo(String importoComplessivo) {
		this.importoComplessivo = importoComplessivo;
	}
	/**
     *
     * @return
     */
    public List<String> getTemplateAllegatiRichiesti(){
        List<String> l=new ArrayList<String>();
        //l.add(getLettera());
        if (getAllegato1().equalsIgnoreCase("SI"))
            l.add("Allegato1_cor");
        if (getAll2().equalsIgnoreCase("SI"))
            l.add("Allegato2_cor");
        if (getAll3().equalsIgnoreCase("SI"))
            l.add("Allegato3_cor");
        if (getAll4().equalsIgnoreCase("SI"))
            l.add("Allegato4_cor");
        if(getFacta().equalsIgnoreCase("SI"))
            l.add("Fatca");
        if(getBeneficiarioTerzo().equalsIgnoreCase("SI"))
            l.add("BeneficiarioTerzo");
        return l;
    }

    public int getIdLettera(){
        if (lettera.equals("1L"))
            return 1;
        if (lettera.equals("1LP"))
            return 2;
        if (lettera.equals("2L"))
            return 3;
        if (lettera.equals("LRC"))
            return 4;
        if (lettera.equals("SO1"))
            return 5;
        if (lettera.equals("SO1P"))
            return 6;
        if (lettera.equals("SRC"))
            return 7;
        return 0;
    }

    public String getFirmaLettera(){
        if (lettera.equals("1L"))
            return "1LI";
        if (lettera.equals("1LP"))
            return "1LP";
        if (lettera.equals("2L"))
            return "2LI";
        if (lettera.equals("LRC"))
            return "LRC";
        if (lettera.equals("SO1"))
            return "SO1";
        if (lettera.equals("SO1P"))
            return "SO1P";
        if (lettera.equals("SRC"))
            return "SRC";
        return "";
    }
	public String getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(String dataMorte) {
		this.dataMorte = dataMorte;
	}
	public DatiPrivateBanker getDatiPrivateBanker() {
		return datiPrivateBanker;
	}
	public void setDatiPrivateBanker(DatiPrivateBanker datiPrivateBanker) {
		this.datiPrivateBanker = datiPrivateBanker;
	}
	public TabellaPrestazioni getTabellaPrestazioni() {
		return tabellaPrestazioni;
	}
	public void setTabellaPrestazioni(TabellaPrestazioni tabellaPrestazioni) {
		this.tabellaPrestazioni = tabellaPrestazioni;
	}
	public String getReversibilita() {
		return reversibilita;
	}
	public void setReversibilita(String reversibilita) {
		this.reversibilita = reversibilita;
	}
	public String getImportoTotale() {
		return importoTotale;
	}
	public void setImportoTotale(String importoTotale) {
		this.importoTotale = importoTotale;
	}
	public Reversionario getReversionario() {
		return reversionario;
	}
	public void setReversionario(Reversionario reversionario) {
		this.reversionario = reversionario;
	}
	public String getCertezza() {
		return certezza;
	}
	public void setCertezza(String certezza) {
		this.certezza = certezza;
	}
	public String getFrazionamento() {
		return frazionamento;
	}
	public void setFrazionamento(String frazionamento) {
		this.frazionamento = frazionamento;
	}
	public String getUltimaRata() {
		return ultimaRata;
	}
	public void setUltimaRata(String ultimaRata) {
		this.ultimaRata = ultimaRata;
	}
	public String getDataChiusura() {
		return dataChiusura;
	}
	public void setDataChiusura(String dataChiusura) {
		this.dataChiusura = dataChiusura;
	}
	public String getAddRegTotale() {
		return addRegTotale;
	}
	public void setAddRegTotale(String addRegTotale) {
		this.addRegTotale = addRegTotale;
	}
	public String getAddComTotale() {
		return addComTotale;
	}
	public void setAddComTotale(String addComTotale) {
		this.addComTotale = addComTotale;
	}
	public String getDataProssima() {
		return dataProssima;
	}
	public void setDataProssima(String dataProssima) {
		this.dataProssima = dataProssima;
	}
    public boolean tabellaPrestazioniIsValorizzato(){
    	
    	return tabellaPrestazioni == null ? false : true;
    }
    public String polizzeRischiComuni() {
    	
    	String polizze = "";
    	if (tabella != null) {

    		int cont = 0;
    		for (Record rec : tabella.getRecord()) {
    			
    			if (cont == 0) {
    				polizze =rec.getPolizza();
    			}
    			else  {
        			polizze = polizze + " - " + rec.getPolizza();
    			}
    			cont++;
    		}
    	}
    	
    	
    	return polizze;
    }
    
    public String scedenzeRischiComuni() {
    	
    	String out = "";
    	if (tabella != null) {

    		int cont = 0;
    		for (Record rec : tabella.getRecord()) {
    			
    			if (cont == 0) {
    				out = rec.getScadenza() + " della polizza " + rec.getPolizza();
    			}
    			else  {
    				out = out + " e del " + rec.getScadenza() + " della polizza " + rec.getPolizza();
    			}
    			cont++;
    		}
    	}
    	
    	
    	return out;
    }
    
    public boolean nascondiBanker() {
        
        String pb = datiPrivateBanker.getCognomePrivateBanker().trim() +datiPrivateBanker.getNomePrivateBanker().trim();
        
        if (pb.equalsIgnoreCase("")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean visualizzaSezioneAddizionali() {
    	
    	if (  (addComTotale != null && new Double(addComTotale.replace(",", ".")) > 0) || 
    			(addRegTotale != null && new Double(addRegTotale.replace(",", ".")) > 0)  ) {
    		return true;
    	}
		else {
    		return false;
		}
    		
    }
    
}
