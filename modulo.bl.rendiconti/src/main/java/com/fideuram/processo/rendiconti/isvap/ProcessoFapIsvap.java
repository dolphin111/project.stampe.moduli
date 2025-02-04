package com.fideuram.processo.rendiconti.isvap;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.FapMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 10.57
 */
public class ProcessoFapIsvap  extends ProcessoGenericoRendiconti {
    public ProcessoFapIsvap() {
        super();
    }
    public byte[] stampa(FapIsvap fap) throws RendicontiException {
        nomeFileOdt="DTSTORFAP_ISVAP.odt";
        normativaProdottoAllegato=fap;
        return start("RendicontoIsvapFap.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoFapIsvap().stampa(FapMock.getMock());
    }
}
