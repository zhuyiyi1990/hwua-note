package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {
    private IAccountDao accountDao;

    private String name;

    private Integer age;

    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("AccountServiceImpl2中的saveAccount执行了");
        accountDao.saveAccount();
    }
}
