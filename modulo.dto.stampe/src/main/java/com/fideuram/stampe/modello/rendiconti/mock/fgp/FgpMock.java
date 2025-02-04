package com.fideuram.stampe.modello.rendiconti.mock.fgp;

import com.fideuram.stampe.modello.rendiconti.Fondo;
import com.fideuram.stampe.modello.rendiconti.Ter;
import com.fideuram.stampe.modello.rendiconti.Turnover;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;
import com.fideuram.stampe.modello.rendiconti.rendimento.RendimentoMedioAnnuo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created
 * User: v801068
 * Date: 31/01/14
 * Time: 12.41
 */
public class FgpMock extends BaseMock {
    public static Fgp getMock(){
        Fgp fgp = new Fgp();
        fgp.setDataRiferimento(new Date());
        fgp.setFondi(getFondi(2006, 2016, "FGP"));
        return fgp;
    }


    protected static List<Fondo> getFondi(int da, int a, String nome){
        int contatore=0;
        List<Fondo> listafondi =new ArrayList<Fondo>();
        for(int i=0;i<30;i++){
            if(contatore==5){
                contatore=0;
                da=da+1;
            }
            Fondo fondo = new Fondo();
            fondo.setCodiceFondo(nome+"  "+da+"-"+(a+contatore));
            fondo.setDescrizioneFondo(nome + "  " + da + "-" + (a + contatore));
            //fondo.set("01/01/2014 - 31/12/2016");
            fondo.setInizioOperativita(new Date("01/01/2014"));
            fondo.setScadenzaOperativita(new Date("31/12/2016"));

            VolatilitaProspettica volatilitaProspettica=new VolatilitaProspettica();
            volatilitaProspettica.setPercVolatilitaEffettiva(04.00 + i);
            fondo.setVolatilitaProspettica(volatilitaProspettica);
            fondo.setRendimentoAnnuo(getRendimentoAnnuo());
            fondo.setValoreUnitarioQuota(getRendimentoMensile());
            fondo.getTer().add(getTer(0 + i));
            fondo.getTer().add(getTer(1+i));
            fondo.getTer().add(getTer(2+i));
            fondo.getTurnover().add(getTurnover(0 + i));
            fondo.getTurnover().add(getTurnover(1+i));
            fondo.getTurnover().add(getTurnover(2+i));
            fondo.setRendimentoMedioAnnuo(getRendimentoMedioAnnuo());
            listafondi.add(fondo);

            contatore++;
        }
        return listafondi;
    }

    private static Ter getTer(int i){
        Ter t = new Ter();
        t.setAnno(2011 + i);
        t.setTer(new Double(2.4777 + i));
        t.setCommGestione(new Double(0.995 + i));
        t.setTerOicrSottostanti(new Double(1.414 + i));
        t.setSpeseRevisioneCertificataFondo(new Double(0.008 + i));
        t.setCostoGaranziaCasoMorte(new Double(0.050 + i));
        t.setSpesePubblicazioneQuota(new Double(0.050 + i));
        return t;
    }

    private static Turnover getTurnover(int i){
        Turnover t = new Turnover();
        t.setAnno(2011 + i);
        t.setTurnover(new Double(0.050 + i));
        return t;
    }

    protected static RendimentoMedioAnnuo getRendimentoMedioAnnuo(){
        RendimentoMedioAnnuo r= new RendimentoMedioAnnuo();
        r.setUltimi3anni(new Double(15));
        r.setUltimi5anni(new Double(15.04));
        r.setUltimoanno(new Double(0.3));
        r.setDataUltimoanno(2011);
        r.setUltimi2anni(new Double(1.00));
        r.setDataPenultimoanno(2012);
        return r;
    }
}
