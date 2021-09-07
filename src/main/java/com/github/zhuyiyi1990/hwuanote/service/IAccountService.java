package com.github.zhuyiyi1990.hwuanote.service;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

import java.util.List;

public interface IAccountService {

    abstract public List<Account> findAll();

    abstract public Account findById(int id);

    abstract public int save(Account account);

    abstract public int update(Account account);

    abstract public int delete(int id);

}
