package com.fideuram.processo.cud;

import com.fideuram.stampe.modello.cud.AnagraficaDipendente;
import com.fideuram.stampe.modello.cud.CUD;

/**
 * Created with
 * User: v801068
 * Date: 27/01/14
 * Time: 11.40
 */
public class CUDToObjectArrayConverter {
    public static Object[] getArrayBeans(CUD cud){
 
    	Object[] cudArray = new Object[197];
    	if(cud.getAnagraficaDatLav().getCAP()!=null){
    		cudArray[0]= cud.getAnagraficaDatLav().getCAP();
    	}
    	else 
    		cudArray[0]="";
    	
    	if(cud.getAnagraficaDatLav().getCodAttivita()!=null){
    		cudArray[1]= cud.getAnagraficaDatLav().getCodAttivita(); 
		}
		else 
			cudArray[1]="";
    	
    	if(cud.getAnagraficaDatLav().getCodFis()!=null){
    		cudArray[2]= cud.getAnagraficaDatLav().getCodFis();
		}
		else 
			cudArray[2]="";
    	
    	if(cud.getAnagraficaDatLav().getCodSede()!=null){
    		cudArray[3]= cud.getAnagraficaDatLav().getCodSede();
		}
		else 
			cudArray[3]="";
    	
    	if(cud.getAnagraficaDatLav().getCognome_denominazione()!=null){
    		cudArray[4]= cud.getAnagraficaDatLav().getCognome_denominazione();
    	}
		else 
			cudArray[4]="";
    	
    	if(cud.getAnagraficaDatLav().getComune()!=null){
    		cudArray[5]= cud.getAnagraficaDatLav().getComune(); 
    	}
		else 
			cudArray[5]="";
    	
    	if(cud.getAnagraficaDatLav().getEmail()!=null){
    		cudArray[6]= cud.getAnagraficaDatLav().getEmail();
    	}
		else 
			cudArray[6]="";
    	
    	if(cud.getAnagraficaDatLav().getIndirizzo()!=null){
    		cudArray[7]= cud.getAnagraficaDatLav().getIndirizzo(); 
    	}
		else 
			cudArray[7]="";
    	
    	if(cud.getAnagraficaDatLav().getNome()!=null){
    		cudArray[8]=cud.getAnagraficaDatLav().getNome(); 
    	}
		else 
			cudArray[8]="";
    	
    	if(cud.getAnagraficaDatLav().getProvincia()!=null){
    		cudArray[9]= cud.getAnagraficaDatLav().getProvincia(); 
    	}
		else 
			cudArray[9]="";
    	
    	if(cud.getAnagraficaDatLav().getTel_fax()!=null){
    		cudArray[10]= cud.getAnagraficaDatLav().getTel_fax();
    	}
		else 
			cudArray[10]="";
    	
    	if(cud.getAnagraficaDip().getCodComuneDomAnnoPrec()!=null){
    		cudArray[11]= cud.getAnagraficaDip().getCodComuneDomAnnoPrec();
    	}
		else 
			cudArray[11]="";
    	
    	if(cud.getAnagraficaDip().getCodComuneDomCorrente()!=null){
    		cudArray[12]= cud.getAnagraficaDip().getCodComuneDomCorrente(); 
    	}
		else 
			cudArray[12]="";
    	
    	if(cud.getAnagraficaDip().getCodFis()!=null){
    		cudArray[13]= cud.getAnagraficaDip().getCodFis();
    	}
		else 
			cudArray[13]="";
    	
    	if(cud.getAnagraficaDip().getCognome()!=null){
    		cudArray[14]= cud.getAnagraficaDip().getCognome();
    	}
		else 
			cudArray[14]="";
    	
    	if(cud.getAnagraficaDip().getComuneNascita()!=null){
    		cudArray[15]= cud.getAnagraficaDip().getComuneNascita();
    	}
		else 
			cudArray[15]="";
    	
		if(cud.getAnagraficaDip().getDataIscrFondo()!=null){
    		cudArray[16]= cud.getAnagraficaDip().getDataIscrFondo();
    	}
		else 
			cudArray[16]="-- -- ----";
    	
    	if(cud.getAnagraficaDip().getDataNascita()!=null){
    		cudArray[17]= cud.getAnagraficaDip().getDataNascita(); 
    	}
		else 
			cudArray[17]="-- -- ----";
    	
    	if(cud.getAnagraficaDip().getDomicilioAnnoPrec()!=null){
    		cudArray[18]= cud.getAnagraficaDip().getDomicilioAnnoPrec();
    	}
		else 
			cudArray[18]="";
    	
    	if(cud.getAnagraficaDip().getDomicilioCorrente()!=null){
    		cudArray[19]= cud.getAnagraficaDip().getDomicilioCorrente();
    	}
		else 
			cudArray[19]="";
    	
    	if(cud.getAnagraficaDip().getDomicilioFineRappLav()!=null){
    		cudArray[20]= cud.getAnagraficaDip().getDomicilioFineRappLav();	
    	}
		else 
			cudArray[20]="";
    	
    	if(cud.getAnagraficaDip().getEventiEcc()!=null){
    		cudArray[21]= cud.getAnagraficaDip().getEventiEcc();
    	}
		else 
			cudArray[21]="";
    	
    	if(cud.getAnagraficaDip().getNome()!=null){
    		cudArray[22]= cud.getAnagraficaDip().getNome(); 
    	}
		else 
			cudArray[22]="";
    	
    	if(cud.getAnagraficaDip().getPrevidComplem()!=null){
    		cudArray[23]= cud.getAnagraficaDip().getPrevidComplem();
    	}
		else 
			cudArray[23]="";
    	
    	if(cud.getAnagraficaDip().getProvDomAnnoPrec()!=null){
    		cudArray[24]= cud.getAnagraficaDip().getProvDomAnnoPrec();
    	}
		else 
			cudArray[24]="";
    	
    	if(cud.getAnagraficaDip().getProvDomCorrente()!=null){
    		cudArray[25]= cud.getAnagraficaDip().getProvDomCorrente();
    	}
		else 
			cudArray[25]="";
    	
    	if(cud.getAnagraficaDip().getProvDomFineRappLav()!=null){	
    		cudArray[26]= cud.getAnagraficaDip().getProvDomFineRappLav();
    	}
		else 
			cudArray[26]="";
    	
    	if(cud.getAnagraficaDip().getProvinciaNascita()!=null){
    		cudArray[27]= cud.getAnagraficaDip().getProvinciaNascita();
    	}
		else 
			cudArray[27]="";
    	
    	if(cud.getAnagraficaDip().getSesso()!=null){
    		cudArray[28]= cud.getAnagraficaDip().getSesso();
    	}
		else 
			cudArray[28]="";
    	
    	if(cud.getAnagraficaDip().getCap()!=null){
    		cudArray[175]= cud.getAnagraficaDip().getCap();
    	}
		else 
			cudArray[175]="";
    	
    	if(cud.getAnagraficaDip().getIndirizzoDip()!=null){
    		cudArray[176]= cud.getAnagraficaDip().getIndirizzoDip();
    	}
		else 
			cudArray[176]="";
    	
		cudArray[29]= cud.getDatiFiscali().getAccAddComIrpef();
		cudArray[30]= cud.getDatiFiscali().getAccAddComIrpefSosp(); 
		cudArray[31]= cud.getDatiFiscali().getAccCedSecSosp(); 
		cudArray[32]= cud.getDatiFiscali().getAccIrpefSosp(); 
		cudArray[33]= cud.getDatiFiscali().getAddComIrpefAccCorr();
		cudArray[34]= cud.getDatiFiscali().getAddComIrpefAccPrec(); 
		cudArray[35]= cud.getDatiFiscali().getAddComIrpefSaldoPrec(); 
		cudArray[36]= cud.getDatiFiscali().getAddComIrpefSospAccPrec();	
		cudArray[37]= cud.getDatiFiscali().getAddComIrpefSospSaldoPrec(); 
		cudArray[38]= cud.getDatiFiscali().getAddRegIrpef();
		cudArray[39]= cud.getDatiFiscali().getAddRegIrpefSosp(); 
		cudArray[40]= cud.getDatiFiscali().getCredAddComIrpefNoRimb(); 
		cudArray[41]= cud.getDatiFiscali().getCredAddRegIrpefNoRimb(); 
		cudArray[42]= cud.getDatiFiscali().getCredCedSecNoRimb();
		cudArray[43]= cud.getDatiFiscali().getCredIrpefNoRimb();
		
		if(cud.getDatiFiscali().getGiorni1234TuirLavDip()!=null)
			cudArray[44]= cud.getDatiFiscali().getGiorni1234TuirLavDip();
		else
			cudArray[44]="";
		
		if(cud.getDatiFiscali().getGiorni1234TuirPensione()!=null)
			cudArray[45]= cud.getDatiFiscali().getGiorni1234TuirPensione();
		else
			cudArray[45]="";
		
		cudArray[46]= cud.getDatiFiscali().getPrimAccIrpefTrat();
		cudArray[47]= cud.getDatiFiscali().getPrimRataAccCedSec();
		cudArray[48]= cud.getDatiFiscali().getRedditi1234Tuir(); 
		cudArray[49]= cud.getDatiFiscali().getRedditi5_5bisTuir();
		cudArray[50]= cud.getDatiFiscali().getRitenIrpefSosp(); 
		cudArray[51]= cud.getDatiFiscali().getRitenutaIrpef();
		cudArray[52]= cud.getDatiFiscali().getSec_unicAccIrpefTrat();	
		cudArray[53]= cud.getDatiFiscali().getSec_unicRataAccCedSec();
    		
    	cudArray[54]= cud.getAltriDatiFis().getContrPrevComplEsclRedditi();
    	cudArray[55]= cud.getAltriDatiFis().getContrPrevComplNoEsclRedditi(); 
    	cudArray[56]= cud.getAltriDatiFis().getCPCLPOAnniRes();
    	cudArray[57]= cud.getAltriDatiFis().getCPCLPOApplMagRit();
    	cudArray[58]= cud.getAltriDatiFis().getCPCLPOAssicSanit();
    	cudArray[59]= cud.getAltriDatiFis().getCPCLPOCasiPart(); 
    	cudArray[60]= cud.getAltriDatiFis().getCPCLPOContrAssist();		
    	cudArray[61]= cud.getAltriDatiFis().getCPCLPOContrSolid();
    	cudArray[62]= cud.getAltriDatiFis().getCPCLPOContrSolidSosp();
    	cudArray[63]= cud.getAltriDatiFis().getCPCLPODiffer(); 
    	cudArray[64]= cud.getAltriDatiFis().getCPCLPOEcced(); 	
    	cudArray[65]= cud.getAltriDatiFis().getCPCLPOPrevCompFam();
    	cudArray[66]= cud.getAltriDatiFis().getCPCLPOTot();
    	cudArray[67]= cud.getAltriDatiFis().getCPCLPOTotOneriDetraz(); 
    	cudArray[68]= cud.getAltriDatiFis().getCPCLPOTotOneriNORedditi();	
    	cudArray[69]= cud.getAltriDatiFis().getCPCLPOVersati();
    	cudArray[70]= cud.getAltriDatiFis().getCredCanLocRec(); 
    	cudArray[71]= cud.getAltriDatiFis().getCredFamNumRec();
    	cudArray[72]= cud.getAltriDatiFis().getCredImpPagEstero();	
    	cudArray[73]= cud.getAltriDatiFis().getCredNoRicCanLoc();
    	cudArray[74]= cud.getAltriDatiFis().getCredNoRicFamNum();
    	cudArray[75]= cud.getAltriDatiFis().getCredRicCanLoc();
    	cudArray[76]= cud.getAltriDatiFis().getCredRiconFamNum(); 	
    	cudArray[77]= cud.getAltriDatiFis().getDetrazFamiglia();
    	cudArray[78]= cud.getAltriDatiFis().getDetrazFamNum();
    	cudArray[79]= cud.getAltriDatiFis().getDetrCanLoc(); 
    	cudArray[80]= cud.getAltriDatiFis().getDetrLavDip_Pens_Redditi();	
    	cudArray[81]= cud.getAltriDatiFis().getDetrOneri(); 
    	cudArray[82]= cud.getAltriDatiFis().getImpostaLorda();
    	cudArray[83]= cud.getAltriDatiFis().getTotDetrazioni();
    	cudArray[91]= cud.getAltriDatiFis().getCPCLPOTotOneriNOEsclRedditi();  	
    		
    	cudArray[84]= cud.getDatiConguagli().getIrpefDaVers();		
    	cudArray[85]= cud.getDatiConguagli().getIrpefTratSuc28Feb();
    	cudArray[86]= cud.getDatiConguagli().getTotredCong1();
    	cudArray[87]= cud.getDatiConguagli().getTotredCong2();
    	

    	if(cud.getSommeIncrProd().getIstruzioni()!=null){
    		cudArray[88]= cud.getSommeIncrProd().getIstruzioni();
    	}
		else 
			cudArray[88]="";
    	
    	cudArray[89]= cud.getSommeIncrProd().getReddNoImp();
    	cudArray[90]= cud.getSommeIncrProd().getRitSosp();
    	cudArray[92]= cud.getSommeIncrProd().getTotRedd13();		
    	cudArray[93]= cud.getSommeIncrProd().getTotRit();
    	
    	
    	cudArray[94]= cud.getRedditiImponibili().getTotAddRegIrpef(); 
    	cudArray[95]= cud.getRedditiImponibili().getTotAddRegIrpefSosp(); 
    	cudArray[96]= cud.getRedditiImponibili().getTotRedd();
    	cudArray[97]= cud.getRedditiImponibili().getTotRitIrpef();
    	cudArray[98]= cud.getRedditiImponibili().getTotRitIrpefSosp();
    	
    	
    	cudArray[99]= cud.getCompensiAnniPrec().getTotCompArrDetr();
    	cudArray[100]= cud.getCompensiAnniPrec().getTotCompArrNoDetr();	
    	cudArray[101]= cud.getCompensiAnniPrec().getTotRitOper();
    	cudArray[102]= cud.getCompensiAnniPrec().getTotRitSosp();
    	
    	
    	cudArray[103]= cud.getTfr().getAccAntAnniPrec(); 
    	cudArray[104]= cud.getTfr().getDetrazione();	
    	cudArray[105]= cud.getTfr().getIndAccAntSomAnno(); 
    	cudArray[106]= cud.getTfr().getIndArt2122();
    	cudArray[107]= cud.getTfr().getRitenAnniPrec();
    	cudArray[108]= cud.getTfr().getRitenAnniPrecSosp();		
    	cudArray[109]= cud.getTfr().getRitenutaAnno();
    	cudArray[110]= cud.getTfr().getRitenuteSosp();
    	cudArray[111]= cud.getTfr().getTfrNoPrelMatDa01();
    	cudArray[112]= cud.getTfr().getTfrNoPrelMatFi00();    	
    	cudArray[113]= cud.getTfr().getTfrVersMat01_06();
    	cudArray[114]= cud.getTfr().getTfrVersMatDa07();
    	cudArray[115]= cud.getTfr().getTfrVersMatFi00(); 
    	
    	
    	cudArray[116]= cud.getDatiINPS().getInpsColl().getCompensi();		
    	cudArray[117]= cud.getDatiINPS().getInpsColl().getContribDovuti(); 
    	cudArray[118]= cud.getDatiINPS().getInpsColl().getContribTrattenuti();
    	cudArray[119]= cud.getDatiINPS().getInpsColl().getContribVersati();
    	
    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[0])!=null &&
    			String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[0]).equalsIgnoreCase("x"))
    		cudArray[120]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[0];
    	else
    		cudArray[120]="";
    	
    	int j=151;
    	for(int i=1; i<13;i++)
    	{
    		if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[i])!=null &&
        			String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[i]).equalsIgnoreCase("x")){
    			cudArray[j]= String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[i]).toUpperCase();
    		}
    		else{
    			cudArray[j]="";
    		}
    		j++;
    	}
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[1])!=null)
//    		cudArray[151]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[1];
//    	else
//    		cudArray[151]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[2])!=null)
//    		cudArray[152]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[2];
//    	else
//    		cudArray[152]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[3])!=null)
//    		cudArray[153]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[3];
//    	else
//    		cudArray[153]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[4])!=null)
//    		cudArray[154]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[4];
//    	else
//    		cudArray[154]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[5])!=null)
//    		cudArray[155]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[5];
//    	else
//    		cudArray[155]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[6])!=null)
//    		cudArray[156]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[6];
//    	else
//    		cudArray[156]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[7])!=null)
//    		cudArray[157]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[7];
//    	else
//    		cudArray[157]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[8])!=null)
//    		cudArray[158]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[8];
//    	else
//    		cudArray[158]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[9])!=null)
//    		cudArray[159]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[9];
//    	else
//    		cudArray[159]="";
//
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[10])!=null)
//    		cudArray[160]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[10];
//    	else
//    		cudArray[160]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[11])!=null)
//    		cudArray[161]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[11];
//    	else
//    		cudArray[161]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[12])!=null)
//    		cudArray[162]= cud.getDatiINPS().getInpsColl().getMesiDenUniemens()[12];
//    	else
//    		cudArray[162]="";
    	
    	if(cud.getDatiINPS().getInpsPub().getAnnoRif()!=null){
    	cudArray[121]= cud.getDatiINPS().getInpsPub().getAnnoRif();
    	}
		else 
			cudArray[121]="";
    	
    	if(cud.getDatiINPS().getInpsPub().getCodFisAmm()!=null){
    	cudArray[122]= cud.getDatiINPS().getInpsPub().getCodFisAmm();
    	}
		else 
			cudArray[122]="";
    	
    	if(cud.getDatiINPS().getInpsPub().getCodSPT_MEF()!=null){
    	cudArray[123]= cud.getDatiINPS().getInpsPub().getCodSPT_MEF();
    	}
		else 
			cudArray[123]="";
    	
    	cudArray[124]= cud.getDatiINPS().getInpsPub().getGestCredEnam(); 		
    	cudArray[125]= cud.getDatiINPS().getInpsPub().getGestCredEndep();
    	cudArray[126]= cud.getDatiINPS().getInpsPub().getGestPens();
    	cudArray[127]= cud.getDatiINPS().getInpsPub().getGestPrev();
    	
    	if(cud.getDatiINPS().getInpsPub().getProgAzienda()!=null){
    	cudArray[128]= cud.getDatiINPS().getInpsPub().getProgAzienda();	
    	}
		else 
			cudArray[128]="";
    		
    	cudArray[129]= cud.getDatiINPS().getInpsPub().getTotContribENPDEP_ENAM();
    	cudArray[130]= cud.getDatiINPS().getInpsPub().getTotContribGestCred(); 
    	cudArray[131]= cud.getDatiINPS().getInpsPub().getTotContribPens();
    	cudArray[132]= cud.getDatiINPS().getInpsPub().getTotContribTFR(); 		
    	cudArray[133]= cud.getDatiINPS().getInpsPub().getTotContribTFS();
    	cudArray[134]= cud.getDatiINPS().getInpsPub().getTotImpENPDEP_ENAM();
    	cudArray[135]= cud.getDatiINPS().getInpsPub().getTotImpGestCred();
    	cudArray[136]= cud.getDatiINPS().getInpsPub().getTotImpPens();     	
    	cudArray[137]= cud.getDatiINPS().getInpsPub().getTotImpTFR();
    	cudArray[138]= cud.getDatiINPS().getInpsPub().getTotImpTFS();
    	
    	if(cud.getDatiINPS().getInpsSub().getAltro()!=null){
    		cudArray[139]= cud.getDatiINPS().getInpsSub().getAltro(); 
    	}
		else 
			cudArray[139]="";
    	
    	cudArray[140]= cud.getDatiINPS().getInpsSub().getContribLavTratt(); 	
    	cudArray[141]= cud.getDatiINPS().getInpsSub().getImponIVS();
    	cudArray[142]= cud.getDatiINPS().getInpsSub().getImponPrevid(); 
    	
    	if(cud.getDatiINPS().getInpsSub().getInps()!=null){
    	cudArray[143]= cud.getDatiINPS().getInpsSub().getInps(); 
    	}
		else 
			cudArray[143]="";
    	
    	if(cud.getDatiINPS().getInpsSub().getMatrAzienda()!=null){
    	cudArray[144]= cud.getDatiINPS().getInpsSub().getMatrAzienda();	
    	}
		else 
			cudArray[144]="";
    	
    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[0])!=null &&
    			String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[0]).equalsIgnoreCase("x"))
    		cudArray[145]= String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[0]).toUpperCase();
    	else
    		cudArray[145]="";
    	
    	j=163;
    	for(int i=1; i<13;i++)
    	{
    		if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[i])!=null &&
        			String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[i]).equalsIgnoreCase("x")){
    			cudArray[j]= String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[i]).toUpperCase();
    		}
    		else{
    			cudArray[j]="";
    		}
    		j++;
    	}
    	
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[2])!=null)
//    		cudArray[164]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[2];
//    	else
//    		cudArray[164]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[3])!=null)
//    		cudArray[165]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[3];
//    	else
//    		cudArray[165]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[4])!=null)
//    		cudArray[166]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[4];
//    	else
//    		cudArray[166]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[5])!=null)
//    		cudArray[167]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[5];
//    	else
//    		cudArray[167]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[6])!=null)
//    		cudArray[168]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[6];
//    	else
//    		cudArray[168]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[7])!=null)
//    		cudArray[169]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[7];
//    	else
//    		cudArray[169]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[8])!=null)
//    		cudArray[170]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[8];
//    	else
//    		cudArray[170]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[9])!=null)
//    		cudArray[171]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[9];
//    	else
//    		cudArray[171]="";
//
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[10])!=null)
//    		cudArray[172]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[10];
//    	else
//    		cudArray[172]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[11])!=null)
//    		cudArray[173]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[11];
//    	else
//    		cudArray[173]="";
//    	
//    	if(String.valueOf(cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[12])!=null)
//    		cudArray[174]= cud.getDatiINPS().getInpsSub().getMesiDenUniemens()[12];
//    	else
//    		cudArray[174]="";
   	
    	if(cud.getAnnotazioni()!=null){
    	cudArray[146]= cud.getAnnotazioni();
    	}
		else 
			cudArray[146]="";
    	
    	if(cud.getData()!=null){
    	cudArray[147]= cud.getData();
    	}
		else 
			cudArray[147]="-- -- ----";
    	
    	cudArray[148]= cud.getDatiINPS().getInpsColl();		
    	cudArray[149]= cud.getDatiINPS().getInpsPub();
    	cudArray[150]= cud.getDatiINPS().getInpsSub();


        //DATI PER LETTERA DI ACCOMPAGNAMENTO
        if(     null == cud.getLetteraAccompagnamento().getIndirizzo()||
                null == cud.getLetteraAccompagnamento().getCap()||
                null ==  cud.getLetteraAccompagnamento().getComune()||
                null ==  cud.getLetteraAccompagnamento().getProvincia()||
                null ==  cud.getLetteraAccompagnamento().getData()){
                throw new NullPointerException("Lettera Accompagnamento o parte dei suoi dati sono NULL ");

        } else {
                cudArray[181]= cud.getLetteraAccompagnamento().getIndirizzo();
                cudArray[182]= cud.getLetteraAccompagnamento().getCap();
                cudArray[183]= cud.getLetteraAccompagnamento().getComune();
                cudArray[184]= cud.getLetteraAccompagnamento().getProvincia();
                cudArray[185]= cud.getLetteraAccompagnamento().getData();
        }



        //DATI RETTIFICA
        cudArray[190]= cud.isRettifica();
        if(cud.isRettifica())
            cudArray[191]="ANNULLA E SOSTITUISCE";
        else
            cudArray[191]="";

        return cudArray;
    }

}
