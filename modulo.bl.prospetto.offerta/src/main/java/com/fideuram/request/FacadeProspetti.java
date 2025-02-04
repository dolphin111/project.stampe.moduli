package com.fideuram.request;

import java.util.Hashtable;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ObjectOutOfTargetException;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.ProspettoServiceImpl;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.request.controllers.ControllerOffertaFVIGemini;
import com.fideuram.request.controllers.ControllerOffertaFVISintonia;
import com.fideuram.request.controllers.ControllerOffertaFVInsieme;
import com.fideuram.request.controllers.ControllerOffertaFvFacilePerNoi;
import com.fideuram.request.controllers.ControllerOffertaFvInsiemePerNoi;
import com.fideuram.request.controllers.ControllerOffertaFvPrivatePerNoi;
import com.fideuram.request.controllers.ControllerOffertaFviFacile;
import com.fideuram.request.controllers.ControllerOffertaFviPremium;
import com.fideuram.request.controllers.ControllerOffertaFviPremium44;
import com.fideuram.request.controllers.ControllerOffertaFviPrivate;
import com.fideuram.request.controllers.ControllerOffertaPrivateMixPerNoi;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 02/10/12
 * Time: 14.09
 */
public class FacadeProspetti {

    public Object elaboraProcesso(int azione, String xml, Hashtable input){
        switch (azione){
            default:
               return elaboraProcesso(azione,xml);
        }
    }

    public Object elaboraProcesso(int azione, String xml){
        switch (azione){
            default:
               return elaboraProcesso(azione);
        }
    }


