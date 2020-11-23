package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.Account;

public interface IAccountDao {
    public abstract Account findAccountById(int id);

    public abstract Account findAccountByName(String name);

    public abstract int update(Account account);
}
