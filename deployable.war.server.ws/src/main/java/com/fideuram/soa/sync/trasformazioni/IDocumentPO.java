package com.fideuram.soa.sync.trasformazioni;

import javax.jws.WebService;

import com.fideuram.soa.sync.trasformazioni.dto.TrasformazioneDto;

/**
 * Created by
 * User: logan
 * Date: 21/02/12
 * Time: 15.43
 */
@WebService
public interface IDocumentPO {
    /**
     * @param trasformazioneDto
     * @return byte[] il documento delle trasformate per il tipo richiesto
     */
    public byte[] getTrasformata(TrasformazioneDto trasformazioneDto) throws Exception;


    /**
     * @return String "Installazione OK"
     */
    public String testInstallation();

}
