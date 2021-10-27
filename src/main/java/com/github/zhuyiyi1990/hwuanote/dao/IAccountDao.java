package com.github.zhuyiyi1990.hwuanote.dao;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

public interface IAccountDao {

    /**
     * 通过id查找账户
     *
     * @param id
     * @return
     */
    Account findAccountById(int id);

    /**
     * 通过name查找账户
     *
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     *
     * @param account
     * @Return
     */
    int update(Account account);

}
