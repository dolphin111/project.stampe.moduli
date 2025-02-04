package com.fideuram.processo.cud;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.file.io.OdtMerge;
import com.fideuram.processi.ProcessoBase;
import com.fideuram.stampe.modello.cud.AltriDatiFiscali;
import com.fideuram.stampe.modello.cud.AnagraficaDatoreLavoro;
import com.fideuram.stampe.modello.cud.AnagraficaDipendente;
import com.fideuram.stampe.modello.cud.CUD;
import com.fideuram.stampe.modello.cud.CompensiAnniPrecedenti;
import com.fideuram.stampe.modello.cud.DatiConguagli;
import com.fideuram.stampe.modello.cud.DatiFiscali;
import com.fideuram.stampe.modello.cud.DatiINPS;
import com.fideuram.stampe.modello.cud.INPSCollaboratori;
import com.fideuram.stampe.modello.cud.INPSDipPubblici;
import com.fideuram.stampe.modello.cud.INPSDipSubordinati;
import com.fideuram.stampe.modello.cud.RedditiImponibili;
import com.fideuram.stampe.modello.cud.SommeIncrementoProduttivita;
import com.fideuram.stampe.modello.cud.TFR;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created with
 * User: v801068
 * Date: 20/01/14
 * Time: 7.50
 */
public class Cud extends ProcessoBase{
    private String nomeFileDaGenerareOdt;

    public Cud() {
        //super();
        //INVALIDO IL PERCORSO GENERICO.
        //SERVE PER NON CREARE LA CARTELLA. VOGLIAMO CHE TUTTI I CUD SIANO ARCHIVIATI  NELLA STESSA CARTELLA
        percorso= CrmProperties.getProperty("cud.generated.temp.path");
    }



    public File stampa(CUD cud, String nomeFile) throws Exception {
        this.nomeFileDaGenerareOdt=nomeFile;
        Object obj[] = CUDToObjectArrayConverter.getArrayBeans(cud);
        return startCud(obj);
    }


   /* @Deprecated
    public File stampa(CUD anagrafica) throws Exception {
        Object obj[] = CUDToObjectArrayConverter.getArrayBeans(anagrafica);
        return startCud(obj);
    }

    @Deprecated
    private File stampa(Object[] anagrafica) throws Exception {
        this.nomeFileDaGenerareOdt=new Date().getTime()+ "_" + anagrafica[13].toString() + "_Modello730.odt";
        return startCud(anagrafica);
    }*/

    private File mergerOdt(List l,String percorso,String nomeFile) throws Exception {
        byte [] odt=new OdtMerge().mergeFileProdotti(l);
        StreamerFactory.saveFile(odt, percorso,nomeFile);
        LoggingUtils.debug("Generato >>" + percorso + nomeFileDaGenerareOdt);
        return new File(percorso+nomeFile);
    }

