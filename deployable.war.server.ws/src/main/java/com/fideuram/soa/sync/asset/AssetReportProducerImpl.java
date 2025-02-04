package com.fideuram.soa.sync.asset;

import java.io.IOException;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBException;

import com.fideuram.exception.AssetException;
import com.fideuram.facade.AssetFacade;
import com.fideuram.iside.IsideResponce;
import com.fideuram.jaxb.Converter;
import com.fideuram.soa.sync.asset.dto.FondoInvestimentoGlobale;
import com.fideuram.soa.sync.asset.dto.StoredFile;
import com.fideuram.soa.sync.asset.exception.AssetInvestimentProducerExpections;
import com.fideuram.utils.LoggingUtils;


/**
 * Created by
 * User: logan
 * Date: 29/03/12
 * Time: 18.02
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class AssetReportProducerImpl implements IAssetReportProducer{


    @Override
    public String testInstallation() {
        return "Modulo EJB AssetReport - Presente";
    }

    @Override
    public StoredFile generateDomunent(FondoInvestimentoGlobale fondoInvestimentoGlobale) throws AssetInvestimentProducerExpections {
        LoggingUtils.info("ATTIVATO LA STAMPA ASSET 4.0.1");
        AssetFacade assetInvestimenti=new AssetFacade();
        IsideResponce s=null;
        try {
                s= assetInvestimenti.elaboraOdt(convert(fondoInvestimentoGlobale),0);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new AssetInvestimentProducerExpections("Errore di parsing del bean",e);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new AssetInvestimentProducerExpections("Errore di parsing del bean",e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new AssetInvestimentProducerExpections("Errore di parsing del bean",e);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new AssetInvestimentProducerExpections("Errore di parsing del bean",e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new AssetInvestimentProducerExpections("Errore di parsing del bean",e);
        } catch (AssetException e) {
            LoggingUtils.error(e);
            throw new AssetInvestimentProducerExpections("Errore di parsing del bean",e);
        }

        /*
        s = new StoredFile();
        s.setIdDocument("0002");
        s.setMemtype("application/pdf");
        s.setNomeDoc("asset.pdf");
        */
        return new StoredFile(s.getIdDocument(),s.getNomeDoc(),s.getMimetype());
    }



    private com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale convert(FondoInvestimentoGlobale fondoInvestimentoGlobale) throws JAXBException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        String xml= Converter.objectToXml(fondoInvestimentoGlobale);
        //LoggingUtils.info("Asset XML proveniente dal PUC: "+xml);
        com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale fig = new  com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale();
        fig = (com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale) Converter.xml2Object(fig, xml);
        return fig ;
    }

}
