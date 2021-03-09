package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.pojo.Account;
import com.github.zhuyiyi1990.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
    private IAccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        Account targetAccount = accountDao.findAccountByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.update(sourceAccount);
//        int i = 1 / 0;
        accountDao.update(targetAccount);
    }

}
