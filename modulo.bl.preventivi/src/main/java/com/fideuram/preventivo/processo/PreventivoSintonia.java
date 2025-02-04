package com.fideuram.preventivo.processo;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.preventivo.config.Templates;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.modello.PreventivoStampabile;
import com.fideuram.preventivo.modello.RigaTabellaA;
import com.fideuram.preventivo.modello.RigaTabellaB;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JDK on 14/09/2016.
 */
public class PreventivoSintonia {

    public Object getDocumento(Preventivo p)
            throws DocGeneratorException
    {
        LoggingUtils.debug("com.fideuram.crm.stampe.engine.processi.preventivi.LetteraPreventivi.getDocumento");
        HashMap map = new HashMap();
        try{
            PreventivoStampabile preventivoStampabile = new PreventivoStampabile();

            try {
                BeanUtils.copyProperties(preventivoStampabile, p);  //conrollare se qua non copia la lista capitale per anno
            } catch (IllegalAccessException e) {
                LoggingUtils.error("LetteraPreventivi.getDocumento "+e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                LoggingUtils.error("LetteraPreventivi.getDocumento "+e.getMessage());
                e.printStackTrace();
            }

            preventivoStampabile.setD( !(preventivoStampabile
                    .getContraente()
                    .getClassePatrimonioPotenziale().equals("D")
                    || (Double.parseDouble(preventivoStampabile.getPremi()
                    .getPremioUnico())>= 2000000)) );

            setRigheTabelle(preventivoStampabile);

            preventivoStampabile = formatField(preventivoStampabile);
            if(preventivoStampabile.getNumeroPreventivo() == null){
                preventivoStampabile.setNumeroPreventivo("");
            }

            String eta = preventivoStampabile.getAssicurato().getSegniParticolari().getEta();
            preventivoStampabile.getAssicurato().getSegniParticolari().setEta(eta+" anni");

            if(preventivoStampabile.getBozza()){
                map.put("preventivo", preventivoStampabile);
                return generatoreOdt(map, Templates.TEMPLATE_BOZZE_FVSINTONIA);
            }else{

                String fraseFide = "COPIA PER FIDEURAM VITA S.p.A.";
                String fraseCli = "COPIA PER IL CLIENTE";
                preventivoStampabile.setCopiaPerFideuram(fraseFide);
                preventivoStampabile.setCopiaPerCliente(fraseCli);
                map.put("preventivo", preventivoStampabile);

                /*
                byte[] copiafid= generatoreOdt(map, Templates.TEMPLATE_TCM);
                byte[] copiacli= generatoreOdt(map, Templates.TEMPLATE_TCM);
                OdtMerge.mergeFileProdotti()
                */

                return generatoreOdt(map, Templates.TEMPLATE_FVSINTONIA);
            }
        }catch(DocGeneratorException e){
            throw new DocGeneratorException("Eccezione in stampa preventivi:--->"+e);
        }
    }

    private PreventivoStampabile formatField(PreventivoStampabile preventivoStampabile) {
        preventivoStampabile.getCapitale().setCapitaleAssicurato(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicurato())));

        preventivoStampabile.setCommStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getComm()*100) );
        preventivoStampabile.setRlaStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getRla()*100) );
        preventivoStampabile.setRlbStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getRlb()*100) );
        preventivoStampabile.setRmgStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getRmg()*100) );
        preventivoStampabile.setRnaStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getRna()*100) );
        preventivoStampabile.setRnbStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getRnb()*100) );
        preventivoStampabile.setCarTotStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getPremi().getCarTot()) );
        preventivoStampabile.setPercentualeGSStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getPremi().getPercentualePremioGS()) );
        preventivoStampabile.setQuotaGestioneSeparataStampabile( NumberUtils.getNullSefeCurrency(preventivoStampabile.getPremi().getQuotaGestioneSeparata()) );

        preventivoStampabile.getPremi().setPremioUnico( NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getPremi().getPremioUnico())) );

        return preventivoStampabile;
    }

    private double convertToDouble(String importo){
        double d = new BigDecimal(importo).doubleValue();
        return d;
    }

    private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
        byte templateData[] = new byte[0];
        try {
            templateData = TemplateFinder.getTemplate(template);
            LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
            byte doc[] =  new OdtWriter().mergeData(templateData, data);
            doc = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(doc);
            return doc;
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            templateLoaderExcepion.printStackTrace();
        } catch (ConverterException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (WebServiceClientException e) {
            throw new DocGeneratorException(e.getMessage());
        }
        return null;
    }

    private void setRigheTabelle(PreventivoStampabile preventivoStampabile){

        List<RigaTabellaA> listRigaA = new ArrayList<RigaTabellaA>();
        List<RigaTabellaB> listRigaB = new ArrayList<RigaTabellaB>();

        for(int i=0;i<preventivoStampabile.getPremi().getSviluppoPerAnni();i++){
            RigaTabellaA riga = new RigaTabellaA();

            riga.setSviluppoPerAnni( String.valueOf(i+1) );
            if(i==0)
                riga.setQuotaGestioneSeparata(NumberUtils.getNullSefeCurrency(preventivoStampabile.getPremi().getQuotaGestioneSeparata()));
            else
                riga.setQuotaGestioneSeparata("");
            riga.setCapitaleAssicuratoPerAnno("---");
            riga.setCapitaleAssicuratoCasoMorteA( NumberUtils.getNullSefeCurrency(preventivoStampabile.getCapitale().getCapitaleAssicuratoCasoMortePerAnnoA().get(i)) );
            riga.setValoriRiscattoFineAnnoA( NumberUtils.getNullSefeCurrency(preventivoStampabile.getCapitale().getValoriRiscattoFineAnnoA().get(i)) );

            listRigaA.add(riga);
        }

        for(int i=0;i<preventivoStampabile.getPremi().getSviluppoPerAnni();i++){
            RigaTabellaB riga = new RigaTabellaB();

            riga.setSviluppoPerAnni( String.valueOf(i+1) );
            if(i==0)
                riga.setQuotaGestioneSeparata( NumberUtils.getNullSefeCurrency(preventivoStampabile.getPremi().getQuotaGestioneSeparata()/*convertToDouble(preventivoStampabile.getPremi().getPremioUnico())*/));
            else
                riga.setQuotaGestioneSeparata("");
            riga.setCapitaleAssicuratoPerAnno( NumberUtils.getNullSefeCurrency( preventivoStampabile.getCapitale().getCapitaleAssicuratoPerAnno().get(i) ));
            riga.setCapitaleAssicuratoCasoMorteB( NumberUtils.getNullSefeCurrency(preventivoStampabile.getCapitale().getCapitaleAssicuratoCasoMortePerAnnoB().get(i)) );
            riga.setValoriRiscattoFineAnnoB( NumberUtils.getNullSefeCurrency(preventivoStampabile.getCapitale().getValoriRiscattoFineAnnoB().get(i)) );

            listRigaB.add(riga);
        }

        preventivoStampabile.setListRigaTabellaA(listRigaA);
        preventivoStampabile.setListRigaTabellaB(listRigaB);
    }
}
