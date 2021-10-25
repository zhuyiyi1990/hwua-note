package com.github.zhuyiyi1990.hwuanote.service;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account findById(int id);

    int save(Account account);

    int update(Account account);

    int delete(int id);

    void transfer(String sourceName, String targetName, Float money);

}
