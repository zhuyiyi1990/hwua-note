package com.github.zhuyiyi1990.hwuanote.service.impl;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
    @Resource
    private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("service创建了");
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }

    @Override
    public int save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行");
    }

}
