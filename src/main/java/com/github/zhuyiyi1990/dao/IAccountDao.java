package com.github.zhuyiyi1990.dao;

import com.github.zhuyiyi1990.pojo.Account;

public interface IAccountDao {
    /**
     * 通过id查找账户
     *
     * @param id
     * @return
     */
    public abstract Account findAccountById(int id);

    /**
     * 通过name查找账户
     *
     * @param name
     * @return
     */
    public abstract Account findAccountByName(String name);

    /**
     * 更新账户
     *
     * @param account
     * @Return
     */
    public abstract int update(Account account);
}
