package com.github.zhuyiyi1990.hwuanote.dao;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

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
