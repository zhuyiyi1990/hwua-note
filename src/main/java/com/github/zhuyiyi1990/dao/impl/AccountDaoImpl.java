package com.github.zhuyiyi1990.dao.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存用户成功");//简单模拟即可
    }
}
