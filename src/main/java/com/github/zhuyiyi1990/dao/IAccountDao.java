package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.Account;

import java.util.List;

public interface IAccountDao {
    public abstract List<Account> findAll();

    public abstract void saveAccount(Account account);
}
