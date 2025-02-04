package com.fideuram.crm.stampe.model.vospolizza.rendita;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.AvvisidiScadenzaVO;
import com.fideuram.puc.service.impl.OpzioneCertezzaVO;
import com.fideuram.utils.NumberUtils;

import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 28/12/11
 * Time: 16.01
 */
public class Certezza extends AbstractIpotesi implements ICertezza {
    private int certezze=0;

    /**
     * Questo metodo nasce a seguito del TCK 820
     * Impatta sul template AvvisiScadenzaVO.odt
     * @param avvisi
     */
      public Certezza(AvvisidiScadenzaVO avvisi, Polizza polizza) {
           certezze=1;
           setOpzioneAnni1(avvisi.getAnniCertezza1()!=null?avvisi.getAnniCertezza1().toString():"5");
           setTotaleRenditaCerta1AnnualePosticipata(avvisi.getTotaleRenditaCerta1AnnualePosticipata()!=null?avvisi.getTotaleRenditaCerta1AnnualePosticipata():0.00);
           setTotaleRenditaCerta1SemestralePosticipata(avvisi.getTotaleRenditaCerta1SemestralePosticipata()!=null?avvisi.getTotaleRenditaCerta1SemestralePosticipata():0.00);
           setTotaleRenditaCerta1TrimestralePosticipata(avvisi.getTotaleRenditaCerta1TrimestralePosticipata()!=null?avvisi.getTotaleRenditaCerta1TrimestralePosticipata():0.00);
           setTotaleRenditaCerta1MensilePosticipata(avvisi.getTotaleRenditaCerta1MensilePosticipata()!=null?avvisi.getTotaleRenditaCerta1MensilePosticipata():0.00);

           //la seconda opzione certezza è valida solo per le polizze di ramo I....e può non arrivare
           if(polizza.getRamoMinisteriale().equals("1") && avvisi.getAnniCertezza2()!=null){
               certezze=2;
               setOpzioneAnni2(avvisi.getAnniCertezza2()!=null?avvisi.getAnniCertezza2().toString():"");
               setTotaleRenditaCerta2AnnualePosticipata(avvisi.getTotaleRenditaCerta2AnnualePosticipata());
               setTotaleRenditaCerta2SemestralePosticipata(avvisi.getTotaleRenditaCerta2Semestraleposticipata());
               setTotaleRenditaCerta2TrimestralePosticipata(avvisi.getTotaleRenditaCerta2TrimestralePosticipata());
               setTotaleRenditaCerta2MensilePosticipata(avvisi.getTotaleRenditaCerta2MensilePosticipata());
           }
      }

    public boolean isUnaCertezza() {
        return certezze==1?true:false;
    }

    public boolean isDueCertezze() {
        return certezze==2?true:false;
    }

    public Certezza(List<OpzioneCertezzaVO> lCertezza) {
        if (lCertezza != null) {
            for (int i = 0; i < lCertezza.size(); i++) {
                switch (i) {
                    case (0):
                        if(lCertezza.get(0).getAnniCertezza()!=null)
                            setOpzioneAnni1(lCertezza.get(0).getAnniCertezza().toString());
                        if(lCertezza.get(0).getAnnuale()!=null)
                            setTotaleRenditaCerta1AnnualePosticipata(lCertezza.get(i).getAnnuale());
                        if(lCertezza.get(0).getSemestrale()!=null)
                            setTotaleRenditaCerta1SemestralePosticipata(lCertezza.get(i).getSemestrale());
                        if(lCertezza.get(0).getTrimestrale()!=null)
                            setTotaleRenditaCerta1TrimestralePosticipata(lCertezza.get(i).getTrimestrale());
                        if(lCertezza.get(0).getMensile()!=null)
                            setTotaleRenditaCerta1MensilePosticipata(lCertezza.get(i).getMensile());
                        break;
                    case (1):
                        setOpzioneAnni2(lCertezza.get(1).getAnniCertezza().toString());
                        setTotaleRenditaCerta2AnnualePosticipata(lCertezza.get(i).getAnnuale());
                        setTotaleRenditaCerta2SemestralePosticipata(lCertezza.get(i).getSemestrale());
                        setTotaleRenditaCerta2TrimestralePosticipata(lCertezza.get(i).getTrimestrale());
                        setTotaleRenditaCerta2MensilePosticipata(lCertezza.get(i).getMensile());
                        break;
                    case (2):
                        setOpzioneAnni3(lCertezza.get(2).getAnniCertezza().toString());
                        setTotaleRenditaCerta3AnnualePosticipata(lCertezza.get(i).getAnnuale());
                        setTotaleRenditaCerta3SemestralePosticipata(lCertezza.get(i).getSemestrale());
                        setTotaleRenditaCerta3TrimestralePosticipata(lCertezza.get(i).getTrimestrale());
                        setTotaleRenditaCerta3MensilePosticipata(lCertezza.get(i).getMensile());
                        break;
                    case (3):
                        setOpzioneAnni4(lCertezza.get(3).getAnniCertezza().toString());
                        setTotaleRenditaCerta4AnnualePosticipata(lCertezza.get(i).getAnnuale());
                        setTotaleRenditaCerta4SemestralePosticipata(lCertezza.get(i).getSemestrale());
                        setTotaleRenditaCerta4TrimestralePosticipata(lCertezza.get(i).getTrimestrale());
                        setTotaleRenditaCerta4MensilePosticipata(lCertezza.get(i).getMensile());
                        break;
                }
            }
        }
    }

