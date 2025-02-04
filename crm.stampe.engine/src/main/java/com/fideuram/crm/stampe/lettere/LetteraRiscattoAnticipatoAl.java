package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;

import java.text.ParseException;


/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraRiscattoAnticipatoAl extends LetteraEngine{

    public LetteraRiscattoAnticipatoAl(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
     * @param dest
     * @param domanda
     * @throws CrmStampeException
     */
    public void completaPolizza(Polizza dest, DomandaVO domanda) throws WebServiceClientException, PucException, DaoException {

        Integer indicatoreTipoRisc = new Integer(3);
        String dataValutazione = "";

        for (ValoreInputVO v : domanda.getValoriInput()) {
            for (int tipo : Costanti.INPUT_DATA_VALUTAZIONE) {
                if (tipo == v.getDatoInput().getId()) {
                    try {
                        dataValutazione = DateUtils.formatDate(DateUtils.getCrmDate(v.getValore()), Costanti.FORMATO_DATA);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
        }
        dest.addAttributo("dataValutazione", dataValutazione);

        DescrizioniComuni.impostaDescrizioneIpotesiConsiderate(dest);

        //-----------  DICITURA ANTICIPATO SU COLONNA TABELLA ------
        LetteraRiscattoAnticipato.impostaLabelRiscattoAnticipato(dest);

        //-----------  PRESTAZIONI ASSICURATE -------------------
//        TabellaValoreRiscattoAnticipato.impostaTabellaValoreRiscatto(dest);
        try {
			new TabellaValoreRiscattoAnticipato(comID).impostaTabellaValoreRiscatto(dest);
		} catch (WebServiceClientException e) {
            LoggingUtils.error(e);
		} catch (PucException e) {
            LoggingUtils.error(e);
        }

        new DescrizioniComuni(comID).impostaDatiRiscatto(dest, dataValutazione, indicatoreTipoRisc);


    }
}
