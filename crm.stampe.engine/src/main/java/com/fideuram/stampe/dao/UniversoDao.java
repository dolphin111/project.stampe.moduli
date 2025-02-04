package com.fideuram.stampe.dao;

import com.fideuram.costanti.Costanti;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.crm.stampe.serviceclient.bi.WSPrestazioniAssicurateBean;
import com.fideuram.crm.stampe.serviceclient.universo.ClientUniverso;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created with
 * User: v801068
 * Date: 20/11/13
 * Time: 18.14
 */
public class UniversoDao {

    ClientUniverso  universoWs;
    String dataValutazione;

    public UniversoDao() throws WebServiceClientException {
        ClientWsFactory wsFactory = ClientWsFactory.getInstance();
        universoWs = wsFactory.getUniversoClient();
        dataValutazione = DateUtils.formatNow(Costanti.FORMATO_DATA);
    }


    /**
     * Questo metodo valorizza la poolizza con i dati delle prestazioni assicurate
     * @param p
     * @param tripletta
     * @return
     * @throws UniversoException
     */
    public void setPrestazioniAssicuraste(Polizza p, String tripletta)
            throws DaoException {

        p.setPrestazioniAssicurate(ValidatoreRichieste.validaPolizzaPerPrestaioniAssicurate(p));

        if(p.isPrestazioniAssicurate()){
            WSPrestazioniAssicurateBean bean= null;
            try {
                bean = universoWs.getPrestazioniAssicurate(p.getNumero(), dataValutazione);
            } catch (UniversoException e) {
                LoggingUtils.error(e);
                throw new DaoException(e);
            }
            if (bean != null) {
                NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
                try {
                       double bonus = ((Number) nf.parse(bean.getBonusCM())).doubleValue() + ((Number) nf.parse(bean.getBonusCV())).doubleValue();
                        p.setImportoBonus(NumberUtils.getNullSefeCurrency(bonus));
                } catch (ParseException e) {
                    p.setImportoBonus("");
                    LoggingUtils.error(e);
                }

                p.setImportoCasoMorteRivalutato(bean.getTotalePrestazioniCM());

                p.setImportoPrestazioniVita(bean.getTotalePrestazioniCV());
                p.setRenditaGarantita75(bean.getRendita75Anno());
                p.setRenditaGarantita80(bean.getRendita80Anno());
                p.setRenditaGarantita85(bean.getRendita85Anno());
                p.setCapitaleMalattiaGrave(bean.getCapitaleMalattiaGrave());
                p.setCapitaleMorteInfortunio(bean.getCapitaleMorteInfortunio());
                p.setCapitaleMorteInfortunioStradale(bean.getCapitaleMorteInfortunioStradale());
                p.setCapitaleSecondoDecesso(bean.getCapitaleSecondoDecesso());
                p.setMassimaleInfortunio(bean.getMassimaleInfortunio());
                p.setMassimaleMalattia(bean.getMassimaleMalattia());
            }
        }else{
            LoggingUtils.info("La polizza " + p.getNumero() + " non è valida per richiedere Le Prestazioni Assicurate");
            throw new DaoException("La polizza " + p.getNumero()+" non è valida per richiedere Le Prestazioni Assicurate. Stato e SottoSato sono:"+ p.getStato() +" "+p.getCodiceSottostato());
        }
    }
}
