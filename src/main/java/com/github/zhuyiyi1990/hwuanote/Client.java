package com.github.zhuyiyi1990.hwuanote;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(accountDao);
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        System.out.println(accountService);
        accountService = ac.getBean("accountService12", IAccountService.class);
        System.out.println(accountService);
        accountService = ac.getBean("accountService13", IAccountService.class);
        System.out.println(accountService);
        accountService = ac.getBean("accountService2", IAccountService.class);
        System.out.println(accountService);
        accountService = ac.getBean("counterpoise", IAccountService.class);
        System.out.println(accountService);
        accountService = ac.getBean("accountService3", IAccountService.class);
        System.out.println(accountService);
    }

}
