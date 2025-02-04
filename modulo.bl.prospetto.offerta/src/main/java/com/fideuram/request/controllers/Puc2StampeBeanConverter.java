package com.fideuram.request.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.addendum.Addendum;
import com.fideuram.modello.anagrafe.Gestore;
import com.fideuram.modello.anagrafe.SocietaRevisione;
import com.fideuram.modello.anagrafe.SoggettoDelegato;
import com.fideuram.modello.chart.BarraBean;
import com.fideuram.modello.chart.LineaTimeBean;
import com.fideuram.modello.selection.Benchmark;
import com.fideuram.modello.selection.Fundhouse;
import com.fideuram.modello.selection.Isin;
import com.fideuram.modello.selection.Politica;
import com.fideuram.modello.selection.Rendimento;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.modello.selection.Ter;
import com.fideuram.modello.selection.Tipologia;
import com.fideuram.modello.supplemento.Supplemento;
import com.fideuram.puc.service.impl.FundHouse;
import com.fideuram.puc.service.impl.FvInsieme;
import com.fideuram.puc.service.impl.Grafico1;
import com.fideuram.puc.service.impl.Grafico2;
import com.fideuram.puc.service.impl.PuntoG1;
import com.fideuram.puc.service.impl.PuntoG2;
import com.fideuram.puc.service.impl.SelezioneFondi;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.jaxb.XmlGregorian2Date;

/**
 * Created by
 * User: logan
 * Date: 25/10/12
 * Time: 18.37
 */
public class Puc2StampeBeanConverter {
    int countIsinPuc=0;
    int countIsinStampe=0;
    int countIsinConGrafico;
    protected boolean isFondoInterno;
    protected boolean isPropostaInvestimento;
    int prodotto;
    private List<String> match = Arrays.asList( "n.d.","nd","n.d","nd.","n.a.","na","n.a","na.");

    public PubblicazioneConsob convert(FvInsieme puc,int prodotto) throws ProspettoDiOffertaException {
        this.prodotto=prodotto;
        PubblicazioneConsob pb=new PubblicazioneConsob();
        try{
            pb.setDeposito(XmlGregorian2Date.asDate(puc.getDeposito()));
            if(null==pb.getDeposito())
                pb.setDeposito(new Date());
            pb.setValidita(XmlGregorian2Date.asDate(puc.getValidita()));
            if(null==pb.getValidita())
                pb.setValidita(new Date());
            pb.setProtocolloI(puc.getAllegatoAParteI());
            pb.setProtocolloII(puc.getParteII());
            pb.setProtocolloIII(puc.getAllegatoAParteIII());

            //pb.setProtocolloI("Mod. RSPIA06 – Ed. 06/2015");
            //pb.setProtocolloII("Mod. RSPII10 – Ed. 06/2015");
            //pb.setProtocolloIII("Mod. RSPIIIA06 – Ed. 06/2015");

            pb.setSupplemento(createSupplemento(puc));
            pb.setAddendum(createAddendum(puc));
            pb.setNomeProdotto(puc.getNomeProdotto());
            pb.setTestoFondoInterno(puc.getTestoFondoInterno());
            pb.setTestoNomeProdotto_I(puc.getTestoNomeProdottoI());
            pb.setTestoNomeProdotto_III(puc.getTestoNomeProdottoIII());
            pb.setTestoFissoSintesi(puc.getTestoFissoSintesi());
            pb.setTestoFissoAllegatoA(puc.getTestoFissoAllegatoA());

            pb.setTassoMedioInflazione1AnnoPrecedente(puc.getTassoMedioInflazione1AnnoPrecedente());
            pb.setTassoMedioInflazione2AnniPrecedenti(puc.getTassoMedioInflazione2AnniPrecedenti());
            pb.setTassoMedioInflazioneUltimi10Anni(puc.getTassoMedioInflazioneUltimi10Anni());
            pb.setTassoMedioInflazioneUltimi3Anni(puc.getTassoMedioInflazioneUltimi3Anni());
            pb.setTassoMedioInflazioneUltimi5Anni(puc.getTassoMedioInflazioneUltimi5Anni());
            
            String[] c=getAlfabetoSelecttion(puc.getSelezioneFondis().size());
            for(int i=0; i<puc.getSelezioneFondis().size();i++){
               //todo 23Ottobre
               //Pietro segnala che la stampa dei supplementi sintetici non riporta la dicitura: NON CI SONO AGGIORNAMENTI SUGLI ETF
               //QUINDI HO TOLTO QUESTA  if(null!=puc.getSelezioneFondis().get(i).getFundHouses()&&!puc.getSelezioneFondis().get(i).getFundHouses().isEmpty()){   //Elimino la eventuale selection dove getFundHouses is null

                // if(null!=puc.getSelezioneFondis().get(i).getFundHouses()&&!puc.getSelezioneFondis().get(i).getFundHouses().isEmpty()){   //Elimino la eventuale selection dove getFundHouses is null

                    if(null!=puc.getSelezioneFondis().get(i)&&null!=puc.getSelezioneFondis().get(i).getFundHouses()&&puc.getSelezioneFondis().get(i).getFundHouses().size()>0){
                        //if(puc.getSelezioneFondis().get(i).isSelectionProposteInvestimento()){
                        //    LoggingUtils.info(">>>>>>\n>>>>>\n>>>>Elimino la PROPOSTA");
                        //}else{
                            SelectionFund sf= getSelectionFund(puc.getSelezioneFondis().get(i));
                            sf.setPuntatore(c[i]);
                            if(sf.getNome().contains("SELECTION FIDEURAM")){
                            	sf.setNotEsisteFideuram(false);
                            }
                            if(sf.getNome().contains("SELECTION PARTNERS")){
                            	sf.setNotEsistePartners(false);
                            }
                            LoggingUtils.debug("selection caricata: "+sf.getNome());
                            pb.addSelectionFunds(sf);
                        //}
                    }else{
                        SelectionFund sf = new SelectionFund();
                        sf.setNome(puc.getSelezioneFondis().get(i).getDescrizione()!=null?puc.getSelezioneFondis().get(i).getDescrizione():"");
                        sf.setFondoInterno(puc.getSelezioneFondis().get(i).isSelectionFondiInterni()!=null?puc.getSelezioneFondis().get(i).isSelectionFondiInterni():false);
                        sf.setPuntatore(c[i]);
                        if(sf.getNome().contains("SELECTION FIDEURAM")){
                        	sf.setNotEsisteFideuram(true);
                        }
                        if(sf.getNome().contains("SELECTION PARTNERS")){
                        	sf.setNotEsistePartners(true);
                        }
                        LoggingUtils.debug("selection caricata: "+sf.getNome());
                        pb.addSelectionFunds(sf);
                    }
               // }
            }
        }catch (NullPointerException e){
            LoggingUtils.error(e);
            throw new ProspettoDiOffertaException("NullPointerException in Puc2StampeBeanConverter: ",e);
        }
        stampaCorrispondenzaPopolazioneIsin(puc, pb);
        return clean(pb);
    }


