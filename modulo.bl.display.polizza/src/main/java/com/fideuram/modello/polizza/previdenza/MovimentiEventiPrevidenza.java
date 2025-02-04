package com.fideuram.modello.polizza.previdenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 12/04/13
 * Time: 14.15
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class MovimentiEventiPrevidenza {
    private ArrayList<MovimentoPrevidenza> movimentoPrevidenza = new ArrayList<MovimentoPrevidenza>();

    public ArrayList<MovimentoPrevidenza> getMovimentoPrevidenza() {
        return movimentoPrevidenza;
    }
}
