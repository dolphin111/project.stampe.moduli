package com.fideuram.printer.previdenza;

import com.fideuram.stampe.modello.previdenza.versamenti.*;

import java.util.Date;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 16.22
 */
public class DistintaMock {
   public static VersamentiPrevidenza getMock(){
     VersamentiPrevidenza v = new VersamentiPrevidenza();
     Distinta distinta = new Distinta();
       distinta.setInLavorazione(true);
       distinta.setDataCreazione(new Date());
       distinta.setProgressivo("123312");
       distinta.setCompetenza("2014/07");
       distinta.setDescrizione("'Sti Oba Oba");

       DatoreLavoro datoreLavoro = new DatoreLavoro();
       datoreLavoro.setTotaleDipendenti(1);
         Contributi contributiTotali = new Contributi();
         contributiTotali.setTotale("404");
         contributiTotali.setTfr("154");
         contributiTotali.setDatore("250");
         contributiTotali.setIscritto("0");
       datoreLavoro.setContributiTotali(contributiTotali);
         Lavoratore lavoratore = new Lavoratore();
         lavoratore.setCf("rnpla.....");
         lavoratore.setCodice("3636746");
         lavoratore.setNome("Elena");
         lavoratore.setCognome("Guaglioncello");
         lavoratore.setContributi(contributiTotali);
       datoreLavoro.addLavoratore(lavoratore);


       lavoratore = new Lavoratore();
       lavoratore.setCf("rnpla.dddd....");
       lavoratore.setCodice("363674ddd6");
       lavoratore.setNome("Elena");
       lavoratore.setCognome("Guaglioncello222");
       lavoratore.setContributi(contributiTotali);
       datoreLavoro.addLavoratore(lavoratore);


       lavoratore = new Lavoratore();
       lavoratore.setCf("rnpla.dddd....");
       lavoratore.setCodice("363674ddd6222");
       lavoratore.setNome("Elena");
       lavoratore.setCognome("Guaglioncello222");
       lavoratore.setContributi(contributiTotali);
       datoreLavoro.addLavoratore(lavoratore);
       distinta.setDatoreLavoro(datoreLavoro);
       v.setDistinta(distinta);
        return   v;
   }

    public static  String getXml(){
        return "<VersamentiPrevidenza>\n" +
                "    <distinta>\n" +
                "       <inLavorazione>true</inLavorazione>\n" +
                "        <dataCreazione>2014-08-29T09:34:18.063+02:00</dataCreazione>\n" +
                "        <progressivo>201408290000001</progressivo>\n" +
                "        <datoreLavoro>\n" +
                "            <totaleDipendenti>0</totaleDipendenti>\n" +
                "            <contributiTotali>\n" +
                "                <tfr>0.0</tfr>\n" +
                "                <datore>0.0</datore>\n" +
                "                <iscritto>0.0</iscritto>\n" +
                "                <totale>0.0</totale>\n" +
                "            </contributiTotali>\n" +
                "        </datoreLavoro>\n" +
                "    </distinta>\n" +
                "</VersamentiPrevidenza>\n";
    }
}
