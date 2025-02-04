package com.fideuram.processo.rendiconti.isvap;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.Fap3Mock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Fap3Isvap;


/**
 * Created with
 * User: v801068
 * Date: 28/01/14
 * Time: 11.23
 */
public class ProcessoFap3Isvap extends ProcessoGenericoRendiconti{
    public ProcessoFap3Isvap() {
        super();
    }

    public byte[] stampa(Fap3Isvap fap3) throws RendicontiException {
        nomeFileOdt="DTSTORFAP3_ISVAP.odt";
        normativaProdottoAllegato=fap3;
        return start("RendicontoIsvapFap3.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoFap3Isvap().stampa(Fap3Mock.getMock());
    }
}
