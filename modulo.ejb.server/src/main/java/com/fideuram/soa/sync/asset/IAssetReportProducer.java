package com.fideuram.soa.sync.asset;

import com.fideuram.soa.sync.asset.dto.FondoInvestimentoGlobale;
import com.fideuram.soa.sync.asset.dto.StoredFile;
import com.fideuram.soa.sync.asset.exception.AssetInvestimentProducerExpections;

/**
 * Created by
 * User: logan
 * Date: 29/03/12
 * Time: 18.00
 */
public interface IAssetReportProducer {
    public String testInstallation();

    /**
     * @return  type String contenente l'id del documento generato
     */
    public StoredFile generateDomunent(FondoInvestimentoGlobale fondoInvestimentoGlobale) throws AssetInvestimentProducerExpections;
}
