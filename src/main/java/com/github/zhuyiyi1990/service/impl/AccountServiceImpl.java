package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.factory.BeanFactory;
import com.github.zhuyiyi1990.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private String name;

    private Integer age;

    private Date birthday;

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public AccountServiceImpl() {
        System.out.println("对象创建");
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }

}
