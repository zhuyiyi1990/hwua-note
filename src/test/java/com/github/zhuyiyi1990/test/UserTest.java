package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.dao.IUserDao;
import com.github.zhuyiyi1990.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        if (in != null) {
            in.close();
        }
    }
}
