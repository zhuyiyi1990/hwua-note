package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.dao.IUserDao;
import com.github.zhuyiyi1990.pojo.User;
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

public class UserTest {
    private InputStream in;

    private SqlSessionFactory factory;

    private SqlSession sqlSession;

    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
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
    public void testFindAll() throws IOException {
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(3);
        System.out.println(user);
    }
}
