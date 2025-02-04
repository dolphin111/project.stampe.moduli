package com.fideuram.processo.rendiconti.consob;

import com.fideuram.exception.RendicontiException;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.consob.RTF_ConsobMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.RtfConsob;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 05/02/14
 * Time: 15.31
 */
public class ProcessoPRTFConsob extends ProcessoGenericoRendiconti {
    public ProcessoPRTFConsob() {
        super();
    }

    public byte[] stampa(RtfConsob rtf) throws RendicontiException {
        nomeFileOdt="DTSTORPRTF2_R_CONSOB.odt";
        normativaProdottoAllegato=rtf;
        return start("RendicontoDTSTORPRTF2_R_CONSOB.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException {
        new ProcessoPRTFConsob().stampa(RTF_ConsobMock.getMock());
    }
}
