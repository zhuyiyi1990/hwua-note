package com.github.zhuyiyi1990.hwuanote.factory;

import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import com.github.zhuyiyi1990.hwuanote.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {

    @Autowired
    @Qualifier("accountService")
    private IAccountService accountService;

    @Autowired
    private TransactionManager txManager;

    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    txManager.beginTransaction();
                    rtValue = method.invoke(accountService, args);
                    txManager.commit();
                    return rtValue;
                } catch (Exception e) {
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    txManager.release();
                }
            }
        });
    }

}
