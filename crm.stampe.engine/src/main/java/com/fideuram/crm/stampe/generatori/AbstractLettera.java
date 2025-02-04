package com.fideuram.crm.stampe.generatori;

import com.fideuram.crm.service.CrmServiceWSImpl;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.serviceclient.universo.NuovoUniversoClientWS;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.service.Exception_Exception;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.puc.service.impl.InfoPolizzaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 01/06/11
 * Time: 11.39
 */
public abstract class AbstractLettera {
     private     ClientWsFactory       wsFactory    = null;
     protected   ComunicazioneVO       comunicazione= null;
     protected   List<DomandaVO>       listaDomande = new ArrayList<DomandaVO>();
     protected   StampeServiceImpl     pucS;
     protected   CrmServiceWSImpl      crmS;
     protected   NuovoUniversoClientWS uniS;
     protected   int  comID;
     



    private void loadComunicazione(String comID) throws WebServiceClientException, Exception_Exception {
		 comunicazione = crmS.getComunicazioneById(new Integer(comID));
    }

    public ComunicazioneVO getComunicazione(String comID) throws WebServiceClientException, CrmException {
         if (comunicazione==null){
             try {
                 loadComunicazione(comID);
             } catch (Exception_Exception e) {
                throw new CrmException(e);
            }
         }
         return comunicazione ;
     }



     protected String getTripletta(DomandaVO domanda ){
         String  tripletta =
					  domanda.getDescrizioneDomanda().getVecchioliv1()
					+ domanda.getDescrizioneDomanda().getVecchioliv2()
					+ domanda.getDescrizioneDomanda().getVecchioliv3();
         return tripletta;
     }

    /**
     * Ogni counicazione può accorpare una o n Domande
	 */
	protected void sortDomande() {
		List<DomandaVO> domandeOrig = comunicazione.getDomande();

		if (domandeOrig != null) {
			// Ordinamento secondo lettera accompagnamento
			for (DomandaVO d : domandeOrig) {
				// Salto quella con la lettera generica
				if(d.getDescrizioneDomanda().getTemplate().getID() == Costanti.ID_LETTERA_GENERICA)
					continue;

				if (!d.getDescrizioneDomanda().getTemplate().isNeedsLetteraAccompagnamento()) {
					listaDomande.add(0, d);
				} else {
					listaDomande.add(d);
				}
			}

			// Non ho caricato nessuna domanda poiche' tutte generiche, ne aggiungo una sola.
			if(listaDomande.isEmpty()) {
				listaDomande.add(domandeOrig.get(0));
			}

		}
	}

    public List<Polizza> getPolizzaByDomanda(int comid,DomandaVO domanda) throws PucException, WebServiceClientException, StampeInfoException {
        List<Polizza > l = new ArrayList<Polizza>();
        for (com.fideuram.crm.vo.PolizzaVO polizza : domanda.getPolizze()) {
            InfoPolizzaVO vo = null;
            try {
                vo = pucS.getDatiPolizzaByPolizza(new Long(polizza.getNumeroPolizza()));
            } catch (ServiceException_Exception e) {
               throw new PucException(e);
            }
            Polizza p = new Polizza();
            try {
                BeanUtils.copyProperties(p,vo);
            } catch (IllegalAccessException e) {
                throw new StampeInfoException(e);
            } catch (InvocationTargetException e) {
                throw new StampeInfoException(e);
            }
            l.add(p);
        }
        return l;
    }

}
