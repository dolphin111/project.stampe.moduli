package com.fideuram.preventivo.mock;

import com.fideuram.config.CrmProperties;
import com.fideuram.preventivo.modello.Capitale;
import com.fideuram.preventivo.modello.Premi;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.servizi.FacadePreventivi;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.SegniParticolari;
import com.fideuram.utils.Streamer;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDK on 17/07/2017.
 */
public class TestSintonia {

    public static void main(String args[]) throws Exception, URISyntaxException {


        Preventivo preventivo = mockA();
        preventivo.getContraente().setClassePatrimonioPotenziale("C");
        preventivo.setBozza(false);



        byte[] stream = null;

        stream =  new FacadePreventivi().getDocumento(preventivo,"113");
        //System.out.println(i + " - " + stream);
        System.out.println(" - " + stream);
        Streamer.saveToFile(stream, CrmProperties.getProperty("crm.services.temp.path"), "preventivo.pdf");




    }

    private static Preventivo mockA(){
        Preventivo preventivo = new Preventivo();
        preventivo.setNumeroPreventivo("12536985");

        preventivo.setNumeroProposta("125135235");
        preventivo.setDataElaborazionePreventivo("04/12/2012");
        preventivo.setDataDecorrenza("10/12/2012");
        preventivo.setDurataContrattuale("10 anni");
        preventivo.setDataScadenza("04/12/2022");

        Contraente contraente = new Contraente();
        contraente.setNome("FRANCO");
        contraente.setCognome("NERO");
        contraente.setCodiceFiscale("NROFRN75B08U532R");
        contraente.setDataNascitaString("08/02/1975");
        contraente.setClassePatrimonioPotenziale("D");

        Assicurato assicurato = new Assicurato();
        assicurato.setNome("MARIA");
        assicurato.setCognome("ROSSI");
        assicurato.setCodiceFiscale("RSSMRA70H55T432Q");
        //assicurato.setDataDiNascita(Calendar.getInstance().getTime());
        assicurato.setDataNascitaString("15/08/1970");
        assicurato.setSesso("Maschio");
        SegniParticolari segniParticolari = new SegniParticolari();
        segniParticolari.setEta("65");

        assicurato.setSegniParticolari(segniParticolari);
        preventivo.setContraente(contraente);
        preventivo.setAssicurato(assicurato);



        Premi premi = new Premi();


/*
        premi.setPremioAnnuoCostante("12000.00");
        premi.setPremioAnnuoCostanteComplessivo("15000.00");
        premi.setPremioAnnuoCostanteGaranzieComplementari("20000.00");
        premi.setSovrappremioSanitario("1500.00");
        premi.setSovrappremioSportivo("750.00");
        premi.setRataLorda("17500.00");
*/


        premi.setPremioUnico("2000000.00");
        premi.setQuotaGestioneSeparata(5000.00);
        premi.setPercentualePremioGS(2.50);
        premi.setSviluppoPerAnni(10);
        premi.setCarTot(0.5);


        Capitale capitale = new Capitale();

        List<Double> listCapitaleAssicuratoPerAnno = new ArrayList<Double>();
        for(int i =0;i<premi.getSviluppoPerAnni();i++)
            listCapitaleAssicuratoPerAnno.add(666666.01);

        List<Double> listCapitaleAssicuratoCasoMortePerAnnoA = new ArrayList<Double>();
        for(int i =0;i<premi.getSviluppoPerAnni();i++)
            listCapitaleAssicuratoCasoMortePerAnnoA.add(211221.01);

        List<Double> listCapitaleAssicuratoCasoMortePerAnnoB = new ArrayList<Double>();
        for(int i =0;i<premi.getSviluppoPerAnni();i++)
            listCapitaleAssicuratoCasoMortePerAnnoB.add(3123123.01);

        List<Double> listValoriRiscattoFineAnnoA = listCapitaleAssicuratoCasoMortePerAnnoA;

        List<Double> listValoriRiscattoFineAnnoB = listCapitaleAssicuratoCasoMortePerAnnoB;

        capitale.setCapitaleAssicuratoPerAnno( listCapitaleAssicuratoPerAnno );
        capitale.setCapitaleAssicuratoCasoMortePerAnnoA( listCapitaleAssicuratoCasoMortePerAnnoA ); // ipotesi a
        capitale.setCapitaleAssicuratoCasoMortePerAnnoB( listCapitaleAssicuratoCasoMortePerAnnoB ); // ipotesi b
        capitale.setValoriRiscattoFineAnnoA( listValoriRiscattoFineAnnoA );
        capitale.setValoriRiscattoFineAnnoB( listValoriRiscattoFineAnnoB );
        capitale.setCapitaleAssicurato("536165.4567");

        preventivo.setCapitale(capitale);


        preventivo.setPremi(premi);
        preventivo.setDataValiditaPreventivo("04/12/2022");


        preventivo.setComm(0.015);
        preventivo.setRmg(0.00);
        preventivo.setRla(0.00);
        preventivo.setRlb(0.02);
        preventivo.setRna(-0.015);
        preventivo.setRnb(0.005);


        /*List<RigaTabellaA> listRigaA = new ArrayList<RigaTabellaA>();
        List<RigaTabellaB> listRigaB = new ArrayList<RigaTabellaB>();

        for(int i=0;i<premi.getSviluppoPerAnni();i++){
            RigaTabellaA riga = new RigaTabellaA();

            riga.setSviluppoPerAnni( String.valueOf(i) );
            riga.setQuotaGestioneSeparata(preventivo.getPremi().getQuotaGestioneSeparata());
            riga.setCapitaleAssicuratoCasoMorteA( String.valueOf(preventivo.getCapitale().getCapitaleAssicuratoCasoMortePerAnnoA().get(i)) );
            riga.setValoriRiscattoFineAnnoA( String.valueOf(preventivo.getCapitale().getValoriRiscattoFineAnnoA().get(i)) );
        }

        for(int i=0;i<premi.getSviluppoPerAnni();i++){
            RigaTabellaB riga = new RigaTabellaB();

            riga.setSviluppoPerAnni( String.valueOf(i) );
            riga.setQuotaGestioneSeparata(preventivo.getPremi().getQuotaGestioneSeparata());
            riga.setCapitaleAssicuratoCasoMorteB( String.valueOf(preventivo.getCapitale().getCapitaleAssicuratoCasoMortePerAnnoB().get(i)) );
            riga.setValoriRiscattoFineAnnoB( String.valueOf(preventivo.getCapitale().getValoriRiscattoFineAnnoB().get(i)) );
        }*/

        return preventivo;
    }
}
