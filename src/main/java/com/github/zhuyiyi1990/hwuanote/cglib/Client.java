package com.github.zhuyiyi1990.hwuanote.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
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
        cglibProducer.saleProduct(1000);
        cglibProducer.afterService(1000);
    }

}
