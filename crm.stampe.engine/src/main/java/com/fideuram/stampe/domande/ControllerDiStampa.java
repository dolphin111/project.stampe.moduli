package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.lettere.LetteraSimulatoreFPA;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 22/07/14
 * Time: 15.02
 * To change this template use File | Settings | File Templates.
 */
public class ControllerDiStampa {

    /**
     * <br>Questo metodo stampa il documento
     * <br>relativamente alla domanda specificata
     * <br>domandaVO.getDescrizioneDomandaOriginaleId()
     *
     *
     * @param domandaVO
     * @return  byte[] il documento
     */
    public byte[] sviluppaDomanda(DomandaVO domandaVO, ComunicazioneVO comunicazione) throws DomandaException {
        long richiesta= comunicazione.getBpmProcess()!=null?comunicazione.getBpmProcess().getPraticaID():0;
        switch (domandaVO.getDescrizioneDomandaOriginaleId()){
            case(950):
                LoggingUtils.info("ControllerDiStampa x caso 950");
                return new D950PreventivoCR(comunicazione.getID()).generaDocumento(comunicazione,domandaVO);
            case(1000):
            case(1001):
                return new D1000AppendiceCC(comunicazione.getID()).generaDocumento(domandaVO,richiesta);
            default:
                throw new DomandaException("DOMANDA NON CENSITA NEL NUOVO CONTROLLER");
        }
    }

    /**
     * <br>Questo metodo verifica se il codice della domanda appartiene al nuovo ciclo di stampa
     * <br>il quale è (per quanto possibile) è svincolato da StampeInfo
     * @param domandaVO
     * @return
     */
    public static boolean hasDomanda(DomandaVO domandaVO){
        switch (domandaVO.getDescrizioneDomandaOriginaleId()){
            case(950):  //preventivo conversione in rendita
            case(1000): //cambio contraenza
            case(1001): //cambio contraenza
                return true;
            default:
                return false;
        }
    }
}
