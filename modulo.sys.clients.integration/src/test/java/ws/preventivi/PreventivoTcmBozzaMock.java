package ws.preventivi;



import com.fideuram.stampeservice.*;

import java.util.ArrayList;

/**
 * Created by
 * User: logan
 * Date: 19/03/13
 * Time: 15.48
 */
public class PreventivoTcmBozzaMock {
     public static Preventivo getMock(){

            Preventivo preventivo = new Preventivo();
            preventivo.setBozza(false);

            preventivo.setDataElaborazionePreventivo("04/12/2012");
            preventivo.setDataDecorrenza("10/12/2012");
            preventivo.setDurataContrattuale("10 anni");
            preventivo.setDataScadenza("04/12/2022");

            Contraente contraente = new Contraente();
            contraente.setNome("FRANCO");
            contraente.setCognome("NERO");
            contraente.setCodiceFiscale("NROFRN75B08U532R");
            contraente.setDataNascitaString("08/02/1975");

            Assicurato assicurato = new Assicurato();
            assicurato.setNome("MARIA");
            assicurato.setCognome("ROSSI");
            assicurato.setCodiceFiscale("RSSMRA70H55T432Q");
            assicurato.setDataNascitaString("15/08/1970");
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
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(2);
            questionario.setRisposta("0");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(3);
            questionario.setRisposta("0");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(4);
            questionario.setRisposta("0");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(5);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(6);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(7);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(8);
            questionario.setRisposta("0");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(9);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(10);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(11);
            questionario.setRisposta("0");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(12);
            questionario.setRisposta("S");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(13);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(14);
            questionario.setRisposta("0");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(15);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(16);
            questionario.setRisposta("N");
            preventivo.getQuestionario().add(questionario);

            questionario = new Questionario();
            questionario.setIndice(17);
            questionario.setRisposta("S");
            preventivo.getQuestionario().add(questionario);


        return preventivo;




    }
}
