package com.fideuram.processo.rendiconti.consob;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.consob.Fap3_Consob_551_16_22;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.Fap3Consob;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 28/01/14
 * Time: 11.23
 */
public class ProcessoFap3Consob extends ProcessoGenericoRendiconti{
    public ProcessoFap3Consob() {
        super();
    }
    public byte[] stampa(Fap3Consob fap3) throws RendicontiException {
        normativaProdottoAllegato=fap3;
        return start("RendicontoConsobFap3.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoFap3Consob().stampa(Fap3_Consob_551_16_22.getMock());
    }
}
