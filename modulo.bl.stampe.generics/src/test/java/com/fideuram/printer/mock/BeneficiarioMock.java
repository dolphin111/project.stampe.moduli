package com.fideuram.printer.mock;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;

import java.util.Date;


/**
 * User: V801068
 * Date: 18/06/15
 * Time: 14.21
 */
public class BeneficiarioMock {



    public static Individuo getNuovoBenficiario(){
        Individuo individuo=new Individuo();
        individuo.setCognome("Caledonia");
        individuo.setNome("Nuova Maria");
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

}
