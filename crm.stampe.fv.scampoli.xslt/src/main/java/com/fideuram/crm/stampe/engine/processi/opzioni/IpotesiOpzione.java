package com.fideuram.crm.stampe.engine.processi.opzioni;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.lettere.LetteraIpotesiOpzione;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;

public class IpotesiOpzione extends ProcessoBase{

	public IpotesiOpzione()    {
	}

	public Object getDocumento(String data, int richiesta, int formato)throws DocGeneratorException {
		LoggingUtils.debug((new StringBuilder("com.fideuram.crm.stampe.engine.processi.opzioni.IpotesiOpzione.getDocumento--> ")).append(data).append(" -->ProdottoCommerciale richiesto [1]: ").append(richiesta).toString());
		HashMap map = null;
		switch(richiesta)
		{
		case 2: 
			map = (HashMap) LetteraIpotesiOpzione.fromXml(data);
			return generatoreOdt(map, Templates.TEMPLATE_IPOTESI_OPZIONE);
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