package com.fideuram.modello.selection;

import com.fideuram.costanti.Frasi;
import com.fideuram.modello.anagrafe.Gestore;
import com.fideuram.modello.anagrafe.SocietaRevisione;
import com.fideuram.modello.anagrafe.SoggettoDelegato;
import com.fideuram.modello.chart.BarraBean;
import com.fideuram.modello.chart.LineaTimeBean;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.SerigrafiaStringhe;

import fr.opensagres.xdocreport.document.images.IImageProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 06/06/12
 * Time: 14.21
 */
public class Isin implements Serializable {
    private int prodotto;
    private String                          codiceImpresa;                              //FF002
    private String                          codiceIsin;                                 //LU0139057037
    private String                          denominazioneCompletaComparto;              //FIDEURAM FUND MARSHALL WACE TOPS
    private Rendimento                      rendimento;
    private List<Ter>                       ters;                                       //uno per anno solare 2009 2010 2011
    private BarraBean                       barraGraph;
    private List<LineaTimeBean>             lineaGraph;

    //todo add lineaBean

    //ALTRI DATI
    private String                          dataIniziOperativita                  ="n.d.";//15/10/2009
    private String                          durataComparto                        ="n.d.";//n.d.
    private String                          classeQuota                           ="";
    private String                          dataAvvioClasseQuota                  ="---";
    private String                          valutaPatrimonioNetto                 ="";
    private String                          patrimonioNetto31DicAnnoPrecedente    ="n.d.";//€ 168.832.602,36
    private String                          valutaValoreQuota                     ="";
    private String                          valoreQuota31DicAnnoPrecedente        ="n.d.";//  10,42
    private String                          sitoPubblicazioneNav                  ="n.d.";
    private String                          principaliIntermediariNegoziatori     ="n.d.";
    private String 							formaOrganizzativaComparto			  ="";
    private String 							commGestMaxIndOICR					  ="---";
	private String 							commIncentMaxIndOICR		          ="---";
    
    private Tipologia                       tipologia;
    private Politica                        politica;
    private Benchmark                       benchmark;
    private Gestore                         gestore;
    private SocietaRevisione				societaRevisione;
   
	private SoggettoDelegato                soggettoDelegataGestione;                    //FIDEURAM ASSET MANAGEMENT IRELAND (LIMITED)

    private String altroCommGestione="---";
    private String altroCommIncentivo="---";
    private String altroCommGestioneIndiretta="---";
    private String altroCommIncentivoIndiretta="---";
    private String fraseGrafici="";
    private String intestazioneGrafico1="";
    private String stampaGrafico="SI";
    private int suc=0;
    private List<String> match = Arrays.asList( "n.d.","nd","n.d","nd.","n.a.","na","n.a","na.", "N.D.","ND","N.D","ND.","N.A.","NA","N.A","NA.");
    private List<String> matchNa = Arrays.asList( "n.a.","na","n.a","na.", "N.A.","NA","N.A","NA.");
    
    public boolean isGrafico() {
    	if("SI".equals(stampaGrafico)){
    		return true;
    	}
		return false;
	}


	public void setIntestazioneGrafico1(String intestazioneGrafico1) {
		this.intestazioneGrafico1 = intestazioneGrafico1;
	}




	private String notaDiModifica="";


    private String noteTer;
    private String testoTer;
    private String noteAltreInfo;
    private String testoAltreInfo;
    private String notePeriodoOsservazione;
    private String notaAnnoPrecedente;
    private boolean isFondoInterno;
    private boolean propostaInvestimento;
    private boolean oldCostituzione;
    private boolean notBenchmark;
    private String voceAltriOneri;
    private String headerFondo;
    private boolean isFacile = false;
    private String classeQuotaPersonalizzata = "";
    private String classeQuotaTerzoAll = "";
    private String annoPrecedente;
    private String anniPrecedenti2;
    private String testoTurnover;
    

	public boolean isPresenzaClasseQuota() {
		if(classeQuota == null || "".equals(classeQuota) || "---".equals(classeQuota)){
			return false;
		}
		return true;
	}

