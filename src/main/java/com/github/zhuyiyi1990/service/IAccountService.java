package com.github.zhuyiyi1990.service;

import com.github.zhuyiyi1990.pojo.Account;

public interface IAccountService {
    public abstract Account findAccountById(int id);

    public abstract int update(Account account);

    public abstract void transfer(String sourceName, String targetName, float money);
}
