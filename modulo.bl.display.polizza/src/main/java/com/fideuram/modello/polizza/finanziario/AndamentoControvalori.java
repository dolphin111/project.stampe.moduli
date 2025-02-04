package com.fideuram.modello.polizza.finanziario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 05/07/13
 * Time: 17.14
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AndamentoControvalori {

    @XmlElement(name = "andamentoControvalore")
    private List<AndamentoControvalore> andamentoControvalores=new ArrayList<AndamentoControvalore>();

    public List<AndamentoControvalore> getAndamentoControvalores() {
        return andamentoControvalores;
    }



}
