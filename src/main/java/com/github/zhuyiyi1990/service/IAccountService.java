package com.github.zhuyiyi1990.service;

import com.github.zhuyiyi1990.pojo.Account;

public interface IAccountService {

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    public abstract Account findAccountById(int id);

    public abstract void transfer(String sourceName, String targetName, float money);

}