	public boolean isPresenzaSoggettoDelegato() {
		if("---".equals(soggettoDelegataGestione.getDenominazione()) || "---".equals(soggettoDelegataGestione.getGruppo()) ||
				"---".equals(soggettoDelegataGestione.getNazionalita()) || "---".equals(soggettoDelegataGestione.getSedeLegale())){
			return false;
		}
		return true;
	}

	public boolean hasTestoTurnover(){
        if("".equals(getTestoTurnover().trim()))
            return false;
        return true;
    }
    

    public void setTestoTurnover(String testoTurnover) {
		this.testoTurnover = testoTurnover;
	}


	public String getTestoTurnover() {
        if(testoTurnover==null)
            return "";
        return testoTurnover;
    }
    public String getClasseQuotaTerzoAll() {
		return classeQuotaTerzoAll;
	}

	public void setClasseQuotaTerzoAll(String classeQuotaTerzoAll) {
		if(classeQuotaTerzoAll == null || "".equals(classeQuotaTerzoAll))
			return;
		this.classeQuotaTerzoAll = classeQuotaTerzoAll;
	}
	public String getClasseQuotaPersonalizzata() {
		return classeQuotaPersonalizzata;
	}

	public void setClasseQuotaPersonalizzata(String classeQuotaPersonalizzata) {
		this.classeQuotaPersonalizzata = classeQuotaPersonalizzata;
	}
    
    
    public boolean isFondoInterno() {
		return isFondoInterno;
	}

	public String getAnnoPrecedente() {
		return annoPrecedente;
	}

	public void setAnnoPrecedente(String annoPrecedente) {
		this.annoPrecedente = annoPrecedente;
	}

	public String getAnniPrecedenti2() {
		return anniPrecedenti2;
	}

	public void setAnniPrecedenti2(String anniPrecedenti2) {
		this.anniPrecedenti2 = anniPrecedenti2;
	}

	public String getCommGestMaxIndOICR() {
		return commGestMaxIndOICR;
	}

	public void setCommGestMaxIndOICR(String commGestMaxIndOICR) {
		if(commGestMaxIndOICR != null && !"".equals(commGestMaxIndOICR) && !match.contains(commGestMaxIndOICR)){
			this.commGestMaxIndOICR = commGestMaxIndOICR + "%";
		}
	}

	public String getCommIncentMaxIndOICR() {
		return commIncentMaxIndOICR;
	}

	public void setCommIncentMaxIndOICR(String commIncentMaxIndOICR) {
		if(commIncentMaxIndOICR != null && !"".equals(commIncentMaxIndOICR) && !match.contains(commIncentMaxIndOICR)){
			this.commIncentMaxIndOICR = commIncentMaxIndOICR + "%";
		}
	}

	public String getFormaOrganizzativaComparto() {
		if(formaOrganizzativaComparto == null){
			formaOrganizzativaComparto = "";
		}
		return formaOrganizzativaComparto;
	}

	public void setFormaOrganizzativaComparto(String formaOrganizzativaComparto) {
		this.formaOrganizzativaComparto = formaOrganizzativaComparto;
	}

	public SocietaRevisione getSocietaRevisione() {
		return societaRevisione;
	}

	public void setSocietaRevisione(SocietaRevisione societaRevisione) {
		this.societaRevisione = societaRevisione;
	}

	public boolean isFacile() {
		return isFacile;
	}

	public void setFacile(boolean isFacile) {
		this.isFacile = isFacile;
	}
    

    public String getHeaderFondo() {
    	if(headerFondo == null){
    		headerFondo = codiceImpresa;
    	}
		return headerFondo;
	}

	public void setHeaderFondo(String headerFondo) {
		this.headerFondo = headerFondo;
	}

    public void setProdotto(int prodotto) {
        this.prodotto = prodotto;
    }

    public boolean isPropostaInvestimento() {
        return propostaInvestimento;
    }

    public void setPropostaInvestimento(boolean propostaInvestimento) {
        this.propostaInvestimento = propostaInvestimento;
    }

