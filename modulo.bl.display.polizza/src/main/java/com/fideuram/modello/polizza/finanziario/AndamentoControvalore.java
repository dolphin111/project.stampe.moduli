package com.fideuram.modello.polizza.finanziario;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 05/07/13
 * Time: 14.48
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AndamentoControvalore {
   private Double valore;
   private Date data;
   private String descrizione;
   private String nome;

   public String getValore() {
       return FormatterFactory.getStandardImporto(valore);
   }

   public String getNome() {
       return nome;
   }

   public String getDescrizione() {
       return descrizione;
   }

   public String getData() {
       return FormatterFactory.getStandardDate(data);
   }
}
