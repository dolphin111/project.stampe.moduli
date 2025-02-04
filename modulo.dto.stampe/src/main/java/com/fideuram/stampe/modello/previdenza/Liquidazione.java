package com.fideuram.stampe.modello.previdenza;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by V801068 on 03/06/14.
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Liquidazione {
    public static int LIQUIDAZIONE_PARZIALE=1;
    public static int LIQUIDAZIONE_TOTALE=2;
    public static int ANTICIPAZIONE_RISTRUTTURAZIONE=3;
    public static int ANTICIPAZIONE_ACQUISTO_PRIMA_CASA=4;
    public static int ANTICIPAZIONE_CURE_MEDICHE=5;
    public static int ANTICIPAZIONE_ESIGENZE_PERSONALI=6;

    private int  tipoLiquidazione;
    private Date dataRichiesta;
    private Date dataPagamento;
    private String causale;         //indica la causale di richiesta riscatto ad esempio: Riscatto Totale per Invalidità permanente

    public String getDataRichiesta() {
        return FormattatoreDate.formatDate(dataRichiesta, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    /**
     * Restituisce la descrizione del tipo di liquidazione
     * @return
     */
    public String getDescrizioneTipoLiquidazione() {
        switch (tipoLiquidazione){
            case 1:
                return "Riscatto Parziale";
            case 2:
                return "Riscatto Totale";
            case 3:
                return "Anticipazione per la realizzazione di interventi di ristrutturazione relativamente alla prima casa di abitazione";
            case 4:
                return "Anticipazione per l'acquisto della prima casa di abitazione per sé o per i figli";
            case 5:
                return "Anticipazione per il sostenimento di spese mediche gravissime e straordinarie";
            case 6:
                return "Anticipazione per esigenze di carattere personale";
            default:
                return "";
        }
    }

    public int getTipoLiquidazione() {
        return tipoLiquidazione;
    }

    public String getCausale() {
        return causale;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    /**
     * <br>Il tipo di liquidazione Puo essere:
     * <br>LIQUIDAZIONE PARZIALE  = 1
     * <br>LIQUIDAZIONE TOTALE    = 2
     * <br>
     * <br>Esempio di utilizzo:
     * <br>...
     * <br>liquidazione.setTipoLiquidazione(Liquidazione.LIQUIDAZIONE_PARZIALE)
     * <br>...
     *
     * @param tipoLiquidazione
     */
    public void setTipoLiquidazione(int tipoLiquidazione) {
        this.tipoLiquidazione = tipoLiquidazione;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

	public String getDataPagamento() {
		 return FormattatoreDate.formatDate(dataPagamento, FormattatoreDate.FORMATO_DATA_ITALIANA);
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
    
}
