package com.fideuram.modello.chart;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by
 * User: logan
 * Date: 01/06/12
 * Time: 12.11
 */
public class BarraBean implements Serializable {
    private boolean onlyBmkValue=false;
    private boolean bmk=false;
    private Barre barre;

    public boolean isOnlyBmkValue() {
        return onlyBmkValue;
    }

    public void setOnlyBmkValue(boolean onlyBmkValue) {
        this.onlyBmkValue = onlyBmkValue;
    }

    public boolean isBmk() {
        return bmk;
    }

    public void setBmk(boolean bmk) {
        this.bmk = bmk;
    }

    public Barre getBarre() {
        return barre;
    }

    public void setBarre(Barre barre) {
    	if(barre.getBarre() != null){
	        Barre _barre=new Barre();
	
	        //ora aggiungo gli eventuali anni mancanti
	        Hashtable date = new Hashtable();
	        for(int i=0; i<barre.getBarre().size();i++){
	            Barra barra= barre.getBarre().get(i);
	            date.put(barra.getAnno(),"");
	        }
	        int diff = 5-date.size();
	        Barra barra= barre.getBarre().get(0);
	        for(int i=0; i<diff;i++){
	            int anno =Integer.decode(barra.getAnno());
	            //anno=anno-(i+1);
	            anno=(anno-diff)+(i);
	            _barre.addBarra(new Barra(barra.getEtichetta(),Double.valueOf(0),""+anno));
	            //categoryDataset.setValue(Double.valueOf(0),barra.getEtichetta(),""+anno);
	        }
	        for(int i=0; i<barre.getBarre().size();i++){
	            _barre.addBarra(barre.getBarre().get(i));
	        }
	        _barre.setHeader(barre.getHeader());
	        _barre.setYaxis(barre.getYaxis());
	        _barre.setXaxis(barre.getXaxis());
	        this.barre = _barre;
	       // this.barre = barre;
    	}
    }
}
