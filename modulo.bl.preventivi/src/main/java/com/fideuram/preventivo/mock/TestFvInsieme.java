package com.fideuram.preventivo.mock;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fideuram.config.CrmProperties;
import com.fideuram.preventivo.modello.Capitale;
import com.fideuram.preventivo.modello.Premi;
import com.fideuram.preventivo.modello.PremiFVI;
import com.fideuram.preventivo.modello.PreventivoFVI;
import com.fideuram.preventivo.modello.Questionario;
import com.fideuram.preventivo.servizi.FacadePreventivi;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.SegniParticolari;
import com.fideuram.utils.Streamer;

public class TestFvInsieme {
    public static void main(String args[]) throws Exception, URISyntaxException {

    	PreventivoFVI preventivo = new PreventivoFVI();
        preventivo.setBozza(true);
        if(preventivo.getBozza())
            preventivo.setNumeroPreventivo("12536985");
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
        segniParticolari.setPeso("52");
        segniParticolari.setAltezza("160");
        segniParticolari.setEta("65");

        assicurato.setSegniParticolari(segniParticolari);
        preventivo.setContraente(contraente);
        preventivo.setAssicurato(assicurato);

        Capitale capitale = new Capitale();
        capitale.setCapitaleAssicurato("120000.00");
        capitale.setCapitaleAssicuratoMorteInfortunio("150000.00");
        capitale.setCapitaleAssicuratoMorteInfortunioStradale("100000.52");
        preventivo.setCapitale(capitale);

        Premi premi = new Premi();
        premi.setPremioAnnuoCostante("12000.00");
        premi.setPremioAnnuoCostanteComplessivo("15000.00");
        premi.setPremioAnnuoCostanteGaranzieComplementari("20000.00");
        premi.setSovrappremioSanitario("1500.00");
        premi.setSovrappremioSportivo("750.00");
        premi.setRataLorda("17500.00");
        preventivo.setPremi(premi);
        preventivo.setDataValiditaPreventivo("04/12/2022");

        ArrayList<Questionario> listQuestionario = new ArrayList<Questionario>();
        Questionario questionario = new Questionario();
        questionario.setIndice(1);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(2);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(3);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(4);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(5);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(6);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(7);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(8);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(9);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(10);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(11);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(12);
        questionario.setRisposta("S");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(13);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(14);
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(15);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(16);
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(17);
        questionario.setRisposta("S");
        listQuestionario.add(questionario);

        preventivo.setQuestionario(listQuestionario);

        preventivo.setQuestionario(listQuestionario);
        
        List<PremiFVI> listPremiFV = new ArrayList<PremiFVI>();
        PremiFVI premiFV = null;
        for(int i=0;i<10;i++){
        	premiFV = new PremiFVI();        	
        	premiFV.setEta(i);
        	premiFV.setDataDiDecorrenza(new Date());
        	premiFV.setPremioAnnuoCostanteComplessivo(new Double(i).doubleValue());
        	listPremiFV.add(premiFV);
        }
        preventivo.setPremiFV(listPremiFV);
        
        byte[] stream = null;


            stream =  new FacadePreventivi().getDocumento(preventivo,"119");
            //System.out.println(i + " - " + stream);
            System.out.println(" - " + stream);
            Streamer.saveToFile(stream, CrmProperties.getProperty("crm.services.temp.path"), "preventivo.pdf");




    }
}
