package com.github.zhuyiyi1990.hwuanote.dao;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有的账户,同时包含用户信息
     *
     * @return
     */
    abstract public List<Account> findAll();

    /**
     * 通过用户id查找对应的账户
     *
     * @param uid
     * @return
     */
    abstract public List<Account> findByUid(Integer uid);

}
