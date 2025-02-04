package com.fideuram.soa.sync.trasformazioni.integration;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.exception.TrasformazioneException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processo.FacadeTrasformazioni;
import com.fideuram.soa.sync.trasformazioni.dto.TrasformazioneDto;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.PrivateBanker;
import com.fideuram.stampe.modello.polizza.Polizza;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.Streamer;

/**
 * Created with
 * User: logan
 * Date: 03/07/13
 * Time: 11.57
 */
public class TrasformateIntegration {
    public byte[] elabora(TrasformazioneDto trasformazioneDto) throws TrasformazioneException {
        PolizzaTrasformabile polizzaTrasformabile = parse(trasformazioneDto);
        byte[] odt = new FacadeTrasformazioni().elaboraTrasformazioneCanaleFV(polizzaTrasformabile, Integer.decode(trasformazioneDto.getCodiceCommercialeProdottoDestinazione()));
        byte[] pdf = null;
        try {
            pdf = PdfFactory.getPdfFromOdt(odt);

            //solo se devo fare un test
            /*try {
                Streamer.saveToFile(PdfFactory.getPdfFromOdt(odt), CrmProperties.getProperty("crm.services.temp.path"), "FromFacile_PR_Insieme.pdf");
            }catch (Exception e){}*/

        } catch (WebServiceClientException e) {
            LoggingUtils.error("TrasformateIntegration.elabora WebServiceClientException: " + e.getCause());
            throw new  TrasformazioneException("TrasformateIntegration.elabora WebServiceClientException: ",e);
        } catch (ConverterException e) {
            LoggingUtils.error("TrasformateIntegration.elabora ConverterException: " + e.getCause());
            throw new  TrasformazioneException("TTrasformateIntegration.elabora ConverterException: ",e);
        }
        return pdf;
    }

    private PolizzaTrasformabile parse(TrasformazioneDto trasformazioneDto){
        PolizzaTrasformabile polizzaTrasformabile=new PolizzaTrasformabile();

        Assicurato assicurato = new Assicurato();
        assicurato.setCognome(trasformazioneDto.getCognomeAssicurato());
        assicurato.setNome(trasformazioneDto.getNomeAssicurato());

        Contraente contraente = new Contraente();
        contraente.setCognome(trasformazioneDto.getCognomeContraente());
        contraente.setNome(trasformazioneDto.getNomeContraente());

        PrivateBanker privateBanker= new PrivateBanker();
        privateBanker.setRete(trasformazioneDto.getRete());
        privateBanker.setCognome(trasformazioneDto.getCognomePb());
        privateBanker.setNome(trasformazioneDto.getNomePb());
        privateBanker.setCodice(trasformazioneDto.getCodicePb());

        Polizza polizza = new Polizza();
        polizza.setNumero(trasformazioneDto.getNumeroPolizza());
        polizza.setNomeCommercialeProdotto(trasformazioneDto.getNomeCommercialeProdottoOrigine());
        polizza.setAssicurato(assicurato);
        polizza.setContraente(contraente);
        polizza.setPrivateBanker(privateBanker);

        polizza.setTipoPremio(trasformazioneDto.getCodiceTipoPremioPolizza());


        polizzaTrasformabile.setCanale(trasformazioneDto.getCanale());             //0 INDICA il canale FV
        polizzaTrasformabile.setPolizza(polizza);
        try {
            polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), Integer.decode(trasformazioneDto.getCodiceCommercialeProdottoOrigine())));
        } catch (TrasformazioneException e) {
            LoggingUtils.error("TrasformateIntegration.parse errore in polizzaTrasformabile.setOrigine: " + e.getCause());
        }
        polizzaTrasformabile.setDataProposta(DateUtils.formatNow(Costanti.FORMATO_DATA));
        polizzaTrasformabile.setDecorrenza(trasformazioneDto.getDataDecorrenza());
        polizzaTrasformabile.setScadenza(trasformazioneDto.getDataScadenza());
        polizzaTrasformabile.setDurata(trasformazioneDto.getDurata());
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione(trasformazioneDto.getNomeCommercialeProdottoDestinazione());
        polizzaTrasformabile.setNumeroSchedaTrasformazione(trasformazioneDto.getNumeroSchedaTrasformazione());
        polizzaTrasformabile.setControvalorePolizza(trasformazioneDto.getControvalorePolizza());
        polizzaTrasformabile.setDataNav(trasformazioneDto.getDataNav());

        return polizzaTrasformabile;
    }

    public static void main(String args[]) throws Exception {
       //byte[] pdf= new TrasformateIntegration().elabora(TrasformazioneDtoMock.getDatiTrasformazionePolizzaVO());
       //Streamer.saveToFile(pdf, new URI("/tmp/"), "TRASFORMAZIONE.ODT");
    }

}
