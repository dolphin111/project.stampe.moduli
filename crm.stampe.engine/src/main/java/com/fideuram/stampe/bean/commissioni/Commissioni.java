package com.fideuram.stampe.bean.commissioni;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: v801068
 * Date: 27/11/13
 * Time: 12.25
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Commissioni {
    private Date    dataInizioGestione;
    private Double  qteDaInizioGestioneCG=0.00;   //CG=Commissioni Gestione
    private Double  qteDaInizioGestioneCM=0.00;   //CM=Caso Morte
    private Date    dataInizioAnno;
    private Double  qteDaInizioAnnoCG   =0.00;
    private Double  qteDaInizioAnnoCM   =0.00;
    private Date    dataInizioAccantonamento;
    private Double  qteAccantonateCG    =0.00;
    private Double  qteAccantonateCM    =0.00;

    public void setDataInizioGestione(Date dataInizioGestione) {
        this.dataInizioGestione = dataInizioGestione;
    }

    public void setDataInizioAnno(Date dataInizioAnno) {
        this.dataInizioAnno = dataInizioAnno;
    }

    public void setDataInizioAccantonamento(Date dataInizioAccantonamento) {
        this.dataInizioAccantonamento = dataInizioAccantonamento;
    }

    public void setQteDaInizioGestioneCG(Double qteDaInizioGestioneCG) {
        this.qteDaInizioGestioneCG = qteDaInizioGestioneCG;
    }

    public void setQteDaInizioGestioneCM(Double qteDaInizioGestioneCM) {
        this.qteDaInizioGestioneCM = qteDaInizioGestioneCM;
    }

    public void setQteDaInizioAnnoCG(Double qteDaInizioAnnoCG) {
        this.qteDaInizioAnnoCG = qteDaInizioAnnoCG;
    }

    public void setQteDaInizioAnnoCM(Double qteDaInizioAnnoCM) {
        this.qteDaInizioAnnoCM = qteDaInizioAnnoCM;
    }

    public void setQteAccantonateCG(Double qteAccantonateCG) {
        this.qteAccantonateCG = qteAccantonateCG;
    }

    public void setQteAccantonateCM(Double qteAccantonateCM) {
        this.qteAccantonateCM = qteAccantonateCM;
    }

    public String getDataInizioGestione() {
        if(dataInizioGestione!=null)
           return FormatterFactory.getStandardDate(dataInizioGestione);
        return "";
    }

    public String getQteDaInizioGestioneCG() {
        return FormatterFactory.getStandardQuote(qteDaInizioGestioneCG);
    }

    public String getQteDaInizioGestioneCM() {
        return FormatterFactory.getStandardQuote(qteDaInizioGestioneCM);
    }

    public String getDataInizioAnno() {
        if(dataInizioAnno!=null)
            return FormatterFactory.getStandardDate(dataInizioAnno);
        return "";
    }

    public String getQteDaInizioAnnoCG() {
        return FormatterFactory.getStandardQuote(qteDaInizioAnnoCG);
    }

    public String getQteDaInizioAnnoCM() {
        return FormatterFactory.getStandardQuote(qteDaInizioAnnoCM);
    }

    public String getDataInizioAccantonamento() {
        if(dataInizioAccantonamento!=null)
            return FormatterFactory.getStandardDate(dataInizioAccantonamento);
        return "";
    }

    public String getQteAccantonateCG() {
        return FormatterFactory.getStandardQuote(qteAccantonateCG);
    }

    public String getQteAccantonateCM() {
        return FormatterFactory.getStandardQuote(qteAccantonateCM);
    }
}
