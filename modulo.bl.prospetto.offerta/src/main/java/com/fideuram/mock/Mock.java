package com.fideuram.mock;


import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.anagrafe.Gestore;
import com.fideuram.modello.anagrafe.SoggettoDelegato;
import com.fideuram.modello.chart.LineaTimeBean;
import com.fideuram.modello.selection.*;
import com.fideuram.modello.tbd.ClasseBonus;
import com.fideuram.modello.tbd.CostoRetrocesso;
import com.fideuram.modello.tbd.LineaInvestimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 06/06/12
 * Time: 17.48
 */
public class Mock {
    private static int count=1;
    private static boolean anni3=false;

    public static PubblicazioneConsob getMock(){
        List<SelectionFund> selectionFunds = new ArrayList<SelectionFund>();
        selectionFunds.add(Mock.getHouse("OICR: APPARTENENTI ALLA SELECTION FIDEURAM"));
        selectionFunds.add(Mock.getHouse("OICR: APPARTENENTI ALLA SELECTION PARTNERS"));
        PubblicazioneConsob documentoOffertaPremium = new PubblicazioneConsob();
        documentoOffertaPremium.setSelectionFunds(selectionFunds);
        return configuraDocumento(documentoOffertaPremium);
    }

    private static SoggettoDelegato getDelegato(){
        SoggettoDelegato g=new SoggettoDelegato();
        g.setDenominazione("INVESCO MANAGEMENET SA");
        g.setSedeLegale("19 Rue de bainsBitbourg L-1273");
        g.setNazionalita("Lussemburgo");
        g.setGruppo("Invesco ltd");
        return g;
    }

    private static Gestore getGestore(){
        Gestore g=new Gestore();
        g.setDenominazione("INVESCO MANAGEMENET SA");
        g.setSedeLegale("19 Rue de bainsBitbourg L-1273");
        g.setNazionalita("Lussemburgo");
        g.setGruppo("Invesco ltd");
        return g;
    }

