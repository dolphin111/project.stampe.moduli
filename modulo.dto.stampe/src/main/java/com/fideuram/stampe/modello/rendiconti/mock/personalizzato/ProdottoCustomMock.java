package com.fideuram.stampe.modello.rendiconti.mock.personalizzato;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.rendiconti.Benchmark;
import com.fideuram.stampe.modello.rendiconti.Gestione;
import com.fideuram.stampe.modello.rendiconti.Rischio;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.grafici.linea.ElementoLinea;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.*;
import com.fideuram.stampe.modello.rendiconti.grafici.torta.EelementoTorta;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.AndamentoGrafico;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.Performance;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.ReportTemporale;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Composizione;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Posizione;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.*;
import com.fideuram.stampe.modello.utils.EncoderString;


import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 10.50
 */
public class ProdottoCustomMock {
    protected static Date getDataNav(){
        return   new GregorianCalendar(2014,11,28).getTime();
    }

    public static FondoInternoPersonalizzato getMock(String nomeProdotto){
        FondoInternoPersonalizzato fi =    new FondoInternoPersonalizzato();
        //fi.setNomeProdotto("Sarde a Beccafico");
        //fi.setNomeProdotto("beccaccia a punto croce");
        //fi.setNomeProdotto("Azzurra");
        fi.setNomeProdotto(nomeProdotto);
        setSchedaProdotto(fi);
        return fi;
    }



    protected static void setSchedaProdotto(FondoInternoPersonalizzato fi){
        Rischio r=new Rischio();
        r.setProfilo("Medio");
        VolatilitaProspettica v=new VolatilitaProspettica();
        v.setPercVolatilitaMaxAttesa("7,0");
        v.setRischio(r);


        fi.setTipoProdotto("Fondo Interno Assicurativo");
        fi.setDataPartenza(new Date());
        fi.setDataRiferimento(new Date());
        fi.setVolatilita(v);
        fi.setDivisa(new Divisa("Euro", "€"));
        fi.setNav(993.220);
        fi.setDataNav(getDataNav());
        fi.setGestione(new Gestione("Flessibile", "Obiettivo ...."));
        Benchmark ben=new Benchmark();
        ben.setPrevisto("previsto");
        fi.setBenchmark(ben);
        fi.setMacroAsset(getMacroAsset());
        //fi.setAssogestioni(getAssogestioni());
        fi.setScompGeo(getScompGeo());
        fi.setCompoObblg(getComposizioneObblig());
        fi.setStrumentiFinanziari(getStrumentiFinanziari());
        fi.setGestoriOicr(getGestoriOicr());
        fi.setPerformance(getPerformance());
        fi.setComposizione(getComposizione());
        fi.setInformazioniGenerali(getInfos());
       // fi.addMovimentoUltimoMese(getMovimento("BOT ANN 13 12 13 - 12 12 14"));
        //fi.addMovimentoUltimoMese(getMovimento("FIDEURAM 93 EQUITY JAPAN H"));

    }



    protected static MacroAsset getMacroAsset(){
        MacroAsset m =new MacroAsset();
        m.addElement(new EelementoTorta("Liquidità e strumetni monetari",33.33));
        m.addElement(new EelementoTorta("Obbligazionario",23.36));
        m.addElement(new EelementoTorta("Azionario",12.48));
        m.addElement(new EelementoTorta("Bilanciato",25.28));
        m.addElement(new EelementoTorta("Flessibile",5.55));
        return m;
    }

    protected static Assogestioni getAssogestioni(){
        Assogestioni m =new Assogestioni();
        m.addElement(new EelementoTorta("Obl. euro gov (titolo)",33.33));
        m.addElement(new EelementoTorta("prova1",23.36));
        m.addElement(new EelementoTorta("prova2",12.48));
        m.addElement(new EelementoTorta("prova3",5.28));
        m.addElement(new EelementoTorta("prova4",5.55));
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

    protected static Composizione getComposizione(){
        Composizione c= new Composizione();

        c.setDataRiferimento(new GregorianCalendar(2014,01,31).getTime());
        c.addPosizione(getPosizione("ETHNA AKTV E "));
        c.addPosizione(getPosizione("BoNY ACQUA EURO 788443 "));
        c.addPosizione(getPosizione("BOT ANN 13 12 13 - 12 12 14"));
        c.addPosizione(getPosizione("FIDEURAM 93 EQUITY JAPAN H"));
        c.addPosizione(getPosizione("ALSTOM S.A."));
        return c;
    }

    protected static Posizione getPosizione(String titolo){
        Posizione p = new Posizione();
        //p.setDescrizioneTitolo("ETHNA AKTV E " + i);
        p.setDescrizioneTitolo(titolo);
        p.setPeso(9.68);
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

    protected static InformazioniGenerali getInfos(){
        InformazioniGenerali i= new InformazioniGenerali();
        i.setCommentoaimercati(("Dopo i forti ritorni del 2013, i mercati azionari sviluppati aprono l'anno con variazioni negative, in seguito alle maggiori preoccupazioni sui paesi emergenti e a dati americani che suggeriscono una pausa di assestamento nel primo trimestre. Le valute dei paesi emergenti hanno generalmente sofferto, continuando un percorso iniziato con i primi commenti sulla riduzione degli acquisti da parte della FED. I paesi emergenti con le bilancie dei pagamenti più deboli sono stati quelli maggiormente colpiti e a queste preoccupazioni si sono aggiunti i timori di un rallentamento della Cina e della stabilità del suo sistema finanziario. I rendimenti dei mercati obbligazionari core come gli Stati Uniti sono scesi, mentre quello delle attività obbligazionarie a spread corporate hanno risentito della maggiore volatilità dei paesi emergenti. Su fronte degli utili aziendali i report trimestrali di fine anno segnalano negli Stati Uniti una progressione su livelli discreti ma con un reset negativo delle aspettative per il 2014. In Europa i risultati restano in generale ancora deboli, mentre sui mercati emergenti, le revisioni degli utili danno qualche timido segnale di miglioramento, dopo un lungo periodo di difficoltà."));
        i.setAssetallocartion(("Nel corso del mese la componente azionaria direzionale e quella flessibile a media volatilità...."));
        i.setOperazionidelmese(("Non sono state eseguite operazioni di Fund selection nel corso del mese."));
        return i;
    }

    protected static Movimento getMovimento(String titolo){
        Movimento m= new Movimento();
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
