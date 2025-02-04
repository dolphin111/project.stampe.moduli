package com.fideuram.soa.sync.trasformazioni.dto;

import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 18/04/12
 * Time: 10.11
 */
/*
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
*/
public class TrasformazioneDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7765364872553084669L;
	private String  canale="0";                                 //0=fv 1=po
    private String  numeroPolizza;
    private String  nomeCommercialeProdottoOrigine;
    private String  codiceCommercialeProdottoOrigine;           //18001-18002.....
    private String  codiceTipoPremioPolizza;                    //U - R          unico o ricorrente

    private String  nomeCommercialeProdottoDestinazione;
    private String  codiceCommercialeProdottoDestinazione;      //801-802-803

    private String  nomeContraente;
    private String  cognomeContraente;
    private String  nomeAssicurato;
    private String  cognomeAssicurato;
    private String  dataDecorrenza;
    private String  dataScadenza;
    private String  durata;
    private String  rete;

    private String  codicePb="";
    private String  nomePb="";
    private String  cognomePb="";
    private String  numeroSchedaTrasformazione="";
    private String  dataNav="";
    private String  controvalorePolizza="";

    public String getCodiceCommercialeProdottoOrigine() {
        return codiceCommercialeProdottoOrigine;
    }
    public void setCodiceCommercialeProdottoOrigine(String codiceCommercialeProdottoOrigine) {
        this.codiceCommercialeProdottoOrigine = codiceCommercialeProdottoOrigine;
    }
    public String getCodiceTipoPremioPolizza() {
        return codiceTipoPremioPolizza;
    }
    public void setCodiceTipoPremioPolizza(String codiceTipoPremioPolizza) {
        this.codiceTipoPremioPolizza = codiceTipoPremioPolizza;
    }
    public String getCodiceCommercialeProdottoDestinazione() {
        return codiceCommercialeProdottoDestinazione;
    }
    public void setCodiceCommercialeProdottoDestinazione(String codiceCommercialeProdottoDestinazione) {
        this.codiceCommercialeProdottoDestinazione = codiceCommercialeProdottoDestinazione;
    }
    public String getNumeroPolizza() {
        return numeroPolizza;
    }
    public void setNumeroPolizza(String numeroPolizza) {
        this.numeroPolizza = numeroPolizza;
    }
    public String getNomeCommercialeProdottoOrigine() {
        return nomeCommercialeProdottoOrigine;
    }
    public void setNomeCommercialeProdottoOrigine(String nomeCommercialeProdottoOrigine) {
        this.nomeCommercialeProdottoOrigine = nomeCommercialeProdottoOrigine;
    }
    public String getNomeCommercialeProdottoDestinazione() {
        return nomeCommercialeProdottoDestinazione;
    }
    public void setNomeCommercialeProdottoDestinazione(String nomeCommercialeProdottoDestinazione) {
        this.nomeCommercialeProdottoDestinazione = nomeCommercialeProdottoDestinazione;
    }
    public String getNomeContraente() {
        return nomeContraente;
    }
    public void setNomeContraente(String nomeContraente) {
        this.nomeContraente = nomeContraente;
    }
    public String getCognomeContraente() {
        return cognomeContraente;
    }
    public void setCognomeContraente(String cognomeContraente) {
        this.cognomeContraente = cognomeContraente;
    }
    public String getNomeAssicurato() {
        return nomeAssicurato;
    }
    public void setNomeAssicurato(String nomeAssicurato) {
        this.nomeAssicurato = nomeAssicurato;
    }
    public String getCognomeAssicurato() {
        return cognomeAssicurato;
    }
    public void setCognomeAssicurato(String cognomeAssicurato) {
        this.cognomeAssicurato = cognomeAssicurato;
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
    public String getDurata() {
        return durata;
    }
    public void setDurata(String durata) {
        this.durata = durata;
    }
    public String getRete() {
        return rete;
    }
    public void setRete(String rete) {
        this.rete = rete;
    }
    public String getCanale() {
        return canale;
    }
    public void setCanale(String canale) {
        this.canale = canale;
    }
    public String getCodicePb() {
        return codicePb;
    }
    public void setCodicePb(String codicePb) {
        this.codicePb = codicePb;
    }
    public String getNomePb() {
        return nomePb;
    }
    public void setNomePb(String nomePb) {
        this.nomePb = nomePb;
    }
    public String getCognomePb() {
        return cognomePb;
    }
    public void setCognomePb(String cognomePb) {
        this.cognomePb = cognomePb;
    }

    public String getNumeroSchedaTrasformazione() {
        return numeroSchedaTrasformazione;
    }

    public void setNumeroSchedaTrasformazione(String numeroSchedaTrasformazione) {
        this.numeroSchedaTrasformazione = numeroSchedaTrasformazione;
    }

    public String getDataNav() {
        return dataNav;
    }

    public void setDataNav(String dataNav) {
        this.dataNav = dataNav;
    }

    public String getControvalorePolizza() {
        return controvalorePolizza;
    }

    public void setControvalorePolizza(String controvalorePolizza) {
        this.controvalorePolizza = controvalorePolizza;
    }

    public  static int TEMPLATE_35005       = 35005;
    public  static int TEMPLATE_35006       = 35006;
    public  static int TEMPLATE_35007       = 35007;
    public  static int TEMPLATE_18001       = 18001;
    public  static int TEMPLATE_18002       = 18002;
    public  static int TEMPLATE_18003       = 18003;
    public  static int TEMPLATE_18005       = 18005;

    public  static int TEMPLATE_FV_INSIEME  = 801;
    public  static int TEMPLATE_FV_FACILE   = 802;
    public  static int TEMPLATE_FV_PREMIUM  = 803;
    public  static int TEMPLATE_FV_FACILE_VS_INSIEME  = 804;
    public  static int TEMPLATE_FV_INSIEME_VS_PRIVATE  = 805;
    public  static int TEMPLATE_FV_PREMIUM_VS_INSIEME  = 806;
    public  static int TEMPLATE_FV_PREMIUM_VS_FACILE  = 807;

    public  static String CANALE_SFV        = "0";
    public  static String CANALE_PO         = "1";

    public  static String PREMIO_UNICO       ="U";
    public  static String PREMIO_RICORSIVO   ="R";
    public  static String PREMIO_AGGIUNTIVO  ="G";
    public  static String PREMIO_ANNUO       ="A";

}
