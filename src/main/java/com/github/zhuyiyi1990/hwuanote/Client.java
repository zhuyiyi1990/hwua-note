package com.github.zhuyiyi1990.hwuanote;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        System.out.println(accountDao);
        System.out.println("----------");
        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService12", IAccountService.class);
        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService13", IAccountService.class);
        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService14", IAccountService.class);
        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("counterpoise", IAccountService.class);
        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println("----------");
        accountService = ac.getBean("accountService3", IAccountService.class);
        System.out.println(accountService);
        accountService.saveAccount();
        ac.close();
    }

}
