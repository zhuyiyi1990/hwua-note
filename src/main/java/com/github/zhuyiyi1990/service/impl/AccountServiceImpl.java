package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.pojo.Account;
import com.github.zhuyiyi1990.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        update(source);
//        int i = 1 / 0;
        update(target);
    }
}
