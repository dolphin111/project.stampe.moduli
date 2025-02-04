package com.fideuram.crm.stampe.engine.modello;

import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.thoughtworks.xstream.XStream;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * User: logan
 * Date: 26/09/11
 * Time: 11.47
 */
public class BaseModel {
    private Polizza polizza;

    /**
     * @param xml
     * @return Map
     */
    public static Map<String, Object> fromXml(String xml) {
        XStream xstream = new XStreamUtils().readXStream();
        xstream.alias("model", BaseModel.class);
        xstream.alias("polizza", Polizza.class);

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
