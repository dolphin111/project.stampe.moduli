package com.fideuram.crm.stampe.engine.processi.opzioni;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.modello.modelExtention.Opzioni;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;


/**
 * Created by
 * User: logan
 * Date: 26/09/11
 * Time: 11.05
 */
public class ProcessOpzioni extends ProcessoBase{

    @Override
    public Object getDocumento(String data, int richiesta, int formato) throws DocGeneratorException {
        LoggingUtils.debug("processi.trasformazioni.RiscattiRiduzioni.getDocumento--> " + data + " -->ProdottoCommerciale richiesto [4604||4538||4555]: " + richiesta);
        HashMap map = null;
        switch (richiesta) {
            case (5001):
                map = (HashMap) Opzioni.fromXml(data);
                return generatoreOdt(data, Templates.TEMPLATE_OPZIONE_R1_ANTICIPATA);

            default:
                throw new DocGeneratorException("TipoRichiesta non riconosciuto");
        }
    }
}
