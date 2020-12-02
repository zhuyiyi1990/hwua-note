package com.github.zhuyiyi1990.service;

import com.github.zhuyiyi1990.pojo.Account;

import java.util.List;

public interface IAccountService {
    public abstract List<Account> findAll();

    public abstract void saveAccount(Account account);
}
