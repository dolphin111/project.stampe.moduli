package com.fideuram.modello.grafici;


import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.utils.LoggingUtils;
import fr.opensagres.xdocreport.document.images.IImageProvider;

import java.util.List;


/**
 * Created with
 * User: logan
 * Date: 08/07/13
 * Time: 18.40
 */
public class Grafico {


    private Polizza polizza;

    private IImageProvider tortaAssetClass;

    private boolean presentLineaAndamentoRendimenti = false;
    private IImageProvider lineaAndamentoRendimenti;

    private boolean presentBarraRendimentiConsolidatiInizioGestione = false;
    private IImageProvider barraRendimentiConsolidatiInizioGestione;

    private boolean presentBarraRendimentiConsolidatiInizioAnno = false;
    private IImageProvider barraRendimentiConsolidatiInizioAnno;

    private boolean presentBarraRendimentiConsolidatiInizioTrimestre = false;
    private IImageProvider barraRendimentiConsolidatiTrimestre;

    private IImageProvider andamentoControvalore;
    private IImageProvider tortaFondoOicr;

    private String dir = null;


    public Grafico(Polizza polizza, String dir) throws DisplayPolizzaException {
        this.dir = dir;
        this.polizza = polizza;
        try {
            configura();
        } catch (Exception e) {
            LoggingUtils.error("Errore durare la generazione dei grafici");
            LoggingUtils.error(e);
            throw new DisplayPolizzaException("Errore durare la generazione dei grafici", e);
        }
    }


