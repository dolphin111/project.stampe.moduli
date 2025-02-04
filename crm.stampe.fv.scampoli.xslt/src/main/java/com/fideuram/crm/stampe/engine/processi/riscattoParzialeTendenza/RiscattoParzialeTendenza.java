package com.fideuram.crm.stampe.engine.processi.riscattoParzialeTendenza;

import java.util.HashMap;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.lettere.LetteraRiscattoParzialeTendenza;
import com.fideuram.crm.stampe.engine.processi.IdentificatoreProcesso;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

public class RiscattoParzialeTendenza extends ProcessoBase{

	public RiscattoParzialeTendenza(){
	}

	public Object getDocumento(String data, int richiesta, int formato)throws DocGeneratorException {
		LoggingUtils.debug((new StringBuilder("com.fideuram.crm.stampe.engine.processi.riscattoParzialeTendenza.RiscattoParzialeTendenza.getDocumento--> ")).append(data).append(" -->ProdottoCommerciale richiesto [1]: ").append(richiesta).toString());
		String processo = IdentificatoreProcesso.getUndecodeProcess(richiesta);
		HashMap map = null;
		switch(richiesta)
		{
		case 14:
			if(!data.startsWith("<?xml"))
				map = (HashMap) LetteraRiscattoParzialeTendenza.fromXml(getXml(data, processo, "true"));			
			else
				map = (HashMap) LetteraRiscattoParzialeTendenza.fromXml(data);
			
				return generatoreOdt(map, Templates.TEMPLATE_RISCATTO_PARZIALE_TENDENZA);
		}
		throw new DocGeneratorException("TipoRichiesta non riconosciuto");
	}

	private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
		byte templateData[] = getTemplate(template);
		//LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
		byte doc[] = (new OdtWriter()).mergeData(templateData, data);
		return doc;
	}
}