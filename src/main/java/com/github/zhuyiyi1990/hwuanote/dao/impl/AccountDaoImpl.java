package com.github.zhuyiyi1990.hwuanote.dao.impl;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存用户成功");//简单模拟即可
    }

}
