package com.fideuram.printer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.fpa.DettaglioComparto;
import com.fideuram.stampe.modello.fpa.SimulatoriFPA;
import com.fideuram.stampe.modello.preventivi.Preventivo;
import com.fideuram.utils.LoggingUtils;

/**
 * User: V801068
 * Date: 22/07/14
 * Time: 8.22
 */
public class PrinterSimulatoriFPA  extends Printer {
    public PrinterSimulatoriFPA(SimulatoriFPA simulazione, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        simulazione.setAmmontarePosizioneIndividualeMaturata(formatStringDouble(simulazione.getAmmontarePosizioneIndividualeMaturata()));
        simulazione.setControvalore(formatStringDouble(simulazione.getControvalore()));
        if( simulazione.getListaComparti() ==  null || simulazione.getListaComparti().size() == 0 ) {
	        simulazione.setControvaloreReale(formatStringDouble(simulazione.getControvaloreReale()));
	        simulazione.setControvaloreGarantito(formatStringDouble(simulazione.getControvaloreGarantito()));
        }
        
        simulazione.setValoreLordoPrestazionePensionistica50(formatStringDouble(simulazione.getValoreLordoPrestazionePensionistica50()));
        simulazione.setValoreLordoPrestazionePensionistica100(formatStringDouble(simulazione.getValoreLordoPrestazionePensionistica100()));
        simulazione.getRenditaGarantita10Anni().setRateazioneAnnua(formatStringDouble(simulazione.getRenditaGarantita10Anni().getRateazioneAnnua()));
        simulazione.getRenditaGarantita10Anni().setRateazioneMensile(formatStringDouble(simulazione.getRenditaGarantita10Anni().getRateazioneMensile()));
        simulazione.getRenditaGarantita10Anni().setRateazioneSemestrale(formatStringDouble(simulazione.getRenditaGarantita10Anni().getRateazioneSemestrale()));
        simulazione.getRenditaGarantita10Anni().setRateazioneTrimestrale(formatStringDouble(simulazione.getRenditaGarantita10Anni().getRateazioneTrimestrale()));
        simulazione.getRenditaGarantita10Anni().setAmmontarePosizioneIndividualeMaturata(formatStringDouble(simulazione.getRenditaGarantita10Anni().getAmmontarePosizioneIndividualeMaturata()));
        
        
        simulazione.getRenditaGarantita5Anni().setRateazioneAnnua(formatStringDouble(simulazione.getRenditaGarantita5Anni().getRateazioneAnnua()));
        simulazione.getRenditaGarantita5Anni().setRateazioneMensile(formatStringDouble(simulazione.getRenditaGarantita5Anni().getRateazioneMensile()));
        simulazione.getRenditaGarantita5Anni().setRateazioneSemestrale(formatStringDouble(simulazione.getRenditaGarantita5Anni().getRateazioneSemestrale()));
        simulazione.getRenditaGarantita5Anni().setRateazioneTrimestrale(formatStringDouble(simulazione.getRenditaGarantita5Anni().getRateazioneTrimestrale()));
        simulazione.getRenditaGarantita5Anni().setAmmontarePosizioneIndividualeMaturata(formatStringDouble(simulazione.getRenditaGarantita5Anni().getAmmontarePosizioneIndividualeMaturata()));
        
        simulazione.getRenditaImmediata100().setRateazioneAnnua(formatStringDouble(simulazione.getRenditaImmediata100().getRateazioneAnnua()));
        simulazione.getRenditaImmediata100().setRateazioneMensile(formatStringDouble(simulazione.getRenditaImmediata100().getRateazioneMensile()));
        simulazione.getRenditaImmediata100().setRateazioneSemestrale(formatStringDouble(simulazione.getRenditaImmediata100().getRateazioneSemestrale()));
        simulazione.getRenditaImmediata100().setRateazioneTrimestrale(formatStringDouble(simulazione.getRenditaImmediata100().getRateazioneTrimestrale()));
        simulazione.getRenditaImmediata100().setAmmontarePosizioneIndividualeMaturata(formatStringDouble(simulazione.getRenditaImmediata100().getAmmontarePosizioneIndividualeMaturata()));
        
        simulazione.getRenditaImmediata50().setRateazioneAnnua(formatStringDouble(simulazione.getRenditaImmediata50().getRateazioneAnnua()));
        simulazione.getRenditaImmediata50().setRateazioneMensile(formatStringDouble(simulazione.getRenditaImmediata50().getRateazioneMensile()));
        simulazione.getRenditaImmediata50().setRateazioneSemestrale(formatStringDouble(simulazione.getRenditaImmediata50().getRateazioneSemestrale()));
        simulazione.getRenditaImmediata50().setRateazioneTrimestrale(formatStringDouble(simulazione.getRenditaImmediata50().getRateazioneTrimestrale()));
        simulazione.getRenditaImmediata50().setAmmontarePosizioneIndividualeMaturata(formatStringDouble(simulazione.getRenditaImmediata50().getAmmontarePosizioneIndividualeMaturata()));
        simulazione.setTotaleContributiVersatiNettiFondoGenerale(formatStringDouble(simulazione.getTotaleContributiVersatiNettiFondoGenerale()));
        simulazione.setNumeroQuote(formatStringQuote(simulazione.getNumeroQuote()));
        
        if(null != simulazione.getListaComparti()) {
        	simulazione.setValoreQuota("-");
        	List<DettaglioComparto> listaDettaglioComparti = simulazione.getListaComparti();
            for (DettaglioComparto dettaglioComparto : listaDettaglioComparti) {
            	dettaglioComparto.setControvalore(formatStringDouble(dettaglioComparto.getControvalore()));
            	dettaglioComparto.setControvaloreGarantito(formatStringDouble(dettaglioComparto.getControvaloreGarantito()));
            	dettaglioComparto.setNumeroQuote(formatStringQuote(dettaglioComparto.getNumeroQuote()));
            	dettaglioComparto.setValoreNav(formatStringDoubleNav(dettaglioComparto.getValoreNav()));
    		}
        } else {
        	List<DettaglioComparto> listaComparti = new ArrayList<DettaglioComparto>();
        	/*DettaglioComparto cmp = new DettaglioComparto();
        	cmp.setControvalore(simulazione.getControvalore());
        	cmp.setNumeroQuote(simulazione.getNumeroQuote());
        	cmp.setValoreNav(simulazione.getValoreQuota());
        	cmp.setDescrizioneComparto(simulazione.getFondoPensione());
        	listaComparti.add(cmp);*/
        	simulazione.setValoreQuota(formatStringDoubleNav(simulazione.getValoreQuota()));
        	simulazione.setListaComparti(listaComparti);
        }
        
       
        this.object = simulazione;
    }
    
    private String formatStringDouble(String param) {
    	DecimalFormat df = new DecimalFormat("#,##0.00");
    	return df.format(Double.parseDouble(param));
    }
    
    private String formatStringDoubleNav(String param) {
    	DecimalFormat df = new DecimalFormat("#,##0.000");
    	return df.format(Double.parseDouble(param));
    }
    
    private String formatStringQuote(String param) {
    	DecimalFormat df = new DecimalFormat("#,##0.00000");
    	return df.format(Double.parseDouble(param));
    }
}
