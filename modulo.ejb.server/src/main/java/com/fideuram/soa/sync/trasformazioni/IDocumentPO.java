package com.fideuram.soa.sync.trasformazioni;

import com.fideuram.soa.sync.trasformazioni.dto.TrasformazioneDto;

/**
 * Created by
 * User: logan
 * Date: 21/02/12
 * Time: 15.43
 */
public interface IDocumentPO {
    /**
     * @param trasformazioneDto
     * @return byte[] il documento delle trasformate per il tipo richiesto
     */
    public byte[] getTrasformata(TrasformazioneDto trasformazioneDto) throws Exception;


    /**
     * @return String "Installazione OK"
     */
    String testInstallation();

    String getVersion();

}
