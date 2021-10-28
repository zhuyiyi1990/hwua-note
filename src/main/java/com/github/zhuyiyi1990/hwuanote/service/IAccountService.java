package com.github.zhuyiyi1990.hwuanote.service;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

public interface IAccountService {

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    Account findAccountById(int id);

    void transfer(String sourceName, String targetName, float money);

}
