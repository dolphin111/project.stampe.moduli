package com.fideuram.crm.stampe.engine.dataLoader;


import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.costanti.Costanti;
import com.fideuram.puc.service.impl.AvvisidiScadenzaRamoIIIVO;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.fideuram.puc.service.impl.PolizzaVO;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.PrivateBanker;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 23/06/11
 * Time: 11.10
 */
public class Inseminatore {

    /**
     * Metodo per l'allineamento dei dati della polizza provenienti dai WebService<br>
     * puc verso un bean valido: Polizza.
     * @param polizza
     * @param vo
     * @return HashMap
     */
    public static Polizza mashUpPolizza(Polizza polizza,PolizzaVO vo){
       polizza.setId(vo.getPolizza().toString());
       if(vo.getConferimento() == null){
    	   vo.setConferimento("");
       }
       polizza.setCodice_conferimento(vo.getConferimento());
       polizza.setStato(vo.getStatoPolizza());
       polizza.setTipoFormaAssicurativa(vo.getTipoFormaAssicurazione());
       //polizza.setDataScadenzaPolizza(vo.getDataScadenzaPolizza().toString());
       //polizza.setDataRichiesta(new Date().toString());
       polizza.setDataScadenzaPolizza(DateUtils.formatDate(vo.getDataScadenzaPolizza(),"dd/MM/yyyy"));
       polizza.setDataRichiesta(DateUtils.formatNow("dd/MM/yyyy"));
       
       polizza.setCodiceTariffa(vo.getCodiceTariffa());
       polizza.setDescrizioneTariffa(vo.getDescrizioneTariffa());
       polizza.setDataEmissionePolizza(DateUtils.formatDate(vo.getDataEmissione(), "dd/MM/yyyy"));
       polizza.setCodiceProdotto(vo.getProdotto());
       polizza.setDescrizioneProdottoCommerciale(vo.getDescrizioneCommercialeProdotto());
       if((vo.getTotalePrestazioniCM()!=null)&&(vo.getTotalePrestazioniCM()>0)){
          polizza.setPrestazioni_caso_morte(vo.getTotalePrestazioniCM().toString());
       }
       if((vo.getTotalePrestazioniCV()!=null)&&(vo.getTotalePrestazioniCV()>0)){
          polizza.setPrestazioni_caso_vita(vo.getTotalePrestazioniCV().toString());
       }
       polizza.setTipoPrestazione(vo.getTipoPrestazione());
       polizza.setRamoMinisteriale(vo.getRamoMinisteriale());
       polizza.setReteVendita(vo.getRete());
       return polizza;
    }

    /**
     * Vedi sopra
     * @param vos
     * @param polizza
     * @return Polizza
     */
    public static Polizza mashUpPersona(List<DettaglioAnagraficaVO> vos, Polizza polizza) throws InvocationTargetException, IllegalAccessException {
      DettaglioAnagraficaVO anagrafica = null;
      Contraente c=null;
      Assicurato p1=null;
      Assicurato p2=null;
      PrivateBanker b=null;

      for(int i=0;i<vos.size();i++){
         anagrafica=vos.get(i);
         //String dataNascita = DateUtils.formatDate(anagrafica.getDataNascita(), Costanti.FORMATO_DATA);

         LoggingUtils.debug("<<<<<<<<<<<  RUOLO :" + anagrafica.getRuolo());
         System.out.println("<<<<<<<<<<<  RUOLO :" + anagrafica.getRuolo());

         if(anagrafica.getRuolo().equalsIgnoreCase("contraente")){
          c = new Contraente();
          c.setCodiceFiscale(anagrafica.getCodiceFiscale());
          c.setNome(anagrafica.getNome());
          c.setCognome(anagrafica.getCognome());
          c.setSesso(anagrafica.getSesso());
          c.setDataNascitaString(DateUtils.formatDate(anagrafica.getDataNascita(),"dd/MM/yyyy"));
          //BeanUtils.copyProperties(c, anagrafica);
         }
         else if(anagrafica.getRuolo().equalsIgnoreCase("primoassicurato")){
          p1 = new Assicurato();
          p1.setCodiceFiscale(anagrafica.getCodiceFiscale());
          p1.setNome(anagrafica.getNome());
          p1.setCognome(anagrafica.getCognome());
          p1.setSesso(anagrafica.getSesso());
          p1.setDataNascitaString(DateUtils.formatDate(anagrafica.getDataNascita(),"dd/MM/yyyy"));
          //BeanUtils.copyProperties(p1,anagrafica);
          p1.setLivello(1);
         }
         else if(anagrafica.getRuolo().equalsIgnoreCase("secondoassicurato")){
          p2 = new Assicurato();
          p2.setCodiceFiscale(anagrafica.getCodiceFiscale());
          p2.setNome(anagrafica.getNome());
          p2.setCognome(anagrafica.getCognome());
          p2.setSesso(anagrafica.getSesso());
          p2.setDataNascitaString(DateUtils.formatDate(anagrafica.getDataNascita(),"dd/MM/yyyy"));
          //BeanUtils.copyProperties(p2,anagrafica);
          p2.setLivello(2);
         }
         else if(anagrafica.getRuolo().equalsIgnoreCase("banker")){
          b = new PrivateBanker();
          b.setCodiceFiscale(anagrafica.getCodiceFiscale());
          b.setNome(anagrafica.getNome());
          b.setCognome(anagrafica.getCognome());
          b.setSesso(anagrafica.getSesso());
          b.setDataNascitaString(DateUtils.formatDate(anagrafica.getDataNascita(),"dd/MM/yyyy"));
          //BeanUtils.copyProperties(b,anagrafica);
         }
      }      
      if(c!=null) polizza.setContraente(c);
      if(p1!=null) polizza.setPrimoassicurato(p1);
      if(p2!=null) polizza.setSecondoassicurato(p2);
      if(b!=null) polizza.setPb(b);
      return polizza;
    }

