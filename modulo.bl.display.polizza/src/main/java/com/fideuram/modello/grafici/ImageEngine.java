package com.fideuram.modello.grafici;

import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.configuration.Gruppo;
import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.grafici.istogramma.SempliceMulticolor;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;
import com.fideuram.chart.grafici.istogramma.bean.Istogramma;
import com.fideuram.chart.grafici.linea.LineaSemplice;
import com.fideuram.chart.grafici.linea.bean.Linea;
import com.fideuram.chart.grafici.linea.bean.Punto;
import com.fideuram.chart.grafici.torta.TortaChartEngine;
import com.fideuram.chart.grafici.torta.bean.Fetta;
import com.fideuram.chart.grafici.torta.bean.Torta;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.chart.configuration.Colore;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.modello.polizza.finanziario.AndamentoControvalore;
import com.fideuram.modello.polizza.finanziario.AndamentoTir;
import com.fideuram.modello.polizza.finanziario.ComposizionePortafoglio;
import com.fideuram.modello.polizza.finanziario.Statistiche;
import com.fideuram.modello.polizza.finanziario.rendimentoFondi.Fondo;
import com.fideuram.modello.polizza.finanziario.rendimentoFondi.Statistica;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import com.fideuram.xdocreport.ImageProviderFactory;
import fr.opensagres.xdocreport.document.images.IImageProvider;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 14/07/13
 * Time: 10.36
 */
public class ImageEngine {
    private Polizza polizza;
    Configurazione configurazione;
    List filenames;

    String dir = "";

    public ImageEngine(Polizza polizza, String dir) {
        this(polizza);
        this.dir = dir;
    }

    public ImageEngine(Polizza polizza) {
        //dir=polizza.getDatiTecnici().getNumeroPolizza()+"_"+new Date().getTime()+"\\";
        this.polizza = polizza;
        Configurazione c = new Configurazione();
        c.setxPixelDimension(800);
        c.setyPixelDimension(450);
        c.setLegenda(false);
        this.configurazione = c;
        filenames = new ArrayList();
    }


