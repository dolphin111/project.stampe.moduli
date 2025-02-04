package com.fideuram.crm.stampe.engine.modello;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;
import com.thoughtworks.xstream.XStream;

/**
 * Date: 22/06/11
 * Time: 10.00
 */
public class Riscatti {
    private Polizza polizza;

    /**
     * @param xml
     * @return Map
     */
    public static Map<String, Object> fromXml(String xml) {
        XStream xstream = new XStreamUtils().readXStream();
        xstream.alias("model", Riscatti.class);
        xstream.alias("polizza", Polizza.class);
        
        xml = CodificaXML.replace(xml);
        try {
        	
			Document document = DocumentHelper.parseText(xml);
			Element _elDettaglioPolizza = document.getRootElement().element("dettaglio");			
						
			if(_elDettaglioPolizza != null) {				
				document.getRootElement().remove(_elDettaglioPolizza);
			}
			String xmlRefactored = document.getRootElement().asXML();
            Polizza modello = (Polizza) xstream.fromXML(xmlRefactored);
            if(modello.getEccedenza() == null)
            	modello.setEccedenza("");
                    	
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map.put("polizza", modello);
	        return map;
        } catch (Exception e) {
        	LoggingUtils.error(e.getMessage());
		}		        
        return null;        
    }

    public Polizza getPolizza() {
        return polizza;
    }

    public void setPolizza(Polizza polizza) {
        this.polizza = polizza;
    }
}