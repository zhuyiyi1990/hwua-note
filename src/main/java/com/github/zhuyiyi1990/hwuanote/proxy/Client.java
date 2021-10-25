package com.github.zhuyiyi1990.hwuanote.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        IProducer producer = new Producer();
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                if ("saleProduct".equals(method.getName())) {
                    Float money = (Float) args[0];
                    returnValue = method.invoke(producer, money * 0.8F);
                } else {
                    returnValue = method.invoke(producer, args);
                }
                return returnValue;
            }
        });
        producer.saleProduct(1000);
        producer.afterService(1000);
        proxyProducer.saleProduct(1000);
        proxyProducer.afterService(1000);
    }

}
