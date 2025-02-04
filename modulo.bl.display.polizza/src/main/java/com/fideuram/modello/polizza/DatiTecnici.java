    package com.fideuram.modello.polizza;

    import com.fideuram.factory.FormatterFactory;

    import javax.xml.bind.annotation.XmlAccessType;
    import javax.xml.bind.annotation.XmlAccessorType;
    import javax.xml.bind.annotation.XmlRootElement;
    import java.util.Date;

    /**
     * Created by
     * User: logan
     * Date: 09/04/13
     * Time: 18.44
     */
    @XmlRootElement()
    @XmlAccessorType(XmlAccessType.FIELD)
    public class DatiTecnici {
        private String numeroPolizza;
        private String codiceConferimento;
        private String stato;
        private String sottostato;
        private String codice;
        private String descrizione;
        private String ramoMinisteriale;
        private String tipoPrestazione;
        private String tipoPolizza;
        private Date   dataEmissione;
        private Date   dataScadenza;
        private String reteVendita;
        private String reteVenditaEstesa;

        private Prodotto prodotto;
        private Tariffa  tariffa;

        public String getNumeroPolizza() {
            return numeroPolizza;
        }

        public void setNumeroPolizza(String numeroPolizza) {
            this.numeroPolizza = numeroPolizza;
        }

        public String getCodiceConferimento() {
            return codiceConferimento;
        }

        public String getStato() {
            return stato;
        }

        public String getSottostato() {
            return sottostato;
        }

        public String getCodice() {
            return codice;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public String getRamoMinisteriale() {
            return ramoMinisteriale;
        }

        public String getTipoPrestazione() {
            return tipoPrestazione;
        }

        public String getTipoPolizza() {
            return tipoPolizza;
        }

        public String getDataEmissione() {
            return FormatterFactory.getStandardDate(dataEmissione);
        }

        public String getDataScadenza() {
            return FormatterFactory.getStandardDate(dataScadenza);
        }

        public String getReteVendita() {
            return reteVendita;
        }

        public String getReteVenditaEstesa() {
            if(reteVendita.equalsIgnoreCase("BFI"))
                return "Fideuram - Intesa Sanpaolo Private Banking";
            else if(reteVendita.equalsIgnoreCase("SPI"))
                return "Fideuram - Intesa Sanpaolo Private Banking";
            else if(reteVendita.equalsIgnoreCase("IWB"))
            	return "IW SIM S.p.A.";
            return "";
        }

        public Prodotto getProdotto() {
            return prodotto;
        }

        public Tariffa getTariffa() {
            return tariffa;
        }

        public boolean isRendita(){
            if (tipoPrestazione.equalsIgnoreCase("R"))
               return true;
            return false;
        }
        public boolean isCapitale(){
            if (tipoPrestazione.equalsIgnoreCase("C"))
                return true;
            return false;
        }
        public boolean isRamoPrimo(){
            if (ramoMinisteriale.equalsIgnoreCase("1"))
                return true;
            return false;
        }
        public boolean isRamoTerzo(){
            if (ramoMinisteriale.equalsIgnoreCase("3"))
                return true;
            return false;
        }
    }
