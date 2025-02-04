package com.fideuram.stampe.modello.rendiconti.grafici.linea;


import com.fideuram.stampe.modello.rendiconti.grafici.Grafico;

import java.util.ArrayList;
import java.util.List;

/**
 * User: v801068
 * Date: 03/11/14
 * Time: 10.57
 */
public class Andamento extends Grafico{
    protected List<ElementoLinea> andamento;

    public Andamento() {
        andamento=new ArrayList<ElementoLinea>();
    }

    public void addElemento(ElementoLinea stepAndamento) {
       andamento.add(stepAndamento);
    }

    public List<ElementoLinea> getAndamento() {
        return andamento;
    }
}
