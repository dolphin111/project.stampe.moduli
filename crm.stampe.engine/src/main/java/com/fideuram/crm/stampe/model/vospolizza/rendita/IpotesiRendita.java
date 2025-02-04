package com.fideuram.crm.stampe.model.vospolizza.rendita;

/**
 * Created by
 * User: logan
 * Date: 28/12/11
 * Time: 15.17
 */
public class IpotesiRendita implements IIpotesiRendita{
    private Certezza certezza;
    private Frazionamento frazionamento;


    public Certezza getCertezza() {
        return certezza;
    }

    public void setCertezza(Certezza certezza) {
        this.certezza = certezza;
    }

    public Frazionamento getFrazionamento() {
        return frazionamento;
    }

    public void setFrazionamento(Frazionamento frazionamento) {
        this.frazionamento = frazionamento;
    }
}