    public String getOpzioneAnni1() {
        return OpzioneAnni1;
    }

    public void setOpzioneAnni1(String opzioneAnni1) {
        OpzioneAnni1 = opzioneAnni1;
    }

    public String getOpzioneAnni2() {
        return OpzioneAnni2;
    }

    public void setOpzioneAnni2(String opzioneAnni2) {
        OpzioneAnni2 = opzioneAnni2;
    }

    public String getOpzioneAnni3() {
        return OpzioneAnni3;
    }

    public void setOpzioneAnni3(String opzioneAnni3) {
        OpzioneAnni3 = opzioneAnni3;
    }

    public String getOpzioneAnni4() {
        return OpzioneAnni4;
    }

    public void setOpzioneAnni4(String opzioneAnni4) {
        OpzioneAnni4 = opzioneAnni4;
    }

    public String getTotaleRenditaCerta1AnnualePosticipata() {
        return numToString(totaleRenditaCerta1AnnualePosticipata);
    }

    public void setTotaleRenditaCerta1AnnualePosticipata(Double totaleRenditaCerta1AnnualePosticipata) {
        this.totaleRenditaCerta1AnnualePosticipata = totaleRenditaCerta1AnnualePosticipata;
    }

    public String getTotaleRenditaCerta1SemestralePosticipata() {
        return numToString(totaleRenditaCerta1SemestralePosticipata);
    }

    public void setTotaleRenditaCerta1SemestralePosticipata(Double totaleRenditaCerta1SemestralePosticipata) {
        this.totaleRenditaCerta1SemestralePosticipata = totaleRenditaCerta1SemestralePosticipata;
    }

    public String getTotaleRenditaCerta1TrimestralePosticipata() {
        return numToString(totaleRenditaCerta1TrimestralePosticipata);
    }

    public void setTotaleRenditaCerta1TrimestralePosticipata(Double totaleRenditaCerta1TrimestralePosticipata) {
        this.totaleRenditaCerta1TrimestralePosticipata = totaleRenditaCerta1TrimestralePosticipata;
    }

    public String getTotaleRenditaCerta1MensilePosticipata() {
        return numToString(totaleRenditaCerta1MensilePosticipata);
    }

    public void setTotaleRenditaCerta1MensilePosticipata(Double totaleRenditaCerta1MensilePosticipata) {
        this.totaleRenditaCerta1MensilePosticipata = totaleRenditaCerta1MensilePosticipata;
    }

    public String getTotaleRenditaCerta2AnnualePosticipata() {
        return numToString(totaleRenditaCerta2AnnualePosticipata);
    }

    public void setTotaleRenditaCerta2AnnualePosticipata(Double totaleRenditaCerta2AnnualePosticipata) {
        this.totaleRenditaCerta2AnnualePosticipata = totaleRenditaCerta2AnnualePosticipata;
    }

    public String getTotaleRenditaCerta2SemestralePosticipata() {
        return numToString(totaleRenditaCerta2SemestralePosticipata);
    }

    public void setTotaleRenditaCerta2SemestralePosticipata(Double totaleRenditaCerta2SemestralePosticipata) {
        this.totaleRenditaCerta2SemestralePosticipata = totaleRenditaCerta2SemestralePosticipata;
    }

    public String getTotaleRenditaCerta2TrimestralePosticipata() {
        return numToString(totaleRenditaCerta2TrimestralePosticipata);
    }

    public void setTotaleRenditaCerta2TrimestralePosticipata(Double totaleRenditaCerta2TrimestralePosticipata) {
        this.totaleRenditaCerta2TrimestralePosticipata = totaleRenditaCerta2TrimestralePosticipata;
    }

    public String getTotaleRenditaCerta2MensilePosticipata() {
        return numToString(totaleRenditaCerta2MensilePosticipata);
    }

    public void setTotaleRenditaCerta2MensilePosticipata(Double totaleRenditaCerta2MensilePosticipata) {
        this.totaleRenditaCerta2MensilePosticipata = totaleRenditaCerta2MensilePosticipata;
    }

