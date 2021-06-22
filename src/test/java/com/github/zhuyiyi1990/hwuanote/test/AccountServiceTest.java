package com.github.zhuyiyi1990.hwuanote.test;

import com.github.zhuyiyi1990.hwuanote.config.SpringConfiguration;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

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
        account.setId(158);
        account.setName("xiaoming");
        account.setMoney(2000);
        accountService.update(account);
    }

    @Test
    public void testDelete() {
        accountService.delete(158);
    }

}
