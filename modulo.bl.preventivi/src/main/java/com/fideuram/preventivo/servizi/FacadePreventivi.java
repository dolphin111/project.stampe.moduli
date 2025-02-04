package com.fideuram.preventivo.servizi;


import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.modello.PreventivoFVI;
import com.fideuram.preventivo.modello.PreventivoFVO;
import com.fideuram.preventivo.processo.PreventivoMultiRamo;
import com.fideuram.preventivo.processo.PreventivoSintonia;
import com.fideuram.preventivo.processo.PreventivoTcm;
import com.fideuram.preventivo.processo.PreventivoTcmEsitoFVI;
import com.fideuram.preventivo.processo.PreventivoTcmEsitoFVO;
import com.fideuram.preventivo.processo.PreventivoTcmEvoluta;
import com.fideuram.preventivo.processo.PreventivoTcmFVI;
import com.fideuram.preventivo.processo.PreventivoTcmFVO;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 19/03/13
 * Time: 12.36
 */
public class FacadePreventivi {
    public byte[] getDocumento(Preventivo p, String tripletta) throws DocGeneratorException {
        LoggingUtils.debug("ControllerPreventivi: tripletta " + tripletta + " in bozza? " + p.getBozza());
        int richiesta = Integer.parseInt(tripletta);
        switch (richiesta) {
            case (111):
                PreventivoTcm pb = new PreventivoTcm();
                return (byte[]) pb.getDocumento(p,richiesta);
            case(112):
                PreventivoMultiRamo preventivoMultiRamo = new PreventivoMultiRamo();
                return (byte[]) preventivoMultiRamo.getDocumento(p);
            case(113):
           	 PreventivoSintonia preventivoSintonia = new PreventivoSintonia();
           	 	return (byte[]) preventivoSintonia.getDocumento(p);
            case (114):
            case(118):
            	PreventivoTcmEvoluta preventivoTcmEvoluto = new PreventivoTcmEvoluta();
            	return (byte[]) preventivoTcmEvoluto.getDocumento(p,richiesta);
            case (115):
            	PreventivoTcmEvoluta preventivoTcmEvolutoBozza = new PreventivoTcmEvoluta();
            	return (byte[]) preventivoTcmEvolutoBozza.getDocumento(p,richiesta);
            case (116):
            	PreventivoTcmEvoluta preventivoTcmEvolutoBozzaQuest = new PreventivoTcmEvoluta();
                return (byte[]) preventivoTcmEvolutoBozzaQuest.getDocumento(p,richiesta);
            case (117):
            	PreventivoTcmEvoluta preventivoTcmEvolutoQuest = new PreventivoTcmEvoluta();
                return (byte[]) preventivoTcmEvolutoQuest.getDocumento(p,richiesta);
        }
        LoggingUtils.debug("TRIPLETTA RICHIESTA NON TROVATA. TRIPLETTA: "+ tripletta);
        return new byte[0];
    }
    
    public byte[] getDocumento(PreventivoFVI p, String tripletta) throws DocGeneratorException {
        LoggingUtils.debug("ControllerPreventiviFVI: tripletta " + tripletta + " in bozza? " + p.getBozza());
        int richiesta = Integer.parseInt(tripletta);
        switch (richiesta) {
            case (119):
                PreventivoTcmFVI pb = new PreventivoTcmFVI();
                return (byte[]) pb.getDocumento(p,richiesta);
            case (120):
                PreventivoTcmEsitoFVI esito = new PreventivoTcmEsitoFVI();
                return (byte[]) esito.getDocumento(p,richiesta);
        }
        LoggingUtils.debug("TRIPLETTA RICHIESTA NON TROVATA. TRIPLETTA: "+ tripletta);
        return new byte[0];
    }    
    
    public byte[] getDocumento(PreventivoFVO p, String tripletta) throws DocGeneratorException {
        LoggingUtils.debug("ControllerPreventiviFVO: tripletta " + tripletta + " in bozza? " + p.getBozza());
        int richiesta = Integer.parseInt(tripletta);
        System.out.println(richiesta);
        switch (richiesta) {
            case (121):
                PreventivoTcmFVO pb = new PreventivoTcmFVO();
                return (byte[]) pb.getDocumento(p,richiesta);
            case (122):
                PreventivoTcmEsitoFVO esito = new PreventivoTcmEsitoFVO();
                return (byte[]) esito.getDocumento(p,richiesta);
        }
        LoggingUtils.debug("TRIPLETTA RICHIESTA NON TROVATA. TRIPLETTA: "+ tripletta);
        return new byte[0];
    }

}
