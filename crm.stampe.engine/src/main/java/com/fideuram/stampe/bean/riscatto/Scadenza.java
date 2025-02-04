package com.fideuram.stampe.bean.riscatto;

/**
 * Created by V801068 on 30/04/14.
 */
public class Scadenza extends Riscatto{

    private String descrizioneTipoRiscatto;

    public void setDescrizioneTipoRiscatto(String descrizioneTipoRiscatto) {
        this.descrizioneTipoRiscatto = descrizioneTipoRiscatto;
    }

    @Override
    public String getDescrizioneTipoRiscatto() {
        return descrizioneTipoRiscatto;
    }

    public boolean soCosaTiDevoEQuando(){
        if (null==importoLiquidazioneNetta)
            return false;
        return null != dataValutaLiquidazione;
    }

}
