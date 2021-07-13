package com.github.zhuyiyi1990.hwuanote.cglib;

public class Producer {

    /**
     * 销售
     *
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，得到钱" + money);
    }

    /**
     * 售后
     *
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供售后服务，得到钱" + money);
    }

}
