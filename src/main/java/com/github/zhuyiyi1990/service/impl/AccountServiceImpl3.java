package com.github.zhuyiyi1990.service.impl;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.service.IAccountService;

import java.util.*;

public class AccountServiceImpl3 implements IAccountService {
    private IAccountDao accountDao;

    private String[] myStrs;

    private List<String> myList;

    private Set<String> mySet;

    private Map<String, String> myMap;

    private Properties myProps;

    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
        accountDao.saveAccount();
    }
}
