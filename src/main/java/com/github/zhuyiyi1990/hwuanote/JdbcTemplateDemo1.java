package com.github.zhuyiyi1990.hwuanote;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.1.4.16:3306/zhuyiyi");
        ds.setUsername("root");
        ds.setPassword("PW99-mys");
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.update("insert into account2 (name, money) values ('ccc', 1000)");
    }

}