	@Deprecated
    protected String[] getAlfabetoSelecttion(int sizeSelections){
        String[] c=new String[sizeSelections];
        for (int i=0; i<sizeSelections; i++){
            switch (i){
                case 0:
                    c[0]="";
                    break;
                case 1:
                    c[1]="A)";
                    break;
                case 2:
                    c[2]="B)";
                    break;
                case 3:
                    c[3]="C)";
                    break;
                case 4:
                    c[4]="D)";
                    break;
                case 5:
                    c[5]="E)";
                    break;
            }
        }
        return c;
    }

    protected Supplemento createSupplemento(FvInsieme puc){
        Supplemento supplemento = new Supplemento();
        supplemento.setArt(puc.getArticolo());
        for (int i=0; i<puc.getIsinFuoriusciti().size();i++){
            Isin isin = new Isin();
            com.fideuram.puc.service.impl.Isin pucIsin = puc.getIsinFuoriusciti().get(i);
            isin.setCodiceImpresa(pucIsin.getCodiceImpresa());
            isin.setCodiceIsin(pucIsin.getCodiceIsin());
            isin.setDenominazioneCompletaComparto(pucIsin.getDenominazioneCompletaComparto());
            supplemento.addIsinFuoriusciti(isin);
        }

        List<Isin> modificstiParte1 = new ArrayList<Isin>();
        for (int i=0; i<puc.getIsinModificatiParte1().size();i++){
            Isin isin = new Isin();
            com.fideuram.puc.service.impl.Isin pucIsin = puc.getIsinModificatiParte1().get(i);
            isin.setNotaDiModifica(pucIsin.getNotaDiModifica());
            modificstiParte1.add(isin);
        }
        if(modificstiParte1.size()>0)
            supplemento.setIsinModificatiParte1(modificstiParte1);


        List<Isin> modificstiParte2 = new ArrayList<Isin>();
        for (int i=0; i<puc.getIsinModificatiParte2().size();i++){
            Isin isin = new Isin();
            com.fideuram.puc.service.impl.Isin pucIsin = puc.getIsinModificatiParte2().get(i);
            isin.setNotaDiModifica(pucIsin.getNotaDiModifica());
            modificstiParte2.add(isin);
        }
        if(modificstiParte2.size()>0)
            supplemento.setIsinModificatiParte2(modificstiParte2);

        List<Isin> modificstiParte3 = new ArrayList<Isin>();
        for (int i=0; i<puc.getIsinModificatiParte3().size();i++){
            Isin isin = new Isin();
            com.fideuram.puc.service.impl.Isin pucIsin = puc.getIsinModificatiParte3().get(i);
            isin.setNotaDiModifica(pucIsin.getNotaDiModifica());

            modificstiParte3.add(isin);
        }
        if(modificstiParte3.size()>0)
            supplemento.setIsinModificatiParte3(modificstiParte3);

        return supplemento;
    }

    
    protected Addendum createAddendum(FvInsieme puc){
    	Addendum addendum = new Addendum();
//        supplemento.setArt(puc.getArticolo());
        for (int i=0; i<puc.getIsinFuoriusciti().size();i++){
            Isin isin = new Isin();
            com.fideuram.puc.service.impl.Isin pucIsin = puc.getIsinFuoriusciti().get(i);
            isin.setCodiceImpresa(pucIsin.getCodiceImpresa());
            isin.setCodiceIsin(pucIsin.getCodiceIsin());
            isin.setDenominazioneCompletaComparto(pucIsin.getDenominazioneCompletaComparto());
            addendum.addIsinFuoriusciti(isin);
        }

        List<Isin> modificstiParte1 = new ArrayList<Isin>();
        for (int i=0; i<puc.getIsinModificatiParte1().size();i++){
            Isin isin = new Isin();
            com.fideuram.puc.service.impl.Isin pucIsin = puc.getIsinModificatiParte1().get(i);
            isin.setNotaDiModifica(pucIsin.getNotaDiModifica());
            modificstiParte1.add(isin);
        }
        addendum.setIsinModificatiParte1(modificstiParte1);
        return addendum;
    }
    protected PubblicazioneConsob clean(PubblicazioneConsob pb){
    	boolean isPrimoEsterno = false;
        if (pb.getSelectionFunds()!=null){
            for(int i=0; i<pb.getSelectionFunds().size();i++){
                SelectionFund s = pb.getSelectionFunds().get(i);
                if(!s.getFondoInterno()&&!s.isPropostaInvestimento() && !isPrimoEsterno/*&&i==2*/){
                    s.setPrimoFondoEsterno(true);
                    isPrimoEsterno = true;
                }
                if(null!=s.getFundhouses()){
                    for(int y=0; y<s.getFundhouses().size();y++){
                        Fundhouse f=  s.getFundhouses().get(y);
                        if(null==f.getIsins()){
                            s.getFundhouses().remove(y);
                        }
                    }
                }
            }
        }
        return pb;
    }

    protected SelectionFund getSelectionFund(SelezioneFondi selezioneFondi){
        SelectionFund sf = new SelectionFund();
        sf.setNome(selezioneFondi.getDescrizione()!=null?selezioneFondi.getDescrizione():"");
        sf.setFondoInterno(selezioneFondi.isSelectionFondiInterni()!=null?selezioneFondi.isSelectionFondiInterni():false);
        sf.setPropostaInvestimento(selezioneFondi.isSelectionProposteInvestimento()!=null?selezioneFondi.isSelectionProposteInvestimento():false);
        isFondoInterno=sf.getFondoInterno();
        isPropostaInvestimento=sf.isPropostaInvestimento();
        
        for (int i=0;i<selezioneFondi.getFundHouses().size();i++){
            sf.addFundhouses(getFundhouse(selezioneFondi.getFundHouses().get(i),sf));
        }
        return sf;
    }


