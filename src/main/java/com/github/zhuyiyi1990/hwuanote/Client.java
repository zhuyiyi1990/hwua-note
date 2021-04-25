package com.github.zhuyiyi1990.hwuanote;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        IAccountService accountService12 = ac.getBean("accountService12", IAccountService.class);
        IAccountService accountService13 = ac.getBean("accountService13", IAccountService.class);
        IAccountService counterpoise = ac.getBean("counterpoise", IAccountService.class);
        IAccountService accountService3 = ac.getBean("accountService3", IAccountService.class);
        System.out.println(accountDao);
        accountService.saveAccount();
        accountService12.saveAccount();
        accountService13.saveAccount();
        counterpoise.saveAccount();
        accountService3.saveAccount();
    }

}
