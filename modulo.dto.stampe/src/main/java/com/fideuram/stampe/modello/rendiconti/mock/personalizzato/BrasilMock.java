package com.fideuram.stampe.modello.rendiconti.mock.personalizzato;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.rendiconti.Benchmark;
import com.fideuram.stampe.modello.rendiconti.Gestione;
import com.fideuram.stampe.modello.rendiconti.Rischio;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.grafici.linea.ElementoLinea;
import com.fideuram.stampe.modello.rendiconti.grafici.torta.EelementoTorta;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.FondoInternoPersonalizzato;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.InformazioniGenerali;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.Movimento;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.AndamentoGrafico;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.Performance;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.ReportTemporale;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Composizione;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Posizione;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.*;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: V801068
 * Date: 29/12/14
 * Time: 18.40
 *
 */
public class BrasilMock {
    protected static Date getDataPartenza(){
        return   new GregorianCalendar(2014,07,28).getTime();
    }

    protected static Date getDataNav(){
        return   new GregorianCalendar(2014,10,28).getTime();
    }
    public FondoInternoPersonalizzato getMockBrasil(String nomeProdotto){
        FondoInternoPersonalizzato fi =    new FondoInternoPersonalizzato();
        fi.setNomeProdotto("FVI BRASIL");
        setSchedaProdotto(fi);
        return fi;
    }

    protected static void setSchedaProdotto(FondoInternoPersonalizzato fi){
        Rischio r=new Rischio();
        r.setProfilo("Medio Alto");
        VolatilitaProspettica v=new VolatilitaProspettica();
        v.setPercVolatilitaMaxAttesa("Da 0,0399 A 0,1000");
        v.setRischio(r);
        fi.setTipoProdotto("Fondo Interno Assicurativo");
        fi.setDataPartenza(getDataPartenza());
        fi.setDataRiferimento(new Date());
        fi.setVolatilita(v);
        fi.setDivisa(new Divisa("Euro", "€"));
        fi.setNav(9.987);
        fi.setDataNav(getDataNav());
        fi.setGestione(new Gestione("Flessibile", "Obiettivo ...."));
        Benchmark ben=new Benchmark();
        ben.setPrevisto("previsto");
        fi.setBenchmark(ben);
        fi.setMacroAsset(getMacroAsset());
        fi.setScompGeo(getScompGeo());              //Pag 2
        fi.setCompoObblg(getComposizioneObblig());
        fi.setPerformance(getPerformance()); //Pag 3
       fi.setComposizione(getComposizione());//Pag 4

        fi.setScompGeo(getScompGeo());
        fi.setCompoObblg(getComposizioneObblig());
        fi.setStrumentiFinanziari(getStrumentiFinanziari());
        fi.setGestoriOicr(getGestoriOicr());
        fi.setPerformance(getPerformance());

        fi.setInformazioniGenerali(getInfos());
        fi.addMovimentoUltimoMese(getMovimento("BOT ANN 13 12 13 - 12 12 14"));
        fi.addMovimentoUltimoMese(getMovimento("FIDEURAM 93 EQUITY JAPAN H"));

        fi.setInformazioniGenerali(getInfos());           //Pag 5



    }



    protected static Composizione getComposizione(){


        Composizione c= new Composizione();
        c.setDataRiferimento(new GregorianCalendar(2014,03,03).getTime());
        Posizione p  =new Posizione ();


        p.setIsin("dasdjksajdkl");
        p.setDescrizioneTitolo("FRANK TEMP GLB BD-I-AC-H-1€ (TEGBIAH LX)");
        p.setPeso(1.50);
        p.setDiv(new Divisa("E","Eur"));
        p.setPrezzoStorico(17.88000051);
        p.setCambioStorico(1D);
        p.setPrezzoMercato(17.96);
        p.setCambioMercato(1D);
        c.addPosizione(p);


        return c;
    }

    protected static Posizione getPosizione(Posizione bean){
        Posizione p = new Posizione();
        p.setDescrizioneTitolo(bean.getDescrizioneTitolo());
        p.setPeso(new Double(bean.getPeso()));
        p.setPrezzoStorico(new Double(bean.getPrezzoStorico()));
        p.setCambioStorico(new Double(bean.getCambioStorico()));
        p.setPrezzoMercato(new Double(bean.getPrezzoMercato()));
        p.setCambioMercato(new Double(bean.getCambioMercato()));

      //  p.setPerformance(getPerformanceNuovaDeliMortacci());
        return p;
    }


