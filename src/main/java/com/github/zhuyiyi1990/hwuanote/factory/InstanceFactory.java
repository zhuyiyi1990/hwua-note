package com.github.zhuyiyi1990.hwuanote.factory;

import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import com.github.zhuyiyi1990.hwuanote.service.impl.AccountServiceImpl;

public class InstanceFactory {

    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }

}
