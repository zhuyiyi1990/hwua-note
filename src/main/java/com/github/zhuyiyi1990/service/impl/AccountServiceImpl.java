package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.pojo.Account;
import com.github.zhuyiyi1990.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        Account targetAccount = accountDao.findAccountByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.update(sourceAccount);
        accountDao.update(targetAccount);
    }
}