    protected static InformazioniGenerali getInfos(){
        InformazioniGenerali i= new InformazioniGenerali();
        i.setCommentoaimercati(("Nel corso del mese di Agosto 2014 i mercati azionari internazionali hanno registrato un iniziale incremento della volatilità, con un ribasso veloce e profondo seguito da un recupero dei corsi che ha permesso ai mercati sviluppati di chiudere invariati rispetto ad inizio mese  e risultati positivi per quanto riguarda i mercati emergenti. I dati macro  mostrano una situazione non  omogenea nelle diverse aree geografiche, con gli Stati Uniti  avviati su un percorso di crescita stabile ma non elevata mentre l’Europa ha mostrato segnali di debolezza evidenti nel settore manifatturiero. Divergenze sono emerse in tal senso in occasione del simposio internazionale tenutosi a Jackson Hole in cui i presidenti delle diverse Banche centrali si sono riuniti.  La FED  ha confermato i progressi al di sopra delle aspettative del mercato del lavoro e dell’economia, ma evidenzia allo stesso tempo elementi di fragilità come il basso tasso di crescita dei salari  e aree di disoccupazione di lunga durata, elementi che non avvicinano per ora un incremento dei tassi nella prima parte del 2015. La BCE invece ha mostrato una piena disponibilità ad intervenire per sostenere la fragile crescita economica ed impedire che il fenomeno della deflazione danneggi  la congiuntura economica. Da questa situazione interlocutoria, la componente obbligazionaria europea ed americana ha visto un’ulteriore riduzione degli spread e dei rendimenti, in particolare  sulle scadenze più lunghe. Sul fronte delle commodity l’oro ha mostrato una certa stabilità mentre il petrolio ha continuato la dinamica discendente dei prezzi in corso già da due mesi riflettendo le incertezze relative alle prospettive di crescita globale. Discorso a parte il gas che, a fronte delle costanti incertezze geopolitiche tra Russia ed UE, ha visto i propri corsi subire un rialzo.\n"));
        i.setAssetallocartion(("La prima metà del mese ha visto un incremento della duration all'interno della componente obbligazionaria EMU, riducendo il monetario, e un incremento dell'azionario Europa. Nella seconda parte del mese si è incrementato l'azionario globale in coincidenza con la fase di debolezza sui mercati, e rafforzata la posizione sul dollaro USA tramite obbligazionario EM in hard currency"));
        i.setOperazionidelmese(("Non sono state eseguite operazioni di Fund selection nel corso del mese."));
        return i;
    }
    protected static MacroAsset getMacroAsset(){
        MacroAsset m =new MacroAsset();
        m.addElement(new EelementoTorta("Liquidità e strumetni monetari",33.33,"#F9B47B"));
        m.addElement(new EelementoTorta("Obbligazionario",23.36,"#F9B47B"));
        m.addElement(new EelementoTorta("Azionario",12.48,"#F9B47B"));
        m.addElement(new EelementoTorta("Bilanciato",25.28,"#F9B87B"));
        m.addElement(new EelementoTorta("Flessibile",5.55,"#F9B47B"));
        return m;
    }

    protected static Assogestioni getAssogestioni(){
        Assogestioni m =new Assogestioni();
        m.addElement(new EelementoTorta("Obl. euro gov (titolo)",33.33));
        m.addElement(new EelementoTorta("prova1",23.36));
        m.addElement(new EelementoTorta("prova2",12.48));
        m.addElement(new EelementoTorta("prova3",5.28));
        m.addElement(new EelementoTorta("prova4",5.55));

        m.addElement(new EelementoTorta("prova3",5.28));
        m.addElement(new EelementoTorta("prova4",5.55));
        m.addElement(new EelementoTorta("prova3",5.28));
        m.addElement(new EelementoTorta("prova4",5.55));
        m.addElement(new EelementoTorta("prova7",5.28));
        m.addElement(new EelementoTorta("prova8",5.55));
        return m;
    }

    protected static ScomposizioneGeografica getScompGeo(){
        ScomposizioneGeografica m =new ScomposizioneGeografica();
        m.addElement(new EelementoTorta("Obl. euro gov (titolo)",33.33));
        m.addElement(new EelementoTorta("prova1",23.36));
        m.addElement(new EelementoTorta("prova2",12.48));
        m.addElement(new EelementoTorta("prova3",5.28));
        m.addElement(new EelementoTorta("prova4",5.55));
        return m;
    }


    protected static ComposizioneObbligazionaria getComposizioneObblig(){
        ComposizioneObbligazionaria m =new ComposizioneObbligazionaria();
        m.addElement(new EelementoTorta("Obl. euro gov (titolo)",33.33));
        m.addElement(new EelementoTorta("prova1",23.36));
        m.addElement(new EelementoTorta("prova2",12.48));
        m.addElement(new EelementoTorta("prova3",25.28));
        m.addElement(new EelementoTorta("prova4",5.55));
        return m;
    }

