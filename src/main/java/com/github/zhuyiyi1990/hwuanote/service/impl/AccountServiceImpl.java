package com.github.zhuyiyi1990.hwuanote.service.impl;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    //此时关注度不要在他是否应该在这里,主要体现这几种类型数据
    //如果是经常变化的数据,并不适用于注入的方式
    private String name;

    private Integer age;

    private Date birthday;

    public AccountServiceImpl() {
        System.out.println("对象创建");
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        System.out.println("对象创建");
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("AccountServiceImpl中的saveAccount执行了");
//        accountDao.saveAccount();
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }

}
