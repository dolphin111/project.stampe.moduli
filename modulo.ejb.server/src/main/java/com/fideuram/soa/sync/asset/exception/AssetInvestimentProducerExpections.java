package com.fideuram.soa.sync.asset.exception;

/**
 * Created by
 * User: logan
 * Date: 30/03/12
 * Time: 18.13
 */
public class AssetInvestimentProducerExpections extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = -4609883780927182467L;

    /**
     *
     */
    public AssetInvestimentProducerExpections() {
    }

    /**
     * @param arg0
     */
    public AssetInvestimentProducerExpections(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public AssetInvestimentProducerExpections(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public AssetInvestimentProducerExpections(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