    public String getTipoIsin(){
        if(isPropostaInvestimento())
            return "Proposta";
        if(isFondoInterno)
            return "Fondo";
        else
            return "OICR";
    }

    public String getFondoComparto(){
        if(propostaInvestimento)
            switch (prodotto){
                case 55:
                    return "";
                default:
                    return "linea";
            }
        if(isFondoInterno)
            return "fondo";
        else
            return "comparto";
    }

    public String getDelTipoIsinUpper(){
        if(isPropostaInvestimento())
            return "DELLA LINEA DI INVESTIMENTO/COMBINAZIONE LIBERA";
        if(isFondoInterno)
            return "DEL FONDO INTERNO";
        else
            return "DELL'OICR";
    }

    public String getVoceAltriOneri() {
        if(null==voceAltriOneri)
            return "";

        Double d1=getTers().get(0).getAltriOneriCleaned();
        Double d2=getTers().get(1).getAltriOneriCleaned();
        Double d3=getTers().get(2).getAltriOneriCleaned();



        if((d1>0 || d2>0 || d3>0 || d1<0 || d2<0 || d3<0)){
            return "("+voceAltriOneri+")";
        }else {
            LoggingUtils.info("ALTRI ONERI A ZERO X ASINO = " + this.getCodiceIsin());
            return "";
        }
    }

    public void setVoceAltriOneri(String voceAltriOneri) {
        this.voceAltriOneri = voceAltriOneri;
    }

    public boolean isOldCostituzione() {
        return oldCostituzione;
    }

    public void setOldCostituzione(boolean oldCostituzione) {
        this.oldCostituzione = oldCostituzione;
    }

    public boolean isNotBenchmark() {
        return notBenchmark;
    }

    public void setNotBenchmark(boolean notBenchmark) {
        this.notBenchmark = notBenchmark;
    }

    //mi serve solamente per gestire l'eccezione non prevista dei casi in cui il fondo ha periodo osservazione zero
    //ma pure i dati di bmk
    //todo verificare se questa eccezione va allargata pure ai fondi esterni
    public void setFondoInterno(boolean fondoInterno) {
        isFondoInterno = fondoInterno;
    }

    public boolean isFondoVecchio(){
       if(getStampaGrafico().equalsIgnoreCase("SI"))
           return true;
       return false;

    }

    public boolean hasNotePeriodoOsservazione(){
        if("".equals(getNotePeriodoOsservazione().trim()))
            return false;
        return true;
    }

    public String getNotePeriodoOsservazione() {
        return notePeriodoOsservazione!=null?notePeriodoOsservazione:"";
    }

    public boolean hasNotaAnnoPrecedente(){
        if("".equals(getNotaAnnoPrecedente().trim()))
            return false;
        return true;
    }

    public String getNotaAnnoPrecedente() {
        if(null==notaAnnoPrecedente)
            return "";
        return notaAnnoPrecedente;
    }

    public String getNotaDiModifica() {
        return notaDiModifica;
    }

    public boolean hasNoteTer(){
        if("".equals(getNoteTer().trim()))
            return false;
        LoggingUtils.info("LOOOCKK HAS NOTE TER :" +getNoteTer() + this.getCodiceImpresa());
        return true;
    }

    public String getNoteTer() {
        if(noteTer==null)
            return "";
        return noteTer;
    }

    public boolean hasTestoTer(){
        if("".equals(getTestoTer().trim()))
            return false;
        return true;
    }

    public String getTestoTer() {
        if(testoTer==null)
            return "";
        return testoTer;
    }

    public boolean hasNoteAltreInfo(){
        if("".equals(getNoteAltreInfo().trim()))
          return false;
        return true;
    }

    public String getNoteAltreInfo() {
        if(noteAltreInfo==null)
            return "";
        return noteAltreInfo;
    }

    public boolean hasTestoAltreInfo(){
        if("".equals(getTestoAltreInfo().trim()))
            return false;
        return true;
    }

