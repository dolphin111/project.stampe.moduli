package com.fideuram.stampe.modello.mandatiPagamento;



import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: V801092
 * Date: 08/09/14
 * Time: 17.52
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="PAGAMENTO", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pagamento {

    @XmlElement(name = "PROGRESSIVO",nillable = true)
    private int progressivo;

    @XmlElement(name = "NUMERODISTINTA")
    public String  numeroDistinta;

    @XmlElement(name = "NUMEROBONIFICI",nillable = true)
    public String  numeroBonifici;

    @XmlElement(name = "CONTOCORRENTE",nillable = true)
    public String  contoCorrente;

    @XmlElement(name = "IMPORTOCOMPLESSIVO",nillable = true)
    public String  importoComplessivo;

    @XmlElement(name = "VALUTAADDEBITO",nillable = true)
    public String  valutaAddebito;


    @XmlElement(name = "DATA",nillable = true)
    private String data;

    @XmlElement(name = "TIPOMANDATO",nillable = true)
    private String tipoMandato;

    @XmlElement(name = "TIPOPAGAMENTO",nillable = true)
    private String tipoPagamento;

    @XmlElement(name = "INTESTAZIONE")
    private Intestazione intestazione;


    @XmlElement(name = "BENEFICIARIO",nillable = true)
    private List<Beneficiario> beneficiario;

    public Intestazione getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(Intestazione intestazione) {
        this.intestazione = intestazione;
    }


    public String getNumeroDistinta() {
        return numeroDistinta;
    }

    public void setNumeroDistinta(String numeroDistinta) {
        this.numeroDistinta = numeroDistinta;
    }

    public String getNumeroBonifici() {
        return numeroBonifici;
    }

    public void setNumeroBonifici(String numeroBonifici) {
        this.numeroBonifici = numeroBonifici;
    }

    public String getContoCorrente() {
        return contoCorrente;
    }

    public void setContoCorrente(String contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    public String getImportoComplessivo() {
        return importoComplessivo;
    }

    public void setImportoComplessivo(String importoComplessivo) {
        this.importoComplessivo = importoComplessivo;
    }

    public String getValutaAddebito() {
        return valutaAddebito;
    }

    public void setValutaAddebito(String valutaAddebito) {
        this.valutaAddebito = valutaAddebito;
    }

    public String getData() {
        return FormattatoreDate.formatDate(new Date(), FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);

    }

    public void setData(String data) {
        this.data = data;
    }

    public int getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(int progressivo) {
        this.progressivo = progressivo;
    }

    public String getTipoMandato() {
        return tipoMandato;
    }

    public void setTipoMandato(String tipoMandato) {
        this.tipoMandato = tipoMandato;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }



    public List<Beneficiario> getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(List<Beneficiario> beneficiario) {
        this.beneficiario = beneficiario;
    }
}