    public Object elaboraProcesso(int azione) {
       LoggingUtils.debug("FacadeProspetti 1.0.5");
       LoggingUtils.debug("Azione richiesta: "+azione);
       Object obj=null;
       try{
           switch (azione){
               case 18:       //Fv Insieme
                   return new ControllerOffertaFVInsieme().avviaProcesso();
               case 180:      //Fv Insieme
                   return new ControllerOffertaFVInsieme().avviaProcessoSupplemento();
               case 181:      //Fv Insieme              RENDICONTO OORE DE MAMMA
                   return new ControllerOffertaFVInsieme().avviaProcessoRendiconto();
               case 51:       //Fv Insieme Premium
                   return new ControllerOffertaFviPremium().avviaProcesso();
               case 510:      //Fv Insieme Premium
                   return new ControllerOffertaFviPremium().avviaProcessoSupplemento();
               case 511:      //Fv Insieme Premium
                   return new ControllerOffertaFviPremium().avviaProcessoRendiconto();
               case 53:       //FVI private:
                   return new ControllerOffertaFviPrivate().avviaProcesso();
               case 530:      //FVI private:
                   return new ControllerOffertaFviPrivate().avviaProcessoSupplemento();
               case 590:      //FVI private Mix:
                   return new ControllerOffertaPrivateMixPerNoi().avviaProcessoSupplemento();
               case 55:       //FVI Facile:
                   return new ControllerOffertaFviFacile().avviaProcesso();
               case 550:      //FVI Facile:
                   return new ControllerOffertaFviFacile().avviaProcessoSupplemento();
               case 551:      //FVI Facile:             RENDICONTO OORE DE MAMMA
                   return new ControllerOffertaFviFacile().avviaProcessoRendiconto();
               case 56:       //FVI Premium 4+4:
                   return new ControllerOffertaFviPremium44().avviaProcesso();
               case 560:      //FVI Premium 4+4:
                   return new ControllerOffertaFviPremium44().avviaProcessoSupplemento();
               case 561:      //FVI Premium 4+4:        RENDICONTO OORE DE MAMMA
                   return new ControllerOffertaFviPremium44().avviaProcessoRendiconto();
               case 19:       //Fv Insieme              PRODOTTO X NOI
                   return new ControllerOffertaFvInsiemePerNoi().avviaProcesso();
               case 190:       //Fv Insieme supplememnto             PRODOTTO X NOI
                   return new ControllerOffertaFvInsiemePerNoi().avviaProcessoSupplemento();
               case 54:       //FVI private             PRODOTTO X NOI
                   return new ControllerOffertaFvPrivatePerNoi().avviaProcesso();
               case 540:       //FVI private             PRODOTTO X NOI
                   return new ControllerOffertaFvPrivatePerNoi().avviaProcessoSupplemento();
               case 57:       //FVI Facile:             PRODOTTO X NOI
                   return new ControllerOffertaFvFacilePerNoi().avviaProcesso();
               case 570:       //FVI Facile:             PRODOTTO X NOI
                   return new ControllerOffertaFvFacilePerNoi().avviaProcessoSupplemento();
               case 59:       //FVI Facile:             PRODOTTO X NOI
                   return new ControllerOffertaPrivateMixPerNoi().avviaProcesso();
               case 64:       //FVI Gemini:     nota informativa      
                   return new ControllerOffertaFVIGemini().avviaProcesso();
               case 640:       //FVI Gemini:   scheda sintetica
                   return new ControllerOffertaFVIGemini().avviaProcessoSintesi();
               case 66:       //FVI Sintonia:     nota informativa      
                   return new ControllerOffertaFVISintonia().avviaProcesso();
               case 660:       //FVI Sintonia:   scheda sintetica
                   return new ControllerOffertaFVISintonia().avviaProcessoSintesi();
               case 642:	  //FVI Gemini:   addendum
                   return new ControllerOffertaFVIGemini().avviaProcessoAddendum();
               case 662:	  //FVI Sintonia:   addendum
                   return new ControllerOffertaFVISintonia().avviaProcessoAddendum();
               case 641:	  //FVI Gemini:   RENDICONTO
                   return new ControllerOffertaFVIGemini().avviaProcessoRendiconto();
               case 661:	  //FVI Sintonia:   RENDICONTO
                   return new ControllerOffertaFVISintonia().avviaProcessoRendiconto();
               default:
                   LoggingUtils.debug("ERRORE - Richiesto un Prospetto di Offerta, ma non è stato specificato il Tipo. Es: FvInsieme=18||FvInsiemePremium=51. Richiasta EFFETTIVA=  "+azione);
                   throw new ObjectOutOfTargetException("Richiesto un Prospetto di Offerta, ma non è stato specificato il Tipo.  OPPURE NON è UN TIPO CORRETTO.");
           }
       }catch (ObjectOutOfTargetException e){
               salvaErrore("" + azione, e);
               LoggingUtils.debug("Salvato ERRORE "+e);
       }catch (ProspettoDiOffertaException e){
               salvaErrore("" + azione, e);
               LoggingUtils.debug("Salvato ERRORE "+e);
       }catch (WebServiceClientException e) {
               salvaErrore("" + azione, e);
               LoggingUtils.debug("Salvato ERRORE "+e);
       }
       return obj;
    }

    public static void salvaErrore(String idProcesso, Exception e){
        try {
            LoggingUtils.error("Prospetto di Offerta: SALVA ERRORE >>> " +e.getClass() +" "+e.getMessage());
            ProspettoServiceImpl puc = ClientWsFactory.getInstance().getPucProspettoClient();
            puc.setErrorFromStampe(idProcesso, e.getMessage());
        } catch (WebServiceClientException e1) {
            LoggingUtils.error("Prospetto di Offerta: tentativo di SALVARE ERRORE ANDATO MALE" + e1.getMessage());
        } catch (ServiceException_Exception e1) {
            LoggingUtils.error("Prospetto di Offerta: tentativo di SALVARE ERRORE ANDATO MALE"+e1.getMessage());
        }
    }

