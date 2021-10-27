package com.github.zhuyiyi1990.hwuanote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.update("insert into account2 (name, money) values ('ccc', 1000)");
    }

}
