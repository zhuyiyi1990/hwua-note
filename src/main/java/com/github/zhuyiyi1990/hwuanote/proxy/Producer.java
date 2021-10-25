package com.github.zhuyiyi1990.hwuanote.proxy;

public class Producer implements IProducer {

    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，得到钱" + money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("提供售后服务，得到钱" + money);
    }

}
