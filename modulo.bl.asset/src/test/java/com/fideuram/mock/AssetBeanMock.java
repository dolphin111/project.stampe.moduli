package com.fideuram.mock;

import com.fideuram.stampe.modello.asset.CompartoAzioni;
import com.fideuram.stampe.modello.asset.FondoInvestimentoAnnuale;
import com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale;

/**
 * Created with
 * User: v801068
 * Date: 05/12/13
 * Time: 14.15
 */
public class AssetBeanMock {
    public static FondoInvestimentoGlobale getMock(){
        CompartoAzioni compartoAzioni = new CompartoAzioni();
        compartoAzioni.setTipo("abbligazionario");
        compartoAzioni.setFondoInvestimento("Vattela a pesca");
        compartoAzioni.setPercentuale("05,02%");
        compartoAzioni.setValore("5");
        compartoAzioni.setComparto("AGIP PETROLI");
        CompartoAzioni compartoAzioni2 = new CompartoAzioni();
        compartoAzioni2.setTipo("abbligazionario");
        compartoAzioni2.setFondoInvestimento("Vattela a pesca");
        compartoAzioni2.setPercentuale("05,04%");
        compartoAzioni2.setValore("0");
        compartoAzioni2.setComparto("AGIP PETROLI");
        CompartoAzioni compartoAzioni3 = new CompartoAzioni();
        compartoAzioni3.setTipo("abbligazionario");
        compartoAzioni3.setFondoInvestimento("Vattela a pesca");
        compartoAzioni3.setPercentuale("05,00%");
        compartoAzioni3.setValore("7304251.7");
        compartoAzioni3.setComparto("AGIP PETROLI");
        CompartoAzioni compartoAzioni4 = new CompartoAzioni();
        compartoAzioni4.setTipo("azionario");
        compartoAzioni4.setFondoInvestimento("Vattela a pesca");
        compartoAzioni4.setPercentuale("05,00%");
        compartoAzioni4.setValore("7304251.7");
        compartoAzioni4.setComparto("AGIP PETROLI");
        CompartoAzioni compartoAzioni5 = new CompartoAzioni();
        compartoAzioni5.setTipo("azionario");
        compartoAzioni5.setFondoInvestimento("Vattela a pesca");
        compartoAzioni5.setPercentuale("80,00%");
        compartoAzioni5.setValore("100998.7");
        compartoAzioni5.setComparto("AGIP PETROLI");


        FondoInvestimentoAnnuale fia = new FondoInvestimentoAnnuale();
        fia.addCompartoAzioni(compartoAzioni);
        fia.addCompartoAzioni(compartoAzioni2);
        fia.addCompartoAzioni(compartoAzioni3);
        fia.addCompartoAzioni(compartoAzioni4);
        fia.addCompartoAzioni(compartoAzioni5);
        fia.setTotalePercentuale("xx");
        FondoInvestimentoGlobale fig = new FondoInvestimentoGlobale();
        fig.addFondoInvestimentoAnnuale(fia);
        fig.setAnno("2012");
        fig.setNome("FAP");
        fig.setData("30-01-2012");
        fig.setIdNomeFondo("31");
        fig.setIdCategoria("3");
        fig.setDescrizioneSintetica("orco Oid");
        return  fig;
    }
}
