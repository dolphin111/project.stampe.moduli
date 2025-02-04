package com.fideuram.crm.stampe.engine.processi.avvisi;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.dataLoader.AvvisiLoader;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.GenericWriter;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;

public class AvvisiScadenza extends ProcessoBase
{

    public AvvisiScadenza()
    {
    }

    public Object getDocumento(String data, int richiesta, int formato)
        throws DocGeneratorException
    {
        LoggingUtils.debug((new StringBuilder("com.fideuram.crm.stampe.engine.processi.avvisi.AvvisiScadenza.getDocumento--> ")).append(data).append(" -->ProdottoCommerciale richiesto [1]: ").append(richiesta).toString());
        HashMap map = null;
        switch(richiesta)
        {
        case 34907: 
            return generatoreOdt((new AvvisiLoader()).populateAvvisi(data), Templates.TEMPLATE_AVVISI_SCADENZA);
        }
        throw new DocGeneratorException("TipoRichiesta non riconosciuto");
    }

    private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
        GenericWriter writer = null;
        byte templateData[] = getTemplate(template);
        LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
        byte doc[] = (new OdtWriter()).mergeData(templateData, data);
        return doc;
    }
}
