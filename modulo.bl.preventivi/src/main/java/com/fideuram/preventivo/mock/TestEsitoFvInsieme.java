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

public class TestEsitoFvInsieme {
    public static void main(String args[]) throws Exception, URISyntaxException {

    	PreventivoFVI preventivo = new PreventivoFVI();

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
        
        byte[] stream = null;


        stream =  new FacadePreventivi().getDocumento(preventivo,"120");
        //System.out.println(i + " - " + stream);
        System.out.println(" - " + stream);
        Streamer.saveToFile(stream, CrmProperties.getProperty("crm.services.temp.path"), "preventivo.pdf");

    }
}
