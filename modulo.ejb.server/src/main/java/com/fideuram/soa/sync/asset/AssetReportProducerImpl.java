package com.fideuram.soa.sync.asset;

import com.fideuram.exception.AssetException;
import com.fideuram.facade.AssetFacade;
import com.fideuram.iside.IsideResponce;
import com.fideuram.jaxb.Converter;
import com.fideuram.soa.sync.asset.dto.StoredFile;
import com.fideuram.soa.sync.asset.dto.FondoInvestimentoGlobale;
import com.fideuram.soa.sync.asset.exception.AssetInvestimentProducerExpections;
import com.fideuram.utils.LoggingUtils;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import org.jboss.ejb3.annotation.Clustered;

import java.io.IOException;


/**
 * Created by
 * User: logan
 * Date: 29/03/12
 * Time: 18.02
 */
@Stateless(mappedName = "ejb/AssetReportProducerImpl")
@Clustered
@Local(IAssetReportProducerLocal.class)
@Remote(IAssetReportProducerRemote.class)
public class AssetReportProducerImpl implements IAssetReportProducerLocal,IAssetReportProducerRemote{


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
