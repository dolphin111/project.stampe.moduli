package com.fideuram.stampe.modello.rendiconti.prodotto;

import com.fideuram.stampe.modello.rendiconti.CostiGlobali;
import com.fideuram.stampe.modello.rendiconti.Fondo;
import com.fideuram.stampe.modello.rendiconti.rendimento.Inflazione;
import com.fideuram.stampe.modello.rendiconti.rendimento.RendimentoMedioAnnuo;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with
 * User: V801068
 * Date: 08/01/14
 * Time: 14.13
 */
@XmlRootElement(name="rendiconto", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class NormativaProdottoAllegato{
    protected Date dataRiferimento;
    protected List<Fondo>                 fondi;
    protected Inflazione                  inflazione;
    protected List<CostiGlobali>          costiGlobalis;


    protected boolean hasUltimoAnnoElement  =false;
    protected boolean hasBiennioElemnt      =false;
    protected boolean hasTriennioElemnt     =false;
    protected boolean hasQuinquennioElemnt  =false;
    protected boolean hasDecennioElemnt     =false;
    protected List<RendimentoMedioAnnuo[]> listaUltimoAnno;         //1
    protected List<RendimentoMedioAnnuo[]> listaUltimoBiennio;      //2
    protected List<RendimentoMedioAnnuo[]> listaUltimoTriennio;     //3
    protected List<RendimentoMedioAnnuo[]> listaUltimoQuinquennio;  //5
    protected List<RendimentoMedioAnnuo[]> listaUltimoDeceennio;    //10

    public String getDataRiferimento() {
        if(null==dataRiferimento)
            return "---";
        return FormattatoreDate.formatDate(dataRiferimento, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getAnnoRiferimento() {
        return getDataRiferimento().substring(6);
    }

    /**
     *
     * @param i
     * @return
     */
    public String getAnnoRiferimento(Integer i) {
        int anno= Integer.decode(getDataRiferimento().substring(6));
        return (anno-i)+"";
    }

    public String getAnnoProssimo() {
        int i= Integer.decode(getDataRiferimento().substring(6))+1;
        return i+"";
    }

    public List<Fondo> getFondi() {
        if(fondi==null)
            fondi=new ArrayList<Fondo>();
        return fondi;
    }

    public Inflazione getInflazione() {
        if(null==inflazione)
            inflazione=new Inflazione();
        return inflazione;
    }

    public List<CostiGlobali> getCostiGlobalis() {
        if(null==costiGlobalis){
            costiGlobalis=new ArrayList<CostiGlobali>();
            costiGlobalis.add(new CostiGlobali());
            costiGlobalis.add(new CostiGlobali());
            costiGlobalis.add(new CostiGlobali());
        }
        return costiGlobalis;
    }

    public void setDataRiferimento(Date dataRiferimento) {
        this.dataRiferimento = dataRiferimento;
    }

    public void setFondi(List<Fondo> fondi) {
        this.fondi = fondi;
    }

    public void setInflazione(Inflazione inflazione) {
        this.inflazione = inflazione;
    }

    public void addCostiGlobali(CostiGlobali costiGlobali) {
        if(null==costiGlobalis)
            costiGlobalis=new ArrayList<CostiGlobali>();
        this.costiGlobalis.add(costiGlobali);
    }

    @Override
    public String toString() {
        return dataRiferimento.getYear() +"_";
    }

    /**
     * <br>Crea una lista di n elementi dove ogni elemtno è una sottolista
     * <br>di max 7 BeanRendimentoMedioAnnuo.
     *
     * @return
     */


    public List<RendimentoMedioAnnuo[]> getRendimenti3anni(){
        return listaUltimoTriennio;
    }
    public List<RendimentoMedioAnnuo[]> getRendimenti5anni(){
        return listaUltimoQuinquennio;
    }
    public List<RendimentoMedioAnnuo[]> getRendimenti10anni(){
        return listaUltimoDeceennio;
    }

    public List<RendimentoMedioAnnuo[]> getRendimentiUltimoAnno(){
        return listaUltimoAnno;
    }

    public List<RendimentoMedioAnnuo[]> getRendimentiBiennio(){
        return listaUltimoBiennio;
    }

    public boolean hasUltimoAnno(){
        setLista(1);
        return hasUltimoAnnoElement;
    }

    public boolean hasBiennio(){
        setLista(2);
        return hasBiennioElemnt;
    }

    public boolean hasTriennio(){
        setLista(3);
        return hasTriennioElemnt;
    }

    public boolean hasQuinquennio(){
        setLista(5);
        return hasQuinquennioElemnt;
    }

    public boolean hasDecennio(){
        setLista(10);
        return hasDecennioElemnt;
    }
    private void setLista(int lista){
        int contatore=0;
        RendimentoMedioAnnuo[] r=new RendimentoMedioAnnuo[7];
        List<RendimentoMedioAnnuo[]> g = new ArrayList();
        boolean cingaleseAcido=false;    //il 14Febbraio2014 il cingalese del civico 20 ha bruciato le scarpe di Funari con l'acido muriatico
        for (int i = 0; i<fondi.size();i++){
            if(contatore==7){
                if(cingaleseAcido==true)
                    g.add(r);
                r=new RendimentoMedioAnnuo[7];
                contatore=0;
                cingaleseAcido=false;
            }
            if(null!=fondi.get(i).getRendimentoMedioAnnuo().getDataUltimoanno()){
                fondi.get(i).getRendimentoMedioAnnuo().setIdFondoFk(i);
            }
            switch (lista){
                case 1:
                    if("---"!=fondi.get(i).getRendimentoMedioAnnuo().getUltimoanno()&&"---".equals(fondi.get(i).getRendimentoMedioAnnuo().getUltimi2anni())){
                        hasUltimoAnnoElement=true;
                        cingaleseAcido=true;
                        r[contatore]= fondi.get(i).getRendimentoMedioAnnuo();
                        contatore++;
                    }
                    break;
                case 2:
                    if("---"!=fondi.get(i).getRendimentoMedioAnnuo().getUltimi2anni()){
                        hasBiennioElemnt=true;
                        cingaleseAcido=true;
                        r[contatore]=fondi.get(i).getRendimentoMedioAnnuo();
                        contatore++;
                    }
                    break;
                case 3:
                    if("---"!=fondi.get(i).getRendimentoMedioAnnuo().getUltimi3anni()){
                        hasTriennioElemnt=true;
                        cingaleseAcido=true;
                        r[contatore]=fondi.get(i).getRendimentoMedioAnnuo();
                    }
                    contatore++;
                    break;
                case 5:
                    if("---"!=fondi.get(i).getRendimentoMedioAnnuo().getUltimi5anni()){
                        hasQuinquennioElemnt=true;
                        cingaleseAcido=true;
                        r[contatore]=fondi.get(i).getRendimentoMedioAnnuo();
                     }
                    contatore++;
                    break;
                case 10:
                    //if("---"!=fondi.get(i).getRendimentoMedioAnnuo().getUltimi10anni()){
                        hasDecennioElemnt=true;
                        cingaleseAcido=true;
                        r[contatore]=fondi.get(i).getRendimentoMedioAnnuo();
                    //}
                    contatore++;
                    break;
            }


        }
        if(contatore>0&&cingaleseAcido)
            g.add(r);
        switch (lista){
            case 1:
                listaUltimoAnno=g;
                break;
            case 2:
                listaUltimoBiennio=g;
                break;
            case 3:
                listaUltimoTriennio=g;
                break;
            case 5:
                listaUltimoQuinquennio=g;
                break;
            case 10:
                listaUltimoDeceennio=g;
                break;
        }
    }

}