    protected Fundhouse getFundhouse(FundHouse fundHouse, SelectionFund sf){
        Fundhouse fundhouse = new Fundhouse();
        fundhouse.setNome(fundHouse.getTitolo());
        for(int i=0; i<fundHouse.getIsins().size();i++){
            Isin isin = getIsin(fundHouse.getIsins().get(i));
            if(isin!=null){
                fundhouse.addIsins(isin);
                if(isin.isFondoInterno()){
                	sf.getIsinsInterni().add(isin);
                }else{
                	sf.getIsinsEsterni().add(isin);
                }
            }
        }
        return fundhouse;
    }

    /**
     * @param pucIsin (com.fideuram.offertafondi del puc)
     * @return
     */
    private Isin getIsin(com.fideuram.puc.service.impl.Isin pucIsin){
        countIsinPuc=countIsinPuc+1;
        Isin stampeIsin = new Isin();
        stampeIsin.setProdotto(prodotto);
        stampeIsin.setNoteTer(pucIsin.getNoteTer());
        Date today = new Date();
        stampeIsin.setAnnoPrecedente(today.getYear() -1 + 1900 +"");
        stampeIsin.setAnniPrecedenti2(today.getYear() -2 + 1900 +"");
        stampeIsin.setNotaAnnoPrecedente(pucIsin.getRischioRendimento().getNoteAnnoPrecedente());
        stampeIsin.setNotePeriodoOsservazione(pucIsin.getRischioRendimento().getNotePeriodoOsservazione());
        stampeIsin.setNoteAltreInfo(pucIsin.getNoteAltreInfo());

        stampeIsin.setTestoTer(pucIsin.getTestoTer());
        stampeIsin.setTestoAltreInfo(pucIsin.getTestoAltreInfo());
        stampeIsin.setFondoInterno(isFondoInterno);
        stampeIsin.setPropostaInvestimento(isPropostaInvestimento);
        stampeIsin.setVoceAltriOneri(pucIsin.getAltro().getOneriVoceAltriOneriGravantiOicrTer());
        stampeIsin.setSocietaRevisione(getSocietaRevisione(pucIsin.getSocietaRevisione()));
        stampeIsin.setFormaOrganizzativaComparto(pucIsin.getFormaOrganizzativaComparto());

        if(null==pucIsin.isIsFondoNuovaCostituzione()||!pucIsin.isIsFondoNuovaCostituzione())
            stampeIsin.setOldCostituzione(true);
        if(null==pucIsin.isIsBenchmark()||!pucIsin.isIsBenchmark())
            stampeIsin.setNotBenchmark(true);
        try{
            if( pucIsin.getCodiceIsin().toUpperCase().startsWith("XX")){
                LoggingUtils.debug("SCARTATO    " + pucIsin.getCodiceIsin());
                return null;
            }

            stampeIsin.setDenominazioneCompletaComparto(pucIsin.getDenominazioneCompletaComparto());
            stampeIsin.setCodiceImpresa(pucIsin.getCodiceImpresa());
            stampeIsin.setCodiceIsin(pucIsin.getCodiceIsin());

            //ALTRI DATI
            stampeIsin.setDataIniziOperativita(pucIsin.getAltro().getDataAvvioComparto()!=null?pucIsin.getAltro().getDataAvvioComparto():"");   //todo pristine withount ?
            stampeIsin.setDurataComparto(pucIsin.getAltro().getDurataComparto());
//            stampeIsin.setValutaPatrimonioNetto(pucIsin.getAltro().getValutaPatrimonioNetto());
            stampeIsin.setValutaPatrimonioNetto(pucIsin.getAltro().getValutaPatrimonioNetto());
            stampeIsin.setValutaValoreQuota(pucIsin.getAltro().getValutaValoreQuota());
            stampeIsin.setCommGestMaxIndOICR(pucIsin.getAltro().getCommissioneGestioneMassimaOICR());
            stampeIsin.setCommIncentMaxIndOICR(pucIsin.getAltro().getCommissioneIncentivoMassimaOICR());
            
            if (isFondoInterno){
                stampeIsin.setPatrimonioNetto31DicAnnoPrecedente(pucIsin.getAltro().getPatrimonioNetto31DicAnnoPrecedente()!=null?"\u20AC"+" "+pucIsin.getAltro().getPatrimonioNetto31DicAnnoPrecedente():""); //todo pristine withount ?
                stampeIsin.setValoreQuota31DicAnnoPrecedente(pucIsin.getAltro().getValoreQuota31DicAnnoPrecedente()!=null?"\u20AC"+" "+pucIsin.getAltro().getValoreQuota31DicAnnoPrecedente():""); //todo pristine withount ?

            }else{
                stampeIsin.setPatrimonioNetto31DicAnnoPrecedente(pucIsin.getAltro().getPatrimonioNetto31DicAnnoPrecedente()!=null?pucIsin.getAltro().getPatrimonioNetto31DicAnnoPrecedente():""); //todo pristine withount ?
                stampeIsin.setValoreQuota31DicAnnoPrecedente(pucIsin.getAltro().getValoreQuota31DicAnnoPrecedente()!=null?pucIsin.getAltro().getValoreQuota31DicAnnoPrecedente():""); //todo pristine withount ?
            }

            //stampeIsin.setValutaValoreQuota(pucIsin.getAltro().getValutaValoreQuota());

            if(getSoggettoDelegato(pucIsin.getSoggettoDelegato()).getDenominazione().equalsIgnoreCase("---"))
                stampeIsin.setSoggettoDelegataGestione(new SoggettoDelegato());
            else
                stampeIsin.setSoggettoDelegataGestione(getSoggettoDelegato(pucIsin.getSoggettoDelegato()));

            stampeIsin.setSitoPubblicazioneNav(pucIsin.getAltro().getSitoPubblicazioneNav()!=null?pucIsin.getAltro().getSitoPubblicazioneNav():"");
            stampeIsin.setClasseQuota(pucIsin.getAltro().getClasseQuota());
            stampeIsin.setClasseQuotaTerzoAll((pucIsin.getAltro().getClasseQuota() == null || "".equals(pucIsin.getAltro().getClasseQuota())) ? "---" : pucIsin.getAltro().getClasseQuota());
            stampeIsin.setClasseQuotaPersonalizzata
            (stampeIsin.getClasseQuota() != null && !"".equals(stampeIsin.getClasseQuota()) && !stampeIsin.isPropostaInvestimento()? 
            		"classe di quota " + stampeIsin.getClasseQuota() :
            	(stampeIsin.isPropostaInvestimento()? stampeIsin.getClasseQuota() :"classe di quota"));
            stampeIsin.setDataAvvioClasseQuota(pucIsin.getAltro().getDataAvvioClasseQuota());
            stampeIsin.setPrincipaliIntermediariNegoziatori(pucIsin.getAltro().getPrincipaliIntermediariNegoziatori()!=null?pucIsin.getAltro().getPrincipaliIntermediariNegoziatori():"n.d.");
            stampeIsin.setAltroCommGestione(pucIsin.getAltro().getCommissioneGestione());
            stampeIsin.setAltroCommIncentivo(pucIsin.getAltro().getCommissioneIncentivoPerformance());
            stampeIsin.setAltroCommGestioneIndiretta(pucIsin.getAltro().getCommissioneGestioneMassimaOICR());
            stampeIsin.setAltroCommIncentivoIndiretta(pucIsin.getAltro().getCommissioneIncentivoMassimaOICR());
            //TER
            stampeIsin.setTers(getTer(pucIsin));
            //-----------------------------------------------------------------------------------------

            //TIPOLOGIA
            stampeIsin.setTipologia(getTipologia(pucIsin));

            //BENCHMARK
            stampeIsin.setBenchmark(getBenchmark(pucIsin));

            //POLITICA
            stampeIsin.setPolitica(getPolitica(pucIsin));

            //RENDIMENTO
            //rendimento è legato al precarimanto di TIPOLOGIA e  POLITICA
            stampeIsin.setRendimento(getRendimento(pucIsin,stampeIsin));
            stampeIsin.setCodiceImpresa(pucIsin.getCodiceImpresa());
            stampeIsin.setGestore(getGestore(pucIsin.getGestore()));

            stampeIsin.setTestoTurnover(pucIsin.getNoteTurnover());
            
            //PREPARAZIONE GRAFICI
//            if(pucIsin.getCodiceImpresa().equals("IS003"))
            	stampeIsin.configuraGrafici();
            if(pucIsin.isPropostaInvestimento()){
                LoggingUtils.info("STO CICLANDO SU PROPOSTA DI INVEESTIMENTO .................");
            }

            if(stampeIsin.getStampaGrafico().equals("SI")){
                //GRAFICO 1
                if(pucIsin.getRischioRendimento().getGrafico1()!=null)
                    stampeIsin.setBarraGraph(getGrafico1(pucIsin));

                //GRAFICO 2
                if(pucIsin.getRischioRendimento().getGrafico2()!=null){

                    //List<LineaTimeBean> grafico2s= getGraficoLinee(pucIsin.getRischioRendimento().getGrafico2(),stampeIsin.getCodiceIsin(),pucIsin.getDenominazioneSinteticaComparto(),pucIsin.getBenchmark().getDenominazioneSintetica());
                    List<LineaTimeBean> grafico2s= getGraficoLinee(pucIsin.getRischioRendimento().getGrafico2(),stampeIsin.getCodiceIsin(),(pucIsin.isPropostaInvestimento()==null||!pucIsin.isPropostaInvestimento())?pucIsin.getDenominazioneSinteticaComparto():pucIsin.getCodiceImpresa(),pucIsin.getBenchmark().getDenominazioneSintetica());

                    stampeIsin.addLineaGraph(grafico2s.get(0));
                    //EVENTUALE SECONDO GRAFICO 2
                    if(grafico2s.size()>1){
                        stampeIsin.addLineaGraph(grafico2s.get(1));
                    }
                }
                //MEMORIZZO NELLA COUNT A SOLI FINI STATISTICI CHE QUESTO ISIN PRODUCE UN GRAFICO
                countIsinConGrafico=countIsinConGrafico+1;
            }
            stampeIsin.configuraFraseGrafici();
        }catch (NullPointerException e){
            LoggingUtils.error("NullPointerException: Su aIsino "+pucIsin.getCodiceImpresa()  + " - " + e);
            return null;
        }
        countIsinStampe=countIsinStampe+1;
        return stampeIsin;
    }

