package com.fideuram.stampe.modello.rendiconti.composizione;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with
 * User: v801068
 * Date: 24/02/14
 * Time: 11.07
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ComposizioneFondo {
    private Date bmFinoAl;
    private List<FondoAnnidato> sottofondiBmFinoAl;
    private Date bmDal;
    private List<FondoAnnidato> sottofondiBmDal;




    public String getBmFinoAl() {
        return FormattatoreDate.formatDate(bmFinoAl, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public List<FondoAnnidato> getSottofondiBmFinoAl() {
        if(null==sottofondiBmFinoAl){
            sottofondiBmFinoAl=new ArrayList<FondoAnnidato>();
            sottofondiBmFinoAl.add(new FondoAnnidato());
            sottofondiBmFinoAl.add(new FondoAnnidato());
            sottofondiBmFinoAl.add(new FondoAnnidato());
            sottofondiBmFinoAl.add(new FondoAnnidato());
        }
        return sottofondiBmFinoAl;
    }

    public String getBmDal() {
        return FormattatoreDate.formatDate(bmDal, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public List<FondoAnnidato> getSottofondiBmDal() {
        if(null==sottofondiBmDal){
            sottofondiBmDal=new ArrayList<FondoAnnidato>();
            sottofondiBmDal.add(new FondoAnnidato());
            sottofondiBmDal.add(new FondoAnnidato());
            sottofondiBmDal.add(new FondoAnnidato());
            sottofondiBmDal.add(new FondoAnnidato());
        }
        return sottofondiBmDal;
    }

    public void setBmFinoAl(Date bmFinoAl) {
        this.bmFinoAl = bmFinoAl;
    }

    public void setSottofondiBmFinoAl(List<FondoAnnidato> sottofondiBmFinoAl) {
        this.sottofondiBmFinoAl = sottofondiBmFinoAl;
    }

    public void setBmDal(Date bmDal) {
        this.bmDal = bmDal;
    }

    public void setSottofondiBmDal(List<FondoAnnidato> sottofondiBmDal) {
        this.sottofondiBmDal = sottofondiBmDal;
    }
}
