package com.fideuram.stampe.modello.mandatiPagamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="DETTAGLIOPAGAMENTI", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class DettaglioPagamenti {



    @XmlElement(name = "NUMEROCOMPLESSIVO")
    public String numeroComplessivo;

    @XmlElement(name = "PAGAMENTO")
    public List<Pagamento> pagamento;

    public String getNumeroComplessivo() {
        return numeroComplessivo;
    }

    public void setNumeroComplessivo(String numeroComplessivo) {
        this.numeroComplessivo = numeroComplessivo;
    }

    public List<Pagamento> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<Pagamento> pagamento) {
        this.pagamento = pagamento;
    }
}