    private Politica getPolitica(com.fideuram.puc.service.impl.Isin pucIsin){
        Politica p= new Politica();
        p.setTestoGaranzia(pucIsin.getTestoGaranzia());
        p.setCategoriaAnia(pucIsin.getPolitica().getCategoriaAnia());
//        p.setUlterioriInformazioniInvestFondi(pucIsin.getPolitica().getu);
        p.setCategoria(pucIsin.getPolitica().getCategoria());
        p.setOrizzonteTemporale(pucIsin.getPolitica().getOrizzonteTemporaleInvestimentoConsigliato());
        p.setGradoRischio(pucIsin.getPolitica().getGradoRischio());
        if(p.getGradoRischio()==null)
            p.setGradoRischio("");
        else{
        	flagGradoDiRischio(p, pucIsin.getPolitica().getGradoRischio());
        }
        p.setGradoScostamentoBenchmark(pucIsin.getPolitica().getGradoScostamentoBenchmark());
        p.setStrumentiFinanziari(clearString(pucIsin.getPolitica().getPrincipaliTipologieStrumentiFinanziari(), "\n"));
        p.setValutaStrumentiFinanziari(clearString(pucIsin.getPolitica().getValutaDenominazioneStrumentiFinanziari(), "\n"));
        p.setArreeGeografiche(pucIsin.getPolitica().getAreeGeograficheMercatiRiferimento());
        p.setCategoriEmittenti(pucIsin.getPolitica().getCategorieEmittenti());
        p.setSettoriIndustrialiRilevanti(pucIsin.getPolitica().getSettoriIndustrialiRilevanti());
        p.setInvestimentoQuoteAzioniFondiInterniOicr(clearString(pucIsin.getPolitica().getInvestimentoQuoteAzioniFondiInterniOicr() == null ? "": pucIsin.getPolitica().getInvestimentoQuoteAzioniFondiInterniOicr(), "\n"));
        p.setFattoriDiRischio(clearString(pucIsin.getPolitica().getSpecificiFattoriRischio(), "\n"));
        p.setStrumentiDerivati(clearString(pucIsin.getPolitica().getStrumentiDerivati(), "\n"));
        p.setIndicizzazione(clearString(pucIsin.getPolitica().getIndicizzazione(), "\n"));
        p.setGaranzia(clearString(pucIsin.getPolitica().getGaranzia(), "\n"));
        p.setImmunizzazione(clearString(pucIsin.getPolitica().getImmunizzazione(), "\n"));
        p.setGestioneObiettivoRendimentoProtetta(clearString(pucIsin.getPolitica().getGestioneObiettivoRendimentoProtetta(), "\n"));

        p.setTecninaDiGestione(clearString(pucIsin.getPolitica().getTecnicaGestione(), "\n"));
        p.setTecninaDiGestioneRischio(clearString(pucIsin.getPolitica().getTecnicaGestioneRischio(),"\n"));
        p.setTecninaDiGestioneRischioDettagli(clearString(pucIsin.getPolitica().getTecnicaGestioneRischioDettagli(),"\n"));
        p.setDestinazioneProventi(pucIsin.getPolitica().getDestinazioneProventi()!=null?clearString(pucIsin.getPolitica().getDestinazioneProventi(),"\n"):"");
        p.setPrecisazioniGestioneBenchmarkPassivoImmunizzato(clearString(pucIsin.getPolitica().getPrecisazioniGestioneBenchmarkPassivoImmunizzato(),"\n"));
        p.setPrecisazioneGestioneBenchmarkPassivo(clearString(pucIsin.getPolitica().getPrecisazioniGestioneBenchmarkPassivo(),"\n"));
        p.setVariazioniPoliticaInvestimento(pucIsin.getPolitica().getVariazioniPoliticaInvestimentoUlt()!=null?pucIsin.getPolitica().getVariazioniPoliticaInvestimentoUlt(): Frasi.getFrase("variazione.politica.ult.2.anni"));
        p.setVariazioniSoggettiIncaricati(pucIsin.getPolitica().getVariazioniSoggettiIncaricatiGestioneUlt()!=null?pucIsin.getPolitica().getVariazioniSoggettiIncaricatiGestioneUlt(): Frasi.getFrase("variazione.soggetti.ult.2.anni"));
        //p.setDvpi(pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt()!=null?pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt()+".":"");
        if(pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt()!=null&&!pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt().trim().equals("")){
            String capoverso=pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt().trim().substring(0,1).toUpperCase();
            String seguito=pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt().trim().substring(1)+".";
            //String seguito=pucIsin.getPolitica().getDescrizioneVariazioniPoliticaInvestimentoUlt().trim().substring(1)+"."+"\n";
            p.setDvpi(""+capoverso.concat(seguito));
        }else{
            p.setDvpi("");
        }

        if(pucIsin.getPolitica().getDescrizioneVariazioniSoggettiIncaricatiGestioneUlt2Anni()!=null&&!pucIsin.getPolitica().getDescrizioneVariazioniSoggettiIncaricatiGestioneUlt2Anni().trim().equals("")){
            //p.setDvpi(!p.getDvpi().trim().equals("")?p.getDvpi().concat("\n"):"");
            p.setDvpi(!p.getDvpi().trim().equals("")?p.getDvpi().concat(""):"");
            String capoverso=pucIsin.getPolitica().getDescrizioneVariazioniSoggettiIncaricatiGestioneUlt2Anni().trim().substring(0,1).toUpperCase();
            String seguito=pucIsin.getPolitica().getDescrizioneVariazioniSoggettiIncaricatiGestioneUlt2Anni().trim().substring(1);
            p.setDvsi(""+capoverso.concat(seguito));
        }else {
            p.setDvsi("");
        }

        return p;
    }


