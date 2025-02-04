package com.fideuram.modello;

import com.fideuram.costanti.Costanti;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.addendum.Addendum;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.modello.supplemento.Supplemento;
import com.fideuram.modello.tbd.ClasseBonus;
import com.fideuram.modello.tbd.CostoRetrocesso;
import com.fideuram.modello.tbd.LineaInvestimento;
import com.fideuram.utils.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 28/06/12
 * Time: 9.30
 */
public class PubblicazioneConsob implements Serializable {
    private boolean notaIvass=false;
    private Date deposito;                           //Data di deposito in Consob
    private Date validita;                           //Data di validita
    private List<LineaInvestimento> linee;
    private List<ClasseBonus> classeBonus;
    private List<CostoRetrocesso> costoRetrocesso;
    private List<SelectionFund> selectionFunds;
    private String protocolloI="_________";
    private String protocolloII="__________";
    private String protocolloIII="__________";
    private String nomeProdotto="";
    private Supplemento supplemento;
    private String testoNomeProdotto_I;
    private String testoNomeProdotto_III;
    private String testoFondoInterno;
    private String testoFissoSintesi;
    private String testoFissoAllegatoA;
    private boolean isGemini = false;
    private boolean isInsieme = false;
    private String annoRendiconto;
    private Addendum addendum;
    private String tassoMedioInflazione2AnniPrecedenti;
    private String tassoMedioInflazione1AnnoPrecedente;
    private String tassoMedioInflazioneUltimi3Anni;
    private String tassoMedioInflazioneUltimi5Anni;
    private String tassoMedioInflazioneUltimi10Anni;
    
    
    
    
	/**
	 * @return the isInsieme
	 */
	public boolean isInsieme() {
		return isInsieme;
	}

	/**
	 * @param isInsieme the isInsieme to set
	 */
	public void setInsieme(boolean isInsieme) {
		this.isInsieme = isInsieme;
	}

	/**
	 * @return the addendum
	 */
	public Addendum getAddendum() {
		return addendum;
	}

	/**
	 * @param addendum the addendum to set
	 */
	public void setAddendum(Addendum addendum) {
		this.addendum = addendum;
	}

	/**
	 * @return the tassoMedioInflazione2AnniPrecedenti
	 */
	public String getTassoMedioInflazione2AnniPrecedenti() {
		return tassoMedioInflazione2AnniPrecedenti;
	}

	/**
	 * @param tassoMedioInflazione2AnniPrecedenti the tassoMedioInflazione2AnniPrecedenti to set
	 */
	public void setTassoMedioInflazione2AnniPrecedenti(
			String tassoMedioInflazione2AnniPrecedenti) {
		this.tassoMedioInflazione2AnniPrecedenti = tassoMedioInflazione2AnniPrecedenti;
	}

	/**
	 * @return the tassoMedioInflazione1AnnoPrecedente
	 */
	public String getTassoMedioInflazione1AnnoPrecedente() {
		return tassoMedioInflazione1AnnoPrecedente;
	}

	/**
	 * @param tassoMedioInflazione1AnnoPrecedente the tassoMedioInflazione1AnnoPrecedente to set
	 */
	public void setTassoMedioInflazione1AnnoPrecedente(
			String tassoMedioInflazione1AnnoPrecedente) {
		this.tassoMedioInflazione1AnnoPrecedente = tassoMedioInflazione1AnnoPrecedente;
	}

	/**
	 * @return the tassoMedioInflazioneUltimi3Anni
	 */
	public String getTassoMedioInflazioneUltimi3Anni() {
		return tassoMedioInflazioneUltimi3Anni;
	}

	/**
	 * @param tassoMedioInflazioneUltimi3Anni the tassoMedioInflazioneUltimi3Anni to set
	 */
	public void setTassoMedioInflazioneUltimi3Anni(
			String tassoMedioInflazioneUltimi3Anni) {
		this.tassoMedioInflazioneUltimi3Anni = tassoMedioInflazioneUltimi3Anni;
	}

	/**
	 * @return the tassoMedioInflazioneUltimi5Anni
	 */
	public String getTassoMedioInflazioneUltimi5Anni() {
		return tassoMedioInflazioneUltimi5Anni;
	}

