package com.fideuram.crm.stampe.engine.processi.simulazioniSpi;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.lettere.LetteraSimulazioniSPI;
import com.fideuram.crm.stampe.engine.processi.IdentificatoreProcesso;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;

public class SimulazioniSPI extends ProcessoBase{

	public SimulazioniSPI()    {
	}

	public Object getDocumento(String data, int richiesta, int formato)throws DocGeneratorException {
		LoggingUtils.debug((new StringBuilder("com.fideuram.crm.stampe.engine.processi.simulazioniSpi.SimulazioniSPI.getDocumento--> ")).append(data).append(" -->ProdottoCommerciale richiesto [1]: ").append(richiesta).toString());
		HashMap map = null;
		String processo = IdentificatoreProcesso.getUndecodeProcess(richiesta);
		if(!data.startsWith("<?xml"))			
			map = (HashMap) LetteraSimulazioniSPI.fromXml(getXml(data, processo, "true"));
		else
			map = (HashMap) LetteraSimulazioniSPI.fromXml(data);
		
		return generatoreOdt(map, Templates.TEMPLATE_SIMULAZIONI_SPI);
	}
	
	private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
		byte templateData[] = getTemplate(template);
		LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
		byte doc[] = (new OdtWriter()).mergeData(templateData, data);
		return doc;
	}
}