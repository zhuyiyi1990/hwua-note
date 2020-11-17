package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;

    private SqlSessionFactory factory;

    private SqlSession sqlSession;

    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void close() throws IOException {
        if (sqlSession != null) {
            sqlSession.close();
        }
        if (in != null) {
            in.close();
        }
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println("每个账户信息:");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
