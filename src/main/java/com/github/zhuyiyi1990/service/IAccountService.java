package com.github.zhuyiyi1990.service;

import com.github.zhuyiyi1990.pojo.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 查询所有账户
     *
     * @return
     */
    public abstract List<Account> findAll();

    /**
     * 保存账户
     *
     * @param account
     */
    public abstract void saveAccount(Account account);

}
