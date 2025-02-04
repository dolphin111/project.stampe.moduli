package com.fideuram.stampe.modello.rendiconti.mock.personalizzato;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.rendiconti.Rischio;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.FondoInternoPersonalizzato;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.InformazioniGenerali;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.Movimento;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.Performance;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.ReportTemporale;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Composizione;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Posizione;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: V801068
 * Date: 29/12/14
 * Time: 18.34
 */
public class AzzurraMock extends MockVeroNonMock {
    protected static Date getDataPartenza(){
        return   new GregorianCalendar(2014,07,28).getTime();
    }

    protected static Date getDataNav(){
        return   new GregorianCalendar(2014,10,28).getTime();
    }
    public AzzurraMock() {
        super("Azzurra");
    }

    public  FondoInternoPersonalizzato getMock(){
        fi.setDataPartenza(new GregorianCalendar(2014,02,28).getTime());
        fi.setNav(10.49);
        fi.setVolatilita(getVolatilita());
        fi.setInformazioniGenerali(getInfos());


        fi.addMovimentoUltimoMese(getMovimento("BOT ANN 13 12 13 - 12 12 14"));     //todo
        fi.addMovimentoUltimoMese(getMovimento("FIDEURAM 93 EQUITY JAPAN H"));      //todo
        fi.setComposizione(getComposizione());                                      //todo
        return fi;
    }


    protected VolatilitaProspettica getVolatilita(){
        VolatilitaProspettica v=new VolatilitaProspettica();
        v.setPercVolatilitaMaxAttesa("From 0,0399 To 0,1000");
        v.setRischio(getRischio());
        return v;
    }

    protected Rischio getRischio(){
        Rischio r=new Rischio();
        r.setProfilo("Medio Alto");
        return r;
    }

    //todo
    protected  ReportTemporale getAnalisiPerformance(){
        ReportTemporale r =new ReportTemporale();
        r.setDaInizioAnno(-0.89);
        r.setDaInizioFondo(-0.68);
        r.setMese1(-0.74);
        r.setMese3(-0.60);
        r.setMese6(-0.22);
        r.setMese12(-1.04);
        return r;
    }


    protected  ReportTemporale getAnalisiRischio(){
        ReportTemporale r =new ReportTemporale();
        r.setDaInizioAnno(-3.89); //todo
        r.setDaInizioFondo(1.94);
        //todo r.setMese1(-3.43);
        //todo r.setMese3(-0.60);
        //todo r.setMese6(-0.22);
        //todo r.setMese12(-1.04);
        return r;
    }

    protected static InformazioniGenerali getInfos(){
        InformazioniGenerali i= new InformazioniGenerali();
        i.setCommentoaimercati(("Nel corso del mese di Agosto 2014 i mercati azionari internazionali hanno registrato un iniziale incremento della volatilità, con un ribasso veloce e profondo seguito da un recupero dei corsi che ha permesso ai mercati sviluppati di chiudere invariati rispetto ad inizio mese  e risultati positivi per quanto riguarda i mercati emergenti. I dati macro  mostrano una situazione non  omogenea nelle diverse aree geografiche, con gli Stati Uniti  avviati su un percorso di crescita stabile ma non elevata mentre l’Europa ha mostrato segnali di debolezza evidenti nel settore manifatturiero. Divergenze sono emerse in tal senso in occasione del simposio internazionale tenutosi a Jackson Hole in cui i presidenti delle diverse Banche centrali si sono riuniti.  La FED  ha confermato i progressi al di sopra delle aspettative del mercato del lavoro e dell’economia, ma evidenzia allo stesso tempo elementi di fragilità come il basso tasso di crescita dei salari  e aree di disoccupazione di lunga durata, elementi che non avvicinano per ora un incremento dei tassi nella prima parte del 2015. La BCE invece ha mostrato una piena disponibilità ad intervenire per sostenere la fragile crescita economica ed impedire che il fenomeno della deflazione danneggi  la congiuntura economica. Da questa situazione interlocutoria, la componente obbligazionaria europea ed americana ha visto un’ulteriore riduzione degli spread e dei rendimenti, in particolare  sulle scadenze più lunghe. Sul fronte delle commodity l’oro ha mostrato una certa stabilità mentre il petrolio ha continuato la dinamica discendente dei prezzi in corso già da due mesi riflettendo le incertezze relative alle prospettive di crescita globale. Discorso a parte il gas che, a fronte delle costanti incertezze geopolitiche tra Russia ed UE, ha visto i propri corsi subire un rialzo."));
        i.setAssetallocartion(("La prima metà del mese ha visto un incremento della duration all'interno della componente obbligazionaria EMU, riducendo il monetario, e un incremento dell'azionario Europa. Nella seconda parte del mese si è incrementato l'azionario globale in coincidenza con la fase di debolezza sui mercati, e rafforzata la posizione sul dollaro USA tramite obbligazionario EM in hard currency"));
        //todo
        i.setOperazionidelmese(("Non sono state eseguite operazioni di Fund selection nel corso del mese."));
        return i;
    }


    //todo
    protected Movimento getMovimento(String titolo){
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

    //todo
    protected  Composizione getComposizione(){
        Composizione c= new Composizione();

        c.setDataRiferimento(new GregorianCalendar(2014,01,31).getTime());
        c.addPosizione(getPosizione("ETHNA AKTV E "));
        c.addPosizione(getPosizione("BoNY ACQUA EURO 788443 "));
        c.addPosizione(getPosizione("BOT ANN 13 12 13 - 12 12 14"));
        c.addPosizione(getPosizione("FIDEURAM 93 EQUITY JAPAN H"));
        c.addPosizione(getPosizione("ALSTOM S.A."));
        return c;
    }

    protected  Posizione getPosizione(String titolo){
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

    protected  Performance getPerformanceNuovaDeliMortacci(){
        Performance p = new Performance();
        ReportTemporale r1 = getAnalisiPerformance();
        r1.setYTD(-0.21);
        r1.setDataInPtf(13.23);
        p.setRendimentoAnnuo(r1);
        return p;
    }
}