    public String getTotaleRenditaCerta3AnnualePosticipata() {
        return numToString(totaleRenditaCerta3AnnualePosticipata);
    }

    public void setTotaleRenditaCerta3AnnualePosticipata(Double totaleRenditaCerta3AnnualePosticipata) {
        this.totaleRenditaCerta3AnnualePosticipata = totaleRenditaCerta3AnnualePosticipata;
    }

    public String getTotaleRenditaCerta3SemestralePosticipata() {
        return numToString(totaleRenditaCerta3SemestralePosticipata);
    }

    public void setTotaleRenditaCerta3SemestralePosticipata(Double totaleRenditaCerta3SemestralePosticipata) {
        this.totaleRenditaCerta3SemestralePosticipata = totaleRenditaCerta3SemestralePosticipata;
    }

    public String getTotaleRenditaCerta3TrimestralePosticipata() {
        return numToString(totaleRenditaCerta3TrimestralePosticipata);
    }

    public void setTotaleRenditaCerta3TrimestralePosticipata(Double totaleRenditaCerta3TrimestralePosticipata) {
        this.totaleRenditaCerta3TrimestralePosticipata = totaleRenditaCerta3TrimestralePosticipata;
    }

    public String getTotaleRenditaCerta3MensilePosticipata() {
        return numToString(totaleRenditaCerta3MensilePosticipata);
    }

    public void setTotaleRenditaCerta3MensilePosticipata(Double totaleRenditaCerta3MensilePosticipata) {
        this.totaleRenditaCerta3MensilePosticipata = totaleRenditaCerta3MensilePosticipata;
    }

    public String getTotaleRenditaCerta4AnnualePosticipata() {
        return numToString(totaleRenditaCerta4AnnualePosticipata);
    }

    public void setTotaleRenditaCerta4AnnualePosticipata(Double totaleRenditaCerta4AnnualePosticipata) {
        this.totaleRenditaCerta4AnnualePosticipata = totaleRenditaCerta4AnnualePosticipata;
    }

    public String getTotaleRenditaCerta4SemestralePosticipata() {
        return numToString(totaleRenditaCerta4SemestralePosticipata);
    }

    public void setTotaleRenditaCerta4SemestralePosticipata(Double totaleRenditaCerta4SemestralePosticipata) {
        this.totaleRenditaCerta4SemestralePosticipata = totaleRenditaCerta4SemestralePosticipata;
    }

    public String getTotaleRenditaCerta4TrimestralePosticipata() {
        return numToString(totaleRenditaCerta4TrimestralePosticipata);
    }

    public void setTotaleRenditaCerta4TrimestralePosticipata(Double totaleRenditaCerta4TrimestralePosticipata) {
        this.totaleRenditaCerta4TrimestralePosticipata = totaleRenditaCerta4TrimestralePosticipata;
    }

    public String getTotaleRenditaCerta4MensilePosticipata() {
        return numToString(totaleRenditaCerta4MensilePosticipata);
    }

    public void setTotaleRenditaCerta4MensilePosticipata(Double totaleRenditaCerta4MensilePosticipata) {
        this.totaleRenditaCerta4MensilePosticipata = totaleRenditaCerta4MensilePosticipata;
    }

    public boolean isPrestazioniAssicurate() {
        return isPrestazioniAssicurate;
    }

    public void setPrestazioniAssicurate(boolean prestazioniAssicurate) {
        isPrestazioniAssicurate = prestazioniAssicurate;
    }

    private String OpzioneAnni1="";
	private String OpzioneAnni2="";
	private String OpzioneAnni3="";
	private String OpzioneAnni4="";
	private Double totaleRenditaCerta1AnnualePosticipata;
	private Double totaleRenditaCerta1SemestralePosticipata;
	private Double totaleRenditaCerta1TrimestralePosticipata;
	private Double totaleRenditaCerta1MensilePosticipata;
	private Double totaleRenditaCerta2AnnualePosticipata;
	private Double totaleRenditaCerta2SemestralePosticipata;
	private Double totaleRenditaCerta2TrimestralePosticipata;
	private Double totaleRenditaCerta2MensilePosticipata;
	private Double totaleRenditaCerta3AnnualePosticipata;
	private Double totaleRenditaCerta3SemestralePosticipata;
	private Double totaleRenditaCerta3TrimestralePosticipata;
	private Double totaleRenditaCerta3MensilePosticipata;
	private Double totaleRenditaCerta4AnnualePosticipata;
	private Double totaleRenditaCerta4SemestralePosticipata;
	private Double totaleRenditaCerta4TrimestralePosticipata;
	private Double totaleRenditaCerta4MensilePosticipata;
    private boolean isPrestazioniAssicurate = true;

}
