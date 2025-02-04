package com.fideuram;

import com.fideuram.attori.bo.IPersona;
import com.fideuram.attori.bo.impl.Altro;
import com.fideuram.attori.bo.impl.Contraente;
import com.fideuram.attori.bo.impl.Destinatari;
import com.fideuram.attori.bo.impl.PrivateBanker;
import com.fideuram.controllers.DestinatariLettera;
import com.fideuram.crm.service.Exception_Exception;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by
 * User: logan
 * Date: 07/10/11
 * Time: 14.24
 */
public class DestinatariTest  extends TestCase {
   /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(DestinatariTest.class );
    }

     /**
     * SCENARIO_1
     * PROPONENTE = PRIVATE BANKER -->
     * RECLAMANTE = PRIVATE BANKER -->
     */
     public void  testScenario_1() {
        try {
            LoggingUtils.info("-----1----->8200047");
            Destinatari destinatari = test("8200047");
            IPersona proponente  = destinatari.getProponente();
            IPersona richiedente = destinatari.getRichiedente();
            assertTrue(proponente instanceof PrivateBanker);
            //assertNull(richiedente);
            //assertNull (destinatari.getPerConoscenza());
            //System.out.println(proponente instanceof PrivateBanker ? "propnente >> PrivateBanker" : "ERRORE PROPONENTE");
            //System.out.println(richiedente instanceof Contraente ? "richiedente >> Contraente" :"ERRORE RICHIEDENTE");
            LoggingUtils.info("PROPONENTE:" +proponente.getDenominazione());
            LoggingUtils.info("PROPONENTE:" +proponente.getIndirizzo().getVia());
        } catch (DestinatariException e) {
            e.printStackTrace();
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        } catch (Exception_Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

     }

    /**
     * SCENARIO_2
     * PROPONENTE = PRIVATE BANKER -->  COSTA MARCO
     * RECLAMANTE = CONTRAENTE     -->  PRIMATESTA CLEMENTINA
     */
     public void  testScenario_2() {
        try {
            LoggingUtils.info("-----2----->8200048");
            Destinatari destinatari = test("8200048");
            IPersona proponente  = destinatari.getProponente();
            IPersona richiedente = destinatari.getRichiedente();
            assertTrue (proponente.getDenominazione().equalsIgnoreCase("COSTA MARCO"));
            assertTrue (proponente instanceof PrivateBanker);
            assertTrue (richiedente.getDenominazione().equalsIgnoreCase("PRIMATESTA CLEMENTINA"));
            assertTrue(richiedente instanceof Contraente);
            assertNull(destinatari.getPerConoscenza());
            LoggingUtils.info("PROPONENTE:" +proponente.getDenominazione());
            LoggingUtils.info("-----INDIRIZZO PB-----" + proponente.getIndirizzo().getVia());
            LoggingUtils.info("RICHIEDENTE:" +richiedente.getDenominazione());
        } catch (DestinatariException e) {
            e.printStackTrace();
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        } catch (Exception_Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

     }

    /**
     * SCENARIO_3
     * PROPONENTE = Contraente -->  GAMBARDELLA FABRIZIO
     * RECLAMANTE = Contraente -->  GAMBARDELLA FABRIZIO
     */
    public void  testScenario_3() {
        try {
            LoggingUtils.info("-----3----->8186340");
            Destinatari destinatari = test("8186340");
            IPersona proponente  = destinatari.getProponente();
            IPersona richiedente = destinatari.getRichiedente();
            //assertTrue (proponente.getDenominazione().equalsIgnoreCase("GAMBARDELLA FABRIZIO"));
            assertTrue (proponente instanceof Contraente);
            assertNull (richiedente);
            assertTrue (destinatari.getPerConoscenza().get(0) instanceof PrivateBanker);
            //assertNotNull (destinatari.getPerConoscenza());
            //assertTrue (destinatari.getPerConoscenza().get(0).getDenominazione().equalsIgnoreCase("VALENTINI CARMEN"));
            LoggingUtils.info("PROPONENTE:" +proponente.getDenominazione());
            LoggingUtils.info("PC-PB" + destinatari.getPerConoscenza().get(0).getDenominazione());
            LoggingUtils.info("-----INDIRIZZO PB-----" + destinatari.getPerConoscenza().get(0).getIndirizzo().getVia());

            //System.out.println(proponente instanceof Contraente ? "propnente >> CONTRAENTE" : "ERRORE PROPONENTE");
        } catch (DestinatariException e) {
            e.printStackTrace();
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        } catch (Exception_Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

   /**
     * SCENARIO_4
     * PROPONENTE = Altro      -->  GAMBARDELLA FABRIZIO
     * RECLAMANTE = Contraente -->  GAMBARDELLA FABRIZIO
     */
    public void testScenario_4() {
        try {
            LoggingUtils.info("-----4----->8200041");
            Destinatari destinatari = test("8200041");
            IPersona proponente  = destinatari.getProponente();
            IPersona richiedente = destinatari.getRichiedente();
            //assertTrue (proponente.getDenominazione().equalsIgnoreCase("ROSSI MARIO"));
            assertTrue (proponente instanceof Altro);
            //assertTrue (richiedente.getDenominazione().equalsIgnoreCase("FLORI GINO"));
            assertTrue (richiedente instanceof Contraente);
            //assertTrue (destinatari.getPerConoscenza().get(0).getDenominazione().equalsIgnoreCase("BARBETTI WILMA"));
            assertTrue(destinatari.getPerConoscenza().get(0) instanceof PrivateBanker);
            LoggingUtils.info("PROPONENTE:" + proponente.getDenominazione());
            LoggingUtils.info("RICHIEDENTE:" + richiedente.getDenominazione());
            LoggingUtils.info("ALTRO:" +destinatari.getPerConoscenza().get(0).getDenominazione());
            LoggingUtils.info("-----INDIRIZZO PB-----" + destinatari.getPerConoscenza().get(0).getIndirizzo().getVia());
        } catch (DestinatariException e) {
            e.printStackTrace();
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        } catch (Exception_Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    /**
     * SCENARIO_5
     * PROPONENTE = Altro      -->
     * RECLAMANTE = PB         -->
     */
    public void testScenario_5() {
        try {
            LoggingUtils.info("-----5----->8200040");
            Destinatari destinatari = test("8200040");
            IPersona proponente  = destinatari.getProponente();
            IPersona richiedente = destinatari.getRichiedente();
            assertTrue (proponente instanceof Altro);
            assertTrue (richiedente instanceof PrivateBanker);
            assertTrue (destinatari.getPerConoscenza().get(0) instanceof Contraente);
            LoggingUtils.info("PROPONENTE:" +proponente.getDenominazione());
            LoggingUtils.info("RICHIEDENTE:" +richiedente.getDenominazione());
            LoggingUtils.info("ALTRO:" +destinatari.getPerConoscenza().get(0).getDenominazione());
            LoggingUtils.info("-----INDIRIZZO PB-----" + richiedente.getIndirizzo().getVia());
        } catch (DestinatariException e) {
            e.printStackTrace();
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        } catch (Exception_Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    /**
        * SCENARIO_5
        * PROPONENTE = Altro      -->
        * RECLAMANTE = PB         -->
        */
       public void testScenario_6() {
           try {
               LoggingUtils.info("-----6----->8209179");
               Destinatari destinatari = test("8209179");
               IPersona proponente  = destinatari.getProponente();
               IPersona richiedente = destinatari.getRichiedente();
               assertTrue (proponente instanceof Contraente);
               assertTrue (richiedente instanceof Altro);
               //assertNull (destinatari.getPerConoscenza().get(0));
               LoggingUtils.info("PROPONENTE:" +proponente.getDenominazione());
               LoggingUtils.info("RICHIEDENTE:" +richiedente.getDenominazione());
               //LoggingUtils.info("ALTRO:" +destinatari.getPerConoscenza().get(0).getDenominazione());

           } catch (DestinatariException e) {
               e.printStackTrace();
           } catch (WebServiceClientException e) {
               e.printStackTrace();
           } catch (Exception_Exception e) {
               e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
           }

       }


    /**
        * SCENARIO_CANALE WEB
        * PROPONENTE = Altro      -->
        * RECLAMANTE = PB         -->
        */
    public void testScenario_9() {
        try {
            LoggingUtils.info("-----9----->8199907");
            Destinatari destinatari = test("8199907");
            IPersona proponente = destinatari.getProponente();
            IPersona richiedente = destinatari.getRichiedente();
            assertTrue(proponente instanceof PrivateBanker);
            assertNull(richiedente);
            assertNull (destinatari.getPerConoscenza());
            //System.out.println(proponente instanceof PrivateBanker ? "propnente >> PrivateBanker" : "ERRORE PROPONENTE");
            //System.out.println(richiedente instanceof Contraente ? "richiedente >> Contraente" :"ERRORE RICHIEDENTE");
            LoggingUtils.info("PROPONENTE:" + proponente.getDenominazione());
            LoggingUtils.info("PROPONENTE:" + proponente.getIndirizzo().getVia());
        } catch (DestinatariException e) {
            e.printStackTrace();
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        } catch (Exception_Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }



    //TODO ORGANIZZARE IL TEST PER   SCENARIO_6 CONTRAENTE ALTRO
    //TODO ORGANIZZARE IL TEST PER   SCENARIO_7 PB         ALTRO

    protected   Destinatari  test(String comid) throws WebServiceClientException, DestinatariException, Exception_Exception {
        ComunicazioneVO c =  ClientWsFactory.getInstance().getCrmClient().getComunicazioneById(Integer.valueOf(comid));

        DestinatariLettera destinatariLettera = new DestinatariLettera(c,ClientWsFactory.getInstance().getPucClient());
        Destinatari destinatari = destinatariLettera.configuraDestinatari();
        return destinatari;
    }
}
