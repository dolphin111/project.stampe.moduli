package com.fideuram.printer.mock;

import com.fideuram.stampe.modello.attori.Compagnia;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 21/07/14
 * Time: 9.33
 * To change this template use File | Settings | File Templates.
 */
public class ContraenteMock {
    public static Individuo getContraente(){
        Individuo individuo=new Individuo();
        individuo.setCognome("Amanda");
        individuo.setNome("Rosa Maria");
        individuo.setCf("cccfiscalex501c");
        individuo.setIndirizzo(getIndirizzo());
        individuo.setSesso("F");
        individuo.setDataNascita(new Date());
        return individuo;
    }

    private static Recapito getIndirizzo(){
        Recapito recapito= new Recapito();
        recapito.setCap("00100");
        recapito.setProvincia("RM");
        recapito.setComune("Roma");
        recapito.setVia("Via della navicella 32");
        return recapito;
    }


    public static Individuo getAderente(){
        return getContraente();
    }
    public static Individuo getAssicurato(){
        return getContraente();
    }

    public static Individuo getPb(){
        Individuo individuo=new Individuo();
        individuo.setCognome("NeSckens");
        individuo.setNome("Joahn");
        individuo.setIndirizzo(getIndirizzo());
        return individuo;
    }

    public static Compagnia getCompagniaProvenienza(){
        Compagnia compagnia = new Compagnia();
        compagnia.setRagioneSociale("Allianz spa");
        compagnia.setIndirizzo(getIndirizzo());
        return compagnia;
    }

    public static Compagnia getCompagniaDestinazione(){
        return getCompagniaProvenienza();
    }
}