	/**
	 * @param tassoMedioInflazioneUltimi5Anni the tassoMedioInflazioneUltimi5Anni to set
	 */
	public void setTassoMedioInflazioneUltimi5Anni(
			String tassoMedioInflazioneUltimi5Anni) {
		this.tassoMedioInflazioneUltimi5Anni = tassoMedioInflazioneUltimi5Anni;
	}

	/**
	 * @return the tassoMedioInflazioneUltimi10Anni
	 */
	public String getTassoMedioInflazioneUltimi10Anni() {
		return tassoMedioInflazioneUltimi10Anni;
	}

	/**
	 * @param tassoMedioInflazioneUltimi10Anni the tassoMedioInflazioneUltimi10Anni to set
	 */
	public void setTassoMedioInflazioneUltimi10Anni(
			String tassoMedioInflazioneUltimi10Anni) {
		this.tassoMedioInflazioneUltimi10Anni = tassoMedioInflazioneUltimi10Anni;
	}

	/**
	 * @return the annoRendiconto
	 */
	public String getAnnoRendiconto() {
		return annoRendiconto;
	}

	/**
	 * @param annoRendiconto the annoRendiconto to set
	 */
	public void setAnnoRendiconto(String annoRendiconto) {
		this.annoRendiconto = annoRendiconto;
	}

	public boolean isGemini() {
		return isGemini;
	}

	public void setGemini(boolean isGemini) {
		this.isGemini = isGemini;
	}

	public boolean isNotaIvass() {
        return notaIvass;
    }

    public void setNotaIvass() {
        this.notaIvass = true;
    }

    public boolean isNotPrivate(){
        if(getNomeProdotto().contains("Private"))
            return false;
        return true;
    }


    public String getAnno() {
        int i= Integer.decode(FormatterFactory.getStandardDate(validita).substring(6))-1;
        return i+"";
    }

    public Supplemento getSupplemento() {
        return supplemento;
    }

    public void setSupplemento(Supplemento supplemento) {
        this.supplemento = supplemento;
    }

    public String getNomeProdotto() {
        if(null==nomeProdotto)
            return "";
        return nomeProdotto;
    }

    public String getNomeProdottoToUpperCase() {
        if(null==nomeProdotto)
            return "";
        return nomeProdotto.toUpperCase();
    }

    public String getTestoNomeProdotto_III() {
        return testoNomeProdotto_III!=null?testoNomeProdotto_III:"";
    }

    public String getTestoNomeProdotto_I() {
        return testoNomeProdotto_I!=null?testoNomeProdotto_I:"";
    }

    public String getTestoFondoInterno() {
        return testoFondoInterno!=null?testoFondoInterno:"";
    }

    public String getTestoFissoSintesi() {
        return testoFissoSintesi!=null?testoFissoSintesi:"";
    }

    //DA QUI
    boolean spriz; //povero te se stai cercando di capire a cosa serve  lo spritz.. dai ti aiuto spritz sta per split
    int finoA;
    public String getTestoFissoSintesiSplit1() {
       if(testoFissoSintesi!=null&&testoFissoSintesi.contains("Nel caso")){
            spriz=true;
            finoA = testoFissoSintesi.indexOf(".")+1;
            return testoFissoSintesi.substring(0,finoA);
       }
       return "";
    }

    public String getTestoFissoSintesiSplit2() {
        if (spriz)
            return testoFissoSintesi.substring(finoA);
        else
            return getTestoFissoSintesi();
    }

    //A QUI NON SONO PIU' STATO IN ME

