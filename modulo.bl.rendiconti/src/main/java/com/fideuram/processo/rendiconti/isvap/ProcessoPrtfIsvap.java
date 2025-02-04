package com.fideuram.processo.rendiconti.isvap;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.FapMock;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.PrtfMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.PrtfIsvap;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 14.25
 */
public class ProcessoPrtfIsvap  extends ProcessoGenericoRendiconti {
    public ProcessoPrtfIsvap() {
        super();
    }
    public byte[] stampa(PrtfIsvap fap) throws RendicontiException {
        nomeFileOdt="DTSTORPRTF_ISVAP.odt";
        normativaProdottoAllegato=fap;
        return start("RendicontoIsvapPrtf.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoPrtfIsvap().stampa(PrtfMock.getMock());
    }
}