    private void flagGradoDiRischio(Politica p, String gradoRischio) {
		if("basso".equals(gradoRischio)){
			p.setBasso(true);
		}else if("medio-basso".equals(gradoRischio)){
			p.setMedioBasso(true);
		}else if("medio".equals(gradoRischio)){
			p.setMedio(true);
		}else if("medio-alto".equals(gradoRischio)){
			p.setMedioAlto(true);
		}else if("alto".equals(gradoRischio)){
			p.setAlto(true);
		}else if("molto-alto".equals(gradoRischio)){
			p.setMoltoAlto(true);
		}
	}


	private Benchmark getBenchmark(com.fideuram.puc.service.impl.Isin pucIsin){
        Benchmark benchmark = new Benchmark(
                pucIsin.getBenchmark().getDenominazioneCompleta(),
                pucIsin.getBenchmark().getDescrizioneBenchmark()!=null?pucIsin.getBenchmark().getDescrizioneBenchmark():"",
                pucIsin.getBenchmark().getUlterioriInformazioniBenchmark()!=null?pucIsin.getBenchmark().getUlterioriInformazioniBenchmark():"",
                pucIsin.getBenchmark().getVolatilitaAnnuaAttesaCompartoClasseQuota()
                
        );
        return benchmark;
    }

    private Tipologia getTipologia(com.fideuram.puc.service.impl.Isin pucIsin){
        Tipologia tipologia = new Tipologia(
                pucIsin.getTipologiaGestione().getTipologiaGestione(),
                clearString(pucIsin.getTipologiaGestione().getObiettivoGestione(),"\n"),
                pucIsin.getTipologiaGestione().getValutaDenominazioneComparto(),
                pucIsin.getTipologiaGestione().getQualifica(),
                pucIsin.getTipologiaGestione().getDisclaimerGestione()
        );

        return tipologia;
    }



