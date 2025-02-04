package com.fideuram.processo.rendiconti.ante;

import com.fideuram.exception.RendicontiException;

import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.ante551.Ante551FulaaMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fulaa;

import java.io.File;

/**
 * Created
 * User: v801068
 * Date: 21/01/14
 * Time: 11.40
 */
public class ProcessoAnte551Fulaa extends ProcessoGenericoRendiconti {
    public ProcessoAnte551Fulaa() {
        super();
    }

    public byte[] stampa(Fulaa fulaa) throws RendicontiException {
        normativaProdottoAllegato=fulaa;
        return start("RendicontoAnte551Fulaa.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoAnte551Fulaa().stampa(Ante551FulaaMock.getFulaaMock());
    }

}
