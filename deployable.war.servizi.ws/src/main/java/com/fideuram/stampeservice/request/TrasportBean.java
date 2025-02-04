package com.fideuram.stampeservice.request;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 12/11/12
 * Time: 9.30
 */
@XmlType(name="TrasportBean")
public class TrasportBean implements Serializable {
    private String action;
    private List<KeyValue> input;
    private List<String> domande;
    private String xml;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<KeyValue> getInput() {
        return input;
    }

    public void setInput(List<KeyValue> input) {
        this.input = input;
    }

    public List<String> getDomande() {
        return domande;
    }

    public void setDomande(List<String> domande) {
        this.domande = domande;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

}
