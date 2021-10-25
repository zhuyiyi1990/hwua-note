package com.github.zhuyiyi1990.hwuanote.service.impl;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import com.github.zhuyiyi1990.hwuanote.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
    private IAccountDao accountDao;

    private TransactionManager txManager;

    public AccountServiceImpl() {
        System.out.println("service创建了");
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Autowired
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行");
    }

    @Override
    public List<Account> findAll() {
        try {
            txManager.beginTransaction();
            List<Account> accounts = accountDao.findAll();
            txManager.commit();
            return accounts;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }

    @Override
    public Account findById(int id) {
        try {
            txManager.beginTransaction();
            Account account = accountDao.findById(id);
            txManager.commit();
            return account;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }

    @Override
    public int save(Account account) {
        try {
            txManager.beginTransaction();
            int row = accountDao.save(account);
            txManager.commit();
            return row;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }

    @Override
    public int update(Account account) {
        try {
            txManager.beginTransaction();
            int row = accountDao.update(account);
            txManager.commit();
            return row;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }

    @Override
    public int delete(int id) {
        try {
            txManager.beginTransaction();
            int row = accountDao.delete(id);
            txManager.commit();
            return row;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            txManager.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.update(source);
//            int i = 1 / 0;
            accountDao.update(target);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }

}
