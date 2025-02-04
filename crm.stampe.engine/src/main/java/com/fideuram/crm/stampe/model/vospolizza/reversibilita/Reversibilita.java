package com.fideuram.crm.stampe.model.vospolizza.reversibilita;

import com.fideuram.costanti.Costanti;
import com.fideuram.puc.service.impl.OpzioniRamo3ReversibilitaVO;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

/**
 * Created by
 * User: logan
 * Date: 29/12/11
 * Time: 15.18
 */
public class Reversibilita implements IReversibilita{
    private R3_ReversibilitaVo primaTesta=null;
    private R3_ReversibilitaVo secondaTesta=null;

    public Reversibilita(OpzioniRamo3ReversibilitaVO reversibilita) {
        if (reversibilita != null) {
            boolean secondaTesta = false;
            if (reversibilita.getOpzioneReversibilita2Testa() != null) {
                R3_ReversibilitaVo r3 = new R3_ReversibilitaVo();
                if (reversibilita.getOpzioneReversibilita2Testa().getPercentualeReversibilita() != null) {
                    secondaTesta = true;
                    r3.setPercentualeReversibilita(reversibilita.getOpzioneReversibilita2Testa().getPercentualeReversibilita().toString() + "%");
                }
                if (reversibilita.getOpzioneReversibilita2Testa().getSesso() != null) {
                    secondaTesta = true;
                    r3.setTesta(reversibilita.getOpzioneReversibilita2Testa().getSesso());
                }
                if (reversibilita.getOpzioneReversibilita2Testa().getDataNascitaRiferimento() != null) {
                    secondaTesta = true;
                    r3.setDataNascita(DateUtils.formatDate(reversibilita.getOpzioneReversibilita2Testa().getDataNascitaRiferimento(), Costanti.FORMATO_DATA));
                }
                if (reversibilita.getOpzioneReversibilita2Testa().getRenditaReversibile() != null) {
                    secondaTesta = true;
                    r3.setValoreReversibilita(NumberUtils.formatCurrency(reversibilita.getOpzioneReversibilita2Testa().getRenditaReversibile(), Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
                }
                if (reversibilita.getOpzioneReversibilita2Testa().getDataRiferimentoReversibilita() != null) {
                    secondaTesta = true;
                    String data= DateUtils.formatDate(reversibilita.getOpzioneReversibilita2Testa().getDataRiferimentoReversibilita(), Costanti.FORMATO_DATA);
                    data=data.substring(0,6).concat("....");
                    r3.setDataRiferimento(data);
                }
                if (secondaTesta)
                    setSecondaTesta(r3);
            }
            if ((secondaTesta == true) && (reversibilita.getOpzioneReversibilita1Testa() != null)) {
                R3_ReversibilitaVo r3 = new R3_ReversibilitaVo();
                if (reversibilita.getOpzioneReversibilita1Testa().getPercentualeReversibilita() != null) {
                    r3.setPercentualeReversibilita(NumberUtils.formatCurrency(reversibilita.getOpzioneReversibilita1Testa().getPercentualeReversibilita(), Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));  //todo
                }
                if (reversibilita.getOpzioneReversibilita1Testa().getSesso() != null)
                    r3.setTesta(reversibilita.getOpzioneReversibilita1Testa().getSesso());
                if (reversibilita.getOpzioneReversibilita1Testa().getDataNascitaRiferimento() != null)
                    r3.setDataNascita(DateUtils.formatDate(reversibilita.getOpzioneReversibilita1Testa().getDataNascitaRiferimento(), Costanti.FORMATO_DATA));
                if (reversibilita.getOpzioneReversibilita1Testa().getRenditaReversibile() != null)
                    r3.setValoreReversibilita(NumberUtils.formatCurrency(reversibilita.getOpzioneReversibilita1Testa().getRenditaReversibile(), Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
                if (reversibilita.getOpzioneReversibilita1Testa().getDataRiferimentoReversibilita() != null){
                    r3.setDataRiferimento(DateUtils.formatDate(reversibilita.getOpzioneReversibilita1Testa().getDataRiferimentoReversibilita(), Costanti.FORMATO_DATA));
                }
                setPrimaTesta(r3);
            }
        }


    }

    public R3_ReversibilitaVo getSecondaTesta() {
        return secondaTesta;
    }

    public void setSecondaTesta(R3_ReversibilitaVo secondaTesta) {
        this.secondaTesta = secondaTesta;
    }

    public R3_ReversibilitaVo getPrimaTesta() {
        return primaTesta;
    }

    public void setPrimaTesta(R3_ReversibilitaVo primaTesta) {
        this.primaTesta = primaTesta;
    }


}