    /**
     * SIAMO NEL TEMPLATE SALDI ASSET
     * STAMPA DEL GRAFICO DI TIPO BAR "Composizione del portafoglio per Andamento Finanziario""
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getAndamentoControvalore() throws Exception {
        configurazione.setFontSize(7);
        configurazione.setFontObliquo(true);
        configurazione.setPercentualeUpDowngridRange(5);
        Istogramma istogramma = new Istogramma();
        istogramma.setConfigurazione(configurazione);

        istogramma.setHeader("Andamento Finanziario");
        istogramma.setYaxis("Controvalore");
        Gruppo gruppo = new Gruppo(istogramma.getYaxis(), new Colore(69, 114, 167));


        List<AndamentoControvalore> andamentoControvalores = polizza.getFinanziario().getAndamentoControvalori().getAndamentoControvalores();
        if (andamentoControvalores.size() > 0) {
            for (int i = 0; i < andamentoControvalores.size(); i++) {
                AndamentoControvalore a = andamentoControvalores.get(i);
                istogramma.addBarElement(new BarElement(gruppo, Double.parseDouble(a.getValore().replace(".", "").replace(',', '.')), a.getNome()));
            }

            SempliceMulticolor sempliceMulticolor = new SempliceMulticolor();
            byte[] grafico = sempliceMulticolor.generate(istogramma);
            return getImageProvider(grafico, "bar_AssetClass_Polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
        } else {
            return null;
        }
    }

    public IImageProvider getAndamentoControvaloreISFV() throws Exception {
        configurazione.setFontSize(7);
        configurazione.setFontObliquo(true);
        configurazione.setPercentualeUpDowngridRange(5);
        Istogramma istogramma = new Istogramma();
        istogramma.setConfigurazione(configurazione);

        istogramma.setHeader("Andamento della componente United Linked");
        istogramma.setYaxis("Controvalore");
        Gruppo gruppo = new Gruppo(istogramma.getYaxis(), new Colore(69, 114, 167));


        List<AndamentoControvalore> andamentoControvalores = polizza.getFinanziario().getAndamentoControvalori().getAndamentoControvalores();
        if (andamentoControvalores.size() > 0) {
            for (int i = 0; i < andamentoControvalores.size(); i++) {
                AndamentoControvalore a = andamentoControvalores.get(i);
                istogramma.addBarElement(new BarElement(gruppo, Double.parseDouble(a.getValore().replace(".", "").replace(',', '.')), a.getNome()));
            }

            SempliceMulticolor sempliceMulticolor = new SempliceMulticolor();
            byte[] grafico = sempliceMulticolor.generate(istogramma);
            return getImageProvider(grafico, "bar_AssetClass_Polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
        } else {
            return null;
        }
    }

    /**
     * <br> Questo Metodo costruisce una grafico a barre (un istogramma)
     * <br> Relativo ai rendimenti Consolidati da inizio Gestione
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getBarraRendimentiConsolidatiInizioGestione() throws Exception {
        Istogramma istogramma = new Istogramma();
        istogramma.setHeader("Rendimenti consolidati per fondo da inizio gestione");
        istogramma.setYaxis("Rendimento %");
        List<Fondo> rendimento = polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi().getStatistiche();

        Gruppo gruppoG = new Gruppo("Rendimento Positivo", new Colore(0, 102, 51));
        if (rendimento.size() > 1) {
            for (int i = 0; i < rendimento.size(); i++) {
                Fondo fondo = rendimento.get(i);
                //prendo l'ultimo item delle serie statistiche (per capire meglio segui xml mock)
                Statistica s = fondo.getDati().getStatistiche().get(fondo.getDati().getStatistiche().size() - 1);
                istogramma.addBarElement(new BarElement(gruppoG, s.getValoreDaInizioGestione(), fondo.getDescrizione()));
            }
        } else if (rendimento.size() == 1) {
            return getImageProvider(andamentoLinea(polizza, 1), "barConsInizioGest_Polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
        }
        return getImmagineBarraRendimenti(istogramma);
    }

    /**
     * <br> Questo Metodo costruisce una grafico a barre (un istogramma)
     * <br> Relativo ai rendimenti Consolidati da inizio anno
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getBarraRendimentiConsolidatiInizioAnno() throws Exception {
        Istogramma istogramma = new Istogramma();
        istogramma.setHeader("Rendimenti consolidati per fondo da inizio anno");
        istogramma.setYaxis("Rendimento %");
        List<Fondo> rendimento = polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi().getStatistiche();

        Gruppo gruppoG = new Gruppo("Rendimento Positivo", new Colore(0, 102, 51));
        if (rendimento.size() > 1) {
            for (int i = 0; i < rendimento.size(); i++) {
                Fondo fondo = rendimento.get(i);
                Statistica s = fondo.getDati().getStatistiche().get(fondo.getDati().getStatistiche().size() - 1);
                istogramma.addBarElement(new BarElement(gruppoG, s.getValoreDaInizioAnno(), fondo.getDescrizione()));
            }
        } else if (rendimento.size() == 1) {
            return getImageProvider(andamentoLinea(polizza, 2), "barConsInizioAnno_Polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
        }
        return getImmagineBarraRendimenti(istogramma);
    }

    /**
     * <br> Questo Metodo costruisce una grafico a barre (un istogramma)
     * <br> Relativo ai rendimenti Consolidati da inizio trimestre
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getBarraRendimentiConsolidatiInizioTrimestre() throws Exception {
        Istogramma istogramma = new Istogramma();
        istogramma.setHeader("Rendimenti consolidati per fondo del trimestre");
        istogramma.setYaxis("Rendimento %");

        List<Fondo> rendimento = polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi().getStatistiche();
        Gruppo gruppoG = new Gruppo("Rendimento Positivo", new Colore(0, 102, 51));
        if (rendimento.size() > 1) {
            for (int i = 0; i < rendimento.size(); i++) {
                Fondo fondo = rendimento.get(i);
                Statistica s = fondo.getDati().getStatistiche().get(fondo.getDati().getStatistiche().size() - 1);
                istogramma.addBarElement(new BarElement(gruppoG, s.getValoreDelTrimestre(), fondo.getDescrizione()));
            }
        } else if (rendimento.size() == 1) {
            return getImageProvider(andamentoLinea(polizza, 3), "barConsInTrim_Polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
        }
        return getImmagineBarraRendimenti(istogramma);
    }

    private byte[] andamentoLinea(Polizza polizza, int periodo) throws GraphException, IOException {
        List<Statistica> rendimentoFondi = (List<Statistica>) polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi().getStatistiche().get(0).getDati().getStatistiche();
        Linea linea = new Linea();
        linea.setColore(new Colore(69, 114, 167));
        configurazione.setCurvedLine(true);
        configurazione.setBackColor(new Colore(255, 255, 255));
        configurazione.setGridColor(new Colore(0, 0, 0));
        configurazione.setLegenda(false);
        configurazione.setFontObliquo(true);
        configurazione.setxPixelDimension(800);
        configurazione.setFontSize(10);
        linea.setConfigurazione(configurazione);

        if (polizza.getPrevidenza() != null) {
            linea.setHeader("Rendimenti consolidati del Comparto");
        } else {
            linea.setHeader("Rendimenti consolidati del Fondo");
        }

        linea.setYaxis("Rendimento %");
        linea.setXaxis("");
        if (rendimentoFondi.size() > 0) {
            for (int i = 0; i < rendimentoFondi.size(); i++) {
                switch (periodo) {
                    case 1:
                        //questo è il caso da "da inizio gestione"
                        linea.addPunto(new Punto(rendimentoFondi.get(i).getData(), rendimentoFondi.get(i).getValoreDaInizioGestione()));
                        break;
                    case 2:
                        //questo è il caso da "da inizio anno"
                        linea.addPunto(new Punto(rendimentoFondi.get(i).getData(), rendimentoFondi.get(i).getValoreDaInizioAnno()));
                        break;
                    case 3:
                        //questo è il caso da "da inizio anno"
                        linea.addPunto(new Punto(rendimentoFondi.get(i).getData(), rendimentoFondi.get(i).getValoreDelTrimestre()));
                        break;
                }

            }
            return new LineaSemplice().generate(linea);
        } else {
            return null;
        }
    }


    /**
     * Questo metodo restituisce l'immagine dell'istogramma generata usando il grafico: SempliceMulticolor
     *
     * @param istogramma
     * @return
     * @throws Exception
     */
    private IImageProvider getImmagineBarraRendimenti(Istogramma istogramma) throws Exception {
        List<Fondo> rendimento = polizza.getFinanziario().getAndamentiRisultati().getStatisticheRendimentoAndamentoFondi().getStatistiche();

        configurazione.setyPixelDimension(500);
        configurazione.setOrientation(1);
        configurazione.setBackColor(new Colore(255, 255, 255));
        configurazione.setAlarmed(true);
        istogramma.setConfigurazione(configurazione);
        SempliceMulticolor sempliceMulticolor = new SempliceMulticolor();
        byte[] grafico = sempliceMulticolor.generate(istogramma);
        return getImageProvider(grafico, "barRendimenti_Polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
    }

    /**
     * SIAMO NEL TEMPLATE SALDI ASSET
     * STAMPA DEL GRAFICO DI TIPO TORTA "Composizione del portafoglio per Fondo OICR""
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getTortaFondoOicr() throws Exception {
        ComposizionePortafoglio portafoglioPerFondoOincr = polizza.getFinanziario().getComposizionePortafoglioPerFondoOICR();
        List<Statistiche> statistiches = portafoglioPerFondoOincr.getStatistiche();
        if (statistiches.size() > 0)
            return getTortaComposizionePortafoglio(statistiches, "Composizione del portafoglio per Fondo OICR", "FondoOicr");
        else
            return null;
    }

    /**
     * SIAMO NEL TEMPLATE SALDI ASSET
     * STAMPA DEL GRAFICO DI TIPO TORTA "Composizione del portafoglio per Asset Class""
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getTortaAssetClass() throws Exception {
        ComposizionePortafoglio portafoglioPerAssetClass = polizza.getFinanziario().getComposizionePortafoglioPerAssetClass();
        List<Statistiche> statistiches = portafoglioPerAssetClass.getStatistiche();
        if (statistiches.size() > 0)
            return getTortaComposizionePortafoglio(statistiches, "Composizione del portafoglio per Asset Class", "AssetClass");
        else
            return null;
    }


    /**
     * SIAMO NEL TEMPLATE ANDAMENTO RISULTATI
     * STAMPA DEL GRAFICO DI TIPO LINEA "Andamento Rendimento Polizza"
     *
     * @return
     * @throws Exception
     */
    public IImageProvider getLineaAndamentoRendimenti() throws Exception {
        List<AndamentoTir> andamentoTir = polizza.getFinanziario().getAndamentiRisultati().getAndamentoTir();
        Linea linea = new Linea();
        linea.setColore(new Colore(69, 114, 167));
        configurazione.setCurvedLine(true);
        configurazione.setBackColor(new Colore(255, 255, 255));
        configurazione.setGridColor(new Colore(0, 0, 0));
        configurazione.setLegenda(false);
        configurazione.setFontObliquo(true);
        configurazione.setxPixelDimension(800);
        configurazione.setFontSize(10);
        linea.setConfigurazione(configurazione);
        linea.setHeader("Andamento Rendimenti Polizza");
        linea.setYaxis("Percentuale");
        linea.setXaxis("");
        if (andamentoTir.size() > 0) {
            for (int i = 0; i < andamentoTir.size(); i++) {
                linea.addPunto(new Punto(andamentoTir.get(i).getDataToDate(), andamentoTir.get(i).getValoreToDouble()));
            }
            //byte[] grafico =new LineaMonthSemplice().generate(linea);
            byte[] grafico = new LineaSemplice().generate(linea);
            return getImageProvider(grafico, "lar" + polizza.getDatiTecnici().getNumeroPolizza());
        } else {
            return null;
        }
    }


    /**
     * @param statistiches
     * @param header
     * @return
     * @throws Exception
     */
    private IImageProvider getTortaComposizionePortafoglio(List<Statistiche> statistiches, String header, String nomeGrafico) throws Exception {
        configurazione.setFontSize(10);
        configurazione.setLegenda(false);   //TODO impostare a false se si vuole la legenda ancorata agli spicchi di aglio
        Color c;
        Torta torta = new Torta();
        torta.setConfigurazione(configurazione);
        for (int i = 0; i < statistiches.size(); i++) {
            Statistiche statistica = statistiches.get(i);
            if (statistica.getCodiceColore() != null) {
                c = Color.decode(statistica.getCodiceColore());
                torta.addFettas(new Fetta(statistica.getDescrizione() + " " + FormatterFactory.getStandardPercentuale(Double.parseDouble(statistica.getPercentuale())) + "%", Double.parseDouble(statistica.getPercentuale()), new Colore(c.getRed(), c.getGreen(), c.getBlue())));
            } else {
                torta.addFettas(new Fetta(statistica.getDescrizione() + " " + FormatterFactory.getStandardPercentuale(Double.parseDouble(statistica.getPercentuale())) + "%", Double.parseDouble(statistica.getPercentuale())));
            }
        }
        torta.setHeader(header);
        byte[] grafico = new TortaChartEngine().generate(torta);
        return getImageProvider(grafico, nomeGrafico + "_polizza_" + polizza.getDatiTecnici().getNumeroPolizza());
    }


    private IImageProvider getImageProvider(byte[] grafico, String nomeFile) throws Exception {
        if (null == grafico)
            return new ImageProviderFactory().getImageProvider(null);
       /* if(null==dir||dir.equals(""))
            dir= CrmProperties.getProperty("crm.services.temp.path");*/
        String filename = nomeFile + "_" + new Date().getTime() + ".png";
        filenames.add(filename);
        LoggingUtils.info("stampo il file :" + filename);

        StreamerFactory.saveFile(grafico, dir, filename);
        IImageProvider i = new ImageProviderFactory().getImageProvider(dir + filename);
        return i;
    }


    /**
     * @return
     * @throws Exception
     */
   /* private IImageProvider getImageProvider(byte[] grafico) throws Exception {
        if(null==grafico)
            return new ImageProviderFactory().getImageProvider(null);
        String pathfile= CrmProperties.getProperty("crm.services.temp.path");
        String filename=new Date().getTime()+".png";
        filenames.add(filename);
        LoggingUtils.info("stampo il file :" + filename);

        StreamerFactory.saveFile(grafico, pathfile, filename);
        IImageProvider i= new ImageProviderFactory().getImageProvider(pathfile+filename);
        return i;
    }
*/
    public void deletePNG() {
        for (int i = 0; i < filenames.size(); i++) {
            //String s= (String) filenames.get(i);
            String s = dir + (String) filenames.get(i);
            new File(s).deleteOnExit();
            LoggingUtils.info(s + "------------");
            LoggingUtils.info(s + "PNG DELETED");
            LoggingUtils.info(s + "-------------");
        }
    }


}