    private BarraBean getGrafico1(com.fideuram.puc.service.impl.Isin pucIsin){
        //if(pucIsin.getCodiceImpresa().equalsIgnoreCase("FVI07")){
        //    LoggingUtils.info("ISIN CODICE IMPRESA"+pucIsin.getCodiceImpresa());
        //}
        Grafico1 g1=pucIsin.getRischioRendimento().getGrafico1();
        BarraBean barraBean = new BarraBean();
        barraBean.setBmk(pucIsin.getTipologiaGestione().getTipologiaGestione().contains("benchmark"));
        Barre barre = new Barre();
        barre.setHeader("");//nessun titolo
        barre.setXaxis(""); //nessun x
        barre.setYaxis(""); //nessun y

        //verifico che oicr abbia almento un punto G valorizzato
        boolean hasOnlyBmkValue=true;
        for (int i=0; i<g1.getPuntoG1S().size() ;i++){
            if(g1.getPuntoG1S().get(i).getOicr()!=null)
                hasOnlyBmkValue=false;
        }
        barraBean.setOnlyBmkValue(hasOnlyBmkValue);

        if(pucIsin.isPropostaInvestimento()){
           LoggingUtils.info("proposta");
        }
        for (int i=0; i<g1.getPuntoG1S().size() ;i++){
            PuntoG1 p = g1.getPuntoG1S().get(i);
            if(!hasOnlyBmkValue)
                barre.addBarra(new Barra((pucIsin.isPropostaInvestimento()==null||!pucIsin.isPropostaInvestimento())?pucIsin.getDenominazioneSinteticaComparto():pucIsin.getCodiceImpresa(), p.getOicr()!=null?Double.valueOf(p.getOicr()):0.00, p.getAnno()));
            if(p.getBmk()!=null&&pucIsin.getBenchmark().getDenominazioneSintetica()!= null)
                barre.addBarra(new Barra(pucIsin.getBenchmark().getDenominazioneSintetica(), Double.valueOf(p.getBmk()), p.getAnno()));
        }

       /*
         for (int i=0; i<g1.getPuntoG1S().size() ;i++){
            PuntoG1 p = g1.getPuntoG1S().get(i);
            //if(p.getOicr()!=null)
                barre.addBarra(new Barra(pucIsin.getDenominazioneSinteticaComparto(), p.getOicr()!=null?Double.valueOf(p.getOicr()):0.00, p.getAnno()));
            if(p.getBmk()!=null){
                if(barre.getBarre()==null){
                    barre.addBarra(new Barra(pucIsin.getDenominazioneSinteticaComparto(), Double.valueOf(0), p.getAnno()));
                }
                barre.addBarra(new Barra(pucIsin.getBenchmark().getDenominazioneSintetica() != null ? pucIsin.getBenchmark().getDenominazioneSintetica() : "", Double.valueOf(p.getBmk()), p.getAnno()));
            }
        }

         if(barraBean.getBarre()==null){
            PuntoG1 p = g1.getPuntoG1S().get(0);
            barre.addBarra(new Barra(pucIsin.getDenominazioneSinteticaComparto(), 0.00, p.getAnno()));
        }

        */

        barraBean.setBarre(barre);
        return barraBean;
    }


    public static List<LineaTimeBean> getGraficoLinee(Grafico2 g2, String codiceIsin, String legendOicr, String legendBmk){
        List grafici = new ArrayList();
        LineaTimeBean grafico2 = new LineaTimeBean();
        LineaTimeBean grafico3 = new LineaTimeBean();

        grafico2.setNome(codiceIsin+"g21");
        grafico3.setNome(codiceIsin+"g22");

        boolean linea211=false;
        boolean linea212=false;
        boolean linea221=false;
        boolean linea222=false;

        //GRAFICO 2.1
        String  legendOicrEur =null;
        String  timeOicrEur[] =null;
        Number  valueOicrEur[]=null;
        if(!legendOicr.equals("")||null!=legendOicr){
            legendOicrEur=legendOicr;
            timeOicrEur  = new String[g2.getPuntoG2S().size()];
            valueOicrEur = new Number[g2.getPuntoG2S().size()];
        }

        String  legendBmkEur =null;
        String  timeBmkEur[] =null;
        Number  valueBmkEur[]=null;
        if(!legendBmk.equals("")||null!=legendBmk){
            legendBmkEur=legendBmk;
            timeBmkEur  =new String[g2.getPuntoG2S().size()];
            valueBmkEur =new Number[g2.getPuntoG2S().size()];
        }

        //GRAFICO 2.2
        String legendOicrDivisa  =null;
        String  timeOicrDivisa[] =null;
        Number  valueOicrDivisa[]=null;
        if(!legendOicr.equals("")||null!=legendOicr){
            legendOicrDivisa =legendOicr;
            timeOicrDivisa  = new String[g2.getPuntoG2S().size()];
            valueOicrDivisa = new Number[g2.getPuntoG2S().size()];
        }

        String  legendBmkDivisa=null;
        String timeBmkDivis[]  =null;
        Number  valueBmkDivis[]=null;
        if(!legendBmk.equals("")||null!=legendBmk){
            legendBmkDivisa=legendBmk;
            timeBmkDivis = new String[g2.getPuntoG2S().size()];
            valueBmkDivis = new Number[g2.getPuntoG2S().size()];
        }

        // boolean g3=false;

        if(g2.getHeaderNomeOicrEur()!=null){
            grafico2.setHeader(g2.getHeaderNomeOicrEur());
        }else{
            grafico2.setHeader("Valori espressi in Euro");
        }
        //grafico2.setHeader(g2.getHeaderNomeOicrEur()!=null?g2.getHeaderNomeOicrEur():"Valori espressi in Euro");
        grafico3.setHeader(g2.getHeaderNomeOicrDivisa()!=null?g2.getHeaderNomeOicrDivisa():"");
        for(int i=0; i<g2.getPuntoG2S().size();i++){

            PuntoG2 p=g2.getPuntoG2S().get(i);

            if(null!=timeOicrEur){
                timeOicrEur[i]        =p.getDataRiferimento();
                if(null!=p.getOicrEur()){
                    valueOicrEur[i]       =Double.valueOf(p.getOicrEur());
                    linea211=true;
                }
            }
            if(null!=timeBmkEur){
                timeBmkEur[i]             =p.getDataRiferimento();
                if(null!=p.getBmkEur()){
                    valueBmkEur[i]        =Double.valueOf(p.getBmkEur());
                    linea212=true;
                }
            }

            if(null!=timeOicrDivisa){
                timeOicrDivisa[i]   =p.getDataRiferimento();
                if(null!=p.getOicrDivisa()){
                    valueOicrDivisa[i]  =Double.valueOf(p.getOicrDivisa());
                    linea221=true;
                }
            }

            if(null!=timeBmkDivis){
                timeBmkDivis[i]     =p.getDataRiferimento();
                if(null!=p.getBmkDivisa()){
                    valueBmkDivis[i]    =Double.valueOf(p.getBmkDivisa());
                    linea222=true;
                }
            }
        }

        //  if(linea211||linea212){   //verificare la coerenza
        if(linea211)
            grafico2.addLinea(timeOicrEur,valueOicrEur,legendOicrEur,true);
        if(linea212)
            grafico2.addLinea(timeBmkEur,valueBmkEur,legendBmkEur,false);

        grafici.add(grafico2);
        //  }

        if(linea221||linea222){
            if(linea221)
                grafico3.addLinea(timeOicrDivisa,valueOicrDivisa,legendOicrDivisa,true);
            if(linea222)
                grafico3.addLinea(timeBmkDivis,valueBmkDivis,legendBmkDivisa,false);

            grafici.add(grafico3);
        }


        return grafici;
    }
    
    
    private String formattaDato(String tipologia, String value, boolean verifica){
    	String result = value;
		if(verifica && tipologia != null && !tipologia.contains("benchmark")){
			result = "Non previsto";
		}else{
			if(value != null && !"".equals(value) && !match.contains(value)){
    			result = FormatterFactory.getStandardPercentuale(new Double(value.replace(",", "."))) + "%";
    		}
    	}
    	return result;
    }
    
