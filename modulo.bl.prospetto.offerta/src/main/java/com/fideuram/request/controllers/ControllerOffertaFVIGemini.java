package com.fideuram.request.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.chart.BarraBean;
import com.fideuram.modello.selection.Fundhouse;
import com.fideuram.modello.selection.Isin;
import com.fideuram.modello.selection.Rendimento;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.modello.selection.Ter;
import com.fideuram.processo.prospetti.FVInsiemeGemini;
import com.fideuram.processo.prospetti.GeneratoreBase;

/**
 * Created by
 * User: cmollica
 *
 */
public class ControllerOffertaFVIGemini extends ControllerOffertaBase {
	
	List<String> anni = new ArrayList<String>();
	private List<String> na = Arrays.asList("n.a.", "na", "n.a", "na.", "N.A.", "NA", "N.A", "NA.");
	private List<String> nd = Arrays.asList("n.d.", "nd", "n.d", "nd.", "N.D.", "ND", "N.D", "ND.");
	private final String NON_PREVISTA = "Non prevista";
	private final String NON_DISPONIBILE = "Informazione non disponibile";

    /**
     * Genera il fascicolo informativo
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException{
    	PubblicazioneConsob p = loadDati(64);
    	p = setDatiGrafico(p);
    	p.setNomeProdotto("Fideuram Vita Gemini");
    	p.setGemini(true);
    	GeneratoreBase generatoreFVInsiemeGemini= new FVInsiemeGemini(dir);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        byte[] sintesi = stampaParteX(p, 7, generatoreFVInsiemeGemini);
        sintesi = addPiedino(sintesi,"FVGemini-NotaInformativa.pdf", true);
        pdfs.add(sintesi);

        sendPDFListToPuc(pdfs, 64);
        clearTempDirectory(dir);
        return pdfs;
    }

    public List<byte[]> avviaProcessoSintesi() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(64);
        p = setFlagPrimoFondoEsterno(p);
        p.setNomeProdotto("Fideuram Vita Gemini");
        p.setGemini(true);
        GeneratoreBase generatoreFVInsiemeGemini= new FVInsiemeGemini(dir);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        byte[] sintesi = stampaParteX(p, 6, generatoreFVInsiemeGemini);
        sintesi = addPiedino(sintesi,"FVGemini-SchedaSintetica.pdf", true);
        pdfs.add(sintesi);

        sendPDFListToPuc(pdfs, 64);
        clearTempDirectory(dir);
        return pdfs;
    }
    
    
    public List<byte[]> avviaProcessoAddendum() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(642);
        p = setFlagPrimoFondoEsterno(p);
        p = setDatiGrafico(p);
        p.setNomeProdotto("Fideuram Vita Gemini");
        p.setGemini(true);
        GeneratoreBase generatoreFVInsiemeGemini= new FVInsiemeGemini(dir);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        byte[] sintesi = stampaParteX(p, 8, generatoreFVInsiemeGemini);
        sintesi = addPiedino(sintesi,"FVGemini-Addendum.pdf", false);
        pdfs.add(sintesi);

        sendPDFListToPuc(pdfs, 64);
        clearTempDirectory(dir);
        return pdfs;
    }
    
    public List<byte[]> avviaProcessoRendiconto() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(641);
        p = setFlagPrimoFondoEsterno(p);
    	p = setDatiGrafico(p);
        p.setNomeProdotto("Fideuram Vita Gemini");
        Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
        p.setAnnoRendiconto(year -1 + "");
        p.setGemini(true);
        GeneratoreBase generatoreFVInsiemeGemini= new FVInsiemeGemini(dir);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        byte[] rendiconto = stampaParteX(p, 5, generatoreFVInsiemeGemini);
        rendiconto = addPiedino(rendiconto,"FVGemini-Rendiconto.pdf", true);
        pdfs.add(rendiconto);

        sendPDFListToPuc(pdfs, 64);
        clearTempDirectory(dir);
        return pdfs;
    }
    
    
    private void setAnni(List<Barra> listBarre){
    	Integer annoMax = 0;
    	for(Barra b : listBarre){
    		annoMax = new Integer(b.getAnno()) > annoMax ? new Integer(b.getAnno()): annoMax;
    	}
		for(int i = 0 ; i <5; i++){
			anni.add(annoMax-i + "");
		}
    }
    
    
    private PubblicazioneConsob setFlagPrimoFondoEsterno(PubblicazioneConsob p){
    	List<SelectionFund> selectionFunds = p.getSelectionFunds();
    	int i = 0;
    	for(SelectionFund selection : selectionFunds){
    		selection.setPrimoFondoEsterno(!selection.getFondoInterno() && i ==1);
    		i++;
    	}
    	return p;
    }
    
    private PubblicazioneConsob setDatiGrafico(PubblicazioneConsob p){
    	List<SelectionFund> selectionFunds = p.getSelectionFunds();
    	int i = 0;
    	for(SelectionFund selection : selectionFunds){
    		List<Fundhouse> fundhouses = selection.getFundhouses();
    		
    		selection.setPrimoFondoEsterno(!selection.getFondoInterno() && i ==1);
    		for(Fundhouse fund : fundhouses){
    				List<Isin> isins = fund.getIsins();
    				List<Isin> isinsList = new ArrayList<Isin>();
    				for(Isin isin : isins){
    					isin  = setMessaggiFondo(isin);
    					valorizzaTassoInflazioneMedio(isin.getRendimento(),p);
    					List<Ter> ters = isin.getTers();
    					for(Ter t : ters){
    						if(t.getTer() != null && !"---".equals(t.getTer())&&  !"".equals(t.getTer())&&  !nd.contains(t.getTer()) && 
    								!na.contains(t.getTer())){
    							t.setTer(FormatterFactory.getStandardPercentuale(new Double(t.getTer().replace("%", "").replace(",", "."))));
    						}
    						if(t.getOneriDismissioneAttivita() != null && !"---".equals(t.getOneriDismissioneAttivita())&&  !"".equals(t.getOneriDismissioneAttivita()) &&  !nd.contains(t.getOneriDismissioneAttivita())){
    							t.setOneriDismissioneAttivita(FormatterFactory.getStandardPercentuale(new Double(t.getOneriDismissioneAttivita().replace("%", "").replace(",", "."))));
    						}
    						if(t.getSpeseAmministrazioneCustodia() != null && !"---".equals(t.getSpeseAmministrazioneCustodia())&&  !"".equals(t.getSpeseAmministrazioneCustodia())&&  !nd.contains(t.getSpeseAmministrazioneCustodia()) &&
    								!na.contains(t.getSpeseAmministrazioneCustodia())){
    							t.setSpeseAmministrazioneCustodia(FormatterFactory.getStandardPercentuale(new Double(t.getSpeseAmministrazioneCustodia().replace("%", "").replace(",", "."))));
    						}
    						if(t.getSpeseRevisioneCertificazionePatrimonio()!= null && !"---".equals(t.getSpeseRevisioneCertificazionePatrimonio())&&  !"".equals(t.getSpeseRevisioneCertificazionePatrimonio())&& 
    								!nd.contains(t.getSpeseRevisioneCertificazionePatrimonio()) && !na.contains(t.getSpeseRevisioneCertificazionePatrimonio())){
    							t.setSpeseRevisioneCertificazionePatrimonio(FormatterFactory.getStandardPercentuale(new Double(t.getSpeseRevisioneCertificazionePatrimonio().replace("%", "").replace(",", "."))));
    						}
    						if(t.getSpesePubblicazione()!= null && !"---".equals(t.getSpesePubblicazione())&&  !"".equals(t.getSpesePubblicazione())&&  !nd.contains(t.getSpesePubblicazione()) && 
    								!na.contains(t.getSpesePubblicazione())){
    							t.setSpesePubblicazione(FormatterFactory.getStandardPercentuale(new Double(t.getSpesePubblicazione().replace("%", "").replace(",", "."))));
    						}
    						if(t.getAltriOneri()!= null && !"---".equals(t.getAltriOneri())&&  !"".equals(t.getAltriOneri())&&  !nd.contains(t.getAltriOneri()) && !na.contains(t.getAltriOneri())){
    							t.setAltriOneri(FormatterFactory.getStandardPercentuale(new Double(t.getAltriOneri().replace("%", "").replace(",", "."))));
    						}
    					}
    					BarraBean barraGraph = isin.getBarraGraph();
    					if(barraGraph != null && !isin.isFondoInterno()){
	    					Barre barre = barraGraph.getBarre();
	    					List<Barra> listBarre = barre.getBarre();
	    					List<Barra> result = new ArrayList<Barra>();
	    					anni.clear();
	    					setAnni(listBarre);
	    					List<String> anniInseriti = new ArrayList<String>();
	    					for(Barra b : listBarre){
	    						if(anni.contains(b.getAnno())){
	    							result.add(b);
	    							if(!anniInseriti.contains(b.getAnno())){
	    								anniInseriti.add(b.getAnno());
	    							}
	    						}
	    					}
	    					Integer po = new Integer(isin.getRendimento().getPeriodoOsservazione());
	    					if(po >= 5 )
	    						isin.setIntestazioneGrafico1("Rendimento annuo nel corso degli ultimi 5 anni solari");
	    					anniInseriti.clear();
	    					isin.getBarraGraph().getBarre().setBarre(result);
	    					
    					}
    					isinsList.add(isin);
    				}
    				fund.setIsins(isinsList);
    			}
    		i++;
    		}
    	return p;
    }
    
    private void valorizzaTassoInflazioneMedio(Rendimento rr,PubblicazioneConsob p){
    	rr.setTassoMedioInflazione2AnniPrecedenti(p.getTassoMedioInflazione2AnniPrecedenti());
		rr.setTassoMedioInflazione1AnnoPrecedente(p.getTassoMedioInflazione1AnnoPrecedente());
		rr.setTassoMedioInflazioneUltimi3Anni(p.getTassoMedioInflazioneUltimi3Anni());
		rr.setTassoMedioInflazioneUltimi5Anni(p.getTassoMedioInflazioneUltimi5Anni());
		rr.setTassoMedioInflazioneUltimi10Anni(p.getTassoMedioInflazioneUltimi10Anni());
	}

	private Isin setMessaggiFondo(Isin isin) {
		String durataComparto = isin.getDurataComparto();
		if(na.contains(durataComparto)){
			isin.setDurataComparto(NON_PREVISTA);
		}else if(nd.contains(durataComparto)){
			isin.setDurataComparto(NON_DISPONIBILE);
		}
		String areeGeografiche = isin.getPolitica().getArreeGeografiche();
		if("".equals(areeGeografiche) || na.contains(areeGeografiche)){
			isin.getPolitica().setArreeGeografiche("n.a.");
		}else if(nd.contains(areeGeografiche)){
			isin.getPolitica().setArreeGeografiche(NON_DISPONIBILE);
		}
		String categorieEmittenti = isin.getPolitica().getCategoriEmittenti();
		if("".equals(categorieEmittenti) || na.contains(categorieEmittenti)){
			isin.getPolitica().setCategoriEmittenti("n.a.");
		}else if(nd.contains(categorieEmittenti)){
			isin.getPolitica().setCategoriEmittenti(NON_DISPONIBILE);
		}
		String settoriIndustriali = isin.getPolitica().getSettoriIndustrialiRilevanti();	
		if("".equals(settoriIndustriali) || na.contains(settoriIndustriali)){
			isin.getPolitica().setSettoriIndustrialiRilevanti("n.a.");
		}else if(nd.contains(settoriIndustriali)){
			isin.getPolitica().setSettoriIndustrialiRilevanti(NON_DISPONIBILE);
		}
		String investimentoQuote = isin.getPolitica().getInvestimentoQuoteAzioniFondiInterniOicr();
		if(na.contains(investimentoQuote)){
			isin.getPolitica().setInvestimentoQuoteAzioniFondiInterniOicr("Non è previsto l'investimento in quote/azioni "
					+ "di OICR promossi e/o gestiti da società del gruppo di appartenenza dell’Impresa.");
		}
		String strumentiDerivati = isin.getPolitica().getStrumentiDerivati();
		if(!na.contains(strumentiDerivati) && !"".equals(strumentiDerivati)){
			isin.getPolitica().setStrumentiBold(true);
			isin.getPolitica().setAltriStrumenti("La normativa assicurativa vieta l’utilizzo degli strumenti finanziari derivati a fini speculativi");
		}else if ("".equals(strumentiDerivati) || na.contains(strumentiDerivati)){
			isin.getPolitica().setStrumentiDerivati("n.a.");
		}else if (nd.contains(strumentiDerivati)){
			isin.getPolitica().setStrumentiDerivati(NON_DISPONIBILE);
		}
		String tecnicaGestione = isin.getPolitica().getTecninaDiGestione();
		if("".equals(tecnicaGestione)){
			isin.getPolitica().setTecninaDiGestione("Non sono attuate tecniche di gestione");
		}
		String descrizioneBenchmark = isin.getBenchmark().getDescrizioneBenchmark();
		if(na.contains(descrizioneBenchmark) || nd.contains(descrizioneBenchmark)){
			isin.getBenchmark().setDescrizioneBenchmark("");
		}
		return isin;
	}
}
