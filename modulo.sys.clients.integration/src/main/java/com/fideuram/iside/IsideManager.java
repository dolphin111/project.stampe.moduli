package com.fideuram.iside;


import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.IsideException;
import com.fideuram.iside.configurazioni.ProspettoDiOfferta;
import com.fideuram.iside.facade.BusinessException_Exception;
import com.fideuram.iside.facade.DocumentoIsideBean;
import com.fideuram.iside.facade.IsideManagerDelegate;
import org.apache.commons.beanutils.BeanUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 
 * User: logan
 * Date: 11/12/12
 * Time: 11.42
 */
public class IsideManager {
       public static final int CONFIGURATION_ASSET               =0;
       public static final int CONFIGURATION_PROSPETTO_DI_OFFERTA=1;


       public IsideResponce storeFile(DocumentoIsideBean documentoIsideBean) throws IsideException {
           try {
               IsideManagerDelegate isideClient = ClientWsFactory.getInstance().getIsideClient();
               String result = isideClient.setDocumentoIside(documentoIsideBean);
               IsideResponce isideResponce = new IsideResponce(result,documentoIsideBean.getNomeFile(),documentoIsideBean.getCodiceMimeType());
               return isideResponce;
           } catch (WebServiceClientException e) {
               throw new IsideException(e.getMessage());
           } catch (BusinessException_Exception e) {
               throw new IsideException(e.getMessage());
           }
       }

       public IsideResponce storeFile(byte[] stream,
                                             String nomeFile,
                                             String utente,
                                             int configuration)
                                             throws IsideException {
           
           try {
               IsideConfiguration isideConfiguration = getConfigurazione(configuration);
               isideConfiguration.setFile(stream);
               isideConfiguration.setNomeFile(nomeFile);
               isideConfiguration.setUtente(utente);

               IsideManagerDelegate isideClient = ClientWsFactory.getInstance().getIsideClient();
               DocumentoIsideBean documentoIsideBean = convertBean(isideConfiguration);
               return storeFile(documentoIsideBean);
           } catch (DatatypeConfigurationException e) {
               throw new IsideException(e.getMessage());
           } catch (WebServiceClientException e) {
               throw new IsideException(e.getMessage());
           } catch (IllegalAccessException e) {
               throw new IsideException(e.getMessage());
           } catch (InvocationTargetException e) {
               throw new IsideException(e.getMessage());
           }
       }


        private IsideConfiguration getConfigurazione(int caso) throws DatatypeConfigurationException {
           switch (caso){
               case 0:
                   break;
               case 1:
                   return new ProspettoDiOfferta();
           }
           return null;
       }

       private DocumentoIsideBean convertBean(IsideConfiguration isideConfiguration) throws InvocationTargetException, IllegalAccessException {
           DocumentoIsideBean documentoIsideBean=new DocumentoIsideBean();
           BeanUtils.copyProperties(documentoIsideBean,isideConfiguration);
           return documentoIsideBean;
       }
}
                                  