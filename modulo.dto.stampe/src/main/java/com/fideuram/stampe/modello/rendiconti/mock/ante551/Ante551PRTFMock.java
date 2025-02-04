package com.fideuram.stampe.modello.rendiconti.mock.ante551;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.Fondo;
import com.fideuram.stampe.modello.rendiconti.Ter;
import com.fideuram.stampe.modello.rendiconti.Turnover;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Prtf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created
 * User: v801068
 * Date: 27/01/14
 * Time: 10.49
 */
public class Ante551PRTFMock extends BaseMock {

    public static Prtf getPrtfMock(){
        Prtf prtf = new Prtf();
        prtf.setDataRiferimento(new Date());
        prtf.setFondi(getFondi(""));
        return prtf;
    }



    protected static List<Fondo> getFondi(String nome){
        List<Fondo> listafondi =new ArrayList<Fondo>();
        for(int i=0;i<3;i++){
            Fondo fondo = new Fondo();

            if(i==0){
                fondo.setCodiceFondo(nome+"PORTFOLIO PRUDENTE");
                fondo.setDescrizioneFondo("PORTFOLIO PRUDENTE");
            }if(i==1){
                fondo.setCodiceFondo(nome+"PORTFOLIO SICURO");
                fondo.setDescrizioneFondo("PORTFOLIO SICURO");
            }if(i==2){
                fondo.setCodiceFondo(nome+"PORTFOLIO AGGRESSIVO");
                fondo.setDescrizioneFondo("PORTFOLIO AGGRESSIVO");
            }

            VolatilitaProspettica volatilitaProspettica=new VolatilitaProspettica();
            volatilitaProspettica.setPercVolatilitaEffettiva(04.00 + i);
            fondo.setVolatilitaProspettica(volatilitaProspettica);
            fondo.setRendimentoAnnuo(getRendimentoAnnuo());
            fondo.setValoreUnitarioQuota(getRendimentoMensile());
            fondo.getTer().add(getTer(0+i));
            fondo.getTer().add(getTer(1+i));
            fondo.getTer().add(getTer(2+i));
            fondo.getTurnover().add(getTurnover(0+i));
            fondo.getTurnover().add(getTurnover(1+i));
            fondo.getTurnover().add(getTurnover(2+i));
            listafondi.add(fondo);
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
}
