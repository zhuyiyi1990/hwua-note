package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户,同时包含用户信息
     *
     * @return
     */
    public abstract List<Account> findAll();
}
