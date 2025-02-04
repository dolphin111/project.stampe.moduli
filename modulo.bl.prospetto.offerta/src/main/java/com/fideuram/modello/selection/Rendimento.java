package com.fideuram.modello.selection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fideuram.utils.SerigrafiaStringhe;

/**
 * Created by
 * User: logan
 * Date: 06/06/12
 * Time: 14.25
 */
public class Rendimento implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String periodoOsservazione;             //Ultimi 1-2-3 anni
    private String periodoII =null;                 //Ultimi > 3 anni     //todo eliminare (non usato)
    private int colonneRendimento=1;
    List<DatiRendimento> datiRendimentos;
    private String volatilitaUltimoAnnoSolareExAnte;
    private String volatilitaUltimoAnnoSolareExPost;
    private String ultimoAnnoSolareTrascorso;
    private String note="";
    private int anniBmk;
    private String benchmark;
    private String stampaExAntePost;
    private String tabella1;
    private String tabella2;
    private String tabella3;
    private String tabella4;
    private int c=0;                           // definisce quale tabella mostrare
    private boolean graficoDiBenchmark;
    private String primoAnnoOICR = "";
	private String secondoAnnoOICR = "";
	private String primoAnnoBMK= "";
	private String secondoAnnoBMK= "";
	private String ultimiDiecianniOICR = "";
	private String ultimiDieciAnniBMK= "";
	private String ultimi3anniOICR = "";
	private String ultimi3AnniBMK= "";
	private String ultimi5anniOICR = "";
	private String ultimi5AnniBMK= "";
	private String volatilitaBMK = "";
	private boolean tipoUno =false; //utilizzato per gli FVI Gemini
	private boolean tipoDue =false;
	private boolean tipoTre =false;
	private boolean tipoQuattro =false;
	private boolean tipoCinque =false;
	private boolean tipoSei =false;
	private boolean tipoZero = false;
	private String tassoMedioInflazione2AnniPrecedenti = ""; // = "0,00%";
	private String tassoMedioInflazione1AnnoPrecedente = ""; // = "-0,10%";
	private String tassoMedioInflazioneUltimi3Anni = "";// = "0,03%";
	private String tassoMedioInflazioneUltimi5Anni = "";// = "0,86%";
	private String tassoMedioInflazioneUltimi10Anni = "";// = "1,27%";
	private List<String> match = Arrays.asList( "n.d.","nd","n.d","nd.","n.a.","na","n.a","na.",
			"N.D.","ND","N.D","ND.","N.A.","NA","N.A","NA.");
	

	public String getTassoMedioInflazione2AnniPrecedenti() {
		return tassoMedioInflazione2AnniPrecedenti;
	}

	public void setTassoMedioInflazione2AnniPrecedenti(
			String tassoMedioInflazione2AnniPrecedenti) {
		if(tassoMedioInflazione2AnniPrecedenti != null)
			this.tassoMedioInflazione2AnniPrecedenti = tassoMedioInflazione2AnniPrecedenti;
	}

	public String getTassoMedioInflazione1AnnoPrecedente() {
		return tassoMedioInflazione1AnnoPrecedente;
	}

	public void setTassoMedioInflazione1AnnoPrecedente(
			String tassoMedioInflazione1AnnoPrecedente) {
		if(tassoMedioInflazione1AnnoPrecedente != null)
			this.tassoMedioInflazione1AnnoPrecedente = tassoMedioInflazione1AnnoPrecedente;
	}

	public String getTassoMedioInflazioneUltimi3Anni() {
		return tassoMedioInflazioneUltimi3Anni;
	}

	public void setTassoMedioInflazioneUltimi3Anni(
			String tassoMedioInflazioneUltimi3Anni) {
		if(tassoMedioInflazioneUltimi3Anni != null)
			this.tassoMedioInflazioneUltimi3Anni = tassoMedioInflazioneUltimi3Anni;
	}

	public String getTassoMedioInflazioneUltimi5Anni() {
		return tassoMedioInflazioneUltimi5Anni;
	}

	public void setTassoMedioInflazioneUltimi5Anni(
			String tassoMedioInflazioneUltimi5Anni) {
		if(tassoMedioInflazioneUltimi5Anni != null)
			this.tassoMedioInflazioneUltimi5Anni = tassoMedioInflazioneUltimi5Anni;
	}

	public String getTassoMedioInflazioneUltimi10Anni() {
		return tassoMedioInflazioneUltimi10Anni;
	}

	public void setTassoMedioInflazioneUltimi10Anni(
			String tassoMedioInflazioneUltimi10Anni) {
		if(tassoMedioInflazioneUltimi10Anni != null)
			this.tassoMedioInflazioneUltimi10Anni = tassoMedioInflazioneUltimi10Anni;
	}

	public boolean isTipoZero() {
		return tipoZero;
	}

	public void setTipoZero(boolean tipoZero) {
		this.tipoZero = tipoZero;
	}

	public boolean isTipoUno() {
		return tipoUno;
	}

	public void setTipoUno(boolean tipoUno) {
		this.tipoUno = tipoUno;
	}

	public boolean isTipoDue() {
		return tipoDue;
	}

	public void setTipoDue(boolean tipoDue) {
		this.tipoDue = tipoDue;
	}

	public boolean isTipoTre() {
		return tipoTre;
	}

	public void setTipoTre(boolean tipoTre) {
		this.tipoTre = tipoTre;
	}

	public boolean isTipoQuattro() {
		return tipoQuattro;
	}

	public void setTipoQuattro(boolean tipoQuattro) {
		this.tipoQuattro = tipoQuattro;
	}


	public boolean isTipoCinque() {
		return tipoCinque;
	}

	public void setTipoCinque(boolean tipoCinque) {
		this.tipoCinque = tipoCinque;
	}

	public boolean isTipoSei() {
		return tipoSei;
	}

	public void setTipoSei(boolean tipoSei) {
		this.tipoSei = tipoSei;
	}

	public String getUltimi3anniOICR() {
		return ultimi3anniOICR;
	}

	public void setUltimi3anniOICR(String ultimi3anniOICR) {
		if(ultimi3anniOICR != null)
			this.ultimi3anniOICR = ultimi3anniOICR;
	}

	public String getUltimi3AnniBMK() {
		return ultimi3AnniBMK;
	}

	public void setUltimi3AnniBMK(String ultimi3AnniBMK) {
		if(ultimi3AnniBMK != null)
			this.ultimi3AnniBMK = ultimi3AnniBMK;
	}

	public String getUltimi5anniOICR() {
		return ultimi5anniOICR;
	}

	public void setUltimi5anniOICR(String ultimi5anniOICR) {
		if(ultimi5anniOICR != null)
		 this.ultimi5anniOICR = ultimi5anniOICR;
	}

	public String getUltimi5AnniBMK() {
		return ultimi5AnniBMK;
	}

	public void setUltimi5AnniBMK(String ultimi5AnniBMK) {
		if(ultimi5AnniBMK != null)
			this.ultimi5AnniBMK = ultimi5AnniBMK;
	}

	public String getPrimoAnnoOICR() {
		return primoAnnoOICR;
	}

	public void setPrimoAnnoOICR(String primoAnnoOICR) {
		if(primoAnnoOICR != null){
			this.primoAnnoOICR = primoAnnoOICR;
		}
	}

	public String getSecondoAnnoOICR() {
		return secondoAnnoOICR;
	}

	public void setSecondoAnnoOICR(String secondoAnnoOICR) {
		if(secondoAnnoOICR != null){
			this.secondoAnnoOICR = secondoAnnoOICR;
		}
	}

	public String getPrimoAnnoBMK() {
		return primoAnnoBMK;
	}

	public void setPrimoAnnoBMK(String primoAnnoBMK) {
		if(primoAnnoBMK != null){
			this.primoAnnoBMK = primoAnnoBMK;
		}
	}

	public String getSecondoAnnoBMK() {
		return secondoAnnoBMK;
	}

	public void setSecondoAnnoBMK(String secondoAnnoBMK) {
		if(secondoAnnoBMK != null){
			this.secondoAnnoBMK = secondoAnnoBMK;
		}
	}

	public String getUltimiDiecianniOICR() {
		return ultimiDiecianniOICR;
	}

	public void setUltimiDiecianniOICR(String ultimiDiecianniOICR) {
		if(ultimiDiecianniOICR != null){
			this.ultimiDiecianniOICR = ultimiDiecianniOICR;
		}
	}

	public String getUltimiDieciAnniBMK() {
		return ultimiDieciAnniBMK;
	}

	public void setUltimiDieciAnniBMK(String ultimiDieciAnniBMK) {
		if(ultimiDieciAnniBMK != null){
			this.ultimiDieciAnniBMK = ultimiDieciAnniBMK;
		}
	}

	public String getVolatilitaBMK() {
		return volatilitaBMK;
	}

	public void setVolatilitaBMK(String volatilitaBMK) {
		if(volatilitaBMK != null && !"".equals(volatilitaBMK)){
			this.volatilitaBMK = volatilitaBMK + (!"Non previsto".equals(volatilitaBMK) && !"n.d.".equals(volatilitaBMK) && !volatilitaBMK.contains("%")? "%" : "");
		}
	}

	public boolean hasGraficoDiBenchmark() {
        return graficoDiBenchmark;
    }

    public void setGraficoDiBenchmark(boolean graficoDiBenchmark) {
        this.graficoDiBenchmark = graficoDiBenchmark;
    }

    public String getStampaExAntePost() {
        return stampaExAntePost;
    }

    public void setStampaExAntePost(String stampaExAntePost) {
        this.stampaExAntePost = stampaExAntePost;
    }




    public String getBenchmark() {
        return benchmark;
    }


    public void setBenchmark(String benchmark) {
        if(benchmark != null && benchmark.contains("benchmark")){
            this.benchmark = benchmark;
        }else{
            stampaExAntePost="printIt";  //significa che se non esiste il benchmark deve stampare ExAnte ExPost tempalte parte I
            return;
        }
    }

    public void setAnniBmk(int anniBmk) {
        this.anniBmk = anniBmk;
        //LoggingUtils.debug("annibmk  "+anniBmk);
    }

    public String getUltimoAnnoSolareTrascorso() {
        return ultimoAnnoSolareTrascorso;
    }

    public void setUltimoAnnoSolareTrascorso(String ultimoAnnoSolareTrascorso) {
        this.ultimoAnnoSolareTrascorso = ultimoAnnoSolareTrascorso;
    }

    public List<DatiRendimento> getDatiRendimentos() {
        return datiRendimentos;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        if(null==note||note.trim().equalsIgnoreCase(""))
            return;
        this.note = "NB: "+note;
    }

    public void addDatiRendimentos(String descrizione,String percentuale0, String percentuale, String percentuale2, Isin isin) {

        /* ELIMINATO IN DATA 19Marzo su richiesta di Pietro
           a seguito di incongruenza segnalata via mail il 18Marzo
           //todo verificare se questa condizione è vera, (logicamente valida)
           if(isin.getTipologia().getGestione().trim().equals("flessibile")&&
                (isin.getPolitica().getVariazioniSoggettiIncaricati().trim().equalsIgnoreCase("SI")||
                 isin.getPolitica().getVariazioniPoliticaInvestimento().trim().equalsIgnoreCase("SI")))
            return;    */
        if(null!=percentuale0 && percentuale0.trim().equals(""))
            percentuale0=null;
        if(null!=percentuale  && percentuale.trim().equals(""))
            percentuale=null;
        if(null!=percentuale2 &&percentuale2.trim().equals(""))
            percentuale2=null;
        if(descrizione.equalsIgnoreCase("Benchmark")){
            if(percentuale0!=null && !percentuale0.trim().equalsIgnoreCase(""))
                setAnniBmk(1);
            if(percentuale!=null && !percentuale.trim().equalsIgnoreCase(""))
                setAnniBmk(3);
            if(percentuale2!=null &&!percentuale2.trim().equalsIgnoreCase(""))
                setAnniBmk(5);
            //if(null!=percentuale0||null!=percentuale||null!=percentuale2)
            //benchmark="true";
            //else
            //return;
            //forzo la riconfigurazione delle tabelle riferite al periodo di osservazione
            setPeriodoOssrvazioneBMK();

            if(null==percentuale0&&null==percentuale&&null==percentuale2)
              return;

        }
        if(datiRendimentos==null)
            datiRendimentos=new ArrayList<DatiRendimento>();

        DatiRendimento datiRendimento=new DatiRendimento(descrizione,percentuale0,percentuale, percentuale2);
        this.datiRendimentos.add(datiRendimento);
    }

    public String getPeriodoOsservazione() {
        return periodoOsservazione;
    }

    /**
     * Questo metodo ha lo scopo di rettificare la definizione delle tabelle inerenti il rendimento composto e cioè:   <br>
     * Se il periodo di ossrrvazione è uguale a zero, è cmq possibile che arrivino dei valori inerenti il bmk e allora <br>
     * occorre capire di quanti anni è il periodo di osservazione dei BMK. NB: in base agli anni cambia la struttura   <br>
     * della tabella di stampa
     */
    public void setPeriodoOssrvazioneBMK(){
        if(Integer.decode(periodoOsservazione)==0){
            if(anniBmk==3)
                c=c+1;
            if(anniBmk==5)
                c=c+7;
        }
        setTabelle();
    }
    public void setPeriodoOsservazione(String periodoOsservazione) {
        //LoggingUtils.debug("PERIODO DI OSSERVAZIONE: "+ periodoOsservazione);
        this.periodoOsservazione = periodoOsservazione;
        if(Integer.decode(periodoOsservazione)<5){
            //se è maggiore di 4 non si deve vedere
            c=c+1;
        }

        if(Integer.decode(periodoOsservazione)==3){
            c=c+1;
        }

        if(Integer.decode(periodoOsservazione)>3){
            //todo non vede percentuale
            c=c+3;
        }

        if(Integer.decode(periodoOsservazione)>=5){
            //todo non vede percentuale2
            c=c+5;
        }
        setTabelle();
    }

    public void setPeriodoII(String periodo) {
        colonneRendimento=2;
        this.periodoII = periodo;
    }

    public String getTabella1() {
        return tabella1;
    }

    public String getTabella2() {
        return tabella2;
    }

    public String getTabella3() {
        return tabella3;
    }

    public String getTabella4() {
        return tabella4;
    }

    public class DatiRendimento implements Serializable{
        private String descrizione  =null;    //FIDEURAM FUND MARSHALL WACE TOPS
        private String percentuale0 ="---";      //1,04%
        private String percentuale  ="---";      //1,04%
        private String percentuale2 ="---";      //1,04%




        public DatiRendimento(String descrizione, String percentuale0, String percentuale, String percentuale2) {
            this.descrizione    = descrizione;
            if(percentuale0!=null&&!percentuale0.trim().equals(""))
                this.percentuale0   = numeroFormattatoDueCifreDecimali(percentuale0)+"%";     //identificato con 1
            if(percentuale!=null&&!percentuale.trim().equals(""))
                this.percentuale    = numeroFormattatoDueCifreDecimali(percentuale)+"%";      //identificato con 3
            if(percentuale2!=null&&!percentuale2.trim().equals(""))
                this.percentuale2   = numeroFormattatoDueCifreDecimali(percentuale2)+"%";     //identificato con 5
        }


        private String numeroFormattatoDueCifreDecimali(String percentuale){
        	String result = null;
        	if(percentuale != null && SerigrafiaStringhe.isNumerico(percentuale)){
        		BigDecimal value = new BigDecimal(percentuale.replace(",", ".") );
        		value = value.setScale(2, RoundingMode.HALF_UP);
        		result = value.toString().replace(".", ",");
        	}
        	return result;
        }
        
        
        public String getDescrizione() {
            return descrizione;
        }

        public String getPercentuale0() {
            return percentuale0;
        }

        public String getPercentuale() {
            return percentuale;
        }

        public String getPercentuale2() {
            return percentuale2;
        }

    }

    public String getPeriodoII() {
        return periodoII;
    }

    public int getColonneRendimento() {
        return colonneRendimento;
    }

    public String getVolatilitaUltimoAnnoSolareExAnte() {
        return volatilitaUltimoAnnoSolareExAnte;
    }

    public void setVolatilitaUltimoAnnoSolareExAnte(String volatilitaUltimoAnnoSolareExAnte) {
        if(match.contains(volatilitaUltimoAnnoSolareExAnte.trim().toLowerCase()) || "".equals(volatilitaUltimoAnnoSolareExAnte) || "-".equals(volatilitaUltimoAnnoSolareExAnte.trim()))
           this.volatilitaUltimoAnnoSolareExAnte = volatilitaUltimoAnnoSolareExAnte;
        else{
        	this.volatilitaUltimoAnnoSolareExAnte = volatilitaUltimoAnnoSolareExAnte.replace("%", "");
        	BigDecimal value = new BigDecimal(this.volatilitaUltimoAnnoSolareExAnte.replace(",", "."));
        	value = value.setScale(2, RoundingMode.DOWN);
            this.volatilitaUltimoAnnoSolareExAnte = value.toString().replace(".", ",")+"%";
        }
    }

    public String getVolatilitaUltimoAnnoSolareExPost() {
        return volatilitaUltimoAnnoSolareExPost;
    }

    public void setVolatilitaUltimoAnnoSolareExPost(String volatilitaUltimoAnnoSolareExPost) {
        if(match.contains(volatilitaUltimoAnnoSolareExPost.trim()) || "".equals(volatilitaUltimoAnnoSolareExPost) || "-".equals(volatilitaUltimoAnnoSolareExPost.trim()))
            this.volatilitaUltimoAnnoSolareExPost = volatilitaUltimoAnnoSolareExPost;
        else{
        	this.volatilitaUltimoAnnoSolareExPost = volatilitaUltimoAnnoSolareExPost.replace("%", "");
        	BigDecimal value = new BigDecimal(this.volatilitaUltimoAnnoSolareExPost.replace(",", "."));
        	value = value.setScale(2, RoundingMode.DOWN);
            this.volatilitaUltimoAnnoSolareExPost = value.toString().replace(".", ",")+"%";
        }
    }


    private void resetTabelle(){
        tabella1=null;
        tabella2=null;
        tabella3=null;
        tabella4=null;
    }

    private void setTabelle(){
        resetTabelle();
        if(c==8)
            tabella1="t";        //3+5
        if(c==4)
            tabella2="t";        //avvio+3
        if(c==1)
            tabella3="t";        //avvio
        if(c==2)
            tabella4="t";        //ultimi 3 anni
    }
}
