package com.github.zhuyiyi1990.test;

import com.github.zhuyiyi1990.dao.IRoleDao;
import com.github.zhuyiyi1990.pojo.Role;
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

public class RoleTest {
    private InputStream in;

    private SqlSessionFactory factory;

    private SqlSession sqlSession;

    private IRoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        roleDao = sqlSession.getMapper(IRoleDao.class);
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
        List<Role> list = roleDao.findAll();
        for (Role role : list) {
            System.out.println("每个角色信息:");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
