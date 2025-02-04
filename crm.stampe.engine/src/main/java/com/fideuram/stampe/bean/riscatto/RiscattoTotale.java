package com.fideuram.stampe.bean.riscatto;

import com.fideuram.stampe.bean.anagrafica.Beneficiario;

import java.util.Date;

/**
 * Created by V801068 on 30/04/14.
 */
public class RiscattoTotale extends Riscatto{



    @Override
    public String getDescrizioneTipoRiscatto() {
        return "Riscatto totale";
    }

    public boolean soCosaTiDevoEQuando(){
        if (null==importoLiquidazioneNetta)
            return false;
        if (null==dataValutaLiquidazione)
            return false;
        return true;
    }

}
