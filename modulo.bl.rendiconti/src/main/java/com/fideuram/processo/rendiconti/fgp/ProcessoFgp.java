package com.fideuram.processo.rendiconti.fgp;

import com.fideuram.exception.RendicontiException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.fgp.FgpMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 31/01/14
 * Time: 12.39
 */
public class ProcessoFgp extends ProcessoGenericoRendiconti {
    public ProcessoFgp() {

        super();
    }

    public byte[] stampa(Fgp fgp, int richiesta) throws RendicontiException {
        normativaProdottoAllegato=fgp;
        //return start("RendicontoFGP.odt",false);
        return start(TemplateFactory.getNomeTemplate(""+richiesta),false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoFgp().stampa(FgpMock.getMock(),6002);
    }

}



