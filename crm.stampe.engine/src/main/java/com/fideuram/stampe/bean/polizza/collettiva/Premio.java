package com.fideuram.stampe.bean.polizza.collettiva;

import com.fideuram.factory.FormatterFactory;

import java.util.Date;

/**
 * Created with
 * User: V801068
 * Date: 07/07/14
 * Time: 14.55
 */
public class Premio{
   private String inizioCopertura;
   private Double importo;
   private String dataIncasso;
   private String elenco;

    public Premio(String  elenco,String inizioCopertura, Double importo, String dataIncasso) {
        this.elenco=elenco;
        this.inizioCopertura = inizioCopertura;
        this.importo = importo;
        this.dataIncasso = dataIncasso;
    }


   public String getElenco() {
       return elenco!=null?elenco:"";
   }

   public String getInizioCopertura() {
       return inizioCopertura;
   }

   public String getImporto() {
       return FormatterFactory.getStandardImporto(importo);
   }

   public String getDataIncasso() {
       return dataIncasso;
   }


}
