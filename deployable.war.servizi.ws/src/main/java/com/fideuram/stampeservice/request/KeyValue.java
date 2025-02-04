package com.fideuram.stampeservice.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 13/11/12
 * Time: 11.46
 */
@XmlType(name="KeyValue")
public class KeyValue implements Serializable {
    private String key;
    private String value;

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