    public String getTestoAltreInfo() {
        if(testoAltreInfo==null)
            return "";
        return testoAltreInfo;
    }

    public void setNoteTer(String noteTer) {
        this.noteTer = noteTer;
    }

    public void setTestoTer(String testoTer) {
        this.testoTer = testoTer;
    }

    public void setNoteAltreInfo(String noteAltreInfo) {
        this.noteAltreInfo = noteAltreInfo;
    }

    public void setNotePeriodoOsservazione(String notePeriodoOsservazione) {
        this.notePeriodoOsservazione = notePeriodoOsservazione;
    }

    public void setNotaAnnoPrecedente(String notaAnnoPrecedente) {
        this.notaAnnoPrecedente = notaAnnoPrecedente;
    }

    public void setTestoAltreInfo(String testoAltreInfo) {
        this.testoAltreInfo = testoAltreInfo;
    }

    public void setNotaDiModifica(String notaDiModifica) {
        this.notaDiModifica = notaDiModifica;
    }

    public String getAltroCommGestione() {
        /*if(altroCommGestione==null||altroCommGestione.equals(""))
            return "---";*/
        return altroCommGestione;
    }

    public void setAltroCommGestione(String altroCommGestione) {
        if(null==altroCommGestione||altroCommGestione.trim().equals(""))
            return;
        if(!altroCommGestione.contains("%"))
            altroCommGestione=altroCommGestione+"%";
        this.altroCommGestione = altroCommGestione;
    }

    public String getAltroCommIncentivo() {
        if(matchNa.contains(altroCommIncentivo)||altroCommIncentivo.equalsIgnoreCase("0")||altroCommIncentivo.equalsIgnoreCase("0,00")||altroCommIncentivo.equalsIgnoreCase("0.00") ||
        		altroCommIncentivo.equalsIgnoreCase("0.00%") || altroCommIncentivo.equalsIgnoreCase("0,00%"))
            return "---";
        return altroCommIncentivo;
    }

    public void setAltroCommIncentivo(String altroCommIncentivo) {
        if(null==altroCommIncentivo||altroCommIncentivo.trim().equals(""))
            return;
        this.altroCommIncentivo = altroCommIncentivo;
    }
    
    public String getAltroCommIncentivoIndiretta() {
        if(matchNa.contains(altroCommIncentivoIndiretta)||altroCommIncentivoIndiretta.equalsIgnoreCase("0")||altroCommIncentivoIndiretta.equalsIgnoreCase("0,00")||altroCommIncentivoIndiretta.equalsIgnoreCase("0.00") ||
        		altroCommIncentivoIndiretta.equalsIgnoreCase("0.00%") || altroCommIncentivoIndiretta.equalsIgnoreCase("0,00%"))
            return "---";
        return altroCommIncentivoIndiretta.contains("%")  || "---".equals(altroCommIncentivoIndiretta) || altroCommIncentivoIndiretta.contains("n")? altroCommIncentivoIndiretta : altroCommIncentivoIndiretta + "%";
    }

    public void setAltroCommIncentivoIndiretta(String altroCommIncentivo) {
        if(null==altroCommIncentivo||altroCommIncentivo.trim().equals(""))
            return;
        this.altroCommIncentivoIndiretta = altroCommIncentivo;
    }
    
    public String getAltroCommGestioneIndiretta() {
        if(matchNa.contains(altroCommGestioneIndiretta)||altroCommGestioneIndiretta.equalsIgnoreCase("0")||altroCommGestioneIndiretta.equalsIgnoreCase("0,00")||altroCommGestioneIndiretta.equalsIgnoreCase("0.00") ||
        		altroCommGestioneIndiretta.equalsIgnoreCase("0.00%") || altroCommGestioneIndiretta.equalsIgnoreCase("0,00%"))
            return "---";
        return altroCommGestioneIndiretta.contains("%") || "---".equals(altroCommGestioneIndiretta) || altroCommGestioneIndiretta.contains("n")? altroCommGestioneIndiretta : altroCommGestioneIndiretta + "%";
    }

