package com.fideuram.stampe.modello.rendiconti;

import com.fideuram.stampe.modello.rendiconti.composizione.ComposizioneFondo;
import com.fideuram.stampe.modello.rendiconti.rendimento.RendimentoMedioAnnuo;
import com.fideuram.stampe.modello.utils.FormattatoreDate;
import fr.opensagres.xdocreport.document.images.IImageProvider;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: V801068
 * Date: 14/01/14
 * Time: 16.16
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Fondo {

    @XmlTransient
    private IImageProvider              graficoRendimentoMensile;
    @XmlTransient
    private IImageProvider              graficoRendimentoAnnuale;
    private String                      codiceFondo;
    private String                      descrizioneFondo;
    private VolatilitaProspettica       volatilitaProspettica;
    private List<RendimentoAnnuo>       rendimentoAnnuo;
    private List<RendimentoMensile>     valoreUnitarioQuota;
    private RendimentoMedioAnnuo        rendimentoMedioAnnuo;
    private List<Ter>                   ter;
    private List<Turnover>              turnover;
    private Date                        inizioOperativita;
    private Date                        scadenzaOperativita;
    private Integer                     orizzonteInvestimento;
    private Patrimonio                  patrimonio;
    private List<CostiGlobali>          costiGlobalis;
    private boolean                     fondoNuovo;
    private ComposizioneFondo           composizioneFondo;

    public boolean isFondoNuovo() {
        return fondoNuovo;
    }

    public boolean isFondoVecchio() {
        if(fondoNuovo==false)
          return true;
        else
          return false;
    }

    public ComposizioneFondo getComposizioneFondo(){
        if(composizioneFondo==null)
            composizioneFondo=new ComposizioneFondo();
        return composizioneFondo;
    }

    public List<CostiGlobali> getCostiGlobalis() {
        if(null==costiGlobalis){
            costiGlobalis=new ArrayList<CostiGlobali>();
            for (int i=0; i<4; i++){
                costiGlobalis.add(new CostiGlobali());
            }
        }
        return costiGlobalis;
    }

    public String getCodiceFondo() {
        if(null==codiceFondo)
           codiceFondo="";
        return codiceFondo;
    }

    public String getDescrizioneFondo() {
        if(null==descrizioneFondo)
            descrizioneFondo="";
        return descrizioneFondo;
    }

    public VolatilitaProspettica getVolatilitaProspettica() {
        if(null==volatilitaProspettica)
            volatilitaProspettica=new VolatilitaProspettica();
        return volatilitaProspettica;
    }

    public List<RendimentoAnnuo> getRendimentoAnnuo() {
        if (rendimentoAnnuo==null)
            rendimentoAnnuo=new ArrayList<RendimentoAnnuo>();
        return rendimentoAnnuo;
    }

    public List<RendimentoMensile> getValoreUnitarioQuota() {
        if (valoreUnitarioQuota==null)
            valoreUnitarioQuota=new ArrayList<RendimentoMensile>();
        return valoreUnitarioQuota;
    }

    public List<Ter> getTer() {
        if(null==ter)
            ter=new ArrayList<Ter>();
        return ter;
    }


    public List<Turnover> getTurnover() {
        if (turnover==null)
            turnover=new ArrayList<Turnover>();
        return turnover;
    }

    public IImageProvider getGraficoRendimentoMensile() {
        return graficoRendimentoMensile;
    }

    public IImageProvider getGraficoRendimentoAnnuale() {
        return graficoRendimentoAnnuale;
    }

    public RendimentoMedioAnnuo getRendimentoMedioAnnuo() {
        if(null==rendimentoMedioAnnuo)
            rendimentoMedioAnnuo=new RendimentoMedioAnnuo();
        return rendimentoMedioAnnuo;
    }

    public String getPeriodoDurata() {
        return FormattatoreDate.formatDate(inizioOperativita,FormattatoreDate.FORMATO_DATA_ITALIANA)+" - "+FormattatoreDate.formatDate(scadenzaOperativita,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }


    public String getOrizzonteInvestimento() {
        if(null==orizzonteInvestimento)
            return "---";
        return orizzonteInvestimento.toString();
    }

    public Patrimonio getPatrimonio() {
        if(null==patrimonio)
            return new Patrimonio();
        return patrimonio;
    }

    public String getInizioOperativita() {
        return FormattatoreDate.formatDate(inizioOperativita,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getScadenzaOperativita() {
        return FormattatoreDate.formatDate(scadenzaOperativita,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setTer(List<Ter> ter) {
        this.ter = ter;
    }


    public void setCodiceFondo(String codiceFondo) {this.codiceFondo = codiceFondo;}
    public void setDescrizioneFondo(String descrizioneFondo) {this.descrizioneFondo = descrizioneFondo; }
    public void setVolatilitaProspettica(VolatilitaProspettica volatilitaProspettica) {this.volatilitaProspettica = volatilitaProspettica;}
    public void setRendimentoAnnuo(List<RendimentoAnnuo> rendimentoAnnuo) { this.rendimentoAnnuo = rendimentoAnnuo;}
    public void setValoreUnitarioQuota(List<RendimentoMensile> valoreUnitarioQuota) {
        this.valoreUnitarioQuota = valoreUnitarioQuota;
    }
    public void setGraficoRendimentoMensile(IImageProvider graficoRendimentoMensile) {
        this.graficoRendimentoMensile = graficoRendimentoMensile;
    }
    public void setGraficoRendimentoAnnuale(IImageProvider graficoRendimentoAnnuale) {
        this.graficoRendimentoAnnuale = graficoRendimentoAnnuale;
    }
    public void setRendimentoMedioAnnuo(RendimentoMedioAnnuo rendimentoMedioAnnuo) {
        this.rendimentoMedioAnnuo = rendimentoMedioAnnuo;
    }
    public void setOrizzonteInvesimento(Integer orizzonteInvestimento) {this.orizzonteInvestimento = orizzonteInvestimento;}
    public void setInizioOperativita(Date inizioOperativita) {this.inizioOperativita = inizioOperativita;}
    public void setScadenzaOperativita(Date scadenzaOperativita) {this.scadenzaOperativita = scadenzaOperativita;}

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

    public void setTurnover(List<Turnover> turnover) {
        this.turnover = turnover;
    }

    public void setFondoNuovo(boolean fondoNuovo) {
        this.fondoNuovo = fondoNuovo;
    }

    @Override
    public String toString() {
        return descrizioneFondo;
    }

}