    protected static StrumentiFinanziari getStrumentiFinanziari(){
        StrumentiFinanziari m =new StrumentiFinanziari();
        m.addElement(new EelementoTorta("strumento 1",33.33));
        m.addElement(new EelementoTorta("strumento 1",23.36));
        m.addElement(new EelementoTorta("strumento 2",12.48));
        m.addElement(new EelementoTorta("strumento 3",25.28));
        m.addElement(new EelementoTorta("strumento 4",5.55));
        return m;
    }

    protected static GestoriOicr getGestoriOicr(){
        GestoriOicr m =new GestoriOicr();
        m.addElement(new EelementoTorta("oicr 1",33.33));
        m.addElement(new EelementoTorta("oicr 1",23.36));
        m.addElement(new EelementoTorta("oicr 2",12.48));
        m.addElement(new EelementoTorta("oicr 3",25.28));
        m.addElement(new EelementoTorta("oicr 4",5.55));
        return m;
    }

    protected static Performance getPerformance(){
        Performance m =new Performance();
        AndamentoGrafico a=new AndamentoGrafico();
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,01,01).getTime(),190.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,02,01).getTime(),191.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,03,01).getTime(),189.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,04,01).getTime(),193.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,05,01).getTime(),188.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,06,01).getTime(),190.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,07,01).getTime(),191.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,8,01).getTime(),191.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,9,01).getTime(),191.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,10,01).getTime(),192.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,11,01).getTime(),193.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2013,12,01).getTime(),192.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,01,01).getTime(),191.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,02,01).getTime(),192.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,03,01).getTime(),193.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,04,01).getTime(),194.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,05,01).getTime(),193.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,06,01).getTime(),194.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,07,01).getTime(),192.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,8,01).getTime(),193.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,9,01).getTime(),194.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,10,01).getTime(),195.00));
        a.addElemento(new ElementoLinea("Prezzo netto quote",new GregorianCalendar(2014,11,01).getTime(),193.00));
        m.setAndamentoGrafico(a);
        m.setRendimentoAnnuo(getAnalisiPerformance());
        m.setVolatilitaAnnua(getAnalisiRischio());
        m.setModifiedDuration(2.00);
        return m;
    }

    protected static ReportTemporale getAnalisiPerformance(){
        ReportTemporale r =new ReportTemporale();
        r.setDaInizioAnno(-0.89);
        r.setDaInizioFondo(-0.68);
        r.setMese1(-0.74);
        r.setMese3(-0.60);
        r.setMese6(-0.22);
        r.setMese12(-1.04);
        return r;
    }

    protected static ReportTemporale getAnalisiRischio(){
        ReportTemporale r =new ReportTemporale();
        r.setDaInizioAnno(-3.89);
        r.setDaInizioFondo(-0.68);
        r.setMese1(-3.43);
        r.setMese3(-0.60);
        r.setMese6(-0.22);
        r.setMese12(-1.04);
        return r;
    }



    protected static Posizione getPosizione(String titolo){
        Posizione p = new Posizione();
        //p.setDescrizioneTitolo("ETHNA AKTV E " + i);
        p.setDescrizioneTitolo(titolo);
        p.setPeso(9.68);
        p.setIsin("21245");
        p.setPrezzoStorico(110.27);
        p.setCambioStorico(1.00);
        p.setPrezzoMercato(125.82);
        p.setCambioMercato(1.00);

        p.setPerformance(getPerformanceNuovaDeliMortacci());
        return p;
    }

    protected static Performance getPerformanceNuovaDeliMortacci(){
        Performance p = new Performance();
        ReportTemporale r1 = getAnalisiPerformance();
        r1.setYTD(-0.21);
        r1.setDataInPtf(13.23);
        p.setRendimentoAnnuo(r1);
        return p;
    }



    protected static Movimento getMovimento(String titolo){
        Movimento m= new Movimento();
        m.setIsin("121311");
        m.setDescrizioneTitolo(titolo);
        m.setDivisa(new Divisa("Euro","€"));
        m.setOperazione("Acquisto a contanti");
        m.setDataOperazione(new GregorianCalendar(2014,10,28).getTime());
        m.setDataValuta(new GregorianCalendar(2014,10,28).getTime());
        m.setDataBanca(new GregorianCalendar(2014,10,28).getTime());
        m.setValoreNominale(4500.00);
        m.setPrezzoOperazione(128.38);
        m.setValoreOperazione(418097.00);
        m.setPmRealizzo(0.00);
        m.setCambio(1.00);
        m.setPmCambio(0.00);
        m.setScartoEmissioni(0.00);
        return m;
    }
}
