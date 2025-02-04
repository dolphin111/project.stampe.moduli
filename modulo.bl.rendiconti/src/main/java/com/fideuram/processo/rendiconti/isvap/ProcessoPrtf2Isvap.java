package com.fideuram.processo.rendiconti.isvap;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.FapMock;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.Prtf2Mock;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.PrtfMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Prtf2Isvap;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 15.43
 */
public class ProcessoPrtf2Isvap  extends ProcessoGenericoRendiconti {
    public ProcessoPrtf2Isvap() {
        super();
    }

    public byte[] stampa(Prtf2Isvap fap) throws RendicontiException {
        nomeFileOdt="DTSTORPRTF2_ISVAP.odt";
        normativaProdottoAllegato=fap;
        return start("RendicontoIsvapPrtf2.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoPrtf2Isvap().stampa(Prtf2Mock.getMock());
    }
}
