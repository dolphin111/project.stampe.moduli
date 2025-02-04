package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato;

import com.fideuram.stampe.modello.contocorrente.Divisa;
import com.fideuram.stampe.modello.rendiconti.Benchmark;
import com.fideuram.stampe.modello.rendiconti.Gestione;
import com.fideuram.stampe.modello.rendiconti.VolatilitaProspettica;
import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.Performance;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione.Composizione;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.*;
import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * User: v801068
 * Date: 29/10/14
 * Time: 14.58
 */
@XmlRootElement(name="FondoPersonalizzato", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class FondoInternoPersonalizzato extends NormativaProdottoAllegato {
    private String                      nomeProdotto;
    private String                      tipoProdotto;            //Fondo interno assicurativo
    private Date                        dataPartenza;
    private VolatilitaProspettica       volatilita;
    private Double                      nav;                     //993,220   #Net asset value
    private Date                        dataNav;                 //31 Gennaio
    private Double                      patrimonio;
    private Divisa                      divisa;
    private Gestione                    gestione;
    private Benchmark                   benchmark;
    private MacroAsset                  macroAsset;
    private Assogestioni                assogestioni;
    private ScomposizioneGeografica     scompGeo;
    private ComposizioneObbligazionaria compoObblg;
    private Bluerating                  bluerating;
    private StrumentiFinanziari         strumentiFinanziari;
    private GestoriOicr                 gestoriOicr;
    private Performance                 performance;
    private Composizione                composizione;
    private InformazioniGenerali        informazioniGenerali;
    private List<Movimento>             movimentiUltimoMese;

    public boolean hasMovimenti(){
        return movimentiUltimoMese.size()>0?true:false;
    }

    public FondoInternoPersonalizzato() {
        movimentiUltimoMese=new ArrayList<Movimento>();
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public String getTipoProdotto() {
        return tipoProdotto;
    }

    /**
     * Override:
     * resttuisce la data in forma dd-mese-yyyy
     * @return
     */
    public String getDataRiferimento() {
        return FormattatoreDate.formatDate(dataRiferimento, FormattatoreDate.FORMATO_DATA_ESTESA_ITALIANA);
    }


    public String getDataPartenza() {
        return FormattatoreDate.formatDate(dataPartenza,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public VolatilitaProspettica getVolatilita() {
        return volatilita!=null?volatilita:new VolatilitaProspettica();
    }

    public String getNav() {
        return  FormattatoreCifre.formatQuota(nav, ".", ",");  //formatQuota è di default tre  decimali
    }

    public String getPatrimonio() {
        return  FormattatoreCifre.formatImporto(patrimonio, ".", ",");
    }


    public String getDataNav() {
        return FormattatoreDate.formatDate(dataNav,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public Divisa getDivisa() {
        return divisa!=null?divisa:new Divisa("Euro","€");
    }

    public Gestione getGestione() {
        return gestione;
    }


    public Benchmark getBenchmark() {
        return benchmark!=null?benchmark:new Benchmark();
    }

    public MacroAsset getMacroAsset() {
        return macroAsset;
    }

    public Assogestioni getAssogestioni() {
        return assogestioni;
    }

    public ScomposizioneGeografica getScompGeo() {
        return scompGeo;
    }

    public ComposizioneObbligazionaria getCompoObblg() {
        return compoObblg;
    }

    public Bluerating getBluerating() {
        return bluerating;
    }

    public StrumentiFinanziari getStrumentiFinanziari() {
        return strumentiFinanziari;
    }

    public GestoriOicr getGestoriOicr() {
        return gestoriOicr;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Composizione getComposizione() {
        return composizione;
    }

    public InformazioniGenerali getInformazioniGenerali() {
        return informazioniGenerali;
    }

    public List<Movimento> getMovimentiUltimoMese() {
        return movimentiUltimoMese;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public void setTipoProdotto(String tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    public void setDataPartenza(Date dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public void setVolatilita(VolatilitaProspettica volatilita) {
        this.volatilita = volatilita;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public void setPatrimonio(Double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public void setDataNav(Date dataNav) {
        this.dataNav = dataNav;
    }

    public void setDivisa(Divisa divisa) {
        this.divisa = divisa;
    }

    public void setGestione(Gestione gestione) {
        this.gestione = gestione;
    }

    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    public void setMacroAsset(MacroAsset macroAsset) {
        this.macroAsset = macroAsset;
    }

    public void setAssogestioni(Assogestioni assogestioni) {
        this.assogestioni = assogestioni;
    }

    public void setScompGeo(ScomposizioneGeografica scompGeo) {
        this.scompGeo = scompGeo;
    }

    public void setCompoObblg(ComposizioneObbligazionaria compoObblg) {
        this.compoObblg = compoObblg;
    }

    public void setBluerating(Bluerating bluerating) {
        this.bluerating = bluerating;
    }

    public void setStrumentiFinanziari(StrumentiFinanziari strumentiFinanziari) {
        this.strumentiFinanziari = strumentiFinanziari;
    }

    public void setGestoriOicr(GestoriOicr gestoriOicr) {
        this.gestoriOicr = gestoriOicr;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public void setComposizione(Composizione composizione) {
        this.composizione = composizione;
    }

    public void setInformazioniGenerali(InformazioniGenerali informazioniGenerali) {
        this.informazioniGenerali = informazioniGenerali;
    }

    public void addMovimentoUltimoMese(Movimento movimento) {
        this.movimentiUltimoMese.add(movimento);
    }
}
