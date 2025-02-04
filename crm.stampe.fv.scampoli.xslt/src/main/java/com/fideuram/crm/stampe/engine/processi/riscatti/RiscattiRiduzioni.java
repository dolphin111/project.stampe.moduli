package com.fideuram.crm.stampe.engine.processi.riscatti;

import com.fideuram.crm.stampe.engine.Templates;
import com.fideuram.crm.stampe.engine.dataLoader.AnagraficaLoader;
import com.fideuram.crm.stampe.engine.modello.Riduzioni;
import com.fideuram.crm.stampe.engine.modello.Riscatti;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;

/**
 * Date: 28/07/11
 * Time: 11.34
 * @deprecated
 */
public class RiscattiRiduzioni  extends ProcessoBase{
	@Override
	public Object getDocumento(String data, int richiesta, int formato) throws DocGeneratorException {
		LoggingUtils.debug("processi.trasformazioni.RiscattiRiduzioni.getDocumento--> " + data + " -->ProdottoCommerciale richiesto [4604||4538||4555]: " + richiesta);
		HashMap map = null;
		switch (richiesta) {
		case (4604):
			map = (HashMap) Riduzioni.fromXml(data);
		return generatoreOdt(new AnagraficaLoader().recuperaAnagrafica(map), Templates.RIDUZIONE_4604_E21);
		case (4538):
			map = (HashMap) Riscatti.fromXml(data);
		return generatoreOdt(new AnagraficaLoader().recuperaAnagrafica(map), Templates.RISCATTO_ANTICIPATO_4538_B11);
		case (4555):// RISCATTO POLIZZA A SCADENZA
			map = (HashMap) Riscatti.fromXml(data);
		return generatoreOdt(new AnagraficaLoader().recuperaAnagrafica(map), Templates.RISCATTO_SENZA_HP_4555_B28);
			//map = (HashMap) LetteraPrestazioniScadenza.fromXml(data);
		//return generatoreOdt(map, Templates.RISCATTO_SENZA_HP_4555_B28);
		default:
			throw new DocGeneratorException("TipoRichiesta non riconosciuto");
		}
	}

	/**
	 * @param data
	 * @param template
	 * @return
	 */
	private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
		byte[] templateData = getTemplate(template);
		LoggingUtils.debug("template" + templateData.toString());
		byte[] doc = new OdtWriter().mergeData(templateData, data);
		return doc;
	}

}
