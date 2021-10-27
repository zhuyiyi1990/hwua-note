package com.github.zhuyiyi1990.hwuanote.dao.impl;

import com.github.zhuyiyi1990.hwuanote.dao.IAccountDao;
import com.github.zhuyiyi1990.hwuanote.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> accounts = jdbcTemplate.query("select * from account2 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account2 where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account2 set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

}
