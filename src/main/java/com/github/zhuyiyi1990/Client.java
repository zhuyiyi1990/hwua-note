package com.github.zhuyiyi1990;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
        System.out.println("----------");
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService12", IAccountService.class);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService13", IAccountService.class);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("counterpoise", IAccountService.class);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService3", IAccountService.class);
        accountService.saveAccount();
    }
}
