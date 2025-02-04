package com.fideuram.processo.rendiconti.isvap;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.FaoMock;
import com.fideuram.stampe.modello.rendiconti.mock.isvap.Fap3Mock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FaoIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Fap3Isvap;

/**
 * Created with
 * User: v801068
 * Date: 11/02/14
 * Time: 18.55
 */
public class ProcessoFaoIsvap extends ProcessoGenericoRendiconti {
    public ProcessoFaoIsvap() {
        super();
    }

    public byte[] stampa(FaoIsvap fao) throws RendicontiException {
        nomeFileOdt="DTSTORFAO_ISVAP.odt";
        normativaProdottoAllegato=fao;
        return start("RendicontoIsvapFao.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoFaoIsvap().stampa(FaoMock.getMock());
    }
}
