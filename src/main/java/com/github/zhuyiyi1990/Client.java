package com.github.zhuyiyi1990;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        System.out.println(accountDao);
        System.out.println(accountService);
        ac.close();
    }

}