    public void setAltroCommGestioneIndiretta(String altroCommIncentivo) {
        if(null==altroCommIncentivo||altroCommIncentivo.trim().equals(""))
            return;
        this.altroCommGestioneIndiretta = altroCommIncentivo;
    }

    public String getClasseQuota() {
         /*
         Data       : 10-04-2014
         Richiedente: Pietro
         Oggetto    : FvPrivate

         Se manca classe quota visualizzare "---"
         */

         /*
         Data       : 19-06-2014
         Richiedente: Pietro
         Oggetto    : tutti i prospetti
         Ribadisce che NON si devono vedere i trattini
         */

         /*
         Data       : 22-08-2014
         Richiedente: Antonella Paratore
         Oggetto    : tutti i prospetti
         Ribadisce che SI devono vedere i trattini
         */

         /*
         Data       : 02-09-2014
         Richiedente: Pietro
         Oggetto    : tutti i prospetti
         Ribadisce che NON si devono vedere i trattini
         */

        /*
         Data       : 18-09-2014
         Richiedente: Pietro
         Oggetto    : supplementi sintetici
         Ribadisce che SI devono vedere i trattini
         */

        /*
         Data   04Feb2015: Accordo
         Sui sintetici "---"
         sugli altri   "   "
        */

        //return !classeQuota.trim().equals("")?classeQuota:"---";

        //return classeQuota;

        return isPropostaInvestimento()?"proposta "+getCleanedClasseQuota():"classe di quota "+getCleanedClasseQuota();


    }

    public String getCleanedClasseQuota(){
        //return isClasseEmpty()?"---":classeQuota;
        //return isClasseEmpty()?"---":classeQuota;
        return classeQuota;
    }

    public boolean isClasseEmpty(){
        return classeQuota.trim().equals("")?true:false;
    }

    public void setClasseQuota(String classeQuota) {
        if(null==classeQuota||classeQuota.trim().equalsIgnoreCase(""))
            return;
        this.classeQuota = classeQuota;
    }

    public String getDataAvvioClasseQuota() {
        return dataAvvioClasseQuota;
    }

    public void setDataAvvioClasseQuota(String dataAvvioClasseQuota) {
        if(null==dataAvvioClasseQuota||dataAvvioClasseQuota.trim().equalsIgnoreCase(""))
            return;
        this.dataAvvioClasseQuota = dataAvvioClasseQuota;
    }

    public String getPrincipaliIntermediariNegoziatori() {
        return principaliIntermediariNegoziatori;
    }

    public void setPrincipaliIntermediariNegoziatori(String principaliIntermediariNegoziatori) {
        if(principaliIntermediariNegoziatori.trim().equals(""))
            return;
        this.principaliIntermediariNegoziatori = principaliIntermediariNegoziatori;
    }

    public String getSitoPubblicazioneNav() {
        if(sitoPubblicazioneNav==null||sitoPubblicazioneNav.equals(""))
            return "---";
        return sitoPubblicazioneNav;
    }

    public void setSitoPubblicazioneNav(String sitoPubblicazioneNav) {
        if(sitoPubblicazioneNav.contains("http")){
            this.sitoPubblicazioneNav = sitoPubblicazioneNav.replace("http://","");
        }else{
            this.sitoPubblicazioneNav = sitoPubblicazioneNav;
        }

    }

    public String getCodiceIsin() {
        LoggingUtils.info("get codice ISIN: "+codiceIsin+ "   PER "+ codiceImpresa);
        return codiceIsin;
    }

    public void setCodiceIsin(String codiceIsin) {
        this.codiceIsin = codiceIsin;
    }

    public String getDenominazioneCompletaComparto() {
        return denominazioneCompletaComparto;
    }

    public void setDenominazioneCompletaComparto(String nome) {
        this.denominazioneCompletaComparto = nome;
    }

    public Rendimento getRendimento() {
        return rendimento;
    }

    public void setRendimento(Rendimento rendimento) {
        this.rendimento = rendimento;
    }

    public List<Ter> getTers() {
        return ters;
    }

