package com.fideuram.crm.stampe.engine.modello;

import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.thoughtworks.xstream.XStream;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by.
 * User: logan
 * Date: 22/06/11
 * Time: 10.44
 */
public class Riduzioni {
    private Polizza polizza;


    /**
     * @param xml
     * @return  Map
     */
    public static Map<String, Object> fromXml(String xml) {
        XStream xstream = new XStreamUtils().readXStream();
        xstream.alias("model", Riduzioni.class);
        xstream.alias("polizza", Polizza.class);
        xstream.alias("dettaglio", DettaglioAnagraficaVO.class);

        Polizza modello = (Polizza) xstream.fromXML(xml);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("polizza", modello);

        return map;
    }

    public Polizza getPolizza() {
        return polizza;
    }

    public void setPolizza(Polizza polizza) {
        this.polizza = polizza;
    }
}
