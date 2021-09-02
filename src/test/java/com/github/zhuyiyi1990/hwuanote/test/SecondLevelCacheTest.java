package com.github.zhuyiyi1990.hwuanote.test;

import com.github.zhuyiyi1990.hwuanote.dao.IUserDao;
import com.github.zhuyiyi1990.hwuanote.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SecondLevelCacheTest {

    private InputStream in;

    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void close() throws IOException {
        if (in != null) {
            in.close();
        }
    }

    @Test
    public void testSecondLevelCache() {
        SqlSession sqlSession1 = factory.openSession(true);
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(1);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession(true);
        IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(1);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }

}