    public void setTers(List<Ter> ters) {
        this.ters = ters;
    }

    public void addTers(Ter rap) {
        if(ters ==null)
            ters =new ArrayList<Ter>();
        this.ters.add(rap);
    }

    public boolean notLinea(){
        LoggingUtils.info("interrogo notLinea");
        switch (prodotto){
            case 55:
                return isPropostaInvestimento()?true:false;
            default:
                return false;
        }
    }
    public String getDataIniziOperativita() {
        switch (prodotto){
            case 55:
                return isPropostaInvestimento()?"":dataIniziOperativita;
            default:
                return dataIniziOperativita;
        }
    }

    public void setDataIniziOperativita(String dataIniziOperativita) {
        this.dataIniziOperativita = dataIniziOperativita;
    }

    public String getDurataComparto() {
        return durataComparto;
    }

    public void setDurataComparto(String durataComparto) {
        if(durataComparto==null||durataComparto.equals("---"))
            return;
        this.durataComparto = durataComparto;
    }

    public String getValutaPatrimonioNetto() {
        return valutaPatrimonioNetto!=null?valutaPatrimonioNetto:"";
    }

    public void setValutaPatrimonioNetto(String valutaPatrimonioNetto) {
        this.valutaPatrimonioNetto = valutaPatrimonioNetto;
    }

    public String getPatrimonioNetto31DicAnnoPrecedente() {
        return SerigrafiaStringhe.isNumerico(patrimonioNetto31DicAnnoPrecedente)==true && !patrimonioNetto31DicAnnoPrecedente.contains("\u20AC")?"\u20AC "+patrimonioNetto31DicAnnoPrecedente:patrimonioNetto31DicAnnoPrecedente;
    }

    public void setPatrimonioNetto31DicAnnoPrecedente(String patrimonioNetto31DicAnnoPrecedente) {
        if(null==patrimonioNetto31DicAnnoPrecedente||patrimonioNetto31DicAnnoPrecedente.trim().equals(""))
            return;
        this.patrimonioNetto31DicAnnoPrecedente = patrimonioNetto31DicAnnoPrecedente;
    }

    public String getValutaValoreQuota() {
        return valutaValoreQuota!=null?valutaValoreQuota:"";
    }

    public void setValutaValoreQuota(String valutaValoreQuota) {
        this.valutaValoreQuota = valutaValoreQuota;
    }

    public String getValoreQuota31DicAnnoPrecedente() {
    	if(SerigrafiaStringhe.isNumerico(valoreQuota31DicAnnoPrecedente)==true && !valoreQuota31DicAnnoPrecedente.contains("\u20AC")){
    		return "\u20AC "+valoreQuota31DicAnnoPrecedente;
    	}else if(!SerigrafiaStringhe.isNumerico(valoreQuota31DicAnnoPrecedente) && valoreQuota31DicAnnoPrecedente.contains("\u20AC"))
    		return valoreQuota31DicAnnoPrecedente.replace("\u20AC", "");
    	else
    		return valoreQuota31DicAnnoPrecedente;
    }

    public void setValoreQuota31DicAnnoPrecedente(String valoreQuota31DicAnnoPrecedente) {
        if(null==valoreQuota31DicAnnoPrecedente||valoreQuota31DicAnnoPrecedente.trim().equals(""))
            return;
        this.valoreQuota31DicAnnoPrecedente = valoreQuota31DicAnnoPrecedente;
    }

    public SoggettoDelegato getSoggettoDelegataGestione() {
        return soggettoDelegataGestione;
    }

    public void setSoggettoDelegataGestione(SoggettoDelegato soggettoDelegataGestione) {
        this.soggettoDelegataGestione = soggettoDelegataGestione;
    }


    public List<LineaTimeBean> getLineaGraph() {
        return lineaGraph;
    }

    public void addLineaGraph(LineaTimeBean lineaGraph) {
        if(this.lineaGraph==null)
            this.lineaGraph=new ArrayList<LineaTimeBean>();
        this.lineaGraph.add(lineaGraph);
    }

