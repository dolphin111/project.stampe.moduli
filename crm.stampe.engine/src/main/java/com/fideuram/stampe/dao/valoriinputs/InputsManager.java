package com.fideuram.stampe.dao.valoriinputs;

import com.fideuram.crm.vo.ValoreInputVO;

import java.util.List;

/**
 * User: V801068
 * Date: 01/09/14
 * Time: 17.31
 */
public class InputsManager {
    private InputsBean inputsBean;

    public InputsManager() {
        inputsBean=new InputsBean();
    }

    public InputsBean getValoriInput(List<ValoreInputVO> vi){
        for(int i=0; i<vi.size();i++){
            int codiceInput = vi.get(i).getDatoInput().getId();
            switch (codiceInput){
                case 64:
                    inputsBean.setDurataMinima(vi.get(i).getValore());
                    break;
                case 65:
                    inputsBean.setPremio(vi.get(i).getValore());
                    break;
                case 62:
                    inputsBean.setSesso(vi.get(i).getValore());
                    break;
                case 61:
                    inputsBean.setDataNascita(vi.get(i).getValore());
                    break;
                case 63:
                    inputsBean.setDataDecorrenza(vi.get(i).getValore());
                    break;
                case 66:
                    inputsBean.setRenditaAnnua(vi.get(i).getValore());
                    break;
                case 67:
                    inputsBean.setDecumulo(vi.get(i).getValore());
                    break;
                case 68:
                    inputsBean.setProdotto(vi.get(i).getValore());
                    break;
                case 70:
                    inputsBean.setDataRiferimento(vi.get(i).getValore());
                    break;
            }
        }
        return inputsBean;
    }
}
