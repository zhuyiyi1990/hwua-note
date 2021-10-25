package com.github.zhuyiyi1990.hwuanote.dao;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findById(int id);

    int save(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountByName(String accountName);

}
