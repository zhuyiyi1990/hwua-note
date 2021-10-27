package com.github.zhuyiyi1990.hwuanote;

import com.github.zhuyiyi1990.hwuanote.mapper.AccountRowMapper;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
//        testSave();
//        testUpdate();
//        testDelete();
//        testAccountRowMapper();
//        testBeanPropertyRowMapper();
//        testQueryForOne();
        testQueryForObject();
    }

    private static void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.update("insert into account2 (name, money) values (?, ?)", "ddd", 200);
    }

    private static void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.update("update account2 set name = ?, money = ? where id = ?", "ttt", 3456, 208);
    }

    private static void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.update("delete from account2 where id = ?", 208);
    }

    private static void testAccountRowMapper() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        List<Account> list = jt.query("select * from account2 where money > ?", new AccountRowMapper(), 900);
        for (Account account : list) {
            System.out.println(account);
        }
    }

    private static void testBeanPropertyRowMapper() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        List<Account> list = jt.query("select * from account2 where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 900);
        for (Account account : list) {
            System.out.println(account);
        }
    }

    private static void testQueryForOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        List<Account> list = jt.query("select * from account2 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(list.isEmpty() ? "没有内容" : list.get(0));
    }

    private static void testQueryForObject() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        Long count = jt.queryForObject("select count(id) from account2 where money > ?", Long.class, 900);
        System.out.println(count);
    }

}
