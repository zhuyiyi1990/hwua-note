package com.github.zhuyiyi1990.hwuanote;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findAccountById(2);
        System.out.println(account);
        account.setMoney(10000);
        accountDao.update(account);
    }

}
