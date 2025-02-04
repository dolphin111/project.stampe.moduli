package com.fideuram.crm.stampe.model.vospolizza.rendita;

import com.fideuram.costanti.Costanti;
import com.fideuram.puc.service.impl.AvvisidiScadenzaVO;
import com.fideuram.puc.service.impl.OpzioneFrazionamentoVO;
import com.fideuram.utils.NumberUtils;

/**
 * Created by
 * User: logan
 * Date: 28/12/11
 * Time: 16.28
 */
public class Frazionamento extends AbstractIpotesi implements IFrazionamento{

    public Frazionamento(AvvisidiScadenzaVO avvisi) {
        setIpotesiRenditaAnnuaPosticipataScadenzaCTV(avvisi.getIpotesiValoreriScattoScadenzaCVT());
        setTotaleRenditaFrazionataAnnualePosticipata(avvisi.getTotalerenditaFrazionataAnnualePosticipata());
        setTotaleRenditaFrazionataSemestralePosticipata(avvisi.getTotalerenditaFrazionataSemestralePosticipata());
        setTotaleRenditaFrazionataTrimestralePosticipata(avvisi.getTotalerenditaFrazionataTrimestralePosticipata());
        setTotaleRenditaFrazionataMensilePosticipata(avvisi.getTotalerenditaFrazionataMensilePosticipata());
    }

    public Frazionamento(OpzioneFrazionamentoVO frazionamemnto ) {
        if(frazionamemnto.getAnnualePosticipata()!=null){
              setIpotesiRenditaAnnuaPosticipataScadenzaCTV(frazionamemnto.getAnnualePosticipata());
              setTotaleRenditaFrazionataAnnualePosticipata(frazionamemnto.getAnnualePosticipata());
        }
        if(frazionamemnto.getSemestralePosticipata()!=null)
              setTotaleRenditaFrazionataSemestralePosticipata(frazionamemnto.getSemestralePosticipata());
        if(frazionamemnto.getTrimestralePosticipata()!=null)
              setTotaleRenditaFrazionataTrimestralePosticipata(frazionamemnto.getTrimestralePosticipata());
        if(frazionamemnto.getMensilePosticipata()!=null)
              setTotaleRenditaFrazionataMensilePosticipata(frazionamemnto.getMensilePosticipata());

    }

    public String getIpotesiRenditaAnnuaPosticipataScadenzaCTV() {
        return numToString(ipotesiRenditaAnnuaPosticipataScadenzaCTV,"-");
    }

    public void setIpotesiRenditaAnnuaPosticipataScadenzaCTV(Double ipotesiRenditaAnnuaPosticipataScadenzaCTV) {
        this.ipotesiRenditaAnnuaPosticipataScadenzaCTV = ipotesiRenditaAnnuaPosticipataScadenzaCTV;
    }

    public String getTotaleRenditaFrazionataAnnualePosticipata() {
        return numToString(totaleRenditaFrazionataAnnualePosticipata,"-");
    }

    public void setTotaleRenditaFrazionataAnnualePosticipata(Double totaleRenditaFrazionataAnnualePosticipata) {
        this.totaleRenditaFrazionataAnnualePosticipata = totaleRenditaFrazionataAnnualePosticipata;
    }

    public String getTotaleRenditaFrazionataSemestralePosticipata() {
        return numToString(totaleRenditaFrazionataSemestralePosticipata,"-");
    }

    public void setTotaleRenditaFrazionataSemestralePosticipata(Double totaleRenditaFrazionataSemestralePosticipata) {
        this.totaleRenditaFrazionataSemestralePosticipata = totaleRenditaFrazionataSemestralePosticipata;
    }

    public String getTotaleRenditaFrazionataTrimestralePosticipata() {
        return numToString(totaleRenditaFrazionataTrimestralePosticipata,"-");
    }

    public void setTotaleRenditaFrazionataTrimestralePosticipata(Double totaleRenditaFrazionataTrimestralePosticipata) {
        this.totaleRenditaFrazionataTrimestralePosticipata = totaleRenditaFrazionataTrimestralePosticipata;
    }

    public String getTotaleRenditaFrazionataMensilePosticipata() {
        return numToString(totaleRenditaFrazionataMensilePosticipata,"-");
    }

    public void setTotaleRenditaFrazionataMensilePosticipata(Double totaleRenditaFrazionataMensilePosticipata) {
        this.totaleRenditaFrazionataMensilePosticipata = totaleRenditaFrazionataMensilePosticipata;
    }

    private Double ipotesiRenditaAnnuaPosticipataScadenzaCTV;
    private Double totaleRenditaFrazionataAnnualePosticipata;
	private Double totaleRenditaFrazionataSemestralePosticipata;
	private Double totaleRenditaFrazionataTrimestralePosticipata;
	private Double totaleRenditaFrazionataMensilePosticipata;
}
