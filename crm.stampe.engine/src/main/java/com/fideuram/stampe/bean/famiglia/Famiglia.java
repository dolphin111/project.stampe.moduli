package com.fideuram.stampe.bean.famiglia;

import com.fideuram.crm.stampe.model.Polizza;

/**
 * Created by V801068 on 06/05/14.
 */
public class Famiglia {
    //Elenco delle famiglie
    public  static final int FAMIGLIA_NON_IDENTIFICATA=0;
    public  static final int FIDEURAM_VITA_INSIEME=1;
    public  static final int FIDEURAM_VITA_GARANZIA_E_VALORE=2;
    //Elenco dei prodotti
    private static final String PRODOTTO_VITA_INTERA_PU_VIVATRE   ="RG0T1";
    private static final String PRODOTTO_VITA_INTERA_PU_PREVIDENZA="RP";
    private static final String PRODOTTO_VITA_INSIEME_PREMIUM     ="RB0U1";
    private static final String PRODOTTO_VITA_INSIEME_PREMIUM_4_4 ="RB0U2";
    private static final String PRODOTTO_VITA_INSIEME_FACILE      ="RM0U1";
    private static final String PRODOTTO_VITA_INSIEME_1           ="RS0U1";
    private static final String PRODOTTO_VITA_INSIEME_2           ="RS0U2";
    private static final String PRODOTTO_VITA_INSIEME_PRIVATE     ="RV0U1";



    private int famiglia;

    private Famiglia(int famiglia) {
        this.famiglia=famiglia;
    }

    public int getCodiceFamiglia(){ return famiglia; }

    public String getDescrzioneFamiglia(){
        switch (famiglia){
            case 0:
                return "FAMIGLIA_NON_IDENTIFICATA";
            case 1:
                return "FIDEURAM VITA INSIEME";
            case 2:
                return "FIDEURAM VITA GARANZI E VALORE";
            default:
                return "FAMIGLIA_NON_IDENTIFICATA";
        }
    }

    /**
     * Restituisce la famiglia di appartenenza di una polizza.
     * @param p
     * @return
     */
    public static Famiglia getFamiglia(Polizza p){
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INTERA_PU_VIVATRE))
            return new Famiglia(FIDEURAM_VITA_GARANZIA_E_VALORE);
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INTERA_PU_PREVIDENZA))
            return new Famiglia(FIDEURAM_VITA_GARANZIA_E_VALORE);

        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INSIEME_PREMIUM     ))
            return new Famiglia(FIDEURAM_VITA_INSIEME);
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INSIEME_PREMIUM_4_4 ))
            return new Famiglia(FIDEURAM_VITA_INSIEME);
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INSIEME_FACILE      ))
            return new Famiglia(FIDEURAM_VITA_INSIEME);
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INSIEME_1))
            return new Famiglia(FIDEURAM_VITA_INSIEME);
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INSIEME_2))
            return new Famiglia(FIDEURAM_VITA_INSIEME);
        if (p.getProdotto().trim().equalsIgnoreCase(PRODOTTO_VITA_INSIEME_PRIVATE))
            return new Famiglia(FIDEURAM_VITA_INSIEME);
        return new Famiglia(FAMIGLIA_NON_IDENTIFICATA);
    }



}