    /**
     * SIAMO NEL TEMPLATE ANDAMENTO RISULTATI
     * STAMPA DEL GRAFICO DI TIPO LINEA "Andamento Rendimento Polizza"
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getLineaAndamentoRendimenti() throws Exception {
        return lineaAndamentoRendimenti;
    }

    public IImageProvider getBarraRendimentiConsolidatiInizioGestione() {
        return barraRendimentiConsolidatiInizioGestione;
    }

    public IImageProvider getBarraRendimentiConsolidatiInizioAnno() {
        return barraRendimentiConsolidatiInizioAnno;
    }

    public IImageProvider getBarraRendimentiConsolidatiTrimestre() {
        return barraRendimentiConsolidatiTrimestre;
    }

    /**
     * SIAMO NEL TEMPLATE SALDI ASSET
     * STAMPA DEL GRAFICO DI TIPO TORTA "Composizione del portafoglio per Fondo OICR""
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getTortaFondoOicr() throws Exception {
        return tortaFondoOicr;
    }

    /**
     * SIAMO NEL TEMPLATE SALDI ASSET
     * STAMPA DEL GRAFICO DI TIPO TORTA "Composizione del portafoglio per Asset Class""
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getTortaAssetClass() throws Exception {
        return tortaAssetClass;
    }

    /**
     * SIAMO NEL TEMPLATE SALDI ASSET
     * STAMPA DEL GRAFICO DI TIPO BAR "Composizione del portafoglio per Andamento Finanziario""
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getAndamentoControvalore() throws Exception {
        return andamentoControvalore;
    }


    private void configura() throws Exception {
        int richiesta = polizza.getRichiestaDocumento().getRichiesta();
        switch (richiesta) {
            case (12):
                setTortaAssetClass();
                setTortaFondoOicr();
                setAndamentoControvalore();
                break;
            case (1201):
                setTortaAssetClass();
                setTortaFondoOicr();
                setAndamentoControvaloreISFV();
                break;
            case (11):
                setLineaAndamentoRendimenti();
                setRendimentiConsolidatiPerFondoDaInizioGestione();
                setRendimentiConsolidatiPerFondoDaInizioAnno();
                setRendimentiConsolidatiPerFondoDelTrimestre();
                break;

        }
    }


    //******************************************************************************SETTER
    public void setTortaAssetClass() throws Exception {
        ImageEngine imageEngine = new ImageEngine(polizza, dir);
        this.tortaAssetClass = imageEngine.getTortaAssetClass();
        //deletePNG(imageEngine);
        if (null == tortaAssetClass)
            LoggingUtils.info("IL GRAFICO << TORTA ASSET CLASS >> È NULL -----");
        else
            LoggingUtils.info("GENERATO GRAFICO << TORTA ASSET CLASS >> ");
    }

    public void setTortaFondoOicr() throws Exception {
        ImageEngine imageEngine = new ImageEngine(polizza, dir);
        this.tortaFondoOicr = imageEngine.getTortaFondoOicr();
        //deletePNG(imageEngine);
        if (null == tortaAssetClass)
            LoggingUtils.info("IL GRAFICO << TORTA FONDO OICR >>  È NULL -----");
        else
            LoggingUtils.info("GENERATO GRAFICO << TORTA FONDO OICR >> ");
    }

    public void setAndamentoControvalore() throws Exception {
        ImageEngine imageEngine = new ImageEngine(polizza, dir);
        this.andamentoControvalore = imageEngine.getAndamentoControvalore();
        //deletePNG(imageEngine);

        LoggingUtils.info("GENERATO GRAFICO << ISTOGRAMMA ANDAMENTO CONTROVALORE >>");
    }

    public void setAndamentoControvaloreISFV() throws Exception {
        ImageEngine imageEngine = new ImageEngine(polizza, dir);
        this.andamentoControvalore = imageEngine.getAndamentoControvaloreISFV();
        //deletePNG(imageEngine);

        LoggingUtils.info("GENERATO GRAFICO << ISTOGRAMMA ANDAMENTO CONTROVALORE  ISFV>>");
    }

    //INIZIO CASE 11 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void setLineaAndamentoRendimenti() throws Exception {
        ImageEngine imageEngine = new ImageEngine(polizza, dir);
        if (polizza.hasFinanziario() && polizza.getFinanziario().getAndamentiRisultati().getAndamentoTir() != null) {
            this.lineaAndamentoRendimenti = imageEngine.getLineaAndamentoRendimenti();
            presentLineaAndamentoRendimenti = true;
            //deletePNG(imageEngine);
            LoggingUtils.info("GENERATO GRAFICO << LINEA ANDAMENTO CONTROVALORE >>");
        } else {
            LoggingUtils.info("GRAFICO LINEA DI ANDAMENTI RISULTATI NON STAMPATO");
        }
    }

    public void setRendimentiConsolidatiPerFondoDaInizioGestione() throws Exception {
        if (polizza.hasFinanziario() && polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi() != null) {
            presentBarraRendimentiConsolidatiInizioGestione = true;
            ImageEngine imageEngine = new ImageEngine(polizza, dir);
            this.barraRendimentiConsolidatiInizioGestione = imageEngine.getBarraRendimentiConsolidatiInizioGestione();
            //deletePNG(imageEngine);
            LoggingUtils.info("GENERATO GRAFICO << RENDIMENTI CONSOLIDATI DA INIZIO GESTIONE >>");
        } else {
            LoggingUtils.info("GRAFICO NON GENERATO << RENDIMENTI CONSOLIDATI DA INIZIO GESTIONE >>");
        }
    }

    public void setRendimentiConsolidatiPerFondoDaInizioAnno() throws Exception {
        if (polizza.hasFinanziario() && polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi() != null) {
            presentBarraRendimentiConsolidatiInizioAnno = true;
            ImageEngine imageEngine = new ImageEngine(polizza, dir);
            this.barraRendimentiConsolidatiInizioAnno = imageEngine.getBarraRendimentiConsolidatiInizioAnno();
            //deletePNG(imageEngine);
            LoggingUtils.info("GENERATO GRAFICO << RENDIMENTI CONSOLIDATI DA INIZIO ANNO >>");
        } else {
            LoggingUtils.info("GRAFICO NON GENERATO  << RENDIMENTI CONSOLIDATI DA INIZIO ANNO >>");
        }

    }

    public void setRendimentiConsolidatiPerFondoDelTrimestre() throws Exception {
        if (polizza.hasFinanziario() && polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi() != null) {
            presentBarraRendimentiConsolidatiInizioTrimestre = true;
            ImageEngine imageEngine = new ImageEngine(polizza, dir);
            this.barraRendimentiConsolidatiTrimestre = imageEngine.getBarraRendimentiConsolidatiInizioTrimestre();
            //deletePNG(imageEngine);
            LoggingUtils.info("GENERATO GRAFICO << RENDIMENTI CONSOLIDATI DEL TRIMESTRE >>");
        } else {
            LoggingUtils.info("GRAFICO NON GENERATO  << RENDIMENTI CONSOLIDATI DEL TRIMESTRE >>");
        }
    }
    //FINE   CASE 11 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



    /*public void deletePNG(ImageEngine imageEngine){
          imageEngine.deletePNG();
    }*/


    public boolean isPresentLineaAndamentoRendimenti() {
        return presentLineaAndamentoRendimenti;
    }

    public boolean isPresentBarraRendimentiConsolidatiInizioGestione() {
        return presentBarraRendimentiConsolidatiInizioGestione;
    }

    public boolean isPresentBarraRendimentiConsolidatiInizioAnno() {
        return presentBarraRendimentiConsolidatiInizioAnno;
    }

    public boolean isPresentBarraRendimentiConsolidatiInizioTrimestre() {
        return presentBarraRendimentiConsolidatiInizioTrimestre;
    }
}
