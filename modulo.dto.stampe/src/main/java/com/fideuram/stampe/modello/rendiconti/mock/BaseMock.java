package com.fideuram.stampe.modello.rendiconti.mock;

import com.fideuram.stampe.modello.rendiconti.Fondo;
import com.fideuram.stampe.modello.rendiconti.RendimentoAnnuo;
import com.fideuram.stampe.modello.rendiconti.RendimentoMensile;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.rendimento.RendimentoMedioAnnuo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created ..
 * User: V801068
 * Date: 10/01/14
 * Time: 16.22
 */
public class BaseMock {




    protected static List<Fondo> getFondi(String nome){
        List<Fondo> l=new ArrayList<Fondo>();
        for(int i=0;i<15;i++){
            Fondo fondo = new Fondo();
            fondo.setCodiceFondo(nome+"."+i);
            fondo.setDescrizioneFondo("descrizione " + nome);
            VolatilitaProspettica volatilitaProspettica=new VolatilitaProspettica();
            volatilitaProspettica.setPercVolatilitaProspettica("Compresa tra 1,60% e  3,99%");
            volatilitaProspettica.setPercVolatilitaEffettiva(04.00 + i);
            fondo.setVolatilitaProspettica(volatilitaProspettica);
            fondo.setRendimentoAnnuo(getRendimentoAnnuo());
            fondo.setValoreUnitarioQuota(getRendimentoMensile());
            l.add(fondo);
        }
        return l;
    }


    protected static List<RendimentoAnnuo> getRendimentoAnnuo(){
        List<RendimentoAnnuo> l=new ArrayList<RendimentoAnnuo>();
        for(int i=0;i<10;i++){
            RendimentoAnnuo r = new RendimentoAnnuo();
            r.setAnno(2000+i);
            r.setPercBM(-2.02+i+Math.random());
            r.setPercOldBM(0.25+i+Math.random());
            r.setPercFondo(-0.04+i+Math.random());
            l.add(r);
        }
        return l;
    }

    protected static List<RendimentoMensile> getRendimentoMensile(){
        List<RendimentoMensile> l=new ArrayList<RendimentoMensile>();
        for(int i=0;i<12;i++){
            RendimentoMensile r = new RendimentoMensile();
            r.setAnno(2013);
            r.setMese(1+i);
            r.setPercBM(0.2+i+Math.random());
            r.setPercOldBM(0.25+i+Math.random());
            r.setPercFondo(0.4+i+Math.random());
            l.add(r);
        }
        return l;
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

    protected double getRandom(){
        return Math.random();
    }

}
