package com.fideuram.crm.stampe.model;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 14/05/15
 * Time: 11.36
 * To change this template use File | Settings | File Templates.
 */
public class Rateazione {

    public String rateoAnnuo;
    public String rateoSemestrale;
    public String rateoMensile;
    public String rateoTrimestrale;
    public String ammontare;

    public String getRateoAnnuo() {
        return rateoAnnuo;
    }

    public void setRateoAnnuo(String rateoAnnuo) {
        this.rateoAnnuo = rateoAnnuo;
    }

    public String getRateoSemestrale() {
        return rateoSemestrale;
    }

    public void setRateoSemestrale(String rateoSemestrale) {
        this.rateoSemestrale = rateoSemestrale;
    }

    public String getRateoMensile() {
        return rateoMensile;
    }

    public void setRateoMensile(String rateoMensile) {
        this.rateoMensile = rateoMensile;
    }

    public String getRateoTrimestrale() {
        return rateoTrimestrale;
    }

    public void setRateoTrimestrale(String rateoTrimestrale) {
        this.rateoTrimestrale = rateoTrimestrale;
    }

    public String getAmmontare() {
        return ammontare;
    }

    public void setAmmontare(String ammontare) {
        this.ammontare = ammontare;
    }
}
