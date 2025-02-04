package com.fideuram.modello.polizza.finanziario.rendimentoFondi;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.polizza.finanziario.DettaglioComposizioneInvestimentoRamo3;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 16.33
 */
public class DettaglioRendimentoFondoRamo3 extends DettaglioComposizioneInvestimentoRamo3 {
    //Ovviamente la extend è concettualmente sbagliata
    //ma essendo la modellazione ad oggetti ancora lontana del suo riconoscimento materiale
    //per non ridondare codice dati e oggetti faccio sta porcata che puzza poco meno
    //della modellazione ad esplosione molecolare

    private Double percentualeRendimentoDaInizioGestione;
    private Double percentualeRendimentoDaInizioAnno    ;
    private Double percentualeRendimentoDelTrimestre    ;
    private Double percentualeRendimentoDaInizioMese    ;
    private Double percentualeRendimentoDaSemestre      ;


    public Double getPercentualeRendimentoDaInizioGestioneToDouble() {
        return percentualeRendimentoDaInizioGestione;
    }

    public String getPercentualeRendimentoDaInizioGestione() {
        return percentualeRendimentoDaInizioGestione!=null?FormatterFactory.getStandardPercentuale(percentualeRendimentoDaInizioGestione):"";
    }

    public String getPercentualeRendimentoDaInizioAnno() {
        return percentualeRendimentoDaInizioAnno!=null?FormatterFactory.getStandardPercentuale(percentualeRendimentoDaInizioAnno):"";
    }

    public Double getPercentualeRendimentoDaInizioAnnoToDouble() {
        return percentualeRendimentoDaInizioAnno;
    }

    public String getPercentualeRendimentoDelTrimestre() {
        return percentualeRendimentoDelTrimestre!=null?FormatterFactory.getStandardPercentuale(percentualeRendimentoDelTrimestre):"";
    }

    public Double getPercentualeRendimentoDelTrimestreToDouble() {
        return percentualeRendimentoDelTrimestre;
    }

    public String getPercentualeRendimentoDaInizioMese() {
        return percentualeRendimentoDaInizioMese!=null?FormatterFactory.getStandardPercentuale(percentualeRendimentoDaInizioMese):"";
    }

    public String getPercentualeRendimentoDaSemestre() {
        return percentualeRendimentoDaSemestre!=null?FormatterFactory.getStandardPercentuale(percentualeRendimentoDaSemestre):"";
    }


}
