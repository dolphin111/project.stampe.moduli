package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by V801098 on 09/05/14.
 */
@XmlRootElement(name="VariazioneBeneficiario", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class VariazioneBeneficiario {

    private Date           dataRichiesta;
    protected boolean      sollecito=false;
    protected Contratto    polizza;
    protected List<String> docIntgrativa;

    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public boolean isSollecito() {
        return sollecito;
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public List<String> getDocIntgrativa() {
        return docIntgrativa!=null?docIntgrativa:new ArrayList<String>();
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public void setDocIntgrativa(List<String> docIntgrativa) {
        this.docIntgrativa = docIntgrativa;
    }

    public void addDocIntegrativa(String doc){
        if(null==docIntgrativa)
            docIntgrativa=new ArrayList<String>();
        docIntgrativa.add(doc);
    }

}
