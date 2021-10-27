package com.github.zhuyiyi1990.hwuanote;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo5 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao2", IAccountDao.class);
        Account account = accountDao.findAccountById(2);
        System.out.println(account);
        account.setMoney(9000);
        accountDao.update(account);
    }

}
