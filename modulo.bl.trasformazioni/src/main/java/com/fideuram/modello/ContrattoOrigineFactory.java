package com.fideuram.modello;

import com.fideuram.exception.TrasformazioneException;
import com.fideuram.jaxb.Converter;
import com.fideuram.modello.contratti.*;
import com.fideuram.stampe.modello.polizza.Polizza;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.00
 */
public class ContrattoOrigineFactory {

    public static Contratto getContratto(Polizza polizza, int richiesta) throws TrasformazioneException {

        LoggingUtils.info("INIT ContrattoOrigineFactory>>> richiesta: "+ richiesta);

        if(polizza.getTipoPremio().equalsIgnoreCase("U") || polizza.getTipoPremio().equalsIgnoreCase("G")){
            switch (richiesta) {
                case 001:
                     return new PU001();
                case 201:   //00201  ex PR002  REL 1
                     return new PU002r1();
                case 202:   //00201  ex PR002  REL 2
                     return new PU002r2();
                case 203:   //00201  ex PR002  REL 3
                     return new PU002r3();
                case 204:   //00201  ex PR002  REL 4
                     return new PU002r4();
                case 205:   //00201  ex PR002  REL 5
                     return new PU002r5();
                case 18001:
                     return new PU18001();
                case 18002:
                     return new PU18002();
                case 18003:
                     return new PU18003();
                case 18005:
                     return new PU18005();
                case 35005:
                     return new PU35005();
                case 35006:
                     return new PU35006();
                case 35007:
                     return new PU35007();
                case 111:
                    return new PU111();
                case 112:
                	return new PU112();
                case 114:
                    return new PU114();
                case 115:
                    return new PU115();
                case 116:
                    return new PU116();
                case 117:
                    return new PU117();
                case 118:
                    return new PU118();
                case 119:
                    return new PU119();
                case 120:
                    return new PU120();
                case 121:
                    return new PU121();
                case 122:
                    return new PU122();
                case 123:
                    return new PU123();
                case 126:
                	return new PU126();
                //TODO ISTRUIRE I CASE 19001-19002-19003
            }
        }else {
            switch (richiesta) {
                case 001:
                    return new PR001();
                case 201: //00201  ex PR002  REL 1
                    return new PR002r1();
                case 202: //00202  ex PR002  REL 2
                    return new PR002r2();
                case 203: //00203  ex PR002  REL 1
                    return new PR002r3();
                case 18001:
                    return new PR18001();
                case 18002:
                    return new PR18002();
                case 18003:
                    return new PR18003();
                case 18005:
                    return new PR18005();
                case 19001:
                    return new PR19001();
                case 19002:
                    return new PR19002();
                case 19003:
                    return new PR19003();
                case 35005:
                    return new PR35005();
                case 35006:
                    return new PR35006();
                case 35007:
                    return new PR35007();
                case 111:
                    return new PR111();
                case 113:
                    return new PR113();
                case 124:
                    return new PR124();
                case 125:
                    return new PR125();
                //TODO ISTRUIRE I CASE 19001-19002-19003
            }
        }
        throw new TrasformazioneException("Contratto not found "+richiesta);
    }
}
