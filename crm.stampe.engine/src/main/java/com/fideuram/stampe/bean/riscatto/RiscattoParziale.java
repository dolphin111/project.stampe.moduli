package com.fideuram.stampe.bean.riscatto;

import com.fideuram.stampe.bean.anagrafica.Beneficiario;

import java.util.Date;

/**
 * Created by V801068 on 30/04/14.
 */
public class RiscattoParziale extends Riscatto{

    @Override
    public String getDescrizioneTipoRiscatto() {
        return "Riscatto parziale";
    }

    public boolean soCosaTiDevoEQuando(){
        if (null==dataPresuntoPagamento)
            return false;
        if (null==controvaloreRiscattato)
            return false;
        return true;
    }

}
