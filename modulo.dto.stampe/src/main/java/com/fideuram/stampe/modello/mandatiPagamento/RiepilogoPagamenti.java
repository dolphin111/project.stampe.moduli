package com.fideuram.stampe.modello.mandatiPagamento;



import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name="RIEPILOGOPAGAMENTI", namespace="")
public class RiepilogoPagamenti {

    private List<Pagamento> pagamenti;
    private String sommaPagamenti;
    private String data;

    public List<Pagamento> getPagamenti() {
        return pagamenti;
    }

    public void setPagamenti(List<Pagamento> pagamenti) {
        this.pagamenti = pagamenti;
    }

    public String getSommaPagamenti() {
        return sommaPagamenti;
    }

    public void setSommaPagamenti(String sommaPagamenti) {
        this.sommaPagamenti = sommaPagamenti;
    }


    public String getData() {
        return FormattatoreDate.formatDate(new Date(), FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);
    }

    public void setData(String data) {
        this.data = data;
    }
}