    public void setBarraGraph(BarraBean barraGraph) {
        this.barraGraph = barraGraph;
    }

    public BarraBean getBarraGraph() {
        return barraGraph;
    }



    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public Politica getPolitica() {
        return politica;
    }

    public void setPolitica(Politica politica) {
        this.politica = politica;
    }

    public Benchmark getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    public Gestore getGestore() {
        return gestore;
    }

    public void setGestore(Gestore gestore) {
        this.gestore = gestore;
    }

    public String getCodiceImpresa() {
        LoggingUtils.info(codiceImpresa);
        return codiceImpresa;
    }

    public void setCodiceImpresa(String codiceImpresa) {
        this.codiceImpresa = codiceImpresa;
    }




    private IImageProvider barra;
    private IImageProvider linea;
    private IImageProvider cloneDiLinea;
    private String clone="SI";
    private IImageProvider linea2;

    public String getClone() {
        return clone;
    }

    public Boolean isLinea(){
        if(null!=linea)
            return true;
        else
            return false;
    }

    public IImageProvider getLinea() {
        return linea;
    }

    public void setLinea(IImageProvider linea) {
        this.linea = linea;
        this.cloneDiLinea= this.linea;
    }

    public IImageProvider getCloneDiLinea() {
        return cloneDiLinea;
    }


    public Boolean istLinea2(){
        if(null!=linea2)
            return true;
        else
            return false;
    }

    public IImageProvider getLinea2() {
        return linea2;
    }

    public void setLinea2(IImageProvider linea) {
        if(suc==1){
          return;
        }
        this.linea2 = linea;
        this.clone="NO";
    }

    /**
     * @param barra
     */
    public void setBarra(IImageProvider barra) {
        this.barra = barra;
    }

    public IImageProvider getBarra() {
        return barra;
    }
    
    public void configuraGrafici(){
        suc=getSUC();
//        setFrase(suc);
    }

    public void configuraFraseGrafici(){
        setFrase(suc);
    }

    /**
     * Questo metodo restituisce il sottocaso per la stampa dei grafici
     * @return
     */
    private int getSUC(){
        boolean varPolitica=false;
        boolean varSoggetti=false;
        boolean benchmark=false;
        int periodo=Integer.decode(rendimento.getPeriodoOsservazione());

        switch (periodo){
            case 0:
                suc=1;
                if (politica.getVariazioniPoliticaInvestimento().equalsIgnoreCase("SI"))
                    varPolitica=true;
                if (politica.getVariazioniSoggettiIncaricati().equalsIgnoreCase("SI"))
                    varSoggetti=true;
                //if (getBarraGraph()!=null&&getBarraGraph().isBmk())
                if (!this.isNotBenchmark())
                    benchmark=true;
                if(varPolitica&&!benchmark)
                    suc=2;
                if(varPolitica&&benchmark)
                    suc=3;
                if(varSoggetti&&!benchmark)
                    suc=4;
                if(varSoggetti&&benchmark)
                    suc=5;
                if(varPolitica&&varSoggetti&&!benchmark)
                    suc=6;
                if(varPolitica&&varSoggetti&&benchmark)
                    suc=7;
                //else if(benchmark&&isFondoInterno&&rendimento.getPeriodoOsservazione().equals("0"))
                else if(benchmark&&rendimento.getPeriodoOsservazione().equals("0")&&rendimento.hasGraficoDiBenchmark())
                    suc=0; //eccezione ai tutti i casi precedenti per cui non si ha oicr ma arrivano comunque ossrvazioni sui bmk. Quindi andremo a calcolareil periodo di osservazione dei bmk in anni. SE SI PUò!!!

                //TODO MODIFICA COMMENTATA IL 10 SETTEMBRE 2014
                //ANOMALIA: STAMPA IL GRAFICO DEGLI ISIN DI CODICE IMPRESA(MS010 E MS011)
                //          ANKE SE NON HANNO VALORI DI BMK
                //SOLUZIONE:Aggiunto if(....&&rendimento.hasGraficoDiBenchmark())
                //NOTE:     IN passato funzionava xkè controllavamo isFondoInterno per cui non sarebbe in caso entrato.
                else if(benchmark&&rendimento.hasGraficoDiBenchmark())
                   suc=8;   // CASO NUOVO arrivato con i fondi interni

                break;
            default:
                if(periodo==1){
                   suc=8;
                }else if(periodo > 1){
                   suc=9;
                }
               break;
        }

        switch (suc){
            case 1:
                stampaGrafico="NO";              //no grafici
                break;
            case 2:
                stampaGrafico="NO";              //no grafici
                break;
            case 4:
                stampaGrafico="NO";              //no grafici
                break;
            case 6:
                stampaGrafico="NO";              //no grafici
                break;
            default:
                stampaGrafico="SI";              //no grafici

        }
        return suc;
    }

