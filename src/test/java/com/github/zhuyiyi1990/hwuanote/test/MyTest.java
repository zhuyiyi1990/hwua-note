package com.github.zhuyiyi1990.hwuanote.test;

import com.github.zhuyiyi1990.hwuanote.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        System.out.println(accountService);
        ac.close();
    }

}
