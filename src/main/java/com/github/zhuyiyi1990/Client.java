package com.github.zhuyiyi1990;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        IAccountService accountService2 = ac.getBean("counterpoise", IAccountService.class);
        IAccountService accountService3 = ac.getBean("accountService3", IAccountService.class);
        accountService.saveAccount();
        accountService2.saveAccount();
        accountService3.saveAccount();
        ac.close();
    }

}