    public String getTestoFissoAllegatoA() {
        return testoFissoAllegatoA!=null?testoFissoAllegatoA:"";
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public void setTestoNomeProdotto_I(String testoNomeProdotto) {
        this.testoNomeProdotto_I = testoNomeProdotto;
    }

    public void setTestoNomeProdotto_III(String testoNomeProdotto_III) {
        this.testoNomeProdotto_III = testoNomeProdotto_III;
    }

    public void setTestoFondoInterno(String testoFondoInterno) {
        this.testoFondoInterno = testoFondoInterno;
    }

    public void setTestoFissoSintesi(String testoFissoSintesi) {
        this.testoFissoSintesi = testoFissoSintesi;
    }

    public void setTestoFissoAllegatoA(String testoFissoAllegatoA) {
        this.testoFissoAllegatoA = testoFissoAllegatoA;
    }

    public List<SelectionFund> getSelectionFunds() {
        return selectionFunds;
    }

    public void setSelectionFunds(List<SelectionFund> selectionFunds) {
        this.selectionFunds = selectionFunds;
    }

    public void addSelectionFunds(SelectionFund selectionFund) {
        if(null==selectionFunds)
            selectionFunds=new ArrayList<SelectionFund>();
        if(selectionFund.isPropostaInvestimento()){
            selectionFund.setPuntatore("");
            this.selectionFunds.add(0,selectionFund);
        }else{
            this.selectionFunds.add(selectionFund);
        }
    }

    public Date getDeposito() {
        return deposito ;
    }

    public void setDeposito(Date deposito) {
        this.deposito = deposito;
    }

    public Date getValidita() {
        return validita;
    }



    public void setValidita(Date validita) {
        this.validita = validita;
    }



    public List<CostoRetrocesso> getCostoRetrocesso() {
        return costoRetrocesso;
    }

    public void addCostoRetrocesso (CostoRetrocesso  c) {
        if(costoRetrocesso==null)
            costoRetrocesso=new ArrayList<CostoRetrocesso>();
        this.costoRetrocesso.add(c);
    }

    public List<LineaInvestimento> getLinee() {
        return linee;
    }

    public void addLinea(LineaInvestimento  linea) {
        if(linee==null)
            linee=new ArrayList<LineaInvestimento>();
        this.linee.add(linea);
    }

    public List<ClasseBonus> getClasseBonus() {
        return classeBonus;
    }

    public void addClasseBonus( ClasseBonus  c) {
        if(classeBonus==null)
            classeBonus=new ArrayList<ClasseBonus>();
        classeBonus.add(c);
    }

    public String getValiditaString() {
        if(null==validita)
            return "";
        return DateUtils.formatDate(validita, Costanti.FORMATO_DATA);
    }

    public String getDepositoString() {
        if(null==deposito)
            return "";
        return DateUtils.formatDate(deposito, Costanti.FORMATO_DATA);
    }

    public String getProtocolloI() {
        return protocolloI;
    }

    public void setProtocolloI(String protocolloI) {
        if(null==protocolloI)
            return;
        this.protocolloI = protocolloI;
    }

    public String getProtocolloII() {
        return protocolloII;
    }

    public void setProtocolloII(String protocolloII) {
        if(null==protocolloII)
            return;
        this.protocolloII = protocolloII;
    }

    public String getProtocolloIII() {
        return protocolloIII;
    }

    public void setProtocolloIII(String protocolloIII) {
        if(null==protocolloIII)
            return;
        this.protocolloIII = protocolloIII;
    }


    /**
     * Ha lo scopo di:
     *   - eliminare le SelectionFund se prive di OICR : eraseEmptySelection deve essere == true
     *   - indicizzare le  SelectionFund  a partire da  shiftIndexPosition = 0||1||2...
     * @param eraseEmptySelection
     */
    public void cleanDoc(boolean eraseEmptySelection){
        for (int i=0; i<selectionFunds.size();i++){
            SelectionFund s =selectionFunds.get(i);
            //if (eraseEmptySelection && (null==s.getFundhouses()||s.getFundhouses().size()==0)){
            if (eraseEmptySelection && s.getFundhouses().size()==0){
                selectionFunds.remove(i);
                i=i-1;
            }
        }
    }

    public void indexSelectionFunds(int shiftPosition){
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int puntatore=0;
        for (int i=0+shiftPosition; i<selectionFunds.size();i++){
            selectionFunds.get(i).setPuntatore(alphabet[puntatore]+")");
            puntatore++;
        }
    }

   //private void orderSelectionFund(){
   //    //SelectionFund proposta=null;
   //    //for (int i = 0; i<selectionFunds.size(); i++){
   //    //     proposta=selectionFunds.get(i).isPropostaInvestimento()?selectionFunds.get(i):null;
   //    //}
   //    //if (proposta!=null){
   //    //    selectionFunds.remove(proposta);
   //    //    selectionFunds.add(0,proposta);
   //    //}
   //}

}
