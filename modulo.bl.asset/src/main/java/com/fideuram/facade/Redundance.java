package com.fideuram.facade;

import com.fideuram.costanti.Costanti;
import com.fideuram.stampe.modello.asset.CompartoAzioni;
import com.fideuram.stampe.modello.asset.FondoInvestimentoAnnuale;
import com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale;
import com.fideuram.utils.NumberUtils;

import java.util.List;

/**
 * Created with
 * User: v801068
 * Date: 05/12/13
 * Time: 11.39
 */
public class Redundance {
    /**
     * Questo metodo ha lo scopo di pulire le ridondanze (affichè non si producano stuckevoli ripetizioni nei documenti)
     * @param   fondoInvestimentoGlobale
     * @return  FondoInvestimentoGlobale
     */
    public  FondoInvestimentoGlobale cleaner(FondoInvestimentoGlobale fondoInvestimentoGlobale){

        List<FondoInvestimentoAnnuale> annuales =fondoInvestimentoGlobale.getFondoInvestimentoAnnuales();
        FondoInvestimentoAnnuale _f;
        CompartoAzioni _c;

        for (int i=0; i<annuales.size(); i++){
            FondoInvestimentoAnnuale _annuale = annuales.get(i);
            List <CompartoAzioni> compartoAzionis = _annuale.getCompartoAzionis();

            String raggruppamento="";   //reset del COMPARTO ALIAS RAGGRUPPAMENTO
            double totalePerc=0;
            double totaleValore=0;
            double subtot=0;
            double subval=0;

            _c = new CompartoAzioni();
            for(int x=0; x<compartoAzionis.size(); x++){
                _c = compartoAzionis.get(x);

                Double percentuale=  Double.valueOf(_c.getPercentuale().replace("%","").trim().replace(",",".")).doubleValue();
                /*
                    16 NOVEMBRE 2015
                    percentuale*-1  MI E' STATO CHIESTO DI CONTABILIZZARE I NEGATIVI COME FOSSERO POSITIVI...
                    OKKIO: SOLO PER IL CALCOLO DEL TOTALE PERCENTUALE PERO
                */
                totalePerc   += percentuale>=0?percentuale:(percentuale*-1);  //
                double valore=Double.valueOf(_c.getValore()).doubleValue();
                _c.setValore(NumberUtils.format(valore,Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI,2));
                totaleValore += valore;

                if(raggruppamento.equalsIgnoreCase("")){
                    raggruppamento=_c.getTipo();
                    subtot+= Double.valueOf(_c.getPercentuale().replace("%","").trim().replace(",",".")).doubleValue();
                    subtot = Math.rint(subtot*Math.pow(10,2))/Math.pow(10,2);
                    subval+= valore;
                }else{
                    if(raggruppamento.equalsIgnoreCase(_c.getTipo())){
                        subtot+= Double.valueOf(_c.getPercentuale().replace("%","").trim().replace(",",".")).doubleValue();
                        subtot = Math.rint(subtot*Math.pow(10,2))/Math.pow(10,2);
                        subval+= valore;
                        _c.setTipo("");
                        _c.setFondoInvestimento("");
                    }else if(!raggruppamento.equalsIgnoreCase(_c.getTipo())){
                        raggruppamento=_c.getTipo();
                        CompartoAzioni ca_precedente=compartoAzionis.get(x-1);
                        ca_precedente.setSubTotalePerc(trasformaPerc(subtot,true));
                        ca_precedente.setSubTotaleVal(trasformaVal(subval));
                        subtot=0;
                        subval=0;
                        subtot+= Double.valueOf(_c.getPercentuale().replace("%","").trim().replace(",",".")).doubleValue();
                        subtot = Math.rint(subtot*Math.pow(10,2))/Math.pow(10,2);
                        subval+= valore;
                    }

                }

            }
            if (_c!=null){
                _c.setSubTotalePerc(trasformaPerc(subtot,true));
                _c.setSubTotaleVal(trasformaVal(subval));
            }

            _annuale.setTotalePercentuale(trasformaPerc(totalePerc,true));
            _annuale.setTotaleValore(trasformaVal(totaleValore));
        }
        return fondoInvestimentoGlobale;
    }

    private String trasformaVal(double val ){
        return   NumberUtils.formatCurrency(Double.valueOf(val),
                Costanti.SEPARATORE_MIGLIAIA,
                Costanti.SEPARATORE_DECIMALI);
    }

    /**
     * server solo per formattare le percentuali
     * @param perc
     * @return
     */
    private String trasformaPerc(double perc, boolean troncato){
        if((perc>99.8)&&(perc<100.99)){
            return "100";
        }
        int index=String.valueOf(perc).indexOf(".");
        //String appo = String.valueOf(perc).substring(0,index+2);
        String appo = String.valueOf(perc);
        appo= appo.replace(".",",");
        String tmp=appo.substring(index+1,appo.length());
        if((tmp.equalsIgnoreCase("0"))||tmp.equalsIgnoreCase("00")){
            appo=appo.substring(0,index);
        }

        if(appo.length()-index>2){
            appo= String.valueOf(appo).substring(0,index+3);
        }
        return appo;
    }
}
