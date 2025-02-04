package com.fideuram.crm.stampe.engine.processi;

import com.fideuram.utils.LoggingUtils;

/**
 * Created
 * User: logan
 * Date: 23/11/11
 * Time: 14.15
 */
public class IdentificatoreProcesso {

    /*public static String getProcesso(String processo){
        LoggingUtils.info("PROCESSO RICHIESTO DAL PUC " + processo);

        //template Stato Pratica
        if (processo.equalsIgnoreCase("statopratica"))
            return "1";
        else if(processo.equalsIgnoreCase("opzioniRamo3")||processo.equalsIgnoreCase("opzioniRamo1"))
            return "2";
        else if(processo.equalsIgnoreCase("riscattoAnticipatoTotale"))
            return "3";
        else if(processo.equalsIgnoreCase("ipotesiRiduzione"))
            return "4604";
        else if(processo.equalsIgnoreCase("ipotesiRiscattoPC"))
            return "4538";
        else if(processo.equalsIgnoreCase("prestazioniScadenza"))
            return "4555";
        else if(processo.equalsIgnoreCase("stimaAvvisoScadenza"))
            return "34907";
        else if(processo.equalsIgnoreCase("estrattoContoPremiVersati"))//DECUMULO
            return "502";
        else if(processo.equalsIgnoreCase("bonus"))
            return "510";
        else if(processo.equalsIgnoreCase("datiSinteticiPolizza"))//DISPLAY POLIZZA DATI SINTETICI
            return "5";
        else if(processo.equalsIgnoreCase("avvisiScadenzaSPI"))//AVVISI DI SCADENZA SPI
            return "7";
        else if(processo.equalsIgnoreCase("simulazioniSPI"))//SIMULAZIONI SPI
            return "8";
        else if(processo.equalsIgnoreCase("riscattoAnticipatoSPI"))//RISCATTO ANTICIPATO SPI
            return "9";
        else if(processo.equalsIgnoreCase("spiegazioneConteggiLiquidazioneSPI"))//SPIEGAZIONE CONTEGGI LIQUIDAZIONE SPI
            return "10";
        else if(processo.equalsIgnoreCase("andamentiRisultatiPolizza"))//ANDAMENTI E RISULTATI
            return "11";
        else if(processo.equalsIgnoreCase("saldiAssetPolizza"))//SALDI E ASSET
            return "12";
        else if(processo.equalsIgnoreCase("avvisiScadenza"))//AVVISI SCADENZA RAMO I E III
            return "13";
        else if(processo.equalsIgnoreCase("riscattoParzialeTendenza"))//RISCATTO PARZIALE TENDENZA
            return "14";
        else if(processo.equalsIgnoreCase("simulazioneDecumulo"))//DECUMULO
            return "15";
        else
            return "-1";
    }*/


    public static Integer getProcesso(String processo){

        if (processo.equalsIgnoreCase("statopratica"))
            return 1;
        else if(processo.equalsIgnoreCase("opzioniRamo3")||processo.equalsIgnoreCase("opzioniRamo1"))
            return 2;
        else if(processo.equalsIgnoreCase("riscattoAnticipatoTotale"))
            return 3;
        else if(processo.equalsIgnoreCase("ipotesiRiduzione"))
            return 4604;
        else if(processo.equalsIgnoreCase("ipotesiRiscattoPC"))
            return 4538;
        else if(processo.equalsIgnoreCase("prestazioniScadenza"))
            return 4555;
        else if(processo.equalsIgnoreCase("stimaAvvisoScadenza"))
            return 34907;
        else if(processo.equalsIgnoreCase("estrattoContoPremiVersati"))//DECUMULO
            return 502;
        else if(processo.equalsIgnoreCase("bonus"))
            return 510;
        else if(processo.equalsIgnoreCase("datiSinteticiPolizza"))//DISPLAY POLIZZA DATI SINTETICI
            return 5;
        else if(processo.equalsIgnoreCase("avvisiScadenzaSPI"))//AVVISI DI SCADENZA SPI
            return 7;
        else if(processo.equalsIgnoreCase("simulazioniSPI"))//SIMULAZIONI SPI
            return 8;
        else if(processo.equalsIgnoreCase("riscattoAnticipatoSPI"))//RISCATTO ANTICIPATO SPI
            return 9;
        else if(processo.equalsIgnoreCase("spiegazioneConteggiLiquidazioneSPI"))//SPIEGAZIONE CONTEGGI LIQUIDAZIONE SPI
            return 10;
        else if(processo.equalsIgnoreCase("andamentiRisultatiPolizza"))//ANDAMENTI E RISULTATI
            return 11;
        else if(processo.equalsIgnoreCase("saldiAssetPolizza"))//SALDI E ASSET
            return 12;
        else if(processo.equalsIgnoreCase("avvisiScadenza"))//AVVISI SCADENZA RAMO I E III
            return 13;
        else if(processo.equalsIgnoreCase("riscattoParzialeTendenza"))//RISCATTO PARZIALE TENDENZA
            return 14;
        else if(processo.equalsIgnoreCase("simulazioneDecumulo"))//DECUMULO
            return 15;
        else if(processo.equalsIgnoreCase("simulatoriMulticompartoFPA") || processo.equalsIgnoreCase("simulatoriFPA"))//Simulatore Multicomparto FPA
            return 20;
        else if(processo.equalsIgnoreCase("sollecitoDocumentiRipensamentoRendita"))//sollecito Documenti Ripensamento Rendita
            return 21;
        else
            return null;
    }

    public static String getUndecodeProcess(int processo){
        String processDecoded = "";
        switch (processo) {
            case 1:
                processDecoded = "statopratica";
                break;
            case 2:
                processDecoded = "opzioniRamo3";
                break;
            case 3:
                processDecoded = "riscattoAnticipatoTotale";
                break;
            case 5:
                processDecoded = "datiSinteticiPolizza";
                break;
            case 7:
                processDecoded = "avvisiScadenzaSPI";
                break;
            case 8:
                processDecoded = "simulazioniSPI";
                break;
            case 9:
                processDecoded = "riscattoAnticipatoSPI";
                break;
            case 10:
                processDecoded = "spiegazioneConteggiLiquidazioneSPI";
                break;
            case 11:
                processDecoded = "andamentiRisultatiPolizza";
                break;
            case 12:
                processDecoded = "saldiAssetPolizza";
                break;
            case 13:
                processDecoded = "avvisiScadenza";
                break;
            case 14:
                processDecoded = "riscattoParzialeTendenza";
                break;
            case 15:
                processDecoded = "simulazioneDecumulo";
                break;
            case 20:
                processDecoded = "simulatoriMulticompartoFPA";
                break;
            case 4604:
                processDecoded = "ipotesiRiduzione";
                break;
            case 4538:
                processDecoded = "ipotesiRiscattoPC";
                break;
            case 4555:
                processDecoded = "prestazioniScadenza";
                break;
            case 34907:
                processDecoded = "stimaAvvisoScadenza";
                break;
            default:
                break;
        }
        return processDecoded;
    }
}
