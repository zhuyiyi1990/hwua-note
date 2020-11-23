package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.config.JdbcConfig;
import com.github.zhuyiyi1990.config.SpringConfiguration;
import com.github.zhuyiyi1990.config.TransactionManagerConfig;
import com.github.zhuyiyi1990.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:bean.xml"})
@ContextConfiguration(classes = {SpringConfiguration.class})
public class MyTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void test() {
        accountService.transfer("aaa", "bbb", 100);
    }
}
