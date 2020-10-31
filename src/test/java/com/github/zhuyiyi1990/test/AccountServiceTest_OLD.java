package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.pojo.Account;
import com.github.zhuyiyi1990.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest_OLD {
    private ApplicationContext ac;

    private IAccountService accountService;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean.xml");
        accountService = ac.getBean("accountService", IAccountService.class);
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("小明");
        account.setMoney(200);
        accountService.save(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(19);
        account.setName("xiaoming");
        account.setMoney(2000);
        accountService.update(account);
    }

    @Test
    public void testDelete() {
        accountService.delete(19);
    }
}
