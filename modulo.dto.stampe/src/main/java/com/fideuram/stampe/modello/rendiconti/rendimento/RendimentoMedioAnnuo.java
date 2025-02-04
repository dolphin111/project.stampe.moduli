package com.fideuram.stampe.modello.rendiconti.rendimento;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created
 * User: v801068
 * Date: 28/01/14
 * Time: 10.31
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class RendimentoMedioAnnuo {
    private String  titoloaRendimento="---"; //Fondo intermo, Benchmark fino al 31/10/2007, Benchmark dal 1/11/2007
    private Date    oldBenchmarkRefDate;
    private Date    onewBenchmarkRefDate;
    private Integer dataUltimoanno;
    private Integer dataPenultimoanno;
    private Double  ultimoanno;
    private Double  ultimoannobm;
    private Double  ultimoannooldbm;
    private Double  ultimi2anni;
    private Double  ultimi2annibm;
    private Double  ultimi2annioldbm;

    private Double  ultimi3anni;
    private Double  ultimi3annibm;
    private Double  ultimi3annioldbm;
    private Double  ultimi4anni;
    private Double  ultimi4annibm;
    private Double  ultimi4annioldbm;
    private Double  ultimi5anni;
    private Double  ultimi5annibm;
    private Double  ultimi5annioldbm;
    private Double  ultimi10anni;
    private Double  ultimi10annibm;
    private Double  ultimi10annioldbm;

    public String getTitoloaRendimento() {
        return titoloaRendimento;
    }

    public String getOldBenchmarkRefDate() {
        return FormattatoreDate.formatDate(oldBenchmarkRefDate,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getOnewBenchmarkRefDate() {
        return FormattatoreDate.formatDate(onewBenchmarkRefDate,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public String getDataUltimoanno() {
        return dataUltimoanno.toString();
    }

    public String getDataPenultimoanno() {
        return dataPenultimoanno.toString();
    }

    public String getUltimoanno() {
        return FormattatorePerc.percentualeStandard(ultimoanno, true);
    }

    public String getUltimi2anni() {
        return FormattatorePerc.percentualeStandard(ultimi2anni,true);
    }

    public String getUltimi3anni() {
        return FormattatorePerc.percentualeStandard(ultimi3anni,true);
    }

    public String getUltimi5anni() {
        return FormattatorePerc.percentualeStandard(ultimi5anni,true);
    }

    public String getUltimi10anni() {
        return FormattatorePerc.percentualeStandard(ultimi10anni,true);
    }


    public String getUltimoannobm() {
        return FormattatorePerc.percentualeStandard(ultimoannobm,true);
    }

    public String getUltimoannooldbm() {
        return FormattatorePerc.percentualeStandard(ultimoannobm,true);
    }

    public String getUltimi2annibm() {
        return FormattatorePerc.percentualeStandard(ultimi2annibm,true);
    }

    public String getUltimi2annioldbm() {
        return FormattatorePerc.percentualeStandard(ultimi2annioldbm,true);
    }


    public String getUltimi3annibm() {
        return FormattatorePerc.percentualeStandard(ultimi3annibm,true);
    }


    public String getUltimi3annioldbm() {
        return FormattatorePerc.percentualeStandard(ultimi3annioldbm,true);
    }


    public String getUltimi4anni() {
        return FormattatorePerc.percentualeStandard(ultimi3annioldbm,true);
    }

    public String getUltimi4annibm() {
        return FormattatorePerc.percentualeStandard(ultimi4annibm,true);
    }

    public String getUltimi4annioldbm() {
        return FormattatorePerc.percentualeStandard(ultimi4annioldbm,true);
    }

    public String getUltimi5annibm() {
        return FormattatorePerc.percentualeStandard(ultimi5annibm,true);
    }

    public String getUltimi5annioldbm() {
        return FormattatorePerc.percentualeStandard(ultimi5annioldbm,true);
    }



    public String getUltimi10annibm() {
        return FormattatorePerc.percentualeStandard(ultimi10annibm,true);
    }

    public String getUltimi10annioldbm() {
        return FormattatorePerc.percentualeStandard(ultimi10annioldbm,true);
    }

    //Server per rintracciare il fondo e la sua descrizione all'interno del template dei rendiconti
    private int idFondoFk;

    public int getIdFondoFk() {
        return idFondoFk;
    }

    public void setIdFondoFk(int idFondoFk) {
        this.idFondoFk = idFondoFk;
    }

    /**
     * <br>Si riferisce al Fondo interno o al Benchmarck
     * <br>Nel caso del BenchMarck va inserita questa dicitura:
     * <br>Benchmark fino al 31/10/2007,
     * <br>oppure: Benchmark dal 1/11/2007
     * la data ovviamente...
     * @param titoloaRendimento
     */
    public void setTitoloaRendimento(String titoloaRendimento) {
        this.titoloaRendimento = titoloaRendimento;
    }

    public void setOldBenchmarkRefDate(Date oldBenchmarkRefDate) {
        this.oldBenchmarkRefDate = oldBenchmarkRefDate;
    }

    public void setOnewBenchmarkRefDate(Date onewBenchmarkRefDate) {
        this.onewBenchmarkRefDate = onewBenchmarkRefDate;
    }

    public void setDataUltimoanno(Integer dataUltimoanno) {
        this.dataUltimoanno = dataUltimoanno;
    }

    public void setDataPenultimoanno(Integer dataPenultimoanno) {
        this.dataPenultimoanno = dataPenultimoanno;
    }

    public void setUltimoanno(Double ultimoanno) {
        this.ultimoanno = ultimoanno;
    }

    public void setUltimi2anni(Double ultimi2anni) {
        this.ultimi2anni = ultimi2anni;
    }

    public void setUltimi3anni(Double ultimi3anni) {
        this.ultimi3anni = ultimi3anni;
    }

    public void setUltimi4anni(Double ultimi4anni) {
        this.ultimi4anni = ultimi4anni;
    }

    public void setUltimi5anni(Double ultimi5anni) {
        this.ultimi5anni = ultimi5anni;
    }

    public void setUltimi10anni(Double ultimi10anni) {
        this.ultimi10anni = ultimi10anni;
    }

    public void setUltimoannobm(Double ultimoannobm) {
        this.ultimoannobm = ultimoannobm;
    }

    public void setUltimoannooldbm(Double ultimoannooldbm) {
        this.ultimoannooldbm = ultimoannooldbm;
    }

    public void setUltimi2annibm(Double ultimi2annibm) {
        this.ultimi2annibm = ultimi2annibm;
    }

    public void setUltimi2annioldbm(Double ultimi2annioldbm) {
        this.ultimi2annioldbm = ultimi2annioldbm;
    }

    public void setUltimi3annibm(Double ultimi3annibm) {
        this.ultimi3annibm = ultimi3annibm;
    }

    public void setUltimi3annioldbm(Double ultimi3annioldbm) {
        this.ultimi3annioldbm = ultimi3annioldbm;
    }

    public void setUltimi4annibm(Double ultimi4annibm) {
        this.ultimi4annibm = ultimi4annibm;
    }

    public void setUltimi4annioldbm(Double ultimi4annioldbm) {
        this.ultimi4annioldbm = ultimi4annioldbm;
    }

    public void setUltimi5annibm(Double ultimi5annibm) {
        this.ultimi5annibm = ultimi5annibm;
    }

    public void setUltimi5annioldbm(Double ultimi5annioldbm) {
        this.ultimi5annioldbm = ultimi5annioldbm;
    }

    public void setUltimi10annibm(Double ultimi10annibm) {
        this.ultimi10annibm = ultimi10annibm;
    }

    public void setUltimi10annioldbm(Double ultimi10annioldbm) {
        this.ultimi10annioldbm = ultimi10annioldbm;
    }
}
