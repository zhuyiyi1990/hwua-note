package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.dao.IAccountDao;
import com.github.zhuyiyi1990.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSaveAccount() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);
        IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
        Account account = new Account();
        account.setName("test");
        account.setMoney(200F);
        accountDao.saveAccount(account);
        sqlSession.close();
        in.close();
    }
}
