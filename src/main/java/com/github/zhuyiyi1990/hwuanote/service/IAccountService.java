package com.github.zhuyiyi1990.hwuanote.service;

import com.github.zhuyiyi1990.hwuanote.pojo.Account;

import java.util.List;

public interface IAccountService {

    public abstract List<Account> findAll();

    public abstract Account findById(int id);

    public abstract int save(Account account);

    public abstract int update(Account account);

    public abstract int delete(int id);

}