    private void setFrase(int suc)  {

      switch (suc){
          case 0:
              int x=calcolaAnniBMK();
              if(x==1)
               intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.8");
              else if(x>1)
               intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.9")+" "+x+" anni solari";
              break;
          case 1:
              fraseGrafici = Frasi.getFrase("grafici.suc.1");
              //stampaGrafico="NO";              //no grafici
              break;
          case 2:
              fraseGrafici = Frasi.getFrase("grafici.suc.2");
              //stampaGrafico="NO";              //no grafici
              break;
          case 3:
              if(rendimento.getPeriodoOsservazione().equals("0")){
                  intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.9")+" "+calcolaAnniBMK()+" anni solari";
              }else{
                  intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.8");
              }
              fraseGrafici = Frasi.getFrase("grafici.suc.3");
              break;
          case 4:
              fraseGrafici = Frasi.getFrase("grafici.suc.4");
              //stampaGrafico="NO";              //no grafici
              break;
          case 5:
              intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.8");
              //intestazioneGrafico2 = Frasi.getFrase("grafico2.suc.8");
              fraseGrafici = Frasi.getFrase("grafici.suc.5");
              break;
          case 6:
              fraseGrafici = Frasi.getFrase("grafici.suc.6");
              //stampaGrafico="NO";              //no grafici
              break;
          case 7:
              //TODO VERIFICARE QUÌ   IN DEBUG
//        	  if(rendimento.getPeriodoOsservazione().equals("0")){
                  intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.9")+" "+calcolaAnniBMK()+" anni solari";
//              }else{
//              intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.7");
//              }
              fraseGrafici = Frasi.getFrase("grafici.suc.7");
              break;
          case 8:
              intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.8");
              //intestazioneGrafico2 = Frasi.getFrase("grafico2.suc.8");
              break;
          case 9:
              intestazioneGrafico1 = Frasi.getFrase("grafico1.suc.9")+" "+Integer.decode(rendimento.getPeriodoOsservazione())+" anni solari";
              //intestazioneGrafico2 = Frasi.getFrase("grafico2.suc.8");
              break;
      }
    }

    private int calcolaAnniBMK(){
    	 int x=0;
    	 if(barraGraph.getBarre() != null ){
        int barrebmk=this.barraGraph.getBarre().getBarre().size();
        // il ns periodo di osservazione
        List<String> anni = new ArrayList<String>();
       
	        for(int i=0; i<barrebmk;i++){
	            if(this.barraGraph.getBarre().getBarre().get(i).getValore()!=0.00){
	            	if(!anni.contains(this.barraGraph.getBarre().getBarre().get(i).getAnno())){
	            		x++;
	            	}
	            	anni.add(this.barraGraph.getBarre().getBarre().get(i).getAnno());
	            }
	        }
        }
        return x;
    }

    public String getFraseGrafici() {
        return fraseGrafici;
    }
    public void setFraseGrafici(String fraseGrafici) {
        this.fraseGrafici = fraseGrafici;
    }

    public String getStampaGrafico() {
        return stampaGrafico;
    }

    public String getIntestazioneGrafico1() {
        return intestazioneGrafico1;
    }
}
