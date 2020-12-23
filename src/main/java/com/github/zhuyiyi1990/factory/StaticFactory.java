package com.github.zhuyiyi1990.factory;

import com.github.zhuyiyi1990.service.IAccountService;
import com.github.zhuyiyi1990.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