    public static void main(String args[]){
    	//PROSPETTO
//    	new FacadeProspetti().elaboraProcesso(51);     //FV INSIEME PREMIUM             TODO  OK
//      	new FacadeProspetti().elaboraProcesso(18);     //FV INSIEME                     TODO  OK
//      	new FacadeProspetti().elaboraProcesso(55);     //FV FACILE                      TODO  OK
//      	new FacadeProspetti().elaboraProcesso(56);     //FV PREMIUM 4 + 4               TODO  OK 	
//    	new FacadeProspetti().elaboraProcesso(54);     //FV PRIVATE  x noi   (Probabilmente chiuso al prospetto)
    	
    	//ALLEGATO A ALLA SINTESI
//    	new FacadeProspetti().elaboraProcesso(53);     //FV PRIVATE                     TODO  OK
//      new FacadeProspetti().elaboraProcesso(19);     //FV INSIEME PER NOI             TODO  OK
//    	new FacadeProspetti().elaboraProcesso(57);     //FV FACILE  PER NOI             TODO  OK
      new FacadeProspetti().elaboraProcesso(54);     //FV PRIVATE PER NOI             TODO  OK
//    	new FacadeProspetti().elaboraProcesso(59);     //FV PRIVATE MIX PER NOI         (Probabilmente chiuso all'allegato alla sintesi)
    	
    	//SUPPLEMENTO AL PROSPETTO
//    	new FacadeProspetti().elaboraProcesso(180);     //FV INSIEME  SUPPLEMENTO                   TODO  OK	
//    	new FacadeProspetti().elaboraProcesso(510);     //FVI PREMIUM SUPPLEMENTO					TODO  OK
//    	new FacadeProspetti().elaboraProcesso(560);     //FV PREMIUM 4 + 4   SUPPLEMENTO            TODO  OK
//    	new FacadeProspetti().elaboraProcesso(550);     //FV FACILE   SUPPLEMENTO                   TODO  OK
    	
    	//SUPPLEMENTO ALLA SINTESI
//    	new FacadeProspetti().elaboraProcesso(530);      //FVI PRIVATE SUPPLEMENTO ALLA SINTESI          TODO OK
//    	new FacadeProspetti().elaboraProcesso(540);      //FVI PRIVATE PER NOI SUPPLEMENTO ALLA SINTESI  TODO OK
//    	new FacadeProspetti().elaboraProcesso(190);      //FV INSIEME PER NOI SUPPLEMENTO ALLA SINTESI   TODO OK
//    	new FacadeProspetti().elaboraProcesso(570);      //FV FACILE PER NOI  SUPPLEMENTO ALLA SINTESI (Probabilmente chiuso al supplemento alla sintesi)
//    	new FacadeProspetti().elaboraProcesso(590);		//FVI PRIVATE MIX SUPPLEMENTO ALLA SINTESI          TODO OK
    	
    	//ALLEGATO AL RENDICONTO
//    	new FacadeProspetti().elaboraProcesso(551);    //FV FACILE         RENDICONTO   TODO  OK
//      new FacadeProspetti().elaboraProcesso(561);  //FV PREMIUM 4 + 4  RENDICONTO   TODO  OK
//    	new FacadeProspetti().elaboraProcesso(181);  //FV INSIEME        RENDICONTO   TODO  OK
//    	new FacadeProspetti().elaboraProcesso(511);	// FV PREMIUM
//      new FacadeProspetti().elaboraProcesso(531); // FVI PRIVATE: codice RV0U1
    	//ALLEGATO AI RENDICONTI ANNUALI MULTIRAMO
//    	new FacadeProspetti().elaboraProcesso(641);//FVI GEMINI
//    	new FacadeProspetti().elaboraProcesso(661);//FVI SINTONIA
    	
    	
        //FASCICOLO INFORMATIVO
    		//NOTA INFORMATIVA
//      	new FacadeProspetti().elaboraProcesso(64); //FVI GEMINI NOTA INFORMATIVA
//          new FacadeProspetti().elaboraProcesso(66); //FVI SINTONIA NOTA INFORMATIVA
    	    //SCHEDA SINTETICA
//    	    new FacadeProspetti().elaboraProcesso(640); //FVI GEMINI SCHEDA SINTETICA
//    		new FacadeProspetti().elaboraProcesso(660); //FVI SINTONIA SCHEDA SINTETICA
    		//ADDENDUM
//          new FacadeProspetti().elaboraProcesso(642); // FVI GEMINI ADDENDUM
//    		new FacadeProspetti().elaboraProcesso(662); // FVI SINTONIA ADDENDUM
    }

}

