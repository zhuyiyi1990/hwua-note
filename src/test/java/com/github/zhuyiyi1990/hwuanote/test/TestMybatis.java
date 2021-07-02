package com.github.zhuyiyi1990.hwuanote.test;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
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
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
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
