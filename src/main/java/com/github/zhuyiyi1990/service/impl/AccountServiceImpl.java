package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.dao.impl.AccountDaoImpl;
import com.github.zhuyiyi1990.factory.BeanFactory;
import com.github.zhuyiyi1990.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    //此时关注度不要在他是否应该在这里,主要体现这几种类型数据
    //如果是经常变化的数据,并不适用于注入的方式
    private String name;

    private Integer age;

    private Date birthday;

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