    public static Polizza mashUpAvvisi(AvvisidiScadenzaRamoIIIVO vo, Polizza polizza) throws InvocationTargetException, IllegalAccessException {
    	//booleano aggiunto per controllare se la polizza ha o meno la tabellina dell'OPZIONE DI CERTEZZA
    	boolean controlloCertezza = false;
    	if(vo != null){
			if(vo.getRenditaAnnuavitaliziaMinimaGarantita() != null){
				polizza.setRenditaAnnuaVitMinimaGar(NumberUtils.formatCurrency(
						vo.getRenditaAnnuavitaliziaMinimaGarantita(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			}else {
				polizza.setRenditaAnnuaVitMinimaGar("");
			}

			if(vo.getValoreRiscattoScadenzaGarantito() != null){
				polizza.setValoreRiscattoScadGarantito(NumberUtils.formatCurrency(
						vo.getValoreRiscattoScadenzaGarantito(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setValoreRiscattoScadGarantito("");
			}

			if(vo.getIpotesiRenditaAnnuaPosticipataScadenzaCVT() != null){
				polizza.setIpotesiRenditaAnnuaPosticipataScadenzaCTV(NumberUtils.formatCurrency(
						vo.getIpotesiRenditaAnnuaPosticipataScadenzaCVT(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setIpotesiRenditaAnnuaPosticipataScadenzaCTV("");
			}

			if(vo.getIpotesiValoreriScattoScadenzaCVT() != null){
				polizza.setIpotesiValoreRiscattoScadenzaCTV(NumberUtils.formatCurrency(
						vo.getIpotesiValoreriScattoScadenzaCVT(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setIpotesiValoreRiscattoScadenzaCTV("");
			}

			if(vo.getTotalerenditaFrazionataAnnualePosticipata() != null){
				polizza.setTotaleRenditaFrazionataAnnualePosticipata(NumberUtils.formatCurrency(
						vo.getTotalerenditaFrazionataAnnualePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setTotaleRenditaFrazionataAnnualePosticipata("");
			}

			if(vo.getTotalerenditaFrazionataSemestralePosticipata() != null){
				polizza.setTotaleRenditaFrazionataSemestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotalerenditaFrazionataSemestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setTotaleRenditaFrazionataSemestralePosticipata("");
			}

			if(vo.getTotalerenditaFrazionataTrimestralePosticipata() != null){
				polizza.setTotaleRenditaFrazionataTrimestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotalerenditaFrazionataTrimestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setTotaleRenditaFrazionataTrimestralePosticipata("");
			}

			if(vo.getTotalerenditaFrazionataMensilePosticipata() != null){
				polizza.setTotaleRenditaFrazionataMensilePosticipata(NumberUtils.formatCurrency(
						vo.getTotalerenditaFrazionataMensilePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setTotaleRenditaFrazionataMensilePosticipata("");
			}
			
							// CERTEZZA
			if(vo.getTotaleRenditaCerta1AnnualePosticipata() != null && vo.getTotaleRenditaCerta1AnnualePosticipata() > 0){
				polizza.setTotaleRenditaCerta1AnnualePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta1AnnualePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta1AnnualePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta2AnnualePosticipata() != null && vo.getTotaleRenditaCerta2AnnualePosticipata() > 0){
				polizza.setTotaleRenditaCerta2AnnualePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta2AnnualePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta2AnnualePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta3AnnualePosticipata() != null && vo.getTotaleRenditaCerta3AnnualePosticipata() > 0){
				polizza.setTotaleRenditaCerta3AnnualePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta3AnnualePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta3AnnualePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta4AnnualePosticipata() != null && vo.getTotaleRenditaCerta4AnnualePosticipata() > 0){
				polizza.setTotaleRenditaCerta4AnnualePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta4AnnualePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta4AnnualePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta1SemestralePosticipata() != null && vo.getTotaleRenditaCerta1SemestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta1SemestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta1SemestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta1SemestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta2Semestraleposticipata() != null && vo.getTotaleRenditaCerta2Semestraleposticipata() > 0){
				polizza.setTotaleRenditaCerta2SemestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta2Semestraleposticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta2SemestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta3SemestralePosticipata() != null && vo.getTotaleRenditaCerta3SemestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta3SemestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta3SemestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta3SemestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta4SemestralePosticipata() != null && vo.getTotaleRenditaCerta4SemestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta4SemestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta4SemestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta4SemestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta1TrimestralePosticipata() != null && vo.getTotaleRenditaCerta1TrimestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta1TrimestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta1TrimestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta1TrimestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta2TrimestralePosticipata() != null && vo.getTotaleRenditaCerta2TrimestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta2TrimestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta2TrimestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta2TrimestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta3TrimestralePosticipata() != null && vo.getTotaleRenditaCerta3TrimestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta3TrimestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta3TrimestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta3TrimestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta4TrimestralePosticipata() != null && vo.getTotaleRenditaCerta4TrimestralePosticipata() > 0){
				polizza.setTotaleRenditaCerta4TrimestralePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta4TrimestralePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta4TrimestralePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta1MensilePosticipata() != null && vo.getTotaleRenditaCerta1MensilePosticipata() > 0){
				polizza.setTotaleRenditaCerta1MensilePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta1MensilePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta1MensilePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta2MensilePosticipata() != null && vo.getTotaleRenditaCerta2MensilePosticipata() > 0){
				polizza.setTotaleRenditaCerta2MensilePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta2MensilePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta2MensilePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta3MensilePosticipata() != null && vo.getTotaleRenditaCerta3MensilePosticipata() > 0){
				polizza.setTotaleRenditaCerta3MensilePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta3MensilePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta3MensilePosticipata("ND");
			}

			if(vo.getTotaleRenditaCerta4MensilePosticipata() != null && vo.getTotaleRenditaCerta4MensilePosticipata() > 0){
				polizza.setTotaleRenditaCerta4MensilePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta4MensilePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta4MensilePosticipata("ND");
			}	
			
			if(vo.getTotaleRenditaCerta4MensilePosticipata() != null && vo.getTotaleRenditaCerta4MensilePosticipata() > 0){
				polizza.setTotaleRenditaCerta4MensilePosticipata(NumberUtils.formatCurrency(
						vo.getTotaleRenditaCerta4MensilePosticipata(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
				controlloCertezza = true;
			} else {
				polizza.setTotaleRenditaCerta4MensilePosticipata("ND");
			}		
			
			if(vo.getDataRiferimentoNav() != null){
				polizza.setDataRiferimentoNav(DateUtils.formatDate(vo.getDataRiferimentoNav().toGregorianCalendar(), Costanti.FORMATO_DATA));
			} else {
				polizza.setDataRiferimentoNav("");
			}	
			
			if(vo.getNumeroQuote() != null){
				polizza.setNumeroQuote(NumberUtils.formatCurrency(
						vo.getNumeroQuote(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setNumeroQuote("");
			}
			
			if(vo.getControValoreQuote() != null){
				polizza.setControvaloreQuote(NumberUtils.formatCurrency(
						vo.getControValoreQuote(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setControvaloreQuote("");
			}
			
			if(vo.getImportoNettoRiscattoTermine() != null){
				polizza.setValoreRiscattoNetto(NumberUtils.formatCurrency(
						vo.getImportoNettoRiscattoTermine(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));
			} else {
				polizza.setValoreRiscattoNetto("");
			}
			
			if(vo.getAnniCertezza1() != null){
				polizza.setAnniCertezza(String.valueOf(vo.getAnniCertezza1()));
			}else{
				polizza.setAnniCertezza("");
			}
		}     	
    	polizza.setControlloCertezza(controlloCertezza);
    	return polizza;
    }    
}