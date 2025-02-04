package com.fideuram.preventivo.mock;


import com.fideuram.config.CrmProperties;
import com.fideuram.file.manipolation.pdf.PdfMerge;
import com.fideuram.preventivo.modello.Capitale;
import com.fideuram.preventivo.modello.Dichiarazione;
import com.fideuram.preventivo.modello.Premi;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.modello.Questionario;
import com.fideuram.preventivo.servizi.FacadePreventivi;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.SegniParticolari;
import com.fideuram.utils.Streamer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 19/03/13
 * Time: 15.48
 */
public class TestTcmEvolutaBozzaQuestionarioCartaceo {
    public static void main(String args[]) throws Exception, URISyntaxException {

    	Preventivo preventivo = new Preventivo();
        preventivo.setBozza(true);
        if(!preventivo.getBozza())
            preventivo.setNumeroPreventivo("12536985");
        preventivo.setDataElaborazionePreventivo("04-12-2012");
        preventivo.setDataDecorrenza("10-12-2012");
        preventivo.setDurataContrattuale("10 anni");
        preventivo.setDataScadenza("04-12-2022");
       

        Contraente contraente = new Contraente();
        contraente.setNome("FRANCO");
        contraente.setCognome("NERO");
        contraente.setCodiceFiscale("NROFRN75B08U532R");
        contraente.setDataNascitaString("08-02-1975");
        contraente.setClassePatrimonioPotenziale("D");

        Assicurato assicurato = new Assicurato();
        assicurato.setNome("MARIA");
        assicurato.setCognome("ROSSI");
        assicurato.setCodiceFiscale("RSSMRA70H55T432Q");
        //assicurato.setDataDiNascita(Calendar.getInstance().getTime());
        assicurato.setDataNascitaString("15-08-1970");
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
        capitale.setCapitaleAssicuratoMalattiaGrave("100005.62");
        preventivo.setCapitale(capitale);

        Premi premi = new Premi();
        premi.setPremioAnnuoCostante("12000.00");
        premi.setPremioAnnuoCostanteComplessivo("15000.00");
        premi.setPremioAnnuoCostanteGaranzieComplementari("20000.00");
        premi.setPremioAnnuoCostanteGaranzieComplementariMalattiaGrave("25000.00");
        premi.setSovrappremioSanitario("1500.00");
        premi.setSovrappremioSportivo("750.00");
        premi.setRataLorda("17500.00");
        premi.setFrazionamento("annuale");
        preventivo.setPremi(premi);
        preventivo.setDataValiditaPreventivo("04-12-2022");


        ArrayList<Questionario> listQuestionario = new ArrayList<Questionario>();
        Questionario questionario = new Questionario();
        questionario.setIndice(1);
        questionario.setDomanda("PROVA");
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(2);
        questionario.setDomanda("PROVA");
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(3);
        questionario.setDomanda("PROVA");
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(4);
        questionario.setDomanda("PROVA");
        questionario.setRisposta("0");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(5);
        questionario.setDomanda("PROVA");
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        questionario = new Questionario();
        questionario.setIndice(6);
        questionario.setDomanda("PROVA");
        questionario.setRisposta("N");
        listQuestionario.add(questionario);

        preventivo.setQuestionario(listQuestionario);

        preventivo.setQuestionario(listQuestionario);
        byte[] stream = null;


            stream =  new FacadePreventivi().getDocumento(preventivo,"116");
            //System.out.println(i + " - " + stream);
            System.out.println(" - " + stream);
            
            File file = Streamer.saveToFile(stream, CrmProperties.getProperty("crm.services.temp.path"), "preventivoQuestionario2.pdf");
            
            	/*List<InputStream> list = new ArrayList<InputStream>();
            
            	// Documento generato
            	FileInputStream input = new FileInputStream(file);
                list.add(input);
                // PDF Allegato statico
                list.add(new FileInputStream(new File("C:\\app\\CRMStampe\\Rapp Visita Medica_FV02_2015_10.pdf")));
                
                // Resulting pdf
                OutputStream out = new FileOutputStream(new File("C:\\app\\CRMStampe\\temp\\merge\\merge.pdf"));
                PdfMerge.doMerge(list, out);*/

                
    }
}