    private Rendimento getRendimento(com.fideuram.puc.service.impl.Isin pucIsin, Isin stampeIsin){
    	
        Rendimento r = new Rendimento();
        //Nuovi sviluppitasso medio inflazione per scheda sintetica
        r.setTassoMedioInflazione1AnnoPrecedente(pucIsin.getRischioRendimento().getTassoMedioInflazione1AnnoPrecedente());
        r.setTassoMedioInflazione2AnniPrecedenti(pucIsin.getRischioRendimento().getTassoMedioInflazione2AnniPrecedenti());
        r.setTassoMedioInflazioneUltimi10Anni(pucIsin.getRischioRendimento().getTassoMedioInflazioneUltimi10Anni());
        r.setTassoMedioInflazioneUltimi3Anni(pucIsin.getRischioRendimento().getTassoMedioInflazioneUltimi3Anni());
        r.setTassoMedioInflazioneUltimi5Anni(pucIsin.getRischioRendimento().getTassoMedioInflazioneUltimi5Anni());
    
//        if(pucIsin.get){
//        	
//        }else{
	        r.setPrimoAnnoBMK(formattaDato(pucIsin.getTipologiaGestione().getTipologiaGestione(), pucIsin.getRischioRendimento().getPrimoAnnoBMK(), true));
	        r.setPrimoAnnoOICR(formattaDato(null, pucIsin.getRischioRendimento().getPrimoAnnoOICR(), false));
	        r.setSecondoAnnoBMK(formattaDato(pucIsin.getTipologiaGestione().getTipologiaGestione(), pucIsin.getRischioRendimento().getSecondoAnnoBMK(), true));
	        r.setSecondoAnnoOICR(formattaDato(null,pucIsin.getRischioRendimento().getSecondoAnnoOICR(), false));
	        r.setVolatilitaBMK(formattaDato(pucIsin.getTipologiaGestione().getTipologiaGestione(), pucIsin.getRischioRendimento().getVolatilitaBMK(), true));
	        r.setUltimiDieciAnniBMK(formattaDato(pucIsin.getTipologiaGestione().getTipologiaGestione(), pucIsin.getRischioRendimento().getUltimiDieciAnniBMK(), true));
	        r.setUltimiDiecianniOICR(formattaDato(null,pucIsin.getRischioRendimento().getUltimiDieciAnniOICR(), false));
	        r.setUltimi3AnniBMK(formattaDato(pucIsin.getTipologiaGestione().getTipologiaGestione(), pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUlt3AnniBmk(), true));
	        r.setUltimi3anniOICR(formattaDato(null,pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUlt3AnniOicr(), false));
	        r.setUltimi5AnniBMK(formattaDato(pucIsin.getTipologiaGestione().getTipologiaGestione(), pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUlt5AnniBmk(), true));
	        r.setUltimi5anniOICR(formattaDato(null,pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUlt5AnniOicr(), false));
//        }
        r.setGraficoDiBenchmark(pucIsin.getRischioRendimento().isPresentiDatiGraficoBenchmark()!=null?pucIsin.getRischioRendimento().isPresentiDatiGraficoBenchmark():false);

        r.setUltimoAnnoSolareTrascorso(pucIsin.getRischioRendimento().getUltimoAnnoSolareTrascorso());
        //r.setPeriodoOsservazione(pucIsin.getRischioRendimento().getPeriodoI());
        r.setPeriodoOsservazione(pucIsin.getRischioRendimento().getPeriodoOsservazione());
        // r.setPeriodoII(pucIsin.getRischioRendimento().getPeriodoII());
        r.addDatiRendimentos(isPropostaInvestimento?stampeIsin.getCodiceImpresa():pucIsin.getDenominazioneCompletaComparto(),
                pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaDataAvvioOicr()!=null? pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaDataAvvioOicr():null,
                pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIAnniOicr()!=null? pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIAnniOicr():null,
                pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIIAnniOicr()!=null?pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIIAnniOicr():null,
                stampeIsin);

        r.addDatiRendimentos("Benchmark",
                pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaDataAvvioBmk()!=null?pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaDataAvvioBmk():null,
                pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIAnniBmk()!=null?pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIAnniBmk():null,
                pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIIAnniBmk() != null ? pucIsin.getRischioRendimento().getRendimentoMedioCompostoBaseAnnuaUltPeriodoIIAnniBmk() : null,
                stampeIsin);
        r.setVolatilitaUltimoAnnoSolareExAnte(pucIsin.getRischioRendimento().getVolatilitaUltimoAnnoSolareExAnte());
        r.setVolatilitaUltimoAnnoSolareExPost(pucIsin.getRischioRendimento().getVolatilitaUltimoAnnoSolareExPost());
        r.setNote(pucIsin.getRischioRendimento().getNoteGraficoRendimento());
        r.setBenchmark(isPropostaInvestimento && pucIsin.getTipologiaGestione().getTipologiaGestione()==null ? "": pucIsin.getTipologiaGestione().getTipologiaGestione());
        r.setVolatilitaBMK(isPropostaInvestimento && pucIsin.getTipologiaGestione().getTipologiaGestione() == null ?  "Non previsto": 
        		(pucIsin.getTipologiaGestione().getTipologiaGestione().contains("benchmark")? pucIsin.getRischioRendimento().getVolatilitaBMK() : "Non previsto"));
        r.setStampaExAntePost(pucIsin.isIsFondoNuovaCostituzione() ? null : r.getStampaExAntePost());
        //valorizzata per capire la tipologia di tabella 'Rendimento' che deve essere visualizzata sul doc
        setTabellaRendimento(r);
        return r;
    }

