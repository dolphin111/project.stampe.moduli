package com.fideuram.chart.lab.line.bean;

import com.fideuram.chart.lab.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 06/02/13
 * Time: 11.31
 */
public class Linea {
  
   private Categoria categoria;
   private List<PuntoLinea> puntoLineas;

    public Linea() {}

    public Linea(Categoria categoria) {
        this.categoria = categoria;
    }

    public Linea(Categoria categoria, List<PuntoLinea> puntoLineas) {
        this.categoria = categoria;
        this.puntoLineas = puntoLineas;
    }

    public Categoria getCategoria() {
       return categoria;
   }

   public void setCategoria(Categoria categoria) {
       this.categoria = categoria;
   }

   public List<PuntoLinea> getPuntoLineas() {
       return puntoLineas;
   }

   public void setPuntoLineas(List<PuntoLinea> puntoLineas) {
       this.puntoLineas = puntoLineas;
   }

   public void addPuntoLinea(PuntoLinea puntoLinea){
       if (puntoLineas==null)
           puntoLineas=new ArrayList<PuntoLinea>();
       puntoLineas.add(puntoLinea);
   }
}
