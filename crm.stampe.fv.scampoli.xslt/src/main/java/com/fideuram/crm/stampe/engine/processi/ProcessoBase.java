package com.fideuram.crm.stampe.engine.processi;

import com.fideuram.crm.stampe.engine.dataLoader.InfoPolizza;
import com.fideuram.crm.stampe.engine.modello.Trasformazione;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.io.reader.Reader;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.puc.service.impl.ElaboraProcessoInputVO;
import com.fideuram.puc.service.impl.KeyValuePair;
import com.fideuram.puc.service.impl.ListElaboraProcessoInputVO;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;

/**
 * Created
 * User: logan
 * Date: 28/07/11
 * Time: 11.37
 */
public abstract class ProcessoBase extends Reader {
    public abstract Object getDocumento(String data, int richiesta, int formato) throws DocGeneratorException;

    protected byte[] generatoreOdt(String dati, String template) throws DocGeneratorException {
        byte[] templateData = getTemplate(template);
        HashMap map = (HashMap) Trasformazione.fromXml(dati);
        byte[] doc = new OdtWriter().mergeData(templateData, map);
        LoggingUtils.debug("actionSwitcher: Elaborato il doc tipo ODT per i dati passati:" + dati);
        return doc;
    }

    protected ElaboraProcessoInputVO getElaboraProcessoInput(String numeroPolizza, String processo, String cache) throws DocGeneratorException{
		ElaboraProcessoInputVO input = new ElaboraProcessoInputVO();
		ListElaboraProcessoInputVO elabora = new ListElaboraProcessoInputVO();
		
		KeyValuePair key = new KeyValuePair();
		key.setKey("processo");
		key.setValue(processo);
		elabora.getInput().add(key);
		
		key = new KeyValuePair();
		key.setKey("numeroPolizza");
		key.setValue(numeroPolizza);
		elabora.getInput().add(key);
		
		key = new KeyValuePair();
		key.setKey("client");
		key.setValue("stampe");
		elabora.getInput().add(key);
		
		key = new KeyValuePair();
		key.setKey("view");
		key.setValue("standard");
		elabora.getInput().add(key);
		
		key = new KeyValuePair();
		key.setKey("cacheMode");
		key.setValue(cache);
		elabora.getInput().add(key);
		
		input.getInput().add(elabora);		
		return input;
	}

    protected String getXml(String numeroPolizza, String processo, String cache) throws DocGeneratorException{
		ElaboraProcessoInputVO input = getElaboraProcessoInput(numeroPolizza, processo, cache);
		String xml = new InfoPolizza().getXmlPuc(input);
        LoggingUtils.debug("Richiesto xml per: polizza"+ numeroPolizza + " - Processo:" + processo + " - Cache" + cache);
		return xml;
	}


    

}
