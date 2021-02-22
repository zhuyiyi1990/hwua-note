package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户
     *
     * @return
     */
    public abstract List<Account> findAll();

    /**
     * 保存账户信息
     *
     * @param account
     */
    public abstract void saveAccount(Account account);

}