    private static PubblicazioneConsob configuraDocumento(PubblicazioneConsob doc){
        doc.setValidita(new Date("2012/03/23"));
        doc.setDeposito(new Date("2012/03/31"));
        doc.addLinea(new LineaInvestimento("LG01C", "Linea Total Core “Classe Bonus C", new Date("31/03/2012"), new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("LG01D","Linea Total Core “Classe Bonus D",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL01C","Linea Mix 50 Combinazione Obbligazionaria “Classe Bonus C",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL01D","Linea Mix 50 Combinazione Obbligazionaria “Classe Bonus D",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL02C","Linea Mix 50 Linea Mix 50 Combinazione Azionaria “Classe Bonus C",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL02D","Linea Mix 50 Combinazione Azionaria “Classe Bonus D",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL03C","Linea MultiSelection Combinazione obbligazionaria “Classe Bonus C",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL03D","Linea MultiSelection Combinazione obbligazionaria “Classe Bonus D",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL04C","Linea MultiSelection Combinazione azionaria “Classe Bonus C",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addLinea(new LineaInvestimento("CL04D","Linea MultiSelection Combinazione azionaria “Classe Bonus D",new Date("31/03/2012"),new Date("31/03/2048"), new Float(7), null));
        doc.addClasseBonus(new ClasseBonus("C",5,new Float(20.95)));
        doc.addClasseBonus(new ClasseBonus("D",10,new Float(11.29)));
        doc.addCostoRetrocesso(new CostoRetrocesso("Commissioni Di Gestione (Fondo interno",new Float(82.69)));
        doc.addCostoRetrocesso(new CostoRetrocesso("Commissioni Di Gestione (OICR",new Float(90.38)));
        return doc;
    }


    private static SelectionFund getHouse(String nome){
        SelectionFund selectionFund = new SelectionFund();
        selectionFund.setNome(nome);
        selectionFund.setPuntatore("A)");
        selectionFund.setFundhouses(Mock.getPack());
        return selectionFund;
    }
    
    
    public static List<Fundhouse> getPack(){
        Fundhouse pack = new Fundhouse();
        //pack.setFondo("OICR");
        pack.setNome("OICR: FONDITALIA");
        pack.setIsins(Mock.getIsin());
        List<Fundhouse> packs = new ArrayList<Fundhouse>();
        packs.add(pack);
        return packs;
    }

    public static List<Isin> getIsin(){
        Isin isin = new Isin();
        isin.setCodiceImpresa("ABC");
        isin.setSoggettoDelegataGestione(getDelegato());
        isin.setGestore(getGestore());
        isin.setDenominazioneCompletaComparto("FIDEURAM FUND MARSHALL WACE TOPS");
        isin.setCodiceImpresa("FOO2");
        isin.setCodiceIsin("LU0139057037");
        if(!anni3){
            isin.setRendimento(getRendimento());
            anni3=true;
        }else
            isin.setRendimento(getRendimento2());

        isin.addTers(Mock.getRapportoOP("2009"));
        isin.addTers(Mock.getRapportoOP("2010"));
        isin.addTers(Mock.getRapportoOP("2011"));
        //isin.setBarraGraph(getGraficoABarre());
        //isin.setBarra(new HackPathImageProvider("/develop/Fideuram/PROGETTI/MODULI/modulo.offerta.premium/src/main/resources/mock/Barra"+count+".jpg"));
        //isin.setLinea(new HackPathImageProvider("/develop/Fideuram/PROGETTI/MODULI/modulo.offerta.premium/src/main/resources/mock/Linea"+count+".jpg"));
        isin.addLineaGraph(getGraficoLinee(isin.getCodiceIsin()));
        isin.addLineaGraph(getGraficoLinee(isin.getCodiceIsin()));

        isin.setTipologia(getTipologia());
        isin.setPolitica(getPolitica());
        isin.setBenchmark(getBenchmark());

        count++;
        List<Isin> isins = new ArrayList<Isin>();
        isins.add(isin);
        return isins;
    }

    public static Rendimento getRendimento(){
        Rendimento r = new Rendimento();
        r.setUltimoAnnoSolareTrascorso("BLA");
        r.setPeriodoOsservazione("2");
       // r.addDatiRendimentos("FIDEURAM FUND COMMODITIES","12%",null,null);
       // r.addDatiRendimentos("Benchamrk","0,36%",null,null);
        r.setVolatilitaUltimoAnnoSolareExAnte("10%");
        r.setVolatilitaUltimoAnnoSolareExPost("15%");
        return r;
    }

    public static Rendimento getRendimento2(){
        Rendimento r = new Rendimento();
        r.setUltimoAnnoSolareTrascorso("BLA");
        r.setPeriodoOsservazione("3");
        //r.addDatiRendimentos("FIDEURAM FUND COMMODITIES","12%","2,7%",null);
        //r.addDatiRendimentos("Benchamrk","0,36%","1,9%",null);
        r.setPeriodoII("Ultimi 4 anni");
        r.setVolatilitaUltimoAnnoSolareExAnte("10%");
        r.setVolatilitaUltimoAnnoSolareExPost("15%");
        return r;
    }

    
    public static Ter getRapportoOP(String anno){
        Ter rap1 = new Ter();
        rap1.setAnno(anno);
        rap1.setAltriOneri("n.d");
        rap1.setCommissioniGestione("n.d.");
        //rap1.setCommissioniIncentivo("n.d.");
        rap1.setSpeseAmministrazioneCustodia("n.d.");
        rap1.setSpeseGiudiziarie("n.d.");
        rap1.setSpesePubblicazione("n.d.");
        rap1.setSpeseRevisioneCertificazionePatrimonio("n.d.");
        rap1.setTer("n.d.");
        rap1.setPesoCompravenditeStrumentiFinanziari("10%");
        return rap1;
    }
    


  /*  public static BarraBean getGraficoABarre(){
        BarraBean barraBean = new BarraBean();
        barraBean.setTitolo("Fonditalia Euro Yeld Plus classe T");
        barraBean.setX_axis("");
        barraBean.setY_axis("");
        barraBean.addDatiVo("FONDITALIA", Double.valueOf(-6),"2007" );
        barraBean.addDatiVo("FONDITALIA", Double.valueOf(9) ,"2008" );
        barraBean.addDatiVo("FONDITALIA", Double.valueOf(-3) ,"2009" );
        barraBean.addDatiVo("FONDITALIA", Double.valueOf(7) ,"2010" );
        barraBean.addDatiVo("FONDITALIA", Double.valueOf(19),"2011" );
        barraBean.addDatiVo("ML-GLOBAL", Double.valueOf(-6),"2007" );
        barraBean.addDatiVo("ML-GLOBAL", Double.valueOf(7) ,"2008" );
        barraBean.addDatiVo("ML-GLOBAL", Double.valueOf(8) ,"2009" );
        barraBean.addDatiVo("ML-GLOBAL", Double.valueOf(5) ,"2010" );
        barraBean.addDatiVo("ML-GLOBAL", Double.valueOf(12),"2011" );
        return barraBean;
    }*/

    public static LineaTimeBean getGraficoLinee(String isincode){
        LineaTimeBean ltb = new LineaTimeBean();
        ltb.setNome(isincode);
        ltb.setHeader("Header Ok?");
        ltb.addLinea(new String[]{"2007-01-01","2008-01-01","2009-01-01","2010-02-01"}, new Number[]{3,11,2,9},"Fideuram Comodities",true);
        ltb.addLinea(new String[]{"2009-01-01","2010-02-01"}, new Number[]{3, 4},"Down Jones",false);
        return ltb;
    }

    private static Tipologia getTipologia(){
        return new Tipologia("A benchmark di tipo passivo",
                "l'obbiettivo del comparto è una crescita nel lungo termine investendo in titoli della grande Cina",
                "USD","na","disclaimer!!!");
    }
    
    private static Politica getPolitica(){
        Politica p= new Politica();
        p.setCategoria("Azionario Paesi Emergenti");
        p.setOrizzonteTemporale("5-10 anni");
        p.setGradoRischio("Molto Alto");
        p.setGradoScostamentoBenchmark("Significativo");
        p.setStrumentiFinanziari("Il comparto investe almeno il 70%....");
        p.setValutaStrumentiFinanziari("Dollaro di Hong kong, Dollaro di Taiwan, Dollaro Statunitense");
        p.setArreeGeografiche("Cina, Hong Kong");
        p.setCategoriEmittenti("Società, Corporate");
        p.setSettoriIndustrialiRilevanti("Industria Beni di consumo");
        p.setInvestimentoQuoteAzioniFondiInterniOicr("n.d.");
        p.setFattoriDiRischio("Rischi di investimento in strumenti finanziari (può essere....");
        p.setStrumentiDerivati("Per informazioni si rinvia al prospetto informativo dell'OICR");
        p.setIndicizzazione("");
        p.setGaranzia("");
        p.setImmunizzazione("");
        p.setGestioneObiettivoRendimentoProtetta("");
        p.setTecninaDiGestione("");
        p.setTecninaDiGestioneRischio("");
        p.setTecninaDiGestioneRischioDettagli("");
        p.setDestinazioneProventi("Accumulazione");
        p.setPrecisazioniGestioneBenchmarkPassivoImmunizzato("");
        p.setPrecisazioneGestioneBenchmarkPassivo("");
        p.setVariazioniPoliticaInvestimento("");
        p.setVariazioniSoggettiIncaricati("");
        return p;
    }

    private static Benchmark getBenchmark(){
        return new Benchmark("MSC Golden Dragon (ND)",
                "Include tutte le classi di azioni cinesi, compresi i titoli di Hong Kong e Taiwan",
                "n.d.", "n.d.");
    }

}
