package com.fideuram.stampe.modello.rendiconti.mock.personalizzato;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.rendiconti.Benchmark;
import com.fideuram.stampe.modello.rendiconti.Gestione;
import com.fideuram.stampe.modello.rendiconti.grafici.linea.ElementoLinea;
import com.fideuram.stampe.modello.rendiconti.grafici.torta.EelementoTorta;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.FondoInternoPersonalizzato;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.AndamentoGrafico;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.Performance;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.ReportTemporale;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.Assogestioni;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.ComposizioneObbligazionaria;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.MacroAsset;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.ScomposizioneGeografica;

import java.util.GregorianCalendar;

/**
 * User: V801068
 * Date: 29/12/14
 * Time: 19.19
 */
public abstract class MockVeroNonMock {
    FondoInternoPersonalizzato fi;

    public MockVeroNonMock(String nome) {
        this.fi = new FondoInternoPersonalizzato();
        fi.setNomeProdotto(nome);
        fi.setDataNav(new GregorianCalendar(2014, 10, 28).getTime());
        fi.setDivisa(new Divisa("Euro", "€"));
        fi.setGestione(new Gestione("Flessibile", "Obiettivo ...."));
        fi.setTipoProdotto("Fondo Interno Assicurativo");
        Benchmark ben=new Benchmark();
        ben.setPrevisto("previsto");
        fi.setBenchmark(ben);
        fi.setMacroAsset(getMacroAsset());
        fi.setScompGeo(getScompGeo());
        fi.setCompoObblg(getComposizioneObblig());
        fi.setPerformance(getPerformance());
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

    protected  ScomposizioneGeografica getScompGeo(){
        ScomposizioneGeografica m =new ScomposizioneGeografica();
        m.addElement(new EelementoTorta("Obl. euro gov (titolo)",33.33));
        m.addElement(new EelementoTorta("prova1",23.36));
        m.addElement(new EelementoTorta("prova2",12.48));
        m.addElement(new EelementoTorta("prova3",5.28));
        m.addElement(new EelementoTorta("prova4",5.55));
        return m;
    }


    protected  ComposizioneObbligazionaria getComposizioneObblig(){
        ComposizioneObbligazionaria m =new ComposizioneObbligazionaria();
        m.addElement(new EelementoTorta("Obl. euro gov (titolo)",33.33));
        m.addElement(new EelementoTorta("prova1",23.36));
        m.addElement(new EelementoTorta("prova2",12.48));
        m.addElement(new EelementoTorta("prova3",25.28));
        m.addElement(new EelementoTorta("prova4",5.55));
        return m;
    }

    protected Performance getPerformance(){
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

    protected abstract ReportTemporale getAnalisiPerformance();
    protected abstract ReportTemporale getAnalisiRischio();


}