    protected File startCud(Object[] cud) throws Exception {
        File odt = null;
        OutputStream out;
        try{
            List l = new ArrayList();
            InputStream letteraStreamTemplate;
            if((Boolean)cud[190])
                letteraStreamTemplate= getTemplate("LetteraRettifica.odt");
            else
                letteraStreamTemplate= getTemplate("LetteraAccompagno.odt");
            cud[190]="";
            IXDocReport lettera = XDocReportRegistry.getRegistry().loadReport(letteraStreamTemplate, TemplateEngineKind.Freemarker );
            IContext contesto = lettera.createContext();
            contesto.put( "c", cud );
            odt=new File(percorso+"Lettera"+nomeFileDaGenerareOdt);
            out = new FileOutputStream( odt );
            lettera.process(contesto, out);
            out.close();
            l.add(odt);

            InputStream in= getTemplate("CUD2014.odt");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            IContext context = report.createContext();
            context.put( "c", cud );
            odt = new File(percorso+nomeFileDaGenerareOdt);
            out = new FileOutputStream( odt );
            report.process(context, out);
            out.close();
            l.add(odt);

            File file = mergerOdt(l,percorso,nomeFileDaGenerareOdt);
            odt=new File(percorso+"Lettera"+nomeFileDaGenerareOdt);
            odt.delete();
            return file;
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            LoggingUtils.debug(templateLoaderExcepion.getMessage());
            throw new Exception("Cud.start: TemplateLoaderExcepion",templateLoaderExcepion);
        } catch (FileNotFoundException e) {
            LoggingUtils.debug(e.getMessage());
            throw new Exception("Cud.start: FileNotFoundException",e);
        } catch (XDocReportException e) {
            LoggingUtils.debug(e.getMessage());
            throw new Exception("Cud.start.generateDocument: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.debug(e.getMessage());
            throw new Exception("Cud.start.generateDocument: IOException",e);
        }
    }



    @Deprecated
    protected File start(Object[] cud) throws Exception {
        cud[170]="";
        File odt=null;
        try{


            InputStream in= getTemplate("CUD2014.odt");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            IContext context = report.createContext();
            context.put( "c", cud );
            odt=new File(percorso+nomeFileDaGenerareOdt);
            OutputStream out = new FileOutputStream( odt );
            report.process(context, out);
            out.close();
            LoggingUtils.debug("Generato >>" + percorso + nomeFileDaGenerareOdt);
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            LoggingUtils.debug(templateLoaderExcepion.getMessage());
            throw new Exception("Cud.start: TemplateLoaderExcepion",templateLoaderExcepion);
        } catch (FileNotFoundException e) {
            LoggingUtils.debug(e.getMessage());
            throw new Exception("Cud.start: FileNotFoundException",e);
        } catch (XDocReportException e) {
            LoggingUtils.debug(e.getMessage());
            throw new Exception("Cud.start.generateDocument: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.debug(e.getMessage());
            throw new Exception("Cud.start.generateDocument: IOException",e);
        }
        return odt;
    }

    public static List<CUD> execute() throws Exception { 
    	
//    	Date dataNasc = new Date(1981, 7, 30);
//    	dataNasc.setDate(30);
//    	dataNasc.setMonth(07);
//    	dataNasc.setYear(1981);
//    	SimpleDateFormat sdf = new SimpleDateFormat();
//    	sdf.applyPattern("dd MM yyyy");
//    	String d= sdf.format(dataNasc);
//    	System.out.println(d);
//    	
//        Calendar c=Calendar.getInstance();
//        c.set( c.YEAR, 1981 );
//        c.set( c.MONTH, 7 );
//        c.set( c.DATE, 30 );
    	List<CUD> ListCUD = new ArrayList<CUD>();

    	AnagraficaDatoreLavoro anagraficaDatLav = new AnagraficaDatoreLavoro();
    	anagraficaDatLav.setCAP("00193"); //1
    	anagraficaDatLav.setCodAttivita("66099"); //2
    	anagraficaDatLav.setCodFis("10830461009"); //3
    	anagraficaDatLav.setCodSede(" "); //4
    	anagraficaDatLav.setCognome_denominazione("FIDEURAM VITA SPA"); //5
    	anagraficaDatLav.setComune("ROMA"); //6
    	anagraficaDatLav.setEmail("relazioniclienti@fideuramvita.it"); //7
    	anagraficaDatLav.setIndirizzo("VIA ENNIO QUIRINO VISCONTI 80"); //8
    	anagraficaDatLav.setNome(" "); //9
    	anagraficaDatLav.setProvincia("RM"); //10
    	anagraficaDatLav.setTel_fax("Tel. 390635711 Fax 390635714509"); //11
    	
    	    	
    	
        AnagraficaDipendente anagraficaDip = new AnagraficaDipendente(); 
        anagraficaDip.setCodComuneDomAnnoPrec("C123"); //12
        anagraficaDip.setCodComuneDomCorrente("C123"); //13
        anagraficaDip.setCodFis("RSSNCM81LC0B963B"); //14
        anagraficaDip.setCognome("Rossi"); //15
        anagraficaDip.setComuneNascita("Caserta"); //16
        anagraficaDip.setDataIscrFondo("10 10 2010"); //17
        anagraficaDip.setDataNascita("30 07 1981"); //18
        anagraficaDip.setDomicilioAnnoPrec("Roma"); //19
        anagraficaDip.setDomicilioCorrente("Roma"); //20
        anagraficaDip.setDomicilioFineRappLav("Roma"); //21
        anagraficaDip.setEventiEcc(" "); //22
        anagraficaDip.setNome("Enrico"); //23
        anagraficaDip.setPrevidComplem(" "); //24
        anagraficaDip.setProvDomAnnoPrec("RM"); //25
        anagraficaDip.setProvDomCorrente("RM"); //26
        anagraficaDip.setProvDomFineRappLav("RM"); //27
        anagraficaDip.setProvinciaNascita("CE"); //28
        anagraficaDip.setSesso("M"); //29
        anagraficaDip.setCap("80020");
        anagraficaDip.setIndirizzoDip("Via L. Pirandello 12");
        
    	
    	
    	DatiFiscali datiFiscali = new DatiFiscali(); 
    	datiFiscali.setAccAddComIrpef(0.0); //30
    	datiFiscali.setAccAddComIrpefSosp(0.0); //31
    	datiFiscali.setAccCedSecSosp(0.0); //32
    	datiFiscali.setAccIrpefSosp(0.0); //33
    	datiFiscali.setAddComIrpefAccCorr(0.0); //34
    	datiFiscali.setAddComIrpefAccPrec(0.0); //35
    	datiFiscali.setAddComIrpefSaldoPrec(0.0); //36
    	datiFiscali.setAddComIrpefSospAccPrec(0.0); //37
    	datiFiscali.setAddComIrpefSospSaldoPrec(0.0); //38
    	datiFiscali.setAddRegIrpef(0.0); //39
    	datiFiscali.setAddRegIrpefSosp(0.0); //40
    	datiFiscali.setCredAddComIrpefNoRimb(0.0); //41
    	datiFiscali.setCredAddRegIrpefNoRimb(0.0); //42
    	datiFiscali.setCredCedSecNoRimb(0.0); //43
    	datiFiscali.setCredIrpefNoRimb(0.0); //44
    	datiFiscali.setGiorni1234TuirLavDip("365"); //45
    	datiFiscali.setGiorni1234TuirPensione("365"); //46
    	datiFiscali.setPrimAccIrpefTrat(0.0); //47
    	datiFiscali.setPrimRataAccCedSec(0.0); //48
    	datiFiscali.setRedditi1234Tuir(0.0); //49
    	datiFiscali.setRedditi5_5bisTuir(0.0); //50
    	datiFiscali.setRitenIrpefSosp(0.0); //51
    	datiFiscali.setRitenutaIrpef(0.0); //52
    	datiFiscali.setSec_unicAccIrpefTrat(0.0); //53
    	datiFiscali.setSec_unicRataAccCedSec(0.0); //54

    	
    	AltriDatiFiscali altriDatiFis = new AltriDatiFiscali(); 
    	altriDatiFis.setContrPrevComplEsclRedditi(0.0); //55
    	altriDatiFis.setContrPrevComplNoEsclRedditi(0.0); //56
    	altriDatiFis.setCPCLPOAnniRes(0.0); //57
    	altriDatiFis.setCPCLPOApplMagRit(0.0); //58
    	altriDatiFis.setCPCLPOAssicSanit(0.0); ///59
    	altriDatiFis.setCPCLPOCasiPart(0.0); //60
    	altriDatiFis.setCPCLPOContrAssist(0.0); //61
    	altriDatiFis.setCPCLPOContrSolid(0.0); //62
    	altriDatiFis.setCPCLPOContrSolidSosp(0.0); //63
    	altriDatiFis.setCPCLPODiffer(0.0); //64
    	altriDatiFis.setCPCLPOEcced(0.0); //65
    	altriDatiFis.setCPCLPOPrevCompFam(0.0); //66
    	altriDatiFis.setCPCLPOTot(0.0); //67
    	altriDatiFis.setCPCLPOTotOneriDetraz(0.0); //68
    	altriDatiFis.setCPCLPOTotOneriNORedditi(0.0); //69
    	altriDatiFis.setCPCLPOVersati(0.0); //70
    	altriDatiFis.setCredCanLocRec(0.0); //71
    	altriDatiFis.setCredFamNumRec(0.0); //72
    	altriDatiFis.setCredImpPagEstero(0.0); //73
    	altriDatiFis.setCredNoRicCanLoc(0.0); //74
    	altriDatiFis.setCredNoRicFamNum(0.0); //75
    	altriDatiFis.setCredRicCanLoc(0.0); //76
    	altriDatiFis.setCredRiconFamNum(0.0); //77
    	altriDatiFis.setDetrazFamiglia(0.0); //78
    	altriDatiFis.setDetrazFamNum(0.0); //79
    	altriDatiFis.setDetrCanLoc(0.0); //80
    	altriDatiFis.setDetrLavDip_Pens_Redditi(0.0);//81 
    	altriDatiFis.setDetrOneri(0.0); //82
    	altriDatiFis.setImpostaLorda(0.0); //83
    	altriDatiFis.setTotDetrazioni(0.0); //84
    	altriDatiFis.setCPCLPOTotOneriNOEsclRedditi(0.0);//92


    	DatiConguagli datiConguagli = new DatiConguagli(); 
    	datiConguagli.setIrpefDaVers(0.0); //85
    	datiConguagli.setIrpefTratSuc28Feb(0.0); //86
    	datiConguagli.setTotredCong1(0.0); //87
    	datiConguagli.setTotredCong2(0.0); //88

    	
    	SommeIncrementoProduttivita sommeIncrProd = new SommeIncrementoProduttivita();
    	sommeIncrProd.setIstruzioni("ist"); //89
    	sommeIncrProd.setReddNoImp(0.0); //90
    	sommeIncrProd.setRitSosp(0.0); //91
    	sommeIncrProd.setTotRedd13(0.0); //93
    	sommeIncrProd.setTotRit(0.0); //94

    	
    	RedditiImponibili redditiImponibili = new RedditiImponibili();
    	redditiImponibili.setTotAddRegIrpef(0.0); //95
    	redditiImponibili.setTotAddRegIrpefSosp(0.0); //96
    	redditiImponibili.setTotRedd(0.0); //97
    	redditiImponibili.setTotRitIrpef(0.0); //98
    	redditiImponibili.setTotRitIrpefSosp(0.0); //99

    	
    	CompensiAnniPrecedenti compensiAnniPrec = new CompensiAnniPrecedenti();
    	compensiAnniPrec.setTotCompArrDetr(0.0); //100
    	compensiAnniPrec.setTotCompArrNoDetr(0.0); //101
    	compensiAnniPrec.setTotRitOper(0.0); //102
    	compensiAnniPrec.setTotRitSosp(0.0); //103

    	
    	TFR tfr = new TFR();
    	tfr.setAccAntAnniPrec(0.0); //104
    	tfr.setDetrazione(0.0); //105
    	tfr.setIndAccAntSomAnno(0.0); //106
    	tfr.setIndArt2122(0.0); //107
    	tfr.setRitenAnniPrec(0.0); //108
    	tfr.setRitenAnniPrecSosp(0.0); //109
    	tfr.setRitenutaAnno(0.0); //110
    	tfr.setRitenuteSosp(0.0); //111
    	tfr.setTfrNoPrelMatDa01(0.0); //112
    	tfr.setTfrNoPrelMatFi00(0.0); //113
    	tfr.setTfrVersMat01_06(0.0); //114
    	tfr.setTfrVersMatDa07(0.0); //115
    	tfr.setTfrVersMatFi00(0.0); //116

    	
    	
    	INPSCollaboratori inpsColl = new INPSCollaboratori();
    	inpsColl.setCompensi(0.0); //117
    	inpsColl.setContribDovuti(0.0); //118
    	inpsColl.setContribTrattenuti(0.0); //119
    	inpsColl.setContribVersati(0.0); //120
    	char[] mesiDenUniemens = new char[13]; 
    	
//    	Character defaultChar= 'X';
//    	Character defaultChar1_0= 'x';
    	for (int i = 0; i <mesiDenUniemens.length; i++){
//    		if(mesiDenUniemens[i] == defaultChar || mesiDenUniemens[i] == defaultChar1_0)
//	    			mesiDenUniemens[i]='X';
//	    		else
	    			mesiDenUniemens[i]=' ';
    	}
    	mesiDenUniemens[0] = 'X';
		inpsColl.setMesiDenUniemens(mesiDenUniemens); //121

		
    	INPSDipPubblici inpsPub = new INPSDipPubblici();
    	inpsPub.setAnnoRif("2013"); //122
    	inpsPub.setCodFisAmm("1234567890"); //123
    	inpsPub.setCodSPT_MEF("codSMEF"); //124
    	inpsPub.setGestCredEnam(1.12); //125
    	inpsPub.setGestCredEndep(0.0); //126
    	inpsPub.setGestPens(0.0); //127
    	inpsPub.setGestPrev(0.0); //128
    	inpsPub.setProgAzienda("prog123"); //129
    	inpsPub.setTotContribENPDEP_ENAM(0.0); //130
    	inpsPub.setTotContribGestCred(0.0); //131
    	inpsPub.setTotContribPens(0.0); //132
    	inpsPub.setTotContribTFR(0.0); //133
    	inpsPub.setTotContribTFS(0.0); //134
    	inpsPub.setTotImpENPDEP_ENAM(0.0); //135
    	inpsPub.setTotImpGestCred(0.0); //136
    	inpsPub.setTotImpPens(0.0); //137
    	inpsPub.setTotImpTFR(0.0); //138
    	inpsPub.setTotImpTFS(0.0); //139
    	
    	
    	INPSDipSubordinati inpsSub = new INPSDipSubordinati();
    	inpsSub.setAltro("altro"); //140
    	inpsSub.setContribLavTratt(0.0);//141 
    	inpsSub.setImponIVS(0.0); //142
    	inpsSub.setImponPrevid(0.0); //143
    	inpsSub.setInps("inps"); //144
    	inpsSub.setMatrAzienda("matrAzienda"); //145
    	char[] mesiDenUniemensS = new char[13]; 

//    	Character defaultCharS= 'X';
//    	Character defaultCharS1_0= 'x';
    	for (int i = 0; i <mesiDenUniemensS.length; i++){
//    		if(mesiDenUniemensS[i] == defaultCharS || mesiDenUniemensS[i] == defaultCharS1_0)
//    			mesiDenUniemensS[i]='X';
//    		else
    			mesiDenUniemensS[i]=' ';
    	}
    	mesiDenUniemensS[1] = 'X';
    	mesiDenUniemensS[2] = 'x';
    	inpsSub.setMesiDenUniemens(mesiDenUniemensS);//146
    	
    	
    	DatiINPS datiINPS = new DatiINPS();
    	datiINPS.setInpsColl(inpsColl); //149
    	datiINPS.setInpsPub(inpsPub); //150
    	datiINPS.setInpsSub(inpsSub); //151
    	
    	CUD cudB= new CUD();
    	cudB.setAnnotazioni("annotazioni");//147 
    	cudB.setData("02 02 2010"); //148
    	cudB.setAnagraficaDatLav(anagraficaDatLav);
    	cudB.setAnagraficaDip(anagraficaDip);
    	cudB.setDatiFiscali(datiFiscali);
    	cudB.setAltriDatiFis(altriDatiFis);
    	cudB.setDatiConguagli(datiConguagli);
    	cudB.setSommeIncrProd(sommeIncrProd);
    	cudB.setRedditiImponibili(redditiImponibili);
    	cudB.setCompensiAnniPrec(compensiAnniPrec);
    	cudB.setTfr(tfr);
		cudB.setDatiINPS(datiINPS );
   	    	
    	
		AnagraficaDatoreLavoro anagraficaDatLav1 = new AnagraficaDatoreLavoro();
    	anagraficaDatLav1.setCAP("00193"); //1
    	anagraficaDatLav1.setCodAttivita("66099"); //2
    	anagraficaDatLav1.setCodFis("10830461009"); //3
    	anagraficaDatLav1.setCodSede(" "); //4
    	anagraficaDatLav1.setCognome_denominazione("FIDEURAM VITA SPA"); //5
    	anagraficaDatLav1.setComune("ROMA"); //6
    	anagraficaDatLav1.setEmail("relazioniclienti@fideuramvita.it"); //7
    	anagraficaDatLav1.setIndirizzo("VIA ENNIO QUIRINO VISCONTI 80"); //8
    	anagraficaDatLav1.setNome(" "); //9
    	anagraficaDatLav1.setProvincia("RM"); //10
    	anagraficaDatLav1.setTel_fax("Tel. 390635711 Fax 390635714509"); //11
    	
    	    	
    	
        AnagraficaDipendente anagraficaDip1 = new AnagraficaDipendente(); 
        anagraficaDip1.setCodComuneDomAnnoPrec("D969"); //12
        anagraficaDip1.setCodComuneDomCorrente("D969"); //13
        anagraficaDip1.setCodFis("BAISRG46E02L153Z"); //14
        anagraficaDip1.setCognome("BAIU"); //15
        anagraficaDip1.setComuneNascita("TETI"); //16
        anagraficaDip1.setDataIscrFondo("10 10 2010"); //17
        anagraficaDip1.setDataNascita("02 05 1946"); //18
        anagraficaDip1.setDomicilioAnnoPrec("GENOVA"); //19
        anagraficaDip1.setDomicilioCorrente("GENOVA"); //20
        anagraficaDip1.setDomicilioFineRappLav("GENOVA"); //21
        anagraficaDip1.setEventiEcc(" "); //22
        anagraficaDip1.setNome("SERGIO"); //23
        anagraficaDip1.setPrevidComplem(" "); //24
        anagraficaDip1.setProvDomAnnoPrec("GE"); //25
        anagraficaDip1.setProvDomCorrente("GE"); //26
        anagraficaDip1.setProvDomFineRappLav("GE"); //27
        anagraficaDip1.setProvinciaNascita("NU"); //28
        anagraficaDip1.setSesso("M"); //29
        anagraficaDip1.setCap("32456");
        anagraficaDip1.setIndirizzoDip("Via G. Verga 2");
        
    	
    	
    	DatiFiscali datiFiscali1 = new DatiFiscali(); 
    	datiFiscali1.setAccAddComIrpef(0.0); //30
    	datiFiscali1.setAccAddComIrpefSosp(0.0); //31
    	datiFiscali1.setAccCedSecSosp(0.0); //32
    	datiFiscali1.setAccIrpefSosp(0.0); //33
    	datiFiscali1.setAddComIrpefAccCorr(0.48); //34
    	datiFiscali1.setAddComIrpefAccPrec(0.48); //35
    	datiFiscali1.setAddComIrpefSaldoPrec(1.11); //36
    	datiFiscali1.setAddComIrpefSospAccPrec(0.0); //37
    	datiFiscali1.setAddComIrpefSospSaldoPrec(0.0); //38
    	datiFiscali1.setAddRegIrpef(19.54); //39
    	datiFiscali1.setAddRegIrpefSosp(0.0); //40
    	datiFiscali1.setCredAddComIrpefNoRimb(0.0); //41
    	datiFiscali1.setCredAddRegIrpefNoRimb(0.0); //42
    	datiFiscali1.setCredCedSecNoRimb(0.0); //43
    	datiFiscali1.setCredIrpefNoRimb(0.0); //44
    	datiFiscali1.setGiorni1234TuirLavDip("365"); //45
    	datiFiscali1.setGiorni1234TuirPensione("0"); //46
    	datiFiscali1.setPrimAccIrpefTrat(0.0); //47
    	datiFiscali1.setPrimRataAccCedSec(0.0); //48
    	datiFiscali1.setRedditi1234Tuir(0.0); //49
    	datiFiscali1.setRedditi5_5bisTuir(1588.51); //50
    	datiFiscali1.setRitenIrpefSosp(0.0); //51
    	datiFiscali1.setRitenutaIrpef(365.36); //52
    	datiFiscali1.setSec_unicAccIrpefTrat(0.0); //53
    	datiFiscali1.setSec_unicRataAccCedSec(0.0); //54

    	
    	AltriDatiFiscali altriDatiFis1 = new AltriDatiFiscali(); 
    	altriDatiFis1.setContrPrevComplEsclRedditi(0.0); //55
    	altriDatiFis1.setContrPrevComplNoEsclRedditi(0.0); //56
    	altriDatiFis1.setCPCLPOAnniRes(0.0); //57
    	altriDatiFis1.setCPCLPOApplMagRit(0.0); //58
    	altriDatiFis1.setCPCLPOAssicSanit(0.0); ///59
    	altriDatiFis1.setCPCLPOCasiPart(0.0); //60
    	altriDatiFis1.setCPCLPOContrAssist(0.0); //61
    	altriDatiFis1.setCPCLPOContrSolid(0.0); //62
    	altriDatiFis1.setCPCLPOContrSolidSosp(0.0); //63
    	altriDatiFis1.setCPCLPODiffer(0.0); //64
    	altriDatiFis1.setCPCLPOEcced(0.0); //65
    	altriDatiFis1.setCPCLPOPrevCompFam(0.0); //66
    	altriDatiFis1.setCPCLPOTot(0.0); //67
    	altriDatiFis1.setCPCLPOTotOneriDetraz(0.0); //68
    	altriDatiFis1.setCPCLPOTotOneriNORedditi(0.0); //69
    	altriDatiFis1.setCPCLPOVersati(0.0); //70
    	altriDatiFis1.setCredCanLocRec(0.0); //71
    	altriDatiFis1.setCredFamNumRec(0.0); //72
    	altriDatiFis1.setCredImpPagEstero(0.0); //73
    	altriDatiFis1.setCredNoRicCanLoc(0.0); //74
    	altriDatiFis1.setCredNoRicFamNum(0.0); //75
    	altriDatiFis1.setCredRicCanLoc(0.0); //76
    	altriDatiFis1.setCredRiconFamNum(0.0); //77
    	altriDatiFis1.setDetrazFamiglia(0.0); //78
    	altriDatiFis1.setDetrazFamNum(0.0); //79
    	altriDatiFis1.setDetrCanLoc(0.0); //80
    	altriDatiFis1.setDetrLavDip_Pens_Redditi(0.0);//81 
    	altriDatiFis1.setDetrOneri(0.0); //82
    	altriDatiFis1.setImpostaLorda(365.36); //83
    	altriDatiFis1.setTotDetrazioni(0.0); //84
    	altriDatiFis1.setCPCLPOTotOneriNOEsclRedditi(0.0);//92


    	DatiConguagli datiConguagli1 = new DatiConguagli(); 
    	datiConguagli1.setIrpefDaVers(0.0); //85
    	datiConguagli1.setIrpefTratSuc28Feb(0.0); //86
    	datiConguagli1.setTotredCong1(0.0); //87
    	datiConguagli1.setTotredCong2(0.0); //88

    	
    	SommeIncrementoProduttivita sommeIncrProd1 = new SommeIncrementoProduttivita();
    	sommeIncrProd1.setIstruzioni("ist"); //89
    	sommeIncrProd1.setReddNoImp(0.0); //90
    	sommeIncrProd1.setRitSosp(0.0); //91
    	sommeIncrProd1.setTotRedd13(0.0); //93
    	sommeIncrProd1.setTotRit(0.0); //94

    	
    	RedditiImponibili redditiImponibili1 = new RedditiImponibili();
    	redditiImponibili1.setTotAddRegIrpef(0.0); //95
    	redditiImponibili1.setTotAddRegIrpefSosp(0.0); //96
    	redditiImponibili1.setTotRedd(0.0); //97
    	redditiImponibili1.setTotRitIrpef(0.0); //98
    	redditiImponibili1.setTotRitIrpefSosp(0.0); //99

    	
    	CompensiAnniPrecedenti compensiAnniPrec1 = new CompensiAnniPrecedenti();
    	compensiAnniPrec1.setTotCompArrDetr(0.0); //100
    	compensiAnniPrec1.setTotCompArrNoDetr(0.0); //101
    	compensiAnniPrec1.setTotRitOper(0.0); //102
    	compensiAnniPrec1.setTotRitSosp(0.0); //103

    	
    	TFR tfr1 = new TFR();
    	tfr1.setAccAntAnniPrec(0.0); //104
    	tfr1.setDetrazione(0.0); //105
    	tfr1.setIndAccAntSomAnno(0.0); //106
    	tfr1.setIndArt2122(0.0); //107
    	tfr1.setRitenAnniPrec(0.0); //108
    	tfr1.setRitenAnniPrecSosp(0.0); //109
    	tfr1.setRitenutaAnno(0.0); //110
    	tfr1.setRitenuteSosp(0.0); //111
    	tfr1.setTfrNoPrelMatDa01(0.0); //112
    	tfr1.setTfrNoPrelMatFi00(0.0); //113
    	tfr1.setTfrVersMat01_06(0.0); //114
    	tfr1.setTfrVersMatDa07(0.0); //115
    	tfr1.setTfrVersMatFi00(0.0); //116

    	
    	
    	INPSCollaboratori inpsColl1 = new INPSCollaboratori();
    	inpsColl1.setCompensi(0.0); //117
    	inpsColl1.setContribDovuti(0.0); //118
    	inpsColl1.setContribTrattenuti(0.0); //119
    	inpsColl1.setContribVersati(0.0); //120
    	char[] mesiDenUniemens1 = new char[13]; 
    	
//    	Character defaultChar1= ' ';
//    	Character defaultChar1_1= 'b';
    	for (int i = 0; i <mesiDenUniemens1.length; i++){
//    		if(mesiDenUniemens1[i] == defaultChar1 || mesiDenUniemens1[i] == defaultChar1_1)
//	    			mesiDenUniemens1[i]='X';
//	    		else
	    			mesiDenUniemens1[i]=' ';
    	}
    	mesiDenUniemens1[2] = 'x';
		inpsColl1.setMesiDenUniemens(mesiDenUniemens1); //121

		
    	INPSDipPubblici inpsPub1 = new INPSDipPubblici();
    	inpsPub1.setAnnoRif(""); //122
    	inpsPub1.setCodFisAmm(""); //123
    	inpsPub1.setCodSPT_MEF(""); //124
    	inpsPub1.setGestCredEnam(0.0); //125
    	inpsPub1.setGestCredEndep(0.0); //126
    	inpsPub1.setGestPens(0.0); //127
    	inpsPub1.setGestPrev(0.0); //128
    	inpsPub1.setProgAzienda(""); //129
    	inpsPub1.setTotContribENPDEP_ENAM(0.0); //130
    	inpsPub1.setTotContribGestCred(0.0); //131
    	inpsPub1.setTotContribPens(0.0); //132
    	inpsPub1.setTotContribTFR(0.0); //133
    	inpsPub1.setTotContribTFS(0.0); //134
    	inpsPub1.setTotImpENPDEP_ENAM(0.0); //135
    	inpsPub1.setTotImpGestCred(0.0); //136
    	inpsPub1.setTotImpPens(0.0); //137
    	inpsPub1.setTotImpTFR(0.0); //138
    	inpsPub1.setTotImpTFS(0.0); //139
    	
    	
    	INPSDipSubordinati inpsSub1 = new INPSDipSubordinati();
    	inpsSub1.setAltro(""); //140
    	inpsSub1.setContribLavTratt(0.0);//141 
    	inpsSub1.setImponIVS(0.0); //142
    	inpsSub1.setImponPrevid(0.0); //143
    	inpsSub1.setInps(""); //144
    	inpsSub1.setMatrAzienda(""); //145
    	char[] mesiDenUniemensS1 = new char[13]; 

//    	Character defaultCharS1= 'b';
//    	Character defaultCharS1_1= 'b';
    	for (int i = 0; i <mesiDenUniemensS1.length; i++){
//    		if(mesiDenUniemensS1[i] == defaultCharS1 || mesiDenUniemensS1[i] == defaultCharS1_1)
//    			mesiDenUniemensS1[i]='X';
//    		else
    			mesiDenUniemensS1[i]=' ';
    	}
    	mesiDenUniemensS1[1] = 'x';
    	mesiDenUniemensS1[12] = 'x';
    	inpsSub1.setMesiDenUniemens(mesiDenUniemensS1);//146
    	
    	
    	DatiINPS datiINPS1 = new DatiINPS();
    	datiINPS1.setInpsColl(inpsColl1); //149
    	datiINPS1.setInpsPub(inpsPub1); //150
    	datiINPS1.setInpsSub(inpsSub1); //151
    	
    	CUD cudB1= new CUD();
    	cudB1.setAnnotazioni("AI  Rendita assicurativa");//147 
    	cudB1.setData("02 02 2010"); //148
    	cudB1.setAnagraficaDatLav(anagraficaDatLav1);
    	cudB1.setAnagraficaDip(anagraficaDip1);
    	cudB1.setDatiFiscali(datiFiscali1);
    	cudB1.setAltriDatiFis(altriDatiFis1);
    	cudB1.setDatiConguagli(datiConguagli1);
    	cudB1.setSommeIncrProd(sommeIncrProd1);
    	cudB1.setRedditiImponibili(redditiImponibili1);
    	cudB1.setCompensiAnniPrec(compensiAnniPrec1);
    	cudB1.setTfr(tfr1);
		cudB1.setDatiINPS(datiINPS1);
		
		ListCUD.add(cudB1);
		ListCUD.add(cudB);
       
		return ListCUD;
    }
}
