package com.fideuram.soa.sync.asset.mock;

import com.fideuram.exception.AssetException;
import com.fideuram.jaxb.Converter;
import com.fideuram.soa.sync.asset.AssetReportProducerImpl;
import com.fideuram.soa.sync.asset.dto.CompartoAzioni;
import com.fideuram.soa.sync.asset.dto.FondoInvestimentoAnnuale;
import com.fideuram.soa.sync.asset.dto.FondoInvestimentoGlobale;
import com.fideuram.soa.sync.asset.exception.AssetInvestimentProducerExpections;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by
 * User: logan
 * Date: 11/04/12
 * Time: 15.35
 */
public class AssetMockaccio {
    public static FondoInvestimentoGlobale getMock(){
        CompartoAzioni compartoAzioni = new CompartoAzioni();
        compartoAzioni.setTipo("comparto OICR ZeroCoupon");
        compartoAzioni.setFondoInvestimento("");
        compartoAzioni.setPercentuale("75,09%");
        compartoAzioni.setValore("0");
        compartoAzioni.setComparto("ZERO COUPON");

        CompartoAzioni compartoAzioni2 = new CompartoAzioni();
        compartoAzioni2.setTipo("azionario");
        compartoAzioni2.setFondoInvestimento("");
        compartoAzioni2.setPercentuale("0,37%");
        compartoAzioni2.setValore("0");
        compartoAzioni2.setComparto("FF EQUITY ITALY");

        CompartoAzioni compartoAzioni3 = new CompartoAzioni();
        compartoAzioni3.setTipo("azionario");
        compartoAzioni3.setFondoInvestimento("");
        compartoAzioni3.setPercentuale("5,16%");
        compartoAzioni3.setValore("0");
        compartoAzioni3.setComparto("FF EQUITY EUROPE");

        CompartoAzioni compartoAzioni4 = new CompartoAzioni();
        compartoAzioni4.setTipo("azionario");
        compartoAzioni4.setFondoInvestimento("");
        compartoAzioni4.setPercentuale("9,12%");
        compartoAzioni4.setValore("0");
        compartoAzioni4.setComparto("FF EQUITY USA");

        CompartoAzioni compartoAzioni5 = new CompartoAzioni();
        compartoAzioni5.setTipo("azionario");
        compartoAzioni5.setFondoInvestimento("");
        compartoAzioni5.setPercentuale("2,09%");
        compartoAzioni5.setValore("0");
        compartoAzioni5.setComparto("FF EQUITY JAPAN");

        CompartoAzioni compartoAzioni6 = new CompartoAzioni();
        compartoAzioni6.setTipo("azionario");
        compartoAzioni6.setFondoInvestimento("");
        compartoAzioni6.setPercentuale("1,63%");
        compartoAzioni6.setValore("0");
        compartoAzioni6.setComparto("FF EQUITY PACIFIC EX JAPAN");

        CompartoAzioni compartoAzioni7 = new CompartoAzioni();
        compartoAzioni7.setTipo("azionario");
        compartoAzioni7.setFondoInvestimento("");
        compartoAzioni7.setPercentuale("4,29%");
        compartoAzioni7.setValore("0");
        compartoAzioni7.setComparto("FF EQUITY GLOBAL EMERGING MARKEKTS");

        CompartoAzioni compartoAzioni8 = new CompartoAzioni();
        compartoAzioni8.setTipo("azionario");
        compartoAzioni8.setFondoInvestimento("");
        compartoAzioni8.setPercentuale("1,35%");
        compartoAzioni8.setValore("0");
        compartoAzioni8.setComparto("FF EQUITY USA GROWTH");

        CompartoAzioni compartoAzioni9 = new CompartoAzioni();
        compartoAzioni9.setTipo("azionario");
        compartoAzioni9.setFondoInvestimento("");
        compartoAzioni9.setPercentuale("0,9%");
        compartoAzioni9.setValore("0");
        compartoAzioni9.setComparto("FF EQUITY USA VALUE");

        FondoInvestimentoAnnuale fia = new FondoInvestimentoAnnuale();
        fia.addCompartoAzioni(compartoAzioni);
        fia.addCompartoAzioni(compartoAzioni2);
        fia.addCompartoAzioni(compartoAzioni3);
        fia.addCompartoAzioni(compartoAzioni4);
        fia.addCompartoAzioni(compartoAzioni5);
        fia.addCompartoAzioni(compartoAzioni6);
        fia.addCompartoAzioni(compartoAzioni7);
        fia.addCompartoAzioni(compartoAzioni8);
        fia.addCompartoAzioni(compartoAzioni9);
        fia.setTotalePercentuale("xx");
        FondoInvestimentoGlobale fig = new FondoInvestimentoGlobale();
        fig.addFondoInvestimentoAnnuale(fia);
        fig.setAnno("2008");
        fig.setNome("FUL");
        fig.setData("30-01-2012");
        fig.setIdNomeFondo("31");
        fig.setIdCategoria("3");
        fig.setDescrizioneSintetica("F.U.L. 2008/2019");
        return fig;
    }

    public static void main(String args[]) throws AssetInvestimentProducerExpections {
            new AssetReportProducerImpl().generateDomunent(getMock());
    }

    public static com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale convert(FondoInvestimentoGlobale fondoInvestimentoGlobale) throws JAXBException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        String xml= Converter.objectToXml(fondoInvestimentoGlobale);
        com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale fig = new  com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale();
        fig = (com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale) Converter.xml2Object(fig, xml);
        return fig ;
    }
}
