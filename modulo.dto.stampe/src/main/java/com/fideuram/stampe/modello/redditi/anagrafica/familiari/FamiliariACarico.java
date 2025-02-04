package com.fideuram.stampe.modello.redditi.anagrafica.familiari;


import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 20/11/14
 * Time: 10.06
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class FamiliariACarico extends AbstractQBase{
        private Familiare coniuge;
        private Familiare primoFiglio;
        private List<Familiare> altri;
        private Double percDetrazioneSpettante;

        public FamiliariACarico() {
            altri=new ArrayList<Familiare>();
        }

        public Familiare getConiuge() {
            return coniuge;
        }

        public Familiare getPrimoFiglio() {
            return primoFiglio;
        }

        public List<Familiare> getAltri() {
            return altri;
        }

        public String getPercDetrazioneSpettante() {
             return formattedDouble2String(percDetrazioneSpettante);
        }

        public void setConiuge(Familiare coniuge) {
            this.coniuge = coniuge;
        }

        public void setPrimoFiglio(Familiare primoFiglio) {
            this.primoFiglio = primoFiglio;
        }

        public void addFamiliare(Familiare familiare){
            this.altri.add(familiare);
        }

        public void setPercDetrazioneSpettante(Double percDetrazioneSpettante) {
            this.percDetrazioneSpettante = percDetrazioneSpettante;
        }
}
