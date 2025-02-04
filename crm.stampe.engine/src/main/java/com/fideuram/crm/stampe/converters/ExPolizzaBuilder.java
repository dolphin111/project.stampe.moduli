package com.fideuram.crm.stampe.converters;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.lettere.DescrizioniComuni;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.InfoPolizzaVO;
import com.fideuram.stampe.bean.prestito.Prestito;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.utils.StringUtils;


/**
 * @author Giuseppe Luciani
 * @author Giorgio Desideri
 *
 */
       // Quelli in testa sono gli  artisti che hanno dato sfogo al proprio genio
       // Il codice che segue è opera loro, nulla è stato aggiunto e non ci tengo
       // a prendermi meriti che non mi appartengono

public class ExPolizzaBuilder {
    public Polizza getPolizza(Polizza target, InfoPolizzaVO source){
        target.setValorePrestito(new Prestito(source.isPrestito()!=null?source.isPrestito():false)); //todo test con tck828

        target.setProdotto(source.getProdotto() != null ? source.getProdotto() : "");
        target.setMacroFamiglia(source.getMacroFamigliaID());

        // Prodotto Garantito
        target.setProdottoGarantito(source.getPodottoGarantito());
        target.setDataScadenzaOriginaria(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source.getDataScadenzaOriginaria())));

        //differimento
        if(source.getDurataPrimoDifferimento()>0)
            target.setPrimoDifferimento(source.getDurataPrimoDifferimento());
        else
            target.setPrimoDifferimento(new Long(source.getDurataDifferimento()!=null?source.getDurataDifferimento():"0"));

        target.setTotalePrestazioniCV(source.getTotalePrestazioniCV()!=null?source.getTotalePrestazioniCV().toString():"");


        target.setDescrizioneTariffa(StringUtils.blankString(source
                .getDescrizioneTariffa()));

        target.setDescrizioneCommerciale(StringUtils.blankString(source
                .getDescrizioneCommercialeProdotto()));

        target.setRamoMinisteriale(StringUtils.blankString(source
                .getRamoMinisteriale()));

        target.setTipoPrestazione(StringUtils.blankString(source
                .getTipoPrestazione()));

        target.setTipoFormaAssicurazione(StringUtils.blankString(source
                .getTipoFormaAssicurazione()));

        target.setDescrizioneFondoSintetica(StringUtils.blankString(source
                .getDescrizioneFondoSintetica()));

        target.setTipo(StringUtils.blankString(source.getTipoPolizza()));

        target.setClasse(StringUtils.blankString(source.getClasse()));

        target.setCodiceFondo(StringUtils.blankString(source
                .getDescrizioneFondoSintetica()));

        target.setCodiceGruppo(StringUtils.blankString(source.getGruppo()));

        target.setCodiceIngressoBase(StringUtils.blankString(source
                .getCodiceIngressoBase()));

        target.setCodiceIngresso(StringUtils.blankString(source
                .getCodiceIngresso()));

        target.setCodicePremio(StringUtils.blankString(source
                .getCodicePremio()));

        target.setCodiceTariffa(StringUtils.blankString(source
                .getCodiceTariffa()));

        target.setConferimento(StringUtils.blankString(source.getConferimento()));

        target.setControassicurazione(source.isControAssicurazione()!=null?source.isControAssicurazione():false);

        target.setDataEmissione(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source.getDataEmissione())));



        target.setDataFineDifferimento(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source.getDataFineDifferimento())));

        target.setDataErogazioneRendita(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source
                        .getDataErogazioneRenditaStimata())));

        target.setDataRicorrenza75(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source.getDataRic75Anno())));

        target.setDataRicorrenza80(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source.getDataRic80Anno())));

        target.setDataRicorrenza85(StringUtils.blankString(DateUtils
                .getNullSefeCalendar(source.getDataRic85Anno())));

        target.setRiservaMatematica(NumberUtils.getNullSefeCurrency(source
                .getRiservaMatematica()));

        if (("0" + Costanti.SEPARATORE_DECIMALI + "00").equals(target
                .getRiservaMatematica()))
            target.setRiservaMatematica("");

        if (("VI".equals(target.getClasse()) && ("A".equals(target.getCodicePremio())))
                || ("TE".equals(target.getClasse()))) {
            target.setDataScadenza(StringUtils.blankString(DateUtils
                    .getNullSefeCalendar(source
                            .getDataScadenzaPagamentoPremi())));
        }else if (("VI".equals(target.getClasse()) && ("U".equals(target.getCodicePremio())))) {
            target.setDataScadenza("");
        }else {
            target.setDataScadenza(StringUtils.blankString(DateUtils
                    .getNullSefeCalendar(source.getDataScadenzaPolizza())));
        }

        if ("1".equals(target.getRamoMinisteriale())) {
            target.setDataUltimaRivalutazioneFineDifferimento(StringUtils
                    .blankString(DateUtils.getNullSefeCalendar(source
                            .getDataUltimaRivautazione())));

            target.setDataUltimaRivalutazioneSistema(target
                    .getDataUltimaRivalutazioneFineDifferimento());

        }
        // per polizze UNIT LINKED
        else {
            target.setDataUltimaRivalutazioneFineDifferimento(DateUtils
                    .formatNow(Costanti.FORMATO_DATA));

            target.setDataUltimaRivalutazioneSistema(DateUtils
                    .formatNow(Costanti.FORMATO_DATA));
        }

        target.setCodiceSottostato(StringUtils.blankString(source
                .getSottostatoPolizza()));

        target.setStato(StringUtils.blankString(source.getStatoPolizza()));


        // Descrizione sottostato per esteso per lettera
        DescrizioniComuni.decodificaSottostato(target);

        target.setEccedenza(StringUtils.blankString(NumberUtils
                .getNullSefeCurrency(source.getEccedenza())));

        if (("0" + Costanti.SEPARATORE_DECIMALI + "00").equals(target.getEccedenza()))
            target.setEccedenza("");

        LoggingUtils.debug(" polizzaBuilder - codicesottostato : " + target.getCodiceSottostato());

        target.setReteVendita(StringUtils.blankString(source.getRete()));    //questo è il metodo preferito da Kakà ...e da Romario


        target.setVincoloPegno(source.isPegno()!=null?source.isPegno():false || source.isVincolo()!=null?source.isVincolo():false);

        target.setTipoLineaInvestimento(source.getTipoLineaInvestimento() != null ? source.getTipoLineaInvestimento(): "");

        if(target.getProdotto() != null){
            if(target.getProdotto().equals("RB0U1") || target.getProdotto().equals("RS0U1")){
                target.setPrestazioniAssicurate(false);
            }
        }

        LoggingUtils.debug("---- FINE ex buildPolizza(...) ----");

        return target;
    }
}
