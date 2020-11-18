package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    private String name;

    private Integer age;

    private Date birthday;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("AccountServiceImpl中的saveAccount执行了");
        accountDao.saveAccount();
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
