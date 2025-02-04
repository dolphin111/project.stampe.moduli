package com.fideuram.soa.sync.trasformazioni;

import com.fideuram.exception.TrasformazioneException;
import com.fideuram.jaxb.Converter;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.soa.sync.trasformazioni.integration.TrasformateIntegration;
import com.fideuram.soa.sync.trasformazioni.dto.TrasformazioneDto;
import com.fideuram.utils.LoggingUtils;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import org.jboss.ejb3.annotation.Clustered;

import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 21/02/12
 * Time: 15.40
 */
@Stateless(mappedName = "ejb/DocumentPOImpl")
@Clustered
@Local(IDocumentPOLocal.class)
@Remote(IDocumentPORemote.class)
public class DocumentPOImpl implements  IDocumentPOLocal, IDocumentPORemote {
    @Override
    public byte[] getTrasformata(TrasformazioneDto trasformazioneDto) throws Exception {
        LoggingUtils.info("RICHIESTA DI TRASFORMAZIONE Rel. 1.0");
        LoggingUtils.info("Codice Contratto Origine: "+ (trasformazioneDto.getCodiceCommercialeProdottoOrigine()!=null?trasformazioneDto.getCodiceCommercialeProdottoOrigine():"NULL"));
        LoggingUtils.info("___________________________________");
        LoggingUtils.info("START PROCEDURA DI STAMPA");
        //String xml=Converter.objectToXml(trasformazioneDto);
        //LoggingUtils.info("Richiesta di trasformazione dal Puc/n"+xml);
        try {
            return new TrasformateIntegration().elabora(trasformazioneDto);
        } catch (TrasformazioneException e) {
            LoggingUtils.error(e);
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String getVersion() {
        LoggingUtils.info("GET VERSION EJB");

        return  "stampe.ejb_0.0.2";
    }

    @Override
    public String testInstallation() {
        return "Modulo EJB PO - Presente";
    }

    public static void main(String args[]){

        String anomalia="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizzaTrasformabile>\n" +
                "    <canale>0</canale>\n" +
                "    <polizza>\n" +
                "        <numero>7656670</numero>\n" +
                "        <nomeCommercialeProdotto>Financial Age Protection 2</nomeCommercialeProdotto>\n" +
                "        <tipoPremio>A</tipoPremio>\n" +
                "        <privateBanker>\n" +
                "            <cognome>TERIGI</cognome>\n" +
                "            <nome>SILVIA</nome>\n" +
                "            <rete>BFI</rete>\n" +
                "        </privateBanker>\n" +
                "        <contraente>\n" +
                "            <cognome>GIORCELLI</cognome>\n" +
                "            <nome>ENRICA</nome>\n" +
                "        </contraente>\n" +
                "        <assicurato>\n" +
                "            <cognome>GIORCELLI</cognome>\n" +
                "            <nome>ENRICA</nome>\n" +
                "            <livello>0</livello>\n" +
                "        </assicurato>\n" +
                "    </polizza>\n" +
                "    <nomeCommercialeProdottoDestinazione>Fideuram Vita Insieme Facile</nomeCommercialeProdottoDestinazione>\n" +
                "    <decorrenza>11/11/2003</decorrenza>\n" +
                "    <scadenza>31/12/2022</scadenza>\n" +
                "    <durata>19 anni e 1 mesi</durata>\n" +
                "    <dataProposta>09/09/2014</dataProposta>\n" +
                "    <numeroSchedaTrasformazione>123456789111111</numeroSchedaTrasformazione>\n" +
                "    <dataNav>09/09/2014</dataNav>\n" +
                "    <controvalorePolizza>125,01</controvalorePolizza>\n" +
                "    <origine/>\n" +
                "</polizzaTrasformabile>";
        try {
            PolizzaTrasformabile p= (PolizzaTrasformabile) Converter.xml2Object(new PolizzaTrasformabile(), anomalia);
            TrasformazioneDto t=new TrasformazioneDto();
            t.setCognomeAssicurato(p.getPolizza().getAssicurato().getCognome());
            t.setNomeAssicurato(p.getPolizza().getAssicurato().getNome());

            t.setNomeContraente(p.getPolizza().getContraente().getNome());
            t.setCognomeContraente(p.getPolizza().getContraente().getCognome());

            t.setNomePb(p.getPolizza().getPrivateBanker().getNome());
            t.setCognomePb(p.getPolizza().getPrivateBanker().getCognome());
            t.setCodicePb("011706");
            t.setRete(p.getPolizza().getPrivateBanker().getRete());

            t.setNumeroPolizza(p.getPolizza().getNumero());
            t.setNomeCommercialeProdottoOrigine(p.getPolizza().getNomeCommercialeProdotto());
            t.setCodiceTipoPremioPolizza(p.getPolizza().getTipoPremio());


            t.setCanale(p.getCanale());
            t.setDataScadenza(p.getScadenza());
            t.setDataDecorrenza(p.getDecorrenza());
            t.setDurata(p.getDurata());
            t.setNomeCommercialeProdottoDestinazione(p.getNomeCommercialeProdottoDestinazione());
            t.setCodiceCommercialeProdottoOrigine("111");
            t.setCodiceCommercialeProdottoDestinazione("804");
            t.setNumeroSchedaTrasformazione(p.getNumeroSchedaTrasformazione());
            t.setDataNav(p.getDataNav());
            t.setControvalorePolizza(p.getControvalorePolizza());

            new DocumentPOImpl().getTrasformata(t);
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
