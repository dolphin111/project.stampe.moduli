package com.fideuram.stampe.modello.mandatiPagamento;

import com.fideuram.stampe.modello.corrispondenza.TipoLettera;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="MANDATIPAGAMENTO", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class MandatiPagamento {


    @XmlElement(name = "PAGAMENTO")
    private List<Pagamento> pagamento;

    @XmlElement(name = "NUMEROPEZZI")
    private String numeropezzi;

    @XmlElement(name = "TOTALEIMPORTOCOMPLESSIVO")
    private String totaleImportoComplessivo;



    public List<Pagamento> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamento> pagamento) {
        this.pagamento = pagamento;
    }

    public String getNumeropezzi() {
        return numeropezzi;
    }

    public void setNumeropezzi(String numeropezzi) {
        this.numeropezzi = numeropezzi;
    }

    public String getTotaleImportoComplessivo() {
        return totaleImportoComplessivo;
    }

    public void setTotaleImportoComplessivo(String totaleImportoComplessivo) {
        this.totaleImportoComplessivo = totaleImportoComplessivo;
    }
}
