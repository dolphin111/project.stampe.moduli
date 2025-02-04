package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.vospolizza.prestazioni.CapGarantito;
import com.fideuram.crm.stampe.model.vospolizza.prestazioni.CapNnGarantito;
import com.fideuram.crm.stampe.model.vospolizza.prestazioni.PrestazioneBase;
import com.fideuram.crm.stampe.model.vospolizza.prestazioni.Rendita;
import com.fideuram.crm.stampe.model.vospolizza.rendita.Certezza;
import com.fideuram.crm.stampe.model.vospolizza.rendita.Frazionamento;
import com.fideuram.crm.stampe.model.vospolizza.rendita.IpotesiRendita;
import com.fideuram.crm.stampe.model.vospolizza.reversibilita.Reversibilita;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoBean;
import com.fideuram.puc.service.impl.*;
import com.fideuram.stampe.dao.PucDao;

import java.math.BigDecimal;
import java.util.List;

public class LetteraOpzioneRamo3 extends LetteraEngine{
    OpzioniRamo3InputVO parameters;

    public LetteraOpzioneRamo3(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void completaPolizza(Polizza polizza, OpzioniRamo3InputVO parameters) throws WebServiceClientException, StampeInfoException, PucException {
        this.parameters=parameters;

		try {
            // Mi ricavo il frazionamento
            OpzioneFrazionamentoVO frazionamemnto = pucS.getOpzioniRamo3Frazionamento(parameters);
            Frazionamento _frazionamento = new Frazionamento(frazionamemnto);

            //carico le opzioni di rendita certa
            List<OpzioneCertezzaVO> lCertezza=pucS.getOpzioniRamo3Certezza(parameters);
            Certezza certezza=new Certezza(lCertezza);

            //configuro le ipotesi di rendita caricando le opzioni certezza ed il frazionamento
            IpotesiRendita ipotesiRendita=new IpotesiRendita();
            ipotesiRendita.setCertezza(certezza);
            ipotesiRendita.setFrazionamento(_frazionamento);

            //passo le ipotesi di Rendita alla polizza
            polizza.setRendita(ipotesiRendita);

            //Mi ricavo le Opzioni di Riscatto
            OpzioneRiscattoAlTermineVO opzioneRiscattoAlTermine=pucS.getOpzioniRamo3RiscattoAlTermine(parameters);
            buildPrestazioneBean(polizza,opzioneRiscattoAlTermine,frazionamemnto);
            
            if(polizza.getCodiceTariffa().equals("900") || polizza.getCodiceTariffa().equals("910") 
            		&& polizza.getTipoPrestazione().equalsIgnoreCase("cg") || polizza.getTipoPrestazione().equalsIgnoreCase("r")){
	            try{
                    BigDecimal coefficiente = new PucDao(comID).getCoefficienteRiscattoFul(polizza.getSospensioneScadenza());
					Object o = polizza.getPrestazioni();
					if(o instanceof CapGarantito){
						CapGarantito capG = (CapGarantito)o;
		            	int indicatoreTipoRisc = 1;
		                String dataValutazione = polizza.getAttributo("dataValutazione");
		                WSRiscattoBean bean = uniS.getRiscattoPolizzeAperte(polizza.getNumero(), dataValutazione, indicatoreTipoRisc);
						String renditaIniziale = bean.getRenditaIniziale();
						if(renditaIniziale != null && !renditaIniziale.trim().equals("")){
							renditaIniziale = renditaIniziale.replace(".", "");
							renditaIniziale = renditaIniziale.replace(",", ".");
							BigDecimal renditaInizialeD = new BigDecimal(renditaIniziale);

							/*
                            CalcoloRiscattoTermineVO voInput = new CalcoloRiscattoTermineVO();
							voInput.setNumeroPolizza(polizza.getNumero());
							BigDecimal coefficiente = client.getCoefficenteRiscattoFulByNumeroPolizza(voInput);
							*/
							double calcolato = arrotonda(renditaInizialeD.doubleValue() * coefficiente.doubleValue(),2);
							capG.setValoreRiscattoScadenzaGarantito(calcolato);
						}
					}else{
						Rendita r = (Rendita)o;										
						String renditaIniziale = r.getVitalizioAnnuoMinimoGarantito();
						if(renditaIniziale != null && !renditaIniziale.trim().equals("")){
							renditaIniziale = renditaIniziale.replace(".", "");
							renditaIniziale = renditaIniziale.replace(",", ".");
							BigDecimal renditaInizialeD = new BigDecimal(renditaIniziale);
                            /*
							CalcoloRiscattoTermineVO voInput = new CalcoloRiscattoTermineVO();
							voInput.setNumeroPolizza(polizza.getNumero());
							BigDecimal coefficiente = client.getCoefficenteRiscattoFulByNumeroPolizza(voInput);
							*/
							double calcolato = arrotonda(renditaInizialeD.doubleValue() * coefficiente.doubleValue(),2);
							r.setValoreRiscattoScadenzaGarantito(calcolato);
						}
					}
	            }catch(Exception e){
					throw new StampeInfoException("(93)OPZ_R3 eccezione ritornata dal metodo del puc" +
							  " getCoefficenteRiscattoFulByNumeroPolizza "+e.getMessage()+" per la polizza: " + polizza.getNumero());				
				}
			}

            /* RENDITA REVERSIBLE */
            OpzioniRamo3ReversibilitaVO reversibilita = pucS.getOpzioniRamo3Reversibilita(parameters);
            polizza.setReversibilita(new Reversibilita(reversibilita));
            //Nel caso in cui si verificasse la condizione seguente, nel template verrà aggiunta una frase in testa
            if("FAP".trim().equals(polizza.getDescrizioneFondoSintetica()) 
            		&& "R".equals(polizza.getTipoPrestazione())){            	
            	polizza.setFAP_R(true);
            }

            polizza.setDifferimento();
		} catch (ServiceException_Exception e) {
			throw new PucException(e.getMessage());
		}
	}

    /**
     * Questo metodo si occupa di istanziare il corretto tipo di Prestazione:   <br>
     * CapGarantito                                                             <br>
     * CapNnGarantito                                                           <br>
     * Rendita                                                                  <br>
     * @param polizza
     * @param opz
     * @param frazionamemnto
     */
    private void buildPrestazioneBean(Polizza polizza, OpzioneRiscattoAlTermineVO opz, OpzioneFrazionamentoVO frazionamemnto)
    {
        //IPrestazioni _i=null;
        PrestazioneBase _i=null;

        if ("R".equalsIgnoreCase(polizza.getTipoPrestazione())){
            _i= new Rendita(opz,frazionamemnto);
        }
        if (("C".equalsIgnoreCase(polizza.getTipoPrestazione()))&&("S".equalsIgnoreCase(polizza.getProdottoGarantito())))
            _i= new CapGarantito(opz);
        else if (("C".equalsIgnoreCase(polizza.getTipoPrestazione()))&&("N".equalsIgnoreCase(polizza.getProdottoGarantito())))
            _i= new CapNnGarantito(opz);
        if(_i!=null)
           _i.setDifferimento(polizza.getPrimoDifferimento()!=null?polizza.getPrimoDifferimento():new Long(0));
       polizza.setPrestazioni(_i);
    }
    
    private double arrotonda(double number, int decimal) {
		double p = (double)Math.pow(10,decimal);
		number = number * p;
		double tmp = Math.round(number);
		return (double)tmp/p;
	}
}
