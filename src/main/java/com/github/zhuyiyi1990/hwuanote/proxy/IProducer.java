package com.github.zhuyiyi1990.hwuanote.proxy;

public interface IProducer {

    /**
     * 销售
     *
     * @param money
     */
    public abstract void saleProduct(float money);

    /*
     * 售后
     * @param money
     */
    public abstract void afterService(float money);

}
