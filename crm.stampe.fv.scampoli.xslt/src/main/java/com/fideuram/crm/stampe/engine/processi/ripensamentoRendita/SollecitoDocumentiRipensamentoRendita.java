package com.fideuram.crm.stampe.engine.processi.ripensamentoRendita;

import java.util.HashMap;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.lettere.LetteraDecumulo;
import com.fideuram.crm.stampe.engine.lettere.LetteraSollecitoDocumentiRipensamentoRendita;
import com.fideuram.crm.stampe.engine.processi.IdentificatoreProcesso;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.GenericWriter;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

public class SollecitoDocumentiRipensamentoRendita extends ProcessoBase
{

    public SollecitoDocumentiRipensamentoRendita()
    {
    }

    public Object getDocumento(String data, int richiesta, int formato)
        throws DocGeneratorException
    {
        LoggingUtils.debug((new StringBuilder("com.fideuram.crm.stampe.engine.processi.ripensamentoRendita.decumulo.SollecitoDocumentiRipensamentoRendita.getDocumento --> ")).append(data).append(" -->ProdottoCommerciale richiesto [1]: ").append(richiesta).toString());
        String processo = IdentificatoreProcesso.getUndecodeProcess(richiesta);

        HashMap map = null;
    	if(!data.startsWith("<?xml")) {
//    		map = (HashMap) LetteraDecumulo.fromXml(getXml(data, processo, "true"));
    	}
    	else
    		map = (HashMap) LetteraSollecitoDocumentiRipensamentoRendita.fromXml(data);
    	
    	return generatoreOdt(map, Templates.TEMPLATE_SOLLECITO_RIPENSAMENTO_RENDITA);
    }

    private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
        GenericWriter writer = null;
        byte templateData[] = getTemplate(template);
        LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
        byte doc[] = (new OdtWriter()).mergeData(templateData, data);
        return doc;
    }
}
