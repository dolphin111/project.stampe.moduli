package com.fideuram.prova;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.redditi.anagrafica.DomicilioFiscale;
import com.fideuram.stampe.modello.redditi.anagrafica.PercettoreSomme;
import com.fideuram.stampe.modello.redditi.anagrafica.ResidenzaEstero;
import com.fideuram.stampe.modello.redditi.anagrafica.SostitutoImposta;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;

import java.util.Date;

/**
 * User: V801068
 * Date: 07/01/16
 * Time: 17.12
 */
public class  AnagraficaMock {

    protected static SostitutoImposta getDL(){
        Recapito r= new Recapito();
        r.setTel_fax("+390635711/+390635714509");
        r.seteMail("relazioniclienti@fideuramvita.it");
        r.setVia(" VIA ENNIO QUIRINO VISCONTI 80");
        r.setCap("00193");
        r.setComune("ROMA");
        r.setProvincia("RM");

        SostitutoImposta dl = new SostitutoImposta();
        dl.setRagioneSociale("FIDEURAM VITA SPA");
        dl.setCf("10830461009");
        dl.setIndirizzo(r);
        dl.setCodAttivita("651100");
        return dl;
    }

    protected static PercettoreSomme getPS(){
        Familiare coniuge = new Familiare();
        coniuge.setTipoFamiliare(Familiare.FIGLIO);
        coniuge.setCf("xxxxxx00x00x000x");
        coniuge.setDetrazPercSpettante(10);
        coniuge.setNumeroMesiACarico(3);
        //coniuge.setDetrazTotaleAffidamento(100);

        Familiare primoFiglio = new Familiare();
        primoFiglio.setTipoFamiliare(Familiare.FIGLIO);
        primoFiglio.setCf("xxxxxx00x00x000x");
        primoFiglio.setNumeroMesiACarico(3);
        primoFiglio.setMinoreAnni3(false);
        primoFiglio.setDetrazPercSpettante(25);
        primoFiglio.setDetrazTotaleAffidamento(100);

        Familiare secFiglio = new Familiare();
        secFiglio.setTipoFamiliare(Familiare.FIGLIO);
        secFiglio.setCf("xxxxxx00x00x000x");
        secFiglio.setNumeroMesiACarico(3);
        secFiglio.setMinoreAnni3(false);
        secFiglio.setDetrazPercSpettante(25);
        secFiglio.setDetrazTotaleAffidamento(100);

        Familiare altro = new Familiare();
        altro.setTipoFamiliare(Familiare.ALTRO);
        altro.setDisabile(true);
        altro.setCf("xxxxxx00x00x000x");
        altro.setNumeroMesiACarico(12);
        altro.setMinoreAnni3(true);
        altro.setDetrazPercSpettante(25);
        altro.setDetrazTotaleAffidamento(100);

        FamiliariACarico fac=new FamiliariACarico();
        fac.setConiuge(coniuge);
        fac.setPrimoFiglio(primoFiglio);
        fac.addFamiliare(primoFiglio);
        fac.addFamiliare(secFiglio);
        fac.addFamiliare(altro);



        Individuo rappresntante=new Individuo();
        rappresntante.setCf("xxxxxx00x00x000x");

        DomicilioFiscale df=new DomicilioFiscale();
        df.setComune("VERCELLI");
        df.setProvincia("VC");
        df.setCodiceComune("L750");
        df.setVia(" VIA ENNIO 20");
        df.setCap("00183");

        ResidenzaEstero re=new ResidenzaEstero();
        re.setCfEstero("NL-ABC");
        re.setLocalita("AMSTERDAM-OLANDA");
        re.setViaenumero("PIAZZA DAM 2");
        re.setShumacker("X");
        re.setCodiceStatoEstero("050");

        PercettoreSomme percettore = new PercettoreSomme();
        percettore.setNome("MARIO");
        percettore.setCognome("CONNIZZOLI");
        percettore.setCf("CNNMLG41P15B910H");
        percettore.setSesso("M");
        percettore.setDataNascita(new Date());
        percettore.setComuneNascita("ROMA");
        percettore.setProvinciaNascita("RM");
        percettore.setCategorieParticolari("??");
        percettore.setEventiEccezionali("??");
        percettore.setCasiEsclusione("??");
        percettore.setDfAttuale(df);
        percettore.setDfAnnoPrecedente(df);
        percettore.setRappresentante(rappresntante);
        percettore.setFamiliariACarico(fac);
        percettore.setResidenzaEstero(re);

        return percettore;
    }
}
