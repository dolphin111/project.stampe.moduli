package com.fideuram.crm.stampe.engine.processi.scadenzaPremi;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.lettere.LetteraAvvisiScadenzaPremi;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;

public class AvvisiScadenzaPremi extends ProcessoBase{

	public AvvisiScadenzaPremi()    {
	}

	public Object getDocumento(String data, int richiesta, int formato)throws DocGeneratorException {
		LoggingUtils.debug((new StringBuilder("com.fideuram.crm.stampe.engine.processi.scadenzaPremi.AvvisiScadenzaPremi.getDocumento--> ")).append(data).append(" -->ProdottoCommerciale richiesto [1]: ").append(richiesta).toString());
		HashMap map = null;
		switch(richiesta)
		{
		case 1: 
			map = (HashMap) LetteraAvvisiScadenzaPremi.fromXml(data);
			return generatoreOdt(map, Templates.TEMPLATE_AVVISI_SCADENZA_PREMI);
		}
		throw new DocGeneratorException("TipoRichiesta non riconosciuto");
	}

	private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
		byte templateData[] = getTemplate(template);
		LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
		byte doc[] = (new OdtWriter()).mergeData(templateData, data);
		return doc;
	}
}