    private void setTabellaRendimento(Rendimento r) {
    	Integer po = r.getPeriodoOsservazione() != null ? new Integer(r.getPeriodoOsservazione()): 0;
    	//se il 0<periodo di osservazione>3  e diverso da 2 (quindi uguale a 1)
    	//1° OICR, 1° BMK
		if(po > 0 && po < 3 && po != 2){
			r.setTipoUno(true);
			return;
		}
		//se periodo osservazione = 2
		//1° OICR, 1° BMK, 2°OICR, 2° BMK
		if(po == 2){
			r.setTipoDue(true);
			return ;
		}
		//3<=periodo osservazione<5 
		// 3 anni OICR, 3 anni BMK
		if(po >= 3 && po < 5){
			r.setTipoTre(true);
			return ;
		}
		//periodo osservazione > 5
		//5 anni OICR, 5 anni BMK
//		if(po > 5){
//			r.setTipoQuattro(true);
//			return ;
//		}
		//periodo osservazione = 5
		//5 anni OICR, 5 anni BMK, 10 anni OICR
		if(po >= 5){
			r.setTipoCinque(true);
			return ;
		}
		//periodo osservazione = 10
		//10 anni BMK
		if(po == 10){
			r.setTipoSei(true);
			return ;
		}
		if(po == 0){
			r.setTipoZero(true);
			return;
		}
		return ;
	}


	public List<Ter> getTer(com.fideuram.puc.service.impl.Isin pucIsin){
        List<Ter> rops=new ArrayList<Ter>();
        for(int i=0; i<pucIsin.getTers().size();i++ ){
            com.fideuram.puc.service.impl.Ter t = pucIsin.getTers().get(i);
            Ter r = new Ter();
            r.setAnno(t.getAnno());
            r.setCommissioniGestione(t.getCommissioniGestione());
            r.setTurnoverPortafoglio(t.getTurnoverPortafoglio());
            r.setOneriDismissioneAttivita(t.getOneriDismissioneAttivita());
            r.setCommissioniIncentivo(t.getCommissioniIncentivoPerformance());
            r.setTer(t.getOicrSottostanti());
            r.setTotSpeseArrotondate(t.getTotale());
            r.setSpeseAmministrazioneCustodia(t.getSpeseAmministrazioneCustodiaBancaDepo());
            r.setSpeseRevisioneCertificazionePatrimonio(t.getSpeseRevisioneCertificazionePatrimonioOicr());
            r.setSpeseGiudiziarie(t.getSpeseLegaliGiudiziarie());
            r.setSpesePubblicazione(t.getSpesePubblicazione());
//            r.setAltriOneri(isValidYear(r) ? t.getAltriOneriGravantiOicr() : "---");tolto il 20/10/2017 su richiesta di Sommavilla
            r.setAltriOneri(t.getAltriOneriGravantiOicr());
            r.setTotSpese(t.getTotale());
            r.setTotCommissioni(t.getTotaleCommissioni());
            r.setPesoCompravenditeStrumentiFinanziari(t.getPesoPercCompravenditeStrumentiFinanziari());
            r.setPesoCompFin(t.getPesoPercCompravenditeStrumentiFinanziari());
            rops.add(r);
        }
        return rops;
    }
	
	private boolean isValidYear(Ter t){
		boolean isValid =  false;
		 if(!"---".equals(t.getCommissioniGestione()) || !"---".equals(t.getCommissioniIncentivo()) ||
				!"---".equals(t.getTer()) || !"---".equals(t.getOneriDismissioneAttivita()) || !"---".equals(t.getSpeseAmministrazioneCustodia())|| 
				!"---".equals(t.getSpesePubblicazione())){
			 isValid = true;
		 }
		return isValid;
	}
	

    /**
    *
    * @param  societa di revisione proveniente dal PUC
    * @return
    */
   private SocietaRevisione getSocietaRevisione(com.fideuram.puc.service.impl.SocietaRevisione sd){
       SocietaRevisione societaRevisione = new SocietaRevisione();
       societaRevisione.setDenominazione(sd.getDenominazione());
       societaRevisione.setSedeLegale(sd.getSedeLegale());
       societaRevisione.setNazionalita(sd.getNazionalita());
       return societaRevisione;
   }


    /**
     *
     * @param sd tipo com.fideuram.offertafondi.isin.SoggettoDelegato
     *           soggetto delegato proveniente dal PUC
     * @return
     */
    private SoggettoDelegato getSoggettoDelegato(com.fideuram.puc.service.impl.SoggettoDelegato sd){
        SoggettoDelegato soggettoDelegato = new SoggettoDelegato();
        soggettoDelegato.setDenominazione(sd.getDenominazione());
        soggettoDelegato.setSedeLegale(sd.getSedeLegale());
        soggettoDelegato.setGruppo(sd.getGruppo());
        soggettoDelegato.setNazionalita(sd.getNazionalita());
        return soggettoDelegato;
    }

    /**
     *
     * @param sd tipo com.fideuram.offertafondi.isin.SoggettoDelegato
     *           soggetto delegato proveniente dal PUC
     * @return
     */
    private Gestore getGestore(com.fideuram.puc.service.impl.Gestore sd){
        Gestore soggettoDelegato = new Gestore();
        soggettoDelegato.setDenominazione(sd.getDenominazione());
        soggettoDelegato.setSedeLegale(sd.getSedeLegale());
        soggettoDelegato.setGruppo(sd.getGruppo());
        soggettoDelegato.setNazionalita(sd.getNazionalita());
        return soggettoDelegato;
    }


    public static void main(String args[]){
        clearString("prova\ndistringaripu\nlita","\n");
    }

    public static String clearString(String stringa, String sequenza){
        return stringa.replace(sequenza," ");
    }

    protected void stampaCorrispondenzaPopolazioneIsin(FvInsieme puc, PubblicazioneConsob pb) {
        LoggingUtils.debug(" ");
        LoggingUtils.debug("---------------------------------------");
        LoggingUtils.debug("|            STATISTICHE              |");
        LoggingUtils.debug("|_____________________________________|");
        LoggingUtils.debug("|                                     |");
        LoggingUtils.debug("|   ASINI PROVENIENTI DAL PUC: "+countIsinPuc+"     |");
        LoggingUtils.debug("|   ASINI MESSI IN STAMPA    : "+countIsinStampe+"     |");
        LoggingUtils.debug("|   DI CUI CON GRAFICO       : "+countIsinConGrafico+"     |");
        LoggingUtils.debug("|_____________________________________|");
        LoggingUtils.debug(" ");
    }
}
