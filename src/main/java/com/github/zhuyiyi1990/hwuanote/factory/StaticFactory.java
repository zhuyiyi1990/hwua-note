package com.github.zhuyiyi1990.hwuanote.factory;

import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import com.github.zhuyiyi1990.hwuanote.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }

}
