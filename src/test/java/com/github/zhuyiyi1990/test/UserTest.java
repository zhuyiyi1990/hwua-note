package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.dao.IUserDao;
import com.github.zhuyiyi1990.pojo.QueryVo;
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
import java.util.Date;
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

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("bb");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("重庆");
        int rows = userDao.saveUser(user);
        System.out.println(rows);
        System.out.println(user.getId());//保存到id属性中了
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(21);
        user.setUsername("cc");
        user.setAddress("深圳");
        int rows = userDao.updateUser(user);
        System.out.println(rows);
    }

    @Test
    public void testDelete() {
        int rows = userDao.deleteUser(21);
        System.out.println(rows);
    }

    @Test
    public void testFindByName() {
        List<User> list = userDao.findByName("%小%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindByQueryVo() {
        QueryVo vo = new QueryVo();
        User user1 = new User();
        user1.setUsername("%小%");
        vo.setUser(user1);
        List<User> list = userDao.findByQueryVo(vo);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
